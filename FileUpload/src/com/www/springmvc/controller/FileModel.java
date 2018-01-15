package com.www.springmvc.controller;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by shijuan on 2017/12/15.
 */
public class FileModel {
    private MultipartFile  multipartFile;

    public MultipartFile getMultipartFile() {
        return multipartFile;
    }

    public void setMultipartFile(MultipartFile multipartFile) {
        this.multipartFile = multipartFile;
    }
}
