package pageActions.patientDashboard;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import base.BaseClass;
import pages.patientDashboard.ChiefComplaintListingPage;

/**
 * 
 * @author Ajit Yadav
 *
 */
public class ChiefComplaintListingPageActions extends BaseClass {
	
	static ChiefComplaintListingPage chiefComplaintListingPage = PageFactory.initElements(driver, ChiefComplaintListingPage.class);

	
	/*checked column name at chief complaint listing*/
	public static void checkedMainlistDataName() {
//		BaseClass.waitForPageLoad();
		BaseClass.waitForSpinnerToDisappear();
		BaseClass.waitForElementVisibility(chiefComplaintListingPage.getChiefComplaintMainList(), 4000);
		Assert.assertTrue(checkedElementDisplayed(chiefComplaintListingPage.getChiefComplaintMainList()) && checkedElementDisplayed(chiefComplaintListingPage.getLocationMainList())
				&& checkedElementDisplayed(chiefComplaintListingPage.getIntensityMainList()) && checkedElementDisplayed(chiefComplaintListingPage.getPeriodMainList())
				&& checkedElementDisplayed(chiefComplaintListingPage.getNotesMainList()) && checkedElementDisplayed(chiefComplaintListingPage.getCreatedByMainList()));
	}

	/*checking added chief complaints at the chief complaints listing*/
	
	public static void chiefComplaintInMainList(String chiefComplaints) {
		BaseClass.waitForModalOverlayToDisappear();
		BaseClass.waitForSpinnerToDisappear();
		BaseClass.waitForPageToBecomeActive();
		BaseClass.waitForElementVisibility(chiefComplaintListingPage.getChiefComplaintsDates(),5000);
		WebElement element = driver.findElement(
				By.xpath("//th[text()='Chief Complaint']/../../following-sibling::tbody//td[@class='ng-binding']/..//td[contains(text(),'"
						+ chiefComplaints + "')]"));
		BaseClass.waitForElementVisibility(element, 4000);
		BaseClass.waitForElementToBeClickable(element);
		Assert.assertTrue(checkedElementDisplayed(element));
	}


//	public static void chiefComplaintInMainList(String chiefComplaints) {
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		BaseClass.waitForSpinnerToDisappear();
//		BaseClass.waitForPageToBecomeActive();
//		WebElement element = driver.findElement(
//				By.xpath("//th[text()='Chief Complaint']/../../following-sibling::tbody//td[@class='ng-binding']/..//td[contains(text(),'"
//						+ chiefComplaints + "')]"));
//		BaseClass.waitForElementVisibility(element, 4000);
//		BaseClass.waitForElementToBeClickable(element);
//		Assert.assertTrue(checkedElementDisplayed(element));
//	}

	/*checking deleted chief complaint at chief complaint listing*/
	
	public static void deletedChiefComplaintInMainList(String chiefComplaints) {
		BaseClass.waitForModalOverlayToDisappear();
		BaseClass.waitForSpinnerToDisappear();
		BaseClass.waitForPageToBecomeActive();
		BaseClass.waitForElementVisibility(chiefComplaintListingPage.getChiefComplaintsDates(),5000);
		WebElement element = driver.findElement(
				By.xpath("//th[text()='Chief Complaint']/../../following-sibling::tbody//td[contains(text(),'"
						+ chiefComplaints + "')]"));
		BaseClass.waitForElementToBeClickable(element);
		Assert.assertTrue(element.getAttribute("class").contains("deleted"));
	}

	/*checking intentsity at the chief complaint listing*/
	public static void intensityMainList(String chiefComplaints, String intentsity) {
		WebElement weblement;
//		BaseClass.waitForPageLoad();
		BaseClass.waitForSpinnerToDisappear();
		if (intentsity.equals("NA")) {
			weblement = driver.findElement(By
					.xpath("//div[contains(@class,'whtBox brdr_drk_gry tabularListing mrgn-btm')]//td[contains(text(),'"
							+ chiefComplaints
							+ "')]/following-sibling::td/span[contains(@data-ng-show,'cc.CCdetails.ChiefcomplaintIntensity')]"));
		} else {
			weblement = driver.findElement(By
					.xpath("//div[contains(@class,'whtBox brdr_drk_gry tabularListing mrgn-btm')]//td[contains(text(),'"
							+ chiefComplaints
							+ "')]/following-sibling::td/span[contains(@data-ng-repeat,'cc.CCdetails.ChiefcomplaintIntensity')]"));
		}
		Assert.assertTrue(weblement.getText().contains(intentsity));
	}

