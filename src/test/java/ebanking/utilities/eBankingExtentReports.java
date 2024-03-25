package ebanking.utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class eBankingExtentReports {
	
	public static ExtentReports extent;
	
	public static ExtentReports setUpExtentReport()
	{
		Date d=new Date();
		SimpleDateFormat date=new SimpleDateFormat("dd.MM.yyyy.HH.mm.ss");
		String timestamp=date.format(d);
		String fileName="Test-Reports-"+timestamp+".html";
		File file=new File(System.getProperty("user.dir")+"\\Reports\\"+fileName);
		ExtentSparkReporter reporter=new ExtentSparkReporter(file);
		
		reporter.config().setDocumentTitle("eBanking Framework Project");
		reporter.config().setReportName("Functional Test Automation Report");
		reporter.config().setTheme(Theme.DARK);
		
		extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Host Name", "localhost");
		extent.setSystemInfo("Enviornment", "QA");
		extent.setSystemInfo("Tester", "Ujwala Biranje");
		return extent;
	}

}
