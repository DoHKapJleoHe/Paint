package ru.nsu.fit.g20202.vartazaryan;

import ru.nsu.fit.g20202.vartazaryan.instruments.PolygonTool;
import ru.nsu.fit.g20202.vartazaryan.instruments.FillTool;
import ru.nsu.fit.g20202.vartazaryan.instruments.LineTool;
import ru.nsu.fit.g20202.vartazaryan.instruments.StarTool;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;

public class DrawField extends JPanel implements MouseListener, MouseMotionListener
{
    /*CANVAS*/
    private int minWidth = 640;
    private int minHeight = 480;
    private int thickness = 5;
    private BufferedImage image;
    private Graphics2D g2d;
    private penStyle curPenStyle = penStyle.PEN;
    private Color curentColor = Color.BLACK;

    /*INSTRUMENTS*/
    private LineTool lineTool = new LineTool();
    private FillTool fillTool = new FillTool();
    private StarTool starTool = new StarTool();
    private PolygonTool polygonTool = new PolygonTool();

    /*ADDONS*/
    private Point startPoint = new Point(-1, -1);
    private Point prevPoint = new Point(-1, -1);
    private Story saves = new Story();

    public DrawField()
    {
        image = new BufferedImage(minWidth, minHeight, BufferedImage.TYPE_INT_RGB);
        g2d = image.createGraphics();

        this.addMouseListener(this);
        this.addMouseMotionListener(this);

        setWhite();
    }

    public void resizeImage(int width, int height)
    {
        this.minWidth = width;
        this.minHeight = height;

        BufferedImage newImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        this.g2d = newImage.createGraphics();
        setWhite();
        newImage.setData(image.getData());
        this.image = newImage;
        repaint();
    }

    public void setWhite()
    {
        g2d.setColor(Color.WHITE);
        g2d.setBackground(Color.WHITE);
        g2d.fillRect(0, 0, minWidth, minHeight);
        repaint();
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        g.drawImage(image, 0, 0, this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e)
    {
        if(e.getX() > minWidth || e.getY() > minHeight)
            return;

        switch (curPenStyle)
        {
            case LINE:
            {
                if(SwingUtilities.isLeftMouseButton(e))
                {
                    if(startPoint.x == -1 & startPoint.y == -1)
                    {
                        startPoint.x = e.getX();
                        startPoint.y = e.getY();
                    }
                    else
                    {
                        lineTool.drawLine(image, thickness, curentColor, startPoint, new Point(e.getX(), e.getY()));
                        resetStartPos();
                    }
                }
                break;
            }
            case STAR:
            {
                starTool.draw(image, e.getPoint(), curentColor);
                break;
            }
            case POLYGON:
            {
                polygonTool.draw(image, e.getPoint(), curentColor);
                break;
            }
            case FILL:
            {
                fillTool.fill(image, e.getPoint(), curentColor);
                break;
            }
            case PEN:
            {
                prevPoint = e.getPoint();
                g2d.setColor(curentColor);
                g2d.fillOval(e.getX() - thickness/2, e.getY() - thickness/2, thickness, thickness);
                break;
            }
        }
        repaint();
    }

    @Override
    public void mouseDragged(MouseEvent e)
    {
        if(e.getX() > minWidth || e.getY() > minHeight)
            return;

        if(curPenStyle == penStyle.PEN)
        {
            g2d.setColor(curentColor);
            g2d.fillOval(e.getX() - thickness/2, e.getY() - thickness/2, thickness, thickness);
            g2d.setStroke(new BasicStroke(thickness, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
            g2d.drawLine(prevPoint.x, prevPoint.y, e.getX(), e.getY());
            prevPoint = e.getPoint();
            repaint();
        }
        else if(curPenStyle == penStyle.ERASER)
        {
            g2d.setColor(Color.WHITE);
            g2d.fillOval(e.getX(), e.getY(), thickness, thickness);
            repaint();
        }
    }

    private void resetStartPos()
    {
        startPoint.x = -1;
        startPoint.y = -1;
    }

    @Override
    public void mouseReleased(MouseEvent e)
    {
        if(e.getX() > minWidth || e.getY() > minHeight)
            return;

        saves.saveImage(image.getData());
        System.out.println("Image saved");
    }

    // Find an error here
    public void back()
    {
        Raster lastSave = saves.getLastSave();
        if(lastSave != null)
        {
            image.setData(lastSave);
            repaint();
            System.out.println("returned");
        }
    }
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}
    @Override
    public void mouseMoved(MouseEvent e) {}

    public void setThickness(int thickness)
    {
        this.thickness = thickness;
    }

    public BufferedImage getImage()
    {
        return image;
    }

    public void setImage(BufferedImage newImage)
    {
        this.image = newImage;
        g2d = newImage.createGraphics();
        repaint();
        System.out.println("New image has been set!");
    }

    public void setPenStyle(penStyle style)
    {
        this.curPenStyle = style;
        System.out.println("Pen changed to " + style.name());
    }

    public void setColor(Color color)
    {
        curentColor = color;
    }

    public void setPolygonParameters(int angle, int numOfVertices, int radius)
    {
        starTool.setAngleCount(numOfVertices);
        starTool.setAngle(angle);

        polygonTool.setAngleCount(numOfVertices);
        polygonTool.setAngle(angle);
        polygonTool.setRadius(radius);
    }

    enum penStyle
    {
        PEN,
        LINE,
        STAR,
        POLYGON,
        ERASER,
        FILL
    }
}
