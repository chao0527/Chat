package top.gzcsxy.chatgpt.entity.common;

import lombok.Data;

import java.io.Serializable;

/**
 * 描述：
 *
 * @author : [chao]
 * @version : [v1.0]
 * @createTime : [2023/5/6 10:01]
 */
@Data
public class DeleteResponse implements Serializable {
    private String id;
    private String object;
    private boolean deleted;
}
