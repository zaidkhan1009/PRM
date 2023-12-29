package pageActions.doctorDashboard;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import base.BaseClass;
import pages.doctorDashboard.Login;
import pages.doctorDashboard.MiscellaneousCallPage;

public class MiscellaneousCallPageActions extends BaseClass  {
	
	static Login loginPage = PageFactory.initElements(driver, Login.class);
	static MiscellaneousCallPage miscellaneousCallPage = PageFactory.initElements(driver, MiscellaneousCallPage.class);


	/*-- Checking the All Button shown in New Miscellaneous Call Page --*/
	public static void checkedAllBtnInMiscellaneousCallAdd() {
		BaseClass.waitForPageLoad();
		Assert.assertTrue(checkedWebElementDisplayed(miscellaneousCallPage.getType()) && checkedWebElementDisplayed(miscellaneousCallPage.getInfo()) &&checkedWebElementDisplayed(miscellaneousCallPage.getDisposition()) &&checkedWebElementDisplayed(miscellaneousCallPage.getWorkAreaBtn()) && checkedWebElementDisplayed(miscellaneousCallPage.getMiscCallsListBtn()) && checkedWebElementDisplayed(miscellaneousCallPage.getSubscribersBtn())
				&& checkedWebElementDisplayed(miscellaneousCallPage.getSaveBtn()) && checkedWebElementDisplayed(miscellaneousCallPage.getResetBtn()) && checkedWebElementDisplayed(miscellaneousCallPage.getCancelBtn()));
	}

