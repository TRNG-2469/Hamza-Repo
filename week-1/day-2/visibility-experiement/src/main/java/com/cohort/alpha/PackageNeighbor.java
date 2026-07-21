package com.cohort.alpha;

public class PackageNeighbor {
    public static void main(String[] args) {
        AccessHolder holder = new AccessHolder();
        holder.publicMethod();
        holder.protectedMethod();
        holder.defaultMethod();
        // holder.privateMethod(); // Can you compile this?
        //The privateMethod failed because this method isn't accessible to outside to anyone but its class
    }
}
