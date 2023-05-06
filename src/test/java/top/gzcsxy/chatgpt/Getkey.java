package top.gzcsxy.chatgpt;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

/**
 * [一句话描述该类的功能]
 *
 * @author : [chao]
 * @version : [v1.0]
 * @createTime : [2023/5/6 10:50]
 */
public class Getkey {
    @Test
    public void getProperties(){
    Properties prop = new Properties();
    InputStream input = null;

        try {
        input = Getkey.class.getClassLoader().getResourceAsStream("config.properties");
        // 加载 properties 文件
        prop.load(input);
        // 读取属性
        String ApiKey = prop.getProperty("ApiKey");
        System.out.println("ApiKey: " + ApiKey);
    } catch (
    IOException ex) {
        ex.printStackTrace();
    } finally {
        if (input != null) {
            try {
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
}
