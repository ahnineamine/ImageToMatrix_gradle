package ma.pca.ImageToMatrix;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ImageToMatrix {

    private int[][] red_arr;
    private int[][] blue_arr;
    private int[][] green_arr;

    public ImageToMatrix(){
        this.red_arr = null;
        this.blue_arr = null;
        this.green_arr = null;
    }

    //populate rbg matrices with the correspondent values
    public void SetMatrix(BufferedImage img){
        //get the image
        //BufferedImage img = getImg();
        //get image width and height
        Utils utils = new Utils();
        int[] dimension = utils.ImageDimension(img);
        int height = dimension[0];
        int width = dimension[1];
        //color matrix
        int[][] red_arr = new int[height][width];
        int[][] blue_arr = new int[height][width];
        int[][] green_arr = new int[height][width];

        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                Color mycolor = new Color(img.getRGB(col, row));
                red_arr[row][col] = mycolor.getRed();
                blue_arr[row][col] = mycolor.getBlue();
                green_arr[row][col] = mycolor.getGreen();
            }
        }
        this.red_arr = red_arr;
        this.blue_arr = blue_arr;
        this.green_arr = green_arr;

        //return new ImageToMatrix(red_arr, blue_arr, green_arr);
    }

    //matrix to csv
    public void MatrixToCsv(ImageToMatrix matrix, BufferedImage img, String filename, String redDirectory, String greenDirectory, String blueDirectory){
        //initiate StringBuilders
        StringBuilder builder_red = new StringBuilder();
        StringBuilder builder_green = new StringBuilder();
        StringBuilder builder_blue = new StringBuilder();

        //get the image
        //BufferedImage img = getImg();
        //get image width and height
        Utils utils = new Utils();
        int[] dimension = utils.ImageDimension(img);
        int height = dimension[0];
        int width = dimension[1];

        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                builder_red.append(matrix.red_arr[row][col]+"");
                builder_green.append(matrix.green_arr[row][col]+"");
                builder_blue.append(matrix.blue_arr[row][col]+"");
                //if this is not the last row element
                if(col < width - 1){
                    //then add comma
                    builder_red.append(",");
                    builder_green.append(",");
                    builder_blue.append(",");
                }
            }
            builder_red.append("\n");//append new line at the end of the row
            builder_green.append("\n");//append new line at the end of the row
            builder_blue.append("\n");//append new line at the end of the row
        }

        {
            try {
                //initiate BufferWritters
                BufferedWriter buffer_red = new BufferedWriter(new FileWriter(redDirectory+"/red_"+filename+".csv"));
                BufferedWriter buffer_green = new BufferedWriter(new FileWriter(greenDirectory+"/green_"+filename+".csv"));
                BufferedWriter buffer_blue = new BufferedWriter(new FileWriter(blueDirectory+"/blue_"+filename+".csv"));

                //write in files
                buffer_red.write(builder_red.toString());
                buffer_green.write(builder_green.toString());
                buffer_blue.write(builder_blue.toString());
                buffer_red.close();
                buffer_green.close();
                buffer_blue.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
