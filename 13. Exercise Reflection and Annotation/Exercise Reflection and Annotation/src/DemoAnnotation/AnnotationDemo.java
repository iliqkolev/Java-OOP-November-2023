package DemoAnnotation;


public class AnnotationDemo {
    public static void main(String[] args) {

        Employee employee = new Employee("Kaloyan", 1);
        System.out.println(employee.toString());


        Company companyAnnotation = employee.getClass().getAnnotation(Company.class);

        System.out.printf("Company name: %s\n", companyAnnotation.name());
        System.out.printf("City name: %s", companyAnnotation.city());


    }
}
