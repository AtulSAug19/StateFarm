package com.qa.StateFarm.StateFarm;

import java.awt.AWTException;
import java.io.File;
import java.io.FileInputStream;
import java.net.MalformedURLException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.StateFarm.PageObjects.PageObjects;

public class TestScript1 {

	public ControlFile controlFile;
	public static Properties prop = new Properties();
	WebDriver driver;
	WebDriverWait wait;
	String clientID = null;

	@BeforeClass
	public void setUp() throws MalformedURLException, InterruptedException {
		controlFile = ControlFile.getInstance();
		controlFile.openBrowser("GalaxyS5", false);
		try {
			String filePath = System.getProperty("user.dir") + "\\TestData\\TestData.properties";
			File file = new File(filePath);
			FileInputStream fileInput = new FileInputStream(file);
			prop.load(fileInput);
			driver = ControlFile.getDriver();

		} catch (Exception e) {

		}

	}
	
	@AfterClass
	public void tearDown()
	{
		controlFile.closeBrowser();
	}

	// Step-1
	@Test(priority = 1)
	public void startTest() throws InterruptedException, AWTException {
		WebElement productType = controlFile.getElement("css", PageObjects.drpdwn_Product_CSS);
		WebElement zipCode_StartQuote = controlFile.getElement("css", PageObjects.txt_StartQuoteZipCode_CSS);
		WebElement startQuote = controlFile.getElement("css", PageObjects.btn_startQuote_CSS);
		controlFile.selectValueinDropDown(productType, "visibletext", prop.getProperty("ProductType"));
		controlFile.setText(zipCode_StartQuote, prop.getProperty("ZipCode_StartQuote"));
		Thread.sleep(1000);
		controlFile.clickElement(startQuote);
		Thread.sleep(4000);
	}

