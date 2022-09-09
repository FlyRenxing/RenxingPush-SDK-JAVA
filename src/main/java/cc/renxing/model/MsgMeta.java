package cc.renxing.model;


import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.Serializable;

/**
 * 一般包含在消息类中的元数据，比如消息类别等
 *
 * @author Renxing
 * @tag 消息元数据类
 */

public class MsgMeta implements Serializable {
    public static final String MSG_TYPE_QQ = "qq";
    public static final String MSG_TYPE_QQ_GROUP = "qq_group";
    public static final String MSG_TYPE_TELEGRAM = "telegram";
    /**
     * 消息类型，目前仅支持"qq"、"qq_group、telegram"
     *
     * @mock qq
     */

    private String type;
    /**
     * 消息元数据，与type对应。
     * qq-QQ号，qq_group-QQ群号，telegram-telegramID
     *
     * @mock 1277489864
     */
    private String data;
    /**
     * 指定QQ机器人号码
     *
     * @mock 1277489864
     */
    private Long qqBot;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Long getQqBot() {
        return qqBot;
    }

    public void setQqBot(Long qqBot) {
        this.qqBot = qqBot;
    }

    @Override
    public String toString() {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.valueToTree(this).toString();
    }
}
