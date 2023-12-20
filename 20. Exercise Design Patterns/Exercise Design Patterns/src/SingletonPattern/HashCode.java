package SingletonPattern;

public class HashCode {
    private String points;
    private static HashCode instance;

    private HashCode(String points) {
        this.points = points;
    }

    public static HashCode getInstance(String points){
        if (instance == null){
            instance = new HashCode(points);
        }
        return instance;
    }

    public String getPoints() {
        return points;
    }
}
