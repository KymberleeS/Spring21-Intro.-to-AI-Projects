import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(1500, 700);
        frame.setLocationRelativeTo(null);
        frame.setTitle("Polygon Obstacle Course");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        PolygonEnvironment environment = new PolygonEnvironment();
        frame.setContentPane(environment);

        frame.setVisible(true);
        frame.invalidate();
    }
}
