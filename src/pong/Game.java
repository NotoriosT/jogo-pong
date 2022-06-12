package pong;

import entidades.Bola;
import entidades.Enemy;
import entidades.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Game extends Canvas implements Runnable, KeyListener {
    private final int WIGTH=240;
    private  final  int HIGHT=120;
    private  int scala=3;
   private Player player;
   private Enemy enemy;
   private Bola bola;

   private BufferedImage layer=new BufferedImage(WIGTH,HIGHT,BufferedImage.TYPE_INT_RGB);


    private JFrame jFrame=new JFrame();


    public Game() {

        setPreferredSize(new Dimension(WIGTH*scala, HIGHT*scala));
       jFrame.setResizable(false);
       jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       jFrame.add(this);
       jFrame.pack();
        jFrame.setLocale(null);
        jFrame.setVisible(true);
        player=new Player(100, 120-5);
        enemy=new Enemy(100,0);
        bola=new Bola(100,HIGHT/2-1);
        this.addKeyListener(this);
        new Thread(this).start();


    }
public      void interr(Game game){
        new Thread(game).interrupt();
    }

    public void tick(){
        player.update();
        enemy.update(bola.getX());

if (bola.update(WIGTH, HIGHT, player.getX(), player.getY(), player.getWidth(), player.getHight(),
                enemy.getX(), enemy.getY(), enemy.getWidth(), enemy.getHight())){

    player=new Player(100, 120-5);
    enemy=new Enemy(100,0);
    bola=new Bola(100,HIGHT/2-1);
    render();
                }
    }
    public  void render(){

        BufferStrategy bufferStrategy=this.getBufferStrategy();
        if (bufferStrategy==null){
            this.createBufferStrategy(3);
            return;
        }

        Graphics graphics=layer.getGraphics();



        graphics.setColor(Color.black);
        graphics.fillRect(0,0,WIGTH,HIGHT);
        player.render(graphics);
        enemy.render(graphics);
        bola.render(graphics);
        graphics=bufferStrategy.getDrawGraphics();
        graphics.drawImage(layer,0,0,WIGTH*scala, HIGHT*scala, null);
        bufferStrategy.show();

    }

    @Override
    public void run() {
        while (true){
            tick();
            render();
            try {
                Thread.sleep(1000/60);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode()==KeyEvent.VK_RIGHT){

            player.movimentacao(KeyEvent.VK_RIGHT, true);
        } if(e.getKeyCode() == KeyEvent.VK_LEFT){
            player.movimentacao(KeyEvent.VK_LEFT, true);
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode()==KeyEvent.VK_RIGHT){
            player.movimentacao(KeyEvent.VK_RIGHT, false);

        }else if(e.getKeyCode() == KeyEvent.VK_LEFT){

            player.movimentacao(KeyEvent.VK_LEFT, false);
        }

    }
}
