package be.intecbrussel;

import be.intecbrussel.exceptions.AppointmentNotFoundException;
import be.intecbrussel.model.Appointment;
import be.intecbrussel.service.AppointmentService;


public class App {

    public static void main(String[] args) throws AppointmentNotFoundException {

        AppointmentService appointmentService = new AppointmentService();
        Appointment appointment1 = new Appointment("dentist", "teeth ", 12, 10, 2023, 00, 12);
        Appointment appointment2 = new Appointment("psychiater", "crazy", 12, 10, 2023, 30, 12);
        Appointment appointment3 = new Appointment("internal diseases", "heart", 12, 10, 2023, 00, 13);
        Appointment appointment4 = new Appointment("kinderarts", "sleep", 12, 10, 2023, 30, 13);


        appointmentService.addAppointment(appointment1);
        appointmentService.addAppointment(appointment2);
        appointmentService.addAppointment(appointment3);
        appointmentService.addAppointment(appointment4);


       // appointmentService.deleteAppointment(1L);
        appointment1.setTitle("updadate test");
        appointmentService.updateAppointment(appointment1);





    }
}
