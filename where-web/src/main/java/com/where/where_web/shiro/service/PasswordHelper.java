package com.where.where_web.shiro.service;

import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

import com.where.where_web.shiro.entity.UserTest;
/**
 * 
 * @author AQing
 *
 */
public class PasswordHelper {
	private RandomNumberGenerator randomNumberGenerator=new SecureRandomNumberGenerator();
	private String algorithmName = "md5";
	private int hashIterations = 2;
	
    public void setRandomNumberGenerator(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public void setAlgorithmName(String algorithmName) {
        this.algorithmName = algorithmName;
    }

    public void setHashIterations(int hashIterations) {
        this.hashIterations = hashIterations;
    }
    
    public void encryptPassword(UserTest userTest) {

        userTest.setSalt(randomNumberGenerator.nextBytes().toHex());

        String newPassword = new SimpleHash(
                algorithmName,
                userTest.getPassword(),
                ByteSource.Util.bytes(userTest.getCredentialsSalt()),
                hashIterations).toHex();

        userTest.setPassword(newPassword);
    }

}
