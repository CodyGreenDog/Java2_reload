package ru.geekbrains.java2_reload.vitaly_golikov.homework1;

import java.awt.*;

public class Background extends Sprite{

    private final float START_SPEED = 2f;
    private final float SPEED = 2f;

    private Color color;

    private int width;
    private int height;

    private float red;
    private float green;
    private float blue;


    private float vR = (float)(START_SPEED + (Math.random() * SPEED));
    private float vG = (float)(START_SPEED + (Math.random() * SPEED));
    private float vB = (float)(START_SPEED + (Math.random() * SPEED));


    Background(int width, int height)
    {
        this.width = width;
        this.height = height;

        red = (float)(Math.random() * 255);
        green = (float)(Math.random() * 255);
        blue = (float)(Math.random() * 255);

        color = new Color((int)red, (int)green, (int)blue);
    }


    @Override
    void update(GameCanvas canvas, float deltaTime) {
        red += vR;
        green += vG;
        blue += vB;

        if(red > 255f)
        {
            red = 255f;
            vR = - vR;
        }
        if(red < 0f)
        {
            red = 0f;
            vR = - vR;
        }

        if(green > 255f)
        {
            green = 255f;
            vG = - vG;
        }
        if(green < 0f)
        {
            green = 0f;
            vG = - vG;
        }

        if(blue > 255f)
        {
            blue = 255f;
            vB = - vB;
        }
        if(blue < 0f)
        {
            blue = 0f;
            vB = - vB;
        }

        color = new Color((int)red, (int)green, (int)blue);
    }

    @Override
    void render(GameCanvas canvas, Graphics g) {
        g.setColor(color);
        g.fillRect(0, 0, width, height);
    }
}
