package WildFarm_04;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();

        List<Animal> animals =new ArrayList<>();

        while (!line.equalsIgnoreCase("end")) {
            Animal animal = createAnimal(line);
            Food food = createFood(scanner.nextLine());
            animal.makeSound();
            animal.eat(food);

            animals.add(animal);

            line = scanner.nextLine();
        }

        for (Animal animal : animals) {
            System.out.println(animal.toString());
        }
    }

    private static Animal createAnimal(String line) {
        String[] tokens = line.split("\\s+");

        String type = tokens[0];
        String name = tokens[1];
        Double weight = Double.parseDouble(tokens[2]);
        String livingRegion = tokens[3];

        Animal animal;

        if (type.equals("Cat")) {
            animal = new Cat(name, type, weight, livingRegion, tokens[4]);
        } else if (type.equals("Mouse")) {
            animal = new Mouse(name, type, weight, livingRegion);
        } else if (type.equals("Tiger")) {
            animal = new Tiger(name, type, weight, livingRegion);
        } else {
            animal = new Zebra(name, type, weight, livingRegion);
        }

        return animal;
    }

    private static Food createFood(String line) {
        String[] tokens = line.split("\\s+");
        String foodType = tokens[0];
        int quantity = Integer.parseInt(tokens[1]);

        return foodType.equals("Meat") ? new Meat(quantity) : new Vegetable(quantity);
    }

}
