package com.changgou.file.util;

import com.changgou.file.pojo.FileInf;
import io.minio.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.InputStream;

@Component
public class MinioClientUtil {


    private static String ENDPOINT;

    private static String BUCKET_NAME;

    private static String ACCESS_KEY;

    private static String SECRET_KEY;

    private static final Logger logger = LoggerFactory.getLogger(MinioClientUtil.class);

    private static final String READ_ONLY = "{\"Version\":\"2012-10-17\",\"Statement\":[{\"Effect\":\"Allow\",\"Principal\":{\"AWS\":[\"*\"]},\"Action\":[\"s3:GetBucketLocation\",\"s3:ListBucket\"],\"Resource\":[\"arn:aws:s3:::" + BUCKET_NAME + "\"]},{\"Effect\":\"Allow\",\"Principal\":{\"AWS\":[\"*\"]},\"Action\":[\"s3:GetObject\"],\"Resource\":[\"arn:aws:s3:::" + BUCKET_NAME + "/*\"]}]}";


    public static String uploadFile(FileInf fileInf) throws Exception {
        MinioClient minioClient = getMinioClient();
        String name = fileInf.getName();
        minioClient.putObject(PutObjectArgs.builder()
                .bucket(BUCKET_NAME)
                .object(name)
                .stream(fileInf.getInputStream(), fileInf.getFileSize(), -1)
                .contentType(fileInf.getContentType())
                .build());
        return ENDPOINT + "/" + BUCKET_NAME + "/" + name;
    }

    public static void deleteFile(String name) throws Exception{
        MinioClient minioClient = getMinioClient();
        minioClient.removeObject(RemoveObjectArgs.builder()
                .bucket(BUCKET_NAME)
                .object(name)
                .build());
    }

    public static InputStream downloadFile(String name) throws Exception{
        MinioClient minioClient = getMinioClient();
        InputStream in = minioClient.getObject(GetObjectArgs.builder()
                .bucket(BUCKET_NAME)
                .object(name)
                .build());
        return in;
    }

    public static MinioClient getMinioClient() throws Exception{

        MinioClient minioClient = MinioClient.builder()
                .endpoint(ENDPOINT)
                .credentials(ACCESS_KEY, SECRET_KEY)
                .build();
        boolean b = minioClient.bucketExists(BucketExistsArgs.builder().bucket(BUCKET_NAME).build());
        if(!b){
            minioClient.makeBucket(MakeBucketArgs.builder().bucket(BUCKET_NAME).build());
            minioClient.setBucketPolicy(SetBucketPolicyArgs.builder().bucket(BUCKET_NAME).config(READ_ONLY).build());
        }else{
            logger.info("bucket " + BUCKET_NAME +"已经创建！");
        }
        logger.info("MinioClient创建成功！");
        return minioClient;
    }

    @Value("${minio.endpoint}")
    public void setENDPOINT(String ENDPOINT) {
        MinioClientUtil.ENDPOINT = ENDPOINT;
    }

    @Value("${minio.bucketName}")
    public void setBucketName(String bucketName) {
        BUCKET_NAME = bucketName;
    }

    @Value("${minio.accessKey}")
    public void setAccessKey(String accessKey) {
        ACCESS_KEY = accessKey;
    }

    @Value("${minio.secretKey}")
    public void setSecretKey(String secretKey) {
        SECRET_KEY = secretKey;
    }
}
