package ru.geekbrains.java2_reload.vitaly_golikov.homework1;

import java.awt.*;

public class Background extends Sprite{

    private final float START_SPEED = 0.002f;
    private final float SPEED = 0.5f;

    private Color color;

    private int width;
    private int height;

    private float red;
    private float green;
    private float blue;


    private final float vR = (float)(START_SPEED + (Math.random() * SPEED));
    private final float vG = (float)(START_SPEED + (Math.random() * SPEED));
    private final float vB = (float)(START_SPEED + (Math.random() * SPEED));

    private float phR = (float)(Math.random() * 2. * Math.PI);
    private float phG = (float)(Math.random() * 2. * Math.PI);
    private float phB = (float)(Math.random() * 2. * Math.PI);



    Background(int width, int height)
    {
        this.width = width;
        this.height = height;

    }


    @Override
    void update(GameCanvas canvas, float deltaTime) {
        phR += (float)(2.* Math.PI * deltaTime * vR);
        phG += (float)(2.* Math.PI * deltaTime * vG);
        phB += (float)(2.* Math.PI * deltaTime * vB);

        red = (float)(127.5 + 127.5 * Math.sin( phR ) );
        green = (float)(127.5 + 127.5 * Math.sin( phG ) );
        blue = (float)(127.5 + 127.5 * Math.sin( phB  ) );

        color = new Color((int)red, (int)green, (int)blue);
    }

    @Override
    void render(GameCanvas canvas, Graphics g) {
        g.setColor(color);
        g.fillRect(0, 0, width, height);
    }
}
