package SingletonPattern;


public class Main {
    public static void main(String[] args) {


        HashCode instance1 = HashCode.getInstance("SoftUni!");
        HashCode instance2 = HashCode.getInstance("Hello");

        System.out.println(instance1.getPoints());
        System.out.println(instance2.getPoints());

    }
}
