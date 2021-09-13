package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.db.orderReqSpeedBean;
import com.example.demo.db.orderReqSpeedBeanExample;
import com.example.demo.db.orderReqSpeedBeanMapper;
import com.example.demo.entity.ResponseObject;



@Controller
public class orderReqSpeedController {
	@Autowired
	private orderReqSpeedBeanMapper orderReqSpeedMapper;
	
	@ResponseBody
	@GetMapping("/order/reqSpeedAll")
	public ResponseObject getOrderReqSpeed()
	{
		ResponseObject rtnObject = new ResponseObject();
		orderReqSpeedBeanExample example = new orderReqSpeedBeanExample();
	 List<orderReqSpeedBean> results =	orderReqSpeedMapper.selectByExample(example);
	 	rtnObject.getValues().put("count", results.size());
		rtnObject.getValues().put("orderSpeed", results);
		rtnObject.setCode(0);
		rtnObject.setCodeDescribe("OK");
		return rtnObject;
	}
	
	@ResponseBody
	@GetMapping("/order/reqSpeedByDay")
	public ResponseObject getOrderReqSpeedByDay(String day,String symbol)
	{
		ResponseObject rtnObject = new ResponseObject();
		orderReqSpeedBeanExample example = new orderReqSpeedBeanExample();
		example.createCriteria().andActiondateEqualTo(day)
		.andInstrumentidEqualTo(symbol);
		
		List<orderReqSpeedBean> results =	orderReqSpeedMapper.selectByExample(example);
	 	rtnObject.getValues().put("count", results.size());
		rtnObject.getValues().put("orderSpeed", results);
		rtnObject.setCode(0);
		rtnObject.setCodeDescribe("OK");
		return rtnObject;
	}
	
	@ResponseBody
	@GetMapping("/order/reqSpeedSumByDay")
	public ResponseObject getOrderReqSpeedByDay(String day)
	{
		ResponseObject rtnObject = new ResponseObject();

		
		String results = orderReqSpeedMapper.selectSumByactionDay(day);
	 	rtnObject.getValues().put("count", 1);
		rtnObject.getValues().put("orderSum", results);
		rtnObject.setCode(0);
		rtnObject.setCodeDescribe("OK");
		return rtnObject;
	}
	
	

	@ResponseBody
	@GetMapping("/order/reqSpeedSumByDay2")
	public ResponseObject getOrderReqSpeedByDay2(String day1,String day2)
	{
		ResponseObject rtnObject = new ResponseObject();

		
		List<String> results = orderReqSpeedMapper.selectSumBetweenActionDayRange(day1,day2);
	 	rtnObject.getValues().put("count", results.size());
		rtnObject.getValues().put("orderSum", results);
		rtnObject.setCode(0);
		rtnObject.setCodeDescribe("OK");
		return rtnObject;
	}
}
