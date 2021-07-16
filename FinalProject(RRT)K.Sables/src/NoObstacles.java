// imports
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class NoObstacles extends JPanel {
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
        VerticesNodes startNode = new VerticesNodes(250, 525, 0, 0);
        shapes.setColor(Color.red);
        shapes.fillOval(250, 500, 20, 20);

        int startX[] = {220, 220, 320, 320};
        int startY[] = {475, 575, 575, 475};
        Polygon startArea = new Polygon(startX, startY, 4);
        shapes.fillPolygon(startArea);

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
}



