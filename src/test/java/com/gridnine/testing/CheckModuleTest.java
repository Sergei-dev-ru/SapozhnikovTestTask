package com.gridnine.testing;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class CheckModuleTest {

    CheckModule checkModule;

    @Before
    public void setUp() throws Exception {
        System.out.println("Перед тестированием метода класса " + CheckModule.class.getName() + '\n');
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("После тестирования метода класса " + CheckModule.class.getName() + '\n');
    }

    @Test
    public void departureToTheCurrentTime() {
        checkModule = new CheckModule();
        List<Flight> resultTask1 = checkModule.departureToTheCurrentTime(FlightBuilder.createFlights());
        assertTrue(!resultTask1.isEmpty());
        System.out.println("Лист resultTask1 заполнен!");
    }

    @Test
    public void arrivalDateBeforeDepartureDate() {
        checkModule = new CheckModule();
        List<Flight> resultTask2 = checkModule.arrivalDateBeforeDepartureDate(FlightBuilder.createFlights());
        assertTrue(!resultTask2.isEmpty());
        System.out.println("Лист resultTask2 заполнен!");
    }

    @Test
    public void timeOnEarthExceedsTwoHours() {
        checkModule = new CheckModule();
        List<Flight> resultTask3 = checkModule.timeOnEarthExceedsTwoHours(FlightBuilder.createFlights());
        assertTrue(!resultTask3.isEmpty());
        System.out.println("Лист resultTask3 заполнен!");
    }
}