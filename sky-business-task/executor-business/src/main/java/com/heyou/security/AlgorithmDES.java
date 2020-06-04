package com.heyou.security;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.Key;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * 对称DES加密解密工具<br>
 * <p>
 * <li>对称加密
 * <P>
 * 对称加密称为密钥加密，速度快，但加密和解密的钥匙必须相同，只有通信双方才能知道密钥，常见的有DES，3DES，AES对称加密。
 * DES密钥长度是8，AES密钥长度是[16, 24, 32]
 * </P>
 * </li>
 * <li>非对称加密
 * <P>
 * 非对称加密称为公钥加密，算法更加复杂，速度慢，加密和解密钥匙不相同，任何人都可以知道公钥，只有一个人持有私钥可以解密。常见的就是RSA了。
 * </P>
 * </li>
 * <li>不可逆加密
 * <P>
 * 典型的代表就是MD5加密了。
 * </P>
 * </li>
 * </p>
 * 
 * @author xuyd
 * 
 */
public class AlgorithmDES {

	protected static final Logger logger = LoggerFactory.getLogger(AlgorithmDES.class);

	public static AlgorithmDES _self = null;

	/**
	 * DES密钥路径
	 */
	private String desKeyPath;

	/**
	 * 固定的密钥内容[>8]
	 */
	public static final String FIX_KEY = "DESJIAMI";
	
	/**
	 * 密钥长度
	 */
	private static final int KEY_SIZE = 56;
	
	// DES密钥字符长度是8字节，AES密钥长度是[16, 24, 32]
	private static final String ALGORITHM_NAME = "DES";

	private final BASE64Encoder base64Encoder = new BASE64Encoder();
	private final BASE64Decoder base64Decoder = new BASE64Decoder();

	public static final String CHARCODE_UFT8 = "UTF-8";


	private AlgorithmDES(){
	}

	/**
	 * 单例获取对象
	 */
	public static AlgorithmDES getInstance() {
		if(_self == null) {
			_self = new AlgorithmDES();
		}
		return _self;
	}

	/**
	 * 设置密钥路径
	 * @param desKeyPath
	 */
	public AlgorithmDES setDesKeyPath(String desKeyPath) {
		this.desKeyPath = desKeyPath;
		return this;
	}

	/********************************* 加密解密处理(S) ************************************/

	/**
	 * 加密处理，加密失败则还是返回原字符串
	 * 
	 * @param val
	 * @param key
	 * @return
	 */
	public String encrypt(String val) {
		if (val == null || val.length() <= 0) {
			return null;
		}
		if (desKeyPath == null || desKeyPath.length() <= 0) {
			throw new RuntimeException("密钥文件路径未设置。");
		}
		String afterVal = null;
		try {
			// 还原密钥
			byte[] secretKeyBytes = this.readIntoByte(desKeyPath);
			SecretKey secretKey = restoreKey(secretKeyBytes);

			// 获取字符字节码
			byte[] codeBytes = val.getBytes(CHARCODE_UFT8);
			// 加密获得字节码
			byte[] b = _encrypt(secretKey, codeBytes);
			// 加密后字节码编码成字符串
			afterVal = base64Encoder.encode(b);
		} catch (Throwable e) {
			logger.error("encrypt failed.", e);
		}
		return afterVal;
	}

	/**
	 * 加密处理，加密失败则还是返回原字符串
	 * 
	 * @param val
	 * @param key
	 * @return
	 */
	public String encrypt(String val, String key) {
		if (val == null || val.length() <= 0) {
			return null;
		}
		String afterVal = null;
		try {
			// 还原密钥
			byte[] secretKeyBytes = key.getBytes();// key可以是任意字符串>8
			SecretKey secretKey = restoreKey(secretKeyBytes);

			// SecretKey secretKey = new SecretKeySpec(key.getBytes(), ALGORITHM_NAME);// key只能是8个字节长度
			
			// 获取字符字节码
			byte[] codeBytes = val.getBytes(CHARCODE_UFT8);
			// 加密获得字节码
			byte[] b = _encrypt(secretKey, codeBytes);
			// 加密后字节码编码成字符串
			afterVal = base64Encoder.encode(b);
		} catch (Throwable e) {
			logger.error("encrypt failed.", e);
		}
		return afterVal;
	}


