import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        String[] weekdays= new String[5];
        int length= weekdays.length;
        weekdays[0] ="Monday";
        weekdays[1] ="Tuesday";
        weekdays[2] ="Wednesday";
        weekdays[3] ="Thursday";
        weekdays[4] ="Friday";

        for (int i = 0; i < length; i++) {
            System.out.println(weekdays[i]);
        }

    }
}
