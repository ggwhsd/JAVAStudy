package com.example.demo;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.config.SystemConfig;
import com.example.demo.entity.FileDescripe;

@Controller
@RequestMapping("/file")
public class FileDownloads {
	@Autowired
	SystemConfig info;
	
	@RequestMapping("/list")
	public ModelAndView list()
	{
		ModelAndView modelAndView = new ModelAndView();
		List<FileDescripe> arr = new ArrayList<FileDescripe>();
		File files = new File(info.getUploadPath());
		for(File file : files.listFiles())
		{
			FileDescripe f = new FileDescripe();
			f.setName(file.getName());
			f.setSize(file.length()/1024.0/1024.0);  //MB
			f.setType(file.isDirectory()?"dir":"file");
			arr.add(f);
		}

		modelAndView.setViewName("ListFiles");
		modelAndView.addObject("arr", arr);
		return modelAndView;
		
	}
	
	@RequestMapping("/download")
	public void download(HttpServletRequest request, HttpServletResponse response,@RequestParam("fileName") String filename) throws IOException 
	{
		// 配置文件下载
        response.setHeader("content-type", "application/octet-stream");
        response.setContentType("application/octet-stream");
        // 下载文件能正常显示中文
        response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(filename, "UTF-8"));

     // 实现文件下载
        File file = new File(info.getUploadPath(), filename);
        byte[] buffer = new byte[1024];
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        try {
            fis = new FileInputStream(file);
            bis = new BufferedInputStream(fis);
            OutputStream os = response.getOutputStream();
            int i = bis.read(buffer);
            while (i != -1) {
                os.write(buffer, 0, i);
                i = bis.read(buffer);
            }
            System.out.println("Download the song successfully!");
        }catch (Exception e) {
            System.out.println("Download the song failed!");
        }finally {
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
      
    }

	
}
