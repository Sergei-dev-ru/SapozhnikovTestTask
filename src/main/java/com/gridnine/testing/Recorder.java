package com.gridnine.testing;

import java.util.List;

public class Recorder {

    public static void record(List<Flight> flights){
        for(int i = 0; i < flights.size(); i++) {
            System.out.println(flights.get(i));
        }
        System.out.println();
    }

    public static void record(List<Flight> flights, String str){
        System.out.println(str);
        for(int i = 0; i < flights.size(); i++) {
            System.out.println(flights.get(i));
        }
        System.out.println();
    }

}
