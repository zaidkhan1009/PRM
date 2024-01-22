package pageActions.doctorDashboard;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


import base.BaseClass;
import pages.doctorDashboard.Login;
import pages.doctorDashboard.MiscellaneousCallListingPage;

/*
 *  @author NIKHIL TYAGI*
 */

public class     MiscellaneousCallListingPageActions extends BaseClass  {
	
	static Login loginPage = PageFactory.initElements(driver, Login.class);
	static MiscellaneousCallListingPage miscellaneousCallListingPage = PageFactory.initElements(driver, MiscellaneousCallListingPage.class);

	
	/*-- Checking the All Button shown in Miscellaneous Call listing --*/
	public static void checkedAllBtnInMiscellaneousCallListing() {
		BaseClass.waitForPageLoad();
		Assert.assertTrue(checkedWebElementDisplayed(miscellaneousCallListingPage.getSearchBtn()) && checkedWebElementDisplayed(miscellaneousCallListingPage.getResetBtn()) &&
				checkedWebElementDisplayed(miscellaneousCallListingPage.getDashBoardBtn()) && checkedWebElementDisplayed(miscellaneousCallListingPage.getSubscribersBtn()));
	}

	/*-- Click the Subscribers Button shown in Miscellaneous Call listing --*/
	public static void clickOnSubscribers() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(miscellaneousCallListingPage.getSubscribersBtn());
		miscellaneousCallListingPage.getSubscribersBtn().click();
	}
	
	public static void clickOnAddNew() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForSpinnerToDisappear();
		BaseClass.waitForElementToBeClickable(miscellaneousCallListingPage.getAddNewBtnOnMiscList());
		miscellaneousCallListingPage.getAddNewBtnOnMiscList().click();
	}

	/*-- Click the Miscellaneous Call list Button shown in Subscriber listing --*/
	public static void clickMiscsCallListBtn() {
		BaseClass.WaitTillElementIsPresent(miscellaneousCallListingPage.getMiscCallsListBtn());
		BaseClass.waitForPageLoad();
		miscellaneousCallListingPage.getMiscCallsListBtn().click();
	}

	/*-- Click the DashhBoard Button shown in Miscellaneous Call listing --*/
	public static void clickOnDashboardBtn() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(miscellaneousCallListingPage.getDashBoardBtn());
		miscellaneousCallListingPage.getDashBoardBtn().click();
	}

	/*-- Click the Reset Button shown in Miscellaneous Call listing --*/
	public static void clickOnResetBtn() {
		BaseClass.waitForPageLoad();
//		BaseClass.waitForElementToBeClickable(miscellaneousCallListingPage.getResetBtn());
		miscellaneousCallListingPage.getResetBtn().click();
		BaseClass.waitForSpinnerToDisappear();
	}

	/*-- Click the Search Button shown in Miscellaneous Call listing --*/
	public static void clickSearchBtn()
	{
		BaseClass.waitForPageLoad();
		BaseClass.waitForModalOverlayToDisappear();
		BaseClass.waitForElementToBeClickable(miscellaneousCallListingPage.getSearchBtn());
		miscellaneousCallListingPage.getSearchBtn().click();
		BaseClass.waitForSpinnerToDisappear();
	}

	/*-- Checking All Head after enter new Call shown in Miscellaneous Call listing --*/
	public static void checkedMainListDataName() {
		BaseClass.waitForPageLoad();
		Assert.assertTrue(checkedWebElementDisplayed(miscellaneousCallListingPage.getDateOnMiscList()) && checkedWebElementDisplayed(miscellaneousCallListingPage.getNameMainList()) &&
				checkedWebElementDisplayed(miscellaneousCallListingPage.getMobileMainList()) && checkedWebElementDisplayed(miscellaneousCallListingPage.getTypeMainList()) && checkedWebElementDisplayed(miscellaneousCallListingPage.getDispositionMainList()) &&
				checkedWebElementDisplayed(miscellaneousCallListingPage.getInfoMainList()) && checkedWebElementDisplayed(miscellaneousCallListingPage.getCallerMainList()) && checkedWebElementDisplayed(miscellaneousCallListingPage.getNotesMainList()));
	}

	/*-- Verifying the Date and Time show in Main List --*/
	public static void checkDateTimeMainList(String mobno,String expectedDate,String expectedTime) {
		BaseClass.waitForPageLoad();
		BaseClass.waitForSpinnerToDisappear();
		WebElement ele = driver.findElement(By.xpath("//td[text()='"+mobno+"']/preceding-sibling::td/div"));
		String str = ele.getText();
		System.out.println(str);
		String date=str.split("\n")[0].trim();
		String time=str.split("\n")[1].trim();
		System.out.println("*******"+date);
		System.out.println("##########*"+time);
		System.out.println("%%%%%%%%"+expectedTime);
		String dateTime = date+" "+time;
		try {
			SimpleDateFormat fmt = new SimpleDateFormat("dd-mm-yy h:mm");
			Date actualDateTime = fmt.parse(dateTime);
			Date expectedDateTime = fmt.parse(expectedDate+" "+expectedTime);

			System.out.println("***********"+actualDateTime);
			System.out.println("***********"+expectedDateTime);
			
			if (actualDateTime.equals(expectedDateTime)) {
				System.out.println("Date and Time of main list verified:- "+actualDateTime);
			}
			else
				Assert.assertFalse(true);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*-- Verifying the Name shown in Miscellaneous Call listing --*/
	public static void nameInMainList(String todayDate,String mobno, String name) {
		BaseClass.waitForPageLoad();
		WebElement ele = driver.findElement(By.xpath("//span[text()='"+todayDate+"']/../../following-sibling::td[text()='"+mobno+"']/preceding-sibling::td[text()='"+name+"']"));
		String actual_name = ele.getText();
		Assert.assertEquals(actual_name, name);
	}

	/*-- Verifying the Mobile No,Type,Disposition,Info,Caller shown in Miscellaneous Call listing --*/
	public static void miscellaneousCallList(String todayDate,String mobno, String misc) {
		BaseClass.waitForPageLoad();
		WebElement ele = driver.findElement(By.xpath("//span[text()='"+todayDate+"']/../../following-sibling::td[text()='"+mobno+"']/following-sibling::td[text()='"+misc+"']"));
		String actual_data = ele.getText();
		Assert.assertEquals(actual_data, misc);
	}

	/*-- Verifying the Notes shown in Miscellaneous Call listing --*/
	public static void notesCallList(String todayDate,String mobno,String notes) {
		BaseClass.waitForPageLoad();
		WebElement ele = driver.findElement(By.xpath("//span[text()='"+todayDate+"']/../../following-sibling::td[text()='"+mobno+"']/following-sibling::td/div[text()='"+notes+"']"));
		String actual_data = ele.getText();
		Assert.assertEquals(actual_data, notes);
	}

	/*-- Validate the Successful Msg --*/
	public static void verifySuccessfullMessage(){
		BaseClass.waitForPageLoad();
		BaseClass.waitForSpinnerToDisappear();
		BaseClass.softAssert().assertTrue(checkedWebElementDisplayed(miscellaneousCallListingPage.getSuccessfullMsg()));
		
	}

	/*-- Checking All options in Type DropDown filter--*/
	public static void checkTypeDropDwn() {
		BaseClass.waitForPageLoad();
		boolean flag1, flag2, match = false;
		flag1 = checkedWebElementDisplayed(miscellaneousCallListingPage.getTypeDrpDwn());
		String[] exp = {"Select Type","Inbound", "Outbound" };
		Select sel = new Select(miscellaneousCallListingPage.getTypeDrpDwn());
		List<WebElement> options = sel.getOptions();
		for (WebElement we : options) {
			for (int i = 0; i < exp.length; i++) {
				if (flag2 = we.getText().equals(exp[i])) {
					match = flag1 && flag2;
				}
			}
			Assert.assertTrue(match);
		}
	}

	/*-- Select any one option from Type DropDown filter--*/
	public static void selectType(String typeValue) {
		BaseClass.waitForSpinnerToDisappear();
		BaseClass.WaitTillElementIsPresent(miscellaneousCallListingPage.getTypeDrpDwn());
		BaseClass.selectFromDropDownByVisibleText(miscellaneousCallListingPage.getTypeDrpDwn(), typeValue);
	}

	/*-- Checking All options in Disposition DropDown filter--*/
	public static void checkDispositionDropDown() {
		BaseClass.waitForPageLoad();
		boolean flag1, flag2, match = false;
		flag1 = checkedWebElementDisplayed(miscellaneousCallListingPage.getDispDrpDwn());
		String[] exp = { "Select Disposition", "Busy", "Call Disconnected", "Call Me Back", "Clove Staff/Clinic",
				"Get Back To Patient", "Information Provided", "Invalid Number", "No Connect", "No Response",
				"Not Interested", "Patient Will Call", "Test Call", "Wrong Number" };
		Select sel = new Select(miscellaneousCallListingPage.getDispDrpDwn());
		List<WebElement> options = sel.getOptions();
		for (WebElement we : options) {
			for (int i = 0; i < exp.length; i++) {
				if (flag2 = we.getText().equals(exp[i])) {
					match = flag1 && flag2;
				}
			}
			Assert.assertTrue(match);
		}
	}

	/*-- Select any one option from Disposition DropDown filter --*/
	public static void selectDisposition(String dispositionValue) {
		BaseClass.waitForSpinnerToDisappear();
		BaseClass.waitForElementToBeClickable(miscellaneousCallListingPage.getTypeDrpDwn());
		BaseClass.selectFromDropDownByVisibleText(miscellaneousCallListingPage.getDispDrpDwn(), dispositionValue);
	}

	/*-- Checking All options in CallerName DropDown filter --*/
	public static void checkCallerNameDropDown() {
		BaseClass.waitForPageLoad();
		boolean flag1, flag2, match = false;
		flag1 = checkedWebElementDisplayed(miscellaneousCallListingPage.getCallerNameDrpDwn());
		String[] exp = { "Select Caller Name", "A Sinha", "AlinaK", "Anu B", "ArunimaD",
				"AyushiA", "CCE", "Chirag D", "DeepaliC", "DHC 1",
				"DHC 2", "DHC 3", "DHC 4", "DHC 5","DHC 6","DivaD" };
		Select sel = new Select(miscellaneousCallListingPage.getCallerNameDrpDwn());
		List<WebElement> options = sel.getOptions();
		for (WebElement we : options) {
			for (int i = 0; i < exp.length; i++) {
				if (flag2 = we.getText().equals(exp[i])) {
					match = flag1 && flag2;
				}
			}
			Assert.assertTrue(match);
		}
	}

	/*-- Select any one option from Caller DropDown filter--*/
	public static void selectCallerName(String callerNameValue) {
		BaseClass.waitForSpinnerToDisappear();
		BaseClass.WaitTillElementIsPresent(miscellaneousCallListingPage.getCallerNameDrpDwn());
		BaseClass.selectFromDropDownByVisibleText(miscellaneousCallListingPage.getCallerNameDrpDwn(), callerNameValue);
	}

	/*-- Checking All TextBox filter--*/
	public static void checkAllTextBoxFilter() {
		BaseClass.waitForPageLoad();
		Assert.assertTrue(checkedWebElementDisplayed(miscellaneousCallListingPage.getDetailsTxtBx()) && miscellaneousCallListingPage.getDetailsTxtBx().getAttribute("placeholder").contains("details")
				&& checkedWebElementDisplayed(miscellaneousCallListingPage.getFromDateBtn())&& miscellaneousCallListingPage.getFromDateBtn().getAttribute("placeholder").contains("from (dd-mm-yy)")
				&& checkedWebElementDisplayed(miscellaneousCallListingPage.getToDateBtn())&& miscellaneousCallListingPage.getToDateBtn().getAttribute("placeholder").contains("to (dd-mm-yy)"));
	}

	/*-- Enter data in details filter--*/
	public static void addDetails(String name) {
		BaseClass.waitForPageLoad();
		BaseClass.waitForSpinnerToDisappear();
		BaseClass.waitForElementToBeClickable(miscellaneousCallListingPage.getDetailsTxtBx());
		miscellaneousCallListingPage.getDetailsTxtBx().clear();
		miscellaneousCallListingPage.getDetailsTxtBx().sendKeys(name);
	}

	/*-- Enter date in From Date filter--*/
	public static void AddFromDate(String date)
	{
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(miscellaneousCallListingPage.getFromDateBtn());
		miscellaneousCallListingPage.getFromDateBtn().sendKeys(date);
	}

	/*-- Enter date in To Date filter--*/
	public static void AddToDate(String date)
	{
		BaseClass.waitForPageLoad();
		miscellaneousCallListingPage.getToDateBtn().sendKeys(date);
	}

	public static void verifyDataOnMiscellaneousCallListingOnFilter(String appliedFilterValue,int appliedFilterDataColumn) {
		if(miscellaneousCallListingPage.getListOfPages().size()>0) {
			int totalNumberOfPages=Integer.valueOf(miscellaneousCallListingPage.getListOfPages().get(miscellaneousCallListingPage.getListOfPages().size()-1).getText());
			int currentPage=1;
			while(currentPage<=totalNumberOfPages) {
				for(WebElement callRecord:miscellaneousCallListingPage.getCallRecordOnListing()) {
					List<WebElement> callDetailsList=callRecord.findElements(By.tagName("td"));
					String actualFilterDataValue=callDetailsList.get(appliedFilterDataColumn).getText().toLowerCase();
					System.out.println("******* actual displayed value on Screen"+actualFilterDataValue);
					System.out.println("******* actual search value"+appliedFilterValue);
					Assert.assertTrue(actualFilterDataValue.contains(appliedFilterValue.toLowerCase()));
					
				}
				BaseClass.waitForElementToBeClickable(miscellaneousCallListingPage.getNextPageButton());
				miscellaneousCallListingPage.getNextPageButton().click();
				currentPage++;
			}
		}
		else {
			Assert.assertTrue(miscellaneousCallListingPage.getNoRecordFoundMsg().isDisplayed());
		}
		
	}
	
	public static void verifyDataOnCallTypeFilter(String callType) {
		verifyDataOnMiscellaneousCallListingOnFilter(callType, 3);
		
	}
	
	public static void verifyDataOnCallDispositionFilter(String callDisposition) {
		verifyDataOnMiscellaneousCallListingOnFilter(callDisposition, 4);
	}
	
	public static void verifyDataOnCallerNameFilter(String callerName) {
		verifyDataOnMiscellaneousCallListingOnFilter(callerName, 6);
	}
	
	public static void verifyDataOnMobileNumberSearchFilter(String searchedMobileNumber) {
		verifyDataOnMiscellaneousCallListingOnFilter(searchedMobileNumber, 2);
	}
	
	public static void verifyDataOnNameSearchFilter(String searchedName) {
		verifyDataOnMiscellaneousCallListingOnFilter(searchedName, 1);
	}
	
	
	public static void veifyDataOnDateFilter(String fromDate, String toDate) {
		if (miscellaneousCallListingPage.getListOfPages().size() > 0) {
			int totalNumberOfPages = Integer.valueOf(miscellaneousCallListingPage.getListOfPages().get(miscellaneousCallListingPage.getListOfPages().size() - 1).getText());
			int currentPage = 1;
			while (currentPage <= totalNumberOfPages) {
				for (WebElement callRecord : miscellaneousCallListingPage.getCallRecordOnListing()) {
					List<WebElement> callDetailsList = callRecord.findElements(By.tagName("td"));
					String dateOnCallRecord = callDetailsList.get(0).findElement(By.xpath("div/span")).getText().trim();
					try {
						SimpleDateFormat fmt = new SimpleDateFormat("dd-MM-yy");
						Date actualDateOnCallRecord = fmt.parse(dateOnCallRecord);
						Date expectedFromDate = fmt.parse(fromDate);
						Date expectedToDate = fmt.parse(toDate);
						System.out.println("actual Date"+dateOnCallRecord);
						System.out.println("actual Date"+actualDateOnCallRecord);
						System.out.println("fromDate"+expectedFromDate);
						System.out.println("to Date"+expectedToDate);
						System.out.println("compare value with from Date "+actualDateOnCallRecord.compareTo(expectedFromDate)+"compare value with to Date "+actualDateOnCallRecord.compareTo(expectedToDate));
						if (actualDateOnCallRecord.compareTo(expectedFromDate) >= 0
								&& actualDateOnCallRecord.compareTo(expectedToDate) <= 0) {
							System.out.println("Date is between FromDate and toDate");
						} else {
							System.out.println("Date is NOT between FromDate and toDate");
							Assert.assertFalse(true);
						}
					}

					catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				BaseClass.waitForElementToBeClickable(miscellaneousCallListingPage.getNextPageButton());
				miscellaneousCallListingPage.getNextPageButton().click();
				currentPage++;
			}
		} else {
			Assert.assertTrue(miscellaneousCallListingPage.getNoRecordFoundMsg().isDisplayed());
		}

	}
	
	public static void verifyDateRangeErrorMsg() {
		BaseClass.WaitTillElementIsPresent(miscellaneousCallListingPage.getDateRangeMoreErrorMsg());
		Assert.assertTrue(miscellaneousCallListingPage.getDateRangeMoreErrorMsg().isDisplayed());
		BaseClass.waitTillInvisiblityOfElement(miscellaneousCallListingPage.getDateRangeMoreErrorMsg());
		
	}
	
	public static void verifyFromDateExceedToDateErrorMsg() {
		BaseClass.WaitTillElementIsPresent(miscellaneousCallListingPage.getFromDateExceedToDateMsg());
		Assert.assertTrue(miscellaneousCallListingPage.getFromDateExceedToDateMsg().isDisplayed());
		
	}
	
	private static boolean checkedWebElementDisplayed(WebElement ele) {
		return (ele.isDisplayed());
	}

}
