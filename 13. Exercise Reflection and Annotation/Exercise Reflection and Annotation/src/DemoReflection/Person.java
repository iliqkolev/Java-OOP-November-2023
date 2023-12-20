package DemoReflection;

public class Person {
    private String name;
    public  String lastName;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    private Person(){
        this.name= "Ivan";
        this.lastName="Ivanov";
        this.age= 20;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
    private void walk(){
        System.out.printf("%s is walking!", getName());
    }
}
