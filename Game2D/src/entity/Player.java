/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import game2d.gamePanel;
import game2d.keyHandler;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author HP
 */
public class Player extends entity {

    gamePanel gp;
    keyHandler keyH;

    public Player(gamePanel qp, keyHandler keyH) {
        this.gp = qp;
        this.keyH = keyH;
        setdefaultValues();
        getPlayerImage();
    }

    public void setdefaultValues() {
        x = 100;
        y = 100;
        speed = 4;
        direction = "down";
    }

    public void getPlayerImage() {
        try {
            up1 = ImageIO.read(getClass().getResourceAsStream("/res/chanleft.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/res/chanright.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/res/chanleft.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/res/chanright.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/res/chanleft.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/res/chanright.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/res/chanleft.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/res/chanright.png"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update() {
        if (keyH.upPressed == true) {
            direction = "up";
            y -= speed;
        } else if (keyH.downPressed == true) {
            direction = "down";
            y += speed;
        } else if (keyH.leftPressed == true) {
            direction = "left";
            x -= speed;
        } else if (keyH.rightPressed == true) {
            direction = "right";
            x += speed;
        }
    }

    public void drow(Graphics2D g2) {
        BufferedImage image = null;
        switch (direction) {
            case "up":
                image = up1;
                
                break;
            case "down":
                image = down1;
                break;
            case "left":
                image = left1;
                break;
            case "right":
                image = right1;
                break;
        }

        g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);

//         g2.setColor(Color.white);
//
//        g2.fillRect(x, y, gp.tileSize, gp.tileSize); 
    }
}
