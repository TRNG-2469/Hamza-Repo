package com.week1.day3;

/**
 * RosterApp demonstrates safe array iteration with proper null handling
 * and validation of student names.
 */
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