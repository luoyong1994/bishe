package com.ynet.fullview.service.uploadservice;


import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

public interface UploadAndDownloadByDirectService {
    public String uploadLoad(MultipartFile file);

    public void download(String fileName, HttpServletResponse response) throws UnsupportedEncodingException;

}
