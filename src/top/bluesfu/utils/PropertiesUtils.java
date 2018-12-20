package top.bluesfu.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * @author fsy
 */
public class PropertiesUtils {
    private static Properties prop;
    static {
        try {
            prop=new Properties();
            prop.load(new FileInputStream("/home/fsy/IdeaProjects/StoreProject/src/top/bluesfu/utils/database.properties"));
        }catch (FileNotFoundException e){
            System.out.println("配置文件加载错误");
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static String getDiverProperties(){
        return prop.getProperty("driverClassName");
    }

    public static String getUrlProperties(){
        return prop.getProperty("url");
    }

    public static String getUserNameProperties(){
        return prop.getProperty("username");
    }

    public static String getPasswordProperties(){
        return prop.getProperty("password");
    }
}
