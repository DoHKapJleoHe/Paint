package ru.nsu.fit.g20202.vartazaryan.frames;

import ru.nsu.fit.g20202.vartazaryan.DrawField;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

// NOT USED
public class OptionsFrame extends JFrame
{
    private DrawField field;
    private ExamplePanel example;

    public OptionsFrame(DrawField field)
    {
        /*super("Options");

        this.field = field;
        setBounds(100, 150, 450, 300);
        getContentPane().setLayout(null);

        example = new ExamplePanel();
        example.setBounds(320, 15, 40, 40);
        example.setVisible(true);
        this.add(example);

        JSlider penSize = new JSlider();
        penSize.setMaximum(20);
        penSize.setMinimum(1);
        penSize.setValue(5);
        penSize.setMajorTickSpacing(1);
        penSize.setMinorTickSpacing(1);
        penSize.setPaintTicks(true);
        penSize.setPaintLabels(true);
        penSize.setBounds(0, 30, 300, 50);
        add(penSize);

        JLabel penSizeLabel = new JLabel("PenSize");
        penSizeLabel.setBounds(0, 1, 60, 40);
        penSizeLabel.setVisible(true);
        add(penSizeLabel);
        setVisible(false);

        JSlider starRadius = new JSlider();
        starRadius.setMaximum(10);
        starRadius.setMinimum(1);
        starRadius.setValue(5);
        starRadius.setMajorTickSpacing(1);
        starRadius.setMinorTickSpacing(1);
        starRadius.setPaintTicks(true);
        starRadius.setPaintLabels(true);
        starRadius.setBounds(0, 110, 300, 50);
        add(starRadius);

        /*ACTION LISTENERS*/
        /*penSize.addChangeListener(e -> {
            int size = penSize.getValue();
            field.setThickness(size);

            example.setThickness(size);
        });
        /*----------------*/
    }

    class ExamplePanel extends JPanel
    {
        private BufferedImage penSizeExample;
        private Graphics2D penGraphics;

        private int thickness = 5;

        public ExamplePanel()
        {
            penSizeExample = new BufferedImage(40, 40, BufferedImage.TYPE_INT_RGB);
            penGraphics = penSizeExample.createGraphics();
            repaint();
        }

        @Override
        public void paintComponent(Graphics g)
        {
            super.paintComponent(g);

            penGraphics.setColor(Color.WHITE);
            penGraphics.fillRect(0, 0, 40, 40);
            penGraphics.setColor(Color.BLACK);
            penGraphics.fillOval(10, 10, thickness, thickness);

            g.drawImage(penSizeExample, 0, 0, this);
        }

        public void setThickness(int a)
        {
            thickness = a;
            repaint();
        }
    }
}
