# AI Prompt Log: AI Debugging Exercise

## Roster App - NullPointerException Fix
## 1. Initial Attempt
- **Context**: Roster App, AI Debugging Exercise.
- **Prompt**: "Fix this NullPointerException when reaching index 2"
- **Generated Code**:
```java
// Bug 1: The Null Roster Crash
public class RosterApp {
    public static void main(String[] args) {
        String[] studentNames = new String[5];
        studentNames[0] = "Alice";
        studentNames[1] = "Bob";

        for (int i = 0; i < studentNames.length; i++) {
            // Avoid NullPointerException for uninitialized (null) entries
            if (studentNames[i] != null && studentNames[i].startsWith("A")) {
                System.out.println("Student: " + studentNames[i]);
            }
        }
    }
}
```
## 2. Critique & Evaluation
In this initial attempt, 
the basically correct approach was taken to avoid the NullPointerException 
by checking if the array element is not null before calling the `startsWith` method. 
However, the code could be improved for better readability and maintainability. 
However, I've noticed it only checks for null values rather than performing any additional validation 
like checking for empty strings or trimming whitespace or ensuring that the array is properly initialized with valid student names.

## 3. Refined Attempt
- **Revised Prompt**: "Act as an expert Java compiler diagnostics tool. Fix this NullPointerException when reaching index 2 and
checking for empty strings or trimming whitespace or ensuring that the array is 
properly initialized with valid student names. Explain the root cause and provide a clean, secure fix."
- **Generated Code**:
```java
// Bug 1: The Null Roster Crash - Refined Version
public class RosterApp {
    public static void main(String[] args) {
        String[] studentNames = {"Alice", "Bob", null, "  ", "Amelia"};
        
        System.out.println("=== Student Roster (Names Starting with 'A') ===");
        for (int i = 0; i < studentNames.length; i++) {
            String student = sanitizeName(studentNames[i]);
            
            if (student != null && student.startsWith("A")) {
                System.out.println("Student: " + student);
            }
        }
    }
    
    /**
     * Safely processes a student name by:
     * - Handling null values
     * - Trimming whitespace
     * - Validating non-empty result
     * 
     * @param name the raw student name
     * @return trimmed name, or null if invalid
     */
    private static String sanitizeName(String name) {
        if (name == null) {
            return null; // Missing data
        }
        
        String trimmed = name.trim();
        return trimmed.isEmpty() ? null : trimmed; // Reject whitespace-only strings
    }
}
```
## 3. Refined Attempt
- **Root Cause Explanation**: The original code did not account for null values or empty strings in the `studentNames` 
array, which led to a `NullPointerException` when trying to call methods on null elements. 
Additionally, it did not handle cases where names might consist solely of whitespace, 
which could lead to unexpected behavior. 

- **Fix Explanation**: The refined code introduces a `sanitizeName` method that checks for null values, 
trims whitespace, and ensures that only valid, non-empty names are processed. 
This prevents the `NullPointerException` and ensures that the application behaves 
correctly even when encountering invalid data.

## Airport App - ClassCastException Fix
## 1. Initial Attempt
- **Context**: Airport App, AI Debugging Exercise.
- **Prompt**: "Fix this ClassCastException when casting a Passenger to a Pilot"
- **Generated Code**:
```

class Vehicle {}
class Car extends Vehicle {}
class Airplane extends Vehicle {}

public class AirportApp {
    public static void main(String[] args) {
        Vehicle myVehicle = new Airplane();

        // Safe downcast with instanceof check
        if (myVehicle instanceof Car) {
            Car myCar = (Car) myVehicle;
            System.out.println("Vehicle downcasted to Car successfully.");
        } else if (myVehicle instanceof Airplane) {
            Airplane myPlane = (Airplane) myVehicle;
            System.out.println("Vehicle identified as Airplane.");
        } else {
            System.out.println("Vehicle is of unknown type: " + myVehicle.getClass().getSimpleName());
        }
    }
}
```
## 2. Critique & Evaluation
In this initial attempt, the code correctly uses the `instanceof` operator to check the type of the `myVehicle` object
before performing a downcast. This prevents a `ClassCastException`. However, the code could be improved by providing
a more structured approach to handling different vehicle types and 
ensuring that the application can gracefully handle unexpected types.

## 3. Refined Attempt
- **Revised Prompt**: "Act as an expert Java compiler diagnostics tool. Fix this ClassCastException when casting a Passenger to a Pilot and 
explain the root cause and improve it by providing a more structured approach to handling different vehicle types and
ensuring that the application can gracefully handle unexpected types provide a clean, secure fix."
- **Generated Code**:
```

/**
 * Base class for all vehicles with common behavior handling.
 */
abstract class Vehicle {
    public abstract String getVehicleType();
    
    public abstract void performAction();
}

class Car extends Vehicle {
    @Override
    public String getVehicleType() {
        return "Car";
    }
    
    @Override
    public void performAction() {
        System.out.println("Car is driving on the road.");
    }
}

class Airplane extends Vehicle {
    @Override
    public String getVehicleType() {
        return "Airplane";
    }
    
    @Override
    public void performAction() {
        System.out.println("Airplane is flying in the sky.");
    }
}

public class AirportApp {
    /**
     * Handles vehicle processing using polymorphism and graceful fallback.
     */
    private static void processVehicle(Vehicle vehicle) {
        if (vehicle == null) {
            System.err.println("Error: Vehicle cannot be null.");
            return;
        }
        
        try {
            System.out.println("Processing vehicle: " + vehicle.getVehicleType());
            vehicle.performAction();
        } catch (Exception e) {
            System.err.println("Error processing vehicle: " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        System.out.println("=== Airport Vehicle Management System ===\n");
        
        Vehicle[] vehicles = {
            new Airplane(),
            new Car(),
            new Airplane(),
            null  // Test graceful null handling
        };
        
        for (Vehicle vehicle : vehicles) {
            processVehicle(vehicle);
            System.out.println();
        }
    }
}
```
## 3. Refined Attempt
- **Root Cause Explanation**: The original code attempted to downcast a `Vehicle` object to a specific subclass 
without ensuring that the object was of the expected type. This led to a `ClassCastException` when 
the object was not of the expected subclass. The lack of type safety and structured handling of different
vehicle types contributed to the issue.
- **Fix Explanation**: The refined code introduces an abstract `Vehicle` class with common behavior and methods for subclasses.
The `processVehicle` method uses polymorphism to handle different vehicle types gracefully,
and it includes error handling for null values and unexpected types. This approach ensures that the application can
process various vehicle types without risking a `ClassCastException`, providing a more robust and maintainable solution.

## Fianncial App - ArthmeticException Fix
## 1. Initial Attempt
- **Context**: Financial App, AI Debugging Exercise.
- **Prompt**: "Fix this ArithmeticException when dividing by zero"
- **Generated Code**:
```java
public class FinancialApp {
    public static double computeScore(int totalScore, int divisor) throws IllegalArgumentException {
        if (divisor == 0) {
            throw new IllegalArgumentException("Divisor cannot be zero");
        }
        return (double) totalScore / divisor;
    }

    public static void main(String[] args) {
        System.out.println("Processing report...");
        try {
            double value = computeScore(100, 0);
            System.out.println("Calculated Value: " + value);
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
```
## 2. Critique & Evaluation
In this initial attempt, the code correctly checks for a zero divisor and throws an `IllegalArgumentException` to 
prevent an `ArithmeticException`. This is a good practice as it provides a clear error message and
avoids the runtime exception. However, the code could be improved by providing more context in the
error message and ensuring that the application can handle different types of input gracefully.
