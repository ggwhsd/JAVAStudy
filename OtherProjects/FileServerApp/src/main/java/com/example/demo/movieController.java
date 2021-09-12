package com.example.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.config.SystemConfig;
import com.example.demo.entity.FileDescripe;

@Controller
@RequestMapping("/movie")
public class movieController {
	
	private Logger logger = LoggerFactory.getLogger((getClass()));
	
	private int count = 0;
	
	@Autowired
	private SystemConfig info;
	
	//下载或播放视频文件
	@ResponseBody
	@RequestMapping(value="/",method = RequestMethod.GET)
	public void movie(HttpServletRequest request, HttpServletResponse response,@RequestParam("filename") String filename)
	{
		count++;
		logger.info("count="+count);
		
		String dir = info.getmovieDir();
		String filePath = dir + "\\" + filename;
		
		try {
			FileInputStream inputStream = new FileInputStream(filePath);
			byte[] data = new byte[inputStream.available()];
			inputStream.read(data);
			String diskfilename = "1.mp4";
			response.setContentType("video/mp4");
			response.setHeader("Content-Disposition", "attachment; filename=\"" + diskfilename + "\"");   
			logger.info("文件长度:"+data.length);
			response.setContentLength(data.length);
			response.setHeader("Content-Range", "" + Integer.valueOf(data.length-1));
			response.setHeader("Accept-Ranges","bytes");
			response.setHeader("Etag", "W/\"9767057-1323779115364\"");
			OutputStream os = response.getOutputStream();
			os.write(data);
			os.flush();
			os.close();
			inputStream.close();
			
		}
		catch(Exception err)
		{	
		}
	}
	
	//查看视频文件列表
	@RequestMapping(value="/list",method = RequestMethod.GET)
	public ModelAndView list()
	{
		ModelAndView modelAndView = new ModelAndView();
		List<FileDescripe> arr = new ArrayList<FileDescripe>();
		File files = new File(info.getmovieDir());
		for(File file : files.listFiles())
		{
			FileDescripe f = new FileDescripe();
			f.setName(file.getName());
			f.setSize(file.length()/1024.0/1024.0);  //MB
			f.setType(file.isDirectory()?"dir":"file");
			arr.add(f);
		}

		modelAndView.setViewName("ListMovies");
		modelAndView.addObject("arr", arr);
		return modelAndView;
		
	}
	
	@RequestMapping("/play")
	public ModelAndView play(@RequestParam("fileName") String filename)
	{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("movie");
		modelAndView.addObject("movieName", filename);
		return modelAndView;
	}
	
	

}