	/*checking  the location at chief complaint listing*/
	public static void locationMainList(String chiefComplaints, String location) {
		boolean flag = false;
		BaseClass.waitForPageLoad();
		if (location.equals("NA")) {
			WebElement weblement = driver.findElement(By
					.xpath("//div[contains(@class,'whtBox brdr_drk_gry tabularListing mrgn-btm')]//td[contains(text(),'"
							+ chiefComplaints
							+ "')]/following-sibling::td/span[contains(@data-ng-hide,'cc.CCdetails.Chiefcomplaintlocation.length')]"));
			Assert.assertTrue(weblement.getText().contains(location));
		} else {
			List<WebElement> elements = driver.findElements(By
					.xpath("//div[contains(@class,'whtBox brdr_drk_gry tabularListing mrgn-btm')]//td[contains(text(),'"
							+ chiefComplaints
							+ "')]/following-sibling::td//span[contains(@data-ng-class,'ccLoc.ccl_deletestatus')]"));
			for (int i = 0; elements.size() > i; i++) {
				String string = elements.get(i).getText();
				flag = string.contains(ChiefComplaintListingPage.getFirst()) || string.contains(ChiefComplaintListingPage.getSecond()) || string.contains(ChiefComplaintListingPage.getThird())
						|| string.contains(ChiefComplaintListingPage.getFourth()) || string.contains(ChiefComplaintListingPage.getFifth()) || string.contains(ChiefComplaintListingPage.getSixth())
						|| string.contains(ChiefComplaintListingPage.getSeventh()) || string.contains(ChiefComplaintListingPage.getEight());
				Assert.assertTrue(flag);
			}
		}
	}

	/*checking periods at chief complaint listing*/
	public static void periodsInMainList(String chiefComplaint, int expectedMonth, int expectedDay, String period) {
		boolean flag = false;
//		BaseClass.waitForPageLoad();
		BaseClass.waitForSpinnerToDisappear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		if (period.equals("NA")) {
			WebElement weblement = driver.findElement(By
					.xpath("//div[contains(@class,'whtBox brdr_drk_gry tabularListing mrgn-btm')]//td[contains(text(),'"
							+ chiefComplaint
							+ "')]/following-sibling::td//span[contains(@data-ng-show,'cc.CCdetails.ChiefcomplaintPeriod.length < 1')]"));
			flag = weblement.getText().contains(period);
		} else {
			List<WebElement> webelement = driver.findElements(By
					.xpath("//div[contains(@class,'whtBox brdr_drk_gry tabularListing mrgn-btm')]//td[contains(text(),'"
							+ chiefComplaint
							+ "')]/following-sibling::td//span[contains(@data-ng-class,'period.ccp_deletestatus')]"));
			for (int i = 0; webelement.size() > i; i++) {
				if (!webelement.get(i).getAttribute("class").contains("deleted")) {
					String actualString = webelement.get(i).getText();
					String expectedString = expectedMonth + " month(s) " + expectedDay + " day(s)";
					flag = actualString.equals(expectedString);
					break;
				}
			}
		}
		Assert.assertTrue(flag);
	}

	/*checking the chief complaint created by which doctor*/
	public static void chiefComplaintcreatedBy(String chiefComplaint,String username){
		BaseClass.waitForPageLoad();
		WebElement ele = driver.findElement(By.xpath("//div[contains(@class,'whtBox brdr_drk_gry tabularListing mrgn-btm')]//td[contains(text(),'"+chiefComplaint+"')]/following-sibling::td[contains(text(),'"+username+"')]"));
		Assert.assertTrue(checkedElementDisplayed(ele));
	}

	/*checking the notes at the chief complaint listing*/
	public static void notesMainList(String chiefComplaints, String note) {
		BaseClass.waitForPageLoad();
		WebElement weblement = driver.findElement(By.xpath("//td[contains(text(),'" + chiefComplaints
				+ "')]/following-sibling::td/div[contains(@class,'textDataVisualizer tdvNotes')]"));
		Assert.assertTrue(weblement.getText().contains(note));
	}

