import java.sql.SQLOutput;
import java.util.Scanner;

public class SquareRoot_02 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        try {
        int number=Integer.parseInt(scanner.nextLine());
            if (number >= 0){
            double sqrt = Math.sqrt(number);
            System.out.printf("%.2f\n", sqrt);
            }else{
                System.out.println("Invalid");
            }

        }catch (NumberFormatException ignored){
            System.out.println("Invalid");

        }finally {
            System.out.println("Goodbye");

        }

    }
}
