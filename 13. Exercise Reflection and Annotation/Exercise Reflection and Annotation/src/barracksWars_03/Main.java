package barracksWars_03;

import barracksWars_03.interfaces.Repository;
import barracksWars_03.interfaces.Runnable;
import barracksWars_03.interfaces.UnitFactory;
import barracksWars_03.core.Engine;
import barracksWars_03.core.factories.UnitFactoryImpl;
import barracksWars_03.data.UnitRepository;

public class Main {

    public static void main(String[] args) {
        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();

        Runnable engine = new Engine(repository, unitFactory);
        engine.run();
    }
}
