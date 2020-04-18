package ma.pca.ImageToMatrix;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) throws IOException {
        readyml yml = new readyml();
        Utils utils = new Utils();
        BufferedImage[] images = utils.getImg(yml.getConfig().getImage_directory());
        String[] file_names = utils.getFileName(yml.getConfig().getImage_directory());
        String[] RGBdirectories = new String[]{yml.getConfig().getRed_matrix_directory(),yml.getConfig().getGreen_matrix_directory(),yml.getConfig().getBlue_matrix_directory()};
        Iterator<BufferedImage> it_img = Arrays.asList(images).iterator();
        Iterator<String> it_file = Arrays.asList(file_names).iterator();

        int counter = 0;
        while (it_img.hasNext() && it_file.hasNext()) {
            BufferedImage image = it_img.next();
            String file_name = it_file.next();
            ImageToMatrix image_to_matrix = new ImageToMatrix();
            image_to_matrix.SetMatrix(image);
            image_to_matrix.MatrixToCsv(image_to_matrix, image, file_name, RGBdirectories[0],RGBdirectories[1], RGBdirectories[2]);
            System.out.println("CSV files for image number " + counter + " are completed!");
            counter = counter + 1;
        }
    }
}