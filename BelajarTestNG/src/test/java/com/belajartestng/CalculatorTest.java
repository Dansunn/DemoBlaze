package com.belajartestng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorTest {

    @Test
    public void addTest(){
        int actualResult = Calculator.add(10, 20);
        int expectedResult = 30;

        Assert.assertEquals(actualResult, expectedResult);
    }
    @Test
    public void subtractTest(){
        int actualResult = Calculator.subtract(30, 20);
        int expectedResult = 10;
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void multiTest(){
        int actualResult = Calculator.multiplication(10, 20);
        int expectedResult = 200;
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void divTest(){
        int actualResult = Calculator.division(500, 10);
        int expectedResult = 50;
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void modTest(){
        int actualResult = Calculator.mod(25, 3);
        int expectedResult = 1;
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void hitungBMITest(){
        double actualResult = Calculator.hitungBMI(84, 1.76);
        double expectedResult = 27.117768595;
        double delta = 0.00001;
        Assert.assertEquals(actualResult, expectedResult, delta);
    }
}