    /*checking the no record found message displayed*/
	public static void verifyNoRecordFoundMessage() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(chiefComplaintListingPage.getNoRecordFoundMsg());
		Assert.assertTrue(checkedElementDisplayed(chiefComplaintListingPage.getNoRecordFoundMsg()));
	}

	/*checking after added the chief complaint in multiple clinic*/
	public static void verifyChiefComplaintByClinicWise(String clinic) {
		BaseClass.waitForPageLoad();
		List<WebElement> web = driver
				.findElements(By.xpath("(//div[@class='fnt_avgR dateClnc']/span[@class='ng-binding'])[2]"));
		for (int i = 0; web.size() > i; i++) {
			boolean flag;
			if (flag = web.get(i).getText().contains(clinic)) {
				Assert.assertTrue(flag);
			} else {
				Assert.assertTrue(!web.get(i).getText().contains("NA") || web.get(i).getText().contains("null"));
				continue;
			}
		}
	}
    /*checking the date at chief complaint listing*/
	public static void verifyDateInView() {
	        BaseClass.waitForSpinnerToDisappear();
			String string = chiefComplaintListingPage.getDateInView().getText().trim();
			String[] split = string.split(" ");
			String actualDate = split[1];
			Date dat = new Date();
			String expectedDate = new SimpleDateFormat("dd-MM-yy").format(dat);
			boolean flag = expectedDate.equals(actualDate);
			Assert.assertTrue(flag);
	}
	
	
	
