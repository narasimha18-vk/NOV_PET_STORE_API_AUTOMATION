package api.utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class extent_report_listener implements ITestListener {
	
	public void onStart()
	{
		 ExtentReports extent =
		            extent_report_manager.getReportObject();

		    ExtentTest test;
	}

    ExtentReports extent =
            extent_report_manager.getReportObject();

    ExtentTest test;

    @Override
    public void onTestStart(ITestResult result) {

        test = extent.createTest(result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        test.pass("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        test.fail(result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result) {

        test.skip("Test Skipped");
    }

    @Override
    public void onFinish(ITestContext context) {

        extent.flush();
    }
}