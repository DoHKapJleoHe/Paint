package ru.nsu.fit.g20202.vartazaryan;

import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.util.ArrayList;

public class Story
{
    private ArrayList<Raster> saves = new ArrayList<>();
    private int savesNum = 0;

    public void saveImage(Raster imageToSave)
    {
        if(savesNum > 20)
        {
            saves.remove(0);
            savesNum--;
        }
        saves.add(imageToSave);
        savesNum++;
    }

    public Raster getLastSave()
    {
        if(savesNum > 0)
        {
            Raster lastSave = saves.get(savesNum - 1);
            saves.remove(savesNum - 1);
            savesNum--;

            return lastSave;
        }
        else
        {
            return null;
        }
    }
}
