package Utilities;



import java.io.File;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;

import Core.Core;

public class ReportHelper {
	private static ExtentReports report;
	
	public static ExtentReports reportinit()
	{
		if (report==null)
		{
		
			report= new ExtentReports(System.getProperty("user.dir")+"\\src\\test\\resources\\Reports\\Extentetreport.html", true, DisplayOrder.OLDEST_FIRST);
		  report.loadConfig(new File (System.getProperty("user.dir")+"\\extent-config.xml"));
		}
		
		
		return report;
		
		
		
		
	}
	

}
