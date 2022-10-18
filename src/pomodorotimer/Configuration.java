/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pomodorotimer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author guilu
 * Classe cuida da configuração inicial e 
 * das alterações subsequentes de configuração
 */
public class Configuration {
    public static Properties props = new Properties();
    private static FileOutputStream fs;

    public Configuration() {
        createConfig("pomodoro.conf");
        defaultConfig();
    }
    
    
    private static void createConfig(String fname) {
        File f = new File(fname);
        if(f.exists() && !f.isDirectory()) {
            try {
                Configuration.fs = new FileOutputStream(f);
                return;
            }
            catch (FileNotFoundException e){
                System.err.println(e);
            }
        }
        try{
         f.createNewFile();
         fs =  new FileOutputStream(f);
        }
        catch (IOException x) {
            System.err.println(x);
        }
    }
    
    public void addProp(String key, String value) {
        try{
            props.setProperty(key, value);
            props.store(fs, null);
        }
        catch (IOException x){
            System.err.println(x);
        }
    }
    
    public String getProp(String key) {
        try{
            return props.getProperty(key);
        }
        catch (Exception x)
        {
            System.err.println(x);
        }
        
        return null;
    }

    private void defaultConfig() {
        addProp("focus", "1500");
    }
}
