import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws WrongFileNameException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);
        Methods methods = new Methods();
        int num = 1;
        while (num == 1) {
            System.out.println("1.Enter to see custom checked exception");
            System.out.println("2.Enter to create array and see custom unchecked exception (if you enter negative number for array length), and also other one " +
                    "unchecked exception if you enter in index search index which you don't have in that array ");
            System.out.println("3.Enter to see checked exception");
            int num2 = scanner.nextInt();
            if (num2 == 1) {

                 methods.readFile();
            } else if (num2 == 2) {
                int n = methods.setLength();
                methods.setArray(n);
                int[] d = methods.setArray(n);
                methods.addValues(n, d);
                System.out.println("Enter a index of element you want to see");
//if you enter index which you don't have in array that will cause (ArrayIndexOutOfBoundsException) unchecked exception
               int index = scanner.nextInt();
                methods.searchIndex(d, n, index);
            } else if (num2 == 3) {
                System.out.println("Enter class name");
                String s = scanner.nextLine();
                Methods.nonExistanceClass();
            }
            System.out.println("If you want to run again enter 1, if you want to exit enter 2");
            num = scanner.nextInt();

        }
    }
}


