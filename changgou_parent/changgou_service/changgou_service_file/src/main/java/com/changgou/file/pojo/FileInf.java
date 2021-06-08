package com.changgou.file.pojo;

import java.io.InputStream;

public class FileInf {
    //文件名字
    private String name;
    //文件内容-字节方式
    private byte[] content;
    //文件内容-字节方式
    private InputStream inputStream;
    //文件大小
    private long fileSize;
    //文件类型
    private String contentType;
    //文件扩展名
    private String ext;
    //文件MD5摘要值
    private String md5;
    //文件创建作者
    private String author;

    public FileInf() {
    }

    public FileInf(String name, InputStream inputStream, long fileSize, String ext) {
        this.name = name;
        this.inputStream = inputStream;
        this.fileSize = fileSize;
        this.ext = ext;
    }

    public FileInf(String name, byte[] content, long fileSize, String ext) {
        this.name = name;
        this.content = content;
        this.fileSize = fileSize;
        this.ext = ext;
    }

    public FileInf(String name, byte[] content, String ext, String md5, String author) {
        this.name = name;
        this.content = content;
        this.ext = ext;
        this.md5 = md5;
        this.author = author;
    }

    public FileInf(String name, byte[] content, String ext) {
        this.name = name;
        this.content = content;
        this.ext = ext;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public InputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public long getFileSize() {
        return fileSize;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
