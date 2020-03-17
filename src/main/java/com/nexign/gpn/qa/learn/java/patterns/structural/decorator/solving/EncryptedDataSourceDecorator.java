package com.nexign.gpn.qa.learn.java.patterns.structural.decorator.solving;

import com.nexign.gpn.qa.learn.java.patterns.structural.decorator.problem.DataSource;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

import static java.nio.charset.StandardCharsets.UTF_8;

public class EncryptedDataSourceDecorator extends DataSourceDecorator {
    private static SecretKeySpec secretKey;

    public EncryptedDataSourceDecorator(DataSource wrapped) {
        super(wrapped);
        setKey("MySecretKey");
    }

    public static void setKey(String myKey) {
        try {
            byte[] key = myKey.getBytes(UTF_8);
            key = MessageDigest.getInstance("SHA-1").digest(key);
            key = Arrays.copyOf(key, 16);
            secretKey = new SecretKeySpec(key, "AES");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("can't create secret key");
        }
    }

    @Override
    public void writeData(String message) throws IOException {
        try {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] bytes = cipher.doFinal(message.getBytes(UTF_8));
            super.writeData(Base64.getEncoder().encodeToString(bytes));
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException e) {
            throw new RuntimeException("can't encrypt message");
        }
    }

    @Override
    public String readData() throws IOException {
        String encrypted = super.readData();
        try {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            return new String(cipher.doFinal(Base64.getDecoder().decode(encrypted)));
        } catch (IllegalBlockSizeException | BadPaddingException | NoSuchPaddingException | NoSuchAlgorithmException | InvalidKeyException e) {
            throw new RuntimeException("can't decrypt message");
        }
    }

}
