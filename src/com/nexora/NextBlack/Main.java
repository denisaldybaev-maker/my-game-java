package com.nexora.NextBlack;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

public class Main extends JPanel {
    Random random = new Random();
    public void warning() {
        JOptionPane.showMessageDialog(
                Main.this,
                "здесь тебе нужно закрыть жёлтый квадрат\n" +
                        "после этого игра закроется\n" +
                        "управление на w,a,s,d\n" +
                        "к сожалению игра не поддерживает RU раскладку\n" +
                        "переключись на EN раскладку",
                "правила и пояснение",
                JOptionPane.WARNING_MESSAGE
        );
    }
    public void exit() {
        JOptionPane.showMessageDialog(
                Main.this,
                "игра закроется",
                "предупреждение",
                JOptionPane.WARNING_MESSAGE
        );
    }

    int x = random.nextInt(550);
    int y = random.nextInt(350);
    int x1 = 140;
    int y1 = 140;

    public Main() {
        System.out.println(x + ", " + y);
        setBackground(Color.BLACK);

        setFocusable(true);
        addKeyListener(new KeyAdapter() {
           @Override
           public void keyPressed(KeyEvent e) {
               if (x == x1 && y == y1) { exit(); System.exit(0); }
               int Key = e.getKeyCode();
               if (Key == KeyEvent.VK_W) y1 -= 1;
               if (Key == KeyEvent.VK_S) y1 += 1;
               if (Key == KeyEvent.VK_A) x1 -= 1;
               if (Key == KeyEvent.VK_D) x1 += 1;

               repaint();
           }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.ORANGE);
        g.fillRect(x,y, 40, 40);
        g.setColor(Color.BLUE);
        g.fillRect(x1,y1, 40, 40);
    }

    public static void main(String[] args) {
        Main SGame = new Main();

        JFrame window = new JFrame("поиск");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(600,400);
        window.add(SGame);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        SGame.warning();

    }
}