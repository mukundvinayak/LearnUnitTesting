import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BasicTests {
    @Test
    @DisplayName("Compares 2 numbers positive")
    public void compare(){
        Basics basicTest = new Basics();
        int value = basicTest.compare(2,1);
        assertEquals(1, value);
    }
    @Test
    @DisplayName("Compare 2 numbers negative")
    public void compare2(){
        Basics basicTest = new Basics();
        int value = basicTest.compare(1,2);
        assertEquals(-1, value);
    }

    @Test
    @DisplayName("Compare 2 numbers zero")
    public void compare3(){
        Basics basicTest = new Basics();
        int value = basicTest.compare(1,1);
        assertEquals(0, value);
    }



}
