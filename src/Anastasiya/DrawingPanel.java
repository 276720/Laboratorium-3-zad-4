package Anastasiya;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class DrawingPanel extends JPanel {
    private Circle circle;
    private Square square;
    private int height = 250;
    private int width = 400;
    private  double radiusCircle;
    private  double centerCircleX;
    private  double centerCircleY;
    private boolean isSquareSelected = false;
    private boolean isCircleSelected = false;
    public DrawingPanel() {
        circle = new Circle(150,50,50,Color.ORANGE);
        square = new Square(50,50,50,Color.RED);

        //(x−a)^2 + (y-b)^2 <= r^2
        radiusCircle = circle.getDiameter()/2;
        centerCircleX= circle.getX() + radiusCircle;
        centerCircleY =circle.getY() + radiusCircle;
        
        setSize(width,height);
        setBackground(Color.LIGHT_GRAY);
        setFocusable(true);

        addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (square.getX() <= e.getX() && e.getX() <= square.getX() + square.getSideLength() &&
                        square.getY() <= e.getY() && e.getY() <= square.getY() + square.getSideLength()) {
                    System.out.println("Square");
                    isSquareSelected = true;
                    isCircleSelected = false;
                } else if (Math.pow(e.getX() - centerCircleX, 2) + Math.pow(e.getY() - centerCircleY, 2) <= Math.pow(radiusCircle, 2)) {
                    System.out.println("Circle");
                    isCircleSelected = true;
                    isSquareSelected = false;
                } else {
                    isSquareSelected = false;
                    isCircleSelected = false;
                }
                repaint();
            }
        });


        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (isSquareSelected) {
                    moveSquare(e.getKeyCode());
                } else if (isCircleSelected) {
                    moveCircle(e.getKeyCode());
                }
                repaint();
            }
        });
    }
    private void moveSquare(int keyCode) {
        switch (keyCode) {
            case KeyEvent.VK_UP:
                square.move(0, -10);
                break;
            case KeyEvent.VK_DOWN:
                square.move(0, 10);
                break;
            case KeyEvent.VK_LEFT:
                square.move(-10, 0);
                break;
            case KeyEvent.VK_RIGHT:
                square.move(10, 0);
                break;
        }
    }

    private void moveCircle(int keyCode) {
        switch (keyCode) {
            case KeyEvent.VK_UP:
                circle.move(0, -10);
                break;
            case KeyEvent.VK_DOWN:
                circle.move(0, 10);
                break;
            case KeyEvent.VK_LEFT:
                circle.move(-10, 0);
                break;
            case KeyEvent.VK_RIGHT:
                circle.move(10, 0);
                break;
        }
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setColor(square.getColor());
        g2d.fillRect(square.getX(), square.getY(), square.getSideLength(), square.getSideLength());
        g2d.setColor(circle.getColor());
        g2d.fillOval(circle.getX(), circle.getY(), circle.getDiameter(), circle.getDiameter());
        g2d.dispose();
    }
}
