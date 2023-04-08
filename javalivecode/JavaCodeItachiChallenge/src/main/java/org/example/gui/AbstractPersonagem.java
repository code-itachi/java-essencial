package org.example.gui;

import lombok.val;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;

public abstract class AbstractPersonagem {

    final String nome;
    double passos;
    double tamanho;
    Point posicao;
    Color cor;
    private Font font;

    AbstractPersonagem(final String nome, final double passos) {
        this.nome = nome;
        this.passos = passos;
        this.font = new Font("Arial", Font.BOLD,14);
    }

    public void moveToLeft() {
        posicao.x -= passos;
    }

    public void moveToDown() {
        posicao.y += passos;
    }

    public void moveToUp() {
        posicao.y -= passos;
    }

    public void moveToRight() {
        posicao.x += passos;
    }
    protected abstract void drawShape(Graphics2D g);
    public void draw(Graphics2D g){
        val aff = g.getTransform();
        drawShape(g);
        g.setPaint(Color.black);
        g.setFont(font);
        g.drawString(nome, (int) (this.tamanho + this.posicao.x + 5), (this.posicao.y - 5));
        g.setTransform(aff);
    }
}
