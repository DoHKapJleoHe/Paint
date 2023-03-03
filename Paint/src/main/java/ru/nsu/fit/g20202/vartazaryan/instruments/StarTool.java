package ru.nsu.fit.g20202.vartazaryan.instruments;

import lombok.Setter;

import java.awt.*;
import java.awt.image.BufferedImage;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

public class StarTool
{
    private BufferedImage image;
    private Graphics2D g2d;
    private Color color;

    private int bigRadius = 50;
    private int smallRadius = 20;
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

        for(int i = 0; i < angleCount * 2; i++)
        {
            if(i % 2 == 0)
            {
                xCoords[i] = (int) (centre.x + bigRadius * cos(angle + (i*2*Math.PI)/(2*angleCount)));
                yCoords[i] = (int) (centre.y + bigRadius * sin(angle + (i*2*Math.PI)/(2*angleCount)));
            }
            else
            {
                xCoords[i] = (int) (centre.x + smallRadius * cos(angle + (i*2*Math.PI)/(2*angleCount)));
                yCoords[i] = (int) (centre.y + smallRadius * sin(angle + (i*2*Math.PI)/(2*angleCount)));
            }
        }

        g2d.setColor(curColor);
        g2d.drawPolygon(xCoords, yCoords, angleCount*2);
    }
}