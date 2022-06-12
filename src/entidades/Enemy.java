package entidades;

import java.awt.*;

public class Enemy {
    private double x;
    private double y;
    private int width;
    private  int hight;

    public Enemy(double x, double y) {
        this.x = x;
        this.y = y;
        width = 40;
        hight = 5;
    }

    public void update(double valor){
        x+=(valor-x-6)*0.3;

    }

    public void  render(Graphics graphics){
        graphics.setColor(Color.RED);
        graphics.fillRect((int)x,(int)y,width, hight);

    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHight() {
        return hight;
    }
}
