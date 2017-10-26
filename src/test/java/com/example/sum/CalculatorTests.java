package com.example.sum;

import org.junit.Test;
import org.junit.Assert;

public class CalculatorTests {

    private Calculator calculator = new Calculator();

    @Test
    public void test1(){
        Assert.assertEquals(5, calculator.sum(2, 3));
    }

    @Test
    public void test2(){
        Assert.assertNotEquals(2, calculator.sum(2,2));
    }
}