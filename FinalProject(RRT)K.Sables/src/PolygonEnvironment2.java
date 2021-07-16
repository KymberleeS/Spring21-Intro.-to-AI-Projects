// imports
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PolygonEnvironment2 extends JPanel {
    @Override
    public void paintComponent(Graphics polygon) {
        // establishing the environment
        Graphics2D shapes = (Graphics2D) polygon;
        shapes.setStroke(new BasicStroke(3));

        // goal area
        shapes.setColor(Color.blue);

        int goalX[] = {1230, 1230, 1280, 1280};
        int goalY[] = {55, 105, 105, 55};
        Polygon goalArea = new Polygon(goalX, goalY, 4);
        shapes.fillPolygon(goalArea);

        // start point with node
        VerticesNodes startNode = new VerticesNodes(170, 525, 0, 0);
        shapes.setColor(Color.red);
        shapes.fillOval(170, 500, 20, 20);

        int startX[] = {120, 120, 220, 220};
        int startY[] = {475, 575, 575, 475};
        Polygon startArea = new Polygon(startX, startY, 4);
        shapes.fillPolygon(startArea);

        // set shape fill color
        shapes.setColor(Color.gray);

        // triangle 1
        VerticesNodes polygonA1 = new VerticesNodes(300, 50, 0, 0);
        VerticesNodes polygonA2 = new VerticesNodes(500, 50, 0, 0);
        VerticesNodes polygonA3 = new VerticesNodes(400, 200, 0, 0);

        int triangle1X[] = {300, 500, 400};
        int triangle1Y[] = {50, 50, 200};
        Polygon polygonTriangle1 = new Polygon(triangle1X, triangle1Y, 3);
        shapes.fillPolygon(polygonTriangle1);

        // triangle 2
        VerticesNodes polygonB1 = new VerticesNodes(300, 450, 0, 0);
        VerticesNodes polygonB2 = new VerticesNodes(500, 450, 0, 0);
        VerticesNodes polygonB3 = new VerticesNodes(400, 600, 0, 0);

        int triangle2X[] = {300, 500, 400};
        int triangle2Y[] = {450, 450, 600};
        Polygon polygonTriangle2 = new Polygon(triangle2X, triangle2Y, 3);
        shapes.fillPolygon(polygonTriangle2);

        // triangle 3
        VerticesNodes polygonC1 = new VerticesNodes(900, 50, 0, 0);
        VerticesNodes polygonC2 = new VerticesNodes(1100, 50, 0, 0);
        VerticesNodes polygonC3 = new VerticesNodes(1000, 200, 0, 0);

        int triangle3X[] = {900, 1100, 1000};
        int triangle3Y[] = {50, 50, 200};
        Polygon polygonTriangle3 = new Polygon(triangle3X, triangle3Y, 3);
        shapes.fillPolygon(polygonTriangle3);

        // triangle 4
        VerticesNodes polygonD1 = new VerticesNodes(900, 450, 0, 0);
        VerticesNodes polygonD2 = new VerticesNodes(1100, 450, 0, 0);
        VerticesNodes polygonD3 = new VerticesNodes(1000, 600, 0, 0);

        int triangle4X[] = {900, 1100, 1000};
        int triangle4Y[] = {450, 450, 600};
        Polygon polygonTriangle4 = new Polygon(triangle4X, triangle4Y, 3);
        shapes.fillPolygon(polygonTriangle4);

        // triangle 5
        VerticesNodes polygonE1 = new VerticesNodes(700, 100, 0, 0);
        VerticesNodes polygonE2 = new VerticesNodes(500, 400, 0, 0);
        VerticesNodes polygonE3 = new VerticesNodes(900, 400, 0, 0);

        int triangle5X[] = {700, 500, 900};
        int triangle5Y[] = {100, 400, 400};

        Polygon polygonTriangle5 = new Polygon(triangle5X, triangle5Y, 3);
        shapes.fillPolygon(polygonTriangle5);

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

            randomNode.setxValue((int)(Math.random() * ((1500 - 1) + 1)) + 1);
            randomNode.setyValue((int)(Math.random() * ((700 - 1) + 1)) + 1);

            currentNode = nearestNeighbor(randomNode, treeNodes);
            newNode[i] = attachNewNode(currentNode, randomNode, newNode[i]);

            // collision detection
            if (doesIntersect(polygonE1, polygonE2, newNode[i], currentNode) || doesIntersect(polygonE2, polygonE3, newNode[i], currentNode) ||
                doesIntersect(polygonE3, polygonE1, newNode[i], currentNode)) { continue; }

            if (doesIntersect(polygonB1, polygonB2, newNode[i], currentNode) || doesIntersect(polygonB2, polygonB3, newNode[i], currentNode) ||
                doesIntersect(polygonB3, polygonB1, newNode[i], currentNode)) { continue; }

            if (doesIntersect(polygonC1, polygonC2, newNode[i], currentNode) || doesIntersect(polygonC2, polygonC3, newNode[i], currentNode) ||
                doesIntersect(polygonC3, polygonC1, newNode[i], currentNode)) { continue; }

            if (doesIntersect(polygonD1, polygonD2, newNode[i], currentNode) || doesIntersect(polygonD2, polygonD3, newNode[i], currentNode) ||
                doesIntersect(polygonD3, polygonD1, newNode[i], currentNode)) { continue; }

            if (doesIntersect(polygonA1, polygonA2, newNode[i], currentNode) || doesIntersect(polygonA2, polygonA3, newNode[i], currentNode) ||
                doesIntersect(polygonA3, polygonA1, newNode[i], currentNode)) { continue; }

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