//	public static void verifyDateInView() {
//		BaseClass.waitForPageLoad();
//		try {
//			Thread.sleep(4000);
//			String string = chiefComplaintListingPage.getDateInView().getText().trim();
//			String[] split = string.split(" ");
//			String actualDate = split[1];
//			Date dat = new Date();
//			String expectedDate = new SimpleDateFormat("dd-MM-yy").format(dat);
//			boolean flag = expectedDate.equals(actualDate);
//			Assert.assertTrue(flag);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

	/*checking the column name at view popup*/
	public static void dataNameInView() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementVisibility(chiefComplaintListingPage.getChiefComplaintsInView(), 4000);
		Assert.assertTrue(checkedElementDisplayed(chiefComplaintListingPage.getChiefComplaintsInView()) && checkedElementDisplayed(chiefComplaintListingPage.getLocationInView())
				&& checkedElementDisplayed(chiefComplaintListingPage.getIntensityInView()) && checkedElementDisplayed(chiefComplaintListingPage.getPeriodsInView())
				&& checkedElementDisplayed(chiefComplaintListingPage.getCreatedByInView()));
	}

	/*checking the chief complaint at the view popup*/
	public static void checkedChiefComplaintInView(String chiefComplaint) {
		BaseClass.waitForPageLoad();
		WebElement webelement = driver.findElement(
				By.xpath("//tbody[@data-ng-repeat='input in viewList']//td[text()='" + chiefComplaint + "']"));
		Assert.assertTrue(checkedElementDisplayed(webelement));
	}

	/*checked deleted chief complaint at view popup*/
	public static void deletedChiefComplaintInView(String chiefComplaint) {
		BaseClass.waitForPageLoad();
		WebElement webelement = driver.findElement(
				By.xpath("//tbody[@data-ng-repeat='input in viewList']//td[text()='" + chiefComplaint + "']"));
		Assert.assertTrue(webelement.getAttribute("class").contains("deleted"));
	}

	/*checked location in view popup*/
	public static void locationInView(String chiefComplaint, String location) {
		BaseClass.waitForPageLoad();
		boolean flag;
		if (location.equals("NA")) {
			WebElement weblement = driver
					.findElement(By.xpath("//tbody[@data-ng-repeat='input in viewList']//td[text()='" + chiefComplaint
							+ "']/following-sibling::td//span[contains(@data-ng-hide,'input.CCdetails.Chiefcomplaintlocation.length')]"));
			Assert.assertTrue(weblement.getText().contains(location));
		} else {
			List<WebElement> elements = driver
					.findElements(By.xpath("//tbody[@data-ng-repeat='input in viewList']//td[text()='" + chiefComplaint
							+ "']/following-sibling::td//span[contains(@data-ng-class,'ccLoc.ccl_deletestatus')]"));
			for (int i = 0; elements.size() > i; i++) {
				String string = elements.get(i).getText();
				flag = string.contains(ChiefComplaintListingPage.getFirst()) || string.contains(ChiefComplaintListingPage.getSecond()) || string.contains(ChiefComplaintListingPage.getThird())
						|| string.contains(ChiefComplaintListingPage.getFourth()) || string.contains(ChiefComplaintListingPage.getFifth()) || string.contains(ChiefComplaintListingPage.getSixth())
						|| string.contains(ChiefComplaintListingPage.getSeventh()) || string.contains(ChiefComplaintListingPage.getEight());
				Assert.assertTrue(flag);
			}
		}

	}

	/*checked intentsity in view popup*/
	public static void intentsityInView(String chiefComplaint, String intentsity) {
		BaseClass.waitForPageLoad();
		WebElement weblement;
		if (intentsity.equals("NA")) {
			weblement = driver
					.findElement(By.xpath("//tbody[@data-ng-repeat='input in viewList']//td[text()='" + chiefComplaint
							+ "']/following-sibling::td//span[contains(@data-ng-show,'input.CCdetails.ChiefcomplaintIntensity.length < 1')]"));
		} else {
			weblement = driver
					.findElement(By.xpath("//tbody[@data-ng-repeat='input in viewList']//td[text()='" + chiefComplaint
							+ "']/following-sibling::td//span[contains(@data-ng-repeat,'intensity in input.CCdetails.ChiefcomplaintIntensity')]"));
		}
		Assert.assertTrue(weblement.getText().contains(intentsity));
	}

	/*checking the username at the view popup*/
	public static void userNameInView(String chiefComplaint, String userName) {
		BaseClass.waitForPageLoad();
		WebElement weblement = driver
				.findElement(By.xpath("(//tbody[@data-ng-repeat='input in viewList']//td[text()='" + chiefComplaint
						+ "']/following-sibling::td[contains(@data-ng-class,'input.CCdetails.Chiefcomplaint.cc_deletestate')])[4]"));
		BaseClass.WaitTillElementIsPresent(weblement);
		Assert.assertTrue(weblement.getText().equalsIgnoreCase(userName));
	}

	/*checking the nootes in view popup*/
	public static void notesInView(String chiefComplaint, String note) {
		BaseClass.waitForPageLoad();
		WebElement weblement = driver
				.findElement(By.xpath("//tbody[@data-ng-repeat='input in viewList']//td[text()='"+chiefComplaint+"']/../following-sibling::tr//div[contains(@class,'textDataVisualizerFull')]"));
		Assert.assertTrue(weblement.getText().trim().contains(note));
	}

	/*checking the periods in view popup*/
	public static void periodsInView(String chiefComplaint, int expectedMonth, int expectedDay, String period) {
		boolean flag = false;
		BaseClass.waitForPageLoad();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		if (period.equals("NA")) {
			WebElement weblement = driver
					.findElement(By.xpath("//tbody[@data-ng-repeat='input in viewList']//td[text()='" + chiefComplaint
							+ "']/following-sibling::td/span[contains(@data-ng-show,'input.CCdetails.ChiefcomplaintPeriod.length < 1')]"));
			flag = weblement.getText().contains(period);
		} else {
			List<WebElement> webelement = driver
					.findElements(By.xpath("//tbody[@data-ng-repeat='input in viewList']//td[text()='" + chiefComplaint
							+ "']/following-sibling::td//span[contains(@data-ng-class,'period.ccp_deletestatus')]"));
			for (int i = 0; webelement.size() > i; i++) {
				if (!webelement.get(i).getAttribute("class").contains("deleted")) {
					String actualString = webelement.get(i).getText();
					String expectedString = expectedMonth + " month(s) " + expectedDay + " day(s)";
					flag = actualString.equals(expectedString);
					break;
				}
			}
		}
		Assert.assertTrue(flag);
	}

	/*closing the view popup*/
	public static void closeViewPopup() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(chiefComplaintListingPage.getCloseViewbutton());
		chiefComplaintListingPage.getCloseViewbutton().click();
	}

	/*checking header of the view popup*/
	public static void viewChiefComplaint(){
		BaseClass.waitForPageLoad();
		Assert.assertTrue(checkedElementDisplayed(chiefComplaintListingPage.getHeaderViewPopup()));
	}
	private static boolean checkedElementDisplayed(WebElement webelement) {
		return (webelement.isDisplayed());
	}

}
