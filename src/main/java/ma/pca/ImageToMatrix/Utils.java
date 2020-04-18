package ma.pca.ImageToMatrix;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Utils {

    //get list of file names
    public static String[] getFileName(String path) {
        File[] f = new File(path).listFiles();
        int length_file = f.length;
        String[] file_name = new String[length_file];
        int counter = 0;
        for (File file : f){
            String name = file.getName().replaceFirst("[.][^.]+$", "");
            file_name[counter] = name;
            counter = counter + 1;
        }
        return file_name;
    }

    //get list of images
    public static BufferedImage[] getImg(String path) {
        File[] f = new File(path).listFiles();
        int length_file = f.length;
        BufferedImage[] images = new BufferedImage[length_file];
        int counter = 0;
        for (File file : f){
            BufferedImage img = null;
            try {
                img = ImageIO.read(file);
                System.out.println("image number " + counter + " is ready!");
                images[counter]=img;
                System.out.println("image number " + counter + " is in !");
                counter = counter + 1;

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return images;
    }

    //get image width and height
    public static int[] ImageDimension(BufferedImage img){
        int width = img.getWidth();
        int height = img.getHeight();
        int[] dim = new int[]{height,width};
        return dim;
    }

}
