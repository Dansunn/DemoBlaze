package com.belajartestng;

import org.testng.Assert;
import org.testng.annotations.*;

public class Demo2Test {
    String driver;
    String url;

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Demo2Test:: before suite method");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("Demo2Test:: after suite method");
    }

    @BeforeClass
    public void beforeClass() {
        driver = "Ini driver";
        String id = "123";
        url = "http://localhost:8000/admin/" + id;
        System.out.println("Demo2Test:: BeforeClass Method");

    }

    @AfterClass
    public void afterClass() {
        System.out.println("Demo2Test:: AfterClass Method");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Demo2Test:: before Method " + driver);
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("Demo2Test:: after Method " + driver);
    }
    @Test
    public void addTest() {

        System.out.println("Demo2Test:: addTest Method");
        int actualResult = Calculator.add(10, 20);
        int expectedResult = 3000;

        Assert.assertEquals(actualResult, expectedResult, "Gagal test add");
    }

    @Test
    public void subTest() {

        System.out.println("Demo2Test:: subTest Method");
        int actualResult = Calculator.subtract(10, 20);
        int expectedResult = -10;

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void test03() {
        System.out.println("Demo2Test:: test03 Method");
        Assert.assertTrue(7 > 8, "Gagal di test 03");
    }

    @Test
    public void test04() {
        System.out.println("Demo2Test:: test04 Method");
        String[] choice = {"Pendidikan"};
        String[] actual = {"Pendidikan"};
        Assert.assertEqualsNoOrder(choice, actual, "Gagal di test 04");
    }
}
