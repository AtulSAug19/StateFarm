package com.qa.StateFarm.StateFarm;

import java.io.File;
import java.net.MalformedURLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ControlFile {

	private static ControlFile ourInstance = null;
	static WebDriver driver;
	public static Properties prop;
	static JavascriptExecutor js;
	static Actions action;
	static WebDriverWait wait=null;

	static ControlFile getInstance() {
		if (ourInstance == null)
			ourInstance = new ControlFile();
		return ourInstance;
	}

	private ControlFile() {
		
	}

	public void openBrowser(String browserType, boolean isHeadLessReq)
			throws MalformedURLException, InterruptedException {
		if (browserType.equals("MOBILE")) {
			Map<String, Object> deviceMetrics = new HashMap<>();
			deviceMetrics.put("width", 300);
			deviceMetrics.put("height", 640);
			deviceMetrics.put("pixelRatio", 3.0);

			Map<String, Object> mobileEmulation = new HashMap<>();
			mobileEmulation.put("deviceMetrics", deviceMetrics);
			mobileEmulation.put("userAgent",
					"Mozilla/5.0 (Linux; Android 4.2.1; en-us; Nexus 5 Build/JOP40D) AppleWebKit/535.19 (KHTML, like Gecko) Chrome/18.0.1025.166 Mobile Safari/535.19");

			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
			driver = new ChromeDriver(chromeOptions);
		} else {

			Map<String, String> mobileEmulation = new HashMap<>();
			mobileEmulation.put("deviceName", "Galaxy S5");
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
			chromeOptions.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });
			chromeOptions.merge(chromeOptions);
			driver = new ChromeDriver(chromeOptions);

		}

		Dimension dm = new Dimension(360, 800);
		driver.manage().window().setSize(dm);
		driver.get("https://www.statefarm.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		js = (JavascriptExecutor) driver;
		action = new Actions(driver);
		driver.manage().deleteAllCookies();
		wait = new WebDriverWait(driver,10);
	}

	public static WebDriver getDriver() {
		return driver;
	}

	public boolean isElementEnabled(WebElement element) {
		boolean flag = false;
		try {
			if (isElementDisplayed(element))
				flag = element.isEnabled();
		} catch (Exception e) {
			System.out.println("com.qa.Base-TestRunner-isElementEnabled" + e.getMessage());
		}
		return flag;
	}

	public boolean isElementDisplayed(WebElement element) {
		boolean flag = false;
		try {
			flag = element.isDisplayed();
		} catch (Exception e) {
			System.out.println("com.qa.Base-TestRunner-isElementDisplayed" + e.getMessage());
		}
		return flag;
	}

	public void clickElement(WebElement element) {
		if (isElementEnabled(element)) {
			action.moveToElement(element).perform();
			element.click();
		} else
			System.out.println("com.qa.Base-TestRunner-clickElement" + "Element not enabled");
	}

	public void setText(WebElement element, String text) {
		if (isElementEnabled(element))
			element.clear();
		element.sendKeys(text);
	}

	public WebElement getElement(String locatorType, String locatorValue) {
		WebElement element = null;
		switch (locatorType) {
		case "id":
			element = driver.findElement(By.id(locatorValue));
			break;
		case "name":
			element = driver.findElement(By.name(locatorValue));
			break;
		case "xpath":
			element = driver.findElement(By.xpath(locatorValue));
			break;
		case "css":
			element = driver.findElement(By.cssSelector(locatorValue));
			break;
		}
		PageFactory.initElements(driver,this);
		return element;
	}

	public List<WebElement> getListofWebElements(String locatorType, String locatorValue) {
		List<WebElement> element = null;
		switch (locatorType) {
		case "id":
			element = driver.findElements(By.id(locatorValue));
			break;
		case "name":
			element = driver.findElements(By.name(locatorValue));
			break;
		case "xpath":
			element = driver.findElements(By.xpath(locatorValue));
			break;
		case "css":
			element = driver.findElements(By.cssSelector(locatorValue));
			break;
		}
		return element;
	}

	public void closeBrowser() {
		driver.close();
	}

	public void refreshBrowser() {
		driver.navigate().refresh();
	}

	public void getScreenshot(String fileName, String filePath) {
		try {
			TakesScreenshot screenshot = (TakesScreenshot) driver;
			File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
			File destFile = new File(filePath + "//" + fileName + ".png");
			FileUtils.copyFile(srcFile, destFile);

		} catch (Exception e) {

		}
	}

	public String getTitlePage() {
		return driver.getTitle();
	}

	public String getCurrentURLPage() {
		return driver.getCurrentUrl();
	}

	public String getWindowID() {
		return driver.getWindowHandle();
	}

	public Set<String> getAllWindowID() {
		return driver.getWindowHandles();
	}

	public Alert switchToAlert() {
		return driver.switchTo().alert();
	}

	public void switchToFrame(String switchToType, Object value) {
		switch (switchToType) {
		case "index": {
			driver.switchTo().frame((int) value);
			break;
		}
		case "Name": {
			driver.switchTo().frame((String) value);
			break;
		}
		case "WebElement":
			driver.switchTo().frame((WebElement) value);
			break;
		}
	}

	public void returnFromFrame() {
		driver.switchTo().defaultContent();
	}

	public void switchToWindow(String windowID) {
		driver.switchTo().window(windowID);
	}

	public String getCurrentDate() {
		DateFormat dt = new SimpleDateFormat("M/dd/yyyy");
		Date date = new Date();
		return dt.format(date);
	}

	public boolean selectValueinDropDown(WebElement element, String selectByOption, String value) {
		boolean flag = false;

		try {
			Select sel = new Select(element);
			switch (selectByOption) {
			case "value": {
				sel.selectByValue(value);
				flag = true;
				break;
			}
			case "visibletext": {
				sel.selectByVisibleText(value);
				flag = true;
				break;
			}
			case "index":
				sel.selectByIndex(Integer.parseInt(value));
				flag = true;
				break;
			}

		} catch (Exception e) {

		}
		return flag;
	}

	public void scrollToElement(WebElement element) {
		js.executeScript("arguments[0].scrollIntoView();", element);
	}

	public void HoverMouse(WebElement element) {
		action.moveToElement(element);
	}

	public void javascriptClick(WebElement element) {
		PageFactory.initElements(driver,this);
		js.executeScript("arguments[0].click();", element);
	}

}
