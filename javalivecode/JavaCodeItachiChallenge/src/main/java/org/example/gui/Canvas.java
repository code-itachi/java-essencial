package org.example.gui;

import lombok.SneakyThrows;
import lombok.val;
import org.example.util.GlobalKey;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Canvas extends JFrame {

    boolean isPlaying;
    Personagem amarildo, emiliana, luis;
    public Canvas(){
        initFrame();
        initActions();
        this.isPlaying = true;

        amarildo = new Personagem("Amarildo");
        emiliana = new Personagem("Emiliana");
        luis = new Personagem("Luís");
        initGame();
    }

    // inicializadores
    void initFrame() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setExtendedState(MAXIMIZED_BOTH);
    }
    void initActions(){
        addKeyListener(new KeyListener() {
            public void keyTyped(KeyEvent e) {}

            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()){
                    case 37: luis.moveToLeft(); break;
                    case 38: luis.moveToUp(); break;
                    case 39: luis.moveToRight(); break;
                    case 40: luis.moveToDown(); break;
                }
            }

            public void keyReleased(KeyEvent e) {}
        });
    }

    void initGame() {
        val thread = new Thread(this::run);
        thread.start();
    }

    // paint
    @Override
    public void paintComponent(Graphics g) {
        super.paint(g);
        paint((Graphics2D) g);
    }
    void paint(Graphics2D g) {
        g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);

        luis.draw(g);
        amarildo.draw(g);
        emiliana.draw(g);
    }



    @SneakyThrows
    void run() {
        while (this.isPlaying) {
            Thread.sleep(GlobalKey.GAME_DELAY);
            repaint();
        }
    }

}
