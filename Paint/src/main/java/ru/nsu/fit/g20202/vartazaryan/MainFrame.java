package ru.nsu.fit.g20202.vartazaryan;

import ru.nsu.fit.g20202.vartazaryan.frames.LoadFrame;
import ru.nsu.fit.g20202.vartazaryan.frames.OptionsFrame;
import ru.nsu.fit.g20202.vartazaryan.frames.SaveFrame;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;

public class MainFrame extends JFrame
{
    private DrawField field;
    private SaveFrame saveFrame;
    private LoadFrame loadFrame;
    private OptionsFrame optionsFrame;

    private ImageIcon exitIcon;
    private ImageIcon saveIcon;

    private JToolBar toolBar;
    private JButton options;
    private JButton eraser;
    private JButton cleanField;
    private JButton penTool;
    private JButton lineTool;
    private JButton starTool;
    private JButton fillTool;
    private JButton redColor;
    private JButton blackColor;
    private JButton greenColor;
    private JButton blueColor;

    private JMenuBar menuBar;
    private JMenu fileMenu;
    private JMenuItem exitItem;
    private JMenuItem saveItem;
    private JMenuItem loadItem;
    private JMenu aboutMenu;

    private JButton anyColorButton;

    public MainFrame() throws IOException
    {
        super("Paint");

        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setBounds(400, 100, 640, 480);
        setMinimumSize(new Dimension(640, 480));

        field = new DrawField();
        saveFrame = new SaveFrame(field);
        loadFrame = new LoadFrame(field);
        optionsFrame = new OptionsFrame(field);

        field.setVisible(true);
        add(field);

        /*TOOLBAR SECTION*/
        toolBar = new JToolBar();
        toolBar.setFloatable(false);
        toolBar.setRollover(false);
        toolBar.setVisible(true);

        add(toolBar, BorderLayout.NORTH);

        options = new JButton("Options"/*new ImageIcon(ImageIO.read(new File("src/main/resources/options.png")))*/);
        toolBar.add(options);

        cleanField = new JButton("Clean");
        toolBar.add(cleanField);

        eraser = new JButton("Eraser"/*new ImageIcon(ImageIO.read(new File("src/main/resources/erase.png")))*/);
        toolBar.add(eraser);

        penTool = new JButton("Pen");
        toolBar.add(penTool);

        lineTool = new JButton("Line");
        toolBar.add(lineTool);

        starTool = new JButton("Star");
        toolBar.add(starTool);

        fillTool = new JButton("Fill ");
        toolBar.add(fillTool);

        redColor = new JButton("     ");
        redColor.setBackground(Color.RED);
        toolBar.add(redColor);

        greenColor = new JButton("     ");
        greenColor.setBackground(Color.GREEN);
        toolBar.add(greenColor);

        blueColor = new JButton("     ");
        blueColor.setBackground(Color.BLUE);
        toolBar.add(blueColor);

        blackColor = new JButton("     ");
        blackColor.setBackground(Color.BLACK);
        toolBar.add(blackColor);

        anyColorButton = new JButton("Any Color"/*new ImageIcon(ImageIO.read(new File("src/main/resources/palette.png")))*/);
        toolBar.add(anyColorButton);
        /*---------------*/

        /*MENUBAR SECTION*/
        menuBar = new JMenuBar();
        fileMenu = new JMenu("File");
        menuBar.add(fileMenu);

        saveItem = new JMenuItem("Save", saveIcon);
        saveItem.setHorizontalAlignment(SwingConstants.RIGHT);

        loadItem = new JMenuItem("Load");
        loadItem.setHorizontalAlignment(SwingConstants.RIGHT);

        exitItem = new JMenuItem("Exit");
        exitItem.setIcon(exitIcon);
        exitItem.setHorizontalAlignment(SwingConstants.RIGHT);

        fileMenu.add(exitItem);
        fileMenu.add(loadItem);
        fileMenu.add(saveItem);

        aboutMenu = new JMenu("About");
        menuBar.add(aboutMenu);
        /*---------------*/

        /*ACTION LISTENERS*/
        exitItem.addActionListener(e -> System.exit(0));

        penTool.addActionListener(e -> {
            field.setPenStyle(DrawField.penStyle.PEN);
        });

        starTool.addActionListener(e -> {
            field.setPenStyle(DrawField.penStyle.STAR);
        });

        lineTool.addActionListener(e -> {
            field.setPenStyle(DrawField.penStyle.LINE);
        });

        fillTool.addActionListener(e -> {
            field.setPenStyle(DrawField.penStyle.FILL);
        });

        saveItem.addActionListener(e -> {
            try
            {
                saveFrame.saveImage();
            }
            catch (IOException ex)
            {
                throw new RuntimeException(ex);
            }
        });

        loadItem.addActionListener(e -> {
            try
            {
                loadFrame.loadImage();
            }
            catch (IOException ex)
            {
                throw new RuntimeException(ex);
            }
        });

        cleanField.addActionListener(e -> {
            field.setWhite();
        });

        JSlider slider = createSlider();
        slider.setMaximum(20);
        slider.setMinimum(1);
        slider.setValue(5);
        slider.setPaintLabels(false);
        SpinnerNumberModel penSizeSpinnerModel = new SpinnerNumberModel(5, 1, 20, 1);
        JSpinner penSizeSpinner = new JSpinner(penSizeSpinnerModel);
        JPanel sliderPanel = new JPanel();
        sliderPanel.add(slider);
        sliderPanel.add(penSizeSpinner);

        // make it possible to set max value if current value is higher than max value
        slider.addChangeListener(e -> {
            penSizeSpinner.setValue(slider.getValue());
        });

        penSizeSpinner.addChangeListener(e -> {
            if((Integer) penSizeSpinner.getValue() > 20)
                penSizeSpinner.setValue(20);
            slider.setValue((Integer) penSizeSpinner.getValue());
        });

        options.addActionListener(e -> {
            //optionsFrame.setVisible(true);
            int penSize = JOptionPane.showOptionDialog(this,
                    sliderPanel,
                    "PenSize",
                    JOptionPane.OK_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    null,
                    null);

            if(JOptionPane.OK_OPTION == penSize)
            {
                int size = slider.getValue();
                field.setThickness(size);
                slider.setValue(size);
            }
        });

        redColor.addActionListener(e -> {
            field.setColor(Color.RED);
        });

        greenColor.addActionListener(e -> {
            field.setColor(Color.GREEN);
        });

        blueColor.addActionListener(e -> {
            field.setColor(Color.BLUE);
        });

        blackColor.addActionListener(e -> {
            field.setColor(Color.BLACK);
        });

        eraser.addActionListener(e -> {
            field.setColor(Color.WHITE);
            field.setPenStyle(DrawField.penStyle.PEN);
        });

        anyColorButton.addActionListener(e -> {
            Color newColor = JColorChooser.showDialog(null, "Colors", Color.BLACK);
            field.setColor(newColor);
            anyColorButton.setBackground(newColor);
        });

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e)
            {
                //super.windowClosed(e);
                if(JOptionPane.showConfirmDialog(null, "Are you sure you want to close programm?", "Close", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
                {
                    System.exit(0);
                }
            }
        });
        /*----------------*/
        this.setJMenuBar(menuBar);
        this.setVisible(true);
        this.pack();
    }

    private JSlider createSlider()
    {
        JSlider slider = new JSlider(1,10);
        slider.setMajorTickSpacing(1);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setValue(5);

        return slider;
    }

    public static void main(String[] args) throws IOException
    {
        MainFrame mainFrame = new MainFrame();
    }
}