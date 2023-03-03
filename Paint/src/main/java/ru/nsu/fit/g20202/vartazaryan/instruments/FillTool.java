package ru.nsu.fit.g20202.vartazaryan.instruments;

import lombok.Getter;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Stack;

public class FillTool
{
    private Stack<Pair> spanStack = new Stack();
    private BufferedImage image;
    private Graphics2D g2d;
    private int colorToSet;
    private int oldColor;

    private int maxUpX;
    private int maxDownX;

    private void addNewSpan(Point seed)
    {
        //Span is a line that can is defined with two end-points
        //Below I am finding left end-point of the span
        Point newSpanStart = new Point(seed);
        while(newSpanStart.x >= 0 && image.getRGB(newSpanStart.x, newSpanStart.y) == oldColor)
        {
            newSpanStart.x--;
        }
        newSpanStart.x++;

        //Below I am finding right end-point of the span
        Point newSpanEnd = new Point(seed);
        while(newSpanEnd.x < image.getWidth() && image.getRGB(newSpanEnd.x, newSpanEnd.y) == oldColor)
        {
            newSpanEnd.x++;
        }
        newSpanEnd.x--;

        //adding resulting points into span stack as pair
        spanStack.push(new Pair(newSpanStart, newSpanEnd));
    }

    private void findNewSpan(Point point)
    {
        if((point.y - 1) >= 0 && (point.y + 1) < image.getHeight())
        {
            if(point.x > maxUpX)
            {
                if(image.getRGB(point.x, point.y + 1) == oldColor)
                {
                    addNewSpan(new Point(point.x, point.y + 1));
                    maxUpX = spanStack.peek().spanEnd.x;
                }
            }
            if(point.x > maxDownX)
            {
                if(image.getRGB(point.x, point.y - 1) == oldColor)
                {
                    addNewSpan(new Point(point.x, point.y - 1));
                    maxDownX = spanStack.peek().spanEnd.x;
                }
            }
        }
    }

    private void startFilling()
    {
        //Getting span from stack
        Pair curSpan = spanStack.pop();
        g2d.setColor(new Color(colorToSet));
        g2d.drawLine(curSpan.spanStart.x, curSpan.spanStart.y, curSpan.spanEnd.x, curSpan.spanEnd.y);

        for(int x = curSpan.spanStart.x; x < curSpan.spanEnd.x; x++)
        {
            findNewSpan(new Point(x, curSpan.spanStart.y));
        }

        maxUpX = 0;
        maxDownX = 0;
    }

    public void fill(BufferedImage image, Point seed, Color newColor)
    {
        this.image = image;
        this.g2d = (Graphics2D) image.getGraphics();
        this.colorToSet = newColor.getRGB();

        this.oldColor = image.getRGB(seed.x, seed.y);

        if(oldColor != colorToSet)
        {
            addNewSpan(seed);
            while(!spanStack.isEmpty())
            {
                startFilling();
            }
        }
    }

    private class Pair
    {
        @Getter
        private Point spanStart;
        @Getter
        private Point spanEnd;

        public Pair(Point spanStart, Point spanEnd)
        {
            this.spanStart = spanStart;
            this.spanEnd = spanEnd;
        }
    }
}
