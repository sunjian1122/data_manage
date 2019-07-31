package com.alexgaoyh.quartz.test;

import org.springframework.stereotype.Component;

import com.alexgaoyh.sysman.admin.util.SysmanUserServiceUtil;

@Component("ScheduledJob")
public class ScheduledJob{
 
    protected void jobTask() {
    	System.out.println("SysmanUserServiceUtil.getService().get(1) = " + SysmanUserServiceUtil.getService().get(1));
    }
    
    
}