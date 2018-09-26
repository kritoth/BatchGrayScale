/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package batchgrayscale;

import edu.duke.DirectoryResource;
import edu.duke.ImageResource;
import edu.duke.Pixel;
import java.io.File;

/**
 *
 * @author tians
 */
public class BatchInversions {

    /*
     * To make greyscale an image, each of its pixel's RGB values has to be set to 
     * the exact opposite within the 0 to 255 range. 
     * eg. RGB(34,198,240)has to converted to RGB(221,57,15),
     * ie. 255-34=221, 255-198=57, 255-240=15.
     */
    private ImageResource makeInversion(ImageResource inImage) {
        ImageResource outImage = new ImageResource(inImage.getWidth(), inImage.getHeight());

        for (Pixel p : outImage.pixels()) {
            Pixel currentPixInIm = inImage.getPixel(p.getX(), p.getY());
            p.setRed(255 - currentPixInIm.getRed());
            p.setGreen(255 - currentPixInIm.getGreen());
            p.setBlue(255 - currentPixInIm.getBlue());
        }
        return outImage;
    }

    public void testMakeInversions() {
        ImageResource ir = new ImageResource();
        ImageResource irGray = makeInversion(ir);
        irGray.draw();
    }

    public void selectAndConvertMany() {
        DirectoryResource dir = new DirectoryResource();
        for (File f : dir.selectedFiles()) {
            ImageResource imageOrigin = new ImageResource(f);
            ImageResource imageInvert = makeInversion(imageOrigin);
            imageInvert.draw();
        }
    }

    public void selectConvertAndSaveMany() {
        DirectoryResource dir = new DirectoryResource();
        for (File f : dir.selectedFiles()) {
            ImageResource imageOrigin = new ImageResource(f);
            ImageResource imageInvert = makeInversion(imageOrigin);
            imageInvert.setFileName("images/inverted-" + f.getName());
            imageInvert.save();
        }
    }
}
