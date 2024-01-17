/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game2d;

import javax.swing.JFrame;

/**
 *
 * @author HP
 */
public class main {
    public static void main(String[] args) {
        JFrame window = new JFrame();
        //tắt màn hình 
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //không thay đổi kích thước
        window.setResizable(false);
        window.setTitle("game 2D ");
        //gọi gamePannel qua
        gamePanel gamePanel = new gamePanel();
        window.add(gamePanel);
        //đóng gói
        window.pack();
        //luôn ở giữa màn hình khi hiển thị
        window.setLocationRelativeTo(null);
        //cho phép hiển thị
        window.setVisible(true);
        
        gamePanel.startGameThread();
    }
}
