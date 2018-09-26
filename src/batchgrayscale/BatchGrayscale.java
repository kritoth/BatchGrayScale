/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package batchgrayscale;

import edu.duke.*;
import java.io.File;

/**
 *
 * @author tians
 */
public class BatchGrayscale {
    
    /*
     * To make greyscale an image, each of its pixel's RGB values has to be set to the average of the RGB values of the original pixel
     * eg. RGB(100,200,30) has to be converted to (100+200+30)/3=110 RGB(110,110,110)
    */
    private ImageResource makeGrey(ImageResource inImage){
        ImageResource outImage = new ImageResource(inImage.getWidth(), inImage.getHeight());
        
        for(Pixel p : outImage.pixels()){
            Pixel currentPixInIm = inImage.getPixel(p.getX(), p.getY());
            int average = (currentPixInIm.getRed() + currentPixInIm.getGreen() + currentPixInIm.getBlue())/3;
            p.setRed(average);
            p.setGreen(average);
            p.setBlue(average);
        }
        return outImage;
    }
    
    public void testMakeGray(){
        ImageResource ir = new ImageResource();
        ImageResource irGray = makeGrey(ir);
        irGray.draw();
        
    }
    
    public void selectAndConvertMany(){
        DirectoryResource dir = new DirectoryResource();
        for(File f : dir.selectedFiles()){
            ImageResource imageOrigin = new ImageResource(f);
            ImageResource imageGrey = makeGrey(imageOrigin);
            imageGrey.draw();
        }
    }
    
    public void selectConvertAndSaveMany(){
        DirectoryResource dir = new DirectoryResource();
        for(File f : dir.selectedFiles()){
            ImageResource imageOrigin = new ImageResource(f);
            ImageResource imageGrey = makeGrey(imageOrigin);
            imageGrey.setFileName("images/grey-" + f.getName());
            imageGrey.save();
        }
    }
    
}
