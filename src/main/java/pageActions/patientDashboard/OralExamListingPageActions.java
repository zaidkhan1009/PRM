package pageActions.patientDashboard;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import base.BaseClass;
import pages.patientDashboard.OralExamListingPage;

/**
 * 
 * @author Ajit Yadav
 *
 */
public class OralExamListingPageActions extends BaseClass {

	static OralExamListingPage oralExamListingPage = PageFactory.initElements(driver, OralExamListingPage.class);

	
	public static void checkedDataName() {
		BaseClass.waitForPageLoad();
		Assert.assertTrue(checkedElementDisplayed(oralExamListingPage.getToothNo()) && checkedElementDisplayed(oralExamListingPage.getToothSitePerio())
				&& checkedElementDisplayed(oralExamListingPage.getSoftTissue()) && checkedElementDisplayed(oralExamListingPage.getHardTissue())
				&& checkedElementDisplayed(oralExamListingPage.getCreatedBy()) && checkedElementDisplayed(oralExamListingPage.getNotes()));
	}

	public static void checkedViewDataName() {
		BaseClass.waitForPageLoad();
		Assert.assertTrue(checkedElementDisplayed(oralExamListingPage.getViewToothNo()) && checkedElementDisplayed(oralExamListingPage.getViewToothSitePerio())
				&& checkedElementDisplayed(oralExamListingPage.getViewSoftTissue()) && checkedElementDisplayed(oralExamListingPage.getViewHardTissue())
				&& checkedElementDisplayed(oralExamListingPage.getViewCreatedBy()) && checkedElementDisplayed(oralExamListingPage.getViewNotes()));
	}

	public static void verifyProvisinalsSingleTeethOralExamList(String teethNo, int NoProvisinals) {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(oralExamListingPage.getTitle());
		List<WebElement> webElement1 = driver.findElements(By.xpath("//span[contains(text(),'"+OralExamListingPage.getTodayDate()+"')]/../../..//span[contains(text(),'"+teethNo+"')]/../../..//td//span[@class='ng-binding ng-scope']"));
		int size = webElement1.size();
		System.out.println("The Size Is "+size);
		BaseClass.visibilityOfListLocated(webElement1);
		Assert.assertTrue(size == NoProvisinals);
	}

	public static void verifyProvisinalsMultipleTeethOralExamList(String teethNo1, String teethNo2, int NoProvisinals) {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(oralExamListingPage.getTitle());
		List<WebElement> webelement2 = driver.findElements(By.xpath("//span[contains(text(),'"+OralExamListingPage.getTodayDate()+"')]/../../..//span[contains(text(),'" + teethNo1
				+ "," + teethNo2
				+ "')]/../../..//td//span[@class='ng-binding ng-scope']"));
		BaseClass.visibilityOfListLocated(webelement2);
		Assert.assertTrue(webelement2.size() == NoProvisinals);
	}

	public static void oralExamViewPopup(String teethNo, int noProvisinals) {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(oralExamListingPage.getViewCreatedBy());
		List<WebElement> webElements = driver
				.findElements(By.xpath("//table[@class='table table-striped']//span[contains(text(),'"+teethNo+"')]/../../..//td//span[@class='ng-binding ng-scope']"));
		Assert.assertTrue(webElements.size() == noProvisinals);
	}

	public static void createdByOralExamViewPopup(String teethNo, String createdBy) {
		BaseClass.waitForPageLoad();
		Assert.assertTrue(driver.findElement(By.xpath("//table[@class='table table-striped']//span[contains(text(),'"
						+ teethNo + "')]/../../..//td[@class='ng-binding']"))
				.getText().equalsIgnoreCase(createdBy));
	}

	public static void noteOralExamViewPopup(String teethNo, String notes) {
		BaseClass.waitForPageLoad();
		Assert.assertTrue(driver
				.findElement(By.xpath("//table[@class='table table-striped']//span[contains(text(),'" + teethNo
						+ "')]/../../../following-sibling::tr//div[contains(@class,'textDataVisualizerFull')]"))
				.getText().contains(notes));
	}

	public static void verifyNoteOralExamList(String teethNo, String notes) {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(oralExamListingPage.getTitle());
		Assert.assertTrue(driver
				.findElement(By.xpath("//span[contains(text(),'" + teethNo
						+ "')]/../../following-sibling::td/div[contains(@class,'textDataVisualizer tdvNotes')]"))
				.getText().contains(notes));
	}

	public static void verifyViewBtnOnOralExamList() {
		BaseClass.waitForPageLoad();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		WebElement web = driver.findElement(By.xpath("(//div[@class='fnt_avgR dateClnc'])[1]"));
		String str = web.getText();
		String[] split = str.split(" ");
		String str1 = split[0];
		driver.findElement(By.xpath(
				"//span[contains(text(),'" + str1 + "')]/../following-sibling::div//span[@class='actn-icn view']"))
				.click();

	}

	public static void verifyEditBtnOnOralExamList() {
		BaseClass.waitForPageLoad();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		WebElement web = driver.findElement(By.xpath("(//div[@class='fnt_avgR dateClnc'])[1]"));
		String str = web.getText();
		String[] split = str.split(" ");
		String str1 = split[0];
		driver.findElement(By.xpath(
				"//span[contains(text(),'" + str1 + "')]/../following-sibling::div//span[@class='actn-icn edit']"))
				.click();

	}

	public static void verifyDeleteBtnOnOralExamList() {
		BaseClass.waitForPageLoad();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		WebElement web = driver.findElement(By.xpath("(//div[@class='fnt_avgR dateClnc'])[1]"));
		String str = web.getText();
		String[] split = str.split(" ");
		String str1 = split[0];
		driver.findElement(By.xpath(
				"//span[contains(text(),'" + str1 + "')]/../following-sibling::div//span[@class='actn-icn delete']"))
				.click();

	}

	public static void verifyPrintBtnOnOralExamList() {
		BaseClass.waitForPageLoad();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		WebElement web = driver.findElement(By.xpath("(//div[@class='fnt_avgR dateClnc'])[1]"));
		String str = web.getText();
		String[] split = str.split(" ");
		String str1 = split[0];
		driver.findElement(By.xpath(
				"//span[contains(text(),'" + str1 + "')]/../following-sibling::div//span[@class='actn-icn print']"))
				.click();
	}

	public static void verifyCreatedByInOralExamList(String teethNo, String userName) {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(oralExamListingPage.getTitle());
		Assert.assertTrue(driver
				.findElement(By.xpath(
						"//span[contains(text(),'" + teethNo + "')]/../../following-sibling::td[@class='ng-binding']"))
				.getText().equalsIgnoreCase(userName));
	}

	private static boolean checkedElementDisplayed(WebElement webelement) {
		return (webelement.isDisplayed());
	}
}
