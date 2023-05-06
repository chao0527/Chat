package top.gzcsxy.chatgpt.entity.billing;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * 描述：
 *
 * @author : [chao]
 * @version : [v1.0]
 * @createTime : [2023/5/6 9:58]
 */
@Data
public class Grants {
    private String object;
    @JsonProperty("data")
    private List<Datum> data;
}
