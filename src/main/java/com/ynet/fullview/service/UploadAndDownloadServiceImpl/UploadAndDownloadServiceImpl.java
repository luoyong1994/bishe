package com.ynet.fullview.service.UploadAndDownloadServiceImpl;

import com.ynet.fullview.exception.ActionException;
import com.ynet.fullview.fastDFS.FastDFSClientWrapper;
import com.ynet.fullview.service.uploadservice.UploadAndDownloadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Deprecated
public class UploadAndDownloadServiceImpl implements UploadAndDownloadService {


    @Autowired
    private FastDFSClientWrapper fastDFSClientWrapper;

    @Override
    public String uploadLoad(MultipartFile file) {
        byte[] fileBytes = null;
        if (null == file) {
            throw new ActionException("文件不能为空！");
        }
        try {
            fileBytes = file.getBytes();
        } catch (IOException e) {
            throw new ActionException(e.getMessage());
        }
        //获取源文件名称
        String originalFileName = file.getOriginalFilename();
        //获取文件后缀--.doc
        String extension = originalFileName.substring(originalFileName.lastIndexOf(".") + 1);
        String fileName = file.getName();
        //获取文件大小
        long fileSize = file.getSize();
        System.out.println(originalFileName + "==" + fileName + "==" + fileSize + "==" + extension + "==" + fileBytes.length);
        return fastDFSClientWrapper.uploadFile(fileBytes, fileSize, extension);
    }

    @Override
    public void download(String fileUrl,String fileName,HttpServletResponse response) throws UnsupportedEncodingException {
        byte[] bytes = null;
        if (null == fileUrl) {
            throw new ActionException("下载路径不能为空;");
        }
        try {
            bytes = fastDFSClientWrapper.downloadFile(fileUrl);
        } catch (IOException e) {
            throw new ActionException("文件上传错误:" + e.getMessage());
        }
        if(null == fileName){
            fileName="未知文件名"+fileUrl.substring(fileUrl.indexOf("."));
        }
        response.setHeader("Content-disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
        response.setCharacterEncoding("UTF-8");
        ServletOutputStream outputStream = null;
        try {
            outputStream = response.getOutputStream();
            outputStream.write(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                outputStream.flush();
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
