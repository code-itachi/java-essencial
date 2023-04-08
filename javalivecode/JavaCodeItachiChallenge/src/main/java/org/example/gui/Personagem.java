package org.example.gui;

import lombok.val;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.Random;

public class Personagem extends AbstractPersonagem {

    public Personagem(final String nome) {
        super(nome, 10);
        randomPosition();
        regenerateColor();
        randomSize();
    }


    void randomSize() {
        this.tamanho = Math.abs(new Random().nextInt())%200;
    }


    void randomPosition() {
        this.posicao = new Point(Math.abs(new Random().nextInt())%600, Math.abs(new Random().nextInt())%450);
    }

    void regenerateColor() {
        val r = Math.abs( new Random().nextInt()) % 255;
        val g = Math.abs(new Random().nextInt()) % 255;
        val b = Math.abs(new Random().nextInt()) % 255;
        System.out.println("R: "+r);
        System.out.println("G: "+g);
        System.out.println("B: "+b);
        this.cor = new Color(r, g, b);
    }

    @Override
    protected void drawShape(Graphics2D g) {
        val shape = new Ellipse2D.Double(posicao.x, posicao.y, tamanho, tamanho);
        g.setPaint(this.cor);
        g.fill(shape);
    }
}
