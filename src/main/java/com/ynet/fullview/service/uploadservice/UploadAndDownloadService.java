package com.ynet.fullview.service.uploadservice;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

public interface UploadAndDownloadService {

    public String uploadLoad(MultipartFile file);

    public void download(String url, String fileName,HttpServletResponse response) throws UnsupportedEncodingException;
}
