package service;

import model.Customer;


import java.util.*;
import java.util.regex.Pattern;


public class CustomerService {

    private Collection<Customer> allCustomers = new ArrayList<>();
    private Map<String, Customer> mapOfCustomers = new HashMap<>();


    private static CustomerService customerService = null;

    private CustomerService() {
    }

    public static CustomerService getInstance() {

        if (null == customerService) {

            customerService = new CustomerService();
        }
        return customerService;
    }

    public void addCustomer(String email, String firstName, String lastName) {

        Customer customer = new Customer(firstName, lastName, email);
        this.allCustomers.add(customer);
        this.mapOfCustomers.put(customer.getEmail(), customer);
    }

    //Method to retrieve customer from custma email
    public Customer getCustomer(String customerEmail) {

        for (String custma : mapOfCustomers.keySet()) {
            String cusEmail = customerEmail.toLowerCase();
            if (custma.equals(cusEmail)) {

                Customer value = mapOfCustomers.get(custma);

                return value;
            }
        }
            return null;


        }
        // return all of the customers if they are in the customer collection
        public Collection<Customer> getAllCustomers() {
            return allCustomers;
        }
    }





