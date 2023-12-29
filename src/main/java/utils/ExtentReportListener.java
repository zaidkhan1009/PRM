package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

/*
* @author Mohd-Umar
* @version 0.1
* @since 2023-12-01
*/

public class ExtentReportListener implements ITestListener {
    
	
	ExtentSparkReporter sparkReporter;
	ExtentReports reports;
    static ExtentTest test;
    
    public void configureReport() {
    	
    	sparkReporter = new ExtentSparkReporter("CloveReport.html");
    	reports = new ExtentReports();
    	reports.attachReporter(sparkReporter);
    	
    	reports.setSystemInfo("Project Name","Clove");
    	reports.setSystemInfo("O.S","Windows");
    	
    	sparkReporter.config().setDocumentTitle("Automation report");
    	sparkReporter.config().setReportName("Clove Automation report");	
    	
    }
    
    
    @Override
    public void onStart(ITestContext context) {
    	
    	String path=".\\reports\\";
    	
    	Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
        String formattedDate = dateFormat.format(currentDate);
        Date currentTime = new Date();
        SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm a");
        String reportTime = timeFormat.format(currentTime);
        String formattedTime = reportTime.replace(":","-");
        
        sparkReporter = new ExtentSparkReporter(path+"Clove Automation Report "+formattedDate+"_"+formattedTime+".html");
		sparkReporter.config().setDocumentTitle("Clove Automation Test Report");
		sparkReporter.config().setReportName("Clove Automation Report");
		
		reports = new ExtentReports();
		reports.attachReporter(sparkReporter);
		
		reports.setSystemInfo("Project Name","Clove");
		reports.setSystemInfo("O.S","Windows");
		
		final File CONF = new File("ExtentReport.xml");
		try {
			sparkReporter.loadXMLConfig(CONF);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test = reports.createTest(context.getName());
        System.out.println("Test created "+test);
		
    }

    @Override
    public void onTestStart(ITestResult result) {
        test = reports.createTest(result.getMethod().getMethodName());
        System.out.println("Initialized"+test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
    	test.log(Status.PASS, "Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
    	test.log(Status.FAIL, "Test Failed");
    	test.log(Status.FAIL, result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
    	test.log(Status.SKIP, "Test Skipped");
    }

    @Override
    public void onFinish(ITestContext context) {
        reports.flush();
    }

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	}
	
	public ExtentReports getExtentReport() {
        return reports;
    }

    public ExtentTest getExtentTest() {
        return test;
    }
}
