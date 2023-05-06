package top.gzcsxy.web.result;

import lombok.Data;

/**
 * [返回信息的封装]
 *
 * @author : [chao]
 * @version : [v1.0]
 * @createTime : [4/12/2023 4:55 PM]
 */
@Data
public class Result<T> {
    private Integer code;//状态码
    private String message;//响应信息
    private T data;

    //私有化
    private Result() {
    }

    //封装返回数据
    public static <T> Result<T> build(T body, ResultCodeEnum resultCodeEnum) {
        Result<T> result = new Result<>();
        if (body != null) {
            result.setData(body);
        }
        result.setCode(resultCodeEnum.getCode());
        result.setMessage(result.getMessage());
        return result;
    }

    public static <T> Result<T> ok() {
        return build(null, ResultCodeEnum.SUCCESS);
    }

    public static <T> Result<T> OK(T data) {
        return build(data, ResultCodeEnum.SUCCESS);
    }

    public static <T> Result<T> fail() {
        return build(null, ResultCodeEnum.FAIL);
    }

    public static <T> Result<T> fail(T data) {
        return build(data, ResultCodeEnum.FAIL);
    }
}
