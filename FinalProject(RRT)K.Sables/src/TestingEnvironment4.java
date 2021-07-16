// imports
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class TestingEnvironment4 extends JPanel {
    @Override
    public void paintComponent(Graphics polygon) {
        // establishing the environment
        Graphics2D shapes = (Graphics2D) polygon;
        shapes.setStroke(new BasicStroke(3));

        // goal area
        VerticesNodes goalNode = new VerticesNodes(967, 23, 0, 0);
        shapes.setColor(Color.blue);

        int goalX[] = {goalNode.getxValue() - 25, goalNode.getxValue() - 25, goalNode.getxValue() + 25, goalNode.getxValue() + 25};
        int goalY[] = {goalNode.getyValue() - 25, goalNode.getyValue() + 25, goalNode.getyValue() + 25, goalNode.getyValue() - 25};
        Polygon goalArea = new Polygon(goalX, goalY, 4);
        shapes.fillPolygon(goalArea);

        // start point with node
        VerticesNodes startNode = new VerticesNodes(25, 737, 0, 0);
        shapes.setColor(Color.red);
        shapes.fillOval(startNode.getxValue(), startNode.getyValue(), 20, 20);

        int startX[] = {startNode.getxValue() - 25, startNode.getxValue() - 25, startNode.getxValue() + 25, startNode.getxValue() + 25};
        int startY[] = {startNode.getyValue() - 25, startNode.getyValue() + 25, startNode.getyValue() + 25, startNode.getyValue() - 25};
        Polygon startArea = new Polygon(startX, startY, 4);
        shapes.fillPolygon(startArea);

        // non-traditional polygons for 20% obstacles (5)
        shapes.setColor(Color.gray);

        // rectangle A
        VerticesNodes polygonA1 = new VerticesNodes(100, 200, 0, 0);
        VerticesNodes polygonA2 = new VerticesNodes(150, 200, 0, 0);
        VerticesNodes polygonA3 = new VerticesNodes(150, 0, 0, 0);
        VerticesNodes polygonA4 = new VerticesNodes(100, 0, 0, 0);

        int polygonAX[] = {100, 150, 150, 100};
        int polygonAY[] = {200, 200, 0, 0};
        Polygon rectangleA = new Polygon(polygonAX, polygonAY, 4);
        shapes.fillPolygon(rectangleA);

        // rectangle B
        VerticesNodes polygonB1 = new VerticesNodes(100, 300, 0, 0);
        VerticesNodes polygonB2 = new VerticesNodes(150, 300, 0, 0);
        VerticesNodes polygonB3 = new VerticesNodes(150, 800, 0, 0);
        VerticesNodes polygonB4 = new VerticesNodes(100, 800, 0, 0);

        int polygonBX[] = {100, 150, 150, 100};
        int polygonBY[] = {300, 300, 800, 800};
        Polygon rectangleB = new Polygon(polygonBX, polygonBY, 4);
        shapes.fillPolygon(rectangleB);

        // rectangle C
        VerticesNodes polygonC1 = new VerticesNodes(800, 400, 0, 0);
        VerticesNodes polygonC2 = new VerticesNodes(850, 400, 0, 0);
        VerticesNodes polygonC3 = new VerticesNodes(850, 0, 0, 0);
        VerticesNodes polygonC4 = new VerticesNodes(800, 0, 0, 0);

        int polygonCX[] = {800, 850, 850, 800};
        int polygonCY[] = {400, 400, 0, 0};
        Polygon rectangleC = new Polygon(polygonCX, polygonCY, 4);
        shapes.fillPolygon(rectangleC);

        // rectangle D
        VerticesNodes polygonD1 = new VerticesNodes(900, 250, 0, 0);
        VerticesNodes polygonD2 = new VerticesNodes(900, 200, 0, 0);
        VerticesNodes polygonD3 = new VerticesNodes(1000, 200, 0, 0);
        VerticesNodes polygonD4 = new VerticesNodes(1000, 250, 0, 0);

        int polygonDX[] = {900, 900, 1000, 1000};
        int polygonDY[] = {250, 200, 200, 250};
        Polygon rectangleD = new Polygon(polygonDX, polygonDY, 4);
        shapes.fillPolygon(rectangleD);

        // rectangle E
        VerticesNodes polygonE1 = new VerticesNodes(700, 550, 0, 0);
        VerticesNodes polygonE2 = new VerticesNodes(700, 500, 0, 0);
        VerticesNodes polygonE3 = new VerticesNodes(1000, 500, 0, 0);
        VerticesNodes polygonE4 = new VerticesNodes(1000, 550, 0, 0);

        int polygonEX[] = {700, 700, 1000, 1000};
        int polygonEY[] = {550, 500, 500, 550};
        Polygon rectangleE = new Polygon(polygonEX, polygonEY, 4);
        shapes.fillPolygon(rectangleE);

        // rectangle F
        VerticesNodes polygonF1 = new VerticesNodes(800, 600, 0, 0);
        VerticesNodes polygonF2 = new VerticesNodes(850, 600, 0, 0);
        VerticesNodes polygonF3 = new VerticesNodes(850, 800, 0, 0);
        VerticesNodes polygonF4 = new VerticesNodes(800, 800, 0, 0);

        int polygonFX[] = {800, 850, 850, 800};
        int polygonFY[] = {600, 600, 800, 800};
        Polygon rectangleF = new Polygon(polygonFX, polygonFY, 4);
        shapes.fillPolygon(rectangleF);

        // rectangle G
        VerticesNodes polygonG1 = new VerticesNodes(450, 350, 0, 0);
        VerticesNodes polygonG2 = new VerticesNodes(400, 350, 0, 0);
        VerticesNodes polygonG3 = new VerticesNodes(400, 0, 0, 0);
        VerticesNodes polygonG4 = new VerticesNodes(450, 0, 0, 0);

        int polygonGX[] = {450, 400, 400, 450};
        int polygonGY[] = {350, 350, 0, 0};
        Polygon rectangleG = new Polygon(polygonGX, polygonGY, 4);
        shapes.fillPolygon(rectangleG);

        // rectangle H
        VerticesNodes polygonH1 = new VerticesNodes(300, 550, 0, 0);
        VerticesNodes polygonH2 = new VerticesNodes(300, 600, 0, 0);
        VerticesNodes polygonH3 = new VerticesNodes(150, 600, 0, 0);
        VerticesNodes polygonH4 = new VerticesNodes(150, 550, 0, 0);

        int polygonHX[] = {300, 300, 150, 150};
        int polygonHY[] = {550, 600, 600, 550};
        Polygon rectangleH = new Polygon(polygonHX, polygonHY, 4);
        shapes.fillPolygon(rectangleH);

        // rectangle I
        VerticesNodes polygonI1 = new VerticesNodes(550, 350, 0, 0);
        VerticesNodes polygonI2 = new VerticesNodes(550, 300, 0, 0);
        VerticesNodes polygonI3 = new VerticesNodes(800, 300, 0, 0);
        VerticesNodes polygonI4 = new VerticesNodes(800, 350, 0, 0);

        int polygonIX[] = {550, 550, 800, 800};
        int polygonIY[] = {350, 300, 300, 350};
        Polygon rectangleI = new Polygon(polygonIX, polygonIY, 4);
        shapes.fillPolygon(rectangleI);

        // rectangle J
        VerticesNodes polygonJ1 = new VerticesNodes(650, 700, 0, 0);
        VerticesNodes polygonJ2 = new VerticesNodes(600, 700, 0, 0);
        VerticesNodes polygonJ3 = new VerticesNodes(600, 350, 0, 0);
        VerticesNodes polygonJ4 = new VerticesNodes(650, 350, 0, 0);

        int polygonJX[] = {650, 600, 600, 650};
        int polygonJY[] = {700, 700, 350, 350};
        Polygon rectangleJ = new Polygon(polygonJX, polygonJY, 4);
        shapes.fillPolygon(rectangleJ);

        // rectangle K
        VerticesNodes polygonK1 = new VerticesNodes(450, 450, 0, 0);
        VerticesNodes polygonK2 = new VerticesNodes(500, 450, 0, 0);
        VerticesNodes polygonK3 = new VerticesNodes(500, 800, 0, 0);
        VerticesNodes polygonK4 = new VerticesNodes(450, 800, 0, 0);

        int polygonKX[] = {450, 500, 500, 450};
        int polygonKY[] = {450, 450, 800, 800};
        Polygon rectangleK = new Polygon(polygonKX, polygonKY, 4);
        shapes.fillPolygon(rectangleK);

        // rectangle L
        VerticesNodes polygonL1 = new VerticesNodes(250, 700, 0, 0);
        VerticesNodes polygonL2 = new VerticesNodes(250, 650, 0, 0);
        VerticesNodes polygonL3 = new VerticesNodes(450, 650, 0, 0);
        VerticesNodes polygonL4 = new VerticesNodes(450, 700, 0, 0);

        int polygonLX[] = {250, 250, 450, 450};
        int polygonLY[] = {700, 650, 650, 700};
        Polygon rectangleL = new Polygon(polygonLX, polygonLY, 4);
        shapes.fillPolygon(rectangleL);

        // rectangle M
        VerticesNodes polygonM1 = new VerticesNodes(200, 150, 0, 0);
        VerticesNodes polygonM2 = new VerticesNodes(200, 100, 0, 0);
        VerticesNodes polygonM3 = new VerticesNodes(400, 100, 0, 0);
        VerticesNodes polygonM4 = new VerticesNodes(400, 150, 0, 0);

        int polygonMX[] = {200, 200, 400, 400};
        int polygonMY[] = {150, 100, 100, 150};
        Polygon rectangleM = new Polygon(polygonMX, polygonMY, 4);
        shapes.fillPolygon(rectangleM);

        // rectangle N
        VerticesNodes polygonN1 = new VerticesNodes(300, 450, 0, 0);
        VerticesNodes polygonN2 = new VerticesNodes(250, 450, 0, 0);
        VerticesNodes polygonN3 = new VerticesNodes(250, 150, 0, 0);
        VerticesNodes polygonN4 = new VerticesNodes(300, 150, 0, 0);

        int polygonNX[] = {300, 250, 250, 300};
        int polygonNY[] = {450, 450, 150, 150};
        Polygon rectangleN = new Polygon(polygonNX, polygonNY, 4);
        shapes.fillPolygon(rectangleN);

        // rectangle O
        VerticesNodes polygonO1 = new VerticesNodes(700, 200, 0, 0);
        VerticesNodes polygonO2 = new VerticesNodes(700, 250, 0, 0);
        VerticesNodes polygonO3 = new VerticesNodes(450, 250, 0, 0);
        VerticesNodes polygonO4 = new VerticesNodes(450, 200, 0, 0);

        int polygonOX[] = {700, 700, 450, 450};
        int polygonOY[] = {200, 250, 250, 200};
        Polygon rectangleO = new Polygon(polygonOX, polygonOY, 4);
        shapes.fillPolygon(rectangleO);

        // rectangle P
        VerticesNodes polygonP1 = new VerticesNodes(550, 100, 0, 0);
        VerticesNodes polygonP2 = new VerticesNodes(550, 50, 0, 0);
        VerticesNodes polygonP3 = new VerticesNodes(800, 50, 0, 0);
        VerticesNodes polygonP4 = new VerticesNodes(800, 100, 0, 0);

        int polygonPX[] = {550, 550, 800, 800};
        int polygonPY[] = {100, 50, 50, 100};
        Polygon rectangleP = new Polygon(polygonPX, polygonPY, 4);
        shapes.fillPolygon(rectangleP);

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

            randomNode.setxValue((int)(Math.random() * ((1000 - 1) + 1)) + 1);
            randomNode.setyValue((int)(Math.random() * ((800 - 1) + 1)) + 1);

            currentNode = nearestNeighbor(randomNode, treeNodes);
            newNode[i] = attachNewNode(currentNode, randomNode, newNode[i]);

            // collision detection
            if (doesIntersect(polygonA1, polygonA2, newNode[i], currentNode) || doesIntersect(polygonA2, polygonA3, newNode[i], currentNode) ||
                    doesIntersect(polygonA4, polygonA1, newNode[i], currentNode)) { continue; }

            if (doesIntersect(polygonB1, polygonB2, newNode[i], currentNode) || doesIntersect(polygonB2, polygonB3, newNode[i], currentNode) ||
                    doesIntersect(polygonB4, polygonB1, newNode[i], currentNode)) { continue; }

            if (doesIntersect(polygonC1, polygonC2, newNode[i], currentNode) || doesIntersect(polygonC2, polygonC3, newNode[i], currentNode) ||
                    doesIntersect(polygonC4, polygonC1, newNode[i], currentNode)) { continue; }

            if (doesIntersect(polygonD1, polygonD2, newNode[i], currentNode) || doesIntersect(polygonD2, polygonD3, newNode[i], currentNode) ||
                    doesIntersect(polygonD4, polygonD1, newNode[i], currentNode)) { continue; }

            if (doesIntersect(polygonE1, polygonE2, newNode[i], currentNode) || doesIntersect(polygonE2, polygonE3, newNode[i], currentNode) ||
                    doesIntersect(polygonE4, polygonE1, newNode[i], currentNode)) { continue; }

            if (doesIntersect(polygonF1, polygonF2, newNode[i], currentNode) || doesIntersect(polygonF2, polygonF3, newNode[i], currentNode) ||
                    doesIntersect(polygonF4, polygonF1, newNode[i], currentNode)) { continue; }

            if (doesIntersect(polygonG1, polygonG2, newNode[i], currentNode) || doesIntersect(polygonG2, polygonG3, newNode[i], currentNode) ||
                    doesIntersect(polygonG4, polygonG1, newNode[i], currentNode)) { continue; }

            if (doesIntersect(polygonH1, polygonH2, newNode[i], currentNode) || doesIntersect(polygonH2, polygonH3, newNode[i], currentNode) ||
                    doesIntersect(polygonH4, polygonH1, newNode[i], currentNode)) { continue; }

            if (doesIntersect(polygonI1, polygonI2, newNode[i], currentNode) || doesIntersect(polygonI2, polygonI3, newNode[i], currentNode) ||
                    doesIntersect(polygonI4, polygonI1, newNode[i], currentNode)) { continue; }

            if (doesIntersect(polygonJ1, polygonJ2, newNode[i], currentNode) || doesIntersect(polygonJ2, polygonJ3, newNode[i], currentNode) ||
                    doesIntersect(polygonJ4, polygonJ1, newNode[i], currentNode)) { continue; }

            if (doesIntersect(polygonK1, polygonK2, newNode[i], currentNode) || doesIntersect(polygonK2, polygonK3, newNode[i], currentNode) ||
                    doesIntersect(polygonK4, polygonK1, newNode[i], currentNode)) { continue; }

            if (doesIntersect(polygonL1, polygonL2, newNode[i], currentNode) || doesIntersect(polygonL2, polygonL3, newNode[i], currentNode) ||
                    doesIntersect(polygonL4, polygonL1, newNode[i], currentNode)) { continue; }

            if (doesIntersect(polygonM1, polygonM2, newNode[i], currentNode) || doesIntersect(polygonM2, polygonM3, newNode[i], currentNode) ||
                    doesIntersect(polygonM4, polygonM1, newNode[i], currentNode)) { continue; }

            if (doesIntersect(polygonN1, polygonN2, newNode[i], currentNode) || doesIntersect(polygonN2, polygonN3, newNode[i], currentNode) ||
                    doesIntersect(polygonN4, polygonN1, newNode[i], currentNode)) { continue; }

            if (doesIntersect(polygonO1, polygonO2, newNode[i], currentNode) || doesIntersect(polygonO2, polygonO3, newNode[i], currentNode) ||
                    doesIntersect(polygonO4, polygonO1, newNode[i], currentNode)) { continue; }

            if (doesIntersect(polygonP1, polygonP2, newNode[i], currentNode) || doesIntersect(polygonP2, polygonP3, newNode[i], currentNode) ||
                    doesIntersect(polygonP4, polygonP1, newNode[i], currentNode)) { continue; }

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