	// Step-2
	@Test(priority = 2, dependsOnMethods = { "startTest" })
	public void enterPersonalDetails() throws InterruptedException, AWTException {
		try {
		WebElement FirstName = controlFile.getElement("css", PageObjects.txt_FirstName_CSS);
		WebElement MiddleName = controlFile.getElement("css", PageObjects.txt_MiddleName_CSS);
		WebElement LastName = controlFile.getElement("css", PageObjects.txt_LastName_CSS);
		WebElement streetAddress = controlFile.getElement("css", PageObjects.txt_StreetAddress_CSS);
		WebElement AptUnit = controlFile.getElement("css", PageObjects.txt_APTUNIT_CSS);
		WebElement City = controlFile.getElement("css", PageObjects.txt_City_CSS);
		WebElement zipCode = controlFile.getElement("css", PageObjects.txt_ZIPCODE_CSS);
		WebElement DateOfBirth = controlFile.getElement("css", PageObjects.txt_DateOfBirth_CSS);
		WebElement PolicyStartDate = controlFile.getElement("css", PageObjects.txt_PolicyStartDate_CSS);
		WebElement NextButton = controlFile.getElement("xpath", PageObjects.btn_NextVehicles_xpath);

		controlFile.setText(FirstName, prop.getProperty("FirstName"));
		Thread.sleep(1000);
		
		controlFile.setText(MiddleName, prop.getProperty("MiddleName"));
		Thread.sleep(1000);
		
		controlFile.setText(LastName, prop.getProperty("LastName"));
		Thread.sleep(1000);
		
		controlFile.setText(streetAddress, prop.getProperty("StreetAddress"));
		Thread.sleep(1000);
		
		controlFile.setText(AptUnit, prop.getProperty("AptUnit"));
		Thread.sleep(1000);
		
		controlFile.scrollToElement(City);
		Thread.sleep(1000);
		
		controlFile.setText(City, prop.getProperty("City"));
		Thread.sleep(1000);
		
		controlFile.setText(zipCode, prop.getProperty("ZipCode"));
		Thread.sleep(1000);
		
		controlFile.setText(DateOfBirth, prop.getProperty("DateOfBirth"));
		Thread.sleep(1000);
		
		controlFile.setText(PolicyStartDate, prop.getProperty("PolicyStartDate"));
		Thread.sleep(1000);
		
		clientID = controlFile.getCurrentURLPage().split("=")[1];
		
		controlFile.scrollToElement(NextButton);
		Thread.sleep(1000);
//		ControlFile.wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@name='nextVehicles']")));
//		controlFile.clickElement(NextButton);
//		Thread.sleep(2000);
		driver.get("https://auto.statefarm.com/quoteAndPurchase/customer/vehicle?conversationId=" + clientID);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

	// Step -3
	@Test(priority = 3, dependsOnMethods = { "enterPersonalDetails" })
	public void addVehicle() throws InterruptedException {
		Thread.sleep(10000);
		WebElement addVehicle = controlFile.getElement("xpath", PageObjects.btn_AddVehicle_xpath);
		addVehicle.click();

		WebElement year = controlFile.getElement("xpath", PageObjects.drpdwn_Year_xpath);
		controlFile.selectValueinDropDown(year, "visibletext", prop.getProperty("Year"));
		Thread.sleep(1000);

		WebElement make = controlFile.getElement("xpath", PageObjects.drpdwn_Make_xpath);
		controlFile.selectValueinDropDown(make, "visibletext", prop.getProperty("Make"));
		Thread.sleep(1000);

		WebElement model = controlFile.getElement("xpath", PageObjects.drpdwn_Model_xpath);
		controlFile.selectValueinDropDown(model, "visibletext", prop.getProperty("Model"));
		Thread.sleep(1000);

		WebElement BodyStyle = controlFile.getElement("xpath", PageObjects.drpdwn_BodyStyle_xpath);
		controlFile.selectValueinDropDown(BodyStyle, "visibletext", prop.getProperty("BodyStyle"));
		Thread.sleep(1000);

		WebElement add = controlFile.getElement("xpath", PageObjects.btn_Add_xpath);
		controlFile.scrollToElement(add);
		Thread.sleep(1000);
		controlFile.clickElement(add);
		Thread.sleep(1000);

		WebElement vehiclePurchased = controlFile.getElement("xpath",PageObjects.rdo_VehiclePurchasedLastSixMonth_xpath);
		controlFile.HoverMouse(vehiclePurchased);
		controlFile.javascriptClick(vehiclePurchased);
		Thread.sleep(1000);

		WebElement purchaseMonth = controlFile.getElement("xpath", PageObjects.drpdwn_VehiclePurchasedMonth_xpath);
		controlFile.selectValueinDropDown(purchaseMonth, "visibletext", prop.getProperty("PurchaseMonth"));
		Thread.sleep(1000);

		WebElement purchaseYear = controlFile.getElement("xpath", PageObjects.drpdwn_VehiclePurchasedYear_xpath);
		controlFile.selectValueinDropDown(purchaseYear, "index", "3");
		Thread.sleep(1000);

		WebElement vehicleFinanced = controlFile.getElement("xpath", PageObjects.rdo_VehicleFinanced_xpath);
		controlFile.scrollToElement(vehicleFinanced);
		Thread.sleep(1000);
		controlFile.javascriptClick(vehicleFinanced);
		Thread.sleep(1000);

//		 WebElement vehiclePrimaryUse =
//		 controlFile.getElement("xpath",PageObjects.drpdwn_VehiclePrimaryUse_xpath);
//		 controlFile.scrollToElement(vehiclePrimaryUse);
//		 Thread.sleep(1000);
//		 controlFile.selectValueinDropDown(vehiclePrimaryUse, "index","1");
//		 Thread.sleep(1000);

		// WebElement VehicleMileage =
		// controlFile.getElement("xpath",PageObjects.txt_VehicleMileage_xpath);
		// controlFile.scrollToElement(VehicleMileage);
		// Thread.sleep(1000);
		// controlFile.setText(VehicleMileage,"12000");
		// Thread.sleep(1000);

		WebElement installTheftDevice = controlFile.getElement("xpath",PageObjects.rdo_PermanentlyInstalledTheftDevice_xpath);
		controlFile.scrollToElement(installTheftDevice);
		Thread.sleep(1000);
		controlFile.javascriptClick(installTheftDevice);
		Thread.sleep(1000);

		WebElement NextDrivers = controlFile.getElement("xpath", PageObjects.btn_NextDrivers_xpath);
		controlFile.scrollToElement(NextDrivers);
		Thread.sleep(1000);
//		 controlFile.clickElement(NextDrivers);
		 Thread.sleep(1000);
		driver.get("https://auto.statefarm.com/quoteAndPurchase/customer/driver?conversationId=" + clientID);
	}

	// Step-4
	@Test(priority = 4, dependsOnMethods = { "addVehicle" })
	public void enterDriverDetails() throws InterruptedException {
		Thread.sleep(5000);
		WebElement DriverLicense = controlFile.getElement("xpath", PageObjects.txt_DriverLicense_xpath);
		controlFile.setText(DriverLicense, prop.getProperty("DriverLicense"));
		Thread.sleep(1000);

		WebElement gender = controlFile.getElement("xpath", PageObjects.rdo_Gender_xpath);
		controlFile.javascriptClick(gender);
		Thread.sleep(1000);

		WebElement maritalStatus = controlFile.getElement("xpath", PageObjects.drpdwn_MaritalStatus_xpath);
		controlFile.scrollToElement(maritalStatus);
		Thread.sleep(1000);
		controlFile.selectValueinDropDown(maritalStatus, "visibletext", prop.getProperty("MaritalStatus"));
		Thread.sleep(1000);

		WebElement residenceType = controlFile.getElement("xpath", PageObjects.drpdwn_ResidenceType_xpath);
		controlFile.scrollToElement(residenceType);
		Thread.sleep(1000);
		controlFile.selectValueinDropDown(residenceType, "visibletext", prop.getProperty("ResidenceType"));
		Thread.sleep(1000);

		WebElement ownerShipStatus = controlFile.getElement("xpath", PageObjects.drpdwn_OwnershipStatus_xpath);		
		controlFile.selectValueinDropDown(ownerShipStatus, "visibletext", prop.getProperty("OwnerShipStatus"));
		Thread.sleep(1000);

		WebElement numberOfVehicles = controlFile.getElement("xpath", PageObjects.txt_NumberOfVehicles_xpath);		
		controlFile.setText(numberOfVehicles, "1");
		Thread.sleep(1000);

		WebElement NextDrivingHistory = controlFile.getElement("xpath", PageObjects.btn_NextDrivingHistory_xpath);
		controlFile.scrollToElement(NextDrivingHistory);
		Thread.sleep(1000);
		
		driver.get("https://auto.statefarm.com/quoteAndPurchase/customer/drivingHistory?conversationId=" + clientID);
		
		Thread.sleep(12000);
		WebElement NextAdditionalInfo = controlFile.getElement("xpath", PageObjects.btn_NextAditionalInfo_xpath);
		controlFile.scrollToElement(NextAdditionalInfo);
		
		driver.get("https://auto.statefarm.com/quoteAndPurchase/customer/additionalInfo?conversationId=" + clientID);
		Thread.sleep(5000);

	}

//	Step - 5
	@Test(priority = 5, dependsOnMethods = { "enterDriverDetails" })
	public void additionalInfo() throws InterruptedException {
		
		WebElement RegisteredOwner = controlFile.getElement("css",PageObjects.chkBox_RegisteredOwner_css);
		controlFile.javascriptClick(RegisteredOwner);
		Thread.sleep(1000);
		
		WebElement Allstate = controlFile.getElement("xpath",PageObjects.drpdwn_MostRecentAutoInsurance_xpath);
		controlFile.selectValueinDropDown(Allstate, "value", prop.getProperty("MostRecentAutoInsurance"));
		Thread.sleep(1000);
		
		WebElement Years = controlFile.getElement("xpath",PageObjects.drpdwn_YearsInsurance_xpath);
		controlFile.selectValueinDropDown(Years, "value", prop.getProperty("YearsInsurance"));
		Thread.sleep(1000);
		
		WebElement Months = controlFile.getElement("xpath",PageObjects.drpdwn_MonthsInsurance_xpath);
		controlFile.selectValueinDropDown(Months, "value", prop.getProperty("MonthsInsurance"));
		Thread.sleep(1000);
		
		WebElement expirationDate = controlFile.getElement("xpath",PageObjects.txt_ExpirationDate_xpath);
		controlFile.setText(expirationDate, prop.getProperty("ExpirationDate"));
		Thread.sleep(1000);
		
		WebElement coverageLimits = controlFile.getElement("xpath",PageObjects.drpdwn_CoverageLimits_xpath);
		controlFile.selectValueinDropDown(coverageLimits, "value", prop.getProperty("CoverageLimits"));
		Thread.sleep(1000);
		
		WebElement houseHold = controlFile.getElement("xpath",PageObjects.rdo_HouseHoldInfo_xpath);
		controlFile.javascriptClick(houseHold);
		Thread.sleep(1000);
		
		WebElement NextDriverSafeNSave = controlFile.getElement("xpath",PageObjects.btn_NextDriverSafenSave_xpath);
		controlFile.scrollToElement(NextDriverSafeNSave);
		Thread.sleep(1000);
		
		WebElement email = controlFile.getElement("css",PageObjects.txt_Email_css);
		controlFile.setText(email, prop.getProperty("Email"));
		Thread.sleep(1000);
		
		WebElement phone = controlFile.getElement("css",PageObjects.txt_Phone_css);
		controlFile.setText(phone, prop.getProperty("Phone"));
		Thread.sleep(1000);
		
		WebElement type = controlFile.getElement("css",PageObjects.drpdwn_Type_css);
		controlFile.selectValueinDropDown(type, "value", prop.getProperty("Type"));
		Thread.sleep(1000);
		
		driver.get("https://auto.statefarm.com/quoteAndPurchase/customer/driveSafeAndSave?conversationId=" + clientID);
		Thread.sleep(10000);
		
		WebElement discount = controlFile.getElement("css",PageObjects.rdo_DontWantDiscount_css);
		controlFile.javascriptClick(discount);
		Thread.sleep(1000);
		
		WebElement NextQuote = controlFile.getElement("xpath",PageObjects.btn_NextQuote_xpath);
		controlFile.scrollToElement(NextQuote);
		Thread.sleep(1000);
		
//		driver.get("https://auto.statefarm.com/quoteAndPurchase/customer/quote/packages?conversationId=" + clientID);
	}

}
