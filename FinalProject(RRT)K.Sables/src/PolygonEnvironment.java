// imports
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PolygonEnvironment extends JPanel {
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

        // polygon 1 - Pentagon with nodes
        VerticesNodes polygonA1 = new VerticesNodes(250, 175, 0, 0);
        VerticesNodes polygonA2 = new VerticesNodes(410, 40, 0, 0);
        VerticesNodes polygonA3 = new VerticesNodes(550, 150, 0, 0);
        VerticesNodes polygonA4 = new VerticesNodes(470, 360, 0, 0);
        VerticesNodes polygonA5 = new VerticesNodes(310, 330, 0, 0);

        int pentagonX[] = {250, 410, 550, 470, 310};
        int pentagonY[] = {175, 40, 150, 360, 330};
        Polygon polygonPentagon = new Polygon(pentagonX, pentagonY, 5);
        shapes.fillPolygon(polygonPentagon);

        // polygon 2 - Rectangle 1 with nodes
        VerticesNodes polygonB1 = new VerticesNodes(330, 450, 0, 0);
        VerticesNodes polygonB2 = new VerticesNodes(330, 600, 0, 0);
        VerticesNodes polygonB3 = new VerticesNodes(800, 600, 0, 0);
        VerticesNodes polygonB4 = new VerticesNodes(800, 450, 0, 0);

        int rectangle1X[] = {330, 330, 800, 800};
        int rectangle1Y[] = {450, 600, 600, 450};
        Polygon polygonRectangle1 = new Polygon(rectangle1X, rectangle1Y, 4);
        shapes.fillPolygon(polygonRectangle1);

        // polygon 3 - Triangle 1 with nodes
        VerticesNodes polygonC1 = new VerticesNodes(600, 130, 0, 0);
        VerticesNodes polygonC2 = new VerticesNodes(550, 360, 0, 0);
        VerticesNodes polygonC3 = new VerticesNodes(650, 360, 0, 0);

        int triangle1X[] = {600, 550, 650};
        int triangle1Y[] = {130, 360, 360};
        Polygon polygonTriangle1 = new Polygon(triangle1X, triangle1Y, 3);
        shapes.fillPolygon(polygonTriangle1);

        // polygon 4 - Triangle 2 with nodes
        VerticesNodes polygonD1 = new VerticesNodes(870, 525, 0, 0);
        VerticesNodes polygonD2 = new VerticesNodes(930, 400, 0, 0);
        VerticesNodes polygonD3 = new VerticesNodes(800, 300, 0, 0);

        int triangle2X[] = {870, 930, 800};
        int triangle2Y[] = {525, 400, 300};
        Polygon polygonTriangle2 = new Polygon(triangle2X, triangle2Y, 3);
        shapes.fillPolygon(polygonTriangle2);

        // polygon 5 - Trapezoid 1 with nodes
        VerticesNodes polygonE1 = new VerticesNodes(660, 220, 0, 0);
        VerticesNodes polygonE2 = new VerticesNodes(850, 120, 0, 0);
        VerticesNodes polygonE3 = new VerticesNodes(800, 40, 0, 0);
        VerticesNodes polygonE4 = new VerticesNodes(690, 50, 0, 0);

        int trapezoid1X[] = {660, 850, 800, 690};
        int trapzoid1Y[] = {220, 120, 40, 50};
        Polygon polygonTrapezoid1 = new Polygon(trapezoid1X, trapzoid1Y, 4);
        shapes.fillPolygon(polygonTrapezoid1);

        // polygon 6 - Rectangle 2 with nodes
        VerticesNodes polygonF1 = new VerticesNodes(880, 50, 0, 0);
        VerticesNodes polygonF2 = new VerticesNodes(880, 330, 0, 0);
        VerticesNodes polygonF3 = new VerticesNodes(1050, 330, 0, 0);
        VerticesNodes polygonF4 = new VerticesNodes(1050, 50, 0, 0);

        int rectangle2X[] = {880, 880, 1050, 1050};
        int rectangle2Y[] = {50, 330, 330, 50};
        Polygon polygonRectangle2 = new Polygon(rectangle2X, rectangle2Y, 4);
        shapes.fillPolygon(polygonRectangle2);

        // polygon 7 - Trapezoid 2 with nodes
        VerticesNodes polygonG1 = new VerticesNodes(1070, 100, 0, 0);
        VerticesNodes polygonG2 = new VerticesNodes(1130, 50, 0, 0);
        VerticesNodes polygonG3 = new VerticesNodes(1200, 110, 0, 0);
        VerticesNodes polygonG4 = new VerticesNodes(1170, 340, 0, 0);

        int trapezoid2X[] = {1070, 1130, 1200, 1170};
        int trapzoid2Y[] = {100, 50, 110, 340};
        Polygon polygonTrapezoid2 = new Polygon(trapezoid2X, trapzoid2Y, 4);
        shapes.fillPolygon(polygonTrapezoid2);

        // polygon 8 - Hexagon with nodes
        VerticesNodes polygonH1 = new VerticesNodes(1100, 330, 0, 0);
        VerticesNodes polygonH2 = new VerticesNodes(1170, 430, 0, 0);
        VerticesNodes polygonH3 = new VerticesNodes(1170, 535, 0, 0);
        VerticesNodes polygonH4 = new VerticesNodes(1090, 600, 0, 0);
        VerticesNodes polygonH5 = new VerticesNodes(1000, 535, 0, 0);
        VerticesNodes polygonH6 = new VerticesNodes(1000, 430, 0, 0);

        int hexagonX[] = {1100, 1170, 1170, 1090, 1000, 1000};
        int hexagonY[] ={330, 430, 535, 600, 535, 430};
        Polygon polygonHexagon = new Polygon(hexagonX, hexagonY, 6);
        shapes.fillPolygon(polygonHexagon);
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
            if (doesIntersect(polygonA1, polygonA2, newNode[i], currentNode) || doesIntersect(polygonA2, polygonA3, newNode[i], currentNode) ||
                    doesIntersect(polygonA3, polygonA4, newNode[i], currentNode) || doesIntersect(polygonA4, polygonA5, newNode[i], currentNode) ||
                    doesIntersect(polygonA5, polygonA1, newNode[i], currentNode)) { continue; }

            if (doesIntersect(polygonB1, polygonB2, newNode[i], currentNode) || doesIntersect(polygonB2, polygonB3, newNode[i], currentNode) ||
                    doesIntersect(polygonB3, polygonB4, newNode[i], currentNode) || doesIntersect(polygonB4, polygonB1, newNode[i], currentNode)) {
                continue; }

            if (doesIntersect(polygonC1, polygonC2, newNode[i], currentNode) || doesIntersect(polygonC2, polygonC3, newNode[i], currentNode) ||
                    doesIntersect(polygonC3, polygonC1, newNode[i], currentNode)) { continue; }

            if (doesIntersect(polygonD1, polygonD2, newNode[i], currentNode) || doesIntersect(polygonD2, polygonD3, newNode[i], currentNode) ||
                    doesIntersect(polygonD3, polygonD1, newNode[i], currentNode)) { continue; }

            if (doesIntersect(polygonE1, polygonE2, newNode[i], currentNode) || doesIntersect(polygonE2, polygonE3, newNode[i], currentNode) ||
                    doesIntersect(polygonE3, polygonE4, newNode[i], currentNode) || doesIntersect(polygonE4, polygonE1, newNode[i], currentNode)) {
                continue; }

            if (doesIntersect(polygonF1, polygonF2, newNode[i], currentNode) || doesIntersect(polygonF2, polygonF3, newNode[i], currentNode) ||
                    doesIntersect(polygonF3, polygonF4, newNode[i], currentNode) || doesIntersect(polygonF4, polygonF1, newNode[i], currentNode)) {
                continue; }

            if (doesIntersect(polygonG1, polygonG2, newNode[i], currentNode) || doesIntersect(polygonG2, polygonG3, newNode[i], currentNode) ||
                    doesIntersect(polygonG3, polygonG4, newNode[i], currentNode) || doesIntersect(polygonG4, polygonG1, newNode[i], currentNode)) {
                continue; }

            if (doesIntersect(polygonH1, polygonH2, newNode[i], currentNode) || doesIntersect(polygonH2, polygonH3, newNode[i], currentNode) ||
                    doesIntersect(polygonH3, polygonH4, newNode[i], currentNode) || doesIntersect(polygonH4, polygonH5, newNode[i], currentNode) ||
                    doesIntersect(polygonH5, polygonH6, newNode[i], currentNode) || doesIntersect(polygonH6, polygonH1, newNode[i], currentNode)) {
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
