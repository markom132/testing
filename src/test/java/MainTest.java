
import org.junit.jupiter.api.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

@DisplayName("Running MainTest")
class MainTest {
    Methods methods;

    static final Logger logger = Logger.getLogger(MainTest.class.getName());

    @BeforeAll
    public static void beforeAll() {
        logger.log(Level.INFO, "Starting test in class MainTest");
    }

    @BeforeEach
    void init() {
        methods = new Methods();
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
            boolean actual = methods.isNameCorrect(fileName);
            assertEquals(expected, actual, "The failure is on test file name method");
            logger.log(Level.INFO, "Ended test file name");
        }

        @Test
        @DisplayName("Test file name 2")
        void testFileName2() {
            logger.log(Level.INFO, "Started test file name 2");
            boolean expected = true;
            String fileName = "fakeName.txt";
            boolean actual = methods.isNameCorrect(fileName);
            assertNotEquals(expected, actual, "The failure is on test file name method");
            logger.log(Level.INFO, "Ended test file name 2");
        }

        @Test
        @DisplayName("Test getting file")
        void testGetFile() {
            logger.log(Level.INFO, "Started test getting file");
            String fileName = "fakeName";
            assertThrows(WrongFileNameException.class, () -> methods.getFile(fileName), "Any file name except 'someName.txt' should throw");
            logger.log(Level.INFO, "Ended test getting file");
        }

        @Test
        @DisplayName("Test getting file")
        void testGetFile2() throws WrongFileNameException {
            logger.log(Level.INFO, "Started test getting file");
            String input = "trueName.txt";
            InputStream in = new ByteArrayInputStream(input.getBytes());
            System.setIn(in);
            String expected = "trueName.txt";
            assertEquals(expected, methods.readFile());
            logger.log(Level.INFO, "Ended test getting file");
        }

        @Test
        @DisplayName("Test read file")
        void testGetFile3() throws WrongFileNameException {
            logger.log(Level.INFO, "Started test get file 3");
            String input = "trueName.txt";
            InputStream in = new ByteArrayInputStream(input.getBytes());
            System.setIn(in);
            String expected = "trueName.txt";
            String actual = methods.getFile(input);
            assertEquals(expected, actual);
            logger.log(Level.INFO, "Ended test get file 3");
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
            int n = 2;
            int[] expected = new int[n];
            int[] actual = methods.setArray(n);
            assertEquals(actual.length, expected.length);
            logger.log(Level.INFO, "Ended test set array length");
        }


        @Test
        @DisplayName("Started test set array length")
            //I can't call a method for setting array length, but I will test array with entering positive and negative values
        void testSetArrayLenghtPositive() {
            logger.log(Level.INFO, "Test set array length3");
            int n = 2;
            int expected[] = new int[n];
            String input = String.valueOf(2);
            InputStream in = new ByteArrayInputStream(input.getBytes());
            System.setIn(in);
            int actual = methods.setLenght();
            assertEquals(expected.length, actual);
            int actual2 = methods.setArray(actual).length;
            assertEquals(actual, actual2);
            logger.log(Level.INFO, "Ended test set array length3");
        }

        @Test
        @DisplayName("Test negative array can't exists")
        void testArrayLenghtNegative() {
            logger.log(Level.INFO, "Start test negative array can't exists");
            String input = String.valueOf(-2);
            InputStream in = new ByteArrayInputStream(input.getBytes());
            System.setIn(in);
            assertThrows(ArrayLenghtCantBeNegative.class, () -> methods.setLenght(), "Array size can't be negative ");
            logger.log(Level.INFO, "Ended test negative array can't exists");
        }

        @Test
        @DisplayName("Test adding values to array")
        void testAddValues() {
            logger.log(Level.INFO, "Started test adding values to array");
            int n = 1;
            int[] array = new int[n];
            int[] expected = new int[n];
            String input = String.valueOf(1);
            InputStream in = new ByteArrayInputStream(input.getBytes());
            System.setIn(in);
            int[] actual = methods.addValues(n, array);
            assertEquals(expected.length, actual.length);
            logger.log(Level.INFO, "Ended test adding values to array");
        }

        @Test
        @DisplayName("Test search values from array by index")
        void testSearchByIndex() {
            logger.log(Level.INFO, "Started test search values from array by index");

            int index = 1;
            int[] array = new int[]{1, 2, 3};
            int n = 2;
            int actual = methods.searchIndex(array, n, index);
            int[] array2 = new int[]{1, 2, 3};
            int expected = array2[index];
            assertEquals(expected, actual);
            logger.log(Level.INFO, "Ended test search values from array by index");
        }

        @Test
        @DisplayName("Test search index which array don't have")
        void testSearchNonExistentIndex() {
            logger.log(Level.INFO, "Started test search index which array don't have");
            int index = 3;
            int[] array = new int[]{1, 2, 3};
            int n = 2;
            assertThrows(ArrayIndexOutOfBoundsException.class, () -> methods.searchIndex(array, n, index), "You can't search negative numbers");
            logger.log(Level.INFO, "Ended test search index which array don't have");
        }


        @AfterAll
        static void initEndThird() {
            logger.log(Level.INFO, "Ended ArrayTests subclass");
        }
    }

    @Test
    @DisplayName("NonExistentClass")
    void nonExistent() {
        logger.log(Level.INFO, "Started test non-existent class");
        assertThrows(ClassNotFoundException.class, () -> methods.nonExistanceClass(), "This class don't exists");
        logger.log(Level.INFO, "Ended test non-existent class");
    }

    @AfterAll
    static void initEndMain() {
        logger.log(Level.INFO, "Ended tests in MainTest class");
    }


}
