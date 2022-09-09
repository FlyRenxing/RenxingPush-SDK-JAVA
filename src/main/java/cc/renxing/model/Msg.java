package cc.renxing.model;


import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.Serializable;

/**
 * 定义了消息的数据结构
 *
 * @author Renxing
 * @tag 消息类
 */
public class Msg implements Serializable {
    /**
     * 消息内容
     *
     * @mock 这是一条消息
     */

    private String content;
    /**
     * 消息元数据
     */

    private MsgMeta meta;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        if (content.length() > 3000) {
            content = content.substring(0, 3000);
        }
        this.content = content;
    }

    public MsgMeta getMeta() {
        return meta;
    }

    public void setMeta(MsgMeta meta) {
        this.meta = meta;
    }

    @Override
    public String toString() {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.valueToTree(this).toString();
    }
}
