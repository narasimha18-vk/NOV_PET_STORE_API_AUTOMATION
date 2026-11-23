package api.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class extent_report_manager {
	
	
	    public static ExtentReports getReportObject() {

	    //    String path ="C:\\Users\\Naras\\eclipse-workspace\\NOV_PET_STORE_API_AUTOMATION\\reports-folder\\reports.html";
	        
	        String path="C:\\Users\\Naras\\eclipse-workspace\\NOV_PETSTORE_API_AUTOMATION_FRAMEWORK\\reports\\reports.html";
	           

	        ExtentSparkReporter spark =
	            new ExtentSparkReporter(path);

	        ExtentReports extent =
	            new ExtentReports();

	        extent.attachReporter(spark);

	        return extent;
	    }
	

}
