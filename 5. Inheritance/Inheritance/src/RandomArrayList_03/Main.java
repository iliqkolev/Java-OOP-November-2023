package RandomArrayList_03;

public class Main {
    public static void main(String[] args) {

        RandomArrayList<Integer> numbers=new RandomArrayList<>();
        numbers.add(7);
        numbers.add(5);
        numbers.add(12);
        numbers.add(15);
        System.out.println(numbers.getRandomElement());
    }
}
