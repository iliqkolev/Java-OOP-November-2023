package harpoonDiver.models.diving;

import harpoonDiver.models.diver.BaseDiver;
import harpoonDiver.models.diver.Diver;
import harpoonDiver.models.divingSite.DivingSite;
import harpoonDiver.models.divingSite.DivingSiteImpl;
import harpoonDiver.models.seaCatch.SeaCatch;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DivingImpl implements Diving{
    @Override
    public void searching(DivingSite divingSite, Collection<Diver> divers) {

            for (Diver diver: divers){
                if (diver.getOxygen() > 0){
                    diver.canDive();

                    while (diver.getOxygen() > 0){
                        divingSite.getSeaCreatures();
                        diver.shoot();
                        diver.getSeaCatch();
                    }
                }
                if (diver.getOxygen() == 0){
                    continue;
                }
            }

    }
}
