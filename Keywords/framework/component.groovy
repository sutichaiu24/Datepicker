package framework

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.driver.DriverFactory


import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import java.util.concurrent.TimeUnit
import org.openqa.selenium.support.ui.ExpectedConditions




import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import org.seleniumhq.*;



import internal.GlobalVariable

class component{
	@Keyword
	public static void handleDatepicker(TestObject calender, String exp_Date, String exp_Month,
			String exp_Year) throws Exception {
		String expDate = null, calYear = null,datepickerText=null,minYear=null,maxYear=null;
		String expMonth = null , expectYear = 0;
		
		List<WebElement> noOfDays=null,noOfMonths=null,noOfYears=null;
		boolean dateNotFound = true;

		def driver = DriverFactory.getWebDriver()
		expDate = (exp_Date);
		expectYear = (exp_Year);
		expMonth = (exp_Month);
		int count = 0;


		while (dateNotFound) {
		
			String Year = driver.findElement(By.xpath("//div[@class='datepicker-years']/table/thead/tr[2]/th[2]")).getText();
			def String[] yearPicker = Year.split("-");
			minYear = yearPicker[0]
			maxYear = yearPicker[1]
			
			if (Integer.parseInt(expectYear)<= Integer.parseInt(minYear))
			{
				if ((Integer.parseInt(expectYear) >= Integer.parseInt(minYear)) && (Integer.parseInt(expectYear) <= Integer.parseInt(maxYear))) {
					Thread.sleep(2000);
					WebElement datePicker = driver.findElement(By.xpath("//div[@class='datepicker-years']/table"));
					noOfYears = datePicker.findElements(By.cssSelector("span.year"));  				
					for (WebElement year : noOfYears) {
						if (expectYear.equalsIgnoreCase(year.getText())) {
							year.click();
							dateNotFound = false;
							break;
						}
					}
				} else {
					driver.findElement(By.xpath("//div[@class='datepicker-years']/table/thead/tr[2]/th[1]")).click();
				}
			}
				else if ((Integer.parseInt(expectYear) >= Integer.parseInt(minYear)) && (Integer.parseInt(expectYear) <= Integer.parseInt(maxYear))) {
                WebElement datePicker = driver.findElement(By.xpath("//div[@class='datepicker-years']/table"));
				noOfYears = datePicker.findElements(By.cssSelector("span.year"));
				for (WebElement year : noOfYears) {
					if (expectYear.equalsIgnoreCase(year.getText())) {
						year.click();
						dateNotFound =false;
						break;
					}
				}
				System.out.println("Year already Selected");
			}
			else {
				driver.findElement(By.cssSelector("body > div.datepicker.datepicker-dropdown.dropdown-menu.datepicker-orient-left.datepicker-orient-top > div.datepicker-years > table > thead > tr:nth-child(2) > th.next")).click();
			}
		}
			WebElement monthPicker = (driver).findElement(By.xpath("//div[@class='datepicker-months']/table"));
			noOfMonths = monthPicker.findElements(By.cssSelector("span.month"));
			for (WebElement month : noOfMonths){
				if (expMonth.equalsIgnoreCase(month.getText())){
					month.click();
					break ;
				}
			}

			Thread.sleep(2000);
			WebElement dayPicker = (driver).findElement(By.xpath("//div[@class='datepicker-days']/table"));
			List<WebElement> noOfdays = dayPicker.findElements(By.xpath("//td[contains(@class,'day')]"));
			for (WebElement day : noOfdays){
				if (expDate.equalsIgnoreCase(day.getText())){
					day.click();
	     		break ;
				}
			}
		
		
	}
}

