package ExtentReport;

import java.io.File;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class samplereport {
	@Test
	public void launchTheReport() 
	{
		ExtentReports report = new ExtentReports();
		File path = new File("./ExtentReport.html");
		ExtentSparkReporter spark = new ExtentSparkReporter(path);
		spark.config().setDocumentTitle("M3");
		spark.config().setReportName("Priteshsingh");
		spark.config().setTheme(Theme.STANDARD);
		
		// Attach the spark reports to extent report
		report.attachReporter(spark);
		report.setSystemInfo("os", "Windows11");
		report.setSystemInfo("Browser", "Chrome");
		
		// create the test case
		ExtentTest test1 = report.createTest("Test1");
		test1.log(Status.FAIL, "login function error");
		report.flush();
	}
}
