package ebanking.utilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import ebanking.testCases.BaseClass;

public class ReportingListeners extends BaseClass implements ITestListener {

	ExtentTest test;
	ExtentReports extent = eBankingExtentReports.setUpExtentReport();
	ThreadLocal<ExtentTest> tc = new ThreadLocal<ExtentTest>();

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		// ITestListener.super.onTestStart(result);
		test = extent.createTest(result.getMethod().getMethodName());
		tc.set(test);
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		// ITestListener.super.onTestSuccess(result);
		tc.get().log(Status.PASS, "Test is successful");
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		// ITestListener.super.onTestFailure(result);

		tc.get().fail(result.getThrowable());
		String destPath = null;

		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			 destPath = getScreenshot(result.getMethod().getMethodName(), driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		tc.get().addScreenCaptureFromPath(destPath, result.getMethod().getMethodName());

	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		// ITestListener.super.onFinish(context);
		extent.flush();
	}

}
