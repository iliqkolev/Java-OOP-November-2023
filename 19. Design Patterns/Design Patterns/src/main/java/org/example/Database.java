package org.example;

import javax.xml.crypto.Data;
import java.util.HashMap;
import java.util.Map;

public class Database {
    private Map<String, Integer> memory;
    private static Database instance;

    private Database(){

            try {
                Thread.sleep(10_000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            memory = new HashMap<>();
            System.out.println("Connection");
    }

    public static Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }
}
