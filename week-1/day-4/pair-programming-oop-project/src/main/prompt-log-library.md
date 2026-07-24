Round 2:

AI Prompt:
use @file:EBook.java Write a method downloadBook that simulates a 2-second delay using Thread.sleep. Constrain the input size to be positive. Use standard try-catch blocks for interruption

AI Response:
Planned changes — checklist:
•
Add a public method downloadBook(int sizeKB) to EBook.java.
•
Validate sizeKB is positive and throw IllegalArgumentException if not.
•
Simulate a 2-second download using Thread.sleep(2000) inside a try-catch.
•
Use standard try-catch for InterruptedException and re-set the thread interrupt flag.
•
Keep other class code unchanged.
I'll now apply the change to the file EBook.java.
Done — I added a new method downloadBook(int sizeKB) to EBook.java.
Summary of the implementation:
•
Validates input: throws IllegalArgumentException when sizeKB <= 0.
•
Simulates a 2-second download using Thread.sleep(2000).
•
Uses try-catch for InterruptedException, prints a message and restores the thread interrupt flag with Thread.currentThread().interrupt().

Given code:
/**
* Simulates downloading the e-book. The method enforces a positive size
* and simulates a 2-second download using Thread.sleep.
* If the thread is interrupted during sleep, the interrupt flag is re-set.
*
* @param sizeKB size of the download in kilobytes; must be positive
* @throws IllegalArgumentException if sizeKB is not positive
*/
public void downloadBook(int sizeKB) {
if (sizeKB <= 0) {
throw new IllegalArgumentException("sizeKB must be positive");
}

        System.out.println("Starting download (" + sizeKB + " KB)...");
        try {
            // Simulate download delay
            Thread.sleep(2000);
            System.out.println("Download complete.");
        } catch (InterruptedException e) {
            // Restore the interrupt status and handle interruption
            Thread.currentThread().interrupt();
            System.out.println("Download was interrupted.");
        }
    }