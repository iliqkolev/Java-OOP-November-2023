package blackBoxInteger_02;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {

        Scanner scanner=new Scanner(System.in);

        Class<BlackBoxInt> blackBoxIntClass = BlackBoxInt.class;
        Constructor<BlackBoxInt> constructor = blackBoxIntClass.getDeclaredConstructor();
        constructor.setAccessible(true);
        BlackBoxInt blackBox= constructor.newInstance();

        String line=scanner.nextLine();

        while (!"END".equals(line)){

            String[] tokens=line.split("_");
            String methodName=tokens[0];
            int parameter=Integer.parseInt(tokens[1]);

            Method method = blackBoxIntClass.getDeclaredMethod(methodName, int.class);
            method.setAccessible(true);
            method.invoke(blackBox, parameter);

            Field value = blackBoxIntClass.getDeclaredField("innerValue");
            value.setAccessible(true);
            System.out.println(value.get(blackBox));


            line=scanner.nextLine();
        }

    }
}
