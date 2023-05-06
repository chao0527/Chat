package top.gzcsxy.chatgpt.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * [一句话描述该类的功能]
 *
 * @author : [chao]
 * @version : [v1.0]
 * @createTime : [2023/5/6 10:58]
 */
public class ChatGPTKey {
    public static String getProperties(){
        Properties prop = new Properties();
        InputStream input = null;

        try {
            input = ChatGPTKey.class.getClassLoader().getResourceAsStream("config.properties");
            prop.load(input);
           return prop.getProperty("ApiKey");
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
        return "";
    }
}
