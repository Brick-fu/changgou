package com.changgou.file.controller;

import com.changgou.file.pojo.FileInf;
import com.changgou.file.util.FastDFSClient;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin
public class FileController {

    /**
     * @Description 文件上传
     * @Param [file]
     * @Return java.lang.String
     * @Date 下午11:18 2021/5/25
     * @Author brick
     **/
    @PostMapping("/upload")
    public String uploadFile(@RequestParam(name = "file") MultipartFile file) throws Exception {
        FileInf fileInf = new FileInf();
        fileInf.setContent(file.getBytes());
        String originalFilename = file.getOriginalFilename();
        fileInf.setName(originalFilename);
        fileInf.setExt(StringUtils.getFilenameExtension(originalFilename));
        String[] fileResult = FastDFSClient.uploadFile(fileInf);
        return FastDFSClient.getTrackerUrl() + "/" + fileResult[0] +"/" + fileResult[1];
    }
}
