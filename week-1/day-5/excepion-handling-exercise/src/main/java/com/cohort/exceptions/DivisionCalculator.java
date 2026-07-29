package com.cohort.exceptions;

public class DivisionCalculator {
    public static int divide (String numeratorStr, String denominatorStr) throws InvalidInputException {
        if(numeratorStr == null || denominatorStr == null  || numeratorStr.equals("") || denominatorStr.equals("")) {
            throw new InvalidInputException("Input arguments cannot be null or empty.");
        }
        try{
            int numeratorInt = Integer.parseInt(numeratorStr);
            int denominatorInt = Integer.parseInt(denominatorStr);
            return numeratorInt / denominatorInt;
        }catch (NumberFormatException e) {
            throw new InvalidInputException("Inputs must be valid integers. Parsing failed.");
        } catch (ArithmeticException e) {
            throw new InvalidInputException("Division by zero is mathematically undefined.");
        }
        finally {
            System.out.println("[CALCULATOR] Execution cycle complete");
        }
    }

    public static void main(String[] args) {
        divide("100", "5");
        divide("100", "0");
        divide("abc", "5");
        divide(null, "5");
    }
}
