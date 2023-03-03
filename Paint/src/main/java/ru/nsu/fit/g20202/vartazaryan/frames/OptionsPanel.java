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

    private JSlider bigRadiusSlider;
    private JSpinner bigRadiusSpinner;

    private JSlider smallRadiusSlider;
    private JSpinner smallRadiusSpinner;

    public OptionsPanel(DrawField field)
    {
        this.drawField = field;
        setPreferredSize(new Dimension(330, 400));

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
        JLabel polygonOpt = new JLabel("Vertices");
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

        JLabel angle = new JLabel("Rotate");
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

        JLabel radius = new JLabel("Radius1");
        add(radius);

        bigRadiusSlider = new JSlider(0, 100);
        bigRadiusSlider.setMajorTickSpacing(1);
        bigRadiusSlider.setValue(50);
        add(bigRadiusSlider);

        SpinnerNumberModel radiusModel = new SpinnerNumberModel(50, 0, 100, 1);
        bigRadiusSpinner = new JSpinner(radiusModel);
        add(bigRadiusSpinner);

        bigRadiusSlider.addChangeListener(e -> {
            bigRadiusSpinner.setValue(bigRadiusSlider.getValue());
        });

        bigRadiusSpinner.addChangeListener(e -> {
            if((Integer) bigRadiusSpinner.getValue() > 1000)
                bigRadiusSpinner.setValue(100);
            bigRadiusSlider.setValue((Integer) bigRadiusSpinner.getValue());
        });

        JLabel smallRadius = new JLabel("Radius2");
        add(smallRadius);

        smallRadiusSlider = new JSlider(0, 100);
        smallRadiusSlider.setMajorTickSpacing(1);
        smallRadiusSlider.setValue(20);
        add(smallRadiusSlider);

        SpinnerNumberModel smallRadiusModel = new SpinnerNumberModel(20, 1, 100, 1);
        smallRadiusSpinner = new JSpinner(smallRadiusModel);
        add(smallRadiusSpinner);

        smallRadiusSlider.addChangeListener(e -> {
            smallRadiusSpinner.setValue(smallRadiusSlider.getValue());
        });

        smallRadiusSpinner.addChangeListener(e -> {
            if((Integer) smallRadiusSpinner.getValue() > 100)
                smallRadiusSpinner.setValue(100);
            smallRadiusSlider.setValue((Integer) smallRadiusSpinner.getValue());
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
    public int getBigRadius(){return bigRadiusSlider.getValue();}
    public int getSmallRadius(){return smallRadiusSlider.getValue();}
}
