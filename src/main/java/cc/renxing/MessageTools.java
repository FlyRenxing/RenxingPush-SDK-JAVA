package cc.renxing;

import cc.renxing.model.Msg;
import cc.renxing.model.MsgMeta;
import cc.renxing.model.RenxingPushResponse;
import cc.renxing.utils.HttpTools;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import static cc.renxing.model.MsgMeta.*;

public class MessageTools {
    public final String SEND_URL = "/msg/send/";

    private final String cipher;

    private final ObjectMapper mapper = new ObjectMapper();

    public MessageTools(String cipher) {
        this.cipher = cipher;
    }

    public RenxingPushResponse<String> send(String message, String appType, String to) throws JsonProcessingException {
        return send(message, appType, to, null);
    }

    public RenxingPushResponse<String> send(String message, String appType, String to, Long formQQBot) throws JsonProcessingException {
        if (!appType.equals(MSG_TYPE_QQ) && !appType.equals(MSG_TYPE_QQ_GROUP) && !appType.equals(MSG_TYPE_TELEGRAM)) {
            return RenxingPushResponse.defineError("appType参数错误");
        }
        if (appType.equals(MSG_TYPE_TELEGRAM)) {
            if (formQQBot != null) {
                return RenxingPushResponse.defineError("formQQBot参数不支持当前应用类型，请传入null或更换应用类型");
            }
        }
        Msg msg = new Msg();
        msg.setContent(message);
        MsgMeta meta = new MsgMeta();
        meta.setType(appType);
        meta.setData(to);
        if (formQQBot != null) {
            meta.setQqBot(formQQBot);
        }
        msg.setMeta(meta);
        return mapper.readValue(HttpTools.POST(SEND_URL + cipher, msg),
                new TypeReference<RenxingPushResponse<String>>() {
                });
    }

}
