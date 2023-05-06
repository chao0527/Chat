package top.gzcsxy.chatgpt.entity.chat;

import lombok.Data;
import top.gzcsxy.chatgpt.entity.common.Usage;

import java.util.List;

/**
 * [一句话描述该类的功能]
 *
 * @author : [chao]
 * @version : [v1.0]
 * @createTime : [2023/5/6 9:48]
 */
@Data
public class ChatCompletionResponse {
    private String id;
    private String object;
    private long created;
    private String model;
    private List<ChatChoice> choices;
    private Usage usage;
}
