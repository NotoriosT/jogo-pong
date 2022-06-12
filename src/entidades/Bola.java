package entidades;


import java.awt.*;
import java.util.Random;

public class Bola {
    private double x, y;
    private int width, hight;
    private final double velocidade=1.6;

    private double direcaox, direcaoy;

    public Bola(double x, double y) {
        this.x = x;
        this.y = y;
        this.width = 4;
        this.hight = 4;
        int aleatorio=new Random().nextInt(80);
        direcaox=Math.cos(Math.toRadians(aleatorio));
        direcaoy=Math.cos(Math.toRadians(aleatorio));
    }
    public boolean update(int telaDoGame, int cimaTela, int xPlayer, int yPlayer, int widhtPlayer,
                          int hightPlayer, double xInimigo, double yInimigo, double widhtInimigo,
                          double hightInimigo
                        ){

        if (x+(direcaox*velocidade)+width>=telaDoGame){
            direcaox*=-1;
        } else if (x+(direcaox*velocidade)<0) {
            direcaox*=-1;

        }
        if (y>=cimaTela){
            System.out.println(" ponto do inimigo!!!");
            return true;





        } else if (y<0) {
            System.out.println(" ponto do inimigo!!!");return true;

        }
        Rectangle bateu= new Rectangle((int) (x+(direcaox*velocidade)),
                (int)(y+(direcaoy*velocidade)),width, hight);
        Rectangle bateuPlayer= new Rectangle(xPlayer, yPlayer,widhtPlayer, hightPlayer);
        Rectangle bateuInimigo= new Rectangle((int)xInimigo, (int) yInimigo, (int)widhtInimigo,(int) hightInimigo);
        if (bateu.intersects(bateuPlayer)){
            direcaoy*=-1;
        } else if (bateu.intersects(bateuInimigo)) {
            direcaoy*=-1;
            
        }
        x+=direcaox*velocidade;
        y+=direcaoy*velocidade;


        return false;
    }
    public  void render(Graphics graphics){
        graphics.setColor(Color.YELLOW);
        graphics.fillRect((int) x, (int) y, width, hight);

    }

    public double getX() {
        return x;
    }
}
