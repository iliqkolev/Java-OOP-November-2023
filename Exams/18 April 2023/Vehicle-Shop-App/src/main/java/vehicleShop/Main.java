package vehicleShop;

import vehicleShop.core.Engine;
import vehicleShop.core.EngineImpl;
import vehicleShop.models.worker.BaseWorker;

public class Main {
    public static void main(String[] args) {
        Engine engine = new EngineImpl();
        engine.run();
        
    }
}
