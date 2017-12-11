package com.ebay.setupmodule;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseSetUp {
	private WebDriver driver;
	public WebDriver getDriver() {
		return driver;
	}
	public WebDriver setDriver(String browserType, String appURL) {
		return driver = initFirefoxDriver(appURL);
	}

	/*private static WebDriver initChromeDriver(String appURL) {
		
		//System.out.println(appURL);
		System.out.println("Launching google chrome with new profile..");
		//System.setProperty("webdriver.chrome.driver", driverPath
		//		+ "chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Shobhit\\Desktop\\Testing\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(appURL);
		//driver.manage().window().maximize();
		//driver.navigate().to(appURL);
		//driver.get(appURL);
		return driver;
	}*/

private static WebDriver initFirefoxDriver(String appURL) {
		System.out.println("Launching Firefox browser..");
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Shobhit\\Desktop\\Testing\\drivers\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
	//	driver.manage().window().maximize();
		driver.get(appURL);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		return driver;
	}
	@Parameters({ "browserType", "appURL" })
	@BeforeClass
	public void initializeTestBaseSetup(String browserType, String appURL) {
		try {
			
			//System.out.println(appURL);
			setDriver(browserType, appURL);
		} catch (Exception e) {
			System.out.println("Error....." + e.getStackTrace());
		}
	}
	@AfterClass
	public static String excellread(){
		String searchText = null;
		 try {    
			  FileInputStream file = new FileInputStream(new File("C:\\Users\\Shobhit\\Desktop\\data.xlsx")); 
			  XSSFWorkbook workbook = new XSSFWorkbook(file);
			  XSSFSheet sheet = workbook.getSheetAt(0);
		      searchText = sheet.getRow(1).getCell(0).getStringCellValue();
		      file.close();	 
			 } catch (FileNotFoundException fnfe) {
			  fnfe.printStackTrace();
			 } catch (IOException ioe) {
			  ioe.printStackTrace();
			 }
		return searchText;
	}
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	

}
