package ru.nsu.fit.g20202.vartazaryan.instruments;

import java.awt.*;
import java.awt.image.BufferedImage;

public class LineTool
{
    private BufferedImage image;
    private Graphics2D g2d;

    public void drawLine(BufferedImage image, int thickness, Color curentColor, Point start, Point end)
    {
        this.image = image;
        this.g2d = (Graphics2D) image.getGraphics();

        int xStart = start.x;
        int yStart = start.y;
        int xEnd = end.x;
        int yEnd = end.y;

        if (thickness > 1)
        {
            g2d.setColor(curentColor);
            g2d.setStroke(new BasicStroke(thickness));
            g2d.drawLine(xStart, yStart, xEnd, yEnd);
        }
        else
        {
            // setting start point but other points will be calculated by Brezenhem algorithm
            image.setRGB(xStart, yStart, curentColor.getRGB());

            int dx = Math.abs(xEnd - xStart);
            int dy = Math.abs(yStart - yEnd);

            int stepX = xEnd > xStart ? 1 : -1;
            int stepY = yEnd > yStart ? 1 : -1;
            int err = -dx;

            /* There are two options of line location:
             *       1) The angle between line and Ox is less than 45 degrees
             *       2) The angle between line and Ox is more than 45 degrees
             *
             *  In the first case Brezenhem algorithm causes situation when we add +1 to x coord but y coord remains same:
             *       (x1,y1) (x2,y2) (x3,y2) (x4,y3) ....
             *  The second case is similar to the first case except that x can remain the same
             */
            if(dx >= dy)
            {
                if((xEnd - xStart) >= 0 && (yEnd - yStart) >= 0)
                {
                    int x = Math.min(xStart, xEnd);
                    int y = Math.min(yStart, yEnd);

                    for(int i = 0; i < dx; i++)
                    {
                        x++;
                        err += 2*dy;
                        if(err > 0)
                        {
                            y++;
                            err -= 2*dx;
                        }
                        image.setRGB(x, y, curentColor.getRGB());
                    }
                }
                else if((xEnd - xStart) >= 0 && (yEnd - yStart) <= 0)
                {
                    int x = Math.min(xStart, xEnd);
                    int y = Math.max(yStart, yEnd);

                    for(int i = 0; i < dx; i++)
                    {
                        x++;
                        err += 2*dy;
                        if(err > 0)
                        {
                            y--;
                            err -= 2*dx;
                        }
                        image.setRGB(x, y, curentColor.getRGB());
                    }
                }
                else if ((xEnd - xStart) <= 0 && (yEnd - yStart) >= 0)
                {
                    int x = Math.max(xStart, xEnd);
                    int y = Math.min(yStart, yEnd);

                    for(int i = 0; i < dx; i++)
                    {
                        x--;
                        err += 2*dy;
                        if(err > 0)
                        {
                            y++;
                            err -= 2*dx;
                        }
                        image.setRGB(x, y, curentColor.getRGB());
                    }
                }
                else if ((xEnd - xStart) <= 0 && (yEnd - yStart) <= 0)
                {
                    int x = Math.max(xStart, xEnd);
                    int y = Math.max(yStart, yEnd);

                    for(int i = 0; i < dx; i++)
                    {
                        x--;
                        err += 2*dy;
                        if(err > 0)
                        {
                            y--;
                            err -= 2*dx;
                        }
                        image.setRGB(x, y, curentColor.getRGB());
                    }
                }
            }
            else
            {
                if((xEnd - xStart) >= 0 && (yEnd - yStart) >= 0)
                {
                    int x = Math.min(xStart, xEnd);
                    int y = Math.min(yStart, yEnd);

                    for(int i = 0; i < dy; i++)
                    {
                        y++;
                        err += 2*dx;
                        if(err > 0)
                        {
                            x++;
                            err -= 2*dy;
                        }
                        image.setRGB(x, y, curentColor.getRGB());
                    }
                }
                else if((xEnd - xStart) >= 0 && (yEnd - yStart) <= 0)
                {
                    int x = Math.min(xStart, xEnd);
                    int y = Math.max(yStart, yEnd);

                    for(int i = 0; i < dy; i++)
                    {
                        y--;
                        err += 2*dx;
                        if(err > 0)
                        {
                            x++;
                            err -= 2*dy;
                        }
                        image.setRGB(x, y, curentColor.getRGB());
                    }
                }
                else if ((xEnd - xStart) <= 0 && (yEnd - yStart) >= 0)
                {
                    int x = Math.max(xStart, xEnd);
                    int y = Math.min(yStart, yEnd);

                    for(int i = 0; i < dy; i++)
                    {
                        y++;
                        err += 2*dx;
                        if(err > 0)
                        {
                            x--;
                            err -= 2*dy;
                        }
                        image.setRGB(x, y, curentColor.getRGB());
                    }
                }
                else if ((xEnd - xStart) <= 0 && (yEnd - yStart) <= 0)
                {
                    int x = Math.max(xStart, xEnd);
                    int y = Math.max(yStart, yEnd);

                    for(int i = 0; i < dy; i++)
                    {
                        y--;
                        err += 2*dx;
                        if(err > 0)
                        {
                            x--;
                            err -= 2*dy;
                        }
                        image.setRGB(x, y, curentColor.getRGB());
                    }
                }
            }
        }
    }
}

