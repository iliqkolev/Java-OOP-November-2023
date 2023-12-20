package vehicleShop.core;

public interface Controller {
    public abstract String addWorker(String type, String workerName);

    String addVehicle(String vehicleName, int strengthRequired);

    String addToolToWorker(String workerName, int power);

    String makingVehicle(String vehicleName);

    String statistics();
}
