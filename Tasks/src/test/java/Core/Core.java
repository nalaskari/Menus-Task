package Core;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import Utilities.ExcelReader;
import Utilities.ReportHelper;

public class Core {
	/*
	 * initialization : webDriver, logs, reports, configuration excel to be used across the project 
	 * 
	 */

	public static WebDriver driver;
	public static Properties config;
 
	public static FileInputStream fis1;

	public static Logger log = Logger.getLogger("devpinoyLogger");
	public static ExcelReader datareader;
	public static ExtentReports report = ReportHelper.reportinit();
	public static ExtentTest testcase;
	DesiredCapabilities cap;
	 public static SoftAssert softassert;

	@BeforeSuite
	public void init() throws IOException {
		if (driver == null) {
			config = new Properties();
			fis1 = new FileInputStream(
					System.getProperty("user.dir") + "\\Configuration\\Config.properties");
			config.load(fis1);

			if (config.getProperty("browser").equals("chrome")) {
				
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "\\Resources\\Drivers\\chromedriver.exe");
				DesiredCapabilities cap=new DesiredCapabilities();
				//cap.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
				driver = new ChromeDriver();
				log.debug("chrome started");
			} else if (config.getProperty("browser").equals("firefox")) {

				System.setProperty("webdriver.gecko.driver",
						System.getProperty("user.dir") + "\\Resources\\Drivers\\geckodriver.exe");
				DesiredCapabilities cap=new DesiredCapabilities();
				
				driver = new FirefoxDriver();
				log.debug("firefox started");
			}
			else {
				new Exception("Driver not defined in configuration file");
			}
		}

		datareader = new ExcelReader();
		softassert=new SoftAssert();
		driver.get(config.getProperty("SUT"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);

	}

	@AfterSuite
	public void teardown() {
		driver.quit();
		log.debug("driver closed");

	}


}
