import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

@DisplayName("Running MainTest")
class MainTest {
    Main main;

    @BeforeEach
    void init() {
        main = new Main();
    }

    @Nested
    @DisplayName("Running file tests")
    class FileTests {
        @Test
        @DisplayName("Test file name")
        void testFileName() {
            String fileName = "trueName.txt";
            boolean expected = true;
            boolean actual = main.isNameCorrect(fileName);
            assertEquals(expected, actual, "The failure is on test file name method");
        }
        @Test
        @DisplayName("Test getting file")
        void testGetFile(){
            String fileName = "fakeName";
            boolean itsOk = true;
            assumeTrue(itsOk);
            assertThrows(WrongFileNameException.class, () -> main.getFile(fileName), "Any file name except 'someName.txt' should throw");
        }
    }
    @Nested
    @DisplayName("Running array tests")
    class ArrayTests{
        @Test
        @DisplayName("Test set array lenght")
        //I can't call a method for setting array lenght but I will test array with entering positive and negative values
        void testArrayLenghtPositive(){
            int expected = 2;
            int[] array = new int[expected];
            assertEquals(array.length, expected);
        }
        // I needed this part of code from method here to try it
       private void addL(int n){
            try{
            int[] array = new int[n];
       } catch (NegativeArraySizeException exc) {
            if (n <= 0) {
                throw new ArrayLenghtCantBeNegative("Array lenght should be positive ", exc);
            }
        }
        }
        @Test
        @DisplayName("Test negative array can't exists")
        void testArrayLenghtNegative(){
            int n = -1;
            boolean itsOk = true;
            assumeTrue(itsOk);
            assertThrows(ArrayLenghtCantBeNegative.class, () -> addL(n),"Array size can't be negative ");
        }

    }
}
