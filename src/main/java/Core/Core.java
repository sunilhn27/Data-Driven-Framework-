package Core;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;

import ExcelReader.ExcelReader;

public class Core {

	public static WebDriver d = null;
	public static Properties p = new Properties();
	public static ExtentReports r = ExtentReports.get(Core.class);
	public static Logger log = Logger.getLogger(Core.class);
	public static ExcelReader excel = new ExcelReader("D:\\MS OFFICE\\ExcelFiles\\HRM.xlsx");

	@BeforeSuite
	public static void init() throws IOException {

		if (d == null) {
			String log4jConfPath = "log4j.properties";
			PropertyConfigurator.configure(log4jConfPath);
			log.info("Driver initslized");

			r.init("F:\\Selenium The Grand Final\\DataDrivenFrameWork\\src\\main\\resources\\Reports\\Report.html", true);
			FileInputStream fs = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\main\\java\\config\\config.properties");
			p.load(fs);
			if (p.getProperty("browser").equalsIgnoreCase("Chrome")) {
				System.setProperty("webdriver.chrome.driver", "Chromedriver.exe");
				d = new ChromeDriver();
			} else if (p.getProperty("Browser").equals("firefox")) {
				d = new FirefoxDriver();
			} else if (p.getProperty("Browser").equals("IE")) {
				d = new InternetExplorerDriver();

			}
		}
		d.manage().timeouts().implicitlyWait(30l, TimeUnit.SECONDS);
		d.get(p.getProperty("url"));
		d.manage().window().maximize();
	}

	public static void getscreenshot(String testname) throws IOException {
		// File f = new File(p.getProperty("user.dir") +
		// "\\src\\main\\resources\\screenshot\\");
		File scr = ((TakesScreenshot) d).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scr,
				new File(System.getProperty("user.dir") + "\\src\\main\\resources\\screenshot" + testname + ".jpg"));
		log.info("Screen Shot Taken");

	}

	/*
	 * @BeforeClass public void report() { r.startTest(r.); }
	 * 
	 */
	@AfterSuite
	public static void tearDown() throws InterruptedException {
		Thread.sleep(20000);
		log.info("Driver closed");
		d.close();

	}
}