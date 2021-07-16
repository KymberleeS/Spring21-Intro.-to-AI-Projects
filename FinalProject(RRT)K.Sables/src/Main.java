import javax.swing.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        int environmentChoice = 0;

        while (environmentChoice != 10) {
            // creating a menu for the users to select and environment or exit
            System.out.println("Please Select an Environment (1-11):");
            System.out.println("1. Simple Visualization - No Obstacles 1" + "\n2. Simple Visualization - No Obstacles 2" +
                               "\n3. Simple Visualization - No Obstacles 3" + "\n4. Simple Visualization - Assignment 1 Environment" +
                               "\n5. Simple Visualization - Assignment 2 Environment" + "\n6. Testing Phase - Random Start and Goal" +
                               "\n7. Testing Phase - 100 x 100 Pixels, 10% (1 / 10) Obstacles (random shape)" +
                               "\n8. Testing Phase - 200 x 200 Pixels, 20% (5 / 25) Obstacles (non-traditional polygons)" +
                               "\n9. Testing Phase - 300 x 300 Pixels, 30% (15 / 50) Obstacles (maze)" + "\n10. Exit");
            System.out.println("");

            // storing user input in an environment choice variable
            environmentChoice = userInput.nextInt();

            // creating the switch case to correspond with the menu
            switch(environmentChoice) {
                // simple visualization - no obstacles 1 (standard start and goal)
                case 1:
                    NoObstacles noObstacles = new NoObstacles();

                    JFrame frame = new JFrame();
                    frame.setSize(1500, 700);
                    frame.setLocationRelativeTo(null);
                    frame.setTitle("RRT: Implementation Visualization");

                    frame.setContentPane(noObstacles);

                    frame.setVisible(true);
                    frame.invalidate();
                    break;

                // simple visualization - no obstacles 2 (start and 3 goals)
                case 2:
                    NoObstacles2 noObstacles2 = new NoObstacles2();

                    JFrame frame2 = new JFrame();
                    frame2.setSize(1500, 700);
                    frame2.setLocationRelativeTo(null);
                    frame2.setTitle("RRT: Implementation Visualization");

                    frame2.setContentPane(noObstacles2);

                    frame2.setVisible(true);
                    frame2.invalidate();
                    break;

                // simple visualization - no obstacles 3 (start and goal near each other)
                case 3:
                    NoObstacles3 noObstacles3 = new NoObstacles3();

                    JFrame frame3 = new JFrame();
                    frame3.setSize(1500, 700);
                    frame3.setLocationRelativeTo(null);
                    frame3.setTitle("RRT: Implementation Visualization");

                    frame3.setContentPane(noObstacles3);

                    frame3.setVisible(true);
                    frame3.invalidate();
                    break;

                // simple visualization - assignment 1 environment
                case 4:
                    PolygonEnvironment environment = new PolygonEnvironment();

                    JFrame frame4 = new JFrame();
                    frame4.setSize(1500, 700);
                    frame4.setLocationRelativeTo(null);
                    frame4.setTitle("RRT: Implementation Visualization");

                    frame4.setContentPane(environment);

                    frame4.setVisible(true);
                    frame4.invalidate();
                    break;

                // simple visualization - assignment 2 environment
                case 5:
                    PolygonEnvironment2 environment2 = new PolygonEnvironment2();

                    JFrame frame5 = new JFrame();
                    frame5.setSize(1500, 700);
                    frame5.setLocationRelativeTo(null);
                    frame5.setTitle("RRT: Implementation Visualization");

                    frame5.setContentPane(environment2);

                    frame5.setVisible(true);
                    frame5.invalidate();
                    break;

                // testing phase - random start and goal
                case 6:
                    TestingEnvironment testingEnvironment = new TestingEnvironment();

                    JFrame frame6 = new JFrame();
                    frame6.setSize(1500, 700);
                    frame6.setLocationRelativeTo(null);
                    frame6.setTitle("RRT: Implementation Visualization");

                    frame6.setContentPane(testingEnvironment);

                    frame6.setVisible(true);
                    frame6.invalidate();
                    break;

                // testing phase - 100 x 100 pixels, 10% obstacles
                case 7:
                    TestingEnvironment2 testingEnvironment2 = new TestingEnvironment2();

                    JFrame frame7 = new JFrame();
                    frame7.setSize(800, 600);
                    frame7.setLocationRelativeTo(null);
                    frame7.setTitle("RRT: Implementation Visualization");

                    frame7.setContentPane(testingEnvironment2);

                    frame7.setVisible(true);
                    frame7.invalidate();
                    break;

                // testing phase - 200 x 200 pixels, 20% obstacles
                case 8:
                    TestingEnvironment3 testingEnvironment3 = new TestingEnvironment3();

                    JFrame frame8 = new JFrame();
                    frame8.setSize(900, 700);
                    frame8.setLocationRelativeTo(null);
                    frame8.setTitle("RRT: Implementation Visualization");

                    frame8.setContentPane(testingEnvironment3);

                    frame8.setVisible(true);
                    frame8.invalidate();
                    break;

                // testing phase - 300 x 300 pixels, 30% obstacles
                case 9:
                    TestingEnvironment4 testingEnvironment4 = new TestingEnvironment4();

                    JFrame frame9 = new JFrame();
                    frame9.setSize(1000, 800);
                    frame9.setLocationRelativeTo(null);
                    frame9.setTitle("RRT: Implementation Visualization");

                    frame9.setContentPane(testingEnvironment4);

                    frame9.setVisible(true);
                    frame9.invalidate();
                    break;

                // exits the application when the user chooses this option
                case 10:
                    System.out.println("Stopping Application . . .");
                    break;

                // shows user a warning message if their input is invalid
                default:
                    System.out.println("invalid choice, please try again");
                    break;
            }
        }

        userInput.close();
        System.exit(0);
    }
}

