package Anastasiya;
import java.awt.*;

public class Square{
    private int x;
    private int y;
    private int sideLength;
    private Color color;

    public Square(int x, int y, int sideLength, Color color) {
        this.x = x;
        this.y = y;
        this.sideLength = sideLength;
        this.color = color;
    }

    public void move(int dx, int dy) {
        x += dx;
        y += dy;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getSideLength() {
        return sideLength;
    }

    public Color getColor() {
        return color;
    }
}
