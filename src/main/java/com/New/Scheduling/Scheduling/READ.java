package com.New.Scheduling.Scheduling;

import com.alibaba.fastjson.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.alibaba.fastjson.JSONArray;
public class READ {
	
//	 String jo="{\"startTime\":\"2020-08-16\",\"endTime\":\"2020-09-16\",\"object\":[{\"id\":\"1\",\"name\":\"\",\"type\":\"\","
//				+ "\"rule\":[{\"code\":\"1\",\"mark\":\"Default / Random Scheduling\",\"x\":\"0\",\"m\":\"\"},"			 
//				+ "{\"code\":\"2\",\"mark\":\"Number of shifts per day\",\"x\":\"2\",\"m\":\"\"},"
//				+ "{\"code\":\"3\",\"mark\":\"Number of Groups\",\"x\":\"4\",\"m\":\"\"},"
//				+ "{\"code\":\"4\",\"mark\":\"Days of Continuous Day Shift\",\"x\":\"2\",\"m\":\"less than\"},"
//				+ "{\"code\":\"5\",\"mark\":\"Days of Continuous Night Shift\",\"x\":\"2\",\"m\":\"less than\"},"
//				+ "{\"code\":\"6\",\"mark\":\"There is No Dchedule on Week\",\"x\":\"\",\"m\":\"\"},"
//				+ "{\"code\":\"7\",\"mark\":\"Full Customization\",\"x\":\"0\",\"Customization\":{\"CName\":\"A\",\"Sun\":\"F\",\"Sat\":\"D\",\"Fri\":\"D\",\"Thu\":\"D\",\"Wen\":\"D\",\"Tue\":\"D\",\"Mon\":\"D\"}}],"
//				+"\"initilal\":{\"Sun\":\"\",\"Sat\":\"\",\"Fri\":\"\",\"Thu\":\"\",\"Wen\":\"\",\"Tue\":\"\",\"Mon\":\"\"}}]}";	 

	 	 
	 
	 /**
     * code1:默认/随机排班
     * code2:每日班数X
     * code3:组数X
     * code4:连续白班天数不超过X
     * code5:连续夜班天数不超过X
     * code6:X不排班
     * code7:自定义排布，x选择组别，Cname小组别
     * initilal:在随机排布情况下，如当天排班，该组执行班次
     */
	
	 JSONObject jsonObject=JSONObject.parseObject(jo);	 
	  SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	  String begin =(String) jsonObject.get("startTime");
	  String end =(String) jsonObject.get("endTime");
	  public int getDc() {
		  Calendar cal = Calendar.getInstance();
		  Date dat1 = null;
		  Date dat2 = null;
     try {
         dat1 = sdf.parse(begin);
     } catch (ParseException e) {
         e.printStackTrace();
     }
     try {
         dat2 = sdf.parse(end);
     } catch (ParseException e) {
         e.printStackTrace();
     }
 	cal.setTime(dat1);
 	long time1 = cal.getTimeInMillis();
 	cal.setTime(dat2);
 	long time2 = cal.getTimeInMillis();
 	long between_days=(time2-time1)/(1000*3600*24);
 	return Integer.parseInt(String.valueOf(between_days));
	  }
	 
	  JSONArray object = jsonObject.getJSONArray("object");
	  JSONArray rule = object.getJSONObject(0).getJSONArray("rule");
	  JSONObject Customization = rule.getJSONObject(6).getJSONObject("Customization");
	  JSONObject initial = object.getJSONObject(0).getJSONObject("initilal");
	  
     int id= Integer.parseInt((String)object.getJSONObject(0).get("id"));
     
     int code0=Integer.parseInt((String)rule.getJSONObject(0).get("x"));
	 
     int code1=Integer.parseInt((String)rule.getJSONObject(1).get("x"));
	
	 int code2=Integer.parseInt((String)rule.getJSONObject(2).get("x"));
	
	 int code3=Integer.parseInt((String)rule.getJSONObject(3).get("x"));
	 
	 int code4=Integer.parseInt((String)rule.getJSONObject(4).get("x"));
	 
	 String code5=(String)rule.getJSONObject(5).get("x");
	 
	 int code6=Integer.parseInt((String)rule.getJSONObject(6).get("x"));
	 
	 String CName = (String)Customization.get("CName");
	 
	 String CSun = (String)Customization.get("Sun");
	 
	 String CSat = (String)Customization.get("Sat");
	 
	 String CFri = (String)Customization.get("Fri");
	 
	 String CThu = (String)Customization.get("Thu");
	 
	 String CWen = (String)Customization.get("Wen");
	 
	 String CTue = (String)Customization.get("Tue");
	 
	 String CMon = (String)Customization.get("Mon");
	 
	 int code7=Math.max(code3,code4);
		    
    public int getId() {
    	return id;
    }
     
 	public int getCode1() {
		return code1;
	}
	public int getCode2() {
		return code2;
	}
	public int getCode3() {
		return code3;
	}
	public int getCode4() {
		return code4;
	}

	public int getCode6() {
		return code6;
	}

    String sun = initial.getString("Sun");
    
    String sat = initial.getString("Sat");

    String fri = initial.getString("Fri");

    String thu = initial.getString("Thu");

    String wen = initial.getString("Wen");
  
    String tue = initial.getString("Tue");

    String mon = initial.getString("Mon");
       
}
