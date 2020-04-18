package ma.pca.ImageToMatrix;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;
import java.io.IOException;

public class readyml {

    private String configPath;
    private config config;

    public readyml() {
        this.configPath = "config/config.yml";
        File file = new File(this.configPath);
        //Instantiating a new ObjectMapper as a YAMLFactory
        ObjectMapper om = new ObjectMapper(new YAMLFactory());
        // Mapping the employee from the YAML file to the Employee class
        config configObject = null;
        try {
            configObject = om.readValue(file, config.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.config = configObject;
    }

    public config getConfig(){
        return this.config;
    }

}
