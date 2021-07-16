public class VerticesNodes {
    // fields
    private int xValue;
    private int yValue;
    private double estimatedNodeCost;
    private double totalScore;
    private double startToNode;

    // constructor
    public VerticesNodes(int xValue, int yValue, double estimatedNodeCost, double totalScore, double startToNode) {
        this.xValue = xValue;
        this.yValue = yValue;
        this.estimatedNodeCost = estimatedNodeCost;
        this.totalScore = totalScore;
        this.startToNode = startToNode;
    }

    // getters and setters
    public int getxValue() {
        return xValue;
    }

    public int getyValue() {
        return yValue;
    }

    public double getEstimatedNodeCost() {
        return estimatedNodeCost;
    }

    public void setEstimatedNodeCost(double estimatedNodeCost) {
        this.estimatedNodeCost = estimatedNodeCost;
    }

    public double getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(double totalScore) {
        this.totalScore = totalScore;
    }

    public double getStartToNode() {
        return startToNode;
    }

    public void setStartToNode(double startToNode) {
        this.startToNode = startToNode;
    }


}
