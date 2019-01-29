package utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class utils {
	public static String md5(String senha) {
		String md5 = null;
		if(null == senha) return null;
		try{
			MessageDigest digest = MessageDigest.getInstance("MD5");
			digest.update(senha.getBytes(), 0, senha.length());
			md5 = new BigInteger(1,digest.digest()).toString(16);
		   //System.out.println(md5);
		}catch(NoSuchAlgorithmException e){
			e.printStackTrace();
		}
		return md5;
	}
}