	/**
	 * 解密处理，解密失败则还是返回原字符串，预先设置密钥路径
	 * 
	 * @param val 密文
	 * 
	 * @return
	 */
	public String decrypt(String val) {
		if (val == null || val.length() <= 0) {
			return null;
		}
		if (desKeyPath == null || desKeyPath.length() <= 0) {
			throw new RuntimeException("密钥文件路径未设置。");
		}
		String afterVal = null;
		try {
			// 还原密钥
			byte[] secretKeyBytes = this.readIntoByte(desKeyPath);
			SecretKey secretKey = restoreKey(secretKeyBytes);

			// 解码获得字节码
			byte[] codeBytes = base64Decoder.decodeBuffer(val);
			if(codeBytes == null || codeBytes.length <= 0) {
				return val;
			}
			// 解密获得字符字节码
			byte[] b = _decrypt(secretKey, codeBytes);
			// 获取字符串
			afterVal = new String(b, CHARCODE_UFT8);
		} catch(Exception e) {
			logger.error("decrypt failed.", e);
		}
		return afterVal;
	}
	
	/**
	 * 解密处理，解密失败则还是返回原字符串
	 * 
	 * @param val
	 * @param key
	 * 
	 * @return
	 */
	public String decrypt(String val, String key) {
		if (val == null || val.length() <= 0) {
			return null;
		}
		String afterVal = null;
		try {
			// 还原密钥
			byte[] secretKeyBytes = key.getBytes();// key可以是任意字符串>8
			SecretKey secretKey = restoreKey(secretKeyBytes);

			// SecretKey secretKey = new SecretKeySpec(key.getBytes(), ALGORITHM_NAME);// key只能是8个字节长度

			// 解码获得字节码
			byte[] codeBytes = base64Decoder.decodeBuffer(val);
			if(codeBytes == null || codeBytes.length <= 0) {
				return val;
			}
			// 解密获得字符字节码
			byte[] b = _decrypt(secretKey, codeBytes);
			// 获取字符串
			afterVal = new String(b, CHARCODE_UFT8);
		} catch (Throwable e) {
			logger.error("decrypt failed.", e);
		}
		return afterVal;
	}

	/**
	 * 加密处理
	 * 
	 * @param key
	 *            密钥
	 * @param b
	 *            原始字节
	 * 
	 * @return 加密后的字节
	 */
	public byte[] _encrypt(Key key, byte[] b) throws Exception {
		// 可信任的随机数源，加密结果不变
		SecureRandom random = new SecureRandom();
		Cipher cipher;
		cipher = Cipher.getInstance(ALGORITHM_NAME);
		cipher.init(Cipher.ENCRYPT_MODE, key, random);
		return cipher.doFinal(b);
	}

	/**
	 * 解密处理
	 * 
	 * @param key
	 *            密钥
	 * @param b
	 *            加密后字节
	 * 
	 * @return 解密后的字节
	 */
	private byte[] _decrypt(Key key, byte[] b) throws Exception {
		// 可信任的随机数源
		SecureRandom random = new SecureRandom();
		Cipher cipher = Cipher.getInstance(ALGORITHM_NAME);
		cipher.init(Cipher.DECRYPT_MODE, key, random);
		return cipher.doFinal(b);
	}

	/********************************* 加密解密处理(E) ************************************/

	/********************************* 解析密钥(S) ****************************************/

	/**
	 * 还原密钥
	 * 
	 * @param keyBytes
	 * @return
	 */
	private SecretKey restoreKey(byte[] keyBytes) {
		try {
			DESKeySpec keySpec = new DESKeySpec(keyBytes);
			SecretKeyFactory factory = SecretKeyFactory.getInstance(ALGORITHM_NAME);
			SecretKey secretKey = factory.generateSecret(keySpec);
			return secretKey;
		} catch (Exception e) {
			logger.error("restore key failed.", e);
		}
		return null;
	}

