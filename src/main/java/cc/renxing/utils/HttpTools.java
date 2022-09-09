package cc.renxing.utils;

import cn.hutool.http.HttpUtil;

public class HttpTools {
    private static final String BASE_URL = "https://push.renxing.cc/api";

    public static String POST(String uri, Object object) {
        return HttpUtil.post(BASE_URL + uri, object.toString());
    }

    public static String POST(String uri, String jsonData) {
        return HttpUtil.post(BASE_URL + uri, jsonData);
    }
}
