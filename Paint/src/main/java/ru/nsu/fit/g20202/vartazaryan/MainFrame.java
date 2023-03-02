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
    private JMenu viewMenu;
    private JMenuItem penItem;
    private JMenuItem lineItem;
    private JMenuItem starItem;
    private JMenuItem fillItem;
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

        ImageIcon penIcon = new ImageIcon(ImageIO.read(new File("C:\\Users\\eduar\\Desktop\\Проекты\\Paint\\Paint\\src\\main\\java\\ru\\nsu\\fit\\g20202\\vartazaryan\\images\\pen.png")));
        ImageIcon optionsIcon = new ImageIcon(ImageIO.read(new File("C:\\Users\\eduar\\Desktop\\Проекты\\Paint\\Paint\\src\\main\\java\\ru\\nsu\\fit\\g20202\\vartazaryan\\images\\options.png")));
        ImageIcon cleanIcon = new ImageIcon(ImageIO.read(new File("C:\\Users\\eduar\\Desktop\\Проекты\\Paint\\Paint\\src\\main\\java\\ru\\nsu\\fit\\g20202\\vartazaryan\\images\\clearAll.png")));
        ImageIcon eraserIcon = new ImageIcon(ImageIO.read(new File("C:\\Users\\eduar\\Desktop\\Проекты\\Paint\\Paint\\src\\main\\java\\ru\\nsu\\fit\\g20202\\vartazaryan\\images\\eraser.png")));
        ImageIcon lineIcon = new ImageIcon(ImageIO.read(new File("C:\\Users\\eduar\\Desktop\\Проекты\\Paint\\Paint\\src\\main\\java\\ru\\nsu\\fit\\g20202\\vartazaryan\\images\\line.png")));
        ImageIcon starIcon = new ImageIcon(ImageIO.read(new File("C:\\Users\\eduar\\Desktop\\Проекты\\Paint\\Paint\\src\\main\\java\\ru\\nsu\\fit\\g20202\\vartazaryan\\images\\star.png")));
        ImageIcon fillIcon = new ImageIcon(ImageIO.read(new File("C:\\Users\\eduar\\Desktop\\Проекты\\Paint\\Paint\\src\\main\\java\\ru\\nsu\\fit\\g20202\\vartazaryan\\images\\fill.png")));
        ImageIcon anyColorIcon = new ImageIcon(ImageIO.read(new File("C:\\Users\\eduar\\Desktop\\Проекты\\Paint\\Paint\\src\\main\\java\\ru\\nsu\\fit\\g20202\\vartazaryan\\images\\palette.png")));


        /*TOOLBAR SECTION*/
        toolBar = new JToolBar();
        toolBar.setFloatable(false);
        toolBar.setRollover(false);
        toolBar.setVisible(true);

        add(toolBar, BorderLayout.NORTH);

        options = new JButton(optionsIcon);
        toolBar.add(options);

        cleanField = new JButton(cleanIcon);
        toolBar.add(cleanField);

        eraser = new JButton(eraserIcon);
        toolBar.add(eraser);

        penTool = new JButton(penIcon);
        toolBar.add(penTool);

        lineTool = new JButton(lineIcon);
        toolBar.add(lineTool);

        starTool = new JButton(starIcon);
        toolBar.add(starTool);

        fillTool = new JButton(fillIcon);
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

        anyColorButton = new JButton(anyColorIcon);
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
        exitItem.setHorizontalAlignment(SwingConstants.RIGHT);

        fileMenu.add(exitItem);
        fileMenu.add(loadItem);
        fileMenu.add(saveItem);

        viewMenu = new JMenu("View");
        menuBar.add(viewMenu);

        penItem = new JMenuItem("Pen");
        penItem.setHorizontalAlignment(SwingConstants.RIGHT);

        lineItem = new JMenuItem("Line");
        lineItem.setHorizontalAlignment(SwingConstants.RIGHT);

        starItem = new JMenuItem("Star");
        starItem.setHorizontalAlignment(SwingConstants.RIGHT);

        fillItem = new JMenuItem("Fill");
        fillItem.setHorizontalAlignment(SwingConstants.RIGHT);

        viewMenu.add(penItem);
        viewMenu.add(lineItem);
        viewMenu.add(starItem);
        viewMenu.add(fillItem);

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

        /*JSlider slider = createSlider();
        slider.setMaximum(20);
        slider.setMinimum(1);
        slider.setValue(5);
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
        });*/

        options.addActionListener(e -> {
            /*int penSize = JOptionPane.showOptionDialog(this,
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
            }*/
            int confirm  = JOptionPane.showConfirmDialog(this, optionsFrame, "Options", JOptionPane.OK_CANCEL_OPTION);
            if(JOptionPane.OK_OPTION == confirm)
            {
                int size = optionsFrame.getPenSize();
                field.setThickness(size);
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
            field.setPenStyle(DrawField.penStyle.ERASER);
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

        /*View Menu action listeners*/
        penItem.addActionListener(e -> {
            field.setPenStyle(DrawField.penStyle.PEN);
        });

        lineItem.addActionListener(e -> {
            field.setPenStyle(DrawField.penStyle.LINE);
        });

        starItem.addActionListener(e -> {
            field.setPenStyle(DrawField.penStyle.STAR);
        });

        fillItem.addActionListener(e -> {
            field.setPenStyle(DrawField.penStyle.FILL);
        });

        this.setJMenuBar(menuBar);
        this.setVisible(true);
        this.pack();
    }

    public static void main(String[] args) throws IOException
    {
        MainFrame mainFrame = new MainFrame();
    }
}