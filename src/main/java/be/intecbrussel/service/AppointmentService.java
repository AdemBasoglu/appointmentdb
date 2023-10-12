package be.intecbrussel.service;

import be.intecbrussel.exceptions.AppointmentNotFoundException;
import be.intecbrussel.model.Appointment;
import be.intecbrussel.repostory.AppointmentRepository;

import java.util.List;

public class AppointmentService {

        private final AppointmentRepository appointmentRepository=new AppointmentRepository();


    public Appointment getAppointmentById(String id) {
            return appointmentRepository.getAppointmentById(id);
        }

        public List<Appointment> getAllAppointments() throws AppointmentNotFoundException {
            return appointmentRepository.getAllAppointments();
        }

        public void addAppointment(Appointment appointment) {
            appointmentRepository.createAppointment(appointment);
        }

        public void updateAppointment(Appointment appointment) {
            appointmentRepository.updateAppointment(appointment);
        }

        public void deleteAppointment(Long id) {
            appointmentRepository.deleteAppointment(id);
        }
    }


