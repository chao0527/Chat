package top.gzcsxy.web.service;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import top.gzcsxy.chatgpt.OpenAiClient;
import top.gzcsxy.chatgpt.config.ChatGPTKey;
import top.gzcsxy.chatgpt.entity.chat.ChatCompletion;
import top.gzcsxy.chatgpt.entity.chat.ChatCompletionResponse;
import top.gzcsxy.chatgpt.entity.chat.Message;
import top.gzcsxy.chatgpt.interceptor.OpenAILogger;
import top.gzcsxy.chatgpt.interceptor.OpenAiResponseInterceptor;
import top.gzcsxy.chatgpt.utils.FirstKeyStrategy;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * [一句话描述该类的功能]
 *
 * @author : [chao]
 * @version : [v1.0]
 * @createTime : [2023/5/6 13:26]
 */
public class ChatService {
    private OpenAiClient v2;

    public ChatService() {
    }

    public void before() {
        //可以为null
        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("127.0.0.1", 40001));
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(new OpenAILogger());
        //！！！！千万别再生产或者测试环境打开BODY级别日志！！！！
        //！！！生产或者测试环境建议设置为这三种级别：NONE,BASIC,HEADERS,！！！
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.HEADERS);
        OkHttpClient okHttpClient = new OkHttpClient
                .Builder()
                .proxy(proxy)
                .addInterceptor(httpLoggingInterceptor)
                .addInterceptor(new OpenAiResponseInterceptor())
                .connectTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .build();
        v2 = OpenAiClient.builder()
                //支持多key传入，请求时候随机选择
                .apiKey(Arrays.asList(ChatGPTKey.getProperties()))
                //自定义key的获取策略：默认KeyRandomStrategy
                //.keyStrategy(new KeyRandomStrategy())
                .keyStrategy(new FirstKeyStrategy())
                .okHttpClient(okHttpClient)
                //自己做了代理就传代理地址，没有可不不传,(关注公众号回复：openai ，获取免费的测试代理地址)
//                .apiHost("https://自己代理的服务器地址/")
                .build();
    }

    public List<Message> chat(String userMessage) {
        before();
        List<Message> gptMessage = new ArrayList<>();
        //聊天模型：gpt-3.5
        Message message = Message.builder().role(Message.Role.USER).content(userMessage).build();
        ChatCompletion chatCompletion = ChatCompletion
                .builder()
                .messages(Arrays.asList(message))
                .model(ChatCompletion.Model.GPT_3_5_TURBO.getName())
                .build();
        ChatCompletionResponse chatCompletionResponse = v2.chatCompletion(chatCompletion);
        chatCompletionResponse.getChoices().forEach(e -> {
            gptMessage.add(e.getMessage());
        });
        return gptMessage;
    }
}
