package top.gzcsxy.chatgpt.entity.billing;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 描述：金额消耗列表
 *
 * @author : [chao]
 * @version : [v1.0]
 * @createTime : [2023/5/6 9:58]
 */
@Data
public class LineItem {
    /**
     * 模型名称
     */
    private String name;
    /**
     * 消耗金额
     */
    private BigDecimal cost;
}
