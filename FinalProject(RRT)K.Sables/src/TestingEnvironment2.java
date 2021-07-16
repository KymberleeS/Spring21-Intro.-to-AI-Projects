// imports
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class TestingEnvironment2 extends JPanel {
    @Override
    public void paintComponent(Graphics polygon) {
        // establishing the environment
        Graphics2D shapes = (Graphics2D) polygon;
        shapes.setStroke(new BasicStroke(3));

        // goal area
        VerticesNodes goalNode = new VerticesNodes(767, 23, 0, 0);
        shapes.setColor(Color.blue);

        int goalX[] = {goalNode.getxValue() - 25, goalNode.getxValue() - 25, goalNode.getxValue() + 25, goalNode.getxValue() + 25};
        int goalY[] = {goalNode.getyValue() - 25, goalNode.getyValue() + 25, goalNode.getyValue() + 25, goalNode.getyValue() - 25};
        Polygon goalArea = new Polygon(goalX, goalY, 4);
        shapes.fillPolygon(goalArea);

        // start point with node
        VerticesNodes startNode = new VerticesNodes(25, 537, 0, 0);
        shapes.setColor(Color.red);
        shapes.fillOval(startNode.getxValue(), startNode.getyValue(), 20, 20);

        int startX[] = {startNode.getxValue() - 25, startNode.getxValue() - 25, startNode.getxValue() + 25, startNode.getxValue() + 25};
        int startY[] = {startNode.getyValue() - 25, startNode.getyValue() + 25, startNode.getyValue() + 25, startNode.getyValue() - 25};
        Polygon startArea = new Polygon(startX, startY, 4);
        shapes.fillPolygon(startArea);

        // random shape for 10% obstacles (1)
        shapes.setColor(Color.gray);
        VerticesNodes shapeNode = new VerticesNodes((int)(Math.random() * ((700 - 100) + 1) + 100), (int)(Math.random() * ((500 - 100) + 1) + 100),
                0, 0);

        int shapePointsX[] = {shapeNode.getxValue() - 140, shapeNode.getxValue() - 75, shapeNode.getxValue() + 75, shapeNode.getxValue() + 140,
                              shapeNode.getxValue() + 75, shapeNode.getxValue() - 75};

        int shapePointsY[] = {shapeNode.getyValue(), shapeNode.getyValue() - 75, shapeNode.getyValue() - 75, shapeNode.getyValue(),
                              shapeNode.getyValue() + 75, shapeNode.getyValue() + 75};

        VerticesNodes randomP1 = new VerticesNodes(shapePointsX[0], shapePointsY[0], 0, 0);
        VerticesNodes randomP2 = new VerticesNodes(shapePointsX[1], shapePointsY[1], 0, 0);
        VerticesNodes randomP3 = new VerticesNodes(shapePointsX[2], shapePointsY[2], 0, 0);
        VerticesNodes randomP4 = new VerticesNodes(shapePointsX[3], shapePointsY[3], 0, 0);
        VerticesNodes randomP5 = new VerticesNodes(shapePointsX[4], shapePointsY[4], 0, 0);
        VerticesNodes randomP6 = new VerticesNodes(shapePointsX[5], shapePointsY[5], 0, 0);

        Polygon randomShape = new Polygon(shapePointsX, shapePointsY, 6);
        shapes.fillPolygon(randomShape);

        // setting path color
        shapes.setColor(Color.magenta);

//===============================================RRT IMPLEMENTATION START===============================================
        VerticesNodes[] newNode = new VerticesNodes[100000];

        for (int i = 0; i < newNode.length; i++) {
            newNode[i] = new VerticesNodes();
        }

        ArrayList<VerticesNodes> treeNodes = new ArrayList<>();
        treeNodes.add(startNode);

        VerticesNodes randomNode = new VerticesNodes(0, 0, 0, 0);
        VerticesNodes currentNode = new VerticesNodes();

        VerticesNodes[] nodeTrackers = new VerticesNodes[100000];

        for (int i = 0; i < nodeTrackers.length; i++) {
            nodeTrackers[i] = new VerticesNodes();
        }

        ArrayList<VerticesNodes> solutionNodes = new ArrayList<>();

        for (int i = 0; i < newNode.length; i++) {
            if (goalArea.contains(currentNode.getxValue(), currentNode.getyValue())) {
                break;
            }

            randomNode.setxValue((int)(Math.random() * ((800 - 1) + 1)) + 1);
            randomNode.setyValue((int)(Math.random() * ((600 - 1) + 1)) + 1);

            currentNode = nearestNeighbor(randomNode, treeNodes);
            newNode[i] = attachNewNode(currentNode, randomNode, newNode[i]);

            // collision detection
            if (doesIntersect(randomP1, randomP2, newNode[i], currentNode) || doesIntersect(randomP2, randomP3, newNode[i], currentNode) ||
                    doesIntersect(randomP3, randomP4, newNode[i], currentNode) || doesIntersect(randomP4, randomP5, newNode[i], currentNode) ||
                    doesIntersect(randomP5, randomP6, newNode[i], currentNode) || doesIntersect(randomP6, randomP1, newNode[i], currentNode)) {
                continue; }


            // drawing paths after detecting for collision
            shapes.drawLine(newNode[i].getxValue(), newNode[i].getyValue(), currentNode.getxValue(), currentNode.getyValue());

            nodeTrackers[i].setxValue(newNode[i].getxValue());
            nodeTrackers[i].setyValue(newNode[i].getyValue());
            nodeTrackers[i].setPreviousX(currentNode.getxValue());
            nodeTrackers[i].setPreviousY(currentNode.getyValue());

            treeNodes.add(newNode[i]);
            solutionNodes.add(nodeTrackers[i]);
        }
//================================================RRT IMPLEMENTATION END================================================
        shapes.setColor(Color.green);

        // tracing the path back to start
        shapes.drawLine(solutionNodes.get(solutionNodes.size() - 1).getxValue(), solutionNodes.get(solutionNodes.size() - 1).getyValue(),
                solutionNodes.get(solutionNodes.size() - 1).getPreviousX(), solutionNodes.get(solutionNodes.size() - 1).getPreviousY());

        VerticesNodes tempNode = new VerticesNodes();

        for (int i = 0; i < solutionNodes.size(); i++) {
            if (solutionNodes.get(solutionNodes.size() - 1).getPreviousX() == solutionNodes.get(i).getxValue() &&
                    solutionNodes.get(solutionNodes.size() - 1).getPreviousY() == solutionNodes.get(i).getyValue()) {
                shapes.drawLine(solutionNodes.get(i).getPreviousX(), solutionNodes.get(i).getPreviousY(), solutionNodes.get(i).getxValue(), solutionNodes.get(i).getyValue());
                tempNode = solutionNodes.get(i);
            }
        }

        while (tempNode != solutionNodes.get(0) || tempNode != solutionNodes.get(1) || !startArea.contains(tempNode.getxValue(), tempNode.getyValue())) {
            for (int i = 0; i < solutionNodes.size(); i++) {
                if (tempNode.getPreviousX() == solutionNodes.get(i).getxValue() &&
                        tempNode.getPreviousY() == solutionNodes.get(i).getyValue()) {
                    shapes.drawLine(solutionNodes.get(i).getPreviousX(), solutionNodes.get(i).getPreviousY(), solutionNodes.get(i).getxValue(), solutionNodes.get(i).getyValue());
                    tempNode = solutionNodes.get(i);
                }
            }

            if (tempNode == solutionNodes.get(0) || startArea.contains(tempNode.getxValue(), tempNode.getyValue())) {
                break;
            }
        }
    }

    // method that finds the distance between the random node and the nearest tree node
    public double pathCost(VerticesNodes currentNode, VerticesNodes destinationNode) {
        return Math.hypot(destinationNode.getyValue() - currentNode.getyValue(), destinationNode.getxValue() - currentNode.getxValue());
    }

    // method that finds the nearest node on the existing tree
    public VerticesNodes nearestNeighbor(VerticesNodes currentNode, ArrayList<VerticesNodes> allNodes) {
        VerticesNodes temp = new VerticesNodes();
        double shortestPath = Double.MAX_VALUE;
        for (int i = 0; i < allNodes.size(); i++) {
            if (shortestPath > pathCost(currentNode, allNodes.get(i))) {
                shortestPath = pathCost(currentNode, allNodes.get(i));
                temp = allNodes.get(i);
            }
        }
        return temp;
    }

    // method that attaches a new node after a distance away from the current node
    public VerticesNodes attachNewNode(VerticesNodes currentNode, VerticesNodes randomNode, VerticesNodes newNode) {
        newNode.setxValue((currentNode.getxValue() + randomNode.getxValue()) / 2);
        newNode.setyValue((currentNode.getyValue() + randomNode.getyValue()) / 2);

        newNode.setxValue((currentNode.getxValue() + newNode.getxValue()) / 2);
        newNode.setyValue((currentNode.getyValue() + newNode.getyValue()) / 2);

        newNode.setxValue((currentNode.getxValue() + newNode.getxValue()) / 2);
        newNode.setyValue((currentNode.getyValue() + newNode.getyValue()) / 2);

        newNode.setxValue((currentNode.getxValue() + newNode.getxValue()) / 2);
        newNode.setyValue((currentNode.getyValue() + newNode.getyValue()) / 2);

        return newNode;
    }

    // method that determines where the lines are facing
    public int position(VerticesNodes x, VerticesNodes y, VerticesNodes z) {
        int result = (y.getyValue() - x.getyValue()) * (z.getxValue() - y.getxValue()) - (y.getxValue() - x.getxValue()) * (z.getyValue() - y.getyValue());
        if (result == 0) {
            return 0;
        }
        return (result > 0) ? 1 : 2;
    }

    // makes sure that the lines do not intersect the polygon edges
    public boolean doesIntersect(VerticesNodes x1, VerticesNodes y1, VerticesNodes x2, VerticesNodes y2) {
        int case1 = position(x1, y1, x2);
        int case2 = position(x1, y1, y2);
        int case3 = position(x2, y2, x1);
        int case4 = position(x2, y2, y1);

        if (case1 != case2 && case3 != case4) {
            return true;
        }
        return false;
    }
}


