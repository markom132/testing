
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extensions;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.mockito.Mockito.mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import org.mockito.junit.*;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.Mockito.when;

@DisplayName("Running MainTest")
class MainTest {
    Methods methods;
    Methods mockObj;

    static final Logger logger = Logger.getLogger(MainTest.class.getName());

    @BeforeAll
    public static void beforeAll() {
        logger.log(Level.INFO, "Starting test in class MainTest");
    }

    @BeforeEach
    void init() {
        methods = new Methods();
        mockObj = mock(Methods.class);


    }


    @Nested
    @DisplayName("Running file tests")
    class FileTests {
        @BeforeAll
        static void initSecondClass() {
            logger.log(Level.INFO, "Running tests in FileTests subclass");
        }



        @Test
        @DisplayName("Mock test file name")
            //mock test
        void mockTestFileName() {
            logger.log(Level.INFO, "Started mock test file name");
            String fileName = "trueName.txt";
            when(mockObj.isNameCorrect(fileName)).thenReturn(true);
            boolean expected = true;
            boolean actual = mockObj.isNameCorrect(fileName);
            assertEquals(expected, actual, "The failure is on mock test file name method");
            logger.log(Level.INFO, "Ended mock test file name");
        }



        @Test
        @DisplayName("Test getting file exception")
        void testGetFile() {
            logger.log(Level.INFO, "Started test getting file");
            String fileName = "fakeName";
            assertThrows(WrongFileNameException.class, () -> methods.getFile(fileName), "Any file name except 'trueName.txt' should throw");
            logger.log(Level.INFO, "Ended test getting file exception");
        }

        @Test
        @DisplayName("Test getting file ")
        void testGetFile2() throws WrongFileNameException {
            logger.log(Level.INFO, "Started test getting file ");
            String input = "trueName.txt";
            InputStream in = new ByteArrayInputStream(input.getBytes());
            System.setIn(in);
            String expected = "trueName.txt";
            assertEquals(expected, methods.readFile());
            logger.log(Level.INFO, "Ended test getting file ");
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
        @DisplayName("Started mock test set array length")
            //mock test
        void testArrayLengthPositive() {
            logger.log(Level.INFO, "Mock test set array length");
            int expected = 2;
            String input = String.valueOf(2);
            InputStream in = new ByteArrayInputStream(input.getBytes());
            System.setIn(in);
            when(mockObj.setLength()).thenCallRealMethod();
            int actual = mockObj.setLength();
            assertEquals(expected, actual);
            logger.log(Level.INFO, "Mock test set array length");

        }


        @Test
        @DisplayName("Started test set array length")
        void testSetArrayLengthPositive() {
            logger.log(Level.INFO, "Test set array length3");
            int n = 2;
            int[] expected = new int[n];
            String input = String.valueOf(2);
            InputStream in = new ByteArrayInputStream(input.getBytes());
            System.setIn(in);
            int actual = methods.setLength();
            assertEquals(expected.length, actual);
            int actual2 = methods.setArray(actual).length;
            assertEquals(actual, actual2);
            logger.log(Level.INFO, "Ended test set array length3");
        }

        @Test
        @DisplayName("Test negative array can't exists")
        void testArrayLengthNegative() {
            logger.log(Level.INFO, "Start test negative array can't exists");
            String input = String.valueOf(-2);
            InputStream in = new ByteArrayInputStream(input.getBytes());
            System.setIn(in);
            assertThrows(ArrayLengthCantBeNegative.class, () -> methods.setLength(), "Array size can't be negative ");
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
