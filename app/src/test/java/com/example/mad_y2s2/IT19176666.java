package com.example.mad_y2s2;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
public class IT19176666 {
    private activity_total_food_calories_count activity_total_food_calories_count;

    @Before
    public void setup()
    {
        activity_total_food_calories_count = new activity_total_food_calories_count();
    }


    @Test
    public void testTotalCal()
    {

        assertEquals( 10, 5+5);

    }
}
