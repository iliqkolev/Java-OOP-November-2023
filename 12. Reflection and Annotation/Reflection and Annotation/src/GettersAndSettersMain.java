import java.lang.reflect.*;
import java.util.Arrays;

public class GettersAndSettersMain {
    public static void main(String[] args)  {

        Class<Reflection> clazz=Reflection.class;

        Method[] declaredMethods = clazz.getDeclaredMethods();

        Arrays.stream(declaredMethods)
                .filter(m -> !m.getName().equals("toString"))
                .sorted(new MethodComparator())
                .forEach(m -> System.out.println(formatMethodsInfo(m)));


    }
    public static String formatMethodsInfo(Method m){
        if (m.getName().startsWith("get")){
            return m.getName() + " will return class " + m.getReturnType().getName();
        }

        return m.getName() + " will set field of class " + m.getParameterTypes()[0].getName();
    }
}