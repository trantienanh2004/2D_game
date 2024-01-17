/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game2d;

import entity.Player;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

/**
 *
 * @author HP
 */
public class gamePanel extends JPanel implements Runnable {   // has all the qualities of the built-in class called JPanel
   //SCREEN SETTINGS                         //"runnable" Allows thread to run. it also implements the @override and run functions below
    public final int originalTileSize = 16; //tile size 16x16
    public final int scale = 3;
    public final int tileSize = scale * originalTileSize; //48 x 48 tile size.
    public final int maxScreenCol = 16; //column is horizontal: think of a collapse greek building.
    public final int maxScreenRow = 12; //vertical
    //this will make a 16x12 rectangle as screen size.
    public final int ScreenHeight = tileSize * maxScreenRow; // 576 pixels
    public final int ScreenWidth = tileSize * maxScreenCol; //768 pixels

    int FPS = 60;

    keyHandler keyH = new keyHandler(); // implement KeyHandler.
    Thread gameThread;
    Player player = new Player(this, keyH);
    //player stuff
    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 4;


    public gamePanel() {
        this.setPreferredSize(new Dimension(ScreenWidth, ScreenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH); //game panel can now sense key input.
        this.setFocusable(true); //the game panel can now "focus" on key input
    }
    public void startGameThread() {
        gameThread = new Thread(this); //implements the thread into the function.
        gameThread.start(); // thread begins
    }

    @Override
    public void run() {
        double drawInterval = 1000000000/FPS;
        
        double nextDrawTime = System.nanoTime() + drawInterval;
        //we will use this to make a game loop
         while (gameThread != null) { // while the game thread exists, the while loop will keep going.

             // in this loop we will do 2 things:
             //1: UPDATE information (and frames).
             update(); // update
             //2: DRAW: draw the screen, and the tiles, and other stuff.
             repaint();//paint component

             try {
                 double remainingTime = nextDrawTime - System.nanoTime();
                 remainingTime = remainingTime/1000000;

                 if (remainingTime < 0) {
                     remainingTime = 0;
                 }
                 Thread.sleep((long)remainingTime);

                 nextDrawTime +=  drawInterval;

             } catch (InterruptedException e) {
                 e.printStackTrace();
             }

         }
    }
    public void update() {
        player.update();

    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
player.drow(g2);
       

        g2.dispose(); //we don't need to do this, but it saves memory.
    }
}
