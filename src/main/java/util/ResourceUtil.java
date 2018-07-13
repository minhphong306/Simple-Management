/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author phongdm
 */
public class ResourceUtil {

    public String getConfigPath(String key) throws FileNotFoundException, IOException {
        Properties props = new Properties();
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("config.properties");
        props.load(inputStream);
        inputStream.close();

        return props.getProperty(key);
    }

}
