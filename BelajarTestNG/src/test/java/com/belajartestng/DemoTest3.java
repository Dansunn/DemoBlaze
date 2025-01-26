package com.belajartestng;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DemoTest3 {
    @BeforeClass()
    public void register() {
        System.out.println("Register");
    }

    @BeforeClass(enabled = true, dependsOnMethods = { "b2MethodTest" })
    public void login() {
        System.out.println("Login Test");
    }

    @Test
    public void bMethod() {
        System.out.println("Uhuy sebelum");
    }

    @BeforeMethod()
    public void b2MethodTest() {
        System.out.println("b2MethodTest");
    }

    @BeforeMethod(dependsOnMethods = { "b2MethodTest" })
    public void bMethodTest() {
        System.out.println("Uhuy");
    }

    @Test
    public void addProductTest() {
        System.out.println("Add Product Test");
    }

    @Test(priority = -1, enabled = false)
    public void listTestProduct() {
        System.out.println("List Product Test");
    }

    @Test
    public void loginTest() {

    }

}
