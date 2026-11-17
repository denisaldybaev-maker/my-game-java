package com.nexora.nextblack.code;

import com.nexora.nextblack.code.jsonconf.Jsonconfig;
import com.nexora.nextblack.code.jsonconf.JsonconfigPlusWin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

public class Controller extends JPanel {
    Random random = new Random();
    Jsonconfig jsonconfig = new Jsonconfig();
    int x = random.nextInt(550);
    int y = random.nextInt(350);
    int x1 = 140;
    int y1 = 140;
    public Controller() {
        jsonconfig.SJsonconfig();
        System.out.println(x + ", " + y);
        setBackground(Color.BLACK);

        setFocusable(true);
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (x == x1 && y == y1) Win();
                int Key = e.getKeyCode();
                if (Key == KeyEvent.VK_W) y1 -= 1;
                if (Key == KeyEvent.VK_S) y1 += 1;
                if (Key == KeyEvent.VK_A) x1 -= 1;
                if (Key == KeyEvent.VK_D) x1 += 1;
                if (Key == KeyEvent.VK_F12) passkey();
                repaint();
            }
        });
    }

    public static void SController() {
        com.nexora.nextblack.code.Controller SGame = new com.nexora.nextblack.code.Controller();

        JFrame window = new JFrame("NextBlack");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(600, 400);
        window.add(SGame);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        SGame.warning();

    }

    public void passkey() {
        String key = JOptionPane.showInputDialog(null);
        if (key != null && key.equals("30062006")) {
            Win();
        }
    }

    public void warning() {
        JOptionPane.showMessageDialog(
                Controller.this,
                "здесь тебе нужно закрыть жёлтый квадрат\n" +
                        "после этого игра закроется\n" +
                        "управление на w,a,s,d\n" +
                        "к сожалению игра не поддерживает RU раскладку\n" +
                        "переключись на EN раскладку\n\n" +
                        "version " + jsonconfig.version +
                        "\n побед: " + jsonconfig.winGame,
                "правила и пояснение",
                JOptionPane.WARNING_MESSAGE
        );
    }

    public void Win() {
        JsonconfigPlusWin jsonconfigPlusWin = new JsonconfigPlusWin();
        jsonconfigPlusWin.SJsonconfigPlusWin();
        Jsonconfig jsonconfig = new Jsonconfig();
        jsonconfig.SJsonconfig();
        JOptionPane.showMessageDialog(
                Controller.this,
                "игра закроется,\n" +
                        "побед: " + jsonconfig.winGame,
                "предупреждение и инфо",
                JOptionPane.WARNING_MESSAGE
        );
        System.exit(0);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.ORANGE);
        g.fillRect(x, y, 40, 40);
        g.setColor(Color.BLUE);
        g.fillRect(x1, y1, 40, 40);
    }
}
