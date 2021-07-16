// imports
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class PolygonEnvironment extends JPanel {
    public double budget = 0.0;

    @Override
    public void paintComponent(Graphics polygon) {
        // establishing the environment
        Graphics2D shapes = (Graphics2D) polygon;
        shapes.setStroke(new BasicStroke(3));

        // goal point with node
        VerticesNodes goalNode = new VerticesNodes(1230, 55, Math.hypot(1230 - 1230, 55 - 55), 0.0, 0.0);
        shapes.setColor(Color.blue);
        shapes.fillOval(1230, 55, 20, 20);

        // start point with node
        VerticesNodes startNode = new VerticesNodes(250, 525, Math.hypot(goalNode.getyValue() - 525, goalNode.getxValue() - 250),
                0.0, 0.0);
        shapes.setColor(Color.red);
        shapes.fillOval(250, 525, 20, 20);

        // set shape fill color
        shapes.setColor(Color.gray);

        // polygon 1 - Pentagon with nodes
        VerticesNodes polygonA1 = new VerticesNodes(250, 175, Math.hypot(goalNode.getyValue() - 175, goalNode.getxValue() - 250),
                0.0, 0.0);
        VerticesNodes polygonA2 = new VerticesNodes(410, 40, Math.hypot(goalNode.getyValue() - 40, goalNode.getxValue() - 410),
                0.0, 0.0);
        VerticesNodes polygonA3 = new VerticesNodes(550, 150, Math.hypot(goalNode.getyValue() - 150, goalNode.getxValue() - 550),
                0.0, 0.0);
        VerticesNodes polygonA4 = new VerticesNodes(470, 360, Math.hypot(goalNode.getyValue() - 360, goalNode.getxValue() - 470),
                0.0, 0.0);
        VerticesNodes polygonA5 = new VerticesNodes(310, 330, Math.hypot(goalNode.getyValue() - 330, goalNode.getxValue() - 310),
                0.0, 0.0);

        int pentagonX[] = {250, 410, 550, 470, 310};
        int pentagonY[] = {175, 40, 150, 360, 330};
        Polygon polygonPentagon = new Polygon(pentagonX, pentagonY, 5);
        shapes.fillPolygon(polygonPentagon);

        // polygon 2 - Rectangle 1 with nodes
        VerticesNodes polygonB1 = new VerticesNodes(330, 450, Math.hypot(goalNode.getyValue() - 450, goalNode.getxValue() - 330),
                0.0, 0.0);
        VerticesNodes polygonB2 = new VerticesNodes(330, 600, Math.hypot(goalNode.getyValue() - 600, goalNode.getxValue() - 330),
                0.0, 0.0);
        VerticesNodes polygonB3 = new VerticesNodes(800, 600, Math.hypot(goalNode.getyValue() - 600, goalNode.getxValue() - 800),
                0.0, 0.0);
        VerticesNodes polygonB4 = new VerticesNodes(800, 450, Math.hypot(goalNode.getyValue() - 450, goalNode.getxValue() - 800),
                0.0, 0.0);

        int rectangle1X[] = {330, 330, 800, 800};
        int rectangle1Y[] = {450, 600, 600, 450};
        Polygon polygonRectangle1 = new Polygon(rectangle1X, rectangle1Y, 4);
        shapes.fillPolygon(polygonRectangle1);

        // polygon 3 - Triangle 1 with nodes
        VerticesNodes polygonC1 = new VerticesNodes(600, 130, Math.hypot(goalNode.getyValue() - 130, goalNode.getxValue() - 600),
                0.0, 0.0);
        VerticesNodes polygonC2 = new VerticesNodes(550, 360, Math.hypot(goalNode.getyValue() - 360, goalNode.getxValue() - 550),
                0.0, 0.0);
        VerticesNodes polygonC3 = new VerticesNodes(650, 360, Math.hypot(goalNode.getyValue() - 360, goalNode.getxValue() - 650),
                0.0, 0.0);

        int triangle1X[] = {600, 550, 650};
        int triangle1Y[] = {130, 360, 360};
        Polygon polygonTriangle1 = new Polygon(triangle1X, triangle1Y, 3);
        shapes.fillPolygon(polygonTriangle1);

        // polygon 4 - Triangle 2 with nodes
        VerticesNodes polygonD1 = new VerticesNodes(870, 525, Math.hypot(goalNode.getyValue() - 525, goalNode.getxValue() - 870),
                0.0, 0.0);
        VerticesNodes polygonD2 = new VerticesNodes(930, 400, Math.hypot(goalNode.getyValue() - 400, goalNode.getxValue() - 930),
                0.0, 0.0);
        VerticesNodes polygonD3 = new VerticesNodes(800, 300, Math.hypot(goalNode.getyValue() - 300, goalNode.getxValue() - 800),
                0.0, 0.0);

        int triangle2X[] = {870, 930, 800};
        int triangle2Y[] = {525, 400, 300};
        Polygon polygonTriangle2 = new Polygon(triangle2X, triangle2Y, 3);
        shapes.fillPolygon(polygonTriangle2);

        // polygon 5 - Trapezoid 1 with nodes
        VerticesNodes polygonE1 = new VerticesNodes(660, 220, Math.hypot(goalNode.getyValue() - 220, goalNode.getxValue() - 660),
                0.0, 0.0);
        VerticesNodes polygonE2 = new VerticesNodes(850, 120, Math.hypot(goalNode.getyValue() - 120, goalNode.getxValue() - 850),
                0.0, 0.0);
        VerticesNodes polygonE3 = new VerticesNodes(800, 40, Math.hypot(goalNode.getyValue() - 40, goalNode.getxValue() - 800),
                0.0, 0.0);
        VerticesNodes polygonE4 = new VerticesNodes(690, 50, Math.hypot(goalNode.getyValue() - 50, goalNode.getxValue() - 690),
                0.0, 0.0);

        int trapezoid1X[] = {660, 850, 800, 690};
        int trapzoid1Y[] = {220, 120, 40, 50};
        Polygon polygonTrapezoid1 = new Polygon(trapezoid1X, trapzoid1Y, 4);
        shapes.fillPolygon(polygonTrapezoid1);

        // polygon 6 - Rectangle 2 with nodes
        VerticesNodes polygonF1 = new VerticesNodes(880, 50, Math.hypot(goalNode.getyValue() - 50, goalNode.getxValue() - 880),
                0.0, 0.0);
        VerticesNodes polygonF2 = new VerticesNodes(880, 330, Math.hypot(goalNode.getyValue() - 330, goalNode.getxValue() - 850),
                0.0, 0.0);
        VerticesNodes polygonF3 = new VerticesNodes(1050, 330, Math.hypot(goalNode.getyValue() - 330, goalNode.getxValue() - 1050),
                0.0, 0.0);
        VerticesNodes polygonF4 = new VerticesNodes(1050, 50, Math.hypot(goalNode.getyValue() - 50, goalNode.getxValue() - 1050),
                0.0, 0.0);

        int rectangle2X[] = {880, 880, 1050, 1050};
        int rectangle2Y[] = {50, 330, 330, 50};
        Polygon polygonRectangle2 = new Polygon(rectangle2X, rectangle2Y, 4);
        shapes.fillPolygon(polygonRectangle2);

        // polygon 7 - Trapezoid 2 with nodes
        VerticesNodes polygonG1 = new VerticesNodes(1070, 100, Math.hypot(goalNode.getyValue() - 100, goalNode.getxValue() - 1070),
                0.0, 0.0);
        VerticesNodes polygonG2 = new VerticesNodes(1130, 50, Math.hypot(goalNode.getyValue() - 50, goalNode.getxValue() - 1130),
                0.0, 0.0);
        VerticesNodes polygonG3 = new VerticesNodes(1200, 110, Math.hypot(goalNode.getyValue() - 110, goalNode.getxValue() - 1200),
                0.0, 0.0);
        VerticesNodes polygonG4 = new VerticesNodes(1170, 340, Math.hypot(goalNode.getyValue() - 340, goalNode.getxValue() - 1170),
                0.0, 0.0);

        int trapezoid2X[] = {1070, 1130, 1200, 1170};
        int trapzoid2Y[] = {100, 50, 110, 340};
        Polygon polygonTrapezoid2 = new Polygon(trapezoid2X, trapzoid2Y, 4);
        shapes.fillPolygon(polygonTrapezoid2);

        // polygon 8 - Hexagon with nodes
        VerticesNodes polygonH1 = new VerticesNodes(1100, 330, Math.hypot(goalNode.getyValue() - 330, goalNode.getxValue() - 1100),
                0.0, 0.0);
        VerticesNodes polygonH2 = new VerticesNodes(1170, 430, Math.hypot(goalNode.getyValue() - 430, goalNode.getxValue() - 1170),
                0.0, 0.0);
        VerticesNodes polygonH3 = new VerticesNodes(1170, 535, Math.hypot(goalNode.getyValue() - 535, goalNode.getxValue() - 1170),
                0.0, 0.0);
        VerticesNodes polygonH4 = new VerticesNodes(1090, 600, Math.hypot(goalNode.getyValue() - 600, goalNode.getxValue() - 1090),
                0.0, 0.0);
        VerticesNodes polygonH5 = new VerticesNodes(1000, 535, Math.hypot(goalNode.getyValue() - 535, goalNode.getxValue() - 1000),
                0.0, 0.0);
        VerticesNodes polygonH6 = new VerticesNodes(1000, 430, Math.hypot(goalNode.getyValue() - 430, goalNode.getxValue() - 1000),
                0.0, 0.0);

        int hexagonX[] = {1100, 1170, 1170, 1090, 1000, 1000};
        int hexagonY[] ={330, 430, 535, 600, 535, 430};
        Polygon polygonHexagon = new Polygon(hexagonX, hexagonY, 6);
        shapes.fillPolygon(polygonHexagon);

        // setting path color
        shapes.setColor(Color.magenta);

        // array of all nodes
        VerticesNodes[] allNodes = {startNode, polygonA1, polygonA2, polygonA3, polygonA4, polygonA5, polygonB1, polygonB2, polygonB3, polygonB4, polygonC1,
                polygonC2, polygonC3, polygonD1, polygonD2, polygonD3, polygonE1, polygonE2, polygonE3, polygonE4, polygonF1, polygonF2,
                polygonF3, polygonF4, polygonG1, polygonG2, polygonG3, polygonG4, polygonH1, polygonH2, polygonH3, polygonH4, polygonH5,
                polygonH6, goalNode};

        // array of all starting nodes for the polygon edges
        VerticesNodes[] edgeStartPoint = {polygonA1, polygonA2, polygonA3, polygonA4, polygonA5, polygonB1, polygonB2, polygonB3, polygonB4, polygonC1,
                polygonC2, polygonC3, polygonD1, polygonD2, polygonD3, polygonE1, polygonE2, polygonE3, polygonE4, polygonF1,
                polygonF2, polygonF3, polygonF4, polygonG1, polygonG2, polygonG3, polygonG4, polygonH1, polygonH2, polygonH3,
                polygonH4, polygonH5, polygonH6};

        // array of all connecting nodes for the polygon edges
        VerticesNodes[] edgeEndPoint = {polygonA2, polygonA3, polygonA4, polygonA5, polygonA1, polygonB2, polygonB3, polygonB4, polygonB1, polygonC2,
                polygonC3, polygonC1, polygonD2, polygonD3, polygonD1, polygonE2, polygonE3, polygonE4, polygonE1, polygonF2,
                polygonF3, polygonF4, polygonF1, polygonG2, polygonG3, polygonG4, polygonG1, polygonH2, polygonH3, polygonH4,
                polygonH5, polygonH6, polygonH1};

        // setting all nodes' total scores u(n) based on budget
        for (int i = 0; i < allNodes.length; i++) {
            allNodes[i].setStartToNode(pathCost(startNode, allNodes[i]));
            allNodes[i].setTotalScore((budget - allNodes[i].getStartToNode()) / allNodes[i].getEstimatedNodeCost());
        }

//===============================================A* WITH BUDGET IMPLEMENTATION START===============================================
        // implementing the A* algorithm
        PriorityQueue<VerticesNodes> unvisitedNodes = new PriorityQueue<>(compareNodes); // OPEN
        PriorityQueue<VerticesNodes> visitedNodes = new PriorityQueue<>(compareNodes); // CLOSED
        ArrayList<VerticesNodes> solutionPathNodes = new ArrayList<>();
        ArrayList<VerticesNodes> currentNeighbors;
        VerticesNodes currentNode = null;
        double currentCost;

        // (initialization) adding the start node to the unvisited nodes queue
        unvisitedNodes.add(startNode);
        solutionPathNodes.add(startNode);

        while (unvisitedNodes.size() != 0) {
            // removing the current node with the lowest totalScore from the unvisited nodes queue
            currentNode = unvisitedNodes.remove();

            if (currentNode == goalNode) {
                if (!solutionPathNodes.contains(goalNode)) {
                    solutionPathNodes.add(goalNode);
                }
                break;
            }

            // finding the current node's neighbors (had to account for some neighbor nodes; findNeighbors() didn't include everything)
            currentNeighbors = findNeighbors(currentNode, allNodes, edgeStartPoint, edgeEndPoint);
            for (int i = 0; i < currentNeighbors.size(); i++) {
                if (isVisited(visitedNodes, currentNeighbors.get(i))) {
                    currentNeighbors.remove(i);
                }
            }

            if (currentNode == polygonG2 || currentNode == polygonG3 || currentNode == polygonG4) {
                currentNeighbors.add(goalNode);
            }

            if (currentNode == polygonF1) {
                currentNeighbors.add(polygonF4);
            } else if (currentNode == polygonF4) { currentNeighbors.add(polygonF1); }

            if (currentNode == polygonF2) {
                currentNeighbors.add(polygonF3);
            } else if (currentNode == polygonF3) { currentNeighbors.add(polygonF2); }

            // for each neighbor; calculating path costs after finding current node's neighbors
            for (int i = 0; i < currentNeighbors.size(); i++) {
                if (unvisitedNodes.contains(currentNeighbors.get(i)) || visitedNodes.contains(currentNeighbors.get(i)) &&
                        currentNeighbors.get(i).getStartToNode() <= (currentNode.getStartToNode() + pathCost(currentNode, currentNeighbors.get(i)))) {
                    continue;
                }

                currentNeighbors.get(i).setStartToNode(currentNode.getStartToNode() + pathCost(currentNode, currentNeighbors.get(i)));

                if (currentNeighbors.get(i).getStartToNode() >= budget) {
                    continue;
                }

                if (unvisitedNodes.contains(currentNeighbors.get(i))) {
                    currentNeighbors.get(i).setTotalScore(currentNeighbors.get(i).getStartToNode());
                } else {
                    unvisitedNodes.add(currentNeighbors.get(i));
                }

            }
            visitedNodes.add(currentNode);
            solutionPathNodes.add(currentNode);
        }
//================================================A* WITH BUDGET IMPLEMENTATION END================================================
        // drawing the path listed in the solution nodes
        if (currentNode == goalNode) {
            for (int i = 0; i < solutionPathNodes.size() - 1; i++) {
                shapes.drawLine(solutionPathNodes.get(i).getxValue(), solutionPathNodes.get(i).getyValue(),
                        solutionPathNodes.get(i+1).getxValue(), solutionPathNodes.get(i+1).getyValue());
            }
        } else {
            System.out.println("No solution found for the given budget.");
        }

    }

    // comparator for priority queue; compares a node's estimated cost to goal plus its total score
    Comparator<VerticesNodes> compareNodes = new Comparator<VerticesNodes>() {
        @Override
        public int compare(VerticesNodes o1, VerticesNodes o2) {
            if (o1.getTotalScore() > o2.getTotalScore()) {
                return -1;
            } else {
                return 1;
            }
        }
    };

    // an amount the user enters, which adds a constraint to the A* algorithm
    public double maxBudget() {
        Scanner maxBudgetInput = new Scanner(System.in);
        System.out.println("Please enter a budget. To exit, enter -1");

        double userBudget = maxBudgetInput.nextDouble();

        return userBudget;
    }

    // finds a node's neighbors without intersecting the polygons' edges
    public ArrayList<VerticesNodes> findNeighbors(VerticesNodes currentNode, VerticesNodes[] allNodes, VerticesNodes[] edges1,
                                                  VerticesNodes[] edges2) {

        // if the nodes don't intersect with all polygons' edges simultaneously and the node is not itself, add as a neighbor
        ArrayList<VerticesNodes> currentNeighbors = new ArrayList<>();
        for (int i = 0; i < edges1.length; i++) {
            if (!(doesIntersect(currentNode, allNodes[i], edges1[0], edges2[0])) && !(doesIntersect(currentNode, allNodes[i], edges1[1], edges2[1])) &&
                    !(doesIntersect(currentNode, allNodes[i], edges1[2], edges2[2])) && !(doesIntersect(currentNode, allNodes[i], edges1[3], edges2[3])) &&
                    !(doesIntersect(currentNode, allNodes[i], edges1[4], edges2[4])) && !(doesIntersect(currentNode, allNodes[i], edges1[5], edges2[5])) &&
                    !(doesIntersect(currentNode, allNodes[i], edges1[6], edges2[6])) && !(doesIntersect(currentNode, allNodes[i], edges1[7], edges2[7])) &&
                    !(doesIntersect(currentNode, allNodes[i], edges1[8], edges2[8])) && !(doesIntersect(currentNode, allNodes[i], edges1[9], edges2[9])) &&
                    !(doesIntersect(currentNode, allNodes[i], edges1[10], edges2[10])) && !(doesIntersect(currentNode, allNodes[i], edges1[11], edges2[11])) &&
                    !(doesIntersect(currentNode, allNodes[i], edges1[12], edges2[12])) && !(doesIntersect(currentNode, allNodes[i], edges1[13], edges2[13])) &&
                    !(doesIntersect(currentNode, allNodes[i], edges1[14], edges2[14])) && !(doesIntersect(currentNode, allNodes[i], edges1[15], edges2[15])) &&
                    !(doesIntersect(currentNode, allNodes[i], edges1[16], edges2[16])) && !(doesIntersect(currentNode, allNodes[i], edges1[17], edges2[17])) &&
                    !(doesIntersect(currentNode, allNodes[i], edges1[18], edges2[18])) && !(doesIntersect(currentNode, allNodes[i], edges1[19], edges2[19])) &&
                    !(doesIntersect(currentNode, allNodes[i], edges1[20], edges2[20])) && !(doesIntersect(currentNode, allNodes[i], edges1[21], edges2[21])) &&
                    !(doesIntersect(currentNode, allNodes[i], edges1[22], edges2[22])) && !(doesIntersect(currentNode, allNodes[i], edges1[23], edges2[23])) &&
                    !(doesIntersect(currentNode, allNodes[i], edges1[24], edges2[24])) && !(doesIntersect(currentNode, allNodes[i], edges1[25], edges2[25])) &&
                    !(doesIntersect(currentNode, allNodes[i], edges1[26], edges2[26])) && !(doesIntersect(currentNode, allNodes[i], edges1[27], edges2[27])) &&
                    !(doesIntersect(currentNode, allNodes[i], edges1[28], edges2[28])) && !(doesIntersect(currentNode, allNodes[i], edges1[29], edges2[29])) &&
                    !(doesIntersect(currentNode, allNodes[i], edges1[30], edges2[30])) && !(doesIntersect(currentNode, allNodes[i], edges1[31], edges2[31])) &&
                    !(doesIntersect(currentNode, allNodes[i], edges1[32], edges2[32])) && currentNode != allNodes[i]) {
                currentNeighbors.add(allNodes[i]);
            }
        }
        return currentNeighbors;
    }

    // method that determines where the lines are facing (helper for findNeighbors)
    public int position(VerticesNodes x, VerticesNodes y, VerticesNodes z) {
        int result = (y.getyValue() - x.getyValue()) * (z.getxValue() - y.getxValue()) - (y.getxValue() - x.getxValue()) * (z.getyValue() - y.getyValue());
        if (result == 0) {
            return 0;
        }
        return (result > 0) ? 1 : 2;
    }

    // makes sure that the lines do not intersect the polygon edges (helper for findNeighbors)
    public boolean doesIntersect(VerticesNodes x1, VerticesNodes y1, VerticesNodes x2, VerticesNodes y2) {
        int case1 = position(x1, y1, x2);
        int case2 = position(x1, y1, y2);
        int case3 = position(x2, y2, x1);
        int case4 = position(x2, y2, y1);

        // ensures that meeting at the vertex does not count as intersecting
        if (case1 != case2 && case3 != case4) {
            if (x1 == y1 || x1 == y2 || x1 == x2 || x2 == y1 || x2 == y2 || y1 == y2) {
                return false;
            }
            return true;
        }

        /* calculating the distance between points inside the polygons. If the distance equals the path between two points, then the path is
           intersecting the polygons */
        double distance = Math.hypot(y1.getyValue() - x1.getyValue(), y1.getxValue() - x1.getxValue());
        if (distance == 301.0398644698074 || distance == 287.4456470360962 || distance == 325.5764119219941 || distance == 306.75723300355935 ||
                distance == 300.0 || distance == 493.3558553417604 || distance == 228.0350850198276 || distance == 174.64249196572982 ||
                distance == 327.566787083184 || distance == 130.38404810405297 || distance == 292.7456233660889 || distance == 228.08989455914087 ||
                distance == 270.1851217221259 || distance == 216.6217902243447 || distance == 170.0 || distance == 187.88294228055935 ||
                distance == 199.81241202688085 || distance == 192.35384061671346) {
            return true;
        }
        return false;
    }

    // method that calculates the cost from the current node to the destination cost (not including the estimated node cost)
    public double pathCost(VerticesNodes currentNode, VerticesNodes destinationNode) {
        return Math.hypot(destinationNode.getyValue() - currentNode.getyValue(), destinationNode.getxValue() - currentNode.getxValue());
    }

    // method that detects if a node has been visited
    public boolean isVisited(PriorityQueue visitedNodes, VerticesNodes node) {
        if (visitedNodes.contains(node)) {
            return true;
        }
        return false;
    }
}
