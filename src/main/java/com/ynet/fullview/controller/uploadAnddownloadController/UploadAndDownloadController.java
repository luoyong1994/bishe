package com.ynet.fullview.controller.uploadAnddownloadController;
import com.ynet.fullview.service.uploadservice.UploadAndDownloadByDirectService;
import com.ynet.fullview.service.uploadservice.UploadAndDownloadService;
import com.ynet.fullview.util.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;


@Controller
@RequestMapping("/file/")
@Slf4j
public class UploadAndDownloadController {

    @Autowired
    private UploadAndDownloadByDirectService uploadAndDownloadService;

    @PostMapping("upload.do")
    @ResponseBody
    public JsonResult upload(MultipartFile file){
        String fileId= uploadAndDownloadService.uploadLoad(file);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("fileId",fileId);
        hashMap.put("fileName",file.getOriginalFilename());
        return new JsonResult(hashMap);
    }


    @RequestMapping("download.do")
    public void download(String fileName, HttpServletResponse response) throws UnsupportedEncodingException {
//        uploadAndDownloadService.download(url,fileName,response);
        log.info("下载文件名：{}",fileName);
        uploadAndDownloadService.download(fileName,response);
    }

}
