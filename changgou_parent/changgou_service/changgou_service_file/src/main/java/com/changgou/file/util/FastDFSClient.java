package com.changgou.file.util;

import com.changgou.file.pojo.FileInf;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FastDFSClient {

    static Logger logger = LoggerFactory.getLogger(FastDFSClient.class);
    static{
        try {
            String filePath = new ClassPathResource("fdfs_client.conf").getPath();
            ClientGlobal.init(filePath);
        } catch (Exception e) {
            logger.error("FastDFSClient.init,{}",e);
        }
    }

    public static String[] uploadFile(FileInf file){
        String[] result = null;
        try {
            StorageClient storageClient = getStorageClient();
            result = storageClient.upload_file(file.getContent(), file.getExt(), null);
        } catch (Exception e) {
            logger.error("FastDFSClient.uploadFile,{}",e);
        }
        return result;
    }

    public static InputStream downloadFile(String groupName, String remoteFileName){
        try {
            StorageClient storageClient = getStorageClient();
            byte[] fileBytes = storageClient.download_file(groupName, remoteFileName);
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(fileBytes);
            return byteArrayInputStream;
        } catch (Exception e) {
            logger.error("FastDFSClient.downloadFile,{}",e);
        }
        return null;
    }

    public static Integer deleteFile(String groupName, String remoteFileName){
        try {
            StorageClient storageClient = getStorageClient();
            return storageClient.delete_file(groupName, remoteFileName);
        } catch (Exception e) {
            logger.error("FastDFSClient.deleteFile,{}",e);
        }
        return 0;
    }

    public static String getTrackerUrl(){
        try {
            TrackerServer trackerServer = getTrackerServer();
            return "http://" + trackerServer.getInetSocketAddress().getHostString() + ":" + ClientGlobal.getG_tracker_http_port();
        } catch (Exception e) {
            logger.error("FastDFSClient.getTrackerUrl,{}",e);
        }
        return null;
    }

    public static TrackerServer getTrackerServer() throws IOException {
        TrackerClient trackerClient = new TrackerClient();
        return trackerClient.getConnection();
    }

    public static StorageClient getStorageClient() throws IOException {
        TrackerServer trackerServer = getTrackerServer();
        return new StorageClient(trackerServer,null);
    }
}
