package ru.nsu.fit.g20202.vartazaryan.frames;

import ru.nsu.fit.g20202.vartazaryan.DrawField;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class LoadFrame extends JFrame
{
    private DrawField drawField;

    public LoadFrame(DrawField drawField)
    {
        this.setVisible(false);
        this.drawField = drawField;
    }

    public void loadImage() throws IOException {
        BufferedImage newImage;

        System.out.println("Loading...");

        FileDialog load = new FileDialog(this, "Загрузить изображение", FileDialog.LOAD);
        load.setFile("*.png; *.jpg; *.jpeg;");
        load.setVisible(true);
        String file = load.getDirectory()+load.getFile();
        System.out.println("File name is "+file);
        if(file != null)
        {
            newImage = ImageIO.read(new File(file));
            drawField.setImage(newImage);
        }
    }
}
