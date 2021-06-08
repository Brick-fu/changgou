package com.changgou.file.controller;

import com.changgou.file.pojo.FileInf;
import com.changgou.file.util.MinioClientUtil;
import com.changgou.utils.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

@RestController
@CrossOrigin
public class FileController {

    Logger logger = LoggerFactory.getLogger(FileController.class);
    /**
     * @Description 文件上传
     * @Param [file]
     * @Return java.lang.String
     * @Date 下午11:18 2021/5/25
     * @Author brick
     **/
    @PostMapping("/upload")
    public String uploadFile(@RequestParam(name = "file") MultipartFile file) throws Exception {
        logger.info("FileController.uploadFile");
        FileInf fileInf = new FileInf();
        fileInf.setInputStream(file.getInputStream());
        fileInf.setFileSize(file.getSize());
        fileInf.setContentType(file.getContentType());
        // fileInf.setContent(file.getBytes());
        String originalFilename = file.getOriginalFilename();
        originalFilename = DateUtil.getDateTimeTo8() + File.separator + DateUtil.getDateTimeTo14() + "_" + originalFilename;
        fileInf.setName(originalFilename);
        fileInf.setExt(StringUtils.getFilenameExtension(originalFilename));
        String url;
        //fastDFS文件上传
        // String[] fileResult = FastDFSClient.uploadFile(fileInf);
        // url = FastDFSClient.getTrackerUrl() + "/" + fileResult[0] +"/" + fileResult[1];
        //minio文件上传
        url = MinioClientUtil.uploadFile(fileInf);
        return url;
    }

    @PostMapping
    public void downloadFile(@RequestParam String groupName,@RequestParam String remoteFileName){
        logger.info("FileController.downloadFile,{},{}",groupName,remoteFileName);
        InputStream is = null;
        OutputStream os = null;
        try {
            // is = FastDFSClient.downloadFile(groupName, remoteFileName);
            is = MinioClientUtil.downloadFile(remoteFileName);
            byte[] buffer = new byte[1024];
            os = new FileOutputStream(new File("/home/brick/aaa.jpg"));
            while(is != null && is.read(buffer) > 0){
                os.write(buffer);
            }
            os.flush();
            os.close();
            is.close();
        } catch (Exception e) {
            logger.error("文件下载错误",e);
        }
    }

    @PostMapping("/delete")
    public Integer deleteFile(@RequestParam String groupName,@RequestParam String remoteFileName){
        logger.info("FileController.deleteFile,{},{}",groupName,remoteFileName);
        // Integer result = FastDFSClient.deleteFile(groupName, remoteFileName);
        try {
            MinioClientUtil.deleteFile(remoteFileName);
            logger.info("删除成功！");
        } catch (Exception e) {
            logger.error("删除失败！",e);
            return -1;
        }
        return 1;
    }
}
