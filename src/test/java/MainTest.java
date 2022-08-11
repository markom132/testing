
import org.junit.jupiter.api.*;

import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

@DisplayName("Running MainTest")
class MainTest {
    Main main;

    static final Logger logger = Logger.getLogger(MainTest.class.getName());

    @BeforeAll
    public static void beforeAll() {
        logger.log(Level.INFO, "Starting test in class MainTest");
    }

    @BeforeEach
    void init() {
        main = new Main();
    }

    @Nested
    @DisplayName("Running file tests")
    class FileTests {
        @BeforeAll
        static void initSecondClass() {
            logger.log(Level.INFO, "Running tests in FileTests subclass");
        }

        @Test
        @DisplayName("Test file name")
        void testFileName() {
            logger.log(Level.INFO, "Started test file name");
            String fileName = "trueName.txt";
            boolean expected = true;
            boolean actual = main.isNameCorrect(fileName);
            assertEquals(expected, actual, "The failure is on test file name method");
            logger.log(Level.INFO, "Ended test file name");
        }

        @Test
        @DisplayName("Test getting file")
        void testGetFile() {
            logger.log(Level.INFO, "Started test getting file");
            String fileName = "fakeName";
            assertThrows(WrongFileNameException.class, () -> main.getFile(fileName), "Any file name except 'someName.txt' should throw");
            logger.log(Level.INFO, "Ended test getting file");
        }

        @AfterAll
        static void initEndSecond() {
            logger.log(Level.INFO, "Ended tests in FileTests subclass");
        }
    }

    @Nested
    @DisplayName("Running array tests")
    class ArrayTests {
        @BeforeAll
        static void initThirdClass() {
            logger.log(Level.INFO, "Starting ArrayTests subclass");
        }

        @Test
        @DisplayName("Started test set array length")
            //I can't call a method for setting array length, but I will test array with entering positive and negative values
        void testArrayLenghtPositive() {
            logger.log(Level.INFO, "Test set array length");
            int expected = 2;
            int[] array = new int[expected];
            assertEquals(array.length, expected);
            logger.log(Level.INFO, "Ended test set array length");
        }

        // I needed this part of code from method here to try it
        private void addL(int n) {
            try {
                int[] array = new int[n];
            } catch (NegativeArraySizeException exc) {
                if (n <= 0) {
                    throw new ArrayLenghtCantBeNegative("Array length should be positive ", exc);
                }
            }
        }

        @Test
        @DisplayName("Test negative array can't exists")
        void testArrayLenghtNegative() {
            logger.log(Level.INFO, "Start test negative array can't exists");
            int n = -1;
            boolean itsOk = true;
            assumeTrue(itsOk);
            assertThrows(ArrayLenghtCantBeNegative.class, () -> addL(n), "Array size can't be negative ");
            logger.log(Level.INFO, "Ended test negative array can't exists");
        }

        @Test
        @DisplayName("Test search values from array by index")
        void testSearchByIndex() {
            logger.log(Level.INFO, "Started test search values from array by index");
            int index = 1;
            int[] array = new int[]{1, 2, 3};
            int expected = 2;
            int actual = array[index];
            assertEquals(expected, actual);
            logger.log(Level.INFO, "Ended test search values from array by index");
        }

        @Test
        @DisplayName("Test search index which array don't have")
        void testSearchNonExistentIndex() {
            logger.log(Level.INFO, "Started test search index which array don't have");
            int index = 3;
            assertThrows(ArrayIndexOutOfBoundsException.class, () -> searchArr(index), "You can't search negative numbers");
            logger.log(Level.INFO, "Ended test search index with array don't have");
        }

        private void searchArr(int index) throws ArrayIndexOutOfBoundsException {
            int[] array = new int[]{1, 2, 3};
            try {
                System.out.println("Value of selected index is: " + array[index]);

            } catch (ArrayIndexOutOfBoundsException e) {
                throw new ArrayIndexOutOfBoundsException("You don't have this index in array  " + e);
            }
        }
        @AfterAll
        static void initEndThird(){
            logger.log(Level.INFO, "Ended ArrayTests subclass");
        }
    }
    @AfterAll
    static void initEndMain(){
        logger.log(Level.INFO, "Ended tests in MainTest class");
    }


}
