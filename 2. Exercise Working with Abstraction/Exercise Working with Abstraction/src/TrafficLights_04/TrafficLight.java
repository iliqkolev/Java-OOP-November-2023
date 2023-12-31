package TrafficLights_04;

public class TrafficLight {
    private Color color;

    public TrafficLight(Color color) {
        this.color = color;
    }

    //променя си цвета
    public void changeColor() {
        switch (this.color) {
            case RED: this.color = Color.GREEN; break;
            case GREEN: this.color = Color.YELLOW; break;
            case YELLOW: this.color = Color.RED; break;
        }
    }

    public String getColor() {
        return this.color.name();
    }
}
