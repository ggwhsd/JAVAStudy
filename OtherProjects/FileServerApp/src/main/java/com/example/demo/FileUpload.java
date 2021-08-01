package com.example.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.buf.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.config.SystemConfig;

@Controller
@RequestMapping("/file")
public class FileUpload {
	Logger logger = LoggerFactory.getLogger((getClass()));
	@Autowired
	SystemConfig info;
	
	@ResponseBody
	@RequestMapping("/upload")
	public String upload(@RequestParam("file") MultipartFile file) throws IOException {

		boolean isUploadFinished = false;
		File targetFile = new File(info.getUploadPath());
		if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
		FileOutputStream bos = null;
		try {
            String str = targetFile + "\\" + file.getOriginalFilename();    
            logger.info(str);
            bos = new FileOutputStream(str);//FileOutputStream读取流的时候如果是文件夹，就会出错，无论怎么读，都拒绝访问，应该在读取的目录后面加上文件名
            
            bos.write(file.getBytes()); //前端文件传过来后端将文件通过流写入文件夹中
            
            isUploadFinished = true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            
        } finally {
            bos.flush();
            bos.close();
        }
		logger.info("上传成功");
        if(isUploadFinished)
        	return "上传成功";
        else
        	return "上传失败";
	}
	
	@ResponseBody
	@RequestMapping("/upload2")
	public String upload2(@RequestParam("file") MultipartFile file) throws IOException {

		boolean isUploadFinished = false;
		File targetFile = new File(info.getUploadPath());
		if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
		logger.info("准备接收文件:"+file.getOriginalFilename());
		FileOutputStream bos = null;
		try {
            String str = targetFile + "\\" + file.getOriginalFilename();    
            logger.info("保存路径:"+str);
            bos = new FileOutputStream(str);//FileOutputStream读取流的时候如果是文件夹，就会出错，无论怎么读，都拒绝访问，应该在读取的目录后面加上文件名
            InputStream fis = file.getInputStream();
            
            
            int len = 0;
    		byte[] buf = new byte[1024*1024];
    		while((len = fis.read(buf))!=-1)
    		{
    			bos.write(buf,0,len); //前端文件传过来后端将文件通过流写入文件夹中
    		}
    		
            isUploadFinished = true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            
        } finally {
            bos.flush();
            bos.close();
        }
		logger.info("上传成功");
        if(isUploadFinished)
        	return "上传成功";
        else
        	return "上传失败";
	}
	
}
