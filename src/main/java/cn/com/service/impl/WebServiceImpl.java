package cn.com.service.impl;

import javax.jws.WebService;

import cn.com.service.IWebService;

@WebService(serviceName = "service789", endpointInterface = "cn.com.service.IWebService")
public class WebServiceImpl implements IWebService {

	
	public String example(String message) {
		// TODO Auto-generated method stub
		 return message;  
	}


	public String test(String s) {
		// TODO Auto-generated method stub
		String n = "this's ";  
        String t = n+s;  
        return t;  
	}

}
