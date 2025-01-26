package com.belajartestng;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ATMtest {
    private ATM atm;

    @BeforeMethod
    public void setSaldoAwal(){
        atm = new ATM(1000);
    }

    @Test
    public void testCekSaldo(){
        double expectedResult = 1000;
        double actualResult = atm.cekSaldo();
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void testSetorUang(){
        atm.setorUang(5000);
        double expectedResult = 6000;
        double actualResult = atm.cekSaldo();
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void testSetorUangNegatif(){
        atm.setorUang(-1000);
        double expectedResult = 1000;
        double actualResult = atm.cekSaldo();
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void testTarikUang(){
        atm.tarikUang(500);
        double expectedResult = 500;
        double actualResult = atm.cekSaldo();
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void testTarikUangLebihDariSaldo(){
        atm.tarikUang(2500);
        double expectedResult = 1000;
        double actualResult = atm.cekSaldo();
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void testTarikUangNegatif(){
        atm.tarikUang(-750);
        double expectedResult = 1000;
        double actualResult = atm.cekSaldo();
        Assert.assertEquals(actualResult, expectedResult);
    }
}
