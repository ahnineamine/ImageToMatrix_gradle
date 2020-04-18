package ma.pca.ImageToMatrix;

import com.fasterxml.jackson.annotation.JsonProperty;

public class config {
    @JsonProperty
    private String image_directory;
    @JsonProperty
    private String red_matrix_directory;
    @JsonProperty
    private String green_matrix_directory;
    @JsonProperty
    private String blue_matrix_directory;

    public config(String image_directory, String red_matrix_directory, String green_matrix_directory, String blue_matrix_directory) {
        this.image_directory = image_directory;
        this.red_matrix_directory = red_matrix_directory;
        this.green_matrix_directory = green_matrix_directory;
        this.blue_matrix_directory = blue_matrix_directory;
    }

    public config(){}

    public String getImage_directory() {
        return image_directory;
    }

    public void setImage_directory(String image_directory) {
        this.image_directory = image_directory;
    }

    public String getRed_matrix_directory() {
        return red_matrix_directory;
    }

    public void setRed_matrix_directory(String red_matrix_directory) {
        this.red_matrix_directory = red_matrix_directory;
    }

    public String getGreen_matrix_directory() {
        return green_matrix_directory;
    }

    public void setGreen_matrix_directory(String green_matrix_directory) {
        this.green_matrix_directory = green_matrix_directory;
    }

    public String getBlue_matrix_directory() {
        return blue_matrix_directory;
    }

    public void setBlue_matrix_directory(String blue_matrix_directory) {
        this.blue_matrix_directory = blue_matrix_directory;
    }

    @Override
    public String toString() {
        return "config{" +
                "image_directory='" + image_directory + '\'' +
                ", red_matrix_directory='" + red_matrix_directory + '\'' +
                ", green_matrix_directory='" + green_matrix_directory + '\'' +
                ", blue_matrix_directory='" + blue_matrix_directory + '\'' +
                '}';
    }
}
