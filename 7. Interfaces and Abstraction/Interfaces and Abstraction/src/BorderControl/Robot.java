package BorderControl;

public class Robot implements Identifiable{
    private String model;
    private String id;

    public Robot(String model, String name) {
        this.model = model;
        this.id = name;
    }
    public String getModel() {
        return model;
    }

    @Override
    public String getId() {
        return id;
    }

}
