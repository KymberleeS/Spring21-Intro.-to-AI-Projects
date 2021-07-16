// imports
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class TestingEnvironment3 extends JPanel {
    @Override
    public void paintComponent(Graphics polygon) {
        // establishing the environment
        Graphics2D shapes = (Graphics2D) polygon;
        shapes.setStroke(new BasicStroke(3));

        // goal area
        VerticesNodes goalNode = new VerticesNodes(867, 23, 0, 0);
        shapes.setColor(Color.blue);

        int goalX[] = {goalNode.getxValue() - 25, goalNode.getxValue() - 25, goalNode.getxValue() + 25, goalNode.getxValue() + 25};
        int goalY[] = {goalNode.getyValue() - 25, goalNode.getyValue() + 25, goalNode.getyValue() + 25, goalNode.getyValue() - 25};
        Polygon goalArea = new Polygon(goalX, goalY, 4);
        shapes.fillPolygon(goalArea);

        // start point with node
        VerticesNodes startNode = new VerticesNodes(25, 637, 0, 0);
        shapes.setColor(Color.red);
        shapes.fillOval(startNode.getxValue(), startNode.getyValue(), 20, 20);

        int startX[] = {startNode.getxValue() - 25, startNode.getxValue() - 25, startNode.getxValue() + 25, startNode.getxValue() + 25};
        int startY[] = {startNode.getyValue() - 25, startNode.getyValue() + 25, startNode.getyValue() + 25, startNode.getyValue() - 25};
        Polygon startArea = new Polygon(startX, startY, 4);
        shapes.fillPolygon(startArea);

        // non-traditional polygons for 20% obstacles (5)
        shapes.setColor(Color.gray);

        // polygon 1 (3 vertices)
        VerticesNodes polygonA1 = new VerticesNodes(100, 50, 0, 0);
        VerticesNodes polygonA2 = new VerticesNodes(300, 50, 0, 0);
        VerticesNodes polygonA3 = new VerticesNodes(200, 200, 0, 0);

        int polygon1X[] = {100, 300, 200};
        int polygon1Y[] = {50, 50, 200};
        Polygon polygon1 = new Polygon(polygon1X, polygon1Y, 3);
        shapes.fillPolygon(polygon1);

        // polygon 2 (4 vertices)
        VerticesNodes polygonB1 = new VerticesNodes(53, 320, 0, 0);
        VerticesNodes polygonB2 = new VerticesNodes(205, 245, 0, 0);
        VerticesNodes polygonB3 = new VerticesNodes(340, 555, 0, 0);
        VerticesNodes polygonB4 = new VerticesNodes(150, 330, 0, 0);

        int polygon2X[] = {53, 205, 340, 150};
        int polygon2Y[] = {320, 245, 555, 330};
        Polygon polygon2 = new Polygon(polygon2X, polygon2Y, 4);
        shapes.fillPolygon(polygon2);

        // polygon 3 (5 vertices)
        VerticesNodes polygonC1 = new VerticesNodes(456, 430, 0, 0);
        VerticesNodes polygonC2 = new VerticesNodes(555, 531, 0, 0);
        VerticesNodes polygonC3 = new VerticesNodes(637, 560, 0, 0);
        VerticesNodes polygonC4 = new VerticesNodes(590, 600, 0, 0);
        VerticesNodes polygonC5 = new VerticesNodes(470, 600, 0, 0);

        int polygon3X[] = {456, 555, 637, 590, 470};
        int polygon3Y[] = {430, 531, 560, 600, 600};
        Polygon polygon3 = new Polygon(polygon3X, polygon3Y, 5);
        shapes.fillPolygon(polygon3);

        // polygon 4 (6 vertices)
        VerticesNodes polygonD1 = new VerticesNodes(600, 300, 0, 0);
        VerticesNodes polygonD2 = new VerticesNodes(650, 200, 0, 0);
        VerticesNodes polygonD3 = new VerticesNodes(700, 250, 0, 0);
        VerticesNodes polygonD4 = new VerticesNodes(800, 200, 0, 0);
        VerticesNodes polygonD5 = new VerticesNodes(800, 400, 0, 0);
        VerticesNodes polygonD6 = new VerticesNodes(650, 400, 0, 0);

        int polygon4X[] = {600, 650, 700, 800, 800, 650};
        int polygon4Y[] = {300, 200, 250, 200, 400, 400};
        Polygon polygon4 = new Polygon(polygon4X, polygon4Y, 6);
        shapes.fillPolygon(polygon4);

        // polygon 5 (7 vertices)
        VerticesNodes polygonE1 = new VerticesNodes(300, 250, 0, 0);
        VerticesNodes polygonE2 = new VerticesNodes(400, 100, 0, 0);
        VerticesNodes polygonE3 = new VerticesNodes(500, 200, 0, 0);
        VerticesNodes polygonE4 = new VerticesNodes(450, 350, 0, 0);
        VerticesNodes polygonE5 = new VerticesNodes(600, 400, 0, 0);
        VerticesNodes polygonE6 = new VerticesNodes(330, 400, 0, 0);
        VerticesNodes polygonE7 = new VerticesNodes(350, 300, 0, 0);

        int polygon5X[] = {300, 400, 500, 450, 600, 330, 350};
        int polygon5Y[] = {250, 100, 200, 350, 400, 400, 300};
        Polygon polygon5 = new Polygon(polygon5X, polygon5Y, 7);
        shapes.fillPolygon(polygon5);

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

            randomNode.setxValue((int)(Math.random() * ((900 - 1) + 1)) + 1);
            randomNode.setyValue((int)(Math.random() * ((700 - 1) + 1)) + 1);

            currentNode = nearestNeighbor(randomNode, treeNodes);
            newNode[i] = attachNewNode(currentNode, randomNode, newNode[i]);

            // collision detection
            if (doesIntersect(polygonA1, polygonA2, newNode[i], currentNode) || doesIntersect(polygonA2, polygonA3, newNode[i], currentNode) ||
                    doesIntersect(polygonA3, polygonA1, newNode[i], currentNode)) { continue; }

            if (doesIntersect(polygonB1, polygonB2, newNode[i], currentNode) || doesIntersect(polygonB2, polygonB3, newNode[i], currentNode) ||
                    doesIntersect(polygonB3, polygonB4, newNode[i], currentNode) || doesIntersect(polygonB4, polygonB1, newNode[i], currentNode)) { continue; }

            if (doesIntersect(polygonC1, polygonC2, newNode[i], currentNode) || doesIntersect(polygonC2, polygonC3, newNode[i], currentNode) ||
                    doesIntersect(polygonC3, polygonC4, newNode[i], currentNode) || doesIntersect(polygonC4, polygonC5, newNode[i], currentNode) ||
                    doesIntersect(polygonC5, polygonC1, newNode[i], currentNode)) { continue; }

            if (doesIntersect(polygonD1, polygonD2, newNode[i], currentNode) || doesIntersect(polygonD2, polygonD3, newNode[i], currentNode) ||
                    doesIntersect(polygonD3, polygonD4, newNode[i], currentNode) || doesIntersect(polygonD4, polygonD5, newNode[i], currentNode) ||
                    doesIntersect(polygonD5, polygonD6, newNode[i], currentNode) || doesIntersect(polygonD6, polygonD1, newNode[i], currentNode)) {
                continue; }

            if (doesIntersect(polygonE1, polygonE2, newNode[i], currentNode) || doesIntersect(polygonE2, polygonE3, newNode[i], currentNode) ||
                    doesIntersect(polygonE3, polygonE4, newNode[i], currentNode) || doesIntersect(polygonE4, polygonE5, newNode[i], currentNode) ||
                    doesIntersect(polygonE5, polygonE6, newNode[i], currentNode) || doesIntersect(polygonE6, polygonE7, newNode[i], currentNode) ||
                    doesIntersect(polygonE7, polygonE1, newNode[i], currentNode)) {
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

