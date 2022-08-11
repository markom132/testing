
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Methods {


    public static boolean isNameCorrect(String fileName) {
        if (fileName.equals("trueName.txt"))
            return true;
        else
            return false;
    }

    public static String readFile() throws WrongFileNameException {
        System.out.println("Enter any string to start custom unchecked exception");
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();
        getFile(fileName);
        return fileName;
    }

    public static String nonExistanceClass() throws ClassNotFoundException {
//this is one example of checked exception
        String name;
        try {
            name = "name";
            Class.forName(name);
            ClassLoader.getSystemClassLoader().loadClass(name);
            return name;
        } catch (ClassNotFoundException e) {
            throw new ClassNotFoundException();

        }

    }

    public static int[] setArray(int n) {

        int[] array = new int[n];


        return array;

    }

    public static int searchIndex(int[] array, int n, int index) {
        int value = 0;
        if (n >= 1) {


//with try-catch we can try our code and if everything is legit try block is executed, if it's not catch block will 'catch' exception and execute that bloch of code :)
            try {
                System.out.println("Value of selected index is: " + array[index]);
                value = array[index];

            } catch (ArrayIndexOutOfBoundsException e) {
                throw new ArrayIndexOutOfBoundsException();
            }
        }

        return value;
    }

    public static int[] addValues(int n, int[] array) {
        if (n >= 1) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter array values");
            for (int i = 0; i < n; i++) {
                System.out.print("Insert value on index " + (i) + ": ");
                array[i] = scanner.nextInt();
            }
        }
        return array;
    }

    public static int setLenght() throws ArrayLenghtCantBeNegative {
        Scanner scanner = new Scanner(System.in);
        int[] array;
        System.out.println("We will create an array, please enter array length");
        int n = 0;
        try {


            n = scanner.nextInt();
            array = new int[n];
            return n;
        } catch (NegativeArraySizeException exc) {
            if (n <= 0) {
                throw new ArrayLenghtCantBeNegative("Array length should be positive ", exc);
            }


        }


        return n;
    }

    public static String getFile(String fileName) throws WrongFileNameException {

//this is my checked exception, where I tried to read file witch don't exists
        try (Scanner file = new Scanner(new File(fileName))) {
            if (file.hasNextLine()) {
                file.nextLine();
            }
        } catch (FileNotFoundException err) {
            if (!isNameCorrect(fileName)) {
                throw new WrongFileNameException("Wrong file name : " + fileName, err);

            }
        }
        return fileName;
    }
}