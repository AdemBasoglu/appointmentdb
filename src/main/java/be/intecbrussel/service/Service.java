package be.intecbrussel.service;

public class Service {

    private static AppointmentService appointmentService;

    static {
      appointmentService = new AppointmentService();


    }

    public static AppointmentService getAppointmentService() {
        return appointmentService;
    }}