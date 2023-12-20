package vehicleShop.models.worker;

public class SecondShift extends BaseWorker{
    public SecondShift(String name) {
        super(name, 70);
    }

    @Override
    public void working() {
        int decreasedStrength = getStrength() - 5;
        if (decreasedStrength < 0){
            decreasedStrength = 0;
        }
    }
}
