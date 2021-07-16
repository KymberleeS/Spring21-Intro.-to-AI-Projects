public class VerticesNodes {
    // fields
    private int xValue;
    private int yValue;
    private int previousX;
    private int previousY;

    // constructor
    public VerticesNodes() {
        // default
    }

    public VerticesNodes(int xValue, int yValue, int previousX, int previousY) {
        this.xValue = xValue;
        this.yValue = yValue;
        this.previousX = previousX;
        this.previousY = previousY;
    }

    // getters and setters
    public int getxValue() {
        return xValue;
    }

    public int getyValue() {
        return yValue;
    }

    public void setxValue(int xValue) {
        this.xValue = xValue;
    }

    public void setyValue(int yValue) {
        this.yValue = yValue;
    }

    public int getPreviousX() {
        return previousX;
    }

    public void setPreviousX(int previousX) {
        this.previousX = previousX;
    }

    public int getPreviousY() {
        return previousY;
    }

    public void setPreviousY(int previousY) {
        this.previousY = previousY;
    }
}
