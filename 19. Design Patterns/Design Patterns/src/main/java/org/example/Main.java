package org.example;

import javax.xml.crypto.Data;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {

        Database database = Database.getInstance();
        Database database1 = Database.getInstance();
        Database database2 = Database.getInstance();



        Address address= Address.builder()
                .withName("Ivo")
                .withEmail("Ivo@abv.bg")
                .build();






    }
}