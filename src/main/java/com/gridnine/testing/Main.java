package com.gridnine.testing;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        CheckModule checkModule = new CheckModule();
        Recorder.record(FlightBuilder.createFlights(), "Тестовый набор перелетов: ");
        List<Flight> resultTask1 = checkModule.departureToTheCurrentTime(FlightBuilder.createFlights());
        Recorder.record(resultTask1);
        List<Flight> resultTask2 = checkModule.arrivalDateBeforeDepartureDate(FlightBuilder.createFlights());
        Recorder.record(resultTask2);
        List<Flight> resultTask3 = checkModule.timeOnEarthExceedsTwoHours(FlightBuilder.createFlights());
        Recorder.record(resultTask3);
    }
}
