package com.example.mad_y2s2;
import java.util.*;
import java.lang.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;



public class GetDate {

    public static ArrayList<String> dates = new ArrayList<>();

    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy ");
        Calendar cal = Calendar.getInstance();
        // get starting date
        cal.add(Calendar.DAY_OF_YEAR, -7);

        // loop adding one day in each iteration
        for(int i = 0; i< 7; i++){
            cal.add(Calendar.DAY_OF_YEAR, 1);
            System.out.println(sdf.format(cal.getTime()));
            dates.add(sdf.format(cal.getTime()));
        }
    }
}
