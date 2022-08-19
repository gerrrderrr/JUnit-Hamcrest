import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Matrix matrix;
        while (true) {
            System.out.println("Enter number to create your matrix");
            String sizeInput = scanner.nextLine();
            int size = 0;
            try {
                size = Integer.parseInt(sizeInput);
            } catch (NumberFormatException e) {
                System.out.println("Number expected");
            }
            if (size != 0) {
                matrix = new Matrix(size);
                matrix.printOriginal();
                break;
            }
        }

        while (true) {
            System.out.println("""
                    Enter the angle of rotation
                    'first' - get first number
                    'last' - get second number
                    'size' - get amount of elements
                    'end', to exit
                    """);
            String input = scanner.nextLine();
            System.out.println();
            if (input.equals("end")) {
                break;
            } else if (input.equals("first")) {
                System.out.println(matrix.getFirstNum() + "\n");
            } else if (input.equals("last")) {
                System.out.println(matrix.getLastNum() + "\n");
            } else if (input.equals("size")) {
                System.out.println(matrix.amountOfElements() + "\n");
            } else {
                try {
                    int angle = Integer.parseInt(input);
                    matrix.rotate(angle);
                } catch (NumberFormatException e) {
                    System.out.println("Expected angle or command");
                }
            }
        }
        scanner.close();
    }
}