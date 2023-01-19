/**
 * Marco Martinez
 * Customer.java
 */
package com.company;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    // state
    private int id;
    private String name;
    private List<AccountRecord> charges = new ArrayList<>();

    Customer() {};
    // Constructor
    Customer(String id, String name, String charge, String chargeDate)
    {
        setId(Integer.parseInt(id));
        setName(name);
        addCharge(charge, chargeDate);
    }

    // setters and getters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sums up the charges made to the Customer's
     * account, and returns their balance.
     * @return returns the Customer's balance
     */
    public int getBalance() {

        int balance = 0;

        for (AccountRecord charge : charges)
        {
            balance += charge.getCharge();
        }

        return balance;
    }

    public List<AccountRecord> getCharges() {
        return charges;
    }

    // behaviors

    /**
     * Adds new a new charge this customer's "charges"
     * @param charge numerical amount in String form
     * @param chargeDate the date of the charge
     */
    public void addCharge(String charge, String chargeDate)
    {
        AccountRecord newCharge = new AccountRecord();

        newCharge.setCharge(Integer.parseInt(charge));
        newCharge.setChargeDate(chargeDate);

        charges.add(newCharge);
    }

    /**
     * @return a String representation of the Customer object.
     */
    @Override
    public String toString() {

        String output = "\n";

        output += "Customer: " + getName() + "\n";
        output += "Id: " + getId() + "\n";
        output += "Customer balance: " + getBalance() + "\n";

        return output;
    }
}
