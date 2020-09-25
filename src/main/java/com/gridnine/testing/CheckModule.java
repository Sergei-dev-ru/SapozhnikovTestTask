package com.gridnine.testing;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CheckModule extends CheckAbstract {

    private LocalDateTime presentTime;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;

    public ArrayList<Flight> departureToTheCurrentTime(List<Flight> flight){
        presentTime = LocalDateTime.now();
        ArrayList<Flight> flight2 = new ArrayList<>();
        flight2.addAll(flight);

        for(int i = 0; i < flight2.size(); i++){
            String str = String.valueOf(flight.get(i)).substring(1,17);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
            departureTime = LocalDateTime.parse(str, formatter);
            if (departureTime.isBefore(presentTime)){
                flight2.remove(i);
            }
        }
        System.out.println("Убраны перелеты с вылетом до текущего момента времени:");
        return flight2;
    }

    public ArrayList<Flight> arrivalDateBeforeDepartureDate(List<Flight> flight){
        ArrayList<Flight> flight2 = new ArrayList<>();
        flight2.addAll(flight);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        String insideStr = "";
        boolean b = false;
        for(int i = 0; i < flight2.size(); i++){
            String str = String.valueOf(flight.get(i));
            str = str.replaceAll(" ", "");
            for (int j = 0; j < str.length(); j++){
                if(b==true){
                    j = 0;
                }
                insideStr = str.substring(j, str.indexOf("]") + 1);
                insideStr = insideStr.substring(1,17);
                departureTime = LocalDateTime.parse(insideStr, formatter);
                insideStr = str.substring(18,34);
                arrivalTime = LocalDateTime.parse(insideStr, formatter);
                insideStr = str.substring(j, str.indexOf("]") + 1);
                if(arrivalTime.isBefore(departureTime)){
                    flight2.remove(i);
                }
                if(insideStr.length() < str.length()){
                    str = str.substring(insideStr.length());
                    b = true;
                }
                else {
                    j = str.length();
                }
            }
        }
        System.out.println("Убраны перелеты, где есть сегмент с датой прилета раньше даты вылета:");
        return flight2;
    }

    public ArrayList<Flight> timeOnEarthExceedsTwoHours(List<Flight> flight){
        ArrayList<Flight> flight2 = new ArrayList<>();
        flight2.addAll(flight);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        String insideStr = "";
        boolean b = false;
        for(int i = 0; i < flight2.size(); i++){
            ArrayList<LocalDateTime> list = new ArrayList<>();
            String str = String.valueOf(flight.get(i));
            str = str.replaceAll(" ", "");
            for (int j = 0; j < str.length(); j++){
                if(b==true){
                    j = 0;
                }
                insideStr = str.substring(j, str.indexOf("]") + 1);
                insideStr = insideStr.substring(1,17);
                departureTime = LocalDateTime.parse(insideStr, formatter);
                insideStr = str.substring(18,34);
                arrivalTime = LocalDateTime.parse(insideStr, formatter);
                insideStr = str.substring(j, str.indexOf("]") + 1);
                if(insideStr.length() < str.length()){
                    str = str.substring(insideStr.length());
                    b = true;
                    list.add(departureTime);
                    list.add(arrivalTime);
                }
                else {
                    j = str.length();
                    list.add(departureTime);
                    list.add(arrivalTime);
                    if(list.size() > 2) {
                        departureTime = null;
                        arrivalTime = null;
                        for (int k = 1; k < list.size() - 1; k++) {
                            if(k%2!=0){
                                departureTime = list.get(k);
                            }
                            else{
                                arrivalTime = list.get(k);
                            }
                            if(k%2==0){
                                int dep = Integer.parseInt(String.valueOf(departureTime).substring(11,13));
                                int arr = Integer.parseInt(String.valueOf(arrivalTime).substring(11,13));
                                if(arr - dep > 2){
                                    flight2.remove(i);
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println("Убраны перелеты, где время проведенное на земле превышает два часа:");
        return flight2;
    }
}
