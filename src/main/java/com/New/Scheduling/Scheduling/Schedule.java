package com.New.Scheduling.Scheduling;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar; 

public class Schedule {	

	public  static   JSONArray getScheduleResult()  throws Exception{ 
		JSONArray js = new JSONArray();	
		READ code= new READ();	
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");//

		Date dat=null;
        try {
            dat = dateFormat.parse(code.begin);
        } catch (ParseException e) {
            e.printStackTrace();
        }

		Calendar c = Calendar.getInstance();
		c.setTime(dat);
		 c.add(Calendar.DATE,+0);
		 String Begin_Date = dateFormat.format(c.getTime());		  
		 c.add(Calendar.DATE,+code.getDc());
		 String Finish_Date = dateFormat.format(c.getTime());		 	 
		if ( code.getId()== 1) {

		 List<WorkDate> lstDate = new ArrayList<WorkDate>();
		 
		 for (int i = 1; i<=code.getDc(); i ++) {
			 lstDate.add(new WorkDate(i));	 
		 }
		 char a='A';
		 List<Worker> lstWorker = new ArrayList<Worker>() ;
			for (int i=1;i<=code.getCode2();i++) {
					 if (i==1) {
						 a='A';
					 }
					 if (i==2) {
						 a='B';
					 }
					 if (i==3) {
						 a='C';
					 }
					 if (i==4) {
						 a='D';
					 }
				Worker w=new Worker(1,"Automation "+a);
				w.setEasyDay(lstDate.size());
				lstWorker.add(w);
			}

			if(code.getCode1()>2) {
				System.out.println("Error：Too Many Shifts");
				throw new RuntimeException("Unable to compile.");
			}
			if(code.getDc()>31) {
				System.out.println("Error：The Schedule is too Long");
				throw new RuntimeException("Unable to compile.");
			}
			
			KieServices kieServices = KieServices.Factory.get(); 
	        KieContainer kieContainer = kieServices.getKieClasspathContainer();
	        KieSession session =  kieContainer.newKieSession("RuleAutomation.drl");	    
           
	        switch (code.code0) {
	        case 0 :
	        	session.getAgenda().getAgendaGroup("C1").setFocus();
	        	session.getAgenda().getAgendaGroup("RC").setFocus();
	        	break;
	        case 1:
	        if (code.getDc()>=0&&code.getDc()<7) {
		        if ((code.code3==1)&&(code.code4==1)) {
		        	session.getAgenda().getAgendaGroup("A01").setFocus();
		        }
		        if ((code.code3==2)&&(code.code4==2)) {
		        	session.getAgenda().getAgendaGroup("A02").setFocus();
		        }
		        if ((code.code3==3)&&(code.code4==3)) {
		        	session.getAgenda().getAgendaGroup("A03").setFocus();
		        }
		        if ((code.code3==4)&&(code.code4==4)) {
		        	session.getAgenda().getAgendaGroup("A04").setFocus();
		        }
		        if ((code.code3==1)&&(code.code4==2)) {
		        	session.getAgenda().getAgendaGroup("A012").setFocus();
		        }
		        if ((code.code3==1)&&(code.code4==3)) {
		        	session.getAgenda().getAgendaGroup("A013").setFocus();
		        }
		        if ((code.code3==1)&&(code.code4==4)) {
		        	session.getAgenda().getAgendaGroup("A014").setFocus();
		        }
		        if ((code.code3==2)&&(code.code4==3)) {
		        	session.getAgenda().getAgendaGroup("A023").setFocus();
		        }
		        if ((code.code3==2)&&(code.code4==4)) {
		        	session.getAgenda().getAgendaGroup("A024").setFocus();
		        }
		        if ((code.code3==3)&&(code.code4==4)) {
		        	session.getAgenda().getAgendaGroup("A034").setFocus();
		        }
		        if ((code.code3==2)&&(code.code4==1)) {
		        	session.getAgenda().getAgendaGroup("A021").setFocus();
		        }
		        if ((code.code3==3)&&(code.code4==1)) {
		        	session.getAgenda().getAgendaGroup("A031").setFocus();
		        }
		        if ((code.code3==3)&&(code.code4==2)) {
		        	session.getAgenda().getAgendaGroup("A032").setFocus();
		        }
		        if ((code.code3==4)&&(code.code4==1)) {
		        	session.getAgenda().getAgendaGroup("A041").setFocus();
		        }
		        if ((code.code3==4)&&(code.code4==2)) {
		        	session.getAgenda().getAgendaGroup("A042").setFocus();
		        }
		        if ((code.code3==4)&&(code.code4==3)) {
		        	session.getAgenda().getAgendaGroup("A043").setFocus();
		        }
	        }
	        if (code.getDc()>=7&&code.getDc()<14) {
		        if ((code.code3==1)&&(code.code4==1)) {
		        	session.getAgenda().getAgendaGroup("A11").setFocus();
		        }
		        if ((code.code3==2)&&(code.code4==2)) {
		        	session.getAgenda().getAgendaGroup("A12").setFocus();
		        }
		        if ((code.code3==3)&&(code.code4==3)) {
		        	session.getAgenda().getAgendaGroup("A13").setFocus();
		        }
		        if ((code.code3==4)&&(code.code4==4)) {
		        	session.getAgenda().getAgendaGroup("A14").setFocus();
		        }
		        if ((code.code3==1)&&(code.code4==2)) {
		        	session.getAgenda().getAgendaGroup("A112").setFocus();
		        }
		        if ((code.code3==1)&&(code.code4==3)) {
		        	session.getAgenda().getAgendaGroup("A113").setFocus();
		        }
		        if ((code.code3==1)&&(code.code4==4)) {
		        	session.getAgenda().getAgendaGroup("A114").setFocus();
		        }
		        if ((code.code3==2)&&(code.code4==3)) {
		        	session.getAgenda().getAgendaGroup("A123").setFocus();
		        }
		        if ((code.code3==2)&&(code.code4==4)) {
		        	session.getAgenda().getAgendaGroup("A124").setFocus();
		        }
		        if ((code.code3==3)&&(code.code4==4)) {
		        	session.getAgenda().getAgendaGroup("A134").setFocus();
		        }
		        if ((code.code3==2)&&(code.code4==1)) {
		        	session.getAgenda().getAgendaGroup("A121").setFocus();
		        }
		        if ((code.code3==3)&&(code.code4==1)) {
		        	session.getAgenda().getAgendaGroup("A131").setFocus();
		        }
		        if ((code.code3==3)&&(code.code4==2)) {
		        	session.getAgenda().getAgendaGroup("A132").setFocus();
		        }
		        if ((code.code3==4)&&(code.code4==1)) {
		        	session.getAgenda().getAgendaGroup("A141").setFocus();
		        }
		        if ((code.code3==4)&&(code.code4==2)) {
		        	session.getAgenda().getAgendaGroup("A142").setFocus();
		        }
		        if ((code.code3==4)&&(code.code4==3)) {
		        	session.getAgenda().getAgendaGroup("A143").setFocus();
		        }	
	        }
	        if (code.getDc()>=14&&code.getDc()<21) {
		        if ((code.code3==1)&&(code.code4==1)) {
		        	session.getAgenda().getAgendaGroup("A21").setFocus();
		        }
		        if ((code.code3==2)&&(code.code4==2)) {
		        	session.getAgenda().getAgendaGroup("A22").setFocus();
		        }
		        if ((code.code3==3)&&(code.code4==3)) {
		        	session.getAgenda().getAgendaGroup("A23").setFocus();
		        }
		        if ((code.code3==4)&&(code.code4==4)) {
		        	session.getAgenda().getAgendaGroup("A24").setFocus();
		        }
		        if ((code.code3==1)&&(code.code4==2)) {
		        	session.getAgenda().getAgendaGroup("A212").setFocus();
		        }
		        if ((code.code3==1)&&(code.code4==3)) {
		        	session.getAgenda().getAgendaGroup("A213").setFocus();
		        }
		        if ((code.code3==1)&&(code.code4==4)) {
		        	session.getAgenda().getAgendaGroup("A214").setFocus();
		        }
		        if ((code.code3==2)&&(code.code4==3)) {
		        	session.getAgenda().getAgendaGroup("A223").setFocus();
		        }
		        if ((code.code3==2)&&(code.code4==4)) {
		        	session.getAgenda().getAgendaGroup("A224").setFocus();
		        }
		        if ((code.code3==3)&&(code.code4==4)) {
		        	session.getAgenda().getAgendaGroup("A234").setFocus();
		        }
		        if ((code.code3==2)&&(code.code4==1)) {
		        	session.getAgenda().getAgendaGroup("A221").setFocus();
		        }
		        if ((code.code3==3)&&(code.code4==1)) {
		        	session.getAgenda().getAgendaGroup("A231").setFocus();
		        }
		        if ((code.code3==3)&&(code.code4==2)) {
		        	session.getAgenda().getAgendaGroup("A232").setFocus();
		        }
		        if ((code.code3==4)&&(code.code4==1)) {
		        	session.getAgenda().getAgendaGroup("A241").setFocus();
		        }
		        if ((code.code3==4)&&(code.code4==2)) {
		        	session.getAgenda().getAgendaGroup("A242").setFocus();
		        }
		        if ((code.code3==4)&&(code.code4==3)) {
		        	session.getAgenda().getAgendaGroup("A243").setFocus();
		        }
	        }
	        if (code.getDc()>=21&&code.getDc()<28) {
		        if ((code.code3==1)&&(code.code4==1)) {
		        	session.getAgenda().getAgendaGroup("A31").setFocus();
		        }
		        if ((code.code3==2)&&(code.code4==2)) {
		        	session.getAgenda().getAgendaGroup("A32").setFocus();
		        }
		        if ((code.code3==3)&&(code.code4==3)) {
		        	session.getAgenda().getAgendaGroup("A33").setFocus();
		        }
		        if ((code.code3==4)&&(code.code4==4)) {
		        	session.getAgenda().getAgendaGroup("A34").setFocus();
		        }
		        if ((code.code3==1)&&(code.code4==2)) {
		        	session.getAgenda().getAgendaGroup("A312").setFocus();
		        }
		        if ((code.code3==1)&&(code.code4==3)) {
		        	session.getAgenda().getAgendaGroup("A313").setFocus();
		        }
		        if ((code.code3==1)&&(code.code4==4)) {
		        	session.getAgenda().getAgendaGroup("A314").setFocus();
		        }
		        if ((code.code3==2)&&(code.code4==3)) {
		        	session.getAgenda().getAgendaGroup("A323").setFocus();
		        }
		        if ((code.code3==2)&&(code.code4==4)) {
		        	session.getAgenda().getAgendaGroup("A324").setFocus();
		        }
		        if ((code.code3==3)&&(code.code4==4)) {
		        	session.getAgenda().getAgendaGroup("A334").setFocus();
		        }
		        if ((code.code3==2)&&(code.code4==1)) {
		        	session.getAgenda().getAgendaGroup("A321").setFocus();
		        }
		        if ((code.code3==3)&&(code.code4==1)) {
		        	session.getAgenda().getAgendaGroup("A331").setFocus();
		        }
		        if ((code.code3==3)&&(code.code4==2)) {
		        	session.getAgenda().getAgendaGroup("A332").setFocus();
		        }
		        if ((code.code3==4)&&(code.code4==1)) {
		        	session.getAgenda().getAgendaGroup("A341").setFocus();
		        }
		        if ((code.code3==4)&&(code.code4==2)) {
		        	session.getAgenda().getAgendaGroup("A342").setFocus();
		        }
		        if ((code.code3==4)&&(code.code4==3)) {
		        	session.getAgenda().getAgendaGroup("A343").setFocus();
		        }
	        }
	        if (code.getDc()>=28) {
		        if ((code.code3==1)&&(code.code4==1)) {
		        	session.getAgenda().getAgendaGroup("A41").setFocus();
		        }
		        if ((code.code3==2)&&(code.code4==2)) {
		        	session.getAgenda().getAgendaGroup("A42").setFocus();
		        }
		        if ((code.code3==3)&&(code.code4==3)) {
		        	session.getAgenda().getAgendaGroup("A43").setFocus();
		        }
		        if ((code.code3==4)&&(code.code4==4)) {
		        	session.getAgenda().getAgendaGroup("A44").setFocus();
		        }
		        if ((code.code3==1)&&(code.code4==2)) {
		        	session.getAgenda().getAgendaGroup("A412").setFocus();
		        }
		        if ((code.code3==1)&&(code.code4==3)) {
		        	session.getAgenda().getAgendaGroup("A413").setFocus();
		        }
		        if ((code.code3==1)&&(code.code4==4)) {
		        	session.getAgenda().getAgendaGroup("A414").setFocus();
		        }
		        if ((code.code3==2)&&(code.code4==3)) {
		        	session.getAgenda().getAgendaGroup("A423").setFocus();
		        }
		        if ((code.code3==2)&&(code.code4==4)) {
		        	session.getAgenda().getAgendaGroup("A424").setFocus();
		        }
		        if ((code.code3==3)&&(code.code4==4)) {
		        	session.getAgenda().getAgendaGroup("A434").setFocus();
		        }
		        if ((code.code3==2)&&(code.code4==1)) {
		        	session.getAgenda().getAgendaGroup("A421").setFocus();
		        }
		        if ((code.code3==3)&&(code.code4==1)) {
		        	session.getAgenda().getAgendaGroup("A431").setFocus();
		        }
		        if ((code.code3==3)&&(code.code4==2)) {
		        	session.getAgenda().getAgendaGroup("A432").setFocus();
		        }
		        if ((code.code3==4)&&(code.code4==1)) {
		        	session.getAgenda().getAgendaGroup("A441").setFocus();
		        }
		        if ((code.code3==4)&&(code.code4==2)) {
		        	session.getAgenda().getAgendaGroup("A442").setFocus();
		        }
		        if ((code.code3==4)&&(code.code4==3)) {
		        	session.getAgenda().getAgendaGroup("A443").setFocus();
		        }
	        }
	        session.getAgenda().getAgendaGroup("RW").setFocus();
	        break;
	        }
	        
			for(WorkDate date : lstDate) {
				session.insert(date);
				for (Shift s : date.getShifts()) {
					session.insert(s);
				}
			}		  
			for (Worker worker : lstWorker) {
				session.insert(worker);
			}	        	        
			session.fireAllRules();
			
			System.out.println("Begin Date :");
			System.out.println(Begin_Date);
			session.fireAllRules();	
			System.out.println("Finish Date :");
			System.out.println(Finish_Date);
			System.out.println("\n");
			c.add(Calendar.DATE,-code.getDc());	
			int b=code.getId();
			int j = 0;
			if (code.code5== "Sun") {
				j=7;
			} 
			if (code.code5== "Sat") {
				j=6;
			}
			if (code.code5== "Fri") {
				j=5;
			}
			if (code.code5== "Thu") {
				j=4;
			}
			if (code.code5== "Wen") {
				j=3;
			}
			if (code.code5== "Tue") {
				j=2;
			}
			if (code.code5== "Mon") {
				j=1;
			}
	        int r=1;
	        if (j==0) {
	            r=0;
	           }
	        if (j==7)
	        {
	        	j=j-7;
	        }	
	        int u=0;
	        
			List<Shift> lstShift = new ArrayList<Shift>();
			for (Worker w : lstWorker) {
				JSONObject object = new JSONObject();	
				object.put("id",b);
				object.put("name", w.getName());
				lstShift.clear();
				lstShift.addAll(w.getShifts());
				Collections.sort(lstShift);
				u++;
				if (u>code.code2) {
					break;
				}
	             for (Shift shift : lstShift){            	 
	            	int z=shift.getWorkDate().getDay();
	            	int t=shift.getWorkDate().getDay();
	  				 c.add(Calendar.DATE,+z);
	  			    String TIME = dateFormat.format(c.getTime());	
	  		        String[] weekDays = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
	  		        int q = c.get(Calendar.DAY_OF_WEEK) - 1;
	  		        if (q < 0)
	  		            q = 0;	 	  				
	  				object.put("time", TIME);
	  				if (t> 31)
	  				{
	  					t= t-31;
	  				}
	        switch (code.code0) {
	        case 0 :
	        	switch (u) {
	        	case 1 :
	        		switch (t) {
	        		case 1 :
	        			object.put("value", "F");
	        		break;
	        		case 2 :
	        			object.put("value", "F");
	        	    break;
	        		case 3 :
	        			object.put("value", "N");
	        	    break;
	        		case 4 :
	        			object.put("value", "F");
	        	    break;
	        		case 5 :
	        			object.put("value", "N");
	        	    break;
	        		case 6 :
	        			object.put("value", "N");
	        	    break;
	        		case 7 :
	        			object.put("value", "F");
	        	    break;
	        		case 8 :
	        			object.put("value", "D");
	        	    break;
	        		case 9 :
	        			object.put("value", "F");
	        	    break;
	        		case 10 :
	        			object.put("value", "D");
	        	    break;
	        		case 11 :
	        			object.put("value", "F");
	        	    break;
	        		case 12 :
	        			object.put("value", "D");
	        	    break;
	        		case 13 :
	        			object.put("value", "F");
	        	    break;
	        		case 14 :
	        			object.put("value", "D");
	        	    break;
	        		case 15 :
	        			object.put("value", "F");
	        	    break;
	        		case 16 :
	        			object.put("value", "N");
	        	    break;
	        		case 17 :
	        			object.put("value", "F");
	        	    break;
	        		case 18 :
	        			object.put("value", "N");
	        	    break;
	        		case 19 :
	        			object.put("value", "F");
	        	    break;
	        		case 20 :
	        			object.put("value", "N");
	        	    break;
	        		case 21 :
	        			object.put("value", "N");
	        	    break;
	        		case 22 :
	        			object.put("value", "F");
	        	    break;
	        		case 23 :
	        			object.put("value", "D");
	        	    break;
	        		case 24 :
	        			object.put("value", "F");
	        	    break;
	        		case 25 :
	        			object.put("value", "D");
	        	    break;
	        		case 26 :
	        			object.put("value", "D");
	        	    break;
	        		case 27 :
	        			object.put("value", "D");
	        	    break;
	        		case 28 :
	        			object.put("value", "F");
	        	    break;
	        		case 29 :
	        			object.put("value", "D");
	        	    break;
	        		case 30 :
	        			object.put("value", "F");
	        	    break;
	        		case 31 :
	        			object.put("value", "D");
	        	    break;
	        		}
	        		break;
	        	case 2:
	        		switch (t) {
	        		case 1 :
	        			object.put("value", "F");
	        		break;
	        		case 2 :
	        			object.put("value", "F");
	        	    break;
	        		case 3 :
	        			object.put("value", "D");
	        	    break;
	        		case 4 :
	        			object.put("value", "F");
	        	    break;
	        		case 5 :
	        			object.put("value", "D");
	        	    break;
	        		case 6 :
	        			object.put("value", "D");
	        	    break;
	        		case 7 :
	        			object.put("value", "F");
	        	    break;
	        		case 8 :
	        			object.put("value", "N");
	        	    break;
	        		case 9 :
	        			object.put("value", "F");
	        	    break;
	        		case 10 :
	        			object.put("value", "N");
	        	    break;
	        		case 11 :
	        			object.put("value", "F");
	        	    break;
	        		case 12 :
	        			object.put("value", "F");
	        	    break;
	        		case 13 :
	        			object.put("value", "N");
	        	    break;
	        		case 14 :
	        			object.put("value", "N");
	        	    break;
	        		case 15 :
	        			object.put("value", "F");
	        	    break;
	        		case 16 :
	        			object.put("value", "D");
	        	    break;
	        		case 17 :
	        			object.put("value", "F");
	        	    break;
	        		case 18 :
	        			object.put("value", "D");
	        	    break;
	        		case 19 :
	        			object.put("value", "D");
	        	    break;
	        		case 20 :
	        			object.put("value", "F");
	        	    break;
	        		case 21 :
	        			object.put("value", "D");
	        	    break;
	        		case 22 :
	        			object.put("value", "F");
	        	    break;
	        		case 23 :
	        			object.put("value", "N");
	        	    break;
	        		case 24 :
	        			object.put("value", "F");
	        	    break;
	        		case 25 :
	        			object.put("value", "N");
	        	    break;
	        		case 26 :
	        			object.put("value", "N");
	        	    break;
	        		case 27 :
	        			object.put("value", "N");
	        	    break;
	        		case 28 :
	        			object.put("value", "F");
	        	    break;
	        		case 29 :
	        			object.put("value", "N");
	        	    break;
	        		case 30 :
	        			object.put("value", "F");
	        	    break;
	        		case 31 :
	        			object.put("value", "N");
	        	    break;
	        		}
	        		break;
	        	case 3:
	        		switch (t) {
	        		case 1 :
	        			object.put("value", "N");
	        		break;
	        		case 2 :
	        			object.put("value", "N");
	        	    break;
	        		case 3 :
	        			object.put("value", "F");
	        	    break;
	        		case 4 :
	        			object.put("value", "N");
	        	    break;
	        		case 5 :
	        			object.put("value", "F");
	        	    break;
	        		case 6 :
	        			object.put("value", "N");
	        	    break;
	        		case 7 :
	        			object.put("value", "N");
	        	    break;
	        		case 8 :
	        			object.put("value", "F");
	        	    break;
	        		case 9 :
	        			object.put("value", "D");
	        	    break;
	        		case 10 :
	        			object.put("value", "F");
	        	    break;
	        		case 11 :
	        			object.put("value", "D");
	        	    break;
	        		case 12 :
	        			object.put("value", "D");
	        	    break;
	        		case 13 :
	        			object.put("value", "D");
	        	    break;
	        		case 14 :
	        			object.put("value", "F");
	        	    break;
	        		case 15 :
	        			object.put("value", "N");
	        	    break;
	        		case 16 :
	        			object.put("value", "F");
	        	    break;
	        		case 17 :
	        			object.put("value", "N");
	        	    break;
	        		case 18 :
	        			object.put("value", "F");
	        	    break;
	        		case 19 :
	        			object.put("value", "N");
	        	    break;
	        		case 20 :
	        			object.put("value", "N");
	        	    break;
	        		case 21 :
	        			object.put("value", "F");
	        	    break;
	        		case 22 :
	        			object.put("value", "D");
	        	    break;
	        		case 23 :
	        			object.put("value", "F");
	        	    break;
	        		case 24 :
	        			object.put("value", "D");
	        	    break;
	        		case 25 :
	        			object.put("value", "F");
	        	    break;
	        		case 26 :
	        			object.put("value", "N");
	        	    break;
	        		case 27 :
	        			object.put("value", "F");
	        	    break;
	        		case 28 :
	        			object.put("value", "N");
	        	    break;
	        		case 29 :
	        			object.put("value", "N");
	        	    break;
	        		case 30 :
	        			object.put("value", "F");
	        	    break;
	        		case 31 :
	        			object.put("value", "N");
	        	    break;
	        		}
	        		break;
	        	case 4:
	        		switch (t) {
	        		case 1 :
	        			object.put("value", "D");
	        		break;
	        		case 2 :
	        			object.put("value", "D");
	        	    break;
	        		case 3 :
	        			object.put("value", "F");
	        	    break;
	        		case 4 :
	        			object.put("value", "D");
	        	    break;
	        		case 5 :
	        			object.put("value", "D");
	        	    break;
	        		case 6 :
	        			object.put("value", "F");
	        	    break;
	        		case 7 :
	        			object.put("value", "D");
	        	    break;
	        		case 8 :
	        			object.put("value", "F");
	        	    break;
	        		case 9 :
	        			object.put("value", "N");
	        	    break;
	        		case 10 :
	        			object.put("value", "F");
	        	    break;
	        		case 11 :
	        			object.put("value", "N");
	        	    break;
	        		case 12 :
	        			object.put("value", "N");
	        	    break;
	        		case 13 :
	        			object.put("value", "N");
	        	    break;
	        		case 14 :
	        			object.put("value", "F");
	        	    break;
	        		case 15 :
	        			object.put("value", "D");
	        	    break;
	        		case 16 :
	        			object.put("value", "F");
	        	    break;
	        		case 17 :
	        			object.put("value", "D");
	        	    break;
	        		case 18 :
	        			object.put("value", "F");
	        	    break;
	        		case 19 :
	        			object.put("value", "D");
	        	    break;
	        		case 20 :
	        			object.put("value", "D");
	        	    break;
	        		case 21 :
	        			object.put("value", "F");
	        	    break;
	        		case 22 :
	        			object.put("value", "N");
	        	    break;
	        		case 23 :
	        			object.put("value", "F");
	        	    break;
	        		case 24 :
	        			object.put("value", "N");
	        	    break;
	        		case 25 :
	        			object.put("value", "F");
	        	    break;
	        		case 26 :
	        			object.put("value", "D");
	        	    break;
	        		case 27 :
	        			object.put("value", "F");
	        	    break;
	        		case 28 :
	        			object.put("value", "D");
	        	    break;
	        		case 29 :
	        			object.put("value", "F");
	        	    break;
	        		case 30 :
	        			object.put("value", "D");
	        	    break;
	        		case 31 :
	        			object.put("value", "F");
	        	    break;
	        		}
	        		break;
	        	}
	        	break;
      	
	        case 1 :
	  			    int x = shift.getNo();
	  			    if (weekDays[q]==weekDays[j]&& r!=0) {
	  			    	 object.put("value", "F");
	  			    }
	  			    else if (code.sun != "" || code.sat != ""|| code.fri != ""|| code.thu != ""|| code.wen != ""|| code.tue != ""|| code.mon != "") {
	  			    	if (code.sun != "" && q ==0) {
	  			    		object.put("value", code.sun);
	  			    	}
	  			    	if (code.sat != "" && q ==0) {
	  			    		object.put("value", code.sun);
	  			    	}
	  			    	if (code.fri != "" && q ==0) {
	  			    		object.put("value", code.sun);
	  			    	}
	  			    	if (code.thu != "" && q ==0) {
	  			    		object.put("value", code.sun);
	  			    	}
	  			    	if (code.wen != "" && q ==0) {
	  			    		object.put("value", code.sun);
	  			    	}
	  			    	if (code.tue != "" && q ==0) {
	  			    		object.put("value", code.sun);
	  			    	}
	  			    	if (code.mon != "" && q ==0) {
	  			    		object.put("value", code.sun);
	  			    	}
	  			    }
	  			    else {
	                             if(x==1){
	                            	 object.put("value", "D");
	  			              }
	                              if (x==2){
	                            	  object.put("value", "N");
	                            }
	  			    }	            	             	              	  		
			break;
			}
			 c.add(Calendar.DATE,-z);
				String str = JSONObject.toJSONString(object, SerializerFeature.DisableCircularReferenceDetect);
				JSONObject jsonjson = JSONObject.parseObject(str);
            js.add(jsonjson);
	             }
			}
			session.dispose();
		}
		
if (code.getId() == 2) {

    	 List<WorkDate> lstDate = new ArrayList<WorkDate>();
    	 
    	 for (int i = 1; i<=code.getDc(); i ++) {
    		 lstDate.add(new WorkDate(i));	 
    	 }
    	 char a='A';
    	 List<Worker> lstWorker = new ArrayList<Worker>() ;
    		for (int i=1;i<=code.getCode2();i++) {
					 if (i==1) {
						 a='A';
					 }
					 if (i==2) {
						 a='B';
					 }
					 if (i==3) {
						 a='C';
					 }
					 if (i==4) {
						 a='D';
					 }
    			Worker w=new Worker(1,"Long Hole Team "+a);
    			w.setEasyDay(lstDate.size());
    			lstWorker.add(w);
    		}
    		
    		if(code.getCode1()>2) {
    			System.out.println("Error:Too Many Shifts");
    			throw new RuntimeException("Unable to compile.");
    		}
    		if(code.getDc()>31) {
    			System.out.println("Error:The Schedule is too Long");
    			throw new RuntimeException("Unable to compile.");
    		}

			KieServices kieServices = KieServices.Factory.get(); 
	        KieContainer kieContainer = kieServices.getKieClasspathContainer();
	        KieSession session =  kieContainer.newKieSession("RuleLongHoleTeam.drl");
	        
	        switch (code.code0) {
	        case 0 :
	        	session.getAgenda().getAgendaGroup("C1").setFocus();
	        	session.getAgenda().getAgendaGroup("RC").setFocus();
	        	break;
	        case 1:
	        if (code.getDc()>=0&&code.getDc()<7) {
		        if ((code.code3==1)&&(code.code4==1)) {
		        	session.getAgenda().getAgendaGroup("A01").setFocus();
		        }
		        if ((code.code3==2)&&(code.code4==2)) {
		        	session.getAgenda().getAgendaGroup("A02").setFocus();
		        }
		        if ((code.code3==3)&&(code.code4==3)) {
		        	session.getAgenda().getAgendaGroup("A03").setFocus();
		        }
		        if ((code.code3==4)&&(code.code4==4)) {
		        	session.getAgenda().getAgendaGroup("A04").setFocus();
		        }
		        if ((code.code3==1)&&(code.code4==2)) {
		        	session.getAgenda().getAgendaGroup("A012").setFocus();
		        }
		        if ((code.code3==1)&&(code.code4==3)) {
		        	session.getAgenda().getAgendaGroup("A013").setFocus();
		        }
		        if ((code.code3==1)&&(code.code4==4)) {
		        	session.getAgenda().getAgendaGroup("A014").setFocus();
		        }
		        if ((code.code3==2)&&(code.code4==3)) {
		        	session.getAgenda().getAgendaGroup("A023").setFocus();
		        }
		        if ((code.code3==2)&&(code.code4==4)) {
		        	session.getAgenda().getAgendaGroup("A024").setFocus();
		        }
		        if ((code.code3==3)&&(code.code4==4)) {
		        	session.getAgenda().getAgendaGroup("A034").setFocus();
		        }
		        if ((code.code3==2)&&(code.code4==1)) {
		        	session.getAgenda().getAgendaGroup("A021").setFocus();
		        }
		        if ((code.code3==3)&&(code.code4==1)) {
		        	session.getAgenda().getAgendaGroup("A031").setFocus();
		        }
		        if ((code.code3==3)&&(code.code4==2)) {
		        	session.getAgenda().getAgendaGroup("A032").setFocus();
		        }
		        if ((code.code3==4)&&(code.code4==1)) {
		        	session.getAgenda().getAgendaGroup("A041").setFocus();
		        }
		        if ((code.code3==4)&&(code.code4==2)) {
		        	session.getAgenda().getAgendaGroup("A042").setFocus();
		        }
		        if ((code.code3==4)&&(code.code4==3)) {
		        	session.getAgenda().getAgendaGroup("A043").setFocus();
		        }
	        }
	        if (code.getDc()>=7&&code.getDc()<14) {
		        if ((code.code3==1)&&(code.code4==1)) {
		        	session.getAgenda().getAgendaGroup("A11").setFocus();
		        }
		        if ((code.code3==2)&&(code.code4==2)) {
		        	session.getAgenda().getAgendaGroup("A12").setFocus();
		        }
		        if ((code.code3==3)&&(code.code4==3)) {
		        	session.getAgenda().getAgendaGroup("A13").setFocus();
		        }
		        if ((code.code3==4)&&(code.code4==4)) {
		        	session.getAgenda().getAgendaGroup("A14").setFocus();
		        }
		        if ((code.code3==1)&&(code.code4==2)) {
		        	session.getAgenda().getAgendaGroup("A112").setFocus();
		        }
		        if ((code.code3==1)&&(code.code4==3)) {
		        	session.getAgenda().getAgendaGroup("A113").setFocus();
		        }
		        if ((code.code3==1)&&(code.code4==4)) {
		        	session.getAgenda().getAgendaGroup("A114").setFocus();
		        }
		        if ((code.code3==2)&&(code.code4==3)) {
		        	session.getAgenda().getAgendaGroup("A123").setFocus();
		        }
		        if ((code.code3==2)&&(code.code4==4)) {
		        	session.getAgenda().getAgendaGroup("A124").setFocus();
		        }
		        if ((code.code3==3)&&(code.code4==4)) {
		        	session.getAgenda().getAgendaGroup("A134").setFocus();
		        }
		        if ((code.code3==2)&&(code.code4==1)) {
		        	session.getAgenda().getAgendaGroup("A121").setFocus();
		        }
		        if ((code.code3==3)&&(code.code4==1)) {
		        	session.getAgenda().getAgendaGroup("A131").setFocus();
		        }
		        if ((code.code3==3)&&(code.code4==2)) {
		        	session.getAgenda().getAgendaGroup("A132").setFocus();
		        }
		        if ((code.code3==4)&&(code.code4==1)) {
		        	session.getAgenda().getAgendaGroup("A141").setFocus();
		        }
		        if ((code.code3==4)&&(code.code4==2)) {
		        	session.getAgenda().getAgendaGroup("A142").setFocus();
		        }
		        if ((code.code3==4)&&(code.code4==3)) {
		        	session.getAgenda().getAgendaGroup("A143").setFocus();
		        }	
	        }
	        if (code.getDc()>=14&&code.getDc()<21) {
		        if ((code.code3==1)&&(code.code4==1)) {
		        	session.getAgenda().getAgendaGroup("A21").setFocus();
		        }
		        if ((code.code3==2)&&(code.code4==2)) {
		        	session.getAgenda().getAgendaGroup("A22").setFocus();
		        }
		        if ((code.code3==3)&&(code.code4==3)) {
		        	session.getAgenda().getAgendaGroup("A23").setFocus();
		        }
		        if ((code.code3==4)&&(code.code4==4)) {
		        	session.getAgenda().getAgendaGroup("A24").setFocus();
		        }
		        if ((code.code3==1)&&(code.code4==2)) {
		        	session.getAgenda().getAgendaGroup("A212").setFocus();
		        }
		        if ((code.code3==1)&&(code.code4==3)) {
		        	session.getAgenda().getAgendaGroup("A213").setFocus();
		        }
		        if ((code.code3==1)&&(code.code4==4)) {
		        	session.getAgenda().getAgendaGroup("A214").setFocus();
		        }
		        if ((code.code3==2)&&(code.code4==3)) {
		        	session.getAgenda().getAgendaGroup("A223").setFocus();
		        }
		        if ((code.code3==2)&&(code.code4==4)) {
		        	session.getAgenda().getAgendaGroup("A224").setFocus();
		        }
		        if ((code.code3==3)&&(code.code4==4)) {
		        	session.getAgenda().getAgendaGroup("A234").setFocus();
		        }
		        if ((code.code3==2)&&(code.code4==1)) {
		        	session.getAgenda().getAgendaGroup("A221").setFocus();
		        }
		        if ((code.code3==3)&&(code.code4==1)) {
		        	session.getAgenda().getAgendaGroup("A231").setFocus();
		        }
		        if ((code.code3==3)&&(code.code4==2)) {
		        	session.getAgenda().getAgendaGroup("A232").setFocus();
		        }
		        if ((code.code3==4)&&(code.code4==1)) {
		        	session.getAgenda().getAgendaGroup("A241").setFocus();
		        }
		        if ((code.code3==4)&&(code.code4==2)) {
		        	session.getAgenda().getAgendaGroup("A242").setFocus();
		        }
		        if ((code.code3==4)&&(code.code4==3)) {
		        	session.getAgenda().getAgendaGroup("A243").setFocus();
		        }
	        }
	        if (code.getDc()>=21&&code.getDc()<28) {
		        if ((code.code3==1)&&(code.code4==1)) {
		        	session.getAgenda().getAgendaGroup("A31").setFocus();
		        }
		        if ((code.code3==2)&&(code.code4==2)) {
		        	session.getAgenda().getAgendaGroup("A32").setFocus();
		        }
		        if ((code.code3==3)&&(code.code4==3)) {
		        	session.getAgenda().getAgendaGroup("A33").setFocus();
		        }
		        if ((code.code3==4)&&(code.code4==4)) {
		        	session.getAgenda().getAgendaGroup("A34").setFocus();
		        }
		        if ((code.code3==1)&&(code.code4==2)) {
		        	session.getAgenda().getAgendaGroup("A312").setFocus();
		        }
		        if ((code.code3==1)&&(code.code4==3)) {
		        	session.getAgenda().getAgendaGroup("A313").setFocus();
		        }
		        if ((code.code3==1)&&(code.code4==4)) {
		        	session.getAgenda().getAgendaGroup("A314").setFocus();
		        }
		        if ((code.code3==2)&&(code.code4==3)) {
		        	session.getAgenda().getAgendaGroup("A323").setFocus();
		        }
		        if ((code.code3==2)&&(code.code4==4)) {
		        	session.getAgenda().getAgendaGroup("A324").setFocus();
		        }
		        if ((code.code3==3)&&(code.code4==4)) {
		        	session.getAgenda().getAgendaGroup("A334").setFocus();
		        }
		        if ((code.code3==2)&&(code.code4==1)) {
		        	session.getAgenda().getAgendaGroup("A321").setFocus();
		        }
		        if ((code.code3==3)&&(code.code4==1)) {
		        	session.getAgenda().getAgendaGroup("A331").setFocus();
		        }
		        if ((code.code3==3)&&(code.code4==2)) {
		        	session.getAgenda().getAgendaGroup("A332").setFocus();
		        }
		        if ((code.code3==4)&&(code.code4==1)) {
		        	session.getAgenda().getAgendaGroup("A341").setFocus();
		        }
		        if ((code.code3==4)&&(code.code4==2)) {
		        	session.getAgenda().getAgendaGroup("A342").setFocus();
		        }
		        if ((code.code3==4)&&(code.code4==3)) {
		        	session.getAgenda().getAgendaGroup("A343").setFocus();
		        }
	        }
	        if (code.getDc()>=28) {
		        if ((code.code3==1)&&(code.code4==1)) {
		        	session.getAgenda().getAgendaGroup("A41").setFocus();
		        }
		        if ((code.code3==2)&&(code.code4==2)) {
		        	session.getAgenda().getAgendaGroup("A42").setFocus();
		        }
		        if ((code.code3==3)&&(code.code4==3)) {
		        	session.getAgenda().getAgendaGroup("A43").setFocus();
		        }
		        if ((code.code3==4)&&(code.code4==4)) {
		        	session.getAgenda().getAgendaGroup("A44").setFocus();
		        }
		        if ((code.code3==1)&&(code.code4==2)) {
		        	session.getAgenda().getAgendaGroup("A412").setFocus();
		        }
		        if ((code.code3==1)&&(code.code4==3)) {
		        	session.getAgenda().getAgendaGroup("A413").setFocus();
		        }
		        if ((code.code3==1)&&(code.code4==4)) {
		        	session.getAgenda().getAgendaGroup("A414").setFocus();
		        }
		        if ((code.code3==2)&&(code.code4==3)) {
		        	session.getAgenda().getAgendaGroup("A423").setFocus();
		        }
		        if ((code.code3==2)&&(code.code4==4)) {
		        	session.getAgenda().getAgendaGroup("A424").setFocus();
		        }
		        if ((code.code3==3)&&(code.code4==4)) {
		        	session.getAgenda().getAgendaGroup("A434").setFocus();
		        }
		        if ((code.code3==2)&&(code.code4==1)) {
		        	session.getAgenda().getAgendaGroup("A421").setFocus();
		        }
		        if ((code.code3==3)&&(code.code4==1)) {
		        	session.getAgenda().getAgendaGroup("A431").setFocus();
		        }
		        if ((code.code3==3)&&(code.code4==2)) {
		        	session.getAgenda().getAgendaGroup("A432").setFocus();
		        }
		        if ((code.code3==4)&&(code.code4==1)) {
		        	session.getAgenda().getAgendaGroup("A441").setFocus();
		        }
		        if ((code.code3==4)&&(code.code4==2)) {
		        	session.getAgenda().getAgendaGroup("A442").setFocus();
		        }
		        if ((code.code3==4)&&(code.code4==3)) {
		        	session.getAgenda().getAgendaGroup("A443").setFocus();
		        }
	        }
	        session.getAgenda().getAgendaGroup("RW").setFocus();
	        break;
	        }
	        
    		for(WorkDate date : lstDate) {
    			session.insert(date);
    			for (Shift s : date.getShifts()) {
    				session.insert(s);
    			}
    		}
    	    
    		for (Worker worker : lstWorker) {
    			session.insert(worker);
    		}		
    		System.out.println("Begin Date :");
    		System.out.println(Begin_Date);
    		session.fireAllRules();	
    		System.out.println("Finish Date :");
    		System.out.println(Finish_Date);
    		System.out.println("\n");
    		c.add(Calendar.DATE,-code.getDc());

    		
    		int b=code.getId();
            int u = 0;
			int j = 0;
			if (code.code5== "Sun") {
				j=7;
			} 
			if (code.code5== "Sat") {
				j=6;
			}
			if (code.code5== "Fri") {
				j=5;
			}
			if (code.code5== "Thu") {
				j=4;
			}
			if (code.code5== "Wen") {
				j=3;
			}
			if (code.code5== "Tue") {
				j=2;
			}
			if (code.code5== "Mon") {
				j=1;
			}
            int r=1;
            if (j==0) {
                r=0;
               }
            if (j==7) {
            	j=j-7;
            }
    		List<Shift> lstShift = new ArrayList<Shift>();
    		for (Worker w : lstWorker) {
    			JSONObject object = new JSONObject();	
    			object.put("id", b);
    			object.put("name", w.getName());
    			lstShift.clear();
    			lstShift.addAll(w.getShifts());
    			Collections.sort(lstShift);
				u++;
				if (u>code.code2) {
					break;
				}
                 for (Shift shift : lstShift){            	 
                	int z=shift.getWorkDate().getDay();
      				 c.add(Calendar.DATE,+z);
      			    String TIME = dateFormat.format(c.getTime());	
      		        String[] weekDays = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
      		        int q = c.get(Calendar.DAY_OF_WEEK) - 1;
      		        if (q < 0)
      		            q = 0;	       				
      				object.put("time", TIME);
      				int t=u;
      				if (t>2) {
      					t= t-2;
      				}
       switch (code.code0) {
      		        case 0 :
      		        	switch (t) {
      		        	case 1:      		        	
      	                switch (q) {
      	                case 0:            
      	                	object.put("value", "D");
      	                	break;
      	                case 1:
      	                	object.put("value", "F");
      	                	break;
      	                case 2:
      	                	object.put("value", "D");
      	                	break;
      	                case 3:
      	                	object.put("value", "F");
      	                	break;
      	                case 4:
      	                	object.put("value", "D");
      	                	break;
      	                case 5:
      	                	object.put("value", "D");
      	                	break;
      	                case 6:
      	                	object.put("value", "F");
      	                	break;
      	                }
      	                break;
      		        	case 2:
          	                switch (q) {
          	                case 0:            
          	                	object.put("value", "F");
          	                	break;
          	                case 1:
          	                	object.put("value", "D");
          	                	break;
          	                case 2:
          	                	object.put("value", "F");
          	                	break;
          	                case 3:
          	                	object.put("value", "D");
          	                	break;
          	                case 4:
          	                	object.put("value", "D");
          	                	break;
          	                case 5:
          	                	object.put("value", "F");
          	                	break;
          	                case 6:
          	                	object.put("value", "D");
          	                	break;
          	                }
          	                break;
      		        	}
      		        	break;
      		        case 1:     		            		        	     		        	
      			    int x = shift.getNo();
      			    if (weekDays[q]==weekDays[j]&& r!=0) {
      			    	 object.put("value", "F");
      			    }
	  			    else if (code.sun != "" || code.sat != ""|| code.fri != ""|| code.thu != ""|| code.wen != ""|| code.tue != ""|| code.mon != "") {
	  			    	if (code.sun != "" && q ==0) {
	  			    		object.put("value", code.sun);
	  			    	}
	  			    	if (code.sat != "" && q ==0) {
	  			    		object.put("value", code.sun);
	  			    	}
	  			    	if (code.fri != "" && q ==0) {
	  			    		object.put("value", code.sun);
	  			    	}
	  			    	if (code.thu != "" && q ==0) {
	  			    		object.put("value", code.sun);
	  			    	}
	  			    	if (code.wen != "" && q ==0) {
	  			    		object.put("value", code.sun);
	  			    	}
	  			    	if (code.tue != "" && q ==0) {
	  			    		object.put("value", code.sun);
	  			    	}
	  			    	if (code.mon != "" && q ==0) {
	  			    		object.put("value", code.sun);
	  			    	}
	  			    }
      			    else {
                                 if(x==1){
                                	 object.put("value", "D");
      			              }
                                  if (x==2){
                                	  object.put("value", "N");
                                }
      			    }
      			    break;
       }
                 				 c.add(Calendar.DATE,-z);
 	             				String str = JSONObject.toJSONString(object, SerializerFeature.DisableCircularReferenceDetect);
 	             				JSONObject jsonjson = JSONObject.parseObject(str);
 	            	            js.add(jsonjson);	 
                                }
      		}
    		session.dispose();
        }

        
 if (code.getId() == 3)
 {

	 List<WorkDate> lstDate = new ArrayList<WorkDate>();
	 
	 for (int i = 1; i<=code.getDc(); i ++) {
		 lstDate.add(new WorkDate(i));	 
	 }

	 List<Worker> lstWorker = new ArrayList<Worker>() ;
        char a = 'A';
		for (int i=1;i<=code.getCode2();i++) {
			 if (i==1) {
				 a='A';
			 }
			 if (i==2) {
				 a='B';
			 }
			 if (i==3) {
				 a='C';
			 }
			 if (i==4) {
				 a='D';
			 }
			Worker w=new Worker(1,"Manager Ass "+a);
			w.setEasyDay(lstDate.size());
			lstWorker.add(w);
		}
		
		if(code.getCode1()>2) {
			System.out.println("Error:Too Many Shifts");
			throw new RuntimeException("Unable to compile.");
		}
		if(code.getDc()>31) {
			System.out.println("Error:The Schedule is too Long");
			throw new RuntimeException("Unable to compile.");
		}

		KieServices kieServices = KieServices.Factory.get(); 
        KieContainer kieContainer = kieServices.getKieClasspathContainer();
        KieSession session =  kieContainer.newKieSession("RuleMA.drl");
		
        switch (code.code0) {
        case 0 :
        	session.getAgenda().getAgendaGroup("C1").setFocus();
        	session.getAgenda().getAgendaGroup("RC").setFocus();
        	break;
        case 1:
        if (code.getDc()>=0&&code.getDc()<7) {
	        if ((code.code3==1)&&(code.code4==1)) {
	        	session.getAgenda().getAgendaGroup("A01").setFocus();
	        }
	        if ((code.code3==2)&&(code.code4==2)) {
	        	session.getAgenda().getAgendaGroup("A02").setFocus();
	        }
	        if ((code.code3==3)&&(code.code4==3)) {
	        	session.getAgenda().getAgendaGroup("A03").setFocus();
	        }
	        if ((code.code3==4)&&(code.code4==4)) {
	        	session.getAgenda().getAgendaGroup("A04").setFocus();
	        }
	        if ((code.code3==1)&&(code.code4==2)) {
	        	session.getAgenda().getAgendaGroup("A012").setFocus();
	        }
	        if ((code.code3==1)&&(code.code4==3)) {
	        	session.getAgenda().getAgendaGroup("A013").setFocus();
	        }
	        if ((code.code3==1)&&(code.code4==4)) {
	        	session.getAgenda().getAgendaGroup("A014").setFocus();
	        }
	        if ((code.code3==2)&&(code.code4==3)) {
	        	session.getAgenda().getAgendaGroup("A023").setFocus();
	        }
	        if ((code.code3==2)&&(code.code4==4)) {
	        	session.getAgenda().getAgendaGroup("A024").setFocus();
	        }
	        if ((code.code3==3)&&(code.code4==4)) {
	        	session.getAgenda().getAgendaGroup("A034").setFocus();
	        }
	        if ((code.code3==2)&&(code.code4==1)) {
	        	session.getAgenda().getAgendaGroup("A021").setFocus();
	        }
	        if ((code.code3==3)&&(code.code4==1)) {
	        	session.getAgenda().getAgendaGroup("A031").setFocus();
	        }
	        if ((code.code3==3)&&(code.code4==2)) {
	        	session.getAgenda().getAgendaGroup("A032").setFocus();
	        }
	        if ((code.code3==4)&&(code.code4==1)) {
	        	session.getAgenda().getAgendaGroup("A041").setFocus();
	        }
	        if ((code.code3==4)&&(code.code4==2)) {
	        	session.getAgenda().getAgendaGroup("A042").setFocus();
	        }
	        if ((code.code3==4)&&(code.code4==3)) {
	        	session.getAgenda().getAgendaGroup("A043").setFocus();
	        }
        }
        if (code.getDc()>=7&&code.getDc()<14) {
	        if ((code.code3==1)&&(code.code4==1)) {
	        	session.getAgenda().getAgendaGroup("A11").setFocus();
	        }
	        if ((code.code3==2)&&(code.code4==2)) {
	        	session.getAgenda().getAgendaGroup("A12").setFocus();
	        }
	        if ((code.code3==3)&&(code.code4==3)) {
	        	session.getAgenda().getAgendaGroup("A13").setFocus();
	        }
	        if ((code.code3==4)&&(code.code4==4)) {
	        	session.getAgenda().getAgendaGroup("A14").setFocus();
	        }
	        if ((code.code3==1)&&(code.code4==2)) {
	        	session.getAgenda().getAgendaGroup("A112").setFocus();
	        }
	        if ((code.code3==1)&&(code.code4==3)) {
	        	session.getAgenda().getAgendaGroup("A113").setFocus();
	        }
	        if ((code.code3==1)&&(code.code4==4)) {
	        	session.getAgenda().getAgendaGroup("A114").setFocus();
	        }
	        if ((code.code3==2)&&(code.code4==3)) {
	        	session.getAgenda().getAgendaGroup("A123").setFocus();
	        }
	        if ((code.code3==2)&&(code.code4==4)) {
	        	session.getAgenda().getAgendaGroup("A124").setFocus();
	        }
	        if ((code.code3==3)&&(code.code4==4)) {
	        	session.getAgenda().getAgendaGroup("A134").setFocus();
	        }
	        if ((code.code3==2)&&(code.code4==1)) {
	        	session.getAgenda().getAgendaGroup("A121").setFocus();
	        }
	        if ((code.code3==3)&&(code.code4==1)) {
	        	session.getAgenda().getAgendaGroup("A131").setFocus();
	        }
	        if ((code.code3==3)&&(code.code4==2)) {
	        	session.getAgenda().getAgendaGroup("A132").setFocus();
	        }
	        if ((code.code3==4)&&(code.code4==1)) {
	        	session.getAgenda().getAgendaGroup("A141").setFocus();
	        }
	        if ((code.code3==4)&&(code.code4==2)) {
	        	session.getAgenda().getAgendaGroup("A142").setFocus();
	        }
	        if ((code.code3==4)&&(code.code4==3)) {
	        	session.getAgenda().getAgendaGroup("A143").setFocus();
	        }	
        }
        if (code.getDc()>=14&&code.getDc()<21) {
	        if ((code.code3==1)&&(code.code4==1)) {
	        	session.getAgenda().getAgendaGroup("A21").setFocus();
	        }
	        if ((code.code3==2)&&(code.code4==2)) {
	        	session.getAgenda().getAgendaGroup("A22").setFocus();
	        }
	        if ((code.code3==3)&&(code.code4==3)) {
	        	session.getAgenda().getAgendaGroup("A23").setFocus();
	        }
	        if ((code.code3==4)&&(code.code4==4)) {
	        	session.getAgenda().getAgendaGroup("A24").setFocus();
	        }
	        if ((code.code3==1)&&(code.code4==2)) {
	        	session.getAgenda().getAgendaGroup("A212").setFocus();
	        }
	        if ((code.code3==1)&&(code.code4==3)) {
	        	session.getAgenda().getAgendaGroup("A213").setFocus();
	        }
	        if ((code.code3==1)&&(code.code4==4)) {
	        	session.getAgenda().getAgendaGroup("A214").setFocus();
	        }
	        if ((code.code3==2)&&(code.code4==3)) {
	        	session.getAgenda().getAgendaGroup("A223").setFocus();
	        }
	        if ((code.code3==2)&&(code.code4==4)) {
	        	session.getAgenda().getAgendaGroup("A224").setFocus();
	        }
	        if ((code.code3==3)&&(code.code4==4)) {
	        	session.getAgenda().getAgendaGroup("A234").setFocus();
	        }
	        if ((code.code3==2)&&(code.code4==1)) {
	        	session.getAgenda().getAgendaGroup("A221").setFocus();
	        }
	        if ((code.code3==3)&&(code.code4==1)) {
	        	session.getAgenda().getAgendaGroup("A231").setFocus();
	        }
	        if ((code.code3==3)&&(code.code4==2)) {
	        	session.getAgenda().getAgendaGroup("A232").setFocus();
	        }
	        if ((code.code3==4)&&(code.code4==1)) {
	        	session.getAgenda().getAgendaGroup("A241").setFocus();
	        }
	        if ((code.code3==4)&&(code.code4==2)) {
	        	session.getAgenda().getAgendaGroup("A242").setFocus();
	        }
	        if ((code.code3==4)&&(code.code4==3)) {
	        	session.getAgenda().getAgendaGroup("A243").setFocus();
	        }
        }
        if (code.getDc()>=21&&code.getDc()<28) {
	        if ((code.code3==1)&&(code.code4==1)) {
	        	session.getAgenda().getAgendaGroup("A31").setFocus();
	        }
	        if ((code.code3==2)&&(code.code4==2)) {
	        	session.getAgenda().getAgendaGroup("A32").setFocus();
	        }
	        if ((code.code3==3)&&(code.code4==3)) {
	        	session.getAgenda().getAgendaGroup("A33").setFocus();
	        }
	        if ((code.code3==4)&&(code.code4==4)) {
	        	session.getAgenda().getAgendaGroup("A34").setFocus();
	        }
	        if ((code.code3==1)&&(code.code4==2)) {
	        	session.getAgenda().getAgendaGroup("A312").setFocus();
	        }
	        if ((code.code3==1)&&(code.code4==3)) {
	        	session.getAgenda().getAgendaGroup("A313").setFocus();
	        }
	        if ((code.code3==1)&&(code.code4==4)) {
	        	session.getAgenda().getAgendaGroup("A314").setFocus();
	        }
	        if ((code.code3==2)&&(code.code4==3)) {
	        	session.getAgenda().getAgendaGroup("A323").setFocus();
	        }
	        if ((code.code3==2)&&(code.code4==4)) {
	        	session.getAgenda().getAgendaGroup("A324").setFocus();
	        }
	        if ((code.code3==3)&&(code.code4==4)) {
	        	session.getAgenda().getAgendaGroup("A334").setFocus();
	        }
	        if ((code.code3==2)&&(code.code4==1)) {
	        	session.getAgenda().getAgendaGroup("A321").setFocus();
	        }
	        if ((code.code3==3)&&(code.code4==1)) {
	        	session.getAgenda().getAgendaGroup("A331").setFocus();
	        }
	        if ((code.code3==3)&&(code.code4==2)) {
	        	session.getAgenda().getAgendaGroup("A332").setFocus();
	        }
	        if ((code.code3==4)&&(code.code4==1)) {
	        	session.getAgenda().getAgendaGroup("A341").setFocus();
	        }
	        if ((code.code3==4)&&(code.code4==2)) {
	        	session.getAgenda().getAgendaGroup("A342").setFocus();
	        }
	        if ((code.code3==4)&&(code.code4==3)) {
	        	session.getAgenda().getAgendaGroup("A343").setFocus();
	        }
        }
        if (code.getDc()>=28) {
	        if ((code.code3==1)&&(code.code4==1)) {
	        	session.getAgenda().getAgendaGroup("A41").setFocus();
	        }
	        if ((code.code3==2)&&(code.code4==2)) {
	        	session.getAgenda().getAgendaGroup("A42").setFocus();
	        }
	        if ((code.code3==3)&&(code.code4==3)) {
	        	session.getAgenda().getAgendaGroup("A43").setFocus();
	        }
	        if ((code.code3==4)&&(code.code4==4)) {
	        	session.getAgenda().getAgendaGroup("A44").setFocus();
	        }
	        if ((code.code3==1)&&(code.code4==2)) {
	        	session.getAgenda().getAgendaGroup("A412").setFocus();
	        }
	        if ((code.code3==1)&&(code.code4==3)) {
	        	session.getAgenda().getAgendaGroup("A413").setFocus();
	        }
	        if ((code.code3==1)&&(code.code4==4)) {
	        	session.getAgenda().getAgendaGroup("A414").setFocus();
	        }
	        if ((code.code3==2)&&(code.code4==3)) {
	        	session.getAgenda().getAgendaGroup("A423").setFocus();
	        }
	        if ((code.code3==2)&&(code.code4==4)) {
	        	session.getAgenda().getAgendaGroup("A424").setFocus();
	        }
	        if ((code.code3==3)&&(code.code4==4)) {
	        	session.getAgenda().getAgendaGroup("A434").setFocus();
	        }
	        if ((code.code3==2)&&(code.code4==1)) {
	        	session.getAgenda().getAgendaGroup("A421").setFocus();
	        }
	        if ((code.code3==3)&&(code.code4==1)) {
	        	session.getAgenda().getAgendaGroup("A431").setFocus();
	        }
	        if ((code.code3==3)&&(code.code4==2)) {
	        	session.getAgenda().getAgendaGroup("A432").setFocus();
	        }
	        if ((code.code3==4)&&(code.code4==1)) {
	        	session.getAgenda().getAgendaGroup("A441").setFocus();
	        }
	        if ((code.code3==4)&&(code.code4==2)) {
	        	session.getAgenda().getAgendaGroup("A442").setFocus();
	        }
	        if ((code.code3==4)&&(code.code4==3)) {
	        	session.getAgenda().getAgendaGroup("A443").setFocus();
	        }
        }
        session.getAgenda().getAgendaGroup("RW").setFocus();
        break;
        }
        
		for(WorkDate date : lstDate) {
			session.insert(date);
			for (Shift s : date.getShifts()) {
				session.insert(s);
			}
		}
	    
		for (Worker worker : lstWorker) {
			session.insert(worker);
		}		
		System.out.println("Begin Date :");
		System.out.println(Begin_Date);
		session.fireAllRules();	
		System.out.println("Finish Date :");
		System.out.println(Finish_Date);
		System.out.println("\n");
		c.add(Calendar.DATE,-code.getDc());
		
		int b=code.getId();
        int u = 0;
		int j= 0;
		if (code.code5== "Sun") {
			j=7;
		} 
		if (code.code5== "Sat") {
			j=6;
		}
		if (code.code5== "Fri") {
			j=5;
		}
		if (code.code5== "Thu") {
			j=4;
		}
		if (code.code5== "Wen") {
			j=3;
		}
		if (code.code5== "Tue") {
			j=2;
		}
		if (code.code5== "Mon") {
			j=1;
		}
        int r=1;
        if (j==0) {
            r=0;
           }
        if (j==7)
        {
        	j=j-7;
        }
		List<Shift> lstShift = new ArrayList<Shift>();
		for (Worker w : lstWorker) {
			JSONObject object = new JSONObject();	
			object.put("id", b);
			object.put("name", w.getName());
			lstShift.clear();
			lstShift.addAll(w.getShifts());
			Collections.sort(lstShift);
			u++;
			if (u>code.code2) {
				break;
			}
             for (Shift shift : lstShift){            	 
            	int z=shift.getWorkDate().getDay();
  				 c.add(Calendar.DATE,+z);
  			    String TIME = dateFormat.format(c.getTime());	
  		        String[] weekDays = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
  		        int q = c.get(Calendar.DAY_OF_WEEK) - 1;
  		        if (q < 0)
  		            q = 0;	 
  				
  				object.put("time", TIME);
  		       switch (code.code0) {  		       
 		        case 0 :
 		        	switch (u) {
 		        	case 1: 		       
 		        	switch (q) {
 		        	case 0 :
 		        		object.put("value", "F");
 		        		break;
 		        	case 1:
 		        		object.put("value", "D");
 		        		break;
 		        	case 2:
 		        		object.put("value", "N");
 		        		break;
 		        	case 3:
 		        		object.put("value", "F");
 		        		break;
 		        	case 4:
 		        		object.put("value", "D");
 		        		break;
 		        	case 5:
 		        		object.put("value", "N");
 		        	case 6:
 		        		object.put("value", "F");
 		        		break; 		        		
 		        	}
 		        	break;
 		        	case 2: 		       
 		        	switch (q) {
 		        	case 0 :
 		        		object.put("value", "D");
 		        		break;
 		        	case 1:
 		        		object.put("value", "N");
 		        		break;
 		        	case 2:
 		        		object.put("value", "F");
 		        		break;
 		        	case 3:
 		        		object.put("value", "D");
 		        		break;
 		        	case 4:
 		        		object.put("value", "N");
 		        		break;
 		        	case 5:
 		        		object.put("value", "F");
 		        	case 6:
 		        		object.put("value", "F");
 		        		break; 		        		
 		        	}
 		        	break;
 		        	case 3: 		       
 		        	switch (q) {
 		        	case 0 :
 		        		object.put("value", "F");
 		        		break;
 		        	case 1:
 		        		object.put("value", "F");
 		        		break;
 		        	case 2:
 		        		object.put("value", "D");
 		        		break;
 		        	case 3:
 		        		object.put("value", "N");
 		        		break;
 		        	case 4:
 		        		object.put("value", "F");
 		        		break;
 		        	case 5:
 		        		object.put("value", "D");
 		        	case 6:
 		        		object.put("value", "N");
 		        		break; 		        		
 		        	}
 		        	break;
 		        	case 4: 		       
 		        	switch (q) {
 		        	case 0 :
 		        		object.put("value", "N");
 		        		break;
 		        	case 1:
 		        		object.put("value", "F");
 		        		break;
 		        	case 2:
 		        		object.put("value", "F");
 		        		break;
 		        	case 3:
 		        		object.put("value", "D");
 		        		break;
 		        	case 4:
 		        		object.put("value", "N");
 		        		break;
 		        	case 5:
 		        		object.put("value", "F");
 		        	case 6:
 		        		object.put("value", "D");
 		        		break; 		        		
 		        	}
 		        	break;
 		        	} 		        	
 		      	break;
 		        case 1: 		      
  			    int x = shift.getNo();
  			    if (weekDays[q]==weekDays[j]&& r!=0) {
  			    	 object.put("value", "F");
  			    }
  			    else if (code.sun != "" || code.sat != ""|| code.fri != ""|| code.thu != ""|| code.wen != ""|| code.tue != ""|| code.mon != "") {
  			    	if (code.sun != "" && q ==0) {
  			    		object.put("value", code.sun);
  			    	}
  			    	if (code.sat != "" && q ==0) {
  			    		object.put("value", code.sun);
  			    	}
  			    	if (code.fri != "" && q ==0) {
  			    		object.put("value", code.sun);
  			    	}
  			    	if (code.thu != "" && q ==0) {
  			    		object.put("value", code.sun);
  			    	}
  			    	if (code.wen != "" && q ==0) {
  			    		object.put("value", code.sun);
  			    	}
  			    	if (code.tue != "" && q ==0) {
  			    		object.put("value", code.sun);
  			    	}
  			    	if (code.mon != "" && q ==0) {
  			    		object.put("value", code.sun);
  			    	}
  			    }
  			    else {
                             if(x==1){
                            	 object.put("value", "D");
  			              }
                              if (x==2){
                            	  object.put("value", "N");
                            }
  			    }
  			    break;
  		       }
             				 c.add(Calendar.DATE,-z);
	             				String str = JSONObject.toJSONString(object, SerializerFeature.DisableCircularReferenceDetect);
	             				JSONObject jsonjson = JSONObject.parseObject(str);
	            	            js.add(jsonjson);	 
                            }
  		}
		session.dispose();
 }
 
 if (code.getId() == 4)
 {

	 List<WorkDate> lstDate = new ArrayList<WorkDate>();
	 char a = 'A';
	 for (int i = 1; i<=code.getDc(); i ++) {
		 lstDate.add(new WorkDate(i));	 
	 }
	 List<Worker> lstWorker = new ArrayList<Worker>() ;

		for (int i=1;i<=code.getCode2();i++) {
			 if (i==1) {
				 a='A';
			 }
			 if (i==2) {
				 a='B';
			 }
			 if (i==3) {
				 a='C';
			 }
			 if (i==4) {
				 a='D';
			 }
			Worker w=new Worker(1,"Mine Captain "+a);
			w.setEasyDay(lstDate.size());
			lstWorker.add(w);
		}
		
		if(code.getCode1()>2) {
			System.out.println("Error:Too Many Shifts");
			throw new RuntimeException("Unable to compile.");
		}
		if(code.getDc()>31) {
			System.out.println("Error:The Schedule is too Long");
			throw new RuntimeException("Unable to compile.");
		}

		KieServices kieServices = KieServices.Factory.get(); 
        KieContainer kieContainer = kieServices.getKieClasspathContainer();
        KieSession session =  kieContainer.newKieSession("RuleMC.drl");
        
        switch (code.code0) {
        case 0 :
        	session.getAgenda().getAgendaGroup("C1").setFocus();
        	session.getAgenda().getAgendaGroup("RC").setFocus();
        	break;
        case 1:
        if (code.getDc()>=0&&code.getDc()<7) {
	        if ((code.code3==1)&&(code.code4==1)) {
	        	session.getAgenda().getAgendaGroup("A01").setFocus();
	        }
	        if ((code.code3==2)&&(code.code4==2)) {
	        	session.getAgenda().getAgendaGroup("A02").setFocus();
	        }
	        if ((code.code3==3)&&(code.code4==3)) {
	        	session.getAgenda().getAgendaGroup("A03").setFocus();
	        }
	        if ((code.code3==4)&&(code.code4==4)) {
	        	session.getAgenda().getAgendaGroup("A04").setFocus();
	        }
	        if ((code.code3==1)&&(code.code4==2)) {
	        	session.getAgenda().getAgendaGroup("A012").setFocus();
	        }
	        if ((code.code3==1)&&(code.code4==3)) {
	        	session.getAgenda().getAgendaGroup("A013").setFocus();
	        }
	        if ((code.code3==1)&&(code.code4==4)) {
	        	session.getAgenda().getAgendaGroup("A014").setFocus();
	        }
	        if ((code.code3==2)&&(code.code4==3)) {
	        	session.getAgenda().getAgendaGroup("A023").setFocus();
	        }
	        if ((code.code3==2)&&(code.code4==4)) {
	        	session.getAgenda().getAgendaGroup("A024").setFocus();
	        }
	        if ((code.code3==3)&&(code.code4==4)) {
	        	session.getAgenda().getAgendaGroup("A034").setFocus();
	        }
	        if ((code.code3==2)&&(code.code4==1)) {
	        	session.getAgenda().getAgendaGroup("A021").setFocus();
	        }
	        if ((code.code3==3)&&(code.code4==1)) {
	        	session.getAgenda().getAgendaGroup("A031").setFocus();
	        }
	        if ((code.code3==3)&&(code.code4==2)) {
	        	session.getAgenda().getAgendaGroup("A032").setFocus();
	        }
	        if ((code.code3==4)&&(code.code4==1)) {
	        	session.getAgenda().getAgendaGroup("A041").setFocus();
	        }
	        if ((code.code3==4)&&(code.code4==2)) {
	        	session.getAgenda().getAgendaGroup("A042").setFocus();
	        }
	        if ((code.code3==4)&&(code.code4==3)) {
	        	session.getAgenda().getAgendaGroup("A043").setFocus();
	        }
        }
        if (code.getDc()>=7&&code.getDc()<14) {
	        if ((code.code3==1)&&(code.code4==1)) {
	        	session.getAgenda().getAgendaGroup("A11").setFocus();
	        }
	        if ((code.code3==2)&&(code.code4==2)) {
	        	session.getAgenda().getAgendaGroup("A12").setFocus();
	        }
	        if ((code.code3==3)&&(code.code4==3)) {
	        	session.getAgenda().getAgendaGroup("A13").setFocus();
	        }
	        if ((code.code3==4)&&(code.code4==4)) {
	        	session.getAgenda().getAgendaGroup("A14").setFocus();
	        }
	        if ((code.code3==1)&&(code.code4==2)) {
	        	session.getAgenda().getAgendaGroup("A112").setFocus();
	        }
	        if ((code.code3==1)&&(code.code4==3)) {
	        	session.getAgenda().getAgendaGroup("A113").setFocus();
	        }
	        if ((code.code3==1)&&(code.code4==4)) {
	        	session.getAgenda().getAgendaGroup("A114").setFocus();
	        }
	        if ((code.code3==2)&&(code.code4==3)) {
	        	session.getAgenda().getAgendaGroup("A123").setFocus();
	        }
	        if ((code.code3==2)&&(code.code4==4)) {
	        	session.getAgenda().getAgendaGroup("A124").setFocus();
	        }
	        if ((code.code3==3)&&(code.code4==4)) {
	        	session.getAgenda().getAgendaGroup("A134").setFocus();
	        }
	        if ((code.code3==2)&&(code.code4==1)) {
	        	session.getAgenda().getAgendaGroup("A121").setFocus();
	        }
	        if ((code.code3==3)&&(code.code4==1)) {
	        	session.getAgenda().getAgendaGroup("A131").setFocus();
	        }
	        if ((code.code3==3)&&(code.code4==2)) {
	        	session.getAgenda().getAgendaGroup("A132").setFocus();
	        }
	        if ((code.code3==4)&&(code.code4==1)) {
	        	session.getAgenda().getAgendaGroup("A141").setFocus();
	        }
	        if ((code.code3==4)&&(code.code4==2)) {
	        	session.getAgenda().getAgendaGroup("A142").setFocus();
	        }
	        if ((code.code3==4)&&(code.code4==3)) {
	        	session.getAgenda().getAgendaGroup("A143").setFocus();
	        }	
        }
        if (code.getDc()>=14&&code.getDc()<21) {
	        if ((code.code3==1)&&(code.code4==1)) {
	        	session.getAgenda().getAgendaGroup("A21").setFocus();
	        }
	        if ((code.code3==2)&&(code.code4==2)) {
	        	session.getAgenda().getAgendaGroup("A22").setFocus();
	        }
	        if ((code.code3==3)&&(code.code4==3)) {
	        	session.getAgenda().getAgendaGroup("A23").setFocus();
	        }
	        if ((code.code3==4)&&(code.code4==4)) {
	        	session.getAgenda().getAgendaGroup("A24").setFocus();
	        }
	        if ((code.code3==1)&&(code.code4==2)) {
	        	session.getAgenda().getAgendaGroup("A212").setFocus();
	        }
	        if ((code.code3==1)&&(code.code4==3)) {
	        	session.getAgenda().getAgendaGroup("A213").setFocus();
	        }
	        if ((code.code3==1)&&(code.code4==4)) {
	        	session.getAgenda().getAgendaGroup("A214").setFocus();
	        }
	        if ((code.code3==2)&&(code.code4==3)) {
	        	session.getAgenda().getAgendaGroup("A223").setFocus();
	        }
	        if ((code.code3==2)&&(code.code4==4)) {
	        	session.getAgenda().getAgendaGroup("A224").setFocus();
	        }
	        if ((code.code3==3)&&(code.code4==4)) {
	        	session.getAgenda().getAgendaGroup("A234").setFocus();
	        }
	        if ((code.code3==2)&&(code.code4==1)) {
	        	session.getAgenda().getAgendaGroup("A221").setFocus();
	        }
	        if ((code.code3==3)&&(code.code4==1)) {
	        	session.getAgenda().getAgendaGroup("A231").setFocus();
	        }
	        if ((code.code3==3)&&(code.code4==2)) {
	        	session.getAgenda().getAgendaGroup("A232").setFocus();
	        }
	        if ((code.code3==4)&&(code.code4==1)) {
	        	session.getAgenda().getAgendaGroup("A241").setFocus();
	        }
	        if ((code.code3==4)&&(code.code4==2)) {
	        	session.getAgenda().getAgendaGroup("A242").setFocus();
	        }
	        if ((code.code3==4)&&(code.code4==3)) {
	        	session.getAgenda().getAgendaGroup("A243").setFocus();
	        }
        }
        if (code.getDc()>=21&&code.getDc()<28) {
	        if ((code.code3==1)&&(code.code4==1)) {
	        	session.getAgenda().getAgendaGroup("A31").setFocus();
	        }
	        if ((code.code3==2)&&(code.code4==2)) {
	        	session.getAgenda().getAgendaGroup("A32").setFocus();
	        }
	        if ((code.code3==3)&&(code.code4==3)) {
	        	session.getAgenda().getAgendaGroup("A33").setFocus();
	        }
	        if ((code.code3==4)&&(code.code4==4)) {
	        	session.getAgenda().getAgendaGroup("A34").setFocus();
	        }
	        if ((code.code3==1)&&(code.code4==2)) {
	        	session.getAgenda().getAgendaGroup("A312").setFocus();
	        }
	        if ((code.code3==1)&&(code.code4==3)) {
	        	session.getAgenda().getAgendaGroup("A313").setFocus();
	        }
	        if ((code.code3==1)&&(code.code4==4)) {
	        	session.getAgenda().getAgendaGroup("A314").setFocus();
	        }
	        if ((code.code3==2)&&(code.code4==3)) {
	        	session.getAgenda().getAgendaGroup("A323").setFocus();
	        }
	        if ((code.code3==2)&&(code.code4==4)) {
	        	session.getAgenda().getAgendaGroup("A324").setFocus();
	        }
	        if ((code.code3==3)&&(code.code4==4)) {
	        	session.getAgenda().getAgendaGroup("A334").setFocus();
	        }
	        if ((code.code3==2)&&(code.code4==1)) {
	        	session.getAgenda().getAgendaGroup("A321").setFocus();
	        }
	        if ((code.code3==3)&&(code.code4==1)) {
	        	session.getAgenda().getAgendaGroup("A331").setFocus();
	        }
	        if ((code.code3==3)&&(code.code4==2)) {
	        	session.getAgenda().getAgendaGroup("A332").setFocus();
	        }
	        if ((code.code3==4)&&(code.code4==1)) {
	        	session.getAgenda().getAgendaGroup("A341").setFocus();
	        }
	        if ((code.code3==4)&&(code.code4==2)) {
	        	session.getAgenda().getAgendaGroup("A342").setFocus();
	        }
	        if ((code.code3==4)&&(code.code4==3)) {
	        	session.getAgenda().getAgendaGroup("A343").setFocus();
	        }
        }
        if (code.getDc()>=28) {
	        if ((code.code3==1)&&(code.code4==1)) {
	        	session.getAgenda().getAgendaGroup("A41").setFocus();
	        }
	        if ((code.code3==2)&&(code.code4==2)) {
	        	session.getAgenda().getAgendaGroup("A42").setFocus();
	        }
	        if ((code.code3==3)&&(code.code4==3)) {
	        	session.getAgenda().getAgendaGroup("A43").setFocus();
	        }
	        if ((code.code3==4)&&(code.code4==4)) {
	        	session.getAgenda().getAgendaGroup("A44").setFocus();
	        }
	        if ((code.code3==1)&&(code.code4==2)) {
	        	session.getAgenda().getAgendaGroup("A412").setFocus();
	        }
	        if ((code.code3==1)&&(code.code4==3)) {
	        	session.getAgenda().getAgendaGroup("A413").setFocus();
	        }
	        if ((code.code3==1)&&(code.code4==4)) {
	        	session.getAgenda().getAgendaGroup("A414").setFocus();
	        }
	        if ((code.code3==2)&&(code.code4==3)) {
	        	session.getAgenda().getAgendaGroup("A423").setFocus();
	        }
	        if ((code.code3==2)&&(code.code4==4)) {
	        	session.getAgenda().getAgendaGroup("A424").setFocus();
	        }
	        if ((code.code3==3)&&(code.code4==4)) {
	        	session.getAgenda().getAgendaGroup("A434").setFocus();
	        }
	        if ((code.code3==2)&&(code.code4==1)) {
	        	session.getAgenda().getAgendaGroup("A421").setFocus();
	        }
	        if ((code.code3==3)&&(code.code4==1)) {
	        	session.getAgenda().getAgendaGroup("A431").setFocus();
	        }
	        if ((code.code3==3)&&(code.code4==2)) {
	        	session.getAgenda().getAgendaGroup("A432").setFocus();
	        }
	        if ((code.code3==4)&&(code.code4==1)) {
	        	session.getAgenda().getAgendaGroup("A441").setFocus();
	        }
	        if ((code.code3==4)&&(code.code4==2)) {
	        	session.getAgenda().getAgendaGroup("A442").setFocus();
	        }
	        if ((code.code3==4)&&(code.code4==3)) {
	        	session.getAgenda().getAgendaGroup("A443").setFocus();
	        }
        }
        session.getAgenda().getAgendaGroup("RW").setFocus();
        break;
        }
        
		for(WorkDate date : lstDate) {
			session.insert(date);
			for (Shift s : date.getShifts()) {
				session.insert(s);
			}
		}
	    
		for (Worker worker : lstWorker) {
			session.insert(worker);
		}		
		System.out.println("Begin Date :");
		System.out.println(Begin_Date);
		session.fireAllRules();	
		System.out.println("Finish Date :");
		System.out.println(Finish_Date);
		System.out.println("\n");
		c.add(Calendar.DATE,-code.getDc());


		int b=code.getId();
        int u=0;
		int j = 0 ;
		if (code.code5== "Sun") {
			j=7;
		} 
		if (code.code5== "Sat") {
			j=6;
		}
		if (code.code5== "Fri") {
			j=5;
		}
		if (code.code5== "Thu") {
			j=4;
		}
		if (code.code5== "Wen") {
			j=3;
		}
		if (code.code5== "Tue") {
			j=2;
		}
		if (code.code5== "Mon") {
			j=1;
		}
        int r=1;
        if (j==0) {
            r=0;
           }
        if (j==7) {
        	j=j-7;
        }
		List<Shift> lstShift = new ArrayList<Shift>();
		for (Worker w : lstWorker) {
			JSONObject object = new JSONObject();	
			object.put("id", b);
			object.put("name", w.getName());
			lstShift.clear();
			lstShift.addAll(w.getShifts());
			Collections.sort(lstShift);
			 u++;
			 if (u> code.code2) {
				 break;
			 }    
             for (Shift shift : lstShift){            	 
            	int z=shift.getWorkDate().getDay();
  				 c.add(Calendar.DATE,+z);
  			    String TIME = dateFormat.format(c.getTime());	
  		        String[] weekDays = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
  		        int q = c.get(Calendar.DAY_OF_WEEK) - 1;
  		        if (q < 0)
  		            q = 0;	 
  				
  				object.put("time", TIME);
   		       switch (code.code0) {  		       
  		        case 0 :		       
  		        	switch (q) {
  		        	case 0 :
  		        		object.put("value", "F");
  		        		break;
  		        	case 1:
  		        		object.put("value", "D");
  		        		break;
  		        	case 2:
  		        		object.put("value", "D");
  		        		break;
  		        	case 3:
  		        		object.put("value", "D");
  		        		break;
  		        	case 4:
  		        		object.put("value", "D");
  		        		break;
  		        	case 5:
  		        		object.put("value", "D");
  		        	case 6:
  		        		object.put("value", "D");
  		        		break; 		        		
  		        	}       	
  		      	break;
  		        case 1: 
  			    int x = shift.getNo();
  			    if (weekDays[q]==weekDays[j]&& r!=0) {
  			    	 object.put("value", "F");
  			    }
  			    else if (code.sun != "" || code.sat != ""|| code.fri != ""|| code.thu != ""|| code.wen != ""|| code.tue != ""|| code.mon != "") {
  			    	if (code.sun != "" && q ==0) {
  			    		object.put("value", code.sun);
  			    	}
  			    	if (code.sat != "" && q ==0) {
  			    		object.put("value", code.sun);
  			    	}
  			    	if (code.fri != "" && q ==0) {
  			    		object.put("value", code.sun);
  			    	}
  			    	if (code.thu != "" && q ==0) {
  			    		object.put("value", code.sun);
  			    	}
  			    	if (code.wen != "" && q ==0) {
  			    		object.put("value", code.sun);
  			    	}
  			    	if (code.tue != "" && q ==0) {
  			    		object.put("value", code.sun);
  			    	}
  			    	if (code.mon != "" && q ==0) {
  			    		object.put("value", code.sun);
  			    	}
  			    }
  			    else {
                             if(x==1){
                            	 object.put("value", "D");
  			              }
                              if (x==2){
                            	  object.put("value", "N");
                            }
  			    }
  			    break;
   		       }
             				 c.add(Calendar.DATE,-z);
        					              				 
	             				String str = JSONObject.toJSONString(object, SerializerFeature.DisableCircularReferenceDetect);
	             				JSONObject jsonjson = JSONObject.parseObject(str);
	            	            js.add(jsonjson);	 
                            }
  		}
		session.dispose();
 }
 
 if (code.getId() == 5)
 {

	 List<WorkDate> lstDate = new ArrayList<WorkDate>();
	 char a = 'A';
	 for (int i = 1; i<=code.getDc(); i ++) {
		 lstDate.add(new WorkDate(i));	 
	 }
	 List<Worker> lstWorker = new ArrayList<Worker>() ;

		for (int i=1;i<=code.getCode2();i++) {
			 if (i==1) {
				 a='A';
			 }
			 if (i==2) {
				 a='B';
			 }
			 if (i==3) {
				 a='C';
			 }
			 if (i==4) {
				 a='D';
			 }
			Worker w=new Worker(1,"Shift Boss "+a);
			w.setEasyDay(lstDate.size());
			lstWorker.add(w);
		}
		
		if(code.getCode1()>2) {
			System.out.println("Error:Too Many Shifts");
			throw new RuntimeException("Unable to compile.");
		}
		if(code.getDc()>31) {
			System.out.println("Error:Unable to compile.");
		}

		KieServices kieServices = KieServices.Factory.get(); 
        KieContainer kieContainer = kieServices.getKieClasspathContainer();
        KieSession session =  kieContainer.newKieSession("RulePlanner.drl");
        
        switch (code.code0) {
        case 0 :
        	session.getAgenda().getAgendaGroup("C1").setFocus();
        	session.getAgenda().getAgendaGroup("RC").setFocus();
        	break;
        case 1:
        if (code.getDc()>=0&&code.getDc()<7) {
	        if ((code.code3==1)&&(code.code4==1)) {
	        	session.getAgenda().getAgendaGroup("A01").setFocus();
	        }
	        if ((code.code3==2)&&(code.code4==2)) {
	        	session.getAgenda().getAgendaGroup("A02").setFocus();
	        }
	        if ((code.code3==3)&&(code.code4==3)) {
	        	session.getAgenda().getAgendaGroup("A03").setFocus();
	        }
	        if ((code.code3==4)&&(code.code4==4)) {
	        	session.getAgenda().getAgendaGroup("A04").setFocus();
	        }
	        if ((code.code3==1)&&(code.code4==2)) {
	        	session.getAgenda().getAgendaGroup("A012").setFocus();
	        }
	        if ((code.code3==1)&&(code.code4==3)) {
	        	session.getAgenda().getAgendaGroup("A013").setFocus();
	        }
	        if ((code.code3==1)&&(code.code4==4)) {
	        	session.getAgenda().getAgendaGroup("A014").setFocus();
	        }
	        if ((code.code3==2)&&(code.code4==3)) {
	        	session.getAgenda().getAgendaGroup("A023").setFocus();
	        }
	        if ((code.code3==2)&&(code.code4==4)) {
	        	session.getAgenda().getAgendaGroup("A024").setFocus();
	        }
	        if ((code.code3==3)&&(code.code4==4)) {
	        	session.getAgenda().getAgendaGroup("A034").setFocus();
	        }
	        if ((code.code3==2)&&(code.code4==1)) {
	        	session.getAgenda().getAgendaGroup("A021").setFocus();
	        }
	        if ((code.code3==3)&&(code.code4==1)) {
	        	session.getAgenda().getAgendaGroup("A031").setFocus();
	        }
	        if ((code.code3==3)&&(code.code4==2)) {
	        	session.getAgenda().getAgendaGroup("A032").setFocus();
	        }
	        if ((code.code3==4)&&(code.code4==1)) {
	        	session.getAgenda().getAgendaGroup("A041").setFocus();
	        }
	        if ((code.code3==4)&&(code.code4==2)) {
	        	session.getAgenda().getAgendaGroup("A042").setFocus();
	        }
	        if ((code.code3==4)&&(code.code4==3)) {
	        	session.getAgenda().getAgendaGroup("A043").setFocus();
	        }
        }
        if (code.getDc()>=7&&code.getDc()<14) {
	        if ((code.code3==1)&&(code.code4==1)) {
	        	session.getAgenda().getAgendaGroup("A11").setFocus();
	        }
	        if ((code.code3==2)&&(code.code4==2)) {
	        	session.getAgenda().getAgendaGroup("A12").setFocus();
	        }
	        if ((code.code3==3)&&(code.code4==3)) {
	        	session.getAgenda().getAgendaGroup("A13").setFocus();
	        }
	        if ((code.code3==4)&&(code.code4==4)) {
	        	session.getAgenda().getAgendaGroup("A14").setFocus();
	        }
	        if ((code.code3==1)&&(code.code4==2)) {
	        	session.getAgenda().getAgendaGroup("A112").setFocus();
	        }
	        if ((code.code3==1)&&(code.code4==3)) {
	        	session.getAgenda().getAgendaGroup("A113").setFocus();
	        }
	        if ((code.code3==1)&&(code.code4==4)) {
	        	session.getAgenda().getAgendaGroup("A114").setFocus();
	        }
	        if ((code.code3==2)&&(code.code4==3)) {
	        	session.getAgenda().getAgendaGroup("A123").setFocus();
	        }
	        if ((code.code3==2)&&(code.code4==4)) {
	        	session.getAgenda().getAgendaGroup("A124").setFocus();
	        }
	        if ((code.code3==3)&&(code.code4==4)) {
	        	session.getAgenda().getAgendaGroup("A134").setFocus();
	        }
	        if ((code.code3==2)&&(code.code4==1)) {
	        	session.getAgenda().getAgendaGroup("A121").setFocus();
	        }
	        if ((code.code3==3)&&(code.code4==1)) {
	        	session.getAgenda().getAgendaGroup("A131").setFocus();
	        }
	        if ((code.code3==3)&&(code.code4==2)) {
	        	session.getAgenda().getAgendaGroup("A132").setFocus();
	        }
	        if ((code.code3==4)&&(code.code4==1)) {
	        	session.getAgenda().getAgendaGroup("A141").setFocus();
	        }
	        if ((code.code3==4)&&(code.code4==2)) {
	        	session.getAgenda().getAgendaGroup("A142").setFocus();
	        }
	        if ((code.code3==4)&&(code.code4==3)) {
	        	session.getAgenda().getAgendaGroup("A143").setFocus();
	        }	
        }
        if (code.getDc()>=14&&code.getDc()<21) {
	        if ((code.code3==1)&&(code.code4==1)) {
	        	session.getAgenda().getAgendaGroup("A21").setFocus();
	        }
	        if ((code.code3==2)&&(code.code4==2)) {
	        	session.getAgenda().getAgendaGroup("A22").setFocus();
	        }
	        if ((code.code3==3)&&(code.code4==3)) {
	        	session.getAgenda().getAgendaGroup("A23").setFocus();
	        }
	        if ((code.code3==4)&&(code.code4==4)) {
	        	session.getAgenda().getAgendaGroup("A24").setFocus();
	        }
	        if ((code.code3==1)&&(code.code4==2)) {
	        	session.getAgenda().getAgendaGroup("A212").setFocus();
	        }
	        if ((code.code3==1)&&(code.code4==3)) {
	        	session.getAgenda().getAgendaGroup("A213").setFocus();
	        }
	        if ((code.code3==1)&&(code.code4==4)) {
	        	session.getAgenda().getAgendaGroup("A214").setFocus();
	        }
	        if ((code.code3==2)&&(code.code4==3)) {
	        	session.getAgenda().getAgendaGroup("A223").setFocus();
	        }
	        if ((code.code3==2)&&(code.code4==4)) {
	        	session.getAgenda().getAgendaGroup("A224").setFocus();
	        }
	        if ((code.code3==3)&&(code.code4==4)) {
	        	session.getAgenda().getAgendaGroup("A234").setFocus();
	        }
	        if ((code.code3==2)&&(code.code4==1)) {
	        	session.getAgenda().getAgendaGroup("A221").setFocus();
	        }
	        if ((code.code3==3)&&(code.code4==1)) {
	        	session.getAgenda().getAgendaGroup("A231").setFocus();
	        }
	        if ((code.code3==3)&&(code.code4==2)) {
	        	session.getAgenda().getAgendaGroup("A232").setFocus();
	        }
	        if ((code.code3==4)&&(code.code4==1)) {
	        	session.getAgenda().getAgendaGroup("A241").setFocus();
	        }
	        if ((code.code3==4)&&(code.code4==2)) {
	        	session.getAgenda().getAgendaGroup("A242").setFocus();
	        }
	        if ((code.code3==4)&&(code.code4==3)) {
	        	session.getAgenda().getAgendaGroup("A243").setFocus();
	        }
        }
        if (code.getDc()>=21&&code.getDc()<28) {
	        if ((code.code3==1)&&(code.code4==1)) {
	        	session.getAgenda().getAgendaGroup("A31").setFocus();
	        }
	        if ((code.code3==2)&&(code.code4==2)) {
	        	session.getAgenda().getAgendaGroup("A32").setFocus();
	        }
	        if ((code.code3==3)&&(code.code4==3)) {
	        	session.getAgenda().getAgendaGroup("A33").setFocus();
	        }
	        if ((code.code3==4)&&(code.code4==4)) {
	        	session.getAgenda().getAgendaGroup("A34").setFocus();
	        }
	        if ((code.code3==1)&&(code.code4==2)) {
	        	session.getAgenda().getAgendaGroup("A312").setFocus();
	        }
	        if ((code.code3==1)&&(code.code4==3)) {
	        	session.getAgenda().getAgendaGroup("A313").setFocus();
	        }
	        if ((code.code3==1)&&(code.code4==4)) {
	        	session.getAgenda().getAgendaGroup("A314").setFocus();
	        }
	        if ((code.code3==2)&&(code.code4==3)) {
	        	session.getAgenda().getAgendaGroup("A323").setFocus();
	        }
	        if ((code.code3==2)&&(code.code4==4)) {
	        	session.getAgenda().getAgendaGroup("A324").setFocus();
	        }
	        if ((code.code3==3)&&(code.code4==4)) {
	        	session.getAgenda().getAgendaGroup("A334").setFocus();
	        }
	        if ((code.code3==2)&&(code.code4==1)) {
	        	session.getAgenda().getAgendaGroup("A321").setFocus();
	        }
	        if ((code.code3==3)&&(code.code4==1)) {
	        	session.getAgenda().getAgendaGroup("A331").setFocus();
	        }
	        if ((code.code3==3)&&(code.code4==2)) {
	        	session.getAgenda().getAgendaGroup("A332").setFocus();
	        }
	        if ((code.code3==4)&&(code.code4==1)) {
	        	session.getAgenda().getAgendaGroup("A341").setFocus();
	        }
	        if ((code.code3==4)&&(code.code4==2)) {
	        	session.getAgenda().getAgendaGroup("A342").setFocus();
	        }
	        if ((code.code3==4)&&(code.code4==3)) {
	        	session.getAgenda().getAgendaGroup("A343").setFocus();
	        }
        }
        if (code.getDc()>=28) {
	        if ((code.code3==1)&&(code.code4==1)) {
	        	session.getAgenda().getAgendaGroup("A41").setFocus();
	        }
	        if ((code.code3==2)&&(code.code4==2)) {
	        	session.getAgenda().getAgendaGroup("A42").setFocus();
	        }
	        if ((code.code3==3)&&(code.code4==3)) {
	        	session.getAgenda().getAgendaGroup("A43").setFocus();
	        }
	        if ((code.code3==4)&&(code.code4==4)) {
	        	session.getAgenda().getAgendaGroup("A44").setFocus();
	        }
	        if ((code.code3==1)&&(code.code4==2)) {
	        	session.getAgenda().getAgendaGroup("A412").setFocus();
	        }
	        if ((code.code3==1)&&(code.code4==3)) {
	        	session.getAgenda().getAgendaGroup("A413").setFocus();
	        }
	        if ((code.code3==1)&&(code.code4==4)) {
	        	session.getAgenda().getAgendaGroup("A414").setFocus();
	        }
	        if ((code.code3==2)&&(code.code4==3)) {
	        	session.getAgenda().getAgendaGroup("A423").setFocus();
	        }
	        if ((code.code3==2)&&(code.code4==4)) {
	        	session.getAgenda().getAgendaGroup("A424").setFocus();
	        }
	        if ((code.code3==3)&&(code.code4==4)) {
	        	session.getAgenda().getAgendaGroup("A434").setFocus();
	        }
	        if ((code.code3==2)&&(code.code4==1)) {
	        	session.getAgenda().getAgendaGroup("A421").setFocus();
	        }
	        if ((code.code3==3)&&(code.code4==1)) {
	        	session.getAgenda().getAgendaGroup("A431").setFocus();
	        }
	        if ((code.code3==3)&&(code.code4==2)) {
	        	session.getAgenda().getAgendaGroup("A432").setFocus();
	        }
	        if ((code.code3==4)&&(code.code4==1)) {
	        	session.getAgenda().getAgendaGroup("A441").setFocus();
	        }
	        if ((code.code3==4)&&(code.code4==2)) {
	        	session.getAgenda().getAgendaGroup("A442").setFocus();
	        }
	        if ((code.code3==4)&&(code.code4==3)) {
	        	session.getAgenda().getAgendaGroup("A443").setFocus();
	        }
        }
        session.getAgenda().getAgendaGroup("RW").setFocus();
        break;
        }
		
		for(WorkDate date : lstDate) {
			session.insert(date);
			for (Shift s : date.getShifts()) {
				session.insert(s);
			}
		}
	    
		for (Worker worker : lstWorker) {
			session.insert(worker);
		}		
		System.out.println("Begin Date :");
		System.out.println(Begin_Date);
		session.fireAllRules();	
		System.out.println("Finish Date :");
		System.out.println(Finish_Date);
		System.out.println("\n");
		c.add(Calendar.DATE,-code.getDc());


		int b=code.getId();
        int r=1;
		int j= 0;
		if (code.code5== "Sun") {
			j=7;
		} 
		if (code.code5== "Sat") {
			j=6;
		}
		if (code.code5== "Fri") {
			j=5;
		}
		if (code.code5== "Thu") {
			j=4;
		}
		if (code.code5== "Wen") {
			j=3;
		}
		if (code.code5== "Tue") {
			j=2;
		}
		if (code.code5== "Mon") {
			j=1;
		}
        if (j==0) {
         r=0;
        }
        if (j==7)
        {
        	j=j-7;
        }
        int u = 0;
		List<Shift> lstShift = new ArrayList<Shift>();
		for (Worker w : lstWorker) {
			JSONObject object = new JSONObject();	
			object.put("id", b);
			object.put("name", w.getName());
			lstShift.clear();
			lstShift.addAll(w.getShifts());
			Collections.sort(lstShift);
			u++;
			if (u>code.code2) {
				break;
			}
             for (Shift shift : lstShift){            	 
            	int z=shift.getWorkDate().getDay();
  				 c.add(Calendar.DATE,+z);
  			    String TIME = dateFormat.format(c.getTime());	
  		        String[] weekDays = {"SUN","MON", "TUE", "WED", "THU", "FRI", "SAT"};
  		        int q = c.get(Calendar.DAY_OF_WEEK)-1;
  		        if (q < 0) {
  		            q = 0;	 
  		        }
  				object.put("time", TIME);
   		       switch (code.code0) {  		       
 		        case 0 :		       
 		        	switch (q) {
 		        	case 0 :
 		        		object.put("value", "F");
 		        		break;
 		        	case 1:
 		        		object.put("value", "D");
 		        		break;
 		        	case 2:
 		        		object.put("value", "D");
 		        		break;
 		        	case 3:
 		        		object.put("value", "D");
 		        		break;
 		        	case 4:
 		        		object.put("value", "D");
 		        		break;
 		        	case 5:
 		        		object.put("value", "D");
 		        	case 6:
 		        		object.put("value", "D");
 		        		break; 		        		
 		        	}       	
 		      	break;
 		        case 1: 
  			    int x = shift.getNo();  			    
  			    if (weekDays[q]==weekDays[j]&& r!=0) {
  			    	 object.put("value", "F");
  			    }
  			    else if (code.sun != "" || code.sat != ""|| code.fri != ""|| code.thu != ""|| code.wen != ""|| code.tue != ""|| code.mon != "") {
  			    	if (code.sun != "" && q ==0) {
  			    		object.put("value", code.sun);
  			    	}
  			    	if (code.sat != "" && q ==0) {
  			    		object.put("value", code.sun);
  			    	}
  			    	if (code.fri != "" && q ==0) {
  			    		object.put("value", code.sun);
  			    	}
  			    	if (code.thu != "" && q ==0) {
  			    		object.put("value", code.sun);
  			    	}
  			    	if (code.wen != "" && q ==0) {
  			    		object.put("value", code.sun);
  			    	}
  			    	if (code.tue != "" && q ==0) {
  			    		object.put("value", code.sun);
  			    	}
  			    	if (code.mon != "" && q ==0) {
  			    		object.put("value", code.sun);
  			    	}
  			    }
  			    else {
                             if(x==1){
                            	 object.put("value", "D");
  			              }
                              if (x==2){
                            	  object.put("value", "N");
                            }
  			    }
  			    break;
   		       }
             				 c.add(Calendar.DATE,-z);
	             				String str = JSONObject.toJSONString(object, SerializerFeature.DisableCircularReferenceDetect);
	             				JSONObject jsonjson = JSONObject.parseObject(str);
	            	            js.add(jsonjson);	 
                            }


  		}
		session.dispose();
 }
 
 if (code.getId() == 6)
 {

	 List<WorkDate> lstDate = new ArrayList<WorkDate>();
	 
	 for (int i = 1; i<=code.getDc(); i ++) {
		 lstDate.add(new WorkDate(i));	 
	 }
	 char a='A';
	 List<Worker> lstWorker = new ArrayList<Worker>() ;

		for (int i=1;i<=code.getCode2();i++) {
			 if (i==1) {
				 a='A';
			 }
			 if (i==2) {
				 a='B';
			 }
			 if (i==3) {
				 a='C';
			 }
			 if (i==4) {
				 a='D';
			 }
			Worker w=new Worker(1,"Production Group "+a);
			w.setEasyDay(lstDate.size());
			lstWorker.add(w);
		}
		
		if(code.getCode1()>2) {
			System.out.println("Error:Too Many Shifts");
			throw new RuntimeException("Unable to compile.");
		}
		if(code.getDc()>31) {
			System.out.println("Error:The Schedule is too Long");
			throw new RuntimeException("Unable to compile.");
		}

		KieServices kieServices = KieServices.Factory.get(); 
        KieContainer kieContainer = kieServices.getKieClasspathContainer();
        KieSession session =  kieContainer.newKieSession("RuleProduction.drl");
        
        switch (code.code0) {
        case 0 :
        	session.getAgenda().getAgendaGroup("C1").setFocus();
        	session.getAgenda().getAgendaGroup("RC").setFocus();
        	break;
        case 1:
        if (code.getDc()>=0&&code.getDc()<7) {
	        if ((code.code3==1)&&(code.code4==1)) {
	        	session.getAgenda().getAgendaGroup("A01").setFocus();
	        }
	        if ((code.code3==2)&&(code.code4==2)) {
	        	session.getAgenda().getAgendaGroup("A02").setFocus();
	        }
	        if ((code.code3==3)&&(code.code4==3)) {
	        	session.getAgenda().getAgendaGroup("A03").setFocus();
	        }
	        if ((code.code3==4)&&(code.code4==4)) {
	        	session.getAgenda().getAgendaGroup("A04").setFocus();
	        }
	        if ((code.code3==1)&&(code.code4==2)) {
	        	session.getAgenda().getAgendaGroup("A012").setFocus();
	        }
	        if ((code.code3==1)&&(code.code4==3)) {
	        	session.getAgenda().getAgendaGroup("A013").setFocus();
	        }
	        if ((code.code3==1)&&(code.code4==4)) {
	        	session.getAgenda().getAgendaGroup("A014").setFocus();
	        }
	        if ((code.code3==2)&&(code.code4==3)) {
	        	session.getAgenda().getAgendaGroup("A023").setFocus();
	        }
	        if ((code.code3==2)&&(code.code4==4)) {
	        	session.getAgenda().getAgendaGroup("A024").setFocus();
	        }
	        if ((code.code3==3)&&(code.code4==4)) {
	        	session.getAgenda().getAgendaGroup("A034").setFocus();
	        }
	        if ((code.code3==2)&&(code.code4==1)) {
	        	session.getAgenda().getAgendaGroup("A021").setFocus();
	        }
	        if ((code.code3==3)&&(code.code4==1)) {
	        	session.getAgenda().getAgendaGroup("A031").setFocus();
	        }
	        if ((code.code3==3)&&(code.code4==2)) {
	        	session.getAgenda().getAgendaGroup("A032").setFocus();
	        }
	        if ((code.code3==4)&&(code.code4==1)) {
	        	session.getAgenda().getAgendaGroup("A041").setFocus();
	        }
	        if ((code.code3==4)&&(code.code4==2)) {
	        	session.getAgenda().getAgendaGroup("A042").setFocus();
	        }
	        if ((code.code3==4)&&(code.code4==3)) {
	        	session.getAgenda().getAgendaGroup("A043").setFocus();
	        }
        }
        if (code.getDc()>=7&&code.getDc()<14) {
	        if ((code.code3==1)&&(code.code4==1)) {
	        	session.getAgenda().getAgendaGroup("A11").setFocus();
	        }
	        if ((code.code3==2)&&(code.code4==2)) {
	        	session.getAgenda().getAgendaGroup("A12").setFocus();
	        }
	        if ((code.code3==3)&&(code.code4==3)) {
	        	session.getAgenda().getAgendaGroup("A13").setFocus();
	        }
	        if ((code.code3==4)&&(code.code4==4)) {
	        	session.getAgenda().getAgendaGroup("A14").setFocus();
	        }
	        if ((code.code3==1)&&(code.code4==2)) {
	        	session.getAgenda().getAgendaGroup("A112").setFocus();
	        }
	        if ((code.code3==1)&&(code.code4==3)) {
	        	session.getAgenda().getAgendaGroup("A113").setFocus();
	        }
	        if ((code.code3==1)&&(code.code4==4)) {
	        	session.getAgenda().getAgendaGroup("A114").setFocus();
	        }
	        if ((code.code3==2)&&(code.code4==3)) {
	        	session.getAgenda().getAgendaGroup("A123").setFocus();
	        }
	        if ((code.code3==2)&&(code.code4==4)) {
	        	session.getAgenda().getAgendaGroup("A124").setFocus();
	        }
	        if ((code.code3==3)&&(code.code4==4)) {
	        	session.getAgenda().getAgendaGroup("A134").setFocus();
	        }
	        if ((code.code3==2)&&(code.code4==1)) {
	        	session.getAgenda().getAgendaGroup("A121").setFocus();
	        }
	        if ((code.code3==3)&&(code.code4==1)) {
	        	session.getAgenda().getAgendaGroup("A131").setFocus();
	        }
	        if ((code.code3==3)&&(code.code4==2)) {
	        	session.getAgenda().getAgendaGroup("A132").setFocus();
	        }
	        if ((code.code3==4)&&(code.code4==1)) {
	        	session.getAgenda().getAgendaGroup("A141").setFocus();
	        }
	        if ((code.code3==4)&&(code.code4==2)) {
	        	session.getAgenda().getAgendaGroup("A142").setFocus();
	        }
	        if ((code.code3==4)&&(code.code4==3)) {
	        	session.getAgenda().getAgendaGroup("A143").setFocus();
	        }	
        }
        if (code.getDc()>=14&&code.getDc()<21) {
	        if ((code.code3==1)&&(code.code4==1)) {
	        	session.getAgenda().getAgendaGroup("A21").setFocus();
	        }
	        if ((code.code3==2)&&(code.code4==2)) {
	        	session.getAgenda().getAgendaGroup("A22").setFocus();
	        }
	        if ((code.code3==3)&&(code.code4==3)) {
	        	session.getAgenda().getAgendaGroup("A23").setFocus();
	        }
	        if ((code.code3==4)&&(code.code4==4)) {
	        	session.getAgenda().getAgendaGroup("A24").setFocus();
	        }
	        if ((code.code3==1)&&(code.code4==2)) {
	        	session.getAgenda().getAgendaGroup("A212").setFocus();
	        }
	        if ((code.code3==1)&&(code.code4==3)) {
	        	session.getAgenda().getAgendaGroup("A213").setFocus();
	        }
	        if ((code.code3==1)&&(code.code4==4)) {
	        	session.getAgenda().getAgendaGroup("A214").setFocus();
	        }
	        if ((code.code3==2)&&(code.code4==3)) {
	        	session.getAgenda().getAgendaGroup("A223").setFocus();
	        }
	        if ((code.code3==2)&&(code.code4==4)) {
	        	session.getAgenda().getAgendaGroup("A224").setFocus();
	        }
	        if ((code.code3==3)&&(code.code4==4)) {
	        	session.getAgenda().getAgendaGroup("A234").setFocus();
	        }
	        if ((code.code3==2)&&(code.code4==1)) {
	        	session.getAgenda().getAgendaGroup("A221").setFocus();
	        }
	        if ((code.code3==3)&&(code.code4==1)) {
	        	session.getAgenda().getAgendaGroup("A231").setFocus();
	        }
	        if ((code.code3==3)&&(code.code4==2)) {
	        	session.getAgenda().getAgendaGroup("A232").setFocus();
	        }
	        if ((code.code3==4)&&(code.code4==1)) {
	        	session.getAgenda().getAgendaGroup("A241").setFocus();
	        }
	        if ((code.code3==4)&&(code.code4==2)) {
	        	session.getAgenda().getAgendaGroup("A242").setFocus();
	        }
	        if ((code.code3==4)&&(code.code4==3)) {
	        	session.getAgenda().getAgendaGroup("A243").setFocus();
	        }
        }
        if (code.getDc()>=21&&code.getDc()<28) {
	        if ((code.code3==1)&&(code.code4==1)) {
	        	session.getAgenda().getAgendaGroup("A31").setFocus();
	        }
	        if ((code.code3==2)&&(code.code4==2)) {
	        	session.getAgenda().getAgendaGroup("A32").setFocus();
	        }
	        if ((code.code3==3)&&(code.code4==3)) {
	        	session.getAgenda().getAgendaGroup("A33").setFocus();
	        }
	        if ((code.code3==4)&&(code.code4==4)) {
	        	session.getAgenda().getAgendaGroup("A34").setFocus();
	        }
	        if ((code.code3==1)&&(code.code4==2)) {
	        	session.getAgenda().getAgendaGroup("A312").setFocus();
	        }
	        if ((code.code3==1)&&(code.code4==3)) {
	        	session.getAgenda().getAgendaGroup("A313").setFocus();
	        }
	        if ((code.code3==1)&&(code.code4==4)) {
	        	session.getAgenda().getAgendaGroup("A314").setFocus();
	        }
	        if ((code.code3==2)&&(code.code4==3)) {
	        	session.getAgenda().getAgendaGroup("A323").setFocus();
	        }
	        if ((code.code3==2)&&(code.code4==4)) {
	        	session.getAgenda().getAgendaGroup("A324").setFocus();
	        }
	        if ((code.code3==3)&&(code.code4==4)) {
	        	session.getAgenda().getAgendaGroup("A334").setFocus();
	        }
	        if ((code.code3==2)&&(code.code4==1)) {
	        	session.getAgenda().getAgendaGroup("A321").setFocus();
	        }
	        if ((code.code3==3)&&(code.code4==1)) {
	        	session.getAgenda().getAgendaGroup("A331").setFocus();
	        }
	        if ((code.code3==3)&&(code.code4==2)) {
	        	session.getAgenda().getAgendaGroup("A332").setFocus();
	        }
	        if ((code.code3==4)&&(code.code4==1)) {
	        	session.getAgenda().getAgendaGroup("A341").setFocus();
	        }
	        if ((code.code3==4)&&(code.code4==2)) {
	        	session.getAgenda().getAgendaGroup("A342").setFocus();
	        }
	        if ((code.code3==4)&&(code.code4==3)) {
	        	session.getAgenda().getAgendaGroup("A343").setFocus();
	        }
        }
        if (code.getDc()>=28) {
	        if ((code.code3==1)&&(code.code4==1)) {
	        	session.getAgenda().getAgendaGroup("A41").setFocus();
	        }
	        if ((code.code3==2)&&(code.code4==2)) {
	        	session.getAgenda().getAgendaGroup("A42").setFocus();
	        }
	        if ((code.code3==3)&&(code.code4==3)) {
	        	session.getAgenda().getAgendaGroup("A43").setFocus();
	        }
	        if ((code.code3==4)&&(code.code4==4)) {
	        	session.getAgenda().getAgendaGroup("A44").setFocus();
	        }
	        if ((code.code3==1)&&(code.code4==2)) {
	        	session.getAgenda().getAgendaGroup("A412").setFocus();
	        }
	        if ((code.code3==1)&&(code.code4==3)) {
	        	session.getAgenda().getAgendaGroup("A413").setFocus();
	        }
	        if ((code.code3==1)&&(code.code4==4)) {
	        	session.getAgenda().getAgendaGroup("A414").setFocus();
	        }
	        if ((code.code3==2)&&(code.code4==3)) {
	        	session.getAgenda().getAgendaGroup("A423").setFocus();
	        }
	        if ((code.code3==2)&&(code.code4==4)) {
	        	session.getAgenda().getAgendaGroup("A424").setFocus();
	        }
	        if ((code.code3==3)&&(code.code4==4)) {
	        	session.getAgenda().getAgendaGroup("A434").setFocus();
	        }
	        if ((code.code3==2)&&(code.code4==1)) {
	        	session.getAgenda().getAgendaGroup("A421").setFocus();
	        }
	        if ((code.code3==3)&&(code.code4==1)) {
	        	session.getAgenda().getAgendaGroup("A431").setFocus();
	        }
	        if ((code.code3==3)&&(code.code4==2)) {
	        	session.getAgenda().getAgendaGroup("A432").setFocus();
	        }
	        if ((code.code3==4)&&(code.code4==1)) {
	        	session.getAgenda().getAgendaGroup("A441").setFocus();
	        }
	        if ((code.code3==4)&&(code.code4==2)) {
	        	session.getAgenda().getAgendaGroup("A442").setFocus();
	        }
	        if ((code.code3==4)&&(code.code4==3)) {
	        	session.getAgenda().getAgendaGroup("A443").setFocus();
	        }
        }
        session.getAgenda().getAgendaGroup("RW").setFocus();
        break;
        }
		

        
		for(WorkDate date : lstDate) {
			session.insert(date);
			for (Shift s : date.getShifts()) {
				session.insert(s);
			}
		}
	    
		for (Worker worker : lstWorker) {
			session.insert(worker);
		}		
		System.out.println("Begin Date :");
		System.out.println(Begin_Date);
		session.fireAllRules();	
		System.out.println("Finish Date :");
		System.out.println(Finish_Date);
		System.out.println("\n");
		c.add(Calendar.DATE,-code.getDc());


		int b=code.getId();
        int u = 0;
		int j = 0;
		if (code.code5== "Sun") {
			j=7;
		} 
		if (code.code5== "Sat") {
			j=6;
		}
		if (code.code5== "Fri") {
			j=5;
		}
		if (code.code5== "Thu") {
			j=4;
		}
		if (code.code5== "Wen") {
			j=3;
		}
		if (code.code5== "Tue") {
			j=2;
		}
		if (code.code5== "Mon") {
			j=1;
		}
        int r=1;
        if (j==0) {
            r=0;
           }
        if (j==7)
        {
        	j=j-7;
        }
		List<Shift> lstShift = new ArrayList<Shift>();
		for (Worker w : lstWorker) {
			JSONObject object = new JSONObject();	
			object.put("id", b);
			object.put("name", w.getName());
			lstShift.clear();
			lstShift.addAll(w.getShifts());
			Collections.sort(lstShift);
			u++;
			if (u>code.code2) {
				break;
			}
             for (Shift shift : lstShift){            	 
            	int z=shift.getWorkDate().getDay();
  				 c.add(Calendar.DATE,+z);
  			    String TIME = dateFormat.format(c.getTime());	
  		        String[] weekDays = {"SUN", "MON", "TUE", "WED", "THU", "FRI","SAT"};
  		        int q = c.get(Calendar.DAY_OF_WEEK) - 1;
  		        if (q < 0)
  		            q = 0;	 

  				object.put("time", TIME);
   		       switch (code.code0) {  		       
  		        case 0 :
  		        	switch (u) {
  		        	case 1: 		       
  		        	switch (q) {
  		        	case 0 :
  		        		object.put("value", "F");
  		        		break;
  		        	case 1:
  		        		object.put("value", "D");
  		        		break;
  		        	case 2:
  		        		object.put("value", "N");
  		        		break;
  		        	case 3:
  		        		object.put("value", "F");
  		        		break;
  		        	case 4:
  		        		object.put("value", "D");
  		        		break;
  		        	case 5:
  		        		object.put("value", "N");
  		        	case 6:
  		        		object.put("value", "F");
  		        		break; 		        		
  		        	}
  		        	break;
  		        	case 2: 		       
  		        	switch (q) {
  		        	case 0 :
  		        		object.put("value", "D");
  		        		break;
  		        	case 1:
  		        		object.put("value", "N");
  		        		break;
  		        	case 2:
  		        		object.put("value", "F");
  		        		break;
  		        	case 3:
  		        		object.put("value", "D");
  		        		break;
  		        	case 4:
  		        		object.put("value", "N");
  		        		break;
  		        	case 5:
  		        		object.put("value", "F");
  		        	case 6:
  		        		object.put("value", "F");
  		        		break; 		        		
  		        	}
  		        	break;
  		        	case 3: 		       
  		        	switch (q) {
  		        	case 0 :
  		        		object.put("value", "F");
  		        		break;
  		        	case 1:
  		        		object.put("value", "F");
  		        		break;
  		        	case 2:
  		        		object.put("value", "D");
  		        		break;
  		        	case 3:
  		        		object.put("value", "N");
  		        		break;
  		        	case 4:
  		        		object.put("value", "F");
  		        		break;
  		        	case 5:
  		        		object.put("value", "D");
  		        	case 6:
  		        		object.put("value", "N");
  		        		break; 		        		
  		        	}
  		        	break;
  		        	case 4: 		       
  		        	switch (q) {
  		        	case 0 :
  		        		object.put("value", "N");
  		        		break;
  		        	case 1:
  		        		object.put("value", "F");
  		        		break;
  		        	case 2:
  		        		object.put("value", "F");
  		        		break;
  		        	case 3:
  		        		object.put("value", "D");
  		        		break;
  		        	case 4:
  		        		object.put("value", "N");
  		        		break;
  		        	case 5:
  		        		object.put("value", "F");
  		        	case 6:
  		        		object.put("value", "D");
  		        		break; 		        		
  		        	}
  		        	break;
  		        	} 		        	
  		      	break;
  		        case 1: 
  			    int x = shift.getNo();
  			    if (weekDays[q]==weekDays[j]&& r!=0) {
  			    	 object.put("value", "F");
  			    }
  			    else if (code.sun != "" || code.sat != ""|| code.fri != ""|| code.thu != ""|| code.wen != ""|| code.tue != ""|| code.mon != "") {
  			    	if (code.sun != "" && q ==0) {
  			    		object.put("value", code.sun);
  			    	}
  			    	if (code.sat != "" && q ==0) {
  			    		object.put("value", code.sun);
  			    	}
  			    	if (code.fri != "" && q ==0) {
  			    		object.put("value", code.sun);
  			    	}
  			    	if (code.thu != "" && q ==0) {
  			    		object.put("value", code.sun);
  			    	}
  			    	if (code.wen != "" && q ==0) {
  			    		object.put("value", code.sun);
  			    	}
  			    	if (code.tue != "" && q ==0) {
  			    		object.put("value", code.sun);
  			    	}
  			    	if (code.mon != "" && q ==0) {
  			    		object.put("value", code.sun);
  			    	}
  			    }
  			    else {
                             if(x==1){
                            	 object.put("value", "D");
  			              }
                              if (x==2){
                            	  object.put("value", "N");
                            }
  			    }
  			    break;
   		       }
             				 c.add(Calendar.DATE,-z);
	             				String str = JSONObject.toJSONString(object, SerializerFeature.DisableCircularReferenceDetect);
	             				JSONObject jsonjson = JSONObject.parseObject(str);
	            	            js.add(jsonjson);	 
                            }


  		}
		session.dispose();	
 }
 
 if (code.getId() == 7)
 {

	 List<WorkDate> lstDate = new ArrayList<WorkDate>();
	 
	 for (int i = 1; i<=code.getDc(); i ++) {
		 lstDate.add(new WorkDate(i));	 
	 }
	 char a='A';
	 List<Worker> lstWorker = new ArrayList<Worker>() ;

		for (int i=1;i<=code.getCode2();i++) {
			 if (i==1) {
				 a='A';
			 }
			 if (i==2) {
				 a='B';
			 }
			 if (i==3) {
				 a='C';
			 }
			 if (i==4) {
				 a='D';
			 }
			Worker w=new Worker(1,"Service Team "+a);
			w.setEasyDay(lstDate.size());
			lstWorker.add(w);
		}
		
		if(code.getCode1()>2) {
			System.out.println("Error:Too Many Shifts");
			throw new RuntimeException("Unable to compile.");
		}
		if(code.getDc()>31) {
			System.out.println("Error:The Schedule is too Long");
			throw new RuntimeException("Unable to compile.");
		}

		KieServices kieServices = KieServices.Factory.get(); 
        KieContainer kieContainer = kieServices.getKieClasspathContainer();
        KieSession session =  kieContainer.newKieSession("RuleService.drl");
        
        switch (code.code0) {
        case 0 :
        	session.getAgenda().getAgendaGroup("C1").setFocus();
        	session.getAgenda().getAgendaGroup("RC").setFocus();
        	break;
        case 1:
        if (code.getDc()>=0&&code.getDc()<7) {
	        if ((code.code3==1)&&(code.code4==1)) {
	        	session.getAgenda().getAgendaGroup("A01").setFocus();
	        }
	        if ((code.code3==2)&&(code.code4==2)) {
	        	session.getAgenda().getAgendaGroup("A02").setFocus();
	        }
	        if ((code.code3==3)&&(code.code4==3)) {
	        	session.getAgenda().getAgendaGroup("A03").setFocus();
	        }
	        if ((code.code3==4)&&(code.code4==4)) {
	        	session.getAgenda().getAgendaGroup("A04").setFocus();
	        }
	        if ((code.code3==1)&&(code.code4==2)) {
	        	session.getAgenda().getAgendaGroup("A012").setFocus();
	        }
	        if ((code.code3==1)&&(code.code4==3)) {
	        	session.getAgenda().getAgendaGroup("A013").setFocus();
	        }
	        if ((code.code3==1)&&(code.code4==4)) {
	        	session.getAgenda().getAgendaGroup("A014").setFocus();
	        }
	        if ((code.code3==2)&&(code.code4==3)) {
	        	session.getAgenda().getAgendaGroup("A023").setFocus();
	        }
	        if ((code.code3==2)&&(code.code4==4)) {
	        	session.getAgenda().getAgendaGroup("A024").setFocus();
	        }
	        if ((code.code3==3)&&(code.code4==4)) {
	        	session.getAgenda().getAgendaGroup("A034").setFocus();
	        }
	        if ((code.code3==2)&&(code.code4==1)) {
	        	session.getAgenda().getAgendaGroup("A021").setFocus();
	        }
	        if ((code.code3==3)&&(code.code4==1)) {
	        	session.getAgenda().getAgendaGroup("A031").setFocus();
	        }
	        if ((code.code3==3)&&(code.code4==2)) {
	        	session.getAgenda().getAgendaGroup("A032").setFocus();
	        }
	        if ((code.code3==4)&&(code.code4==1)) {
	        	session.getAgenda().getAgendaGroup("A041").setFocus();
	        }
	        if ((code.code3==4)&&(code.code4==2)) {
	        	session.getAgenda().getAgendaGroup("A042").setFocus();
	        }
	        if ((code.code3==4)&&(code.code4==3)) {
	        	session.getAgenda().getAgendaGroup("A043").setFocus();
	        }
        }
        if (code.getDc()>=7&&code.getDc()<14) {
	        if ((code.code3==1)&&(code.code4==1)) {
	        	session.getAgenda().getAgendaGroup("A11").setFocus();
	        }
	        if ((code.code3==2)&&(code.code4==2)) {
	        	session.getAgenda().getAgendaGroup("A12").setFocus();
	        }
	        if ((code.code3==3)&&(code.code4==3)) {
	        	session.getAgenda().getAgendaGroup("A13").setFocus();
	        }
	        if ((code.code3==4)&&(code.code4==4)) {
	        	session.getAgenda().getAgendaGroup("A14").setFocus();
	        }
	        if ((code.code3==1)&&(code.code4==2)) {
	        	session.getAgenda().getAgendaGroup("A112").setFocus();
	        }
	        if ((code.code3==1)&&(code.code4==3)) {
	        	session.getAgenda().getAgendaGroup("A113").setFocus();
	        }
	        if ((code.code3==1)&&(code.code4==4)) {
	        	session.getAgenda().getAgendaGroup("A114").setFocus();
	        }
	        if ((code.code3==2)&&(code.code4==3)) {
	        	session.getAgenda().getAgendaGroup("A123").setFocus();
	        }
	        if ((code.code3==2)&&(code.code4==4)) {
	        	session.getAgenda().getAgendaGroup("A124").setFocus();
	        }
	        if ((code.code3==3)&&(code.code4==4)) {
	        	session.getAgenda().getAgendaGroup("A134").setFocus();
	        }
	        if ((code.code3==2)&&(code.code4==1)) {
	        	session.getAgenda().getAgendaGroup("A121").setFocus();
	        }
	        if ((code.code3==3)&&(code.code4==1)) {
	        	session.getAgenda().getAgendaGroup("A131").setFocus();
	        }
	        if ((code.code3==3)&&(code.code4==2)) {
	        	session.getAgenda().getAgendaGroup("A132").setFocus();
	        }
	        if ((code.code3==4)&&(code.code4==1)) {
	        	session.getAgenda().getAgendaGroup("A141").setFocus();
	        }
	        if ((code.code3==4)&&(code.code4==2)) {
	        	session.getAgenda().getAgendaGroup("A142").setFocus();
	        }
	        if ((code.code3==4)&&(code.code4==3)) {
	        	session.getAgenda().getAgendaGroup("A143").setFocus();
	        }	
        }
        if (code.getDc()>=14&&code.getDc()<21) {
	        if ((code.code3==1)&&(code.code4==1)) {
	        	session.getAgenda().getAgendaGroup("A21").setFocus();
	        }
	        if ((code.code3==2)&&(code.code4==2)) {
	        	session.getAgenda().getAgendaGroup("A22").setFocus();
	        }
	        if ((code.code3==3)&&(code.code4==3)) {
	        	session.getAgenda().getAgendaGroup("A23").setFocus();
	        }
	        if ((code.code3==4)&&(code.code4==4)) {
	        	session.getAgenda().getAgendaGroup("A24").setFocus();
	        }
	        if ((code.code3==1)&&(code.code4==2)) {
	        	session.getAgenda().getAgendaGroup("A212").setFocus();
	        }
	        if ((code.code3==1)&&(code.code4==3)) {
	        	session.getAgenda().getAgendaGroup("A213").setFocus();
	        }
	        if ((code.code3==1)&&(code.code4==4)) {
	        	session.getAgenda().getAgendaGroup("A214").setFocus();
	        }
	        if ((code.code3==2)&&(code.code4==3)) {
	        	session.getAgenda().getAgendaGroup("A223").setFocus();
	        }
	        if ((code.code3==2)&&(code.code4==4)) {
	        	session.getAgenda().getAgendaGroup("A224").setFocus();
	        }
	        if ((code.code3==3)&&(code.code4==4)) {
	        	session.getAgenda().getAgendaGroup("A234").setFocus();
	        }
	        if ((code.code3==2)&&(code.code4==1)) {
	        	session.getAgenda().getAgendaGroup("A221").setFocus();
	        }
	        if ((code.code3==3)&&(code.code4==1)) {
	        	session.getAgenda().getAgendaGroup("A231").setFocus();
	        }
	        if ((code.code3==3)&&(code.code4==2)) {
	        	session.getAgenda().getAgendaGroup("A232").setFocus();
	        }
	        if ((code.code3==4)&&(code.code4==1)) {
	        	session.getAgenda().getAgendaGroup("A241").setFocus();
	        }
	        if ((code.code3==4)&&(code.code4==2)) {
	        	session.getAgenda().getAgendaGroup("A242").setFocus();
	        }
	        if ((code.code3==4)&&(code.code4==3)) {
	        	session.getAgenda().getAgendaGroup("A243").setFocus();
	        }
        }
        if (code.getDc()>=21&&code.getDc()<28) {
	        if ((code.code3==1)&&(code.code4==1)) {
	        	session.getAgenda().getAgendaGroup("A31").setFocus();
	        }
	        if ((code.code3==2)&&(code.code4==2)) {
	        	session.getAgenda().getAgendaGroup("A32").setFocus();
	        }
	        if ((code.code3==3)&&(code.code4==3)) {
	        	session.getAgenda().getAgendaGroup("A33").setFocus();
	        }
	        if ((code.code3==4)&&(code.code4==4)) {
	        	session.getAgenda().getAgendaGroup("A34").setFocus();
	        }
	        if ((code.code3==1)&&(code.code4==2)) {
	        	session.getAgenda().getAgendaGroup("A312").setFocus();
	        }
	        if ((code.code3==1)&&(code.code4==3)) {
	        	session.getAgenda().getAgendaGroup("A313").setFocus();
	        }
	        if ((code.code3==1)&&(code.code4==4)) {
	        	session.getAgenda().getAgendaGroup("A314").setFocus();
	        }
	        if ((code.code3==2)&&(code.code4==3)) {
	        	session.getAgenda().getAgendaGroup("A323").setFocus();
	        }
	        if ((code.code3==2)&&(code.code4==4)) {
	        	session.getAgenda().getAgendaGroup("A324").setFocus();
	        }
	        if ((code.code3==3)&&(code.code4==4)) {
	        	session.getAgenda().getAgendaGroup("A334").setFocus();
	        }
	        if ((code.code3==2)&&(code.code4==1)) {
	        	session.getAgenda().getAgendaGroup("A321").setFocus();
	        }
	        if ((code.code3==3)&&(code.code4==1)) {
	        	session.getAgenda().getAgendaGroup("A331").setFocus();
	        }
	        if ((code.code3==3)&&(code.code4==2)) {
	        	session.getAgenda().getAgendaGroup("A332").setFocus();
	        }
	        if ((code.code3==4)&&(code.code4==1)) {
	        	session.getAgenda().getAgendaGroup("A341").setFocus();
	        }
	        if ((code.code3==4)&&(code.code4==2)) {
	        	session.getAgenda().getAgendaGroup("A342").setFocus();
	        }
	        if ((code.code3==4)&&(code.code4==3)) {
	        	session.getAgenda().getAgendaGroup("A343").setFocus();
	        }
        }
        if (code.getDc()>=28) {
	        if ((code.code3==1)&&(code.code4==1)) {
	        	session.getAgenda().getAgendaGroup("A41").setFocus();
	        }
	        if ((code.code3==2)&&(code.code4==2)) {
	        	session.getAgenda().getAgendaGroup("A42").setFocus();
	        }
	        if ((code.code3==3)&&(code.code4==3)) {
	        	session.getAgenda().getAgendaGroup("A43").setFocus();
	        }
	        if ((code.code3==4)&&(code.code4==4)) {
	        	session.getAgenda().getAgendaGroup("A44").setFocus();
	        }
	        if ((code.code3==1)&&(code.code4==2)) {
	        	session.getAgenda().getAgendaGroup("A412").setFocus();
	        }
	        if ((code.code3==1)&&(code.code4==3)) {
	        	session.getAgenda().getAgendaGroup("A413").setFocus();
	        }
	        if ((code.code3==1)&&(code.code4==4)) {
	        	session.getAgenda().getAgendaGroup("A414").setFocus();
	        }
	        if ((code.code3==2)&&(code.code4==3)) {
	        	session.getAgenda().getAgendaGroup("A423").setFocus();
	        }
	        if ((code.code3==2)&&(code.code4==4)) {
	        	session.getAgenda().getAgendaGroup("A424").setFocus();
	        }
	        if ((code.code3==3)&&(code.code4==4)) {
	        	session.getAgenda().getAgendaGroup("A434").setFocus();
	        }
	        if ((code.code3==2)&&(code.code4==1)) {
	        	session.getAgenda().getAgendaGroup("A421").setFocus();
	        }
	        if ((code.code3==3)&&(code.code4==1)) {
	        	session.getAgenda().getAgendaGroup("A431").setFocus();
	        }
	        if ((code.code3==3)&&(code.code4==2)) {
	        	session.getAgenda().getAgendaGroup("A432").setFocus();
	        }
	        if ((code.code3==4)&&(code.code4==1)) {
	        	session.getAgenda().getAgendaGroup("A441").setFocus();
	        }
	        if ((code.code3==4)&&(code.code4==2)) {
	        	session.getAgenda().getAgendaGroup("A442").setFocus();
	        }
	        if ((code.code3==4)&&(code.code4==3)) {
	        	session.getAgenda().getAgendaGroup("A443").setFocus();
	        }
        }
        session.getAgenda().getAgendaGroup("RW").setFocus();
        break;
        }

		for(WorkDate date : lstDate) {
			session.insert(date);
			for (Shift s : date.getShifts()) {
				session.insert(s);
			}
		}
	    
		for (Worker worker : lstWorker) {
			session.insert(worker);
		}		
		System.out.println("Begin Date :");
		System.out.println(Begin_Date);
		session.fireAllRules();	
		System.out.println("Finish Date :");
		System.out.println(Finish_Date);
		System.out.println("\n");
		c.add(Calendar.DATE,-code.getDc());


		int b=code.getId();
        int u = 0;
		int j = 0;
		if (code.code5== "Sun") {
			j=7;
		} 
		if (code.code5== "Sat") {
			j=6;
		}
		if (code.code5== "Fri") {
			j=5;
		}
		if (code.code5== "Thu") {
			j=4;
		}
		if (code.code5== "Wen") {
			j=3;
		}
		if (code.code5== "Tue") {
			j=2;
		}
		if (code.code5== "Mon") {
			j=1;
		}
        int r=1;
        if (j==0) {
            r=0;
           }
        if (j==7)
        {
        	j=j-7;
        }
		List<Shift> lstShift = new ArrayList<Shift>();
		for (Worker w : lstWorker) {
			JSONObject object = new JSONObject();	
			object.put("id", b);
			object.put("name", w.getName());
			lstShift.clear();
			lstShift.addAll(w.getShifts());
			Collections.sort(lstShift);
			u++;
			if (u>code.code2) {
				break;
			}
             for (Shift shift : lstShift){            	 
            	int z=shift.getWorkDate().getDay();
  				 c.add(Calendar.DATE,+z);
  			    String TIME = dateFormat.format(c.getTime());	
  		        String[] weekDays = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
  		        int q = c.get(Calendar.DAY_OF_WEEK) - 1;
  		        if (q < 0)
  		            q = 0;	 
  				
  				object.put("time", TIME);
   		       switch (code.code0) {  		       
  		        case 0 :
  		        	switch (u) {
  		        	case 1: 		       
  		        	switch (q) {
  		        	case 0 :
  		        		object.put("value", "F");
  		        		break;
  		        	case 1:
  		        		object.put("value", "D");
  		        		break;
  		        	case 2:
  		        		object.put("value", "N");
  		        		break;
  		        	case 3:
  		        		object.put("value", "F");
  		        		break;
  		        	case 4:
  		        		object.put("value", "D");
  		        		break;
  		        	case 5:
  		        		object.put("value", "N");
  		        	case 6:
  		        		object.put("value", "F");
  		        		break; 		        		
  		        	}
  		        	break;
  		        	case 2: 		       
  		        	switch (q) {
  		        	case 0 :
  		        		object.put("value", "D");
  		        		break;
  		        	case 1:
  		        		object.put("value", "N");
  		        		break;
  		        	case 2:
  		        		object.put("value", "F");
  		        		break;
  		        	case 3:
  		        		object.put("value", "D");
  		        		break;
  		        	case 4:
  		        		object.put("value", "N");
  		        		break;
  		        	case 5:
  		        		object.put("value", "F");
  		        	case 6:
  		        		object.put("value", "F");
  		        		break; 		        		
  		        	}
  		        	break;
  		        	case 3: 		       
  		        	switch (q) {
  		        	case 0 :
  		        		object.put("value", "F");
  		        		break;
  		        	case 1:
  		        		object.put("value", "F");
  		        		break;
  		        	case 2:
  		        		object.put("value", "D");
  		        		break;
  		        	case 3:
  		        		object.put("value", "N");
  		        		break;
  		        	case 4:
  		        		object.put("value", "F");
  		        		break;
  		        	case 5:
  		        		object.put("value", "D");
  		        	case 6:
  		        		object.put("value", "N");
  		        		break; 		        		
  		        	}
  		        	break;
  		        	case 4: 		       
  		        	switch (q) {
  		        	case 0 :
  		        		object.put("value", "N");
  		        		break;
  		        	case 1:
  		        		object.put("value", "F");
  		        		break;
  		        	case 2:
  		        		object.put("value", "F");
  		        		break;
  		        	case 3:
  		        		object.put("value", "D");
  		        		break;
  		        	case 4:
  		        		object.put("value", "N");
  		        		break;
  		        	case 5:
  		        		object.put("value", "F");
  		        	case 6:
  		        		object.put("value", "D");
  		        		break; 		        		
  		        	}
  		        	break;
  		        	} 		        	
  		      	break;
  		        case 1: 
  			    int x = shift.getNo();
  			    if (weekDays[q]==weekDays[j]&& r!=0) {
  			    	 object.put("value", "F");
  			    }
  			    else if (code.sun != "" || code.sat != ""|| code.fri != ""|| code.thu != ""|| code.wen != ""|| code.tue != ""|| code.mon != "") {
  			    	if (code.sun != "" && q ==0) {
  			    		object.put("value", code.sun);
  			    	}
  			    	if (code.sat != "" && q ==0) {
  			    		object.put("value", code.sun);
  			    	}
  			    	if (code.fri != "" && q ==0) {
  			    		object.put("value", code.sun);
  			    	}
  			    	if (code.thu != "" && q ==0) {
  			    		object.put("value", code.sun);
  			    	}
  			    	if (code.wen != "" && q ==0) {
  			    		object.put("value", code.sun);
  			    	}
  			    	if (code.tue != "" && q ==0) {
  			    		object.put("value", code.sun);
  			    	}
  			    	if (code.mon != "" && q ==0) {
  			    		object.put("value", code.sun);
  			    	}
  			    }
  			    else {
                             if(x==1){
                            	 object.put("value", "D");
  			              }
                              if (x==2){
                            	  object.put("value", "N");
                            }
  			    }
  			    break;
   		       }
             				 c.add(Calendar.DATE,-z);
	             				String str = JSONObject.toJSONString(object, SerializerFeature.DisableCircularReferenceDetect);
	             				JSONObject jsonjson = JSONObject.parseObject(str);
	            	            js.add(jsonjson);	 
                            }

  		}
		session.dispose();
 }
 
 if (code.getId() == 8)
 {

		 String a = null ;
		 String l = code.CName ;
		 if (code.getCode6() == 1)
		 {
			a  = "Automation";								 
		 }
		 if (code.getCode6() == 2)
		 {
			a  = "Long Hole Team ";
		 }
		 if (code.getCode6() == 3)
		 {
			a  = "MA";
		 }
		 if (code.getCode6() == 4)
		 {
			a  = "MC";
		 }
		 if (code.getCode6() == 5)
		 {
			a  = "Planner";
		 }
		 if (code.getCode6() == 6)
		 {
			a  = "Production Group";
		 }
		 if (code.getCode6() == 7)
		 {
			a  = "Service Team";
		 }

	 List<WorkDate> lstDate = new ArrayList<WorkDate>();
	 
	 for (int i = 1; i<=code.getDc(); i ++) {
		 lstDate.add(new WorkDate(i));	 
	 }
	 List<Worker> lstWorker = new ArrayList<Worker>() ;
		for (int i=1;i<=1;i++) {
			Worker w=new Worker(1,a+l);
			w.setEasyDay(lstDate.size());
			lstWorker.add(w);
		}
		
		if(code.getCode1()>2) {
			System.out.println("Error:Too Many Shifts");
			throw new RuntimeException("Unable to compile.");
		}
		if(code.getDc()>31) {
			System.out.println("Error:The Schedule is too Long");
			throw new RuntimeException("Unable to compile.");
		}

		KieServices kieServices = KieServices.Factory.get(); 
        KieContainer kieContainer = kieServices.getKieClasspathContainer();
        KieSession session =  kieContainer.newKieSession("Rulecustom.drl");
        
        	session.getAgenda().getAgendaGroup("C1").setFocus();
        	session.getAgenda().getAgendaGroup("RC").setFocus();
 		
		for(WorkDate date : lstDate) {
			session.insert(date);
			for (Shift s : date.getShifts()) {
				session.insert(s);
			}
		}
	    
		for (Worker worker : lstWorker) {
			session.insert(worker);
		}		
		System.out.println("Begin Date :");
		System.out.println(Begin_Date);
		session.fireAllRules();	
		System.out.println("Finish Date :");
		System.out.println(Finish_Date);
		System.out.println("\n");
		c.add(Calendar.DATE,-code.getDc());
		int b=0;
		b = code.getCode6();
		List<Shift> lstShift = new ArrayList<Shift>();
		for (Worker w : lstWorker) {
			JSONObject object = new JSONObject();	
			object.put("id", b);
			object.put("name", w.getName());
			lstShift.clear();
			lstShift.addAll(w.getShifts());
			Collections.sort(lstShift);
             for (Shift shift : lstShift){            	 
            	int z=shift.getWorkDate().getDay();
  				 c.add(Calendar.DATE,+z);
  			    String TIME = dateFormat.format(c.getTime());	
  		        String[] weekDays = {"SUN","MON", "TUE", "WED", "THU", "FRI", "SAT"};
  		        int q = c.get(Calendar.DAY_OF_WEEK)-1;
  		        if (q < 0) {
  		            q = 0;	 
  		        }
  				object.put("time", TIME);
                switch (q) {
                case 0:            
                	object.put("value", code.CSun);
                  break ;
                case 1:            
                	object.put("value", code.CMon);
                  break ;
                case 2:            
                	object.put("value", code.CTue);
                  break ;
                case 3:            
                	object.put("value", code.CWen);
                  break ;
                case 4:            
                	object.put("value", code.CThu);
                  break ;
                case 5:            
                	object.put("value", code.CFri);
                  break ;
                case 6:            
                	object.put("value", code.CSat);
                  break ;
                }	                	  				
             				 c.add(Calendar.DATE,-z);
	             				String str = JSONObject.toJSONString(object, SerializerFeature.DisableCircularReferenceDetect);
	             				JSONObject jsonjson = JSONObject.parseObject(str);
	            	            js.add(jsonjson);	 
                            }
  		}
 }
 
 if (code.getId() <=0 || code.getId() > 8)
 {
		System.out.println("Error:No Match Schedule");
		throw new RuntimeException("Unable to compile.");
 }
 
 return js;
}
}

