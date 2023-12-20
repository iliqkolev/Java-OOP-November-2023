public enum Season {
    SUMMER(4),
    WINTER(3),
    SPRING(2),
    AUTUMN(1);

    private final int factor;

    Season(int factor) {
        this.factor = factor;
    }

    public int getFactor() {
        return factor;
    }
}
