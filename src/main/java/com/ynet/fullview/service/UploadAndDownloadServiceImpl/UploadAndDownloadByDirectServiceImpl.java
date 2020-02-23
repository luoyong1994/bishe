package com.ynet.fullview.service.UploadAndDownloadServiceImpl;


import com.ynet.fullview.exception.ActionException;
import com.ynet.fullview.service.uploadservice.UploadAndDownloadByDirectService;
import com.ynet.fullview.util.IDUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import sun.nio.ch.IOUtil;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * 用于直接上传和下载
 */
@Service
@Slf4j
public class UploadAndDownloadByDirectServiceImpl implements UploadAndDownloadByDirectService {

    @Value("${params.path}")
    private String PATH;

    @Override
    public String uploadLoad(MultipartFile file) {
        String fileId = null;
        try {
            if (null != file) {
                InputStream inputStream = file.getInputStream();
                log.info("文件存储路径：{}", PATH);
                File targetFile = new File(PATH);
                if(!targetFile.exists()){
                    targetFile.mkdirs();
                }
                fileId = IDUtil.generaryId();
                String fileName = file.getOriginalFilename();
                String fileSuffix = fileName.substring(fileName.lastIndexOf("."));
                FileOutputStream fileOutputStream = new FileOutputStream(PATH + "/" + fileId + fileSuffix);
                IOUtils.copy(inputStream, fileOutputStream);
                fileOutputStream.flush();
                fileOutputStream.close();
            } else {
                throw new ActionException("上传文件不能空");
            }
        } catch (IOException e) {
            log.info("文件上传存储失败，失败原因：{}", e);
            throw new ActionException(e.toString());
        }
        return fileId;
    }


    @Override
    public void download(String fileName, HttpServletResponse response) throws UnsupportedEncodingException {
        if (StringUtils.isEmpty(fileName)) {
            throw new ActionException("文件名不能为空");
        }
        try {
            String allFileName = PATH + "/" + fileName;
            FileInputStream fileInputStream = new FileInputStream(allFileName);
            response.setHeader("Content-disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
            response.setCharacterEncoding("UTF-8");
            OutputStream outputStream = response.getOutputStream();
            IOUtils.copy(fileInputStream, response.getOutputStream());
            fileInputStream.close();
            outputStream.flush();
            outputStream.close();
        } catch (FileNotFoundException e) {
            log.error("下载文件没有找到");
            throw new ActionException("没有找到对应得文件");
        } catch (IOException e) {
            log.error("下载文件异常");
            throw new ActionException("下载文件出现错误");
        }
    }


}
