package ru.nsu.fit.g20202.vartazaryan.frames;

import ru.nsu.fit.g20202.vartazaryan.DrawField;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class SaveFrame extends JFrame
{
    private DrawField drawField;

    public SaveFrame(DrawField field)
    {
        this.setVisible(false);
        setBounds(400, 100, 300, 300);
        drawField = field;
    }

    public void saveImage() throws IOException
    {
        FileDialog save = new FileDialog(this, "Сохранить изображение", FileDialog.SAVE);
        save.setVisible(true);
        String name = save.getDirectory() + save.getFile() + ".png"; // try getDirectory
        System.out.println(name);
        File image = new File(name);
        ImageIO.write(drawField.getImage(), "png", image);
        System.out.println("Image saved!");
    }
}
