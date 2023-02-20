package com.huawei.redis;

import java.io.*;

/**
 * @DESCRIPTION:
 * @PACKAGE_NAME:QinRui
 * @CREATE_DATE:2023/2/20_星期一_0:13
 */
public class MessageUtil {
    public static String convertToString(Object obj, String charset) throws IOException {

        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        ObjectOutputStream oo = new ObjectOutputStream(bo);
        oo.writeObject(obj);
        String str = bo.toString(charset);
        bo.close();
        oo.close();
        return str;
    }

    //convert To Message
    public static Object convertToMessage(byte[] bytes) throws Exception {
        ByteArrayInputStream in = new ByteArrayInputStream(bytes);
        ObjectInputStream sIn = new ObjectInputStream(in);
        return sIn.readObject();
    }
}
