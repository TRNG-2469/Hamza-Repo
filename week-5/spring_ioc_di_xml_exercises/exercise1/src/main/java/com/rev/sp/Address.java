package com.rev.sp;

public class Address {
    private String city;
    private String state;
    private int pincode;

    public Address() {
    }

    public String getCity() {
        return "New York";
    }

    public String getState() {
        return "New York";
    }


    public int getPincode() {
        return 10005;
    }
    public String toString() {
        return getCity() + ", " + getState() + " " + getPincode();
    }
}
