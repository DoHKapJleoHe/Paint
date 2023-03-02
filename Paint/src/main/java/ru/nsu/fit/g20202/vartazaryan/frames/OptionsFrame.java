package ru.nsu.fit.g20202.vartazaryan.frames;

import ru.nsu.fit.g20202.vartazaryan.DrawField;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

// NOT USED
public class OptionsFrame extends JPanel
{
    private DrawField drawField;
    private JSlider penSlider;
    private JSpinner penSizeSpinner;

    private JSlider anglesSlider;
    private JSpinner anglesSpinner;

    public OptionsFrame(DrawField field)
    {
        this.drawField = field;
        setPreferredSize(new Dimension(400, 200));

        /*PEN OPTIONS*/
        JLabel penSize = new JLabel("Pen Size");
        add(penSize);

        penSlider = new JSlider(1,20);
        penSlider.setMaximum(20);
        penSlider.setMinimum(1);
        penSlider.setMajorTickSpacing(1);
        penSlider.setPaintTicks(true);
        penSlider.setValue(5);
        add(penSlider);

        SpinnerNumberModel penSizeSpinnerModel = new SpinnerNumberModel(5, 1, 20, 1);
        penSizeSpinner = new JSpinner(penSizeSpinnerModel);
        add(penSizeSpinner);

        penSlider.addChangeListener(e -> {
            penSizeSpinner.setValue(penSlider.getValue());
        });

        penSizeSpinner.addChangeListener(e -> {
            if((Integer) penSizeSpinner.getValue() > 20)
                penSizeSpinner.setValue(20);
            penSlider.setValue((Integer) penSizeSpinner.getValue());
        });
        /*-----------------*/

        /*POLYGON OPTIONS*/
        JLabel polygonOpt = new JLabel("Polygon Options");
        add(polygonOpt);

        anglesSlider = new JSlider(3, 16);
        anglesSlider.setMajorTickSpacing(1);
        anglesSlider.setPaintTicks(true);
        anglesSlider.setValue(5);
        add(anglesSlider);

        SpinnerNumberModel anglesSpinnerModel = new SpinnerNumberModel(5, 3, 16, 1);
        anglesSpinner = new JSpinner(anglesSpinnerModel);
        add(anglesSpinner);

        anglesSlider.addChangeListener(e -> {
            anglesSpinner.setValue(anglesSlider.getValue());
        });

        anglesSpinner.addChangeListener(e -> {
            if((Integer) anglesSpinner.getValue() > 16)
                anglesSpinner.setValue(16);
            anglesSlider.setValue((Integer) anglesSpinner.getValue());
        });
        /*---------------*/
    }

    public int getPenSize()
    {
        return penSlider.getValue();
    }

    public void setPenSizeSpinner(int size)
    {
        penSlider.setValue(size);
        penSizeSpinner.setValue(size);
    }
}
