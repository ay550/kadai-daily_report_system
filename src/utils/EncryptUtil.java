//文字列をSHA256でハッシュ化するクラス
package utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.bind.DatatypeConverter;

public class EncryptUtil {

    //ペッパー文字列 : パスワードに連結させる文字列のこと
    //引数で受け取った文字列にペッパー文字列を連結させたものをSHA256でハッシュ化
    //引数の文字列が何もなければ、からの文字列を返す
    public static String getPasswordEncrypt(String plain_p, String pepper) {
        String ret = "";

        if(plain_p != null && !plain_p.equals("")) {
            byte[] bytes;
            String password = plain_p + pepper;
            try {
                bytes = MessageDigest.getInstance("SHA-256").digest(password.getBytes());
                ret = DatatypeConverter.printHexBinary(bytes);
            } catch(NoSuchAlgorithmException ex) {}
        }

        return ret;
    }
}
