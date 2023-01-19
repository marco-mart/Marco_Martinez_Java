/**
 * Marco Martinez
 * Main.java
 * 01/16/23
 *
 * Main class of Module 1 Challenge of the Netflix Pathways Advanced Java Bootcamp
 */

package com.company;

import java.util.*;

public class Main
{

    private static List<String[]> customerData = Arrays.asList(
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"},
            new String[] {"2","Daily Planet","-7500","01-10-2022"},
            new String[] {"1","Wayne Enterprises","18000","12-22-2021"},
            new String[] {"3","Ace Chemical","-48000","01-10-2022"},
            new String[] {"3","Ace Chemical","-95000","12-15-2021"},
            new String[] {"1","Wayne Enterprises","175000","01-01-2022"},
            new String[] {"1","Wayne Enterprises","-35000","12-09-2021"},
            new String[] {"1","Wayne Enterprises","-64000","01-17-2022"},
            new String[] {"3","Ace Chemical","70000","12-29-2022"},
            new String[] {"2","Daily Planet","56000","12-13-2022"},
            new String[] {"2","Daily Planet","-33000","01-07-2022"},
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"},
            new String[] {"2","Daily Planet","33000","01-17-2022"},
            new String[] {"3","Ace Chemical","140000","01-25-2022"},
            new String[] {"2","Daily Planet","5000","12-12-2022"},
            new String[] {"3","Ace Chemical","-82000","01-03-2022"},
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"}
    );

    public static void main(String[] args)
    {

        // generate customers using customerData
        List<Customer> customers = generateCustomers(customerData);

        // print positive accounts
        System.out.println("\nPositive accounts:");
        System.out.println("------------------");
        List<Customer> positiveAccounts = getPositiveAccounts(customers);
        for (Customer customer : positiveAccounts)
            System.out.println(customer);

        // print negative accounts
        System.out.println("\nNegative accounts:");
        System.out.println("------------------");
        List<Customer> negativeAccounts = getNegativeAccounts(customers);
        for (Customer customer : negativeAccounts)
            System.out.println(customer);

    }

    /**
     * Reads in customer data and converts each data entry into a Customer object.
     * @param customerData String[] entries of customer data in the format of {id, name, charge, chargeDate}
     * @return a list of the Customers found in the customer data.
     */
    public static List<Customer> generateCustomers(List<String[]> customerData)
    {
        // list of customers
        List<Customer> customers = new ArrayList<>();

        // map customerId:customerName
        HashMap<Integer, Customer> map = new HashMap<>();

        // data format is: <id, name, charge, chargeDate>
        for (String[] data : customerData)
        {
            int customerId = Integer.parseInt(data[0]);

            if (!map.containsKey(customerId))
            { // customer doesn't exist yet, so initialize new customer

                Customer newCustomer = new Customer();
                newCustomer.setId(Integer.parseInt(data[0]));
                newCustomer.setName(data[1]);
                newCustomer.addCharge(data[2], data[3]);

                // add new customer to map
                map.put(customerId, newCustomer);
            }
            else
            { // Customer already exists, so just add the new charge to the account
                Customer existing = map.get(customerId);
                existing.addCharge(data[2], data[3]);
            }
        }


        // initialize list of customers with the entries in the map made above
        for (Map.Entry entry : map.entrySet())
        {
            customers.add((Customer) entry.getValue());
        }

        return customers;
    }

    /**
     * Finds and returns a list of accounts whose balance is > $0
     * @param customers a list of Customer objects
     * @return a list of Customer objects whose account balance is > $0
     */
    public static List<Customer> getPositiveAccounts(List<Customer> customers)
    {
        List<Customer> positiveAccounts = new ArrayList<>();
        for (Customer customer : customers)
        {
            if (customer.getBalance() > 0)
                positiveAccounts.add(customer);
        }

        return positiveAccounts;
    }

    /**
     * Finds and returns a list of accounts whose balance is < $0
     * @param customers a list of Customer objects
     * @return a list of Customer objects whose account balance is < $0
     */
    public static List<Customer> getNegativeAccounts(List<Customer> customers)
    {
        List<Customer> negativeAccounts = new ArrayList<>();
        for (Customer customer : customers)
        {
            if (customer.getBalance() < 0)
                negativeAccounts.add(customer);
        }

        return negativeAccounts;
    }
}
