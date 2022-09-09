package cc.renxing.model;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.Serializable;

/**
 * 所有的最终反馈会被包装为此类
 *
 * @author Renxing
 * @tag 结果类
 */
public class RenxingPushResponse<T> implements Serializable {
    /**
     * 结果标志，true为成功，false为失败
     */
    private boolean flag;
    /**
     * 结果消息，一般反馈给用户
     *
     * @mock 返回的消息
     */
    private String msg;
    /**
     * 结果数据，一般反馈给前端进行处理
     */
    private T data;

    public RenxingPushResponse() {
    }

    public RenxingPushResponse(String msg, T data) {
        this.flag = true;
        this.msg = msg;
        this.data = data;
    }

    public RenxingPushResponse(boolean b, String msg, T data) {
        this.flag = b;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 自定义异常返回的结果
     *
     * @param e 异常消息
     * @return
     */
    public static RenxingPushResponse<String> defineError(String e) {
        return new RenxingPushResponse<>(false, e, null);
    }

    /**
     * 其他异常处理方法返回的结果
     *
     * @param e 异常
     * @return
     */
    public static RenxingPushResponse<String> otherError(Exception e) {
        return new RenxingPushResponse<>(false, "未知异常！信息：" + e.getMessage(), null);
    }

    @Override
    public String toString() {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.valueToTree(this).toString();
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
