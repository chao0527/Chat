package top.gzcsxy.web.controlller;

import org.springframework.web.bind.annotation.*;
import top.gzcsxy.chatgpt.entity.chat.Message;
import top.gzcsxy.web.result.Result;
import top.gzcsxy.web.service.ChatService;

import java.util.List;

import static top.gzcsxy.web.result.Result.*;

/**
 * [一句话描述该类的功能]
 *
 * @author : [chao]
 * @version : [v1.0]
 * @createTime : [2023/5/6 12:10]
 */
@RequestMapping("/api")
@RestController
public class ChatController {

    @PostMapping("/chat")
    public Result<List<Message>> chat(@RequestParam("userMessage") String userMessage) {
        List<Message> gptMessage = new ChatService().chat(userMessage);
        return OK(gptMessage);
    }

    @PostMapping("/sqlchat")
    public Result<List<Message>> sqlChat(@RequestParam("Schema") String schema, @RequestParam("userMessage") String userMessage){

        List<Message> gptMessage=new ChatService().chat(schema+userMessage);
        return OK(gptMessage);
    }
}
