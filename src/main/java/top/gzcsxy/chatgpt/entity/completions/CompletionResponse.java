package top.gzcsxy.chatgpt.entity.completions;

import top.gzcsxy.chatgpt.entity.common.Choice;
import top.gzcsxy.chatgpt.entity.common.OpenAiResponse;
import top.gzcsxy.chatgpt.entity.common.Usage;
import lombok.Data;

import java.io.Serializable;

/**
 * 描述： 答案类
 *
 * @author : [chao]
 * @version : [v1.0]
 * @createTime : [2023/5/6 10:01]
 */
@Data
public class CompletionResponse extends OpenAiResponse implements Serializable {
    private String id;
    private String object;
    private long created;
    private String model;
    private Choice[] choices;
    private Usage usage;
}