	/**
	 * 读取key文件到内存中
	 * 
	 * @param filePath
	 */
	private byte[] readIntoByte(String filePath) {
		File publicKeyFile = new File(filePath);
		InputStream is = null;
		try {
			is = new FileInputStream(publicKeyFile);
			ByteArrayOutputStream arrayOS = new ByteArrayOutputStream();
			byte[] keys = new byte[1024];
			int len = -1;
			while ((len = is.read(keys)) != -1) {
				arrayOS.write(keys, 0, len);
			}
			return arrayOS.toByteArray();
		} catch (Exception e) {
			logger.error("read key from file failed.", e);
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
				}
			}
		}
		return null;
	}

	/********************************* 解析密钥(E) ****************************************/

	/********************************* 生成密钥(S) ****************************************/

	/**
	 * 生成指定长度的密钥字符串
	 * 
	 * @return
	 * @see #generateKeyIntoFile()
	 * @deprecated 自动生成密钥就不需要转字符串了，直接保存到文件中
	 */
	public String generateKeyString() {
		try {
			byte[] secretKeyBytes = generateKeyBytes();
			String secretKey = base64Encoder.encode(secretKeyBytes);
			return secretKey;
		} catch (Exception e) {
			logger.error("generate key string failed.", e);
		}
		return null;
	}

	/**
	 * 生成的密钥字节码写入到文件中
	 * 
	 * @return
	 * @see #generateKeyString()
	 */
	public boolean generateKeyIntoFile() {
		if (desKeyPath == null || desKeyPath.length() <= 0) {
			throw new RuntimeException("密钥文件路径未设置。");
		}
		OutputStream os = null;
		try {
			byte[] keyBytes = generateKeyBytes();
			File keyFile = new File(desKeyPath);
			// 目录不存在创建
			File fp = new File(keyFile.getParent());
			if (!fp.exists()) {
				fp.mkdirs();
			}
			os = new FileOutputStream(keyFile);
			os.write(keyBytes);
		} catch (Exception e) {
			logger.error("write key into file failed.", e);
			return false;
		} finally {
			if (os != null) {
				try {
					os.close();
				} catch (IOException e) {
				}
			}
		}
		return true;
	}

	/**
	 * 生成密钥字节码
	 * 
	 * @return
	 */
	private byte[] generateKeyBytes() throws Exception {
		KeyGenerator keyGenerator = KeyGenerator.getInstance(ALGORITHM_NAME);
		// 初始化密钥长度
		keyGenerator.init(KEY_SIZE);
		// 获取公钥
		SecretKey secretKey = keyGenerator.generateKey();

		// 返回密钥字节码
		return secretKey.getEncoded();
	}

	/********************************* 生成密钥(E) ****************************************/

	/*************************************************************************/

	/**
	 * TEST
	 * 
	 * @param args
	 */
	public static void main1(String[] args) {
		String val = null;
		val = "9c401008d5d96ef27cc1caaf404bb600";
		val = "hefasql";
		AlgorithmDES algorithmDES = AlgorithmDES.getInstance();
		algorithmDES.setDesKeyPath("C:/home/hefa/deskey.lic");
		boolean ret = algorithmDES.generateKeyIntoFile();
		System.out.println("=====DES加密密钥生成：=====\n" + (ret == true));

		String encryptedVal = algorithmDES.encrypt(val);
		System.out.println("=====DES加密原文=====\n" + val);
		System.out.println("=====DES加密密文=====\n" + encryptedVal);
		String decryptedVal = algorithmDES.decrypt(encryptedVal);
		System.out.println("=====DES解密密文=====\n" + encryptedVal);
		System.out.println("=====DES解密原文=====\n" + decryptedVal);
		
		
		String secretKey = "des123456789jiamia";
		encryptedVal = algorithmDES.encrypt(val, secretKey);
		System.out.println("=====DES加密原文=====\n" + val);
		System.out.println("=====DES加密密钥=====\n" + secretKey);
		System.out.println("=====DES加密密文=====\n" + encryptedVal);
		decryptedVal = algorithmDES.decrypt(encryptedVal, secretKey);
		System.out.println("=====DES解密密文=====\n" + encryptedVal);
		System.out.println("=====DES解密密钥=====\n" + secretKey);
		System.out.println("=====DES解密原文=====\n" + decryptedVal);
	}

}
