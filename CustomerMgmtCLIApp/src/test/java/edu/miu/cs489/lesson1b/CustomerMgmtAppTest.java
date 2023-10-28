package edu.miu.cs489.lesson1b;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CustomerMgmtAppTest {

    private  CustomerMgmtApp customerMgmtApp;

    @Before
    public void setUp() throws Exception {
        this.customerMgmtApp = new CustomerMgmtApp();
    }

    @Test
    public void test_should_sayHello() {
        String expected = "Hello";
        String actual = customerMgmtApp.sayHello();
        assertEquals("Test Fail",expected,actual);
    }
}