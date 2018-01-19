package Rates;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import ObjectRepository.AddRate;

import ObjectRepository.EditRates;
import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;
import ObjectRepository.NewAccoBooking;
import ObjectRepository.Operations;
import ObjectRepository.RateFilter;
import Utility.Configuration;
import lib.DriverAndObjectDetails;
import lib.ExcelDataConfig;
import lib.ExtentManager;
import lib.Takescreenshot;
import lib.DriverAndObjectDetails.DriverName;

public class Stay_length_conditions_can_be_edited {
	public WebDriver driverqa;
	Configuration Config = new Configuration();
	Takescreenshot obj= new Takescreenshot();
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test;
	LoginPage login = new LoginPage();
	HomePage home = new HomePage();
	NewAccoBooking acco = new NewAccoBooking();
	Operations opo = new Operations();
	Logger logger = Logger.getLogger("Stay_length_conditions_can_be_edited");
	
	 @Test
	 @Parameters({ "browsername" })
	  public void editrategeneraldetails(String browsername) throws Exception {
		  test = rep.startTest("editAllotment");
		  ExcelDataConfig excel;
		  excel = new ExcelDataConfig(Config.getExcelPathRate());
		  PropertyConfigurator.configure("Log4j.properties");
		  logger.info("Test Case Started");
		if (browsername.equalsIgnoreCase("CH")) {
			       driverqa = new DriverAndObjectDetails(DriverName.CH).CreateDriver();
				} else if (browsername.equalsIgnoreCase("IE")) {
					driverqa = new DriverAndObjectDetails(DriverName.IE).CreateDriver();
				} else {
					driverqa = new DriverAndObjectDetails(DriverName.FF).CreateDriver();
				}
			    WebDriverWait wait= new WebDriverWait(driverqa, 30);
			    Actions action = new Actions(driverqa);
	           try{
			    logger.info("Browser Opened");
				driverqa.get(Config.getApplicationUrl());
				logger.info("Test Case Started");
				test.log(LogStatus.INFO, "Starting Login");
				WebElement username = driverqa.findElement(LoginPage.uname);
				username.clear();
				username.sendKeys(excel.getData(4, 1, 0));
				WebElement password = driverqa.findElement(LoginPage.pwd);
				password.clear();
				password.sendKeys(excel.getData(4, 1, 1));
				driverqa.findElement(LoginPage.submit).click();
				Thread.sleep(1000);
				String expectedtitle = "DOTWconnect.com::DOTWconnect.com: My Admin";
				String atualtitle = driverqa.getTitle();
				Assert.assertEquals(atualtitle, expectedtitle);
				test.log(LogStatus.INFO, "Ending Login");
				test.log(LogStatus.PASS, "PASSED Login");
				logger.info("Login Successful");
		} catch (Exception e) {
			logger.info(e.getMessage());
			test.log(LogStatus.FAIL, e.getMessage());
			rep.endTest(test);
			rep.flush();
			Assert.assertTrue(false, e.getMessage());
			test.log(LogStatus.FAIL, "Login");
		}
	           try {
					logger.info("Searching Accomodation"); 
					   test.log(LogStatus.INFO, "Navigating to Accomodation search page");
						logger.info("Navigating to Accomodation search page");
						 driverqa.findElement(RateFilter.prod).click();
						 wait.until(ExpectedConditions.visibilityOfElementLocated(RateFilter.accomodation));
						 driverqa.findElement(RateFilter.accomodation).click();
						 wait.until(ExpectedConditions.visibilityOfElementLocated(RateFilter.rateninv));
						 driverqa.findElement(RateFilter.rateninv).click();
						 Thread.sleep(2000);
						 String searchaccomatualtitle = driverqa.getTitle();
						 String searchaccomexpectedtitle = "DOTWconnect.com::Filter Accommodation Units";
						 Assert.assertEquals(searchaccomatualtitle, searchaccomexpectedtitle);
						 logger.info("Navigated to Accomodation search page");
						 test.log(LogStatus.PASS, "Navigated to Accomodation search page");
				} catch (Exception e) {
					logger.info(e.getMessage());
					test.log(LogStatus.FAIL, e.getMessage());
					rep.endTest(test);
					rep.flush();
					Assert.assertTrue(false, e.getMessage());
					test.log(LogStatus.FAIL, "Navigating to Accomodation search page");
					System.out.println(e.getMessage());
				}
	           try {
					Thread.sleep(2000);
					    obj.Takesnap(driverqa, Config.SnapShotPath() + "/Rates/Stay_length_conditions_can_be_edited/Rate-filter-screen.jpg");
					     logger.info("Selecting Accomodation Unit");
					     test.log(LogStatus.INFO, "Selecting Accomodation Unit");
					     wait.until(ExpectedConditions.visibilityOfElementLocated(RateFilter.accomname));
						 driverqa.findElement(RateFilter.accomname).sendKeys(excel.getData(4, 4, 0));
						 Thread.sleep(1000);
						 action.sendKeys(Keys.ARROW_DOWN).build().perform();
						 action.sendKeys(Keys.ENTER).build().perform();
						 Thread.sleep(3000);
						 driverqa.findElement(RateFilter.filter).click();
						 Thread.sleep(2000);
						 obj.Takesnap(driverqa, Config.SnapShotPath() + "/Rates/Stay_length_conditions_can_be_edited/Rate-filter-screen.jpg");
						 wait.until(ExpectedConditions.visibilityOfElementLocated(RateFilter.contractvalidity));
						 String filterratescreenactualtitle = driverqa.getTitle();
						 String filterratescreenexpectedtitle = "DOTWconnect.com::Rate Filter";
						 Assert.assertEquals(filterratescreenactualtitle, filterratescreenexpectedtitle);
						 logger.info("Accomodation Unit Selected");
						 test.log(LogStatus.PASS, "Accomodation Unit Selected");
				} catch (Exception e) {
					logger.info(e.getMessage());
					test.log(LogStatus.FAIL, e.getMessage());
					rep.endTest(test);
					rep.flush();
					Assert.assertTrue(false, e.getMessage());
					test.log(LogStatus.FAIL, "Selecting Accomodation Unit");
					System.out.println(e.getMessage());
				}
	           try {
					logger.info("Navigating to ContractList");
					    test.log(LogStatus.INFO, "Navigating to ContractList");
					   wait.until(ExpectedConditions.visibilityOfElementLocated(RateFilter.filterrates));
					   driverqa.findElement(RateFilter.travelstartdate).clear();
					   driverqa.findElement(RateFilter.travelstartdate).sendKeys(excel.getData(4, 7, 0));
					   Thread.sleep(2000);
					   obj.Takesnap(driverqa, Config.SnapShotPath() + "/Rates/Stay_length_conditions_can_be_edited/Final-Rate-filter-screen.jpg");
					   driverqa.findElement(RateFilter.filterrates).click();
					   wait.until(ExpectedConditions.visibilityOfElementLocated(AddRate.newrate));
					   Thread.sleep(2000);
					   obj.Takesnap(driverqa, Config.SnapShotPath() + "/Rates/Stay_length_conditions_can_be_edited/Contract-List-screen.jpg");
					   String addratescreenactualtitle = driverqa.getTitle();
					   String addratescreenexpectedtitle = "DOTWconnect.com::";
					   Assert.assertEquals(addratescreenactualtitle, addratescreenexpectedtitle);
					   logger.info("Navigated to ContractList");
					   test.log(LogStatus.PASS, "Navigated to ContractList");
				} catch (Exception e) {
					logger.info(e.getMessage());
					test.log(LogStatus.FAIL, e.getMessage());
					rep.endTest(test);
					rep.flush();
					Assert.assertTrue(false, e.getMessage());
					test.log(LogStatus.FAIL, "Navigating to ContractList");
					
				}
	           try {
					logger.info("Editing general details");
					    test.log(LogStatus.INFO, "Editing general details");
					    obj.Takesnap(driverqa, Config.SnapShotPath() + "/Rates/Stay_length_conditions_can_be_edited/Before_edit.jpg");
					  driverqa.findElement(EditRates.stay_length_edit).click();
					  Thread.sleep(2000);
					  Select dropdown1=new Select(driverqa.findElement(EditRates.stay_length_nights));
			            dropdown1.selectByVisibleText(excel.getData(4,10,0));
			            Thread.sleep(3000);
			            
			            driverqa.findElement(EditRates.stay_length_from).clear();
						   driverqa.findElement(EditRates.stay_length_from).sendKeys(excel.getData(4,10,1));
						   Thread.sleep(2000);
						   
						    driverqa.findElement(EditRates.stay_length_to).clear();
							   driverqa.findElement(EditRates.stay_length_to).sendKeys(excel.getData(4,10,2));
							   Thread.sleep(2000);
							   
						if(excel.getData(4, 15, 1).equalsIgnoreCase("yes")){
							if(driverqa.findElement(EditRates.stay_checkbox_sun).isSelected()){
								System.out.println("sunday already selected");}
							else{
								driverqa.findElement(EditRates.stay_checkbox_sun).click();
							}
						}
						else if(excel.getData(4, 15, 1).equalsIgnoreCase("no")){
							driverqa.findElement(EditRates.stay_checkbox_sun).isSelected();
							driverqa.findElement(EditRates.stay_checkbox_sun).click();
						}
						
						if(excel.getData(4, 15, 2).equalsIgnoreCase("yes")){
							if(driverqa.findElement(EditRates.stay_checkbox_mon).isSelected()){
								System.out.println("monday already selected");}
							else{
								driverqa.findElement(EditRates.stay_checkbox_mon).click();
							}
						}
						else if(excel.getData(4, 15, 2).equalsIgnoreCase("no")){
							driverqa.findElement(EditRates.stay_checkbox_mon).isSelected();
							driverqa.findElement(EditRates.stay_checkbox_mon).click();
						}
						
						if(excel.getData(4, 15, 3).equalsIgnoreCase("yes")){
							if(driverqa.findElement(EditRates.stay_checkbox_tue).isSelected()){
								System.out.println("tuesday already selected");}
							else{
								driverqa.findElement(EditRates.stay_checkbox_tue).click();
							}
						}
						else if(excel.getData(4, 15, 3).equalsIgnoreCase("no")){
							driverqa.findElement(EditRates.stay_checkbox_tue).isSelected();
							driverqa.findElement(EditRates.stay_checkbox_tue).click();
						}
						
						
						if(excel.getData(4, 15, 4).equalsIgnoreCase("yes")){
							if(driverqa.findElement(EditRates.stay_checkbox_wed).isSelected()){
								System.out.println("wed already selected");}
							else{
								driverqa.findElement(EditRates.stay_checkbox_wed).click();
							}
						}
						else if(excel.getData(4, 15, 4).equalsIgnoreCase("no")){
							driverqa.findElement(EditRates.stay_checkbox_wed).isSelected();
							driverqa.findElement(EditRates.stay_checkbox_wed).click();
						}
						
						if(excel.getData(4, 15, 5).equalsIgnoreCase("yes")){
							if(driverqa.findElement(EditRates.stay_checkbox_thurs).isSelected()){
								System.out.println("thursday already selected");}
							else{
								driverqa.findElement(EditRates.stay_checkbox_thurs).click();
							}
						}
						else if(excel.getData(4, 15, 5).equalsIgnoreCase("no")){
							driverqa.findElement(EditRates.stay_checkbox_thurs).isSelected();
							driverqa.findElement(EditRates.stay_checkbox_thurs).click();
						}
						
						if(excel.getData(4, 15, 6).equalsIgnoreCase("yes")){
							if(driverqa.findElement(EditRates.stay_checkbox_fri).isSelected()){
								System.out.println("fri already selected");}
							else{
								driverqa.findElement(EditRates.stay_checkbox_fri).click();
							}
						}
						else if(excel.getData(4, 15, 6).equalsIgnoreCase("no")){
							driverqa.findElement(EditRates.stay_checkbox_fri).isSelected();
							driverqa.findElement(EditRates.stay_checkbox_fri).click();
						}	
					
						if(excel.getData(4, 15, 7).equalsIgnoreCase("yes")){
							if(driverqa.findElement(EditRates.stay_checkbox_sat).isSelected()){
								System.out.println("sat already selected");}
							else{
								driverqa.findElement(EditRates.stay_checkbox_sat).click();
							}
						}
						else if(excel.getData(4, 15, 7).equalsIgnoreCase("no")){
							driverqa.findElement(EditRates.stay_checkbox_sat).isSelected();
							driverqa.findElement(EditRates.stay_checkbox_sat).click();
						}
					obj.Takesnap(driverqa, Config.SnapShotPath() + "/Rates/Stay_length_conditions_can_be_edited/After_edit.jpg");
						driverqa.findElement(EditRates.savenotechanges).click();
						Thread.sleep(8000);
					obj.Takesnap(driverqa, Config.SnapShotPath() + "/Rates/Stay_length_conditions_can_be_edited/Success.jpg");
					driverqa.findElement(EditRates.stay_close_pop).click();
					Thread.sleep(2000);
						String actualrateresult= driverqa.findElement(EditRates.stay_nts_updated).getText();
						   String rateexpectedresult = excel.getData(4,11,0);
						   Assert.assertEquals(actualrateresult, rateexpectedresult);
						   logger.info("Stay length conditions edited");
						   test.log(LogStatus.PASS, "Stay length conditions edited");
	           }

				catch (Exception e) {
					logger.info(e.getMessage());
					test.log(LogStatus.FAIL, e.getMessage());
					rep.endTest(test);
					rep.flush();
					Assert.assertTrue(false, e.getMessage());
					test.log(LogStatus.FAIL, "Navigating to ContractList");
					
				}
	 }
	 @AfterMethod
		public void getResult(ITestResult result) {
			if (result.getStatus() == ITestResult.FAILURE) {
				test.log(LogStatus.FAIL, result.getThrowable());
			}
			rep.endTest(test);
		}

		@AfterTest
		public void afterTest() {

			rep.endTest(test);
			rep.flush();
			driverqa.close();
		}}
