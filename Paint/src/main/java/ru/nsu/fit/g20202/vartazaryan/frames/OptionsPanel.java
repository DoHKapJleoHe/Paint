package ru.nsu.fit.g20202.vartazaryan.frames;

import ru.nsu.fit.g20202.vartazaryan.DrawField;

import javax.swing.*;
import java.awt.*;

public class OptionsPanel extends JPanel
{
    private DrawField drawField;
    private JSlider penSlider;
    private JSpinner penSizeSpinner;

    private JSlider vertexSlider;
    private JSpinner vertexSpinner;

    private JSlider angleSlider;
    private JSpinner angleSpinner;

    private JSlider radiusSlider;
    private JSpinner radiusSpinner;


    public OptionsPanel(DrawField field)
    {
        this.drawField = field;
        setPreferredSize(new Dimension(320, 200));

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
        JLabel polygonOpt = new JLabel("Vertexes");
        add(polygonOpt);

        vertexSlider = new JSlider(3, 16);
        vertexSlider.setMajorTickSpacing(1);
        vertexSlider.setPaintTicks(true);
        vertexSlider.setValue(5);
        add(vertexSlider);

        SpinnerNumberModel anglesSpinnerModel = new SpinnerNumberModel(5, 3, 16, 1);
        vertexSpinner = new JSpinner(anglesSpinnerModel);
        add(vertexSpinner);

        vertexSlider.addChangeListener(e -> {
            vertexSpinner.setValue(vertexSlider.getValue());
        });

        vertexSpinner.addChangeListener(e -> {
            if((Integer) vertexSpinner.getValue() > 16)
                vertexSpinner.setValue(16);
            vertexSlider.setValue((Integer) vertexSpinner.getValue());
        });

        JLabel angle = new JLabel("Angle");
        add(angle);

        angleSlider = new JSlider(0, 360);
        angleSlider.setMajorTickSpacing(1);
        angleSlider.setValue(0);
        add(angleSlider);

        SpinnerNumberModel angleModel = new SpinnerNumberModel(0, 0, 360, 1);
        angleSpinner = new JSpinner(angleModel);
        add(angleSpinner);

        angleSlider.addChangeListener(e -> {
            angleSpinner.setValue(angleSlider.getValue());
        });

        angleSpinner.addChangeListener(e -> {
            if((Integer) angleSpinner.getValue() > 360)
                angleSpinner.setValue(360);
            angleSlider.setValue((Integer) angleSpinner.getValue());
        });

        JLabel radius = new JLabel("Radius");
        add(radius);

        radiusSlider = new JSlider(0, 100);
        radiusSlider.setMajorTickSpacing(1);
        radiusSlider.setValue(50);
        add(radiusSlider);

        SpinnerNumberModel radiusModel = new SpinnerNumberModel(50, 0, 100, 1);
        radiusSpinner = new JSpinner(radiusModel);
        add(radiusSpinner);

        radiusSlider.addChangeListener(e -> {
            radiusSpinner.setValue(radiusSlider.getValue());
        });

        radiusSpinner.addChangeListener(e -> {
            if((Integer) radiusSpinner.getValue() > 360)
                radiusSpinner.setValue(360);
            radiusSlider.setValue((Integer) radiusSpinner.getValue());
        });
        /*---------------*/

    }

    public int getPenSize()
    {
        return penSlider.getValue();
    }
    public int getNumOfVertices()
    {
        return vertexSlider.getValue();
    }
    public int getAngle()
    {
        return angleSlider.getValue();
    }
    public int getRadius(){return radiusSlider.getValue();}
}
