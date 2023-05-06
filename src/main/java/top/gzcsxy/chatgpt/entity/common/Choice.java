package top.gzcsxy.chatgpt.entity.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 描述：
 *
 * @author : [chao]
 * @version : [v1.0]
 * @createTime : [2023/5/6 10:05]
 */
@Data
public class Choice implements Serializable {
    private String text;
    private long index;
    private Object logprobs;
    @JsonProperty("finish_reason")
    private String finishReason;
}