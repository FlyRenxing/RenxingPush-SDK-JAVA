package cc.renxing;

import cc.renxing.model.RenxingPushResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;

import static cc.renxing.model.MsgMeta.MSG_TYPE_QQ;

class MessageToolsTest {

    @Test
    void send() throws JsonProcessingException {
        RenxingPushResponse<String> response = new MessageTools("nL6GnqR6dw").send("这是一条测试消息", MSG_TYPE_QQ, "1277489864");
        System.out.println(response);
    }
}
