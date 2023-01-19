/**
 * Marco Martinez
 * CustomerTest.java
 */
package com.company;

import org.junit.Assert;
import org.junit.Test;

public class CustomerTest
{
    /**
     * Tests the Customer.getBalance() method's functionality.
     * It creates two Customers, initializes their accounts with
     * charges, and then compares the result of the method, with
     * what is the expected output of the method.
     */
    @Test
    public void shouldCalculateBalance()
    {
        // initialize customer1
        Customer customer1 = new Customer();
        customer1.addCharge("-430", "03-17-2022");
        customer1.addCharge("-2400", "03-17-2022");
        customer1.addCharge("82", "03-17-2022");
        customer1.addCharge("78000", "03-17-2022");
        customer1.addCharge("-67", "03-17-2022");
        customer1.addCharge("943", "03-17-2022");

        // initialize customer2
        Customer customer2 = new Customer();
        customer2.addCharge("6700", "01-17-2023");
        customer2.addCharge("-9700", "01-17-2023");
        customer2.addCharge("-10600", "01-17-2023");
        customer2.addCharge("457", "01-17-2023");
        customer2.addCharge("78900", "01-17-2023");
        customer2.addCharge("-70000", "01-17-2023");

        Assert.assertEquals(customer1.getBalance(), 76128);
        Assert.assertEquals(customer2.getBalance(), -4243);

    }

    /**
     * Tests the toString() functionality of the Customer class.
     * It creates a new customer, and compares the result of the
     * Customer.toString method with what is expected to be output.
     */
    @Test
    public void shouldEqualString()
    {
        // create test customer
        Customer customer = new Customer();
        customer.setId(1);
        customer.setName("Facebook");
        customer.addCharge("6700", "01-17-2023");
        customer.addCharge("-9700", "01-17-2023");

        String expected = "\nCustomer: Facebook\nId: 1\nCustomer balance: -3000\n";

        Assert.assertEquals(expected, customer.toString());
    }

}