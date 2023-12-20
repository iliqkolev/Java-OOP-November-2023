import java.util.Arrays;
import java.util.Objects;

public class MainAuthorAnnotation {
    public static void main(String[] args) {


        Class<Reflection> reflectionClass = Reflection.class;

        Arrays.stream(reflectionClass.getDeclaredMethods())
                .map(method -> method.getAnnotation(Author.class))
                .filter(Objects::nonNull)
                .forEach(author -> System.out.println(author.value()));


    }
}
