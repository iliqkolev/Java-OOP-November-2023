package harvestingFields_01;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);

		String line=scanner.nextLine();

		Class<RichSoilLand> richSoilLandClass = RichSoilLand.class;
		Field[] declaredFields = richSoilLandClass.getDeclaredFields();


		while (!line.equals("HARVEST")){

			if (line.equals("all")) {
				Arrays.stream(declaredFields).forEach(Main::printField);
			} else {
				String finalLine = line;
				Arrays.stream(declaredFields).filter(field -> Modifier.toString(field.getModifiers()).equals(finalLine))
						.forEach(Main::printField);
			}

			line=scanner.nextLine();
		}


	}
	private  static void printField(Field field){
		System.out.printf("%s %s %s\n",
				Modifier.toString(field.getModifiers()),
				field.getType().getSimpleName(),
				field.getName());
	}
}
