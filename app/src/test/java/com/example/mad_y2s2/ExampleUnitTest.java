package com.example.mad_y2s2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    private activity_statistics statistics;
    private activity_calorieStatus calStatus;


    @Before
    public void setUp() throws Exception {
        statistics = new activity_statistics();
    }

    //BMI test Cases
    @Test
    public void checkBMI() {
        float result = statistics.calculateBMI("70","150");
        assertEquals(31.11111,result,0.001);
    }
    @Test
    public void checkBMI2() {
        float result = statistics.calculateBMI("60","190");
        assertEquals(16.620499,result,0.001);
    }

    //BMI status test cases
    @Test
    public void checkStatus001() {
        String result = calStatus.checkStatus(16.6);
        assertEquals("You are on under weight! 🙁🙁",result,0.001);
    }
}