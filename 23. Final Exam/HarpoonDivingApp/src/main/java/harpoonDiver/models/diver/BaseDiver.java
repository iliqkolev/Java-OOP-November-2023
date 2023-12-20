package harpoonDiver.models.diver;

import harpoonDiver.models.seaCatch.SeaCatch;

import static harpoonDiver.common.ExceptionMessages.DIVER_NAME_NULL_OR_EMPTY;
import static harpoonDiver.common.ExceptionMessages.DIVER_OXYGEN_LESS_THAN_ZERO;

public abstract class BaseDiver implements Diver{
    private String name;
    private double oxygen;
    private SeaCatch seaCatch;

    public BaseDiver(String name, double oxygen) {
        setName(name);
        setOxygen(oxygen);
    }

    @Override
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()){
            throw new NullPointerException(DIVER_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public double getOxygen() {
        return this.oxygen;
    }

    public void setOxygen(double oxygen) {
        if (oxygen < 0){
            throw new IllegalArgumentException(DIVER_OXYGEN_LESS_THAN_ZERO);
        }
        this.oxygen = oxygen;
    }

    @Override
    public boolean canDive() {
        return this.oxygen > 0;
    }

    @Override
    public SeaCatch getSeaCatch() {
        return this.seaCatch;
    }

    @Override
    public void shoot() {
        if (this.oxygen - 30.0 < 0){
            this.oxygen = 0;
        }else{
            this.oxygen -= 30;
        }
    }
}
