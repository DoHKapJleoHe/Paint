package ru.nsu.fit.g20202.vartazaryan.instruments;

import lombok.Setter;

import java.awt.*;
import java.awt.image.BufferedImage;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

public class PolygonTool
{
    private BufferedImage image;
    private Graphics2D g2d;
    private Color color;

    @Setter
    private int radius = 70;
    @Setter
    private int angle = 0;
    @Setter
    private int angleCount = 5;

    public void draw(BufferedImage image, Point centre, Color curColor)
    {
        this.image = image;
        this.g2d = (Graphics2D) image.getGraphics();
        this.color = curColor;

        int[] xCoords = new int[angleCount * 2];
        int[] yCoords = new int[angleCount * 2];

        for(int i = 0; i < angleCount; i++)
        {
            xCoords[i] = (int) (centre.x + radius * cos(angle + (i*2*Math.PI)/(angleCount)));
            yCoords[i] = (int) (centre.y + radius * sin(angle + (i*2*Math.PI)/(angleCount)));
        }

        g2d.setColor(curColor);
        g2d.drawPolygon(xCoords, yCoords, angleCount);
    }
}
