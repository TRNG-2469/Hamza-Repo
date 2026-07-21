package com.cohort.beta;

import com.cohort.alpha.AccessHolder;

public class PackageOutsider {
    public static void main(String[] args) {
        AccessHolder holder = new AccessHolder();
        holder.publicMethod();
        // holder.protectedMethod(); //'protectedMethod()' has protected access in 'com.cohort.alpha.AccessHolder'
        // holder.defaultMethod(); //defaultMethod()' is not public in 'com.cohort.alpha.AccessHolder'. Cannot be accessed from outside package
        // holder.privateMethod(); // Can you compile this?
    }
}
