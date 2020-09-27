package com.StateFarm.PageObjects;

public class PageObjects {

	// Start Quote Page
	public static final String drpdwn_Product_CSS = "#popDropdown";
	public static final String txt_StartQuoteZipCode_CSS = "#quote-main-zip-code-input";
	public static final String btn_startQuote_CSS = "#quote-main-zip-btn";

	// Step 1 Get your quote in few mins
	public static final String txt_FirstName_CSS = "#first_name";
	public static final String txt_MiddleName_CSS = "#middle_name";
	public static final String txt_LastName_CSS = "#last_name";	
	public static final String drpdwn_Suffix_CSS = "#suffix_name-button";
	public static final String txt_StreetAddress_CSS = "#street1";
	public static final String txt_APTUNIT_CSS = "#street2";
	public static final String txt_City_CSS = "#city";
	public static final String txt_State_XPATH = "//input[@id='welcomeAddress.stateProvince']";
	public static final String txt_ZIPCODE_CSS = "#zipPostalCode";
	public static final String txt_DateOfBirth_CSS = "#date_of_birth";
	public static final String txt_PolicyStartDate_CSS = "#effectiveDate";
	public static final String btn_NextVehicles_xpath = "//div[@class='span12 span4 resize-width']/button";

//	Add Vehicle
	public static final String btn_AddVehicle_xpath = "//button[contains(text(),'Add a vehicle')]";
	public static final String chkBox_ExistingVehicle_xpath="//input[@name='sfx_addVehicleModule_selection']";
	public static final String drpdwn_Year_xpath = "//select[@id='sfx_vehicles[0].motorVehicle.ymmb.year_input']";
	public static final String drpdwn_Make_xpath = "//select[@id='sfx_vehicles[0].motorVehicle.ymmb.make_input']";
	public static final String drpdwn_Model_xpath = "//select[@id='sfx_vehicles[0].motorVehicle.ymmb.model_input']";
	public static final String drpdwn_BodyStyle_xpath = "//select[@id='sfx_vehicles[0].motorVehicle.ymmb.bodyStyle_input']";
	public static final String btn_Add_xpath = "//button[@id='sfx_add-veh-step[0]_Add_btn_input']";
	public static final String rdo_VehiclePurchasedLastSixMonth_xpath = "//input[@id='sfx_vehicles[0].vehiclePurchaseInfo.vehiclePurchasedLastSixMonths_input_1']";
	public static final String drpdwn_VehiclePurchasedMonth_xpath = "//select[@id='purchaseMonth0_aqpDateFieldsSelector']";
	public static final String drpdwn_VehiclePurchasedYear_xpath = "//select[@id='purchaseYear0_aqpDateFieldsSelector']";
	public static final String txt_PurchasedDate_xpath = "//input[@id='purchaseDate0']";
	public static final String rdo_VehicleFinanced_xpath = "//input[@id='sfx_vehicles[0].vehicleAdditionalInfo.vehicleFinancing_input_2']";
	public static final String drpdwn_VehiclePrimaryUse_xpath = "//select[@id='sfx_vehicles[0].vehicleUse.vehicleUse_input']";
	public static final String txt_VehicleMileage_xpath = "//input[@id='sfx_vehicles[0].vehicleUse.annualMiles_input']";
	public static final String rdo_PermanentlyInstalledTheftDevice_xpath = "//input[@id='sfx_vehicles[0].motorVehicle.antitheftMechanismIndicator_input_1']";
	public static final String btn_NextDrivers_xpath = "//button[contains(text(),'Next: Drivers')]";
	
//	Drivers
	public static final String txt_DriverLicense_xpath = "//input[@id='sfx_drivers[0].operator.operatorLicense.driverLicense.licenseNumberUserEntered_input']";
	public static final String rdo_Gender_xpath = "//input[@id='sfx_drivers[0].operator.gender_input_1']";
	public static final String drpdwn_MaritalStatus_xpath = "//select[@id='sfx_drivers[0].operator.maritalStatus_input']";
	public static final String drpdwn_ResidenceType_xpath = "//select[@id='sfx_resType_input']";
	public static final String drpdwn_OwnershipStatus_xpath = "//select[@id='sfx_ownStatus_input']";
	public static final String txt_NumberOfVehicles_xpath = "//input[@id='sfx_numVehiclesUsedRegularly_input']";
	public static final String btn_NextDrivingHistory_xpath = "//button[contains(text(),'Next: Driving History')]";
	public static final String btn_NextAditionalInfo_xpath = "//button[contains(text(),'Next: Additional Info')]";
	
//	AdditionalInfo
	public static final String chkBox_RegisteredOwner_css = "#isOwnerInd00";
	public static final String drpdwn_MostRecentAutoInsurance_xpath = "//select[@id='sfx_quotes[0].riskSect[0].vehicleInsurance.insuranceCompanyNameForMostRecentProvider_input']";
	public static final String drpdwn_YearsInsurance_xpath = "//select[@id='numYearsContinuousInsurance_aqpAIContinuousInsuranceFields']";
	public static final String drpdwn_MonthsInsurance_xpath = "//select[@id='numMonthsContinuousInsurance_aqpAIContinuousInsuranceFields']";
	public static final String txt_ExpirationDate_xpath = "//input[@id='expirationDate 0']";
	public static final String drpdwn_CoverageLimits_xpath = "//select[@id='priorBodilyInjuryCoverageLimitAmount']";
	public static final String rdo_HouseHoldInfo_xpath = "//input[@id='sfx_household.uninsuredVehicleDrivenInd_input_1']";
	public static final String txt_Email_css = "#sfx_emlAddr1_input";
	public static final String txt_Phone_css = "#sfx_phoneNumber1_input_0";
	public static final String drpdwn_Type_css = "#sfx_phoneNumber1_input_1";
	public static final String btn_NextDriverSafenSave_xpath = "//button[contains(text(),'Next: Drive Safe & Save')]";
	public static final String rdo_DontWantDiscount_css = "#dssEnroll0LoopIndex2";
	public static final String btn_NextQuote_xpath = "//button[contains(text(),'Next: Quote')]";
	

}
