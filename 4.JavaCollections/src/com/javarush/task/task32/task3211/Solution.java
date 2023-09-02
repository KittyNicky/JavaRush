package com.javarush.task.task32.task3211;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.StringReader;
import java.security.MessageDigest;

/* 
Целостность информации
*/

public class Solution {
    public static void main(String... args) throws Exception {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(new String("test string"));
        oos.flush();
        System.out.println(compareMD5(bos, "5a47d12a2e3f9fecf2d9ba1fd98152eb")); //true

    }

    public static boolean compareMD5(ByteArrayOutputStream byteArrayOutputStream, String md5) throws Exception {
        MessageDigest md = MessageDigest.getInstance("md5");
        byte[] mdBytes = md.digest(byteArrayOutputStream.toByteArray());
        StringBuilder sb = new StringBuilder();

        for (int j = 0; j < mdBytes.length; j++) {
            String s = Integer.toHexString(0xff & mdBytes[j]);
            s = (s.length() == 1) ? "0" + s : s;
            sb.append(s);
        }
        if (md5.equals(sb.toString())) return true;
        else return false;
    }
}
