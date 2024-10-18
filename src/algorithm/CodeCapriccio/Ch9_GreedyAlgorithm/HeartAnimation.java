package algorithm.CodeCapriccio.Ch9_GreedyAlgorithm;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class HeartAnimation extends JPanel {

    private static final int CANVAS_WIDTH = 640;
    private static final int CANVAS_HEIGHT = 480;
    private static final int CANVAS_CENTER_X = CANVAS_WIDTH / 2;
    private static final int CANVAS_CENTER_Y = CANVAS_HEIGHT / 2;
    private static final int IMAGE_ENLARGE = 11;
    private static final Color HEART_COLOR = new Color(255, 192, 203); // #FFC0CB

    private HashSet<Point> points = new HashSet<>();
    private HashSet<Point> edgeDiffusionPoints = new HashSet<>();
    private HashSet<Point> centerDiffusionPoints = new HashSet<>();
    private ArrayList<ArrayList<Point>> allPoints = new ArrayList<>();
    private int generateFrame;

    public HeartAnimation(int generateFrame) {
        this.generateFrame = generateFrame;
        build(2000);

        for (int frame = 0; frame < generateFrame; frame++) {
            calc(frame);
        }

        Timer timer = new Timer(160, e -> repaint());
        timer.start();
    }

    private void build(int number) {
        Random random = new Random();

        for (int i = 0; i < number; i++) {
            double t = random.nextDouble() * 2 * Math.PI;
            Point point = heartFunction(t);
            points.add(point);
        }

        ArrayList<Point> pointList = new ArrayList<>(points);
        for (Point point : pointList) {
            for (int i = 0; i < 3; i++) {
                Point newPoint = scatterInside(point, 0.05);
                edgeDiffusionPoints.add(newPoint);
            }
        }

        for (int i = 0; i < 4000; i++) {
            Point point = pointList.get(random.nextInt(pointList.size()));
            Point newPoint = scatterInside(point, 0.17);
            centerDiffusionPoints.add(newPoint);
        }
    }

    private Point heartFunction(double t) {
        int x = (int) (16 * Math.pow(Math.sin(t), 3));
        int y = (int) (-(13 * Math.cos(t) - 5 * Math.cos(2 * t) - 2 * Math.cos(3 * t) - Math.cos(4 * t)));

        x *= IMAGE_ENLARGE;
        y *= IMAGE_ENLARGE;

        x += CANVAS_CENTER_X;
        y += CANVAS_CENTER_Y;

        return new Point(x, y);
    }

    private Point scatterInside(Point point, double beta) {
        Random random = new Random();
        double ratioX = -beta * Math.log(random.nextDouble());
        double ratioY = -beta * Math.log(random.nextDouble());

        int dx = (int) (ratioX * (point.x - CANVAS_CENTER_X));
        int dy = (int) (ratioY * (point.y - CANVAS_CENTER_Y));

        return new Point(point.x - dx, point.y - dy);
    }

    private void calc(int generateFrame) {
        double ratio = 10 * curve(generateFrame / 10 * Math.PI);

        int haloRadius = (int) (4 + 6 * (1 + curve(generateFrame / 10 * Math.PI)));
        int haloNumber = (int) (3000 + 4000 * Math.abs(Math.pow(curve(generateFrame / 10 * Math.PI), 2)));

        ArrayList<Point> allPointsList = new ArrayList<>();
        HashSet<Point> heartHaloPoint = new HashSet<>();

        Random random = new Random();
        for (int i = 0; i < haloNumber; i++) {
            double t = random.nextDouble() * 2 * Math.PI;
            Point point = heartFunction(t, 11.6);
            point = shrink(point, haloRadius);
            if (!heartHaloPoint.contains(point)) {
                heartHaloPoint.add(point);
                int x = point.x + random.nextInt(29) - 14;
                int y = point.y + random.nextInt(29) - 14;
                int size = random.nextInt(3) + 1;
                allPointsList.add(new Point(x, y, size));
            }
        }

        for (Point point : points) {
            Point newPoint = calcPosition(point, ratio);
            int size = random.nextInt(3) + 1;
            allPointsList.add(newPoint.setSize(size));
        }

        for (Point point : edgeDiffusionPoints) {
            Point newPoint = calcPosition(point, ratio);
            int size = random.nextInt(2) + 1;
            allPointsList.add(newPoint.setSize(size));
        }

        for (Point point : centerDiffusionPoints) {
            Point newPoint = calcPosition(point, ratio);
            int size = random.nextInt(2) + 1;
            allPointsList.add(newPoint.setSize(size));
        }

        allPoints.add(allPointsList);
    }

    private Point calcPosition(Point point, double ratio) {
        double force = 1 / Math.pow(Math.pow(point.x - CANVAS_CENTER_X, 2) + Math.pow(point.y - CANVAS_CENTER_Y, 2), 0.520);
        Random random = new Random();
        int dx = (int) (ratio * force * (point.x - CANVAS_CENTER_X) + random.nextInt(3) - 1);
        int dy = (int) (ratio * force * (point.y - CANVAS_CENTER_Y) + random.nextInt(3) - 1);

        return new Point(point.x - dx, point.y - dy);
    }

    private Point heartFunction(double t, double shrinkRatio) {
        int x = (int) (16 * Math.pow(Math.sin(t), 3));
        int y = (int) (-(13 * Math.cos(t) - 5 * Math.cos(2 * t) - 2 * Math.cos(3 * t) - Math.cos(4 * t)));

        x *= shrinkRatio;
        y *= shrinkRatio;

        x += CANVAS_CENTER_X;
        y += CANVAS_CENTER_Y;

        return new Point(x, y);
    }

    private Point shrink(Point point, int ratio) {
        double force = -1 / Math.pow(Math.pow(point.x - CANVAS_CENTER_X, 2) + Math.pow(point.y - CANVAS_CENTER_Y, 2), 0.6);
        int dx = (int) (ratio * force * (point.x - CANVAS_CENTER_X));
        int dy = (int) (ratio * force * (point.y - CANVAS_CENTER_Y));

        return new Point(point.x - dx, point.y - dy);
    }

    private double curve(double p) {
        return 2 * (2 * Math.sin(4 * p)) / (2 * Math.PI);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int renderFrame = (int) (System.currentTimeMillis() / 160) % generateFrame;

        for (Point point : allPoints.get(renderFrame)) {
            g.setColor(HEART_COLOR);
            g.fillRect(point.x, point.y, point.size, point.size);
        }

        String text = "JMJTC";
        g.setColor(Color.black);
        g.drawString(text, CANVAS_CENTER_X-15, CANVAS_CENTER_Y);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Heart Animation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(CANVAS_WIDTH, CANVAS_HEIGHT);
        frame.setResizable(false);

        HeartAnimation heartAnimation = new HeartAnimation(20);
        frame.add(heartAnimation);

        frame.setVisible(true);
    }

    private static class Point {
        int x;
        int y;
        int size;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
            this.size = 1;
        }

        Point(int x, int y, int size) {
            this.x = x;
            this.y = y;
            this.size = size;
        }

        Point setSize(int size) {
            this.size = size;
            return this;
        }
    }
}
