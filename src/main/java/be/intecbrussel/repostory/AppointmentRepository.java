package be.intecbrussel.repostory;

import be.intecbrussel.config.RepoConfig;
import be.intecbrussel.exceptions.AppointmentException;
import be.intecbrussel.exceptions.AppointmentNotFoundException;
import be.intecbrussel.model.Appointment;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class AppointmentRepository {

    public void createAppointment(Appointment appointment) {
        try (EntityManager em = RepoConfig.getEM()) {
            em.getTransaction().begin();
            em.persist(appointment);
            em.getTransaction().commit();

        } catch (PersistenceException pex) {
            throw new AppointmentException("Error creating appointment"+ pex);

        }

    }

    public Appointment getAppointmentById(String id) {
        try (EntityManager em = RepoConfig.getEM()) {
        Appointment appointment = em.find(Appointment.class, id);
        if (appointment == null) {
            throw new AppointmentNotFoundException("Appointment with id " + id + " not found!");
        }
        return appointment;
    } catch (AppointmentNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Appointment> getAllAppointments() throws AppointmentNotFoundException {
        try (EntityManager em = RepoConfig.getEM()) {
            TypedQuery<Appointment> query = em.createQuery("SELECT a FROM Appointment a", Appointment.class);
            return query.getResultList();
        } catch (NoResultException e) {
            throw new AppointmentNotFoundException("No appointments found!");
        }
    }

    public void updateAppointment(Appointment appointment) {
        try (EntityManager em = RepoConfig.getEM()) {
            em.getTransaction().begin();
            em.merge(appointment);
            em.getTransaction().commit();
        }
    }
    public void deleteAppointment(Long id) {
        try (EntityManager em = RepoConfig.getEM()){
            em.getTransaction().begin();
            Appointment dbAppointment = em.find(Appointment.class, id);
            em.remove(dbAppointment);
            em.getTransaction().commit();
        }
    }




}
