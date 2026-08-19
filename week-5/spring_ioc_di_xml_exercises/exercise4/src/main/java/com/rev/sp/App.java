package com.rev.sp;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("myConfiguration.xml");
        Customer customer = context.getBean("customer", Customer.class);
        customer.setCustomerId(1);
        customer.setEmail("user@email.com");
        customer.setName("user");
        BankAccount bankAccount = context.getBean("bankAccount", BankAccount.class);
        bankAccount.setAccountNumber("1");
        bankAccount.setBalance(3311);
        bankAccount.setCustomer(customer);

        System.out.println("Customer ID: " + bankAccount.getCustomer().getCustomerId());
        System.out.println("Customer Name: " + bankAccount.getCustomer().getName());
        System.out.println("Customer Email: " + bankAccount.getCustomer().getEmail());
        System.out.println("Account Number: " + bankAccount.getAccountNumber());
        System.out.println("Account Balance: " + bankAccount.getBalance());
    }
}
