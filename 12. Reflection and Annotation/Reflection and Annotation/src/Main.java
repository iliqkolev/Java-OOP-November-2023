import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {

        Class<Reflection> clazz = Reflection.class;

        Field[] fields = clazz.getDeclaredFields();

        Arrays.stream(fields)
                .sorted(Comparator.comparing(Field::getName))
                .filter(f -> !Modifier.isPrivate(f.getModifiers()))
                .forEach(f -> System.out.println(f.getName() + " must be private!"));


        Arrays.stream(clazz.getDeclaredMethods())
                .filter(m -> !m.getName().equals("toString"))
                .sorted(Comparator.comparing(Method::getName))
                .filter(Main::filterByType)
                .forEach(m -> System.out.println(formatPrint(m)));

    }

    private static String formatPrint(Method m) {
        String postfix=m.getName().startsWith("get") ? "public!" : "private!";
        return m.getName() + " have to be " + postfix;
    }

    private static boolean filterByType(Method method) {
        return (method.getName().startsWith("get") && !Modifier.isPublic(method.getModifiers()))
                ||
                (method.getName().startsWith("set") && !Modifier.isPrivate(method.getModifiers()));
    }
}
