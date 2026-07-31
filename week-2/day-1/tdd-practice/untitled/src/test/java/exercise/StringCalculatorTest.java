package exercise;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StringCalculatorTest {

    @Test
    public void testAddSimpleNumbers() {
        // Arrange
        StringCalculator calc = new StringCalculator();

        // Act
        int result = calc.add("5,3");
        int multi = calc.multiply("5,3");

        // Assert
        assertEquals(8, result);
        assertEquals(15, multi);
    }
}