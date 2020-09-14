package com.weather.utility;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;
 

  

 
/*******************************************************************************  
 * AES加解密算法  
 *   
 * @author jueyue  
 *   
  
  加密用的Key 可以用26个字母和数字组成，最好不要用保留字符，虽然不会错，至于怎么裁决，个人看情况而定  
  此处使用AES-128-CBC加密模式，key需要为16位。  
   也是使用<span style="font-size: 1em; line-height: 1.5;">0102030405060708</span> 
 */    
    
public class AES {    
    
    // 加密    
    public static String Encrypt(String sSrc, String sKey) throws Exception {    
        if (sKey == null) {    
            System.out.print("Key为空null");    
            return null;    
        }    
        // 判断Key是否为16位    
        if (sKey.length() != 16) {    
            System.out.print("Key长度不是16位");    
            return null;    
        }    
        byte[] raw = sKey.getBytes();    
        SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");    
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");//"算法/模式/补码方式"    
        IvParameterSpec iv = new IvParameterSpec("0102030405060708".getBytes());//使用CBC模式，需要一个向量iv，可增加加密算法的强度    
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);    
        byte[] encrypted = cipher.doFinal(sSrc.getBytes());    
    
        return Base64.encodeBase64String(encrypted);//此处使用BAES64做转码功能，同时能起到2次加密的作用。    
//        		.encodeBAES64String(encrypted);
    }    
    
    // 解密    
    public static String Decrypt(String sSrc, String sKey) throws Exception {    
        try {    
            // 判断Key是否正确    
            if (sKey == null) {    
                System.out.print("Key为空null");    
                return null;    
            }    
            // 判断Key是否为16位    
            if (sKey.length() != 16) {    
                System.out.print("Key长度不是16位");    
                return null;    
            }    
            byte[] raw = sKey.getBytes("ASCII");    
            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");    
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");    
            IvParameterSpec iv = new IvParameterSpec("0102030405060708"    
                    .getBytes());    
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);    
            byte[] encrypted1 = Base64.decodeBase64(sSrc);//先用bAES64解密    
            try {    
                byte[] original = cipher.doFinal(encrypted1);    
                String originalString = new String(original);    
                return originalString;    
            } catch (Exception e) {    
                System.out.println(e.toString());    
                return null;    
            }    
        } catch (Exception ex) {    
            System.out.println(ex.toString());    
            return null;    
        }    
    }    
 
    public static byte[] AES_CBC_Decrypt(byte[] data, byte[] key, byte[] iv) throws Exception{
        Cipher cipher = getCipher(Cipher.DECRYPT_MODE, key, iv);
        return cipher.doFinal(data);
    }

    private static Cipher getCipher(int mode, byte[] key, byte[] iv) throws Exception{
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");

        //因为AES的加密块大小是128bit(16byte), 所以key是128、192、256bit无关
        //System.out.println("cipher.getBlockSize()： " + cipher.getBlockSize());

        SecretKeySpec secretKeySpec = new SecretKeySpec(key, "AES");
        cipher.init(mode, secretKeySpec, new IvParameterSpec(iv));

        return cipher;
    }
    
    public static String getDecrypt(String crypto,String key){
    	
//        byte[] bytes = "db2139561c9fe068".getBytes();
        byte[] bytes = key.getBytes();
        String base64Str = Base64.encodeBase64String(bytes);
//        System.out.println(base64Str);

        byte[] data = null;
        byte[] s = null;
		try {
			data = Hex.decodeHex(crypto.toCharArray());
			s = AES_CBC_Decrypt(data, bytes, bytes);
		} catch (DecoderException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return new String(s);
    }
    public static void main(String[] args) {
		
    	try {
			String code = AES.Encrypt("123","zeLkLmEsQxvKw35J");
			System.out.println("加密"+code);
			String text = AES.Decrypt(code,"zeLkLmEsQxvKw35J");
			System.out.println("解码 ： "+text);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}  