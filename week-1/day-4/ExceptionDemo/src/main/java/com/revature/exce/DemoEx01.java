package com.revature.exce;

import java.util.Scanner;

public class DemoEx01 {
    public static void main(String[] args) {
        String name;
        int age;
        Scanner input = new Scanner(System.in);

        try {
            System.out.println("Please Enter your name: ");
            name = input.nextLine();
            System.out.println("Please Enter your age: ");
            age = input.nextInt();
            System.out.println("Name: " + name + ", Age: " + age);
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter a valid age as a number.");
            e.printStackTrace();
        } finally {
            System.out.println("finally block executed");
        }

        }
}
