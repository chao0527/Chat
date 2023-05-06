package top.gzcsxy.chatgpt.entity.chat;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.io.Serializable;

/**
 * [一句话描述该类的功能]
 *
 * @author : [chao]
 * @version : [v1.0]
 * @createTime : [2023/5/6 9:46]
 */
@Data
@ApiModel(description = "gpt返回消息")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Message implements Serializable {

    /**
     * 目前支持三中角色参考官网，进行情景输入：https://platform.openai.com/docs/guides/chat/introduction
     */
    @ApiModelProperty(value = "角色")
    private String role;

    @ApiModelProperty(value = "描述主题信息")
    private String content;

    @ApiModelProperty(value = "名称")
    private String name;

    public static Builder builder() {
        return new Builder();
    }

    /**
     * 构造函数
     *
     * @param role    角色
     * @param content 描述主题信息
     * @param name    name
     */
    public Message(String role, String content, String name) {
        this.role = role;
        this.content = content;
        this.name = name;
    }

    public Message() {
    }

    private Message(Builder builder) {
        setRole(builder.role);
        setContent(builder.content);
        setName(builder.name);
    }


    @Getter
    @AllArgsConstructor
    public enum Role {

        SYSTEM("system"),
        USER("user"),
        ASSISTANT("assistant"),
        ;
        private String name;
    }

    public static final class Builder {
        private String role;
        private String content;
        private String name;

        public Builder() {
        }

        public Builder role(Role role) {
            this.role = role.getName();
            return this;
        }

        public Builder content(String content) {
            this.content = content;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Message build() {
            return new Message(this);
        }
    }
}
