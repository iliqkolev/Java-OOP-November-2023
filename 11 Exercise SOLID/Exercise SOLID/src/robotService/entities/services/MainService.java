package robotService.entities.services;

public class MainService extends BaseService {

    public static final int CAPACITY = 30;

    public MainService(String name) {
        super(name, CAPACITY);
    }
}
