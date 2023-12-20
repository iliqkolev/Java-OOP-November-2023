import java.util.Scanner;

public class PizzaMain {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        String[]  pizzaData=scanner.nextLine().split("\\s+");
        Pizza pizza=new Pizza(pizzaData[1],Integer.parseInt(pizzaData[2]));

        String [] doughData=scanner.nextLine().split("\\s+");
        Dough dough=new Dough(doughData[1], doughData[2], Double.parseDouble(doughData[3]));

        pizza.setDough(dough);

        String toppingData=scanner.nextLine();

        while (!toppingData.equalsIgnoreCase("end")){

            String [] tokens=toppingData.split("\\s+");
            Topping topping=new Topping(tokens[1],Double.parseDouble(tokens[2]));

            pizza.addTopping(topping);

            toppingData=scanner.nextLine();
        }

        System.out.printf("%s - %.2f", pizza.getName(), pizza.getOverallCalories());

    }
}
