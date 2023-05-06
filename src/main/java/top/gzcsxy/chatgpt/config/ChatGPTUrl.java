package top.gzcsxy.chatgpt.config;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * [一句话描述该类的功能]
 *
 * @author : [chao]
 * @version : [v1.0]
 * @createTime : [2023/5/6 9:42]
 */
@Getter
@AllArgsConstructor
public enum ChatGPTUrl {
    COMPLETIONS("https://api.openai.com/v1/completions"),
    ;

    private String url;
}
