package ru.nsu.fit.g20202.vartazaryan;

import ru.nsu.fit.g20202.vartazaryan.frames.LoadFrame;
import ru.nsu.fit.g20202.vartazaryan.frames.OptionsPanel;
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
    private OptionsPanel optionsPanel;

    private JToolBar toolBar;
    private JButton options;
    private JButton eraser;
    private JButton cleanField;
    private JButton penTool;
    private JButton lineTool;
    private JButton polygonTool;
    private JButton starTool;
    private JButton fillTool;
    private JButton redColor;
    private JButton blackColor;
    private JButton greenColor;
    private JButton blueColor;
    private JButton anyColorButton;
    private JButton backTool;
    private JLabel curToolLabel;
    private JButton curToolButton;

    private JMenuBar menuBar;
    private JMenu fileMenu;
    private JMenuItem exitItem;
    private JMenuItem saveItem;
    private JMenuItem loadItem;
    private JMenu aboutMenu;
    private JMenuItem aboutItem;
    private JMenu viewMenu;
    private JMenuItem fieldSize;
    private JRadioButtonMenuItem penItem;
    private JRadioButtonMenuItem lineItem;
    private JRadioButtonMenuItem polygonItem;
    private JRadioButtonMenuItem starItem;
    private JRadioButtonMenuItem fillItem;
    private JRadioButtonMenuItem eraserItem;
    private JMenuItem clearItem;

    public MainFrame() throws IOException
    {
        super("Paint");

        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setBounds(400, 100, 640, 480);
        setMinimumSize(new Dimension(640, 480));

        field = new DrawField();
        saveFrame = new SaveFrame(field);
        loadFrame = new LoadFrame(field);
        optionsPanel = new OptionsPanel(field);

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
        ImageIcon polygonIcon = new ImageIcon(ImageIO.read(new File("C:\\Users\\eduar\\Desktop\\Проекты\\Paint\\Paint\\src\\main\\java\\ru\\nsu\\fit\\g20202\\vartazaryan\\images\\polygon.png")));
        ImageIcon backIcon = new ImageIcon(ImageIO.read(new File("C:\\Users\\eduar\\Desktop\\Проекты\\Paint\\Paint\\src\\main\\java\\ru\\nsu\\fit\\g20202\\vartazaryan\\images\\back.png")));
        ImageIcon bookIcon = new ImageIcon(ImageIO.read(new File("C:\\Users\\eduar\\Desktop\\Проекты\\Paint\\Paint\\src\\main\\java\\ru\\nsu\\fit\\g20202\\vartazaryan\\images\\book.png")));


        /*TOOLBAR SECTION*/
        toolBar = new JToolBar();
        toolBar.setFloatable(false);
        toolBar.setRollover(false);
        toolBar.setVisible(true);

        add(toolBar, BorderLayout.NORTH);

        options = new JButton(optionsIcon);
        options.setFocusPainted(false);
        toolBar.add(options);

        cleanField = new JButton(cleanIcon);
        cleanField.setFocusPainted(false);
        toolBar.add(cleanField);

        eraser = new JButton(eraserIcon);
        eraser.setFocusPainted(false);
        toolBar.add(eraser);

        penTool = new JButton(penIcon);
        penTool.setFocusPainted(false);
        toolBar.add(penTool);

        lineTool = new JButton(lineIcon);
        lineTool.setFocusPainted(false);
        toolBar.add(lineTool);

        polygonTool = new JButton(polygonIcon);
        polygonTool.setFocusPainted(false);
        toolBar.add(polygonTool);

        starTool = new JButton(starIcon);
        starTool.setFocusPainted(false);
        toolBar.add(starTool);

        fillTool = new JButton(fillIcon);
        fillTool.setFocusPainted(false);
        toolBar.add(fillTool);

        redColor = new JButton("     ");
        redColor.setFocusPainted(false);
        redColor.setBackground(Color.RED);
        toolBar.add(redColor);

        greenColor = new JButton("     ");
        greenColor.setFocusPainted(false);
        greenColor.setBackground(Color.GREEN);
        toolBar.add(greenColor);

        blueColor = new JButton("     ");
        blueColor.setFocusPainted(false);
        blueColor.setBackground(Color.BLUE);
        toolBar.add(blueColor);

        blackColor = new JButton("     ");
        blackColor.setFocusPainted(false);
        blackColor.setBackground(Color.BLACK);
        toolBar.add(blackColor);

        anyColorButton = new JButton(anyColorIcon);
        anyColorButton.setFocusPainted(false);
        toolBar.add(anyColorButton);

        backTool = new JButton(backIcon);
        backTool.setFocusPainted(false);
        toolBar.add(backTool);

        curToolLabel = new JLabel("Tool:");
        toolBar.add(curToolLabel);

        curToolButton = new JButton(penIcon);
        curToolButton.setFocusPainted(false);
        toolBar.add(curToolButton);
        /*---------------*/

        /*FILE MENUBAR SECTION*/
        menuBar = new JMenuBar();
        fileMenu = new JMenu("File");
        menuBar.add(fileMenu);

        saveItem = new JMenuItem("Save");

        loadItem = new JMenuItem("Load");

        exitItem = new JMenuItem("Exit");

        fileMenu.add(exitItem);
        fileMenu.add(loadItem);
        fileMenu.add(saveItem);
        /*---------------------*/

        /*VIEW MENUBAR SECTION*/
        viewMenu = new JMenu("View");
        menuBar.add(viewMenu);

        eraserItem = new JRadioButtonMenuItem("Eraser");

        clearItem = new JMenuItem("Clear");

        penItem = new JRadioButtonMenuItem("Pen");

        lineItem = new JRadioButtonMenuItem("Line");

        polygonItem = new JRadioButtonMenuItem("Polygon");

        starItem = new JRadioButtonMenuItem("Star");

        fillItem = new JRadioButtonMenuItem("Fill");

        fieldSize = new JMenuItem("Resize");

        viewMenu.add(penItem);
        viewMenu.add(lineItem);
        viewMenu.add(polygonItem);
        viewMenu.add(starItem);
        viewMenu.add(fillItem);
        viewMenu.add(eraserItem);
        viewMenu.add(clearItem);
        viewMenu.add(fieldSize);
        /*------------------------*/

        /*ABOUT MENUBAR SECTION*/
        aboutMenu = new JMenu("About");
        menuBar.add(aboutMenu);

        aboutItem = new JMenuItem("About");
        aboutMenu.add(aboutItem);
        /*----------------------*/

        /*FILE ACTION LISTENERS*/
        exitItem.addActionListener(e -> System.exit(0));

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
        /*---------------------*/

        /*TOOLBAR ACTION LISTENERS*/
        penTool.addActionListener(e -> {
            field.setPenStyle(DrawField.penStyle.PEN);
            curToolButton.setIcon(penIcon);

            penItem.setSelected(true);
            lineItem.setSelected(false);
            eraserItem.setSelected(false);
            polygonItem.setSelected(false);
            starItem.setSelected(false);
            fillItem.setSelected(false);
        });

        starTool.addActionListener(e -> {
            field.setPenStyle(DrawField.penStyle.STAR);
            curToolButton.setIcon(starIcon);

            penItem.setSelected(false);
            lineItem.setSelected(false);
            eraserItem.setSelected(false);
            polygonItem.setSelected(false);
            starItem.setSelected(true);
            fillItem.setSelected(false);
        });

        polygonTool.addActionListener(e -> {
            field.setPenStyle(DrawField.penStyle.POLYGON);
            curToolButton.setIcon(polygonIcon);

            penItem.setSelected(false);
            lineItem.setSelected(false);
            eraserItem.setSelected(false);
            polygonItem.setSelected(true);
            starItem.setSelected(false);
            fillItem.setSelected(false);
        });

        lineTool.addActionListener(e -> {
            field.setPenStyle(DrawField.penStyle.LINE);
            curToolButton.setIcon(lineIcon);

            penItem.setSelected(false);
            lineItem.setSelected(true);
            eraserItem.setSelected(false);
            polygonItem.setSelected(false);
            starItem.setSelected(false);
            fillItem.setSelected(false);
        });

        fillTool.addActionListener(e -> {
            field.setPenStyle(DrawField.penStyle.FILL);
            curToolButton.setIcon(fillIcon);

            penItem.setSelected(false);
            lineItem.setSelected(false);
            eraserItem.setSelected(false);
            polygonItem.setSelected(false);
            starItem.setSelected(false);
            fillItem.setSelected(true);
        });

        cleanField.addActionListener(e -> {
            field.setWhite();
        });

        options.addActionListener(e -> {
            int confirm  = JOptionPane.showConfirmDialog(this, optionsPanel, "Options",JOptionPane.OK_CANCEL_OPTION);
            if(JOptionPane.OK_OPTION == confirm)
            {
                int size = optionsPanel.getPenSize();
                field.setThickness(size);
                field.setPolygonParameters(optionsPanel.getAngle(), optionsPanel.getNumOfVertices(), optionsPanel.getBigRadius(), optionsPanel.getSmallRadius());
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
            curToolButton.setIcon(eraserIcon);
        });

        anyColorButton.addActionListener(e -> {
            Color newColor = JColorChooser.showDialog(null, "Colors", Color.BLACK);
            field.setColor(newColor);
            anyColorButton.setBackground(newColor);
        });

        backTool.addActionListener(e -> {
            field.back();
        });
        /*-----------------------------*/

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
        eraserItem.addActionListener(e -> {
            field.setPenStyle(DrawField.penStyle.ERASER);
            curToolButton.setIcon(eraserIcon);
        });

        clearItem.addActionListener(e -> {
            field.setWhite();
        });

        penItem.addActionListener(e -> {
            field.setPenStyle(DrawField.penStyle.PEN);
            curToolButton.setIcon(penIcon);
        });

        lineItem.addActionListener(e -> {
            field.setPenStyle(DrawField.penStyle.LINE);
            curToolButton.setIcon(lineIcon);
        });

        polygonItem.addActionListener(e -> {
            field.setPenStyle(DrawField.penStyle.POLYGON);
            curToolButton.setIcon(polygonIcon);
        });

        starItem.addActionListener(e -> {
            field.setPenStyle(DrawField.penStyle.STAR);
            curToolButton.setIcon(starIcon);
        });

        fillItem.addActionListener(e -> {
            field.setPenStyle(DrawField.penStyle.FILL);
            curToolButton.setIcon(fillIcon);
        });

        SpinnerNumberModel widthModel = new SpinnerNumberModel(640, 640, 1920, 1);
        JSpinner widthField = new JSpinner(widthModel);
        SpinnerNumberModel heightModel = new SpinnerNumberModel(480, 480, 900, 1);
        JSpinner heightField = new JSpinner(heightModel);
        JPanel resizePanel = new JPanel();
        resizePanel.add(new JLabel("Width: "));
        resizePanel.add(widthField);
        resizePanel.add(new JLabel("Height:"));
        resizePanel.add(heightField);

        fieldSize.addActionListener(e -> {
            int confirm = JOptionPane.showConfirmDialog(null, resizePanel, "Resize", JOptionPane.OK_CANCEL_OPTION);

            if(JOptionPane.OK_OPTION == confirm)
            {
                field.resizeImage((int) widthField.getValue(), (int) heightField.getValue());
            }
        });

        aboutItem.addActionListener(e -> {
            JOptionPane.showConfirmDialog(
                    null,
                    "How to work in this program:\n" +
                    "\n" +
                    "* Button with gears will open program's options. You can set size of pen, number of vertexes for shapes, angle(to rotate\n" +
                    "  shapes) and radius  for shapes.\n" +
                    "\n" +
                    "* Button with broom clears the whole canvas.\n" +
                    "\n" +
                    "* Button with pen allows you free draw. Thickness can be changed in options.\n" +
                    "\n" +
                    "* Button with line draws a line. You have to make two clicks on canvas: first click - is the start of the line, second\n" +
                    "  click - is the end of the line. Thickness can be changed in options. If thickness = 1, then line will be drawn with\n" +
                    "  Brezenhem algorithm.\n" +
                    "\n" +
                    "* Button with polygon draws a shape with n vertices. Number of vertices can be set in options. Also in options you can\n" +
                    "  set shape's radius(it makes shape bigger) and angle, that rotates shape.\n" +
                    "\n" +
                    "* Button with star draws a star with n-vertices. Number of vertices can be set in options. Also in options you can\n" +
                    "  set star's angle, that rotates it.\n" +
                    "\n" +
                    "* Button with bucket fills area you clicked with chosen color.\n" +
                    "\n" +
                    "* Buttons with colors changing color.\n" +
                    "\n" +
                    "* Button with palette allow you to choose any color you want.\n" +
                    "\n" +
                    "* Button with arrow canceling your previous move.\n" +
                    "\n" +
                    "                                            ENJOY\n" +
                    "                                            \n" +
                    "Author: Vartazaryan Eduard Araevich, FIT NSU                                            ",
                    "About",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.DEFAULT_OPTION,
                    bookIcon);
        });
        /*-----------*/
        this.setJMenuBar(menuBar);
        this.setVisible(true);
        this.pack();
    }

    private void unClickOtherTools()
    {

    }

    public static void main(String[] args) throws IOException
    {
        MainFrame mainFrame = new MainFrame();
    }
}