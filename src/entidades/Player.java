package entidades;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Player {
    int x, y;
    boolean right, left;
    private int width;
    private int hight;
    public void update(){
        if (right){
            x++;
        }  if (left) {
            x--;

        }

    }

    public Player(int x, int y) {
        this.x = x;
        this.y = y;
        hight=5;
        width=30;
    }

    public void render(Graphics graphics){
graphics.setColor(Color.BLUE);
graphics.fillRect(x, y,width,hight);
    }

    public void movimentacao(int vkLeft, boolean valor) {
        if (vkLeft== KeyEvent.VK_RIGHT){;
           right = valor;
        }else
        if (vkLeft==KeyEvent.VK_LEFT){
           left=valor;
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHight() {
        return hight;
    }
}
