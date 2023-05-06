package top.gzcsxy.chatgpt.entity.common;

import lombok.Data;

import java.io.Serializable;
import java.util.List;
/**
 * 描述：
 *
 * @author : [chao]
 * @version : [v1.0]
 * @createTime : [2023/5/6 10:01]
 */
@Data
public class OpenAiResponse<T> implements Serializable {
    private String object;
    private List<T> data;
    private Error error;


    @Data
    public class Error {
        private String message;
        private String type;
        private String param;
        private String code;
    }
}
