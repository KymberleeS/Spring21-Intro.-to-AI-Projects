// imports
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class PolygonEnvironment2 extends JPanel {
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

        // triangle 1 with nodes
        VerticesNodes polygonA1 = new VerticesNodes(300, 50, Math.hypot(goalNode.getyValue() - 50, goalNode.getxValue() - 300),
                0.0, 0.0);
        VerticesNodes polygonA2 = new VerticesNodes(500, 50, Math.hypot(goalNode.getyValue() - 50, goalNode.getxValue() - 500),
                0.0, 0.0);
        VerticesNodes polygonA3 = new VerticesNodes(400, 200, Math.hypot(goalNode.getyValue() - 200, goalNode.getxValue() - 400),
                0.0, 0.0);

        int triangle1X[] = {300, 500, 400};
        int triangle1Y[] = {50, 50, 200};
        Polygon polygonTriangle1 = new Polygon(triangle1X, triangle1Y, 3);
        shapes.fillPolygon(polygonTriangle1);

        // triangle 2 with nodes
        VerticesNodes polygonB1 = new VerticesNodes(300, 450, Math.hypot(goalNode.getyValue() - 450, goalNode.getxValue() - 300),
                0.0, 0.0);
        VerticesNodes polygonB2 = new VerticesNodes(500, 450, Math.hypot(goalNode.getyValue() - 450, goalNode.getxValue() - 500),
                0.0, 0.0);
        VerticesNodes polygonB3 = new VerticesNodes(400, 600, Math.hypot(goalNode.getyValue() - 600, goalNode.getxValue() - 400),
                0.0, 0.0);

        int triangle2X[] = {300, 500, 400};
        int triangle2Y[] = {450, 450, 600};
        Polygon polygonTriangle2 = new Polygon(triangle2X, triangle2Y, 3);
        shapes.fillPolygon(polygonTriangle2);

        // triangle 3 with nodes
        VerticesNodes polygonC1 = new VerticesNodes(900, 50, Math.hypot(goalNode.getyValue() - 50, goalNode.getxValue() - 900),
                0.0, 0.0);
        VerticesNodes polygonC2 = new VerticesNodes(1100, 50, Math.hypot(goalNode.getyValue() - 50, goalNode.getxValue() - 1100),
                0.0, 0.0);
        VerticesNodes polygonC3 = new VerticesNodes(1000, 200, Math.hypot(goalNode.getyValue() - 200, goalNode.getxValue() - 1000),
                0.0, 0.0);

        int triangle3X[] = {900, 1100, 1000};
        int triangle3Y[] = {50, 50, 200};
        Polygon polygonTriangle3 = new Polygon(triangle3X, triangle3Y, 3);
        shapes.fillPolygon(polygonTriangle3);

        // triangle 4 with nodes
        VerticesNodes polygonD1 = new VerticesNodes(900, 450, Math.hypot(goalNode.getyValue() - 450, goalNode.getxValue() - 900),
                0.0, 0.0);
        VerticesNodes polygonD2 = new VerticesNodes(1100, 450, Math.hypot(goalNode.getyValue() - 450, goalNode.getxValue() - 1100),
                0.0, 0.0);
        VerticesNodes polygonD3 = new VerticesNodes(1000, 600, Math.hypot(goalNode.getyValue() - 600, goalNode.getxValue() - 1000),
                0.0, 0.0);

        int triangle4X[] = {900, 1100, 1000};
        int triangle4Y[] = {450, 450, 600};
        Polygon polygonTriangle4 = new Polygon(triangle4X, triangle4Y, 3);
        shapes.fillPolygon(polygonTriangle4);

        // triangle 5 with nodes
        VerticesNodes polygonE1 = new VerticesNodes(700, 100, Math.hypot(goalNode.getyValue() - 100, goalNode.getxValue() - 700),
                0.0, 0.0);
        VerticesNodes polygonE2 = new VerticesNodes(500, 400, Math.hypot(goalNode.getyValue() - 400, goalNode.getxValue() - 500),
                0.0, 0.0);
        VerticesNodes polygonE3 = new VerticesNodes(900, 400, Math.hypot(goalNode.getyValue() - 400, goalNode.getxValue() - 900),
                0.0, 0.0);

        int triangle5X[] = {700, 500, 900};
        int triangle5Y[] = {100, 400, 400};
        Polygon polygonTriangle5 = new Polygon(triangle5X, triangle5Y, 3);
        shapes.fillPolygon(polygonTriangle5);

        // setting path color
        shapes.setColor(Color.magenta);

        // array of all nodes
        VerticesNodes[] allNodes = {startNode, polygonA1, polygonA2, polygonA3, polygonB1, polygonB2, polygonB3, polygonC1,
                polygonC2, polygonC3, polygonD1, polygonD2, polygonD3, polygonE1, polygonE2, polygonE3, goalNode};

        // array of all starting nodes for the polygon edges
        VerticesNodes[] edgeStartPoint = {polygonA1, polygonA2, polygonA3, polygonB1, polygonB2, polygonB3, polygonC1,
                polygonC2, polygonC3, polygonD1, polygonD2, polygonD3, polygonE1, polygonE2, polygonE3};

        // array of all connecting nodes for the polygon edges
        VerticesNodes[] edgeEndPoint = {polygonA2, polygonA3, polygonA1, polygonB2, polygonB3, polygonB1, polygonC2,
                polygonC3, polygonC1, polygonD2, polygonD3, polygonD1, polygonE2, polygonE3, polygonE1};

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

            if (currentNode == polygonC2 || currentNode == polygonC3 || currentNode == polygonD1 || currentNode == polygonD2 ||
                    currentNode == polygonE3) {
                currentNeighbors.add(goalNode);
            }

            if (currentNode == polygonC1 || currentNode == polygonC3) {
                currentNeighbors.remove(polygonE1);
            }

            if (currentNode == polygonE2) {
                currentNeighbors.add(polygonE3);
                currentNeighbors.remove(polygonC1);
                currentNeighbors.remove(polygonC3);
            } else if (currentNode == polygonE1) { currentNeighbors.add(polygonE3); }

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
            System.out.println("No solution found for the given budget or exit with -1");
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
                    currentNode != allNodes[i]) {
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

