package DemoReflection;

import javax.accessibility.Accessible;
import java.lang.reflect.*;

public class Demo {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        //access the class
        Class<Person> personClass = Person.class;

        //access the fields
        Field[] allFields = personClass.getDeclaredFields(); // return all fields(public, private, protected)
        Field[] publicFields = personClass.getFields(); // return  only public fields

        for (Field field : allFields) {
            System.out.println(field.getName()); // name of the fields
            System.out.println(Modifier.toString(field.getModifiers())); // modifiers of the fields (public, private, protected)
            System.out.println(Modifier.isPublic(field.getModifiers())); // check whether a modifier is public (true or false)
            System.out.println(Modifier.isPrivate(field.getModifiers())); // check whether a modifier is private (true or false)
            System.out.println(Modifier.isProtected(field.getModifiers())); // check whether a modifier is protected (true or false)
        }

        //access public constructor
        Constructor<Person> publicConstructor = personClass.getDeclaredConstructor(String.class, int.class);
        publicConstructor.setAccessible(true);
        Person peter = publicConstructor.newInstance("Peter", 20);
        System.out.println(peter.getName());

        //access private,protected constructor
        Constructor<Person> privateConstructor = personClass.getDeclaredConstructor();
        privateConstructor.setAccessible(true);
        Person privatePerson = privateConstructor.newInstance();
        System.out.println(privatePerson.getName());

        //access methods
        Method[] declaredMethods = personClass.getDeclaredMethods();
        Method privateMethod = declaredMethods[1];
        privateMethod.setAccessible(true);
        privateMethod.invoke(privatePerson);
        System.out.println();
        System.out.println();

        //change private field value
        System.out.println("----------------");
        Field field=allFields[0];
        Field field2 = allFields[1];
        System.out.printf("Person is %s %s\n", privatePerson.getName(), privatePerson.lastName);
        field.setAccessible(true);
        field.set(privatePerson, "Sotir");
        field2.set(privatePerson, "Sotirov");
        System.out.printf("Person is %s %s\n", privatePerson.getName(), privatePerson.lastName);


        System.out.println();


    }
}
