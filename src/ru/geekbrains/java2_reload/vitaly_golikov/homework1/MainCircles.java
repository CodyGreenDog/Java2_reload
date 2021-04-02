package ru.geekbrains.java2_reload.vitaly_golikov.homework1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MainCircles extends JFrame {
    private static final int POS_X = 400;
    private static final int POS_Y = 200;
    private static final int WINDOW_WIDTH = 800;
    private static final int WINDOW_HEIGHT = 600;

    private int spriteCounter = 10;
    private int spriteCapacity = 20;

    Sprite[] sprites = new Sprite[spriteCapacity];

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainCircles();
            }
        });
    }

    private MainCircles() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(POS_X, POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        GameCanvas canvas = new GameCanvas(this);
        initApplication();
        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getButton() == MouseEvent.BUTTON1)
                {
                    addBall( e.getX(), e.getY() );
                }

                if(e.getButton() == MouseEvent.BUTTON3)
                {
                    deleteBall();
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });


        add(canvas);
        setResizable(false);
        setTitle("Circles");
        setVisible(true);
    }

    private void initApplication() {
        sprites[0] = new Background(WINDOW_WIDTH, WINDOW_HEIGHT);

        for (int i = 1; i < spriteCounter; i++) {
            sprites[i] = new Ball();
        }
    }

    private void addBall(int x, int y)
    {
        if(spriteCounter == spriteCapacity)
        {
            Sprite[] tmp = new Sprite[spriteCounter];
            tmp = sprites.clone();

            spriteCapacity *= 2;
            sprites = new Sprite[spriteCapacity];
            sprites = tmp.clone();

        }
        sprites[spriteCounter++] = new Ball(x, y);
    }

    private void deleteBall()
    {
        if( spriteCounter > 1)
        {
            spriteCounter--;
        }
    }

    void onDrawFrame(GameCanvas canvas, Graphics g, float deltaTime) {
        update(canvas, deltaTime); // obnovlenie // S = v * t
        render(canvas, g);         // otrisovka

    }

    private void update(GameCanvas canvas, float deltaTime) {
        for (int i = 0; i < spriteCounter; i++) {
            sprites[i].update(canvas, deltaTime);
        }
    }

    private void render(GameCanvas canvas, Graphics g) {
        for (int i = 0; i < spriteCounter; i++) {
            sprites[i].render(canvas, g);
        }
    }
}
