package com.belajartestng;

import org.testng.Assert;
import org.testng.annotations.*;

public class CalculatorTestDemo {
    @BeforeTest
    public void beforeTest() {
        System.out.println("BeforeTest Method");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("AfterTest Method");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("BeforeClass Method");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("AfterClass Method");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Before Method");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("after Method");
    }
    @Test
    public void addTest() {
        System.out.println("addTest Method");
        int actualResult = Calculator.add(10, 20);
        int expectedResult = 3000;

        Assert.assertEquals(actualResult, expectedResult, "Gagal test add");
    }

    @Test
    public void subTest() {
        System.out.println("subTest Method");
        int actualResult = Calculator.subtract(10, 20);
        int expectedResult = -10;

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void test03() {
        System.out.println("test03 Method");
        Assert.assertTrue(7 > 8, "Gagal di test 03");
    }

    @Test
    public void test04() {
        System.out.println("test04 Method");
        String[] choice = {"Pendidikan"};
        String[] actual = {"Pendidikan"};
        Assert.assertEqualsNoOrder(choice, actual, "Gagal di test 04");
    }
}