	/*-- Checking all options in Type DropDown --*/
	public static void checkTypeDropDwn() {
		BaseClass.waitForPageLoad();
		boolean flag1, flag2, match = false;
		flag1 = checkedWebElementDisplayed(miscellaneousCallPage.getTypeDrpDwn());
		String[] exp = {"Select Type","Inbound", "Outbound" };
		Select sel = new Select(miscellaneousCallPage.getTypeDrpDwn());
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

	/*-- Select one option from Type DropDown --*/
	public static void selectType(String typeValue) {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BaseClass.waitForPageLoad();
		BaseClass.selectFromDropDownByVisibleText(miscellaneousCallPage.getTypeDrpDwn(), typeValue);
	}

	/*-- Checking duration TextField---*/
	public static void checkDuration() {
		BaseClass.waitForPageLoad();
		Assert.assertTrue(checkedWebElementDisplayed(miscellaneousCallPage.getDuration()) && checkedWebElementDisplayed(miscellaneousCallPage.getDurationTxtBx())
				&& miscellaneousCallPage.getDurationTxtBx().getAttribute("placeholder").contains("minutes"));
	}

	/*-- Enter time in miscellaneousCallPage.getDuration() TextField---*/
	public static void addDuration(String duration) {
		BaseClass.waitForPageLoad();
		miscellaneousCallPage.getDurationTxtBx().clear();
		miscellaneousCallPage.getDurationTxtBx().sendKeys(duration);
	}

	/*-- Checking all options in Disposition DropDown --*/
	public static void checkDispositionDropDown() {
		BaseClass.waitForPageLoad();
		boolean flag1, flag2, match = false;
		flag1 = checkedWebElementDisplayed(miscellaneousCallPage.getDispositionDrpDwn());
		String[] exp = { "Select Disposition", "Busy", "Call Disconnected", "Call Me Back", "Clove Staff/Clinic",
				"Get Back To Patient", "Information Provided", "Invalid Number", "No Connect", "No Response",
				"Not Interested", "Patient Will Call", "Test Call", "Wrong Number" };
		Select sel = new Select(miscellaneousCallPage.getDispositionDrpDwn());
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

	/*-- Select one option from Disposition DropDown --*/
	public static void selectDisposition(String dispositionValue) {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BaseClass.waitForPageLoad();
		BaseClass.selectFromDropDownByVisibleText(miscellaneousCallPage.getDispositionDrpDwn(), dispositionValue);
	}

	/*-- Checking all options in Info DropDown --*/
	public static void checkInfoDropDown() {
		BaseClass.waitForPageLoad();
		boolean flag1, flag2, match = false;
		flag1 = checkedWebElementDisplayed(miscellaneousCallPage.getInfoDrpDwn());
		String[] exp = { "Select Info", "Clove Clinic", "Clove Staff", "External Business", "Head Office",
				"Job Enquiry", "Location Query", "Test Call" };
		Select sel = new Select(miscellaneousCallPage.getInfoDrpDwn());
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

	/*-- Select one option from Info DropDown --*/
	public static void selectInfo(String infoValue) {
		BaseClass.waitForPageLoad();
		BaseClass.selectFromDropDownByVisibleText(miscellaneousCallPage.getInfoDrpDwn(), infoValue);
	}

	/*-- Checking Name TextField---*/
	public static void checkNameTxtBx() {
		BaseClass.waitForPageLoad();
		Assert.assertTrue(checkedWebElementDisplayed(miscellaneousCallPage.getName()) && checkedWebElementDisplayed(miscellaneousCallPage.getNameTxtBx())
				&& miscellaneousCallPage.getNameTxtBx().getAttribute("placeholder").contains("name"));
	}

	/*-- Enter Name in Name TextField---*/
	public static void enterNameInTxtBx(String name) {
		BaseClass.waitForPageLoad();
		miscellaneousCallPage.getNameTxtBx().clear();
		miscellaneousCallPage.getNameTxtBx().sendKeys(name);
	}

	/*-- Checking mobile TextField---*/
	public static void checkMobileTxtBx() {
		BaseClass.waitForPageLoad();
		Assert.assertTrue(checkedWebElementDisplayed(miscellaneousCallPage.getMobile()) && checkedWebElementDisplayed(miscellaneousCallPage.getMobileTxtBx())
				&& miscellaneousCallPage.getMobileTxtBx().getAttribute("placeholder").contains("enter 10 digit mobile no"));
	}

	/*-- Enter Mobile Number in Mobile TextField---*/
	public static void enterMobileInTxtBx(String mobile) {
		BaseClass.waitForPageLoad();
		miscellaneousCallPage.getMobileTxtBx().clear();
		miscellaneousCallPage.getMobileTxtBx().sendKeys(mobile);
	}

	/*-- Checking Notes TextField---*/
	public static void checkNotesTxtBx() {
		BaseClass.waitForPageLoad();
		Assert.assertTrue(checkedWebElementDisplayed(miscellaneousCallPage.getNotes()) && checkedWebElementDisplayed(miscellaneousCallPage.getNotesTxtBx()) &&
				miscellaneousCallPage.getNotesTxtBx().getAttribute("placeholder").contains("notes"));
	}

	/*-- Enter Data in Notes TextField---*/
	public static void addNotes(String notes) {
		BaseClass.waitForPageLoad();
		miscellaneousCallPage.getNotesTxtBx().clear();
		miscellaneousCallPage.getNotesTxtBx().sendKeys(notes);
	}

	/*-- Click on Save button shown in New Miscellaneous Call page---*/
	public static void clickOnSave() {
		BaseClass.waitForPageLoad();
		miscellaneousCallPage.getSaveBtn().click();
		BaseClass.waitForSpinnerToDisappear();
	}

	/*-- Click on Reset button shown in New Miscellaneous Call page---*/
	public static void clickOnResetBtn() {
		BaseClass.waitForElementToBeClickable(miscellaneousCallPage.getResetBtn());
		miscellaneousCallPage.getResetBtn().click();
	}

	/*-- Click on Cancel button shown in New Miscellaneous Call page---*/
	public static void clickOnCancelBtn(){
		BaseClass.waitForPageLoad();
		miscellaneousCallPage.getCancelBtn().click();
		BaseClass.waitForSpinnerToDisappear();
	}

	/*-- Click on Subscriber button shown in New Miscellaneous Call page---*/
	public static void clickOnSubscribers() {
		BaseClass.waitForPageLoad();
		miscellaneousCallPage.getSubscribersBtn().click();
	}

	/*-- Click on Miscellaneous Add call button shown in Subscriber page---*/
	public static void clickMiscsCallAddBtn() {
		BaseClass.waitForSpinnerToDisappear();
		BaseClass.waitForElementToBeClickable(miscellaneousCallPage.getMiscCallsAddBtn());
		miscellaneousCallPage.getMiscCallsAddBtn().click();
	}

	/*-- Click on Miscellaneous Call listing button shown in New Miscellaneous Call page---*/
	public static void clickMiscCallListBtn() {
		BaseClass.waitForSpinnerToDisappear();
		BaseClass.waitForElementToBeClickable(miscellaneousCallPage.getMiscCallsListBtn());
		miscellaneousCallPage.getMiscCallsListBtn().click();
	}

	/*-- Click on Work Area button shown in New Miscellaneous Call page---*/
	public static void clickWorkAreaBtn() {
		BaseClass.waitForPageLoad();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		miscellaneousCallPage.getWorkAreaBtn().click();
	}

	/*-- Verifying My Work Page show after click on My Work Area button---*/
	public static void toverifyMyWorkAreaHomePage() {
		BaseClass.waitForPageLoad();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertTrue(driver.getTitle().contains("My Work Area"));
	}

	/*-- Click on DashBoard button shown on My Work Area Page---*/
	public static void clickOnDashboardBtnShowMyWorkArea() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(miscellaneousCallPage.getDashBoardBtn());
		miscellaneousCallPage.getDashBoardBtn().click();
	}

	/*--Check Error messages for Disposition---*/
	public static void checkedErrorDisposition(String errorMsg) {
		BaseClass.waitForPageLoad();
		Assert.assertTrue(checkedWebElementDisplayed(miscellaneousCallPage.getErrorDispositionMsg())&& miscellaneousCallPage.getErrorDispositionMsg().getText().contains(errorMsg));
	}

	/*--Check Error messages for Info---*/
	public static void checkedErrorInfo(String errorMsg) {
		BaseClass.waitForPageLoad();
		Assert.assertTrue(checkedWebElementDisplayed(miscellaneousCallPage.getErrorInfoMsg())&& miscellaneousCallPage.getErrorInfoMsg().getText().contains(errorMsg));
	}

	/*--Check Error messages for Name---*/
	public static void checkedErrorName(String errorMsg) {
		BaseClass.waitForPageLoad();
		Assert.assertTrue(checkedWebElementDisplayed(miscellaneousCallPage.getErrorNameMsg())&& miscellaneousCallPage.getErrorNameMsg().getText().contains(errorMsg));
	}

	/*--Check Error messages for Mobile---*/
	public static void checkedErrorMobile(String errorMsg) {
		BaseClass.waitForPageLoad();
		Assert.assertTrue(checkedWebElementDisplayed(miscellaneousCallPage.getErrorMobileMsg())&& miscellaneousCallPage.getErrorMobileMsg().getText().contains(errorMsg));
	}

	private static boolean checkedWebElementDisplayed(WebElement ele) {
		return (ele.isDisplayed());
	}

}
