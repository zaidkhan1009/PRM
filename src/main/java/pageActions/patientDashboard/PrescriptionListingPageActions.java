package pageActions.patientDashboard;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import base.BaseClass;
import pages.patientDashboard.PrescriptionListingPage;

public class PrescriptionListingPageActions extends BaseClass {
	
	static PrescriptionListingPage prescriptionListingPage = PageFactory.initElements(driver, PrescriptionListingPage.class);

	
	/*-------------Functions------------*/

	/*Verifying Prescription Listing Page-----*/
	public static void verifyPrescriptionListHomePage() {
		try {
			Thread.sleep(3000);
			BaseClass.waitForPageLoad();
			Assert.assertTrue(driver.getTitle().contains("Prescription Listing"));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*-- Checking All head shown in Prescription main listing page-----*/
	public static void checkedMainListDataName() {
		BaseClass.waitForPageLoad();
		Assert.assertTrue(checkedWebElementDisplayed(prescriptionListingPage.getBrandNameMainList())
				&& checkedWebElementDisplayed(prescriptionListingPage.getGenericNameMainList()) && checkedWebElementDisplayed(prescriptionListingPage.getStrengthNameMainList())
				&& checkedWebElementDisplayed(prescriptionListingPage.getDurationNameMainList()) && checkedWebElementDisplayed(prescriptionListingPage.getDosageNameMainList())
				&& checkedWebElementDisplayed(prescriptionListingPage.getRouteNameMainList()) && checkedWebElementDisplayed(prescriptionListingPage.getInstructionNameMainList())
				&& checkedWebElementDisplayed(prescriptionListingPage.getPrescribeByMainList()));
	}

	/*Verifying Add New button in Prescription Listing Page-----*/
	public static void verifyAddNewBtn() {
		BaseClass.waitForPageLoad();
		Assert.assertTrue(checkedWebElementDisplayed(prescriptionListingPage.getAddNewBtn()));
	}

	/*Verifying Generic Name in main list*/
	public static void genericNameInMainList(String brandName,String genericName) {
		BaseClass.waitForPageLoad();
		String str = driver.findElement(By.xpath("//td[text()='"+brandName+"']/../td[text()='" + genericName.toUpperCase()+ "']")).getText();
		Assert.assertTrue(str.equalsIgnoreCase(genericName));
	}

	/*Verifying BrandName,Route and Notes in main list*/
	public static void prescriptionInMainList(String brandName,String prescription) {
		BaseClass.waitForPageLoad();
		String str = driver.findElement(By.xpath("//td[text()='"+brandName+"']/../td[text()='" + prescription + "']")).getText();
		Assert.assertEquals(str, prescription);
	}

	/*Verifying Strength in Main list*/
	public static void strengthMainList(String brandName,String strength, String drug) {
		BaseClass.waitForPageLoad();
		String str = strength + ".00 " + drug;
		Assert.assertTrue(checkedWebElementDisplayed(
				driver.findElement(By.xpath("//td[text()='"+brandName+"']/../td[contains(text(),'" + str + "')]"))));
	}

	/*Verifying Duration in Main list*/
	public static void durationMainList(String brandName,String duration, String dur) {
		BaseClass.waitForPageLoad();
		String str = duration + " " + dur;
		Assert.assertTrue(checkedWebElementDisplayed(
				driver.findElement(By.xpath("//td[text()='"+brandName+"']/../td[contains(text(),'" + str + "')]"))));
	}

	/*Verifying No record Message in Main list*/
	public static void verifyNoRecordFoundMessage() {
		BaseClass.waitForPageLoad();
		BaseClass.WaitTillElementIsPresent(prescriptionListingPage.getNoRecordFoundMsg());
		try {
			Thread.sleep(3000);
			Assert.assertTrue(checkedWebElementDisplayed(prescriptionListingPage.getNoRecordFoundMsg()));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*Verifying Clinic Name in Prescription listing*/
	public static void verifyClinicInPrescriptionListing(String brandName,String clinic) {
		BaseClass.waitForPageLoad();
		WebElement web = driver.findElement(By.xpath("//td[text()='"+brandName+"']/../ancestor::div[@class='clearfix table-responsive']/preceding-sibling::div/div[@class='fnt_avgR dateClnc']"));
		String str = web.getText();
		Assert.assertTrue(str.contains(clinic));
	}

	/*Click on View button Shown in Main list*/
	public static void clickViewMainList(String brandName) {
		BaseClass.waitForPageLoad();
		WebElement webelement = driver.findElement(By.xpath("//td[text()='"+brandName+"']/../ancestor::div[@class='clearfix table-responsive']/preceding-sibling::div//span[text()='View']"));
		Assert.assertTrue(checkedWebElementDisplayed(webelement));
		BaseClass.waitForElementToBeClickable(webelement);
		try {
			Thread.sleep(2000);
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		webelement.click();
	}

	/*Verifying Edit button shown in Main list*/
	public static void verifyEditBtnMainList(String brandName) {
		BaseClass.waitForPageLoad();
		WebElement webelement = driver.findElement(By.xpath("//td[text()='"+brandName+"']/../ancestor::div[@class='clearfix table-responsive']/preceding-sibling::div//span[text()='Edit']"));
		Assert.assertTrue(checkedWebElementDisplayed(webelement));
	}

	/*Verifying Print button shown in Main list*/
	public static void verifyPrintBtnMainList(String brandName) {
		BaseClass.waitForPageLoad();
		WebElement webelement = driver.findElement(By.xpath("//td[text()='"+brandName+"']/../ancestor::div[@class='clearfix table-responsive']/preceding-sibling::div//span[text()='Print']"));
		Assert.assertTrue(checkedWebElementDisplayed(webelement));
	}
	
	/*Click on Send button shown in Main list*/
	public static void clickSendBtnMainList(String brandName,String patientName, String mobile, String email) {
		WebElement sendBtn = driver.findElement(By.xpath("//td[text()='"+brandName+"']/../ancestor::div[@class='clearfix table-responsive']/preceding-sibling::div//span[text()='Send']"));
		try {
			Thread.sleep(3000);
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
		sendBtn.click();
		try {
			Thread.sleep(2000);
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
		BaseClass.waitForSpinnerToDisappear();
		if(prescriptionListingPage.getMailSendMsg().isDisplayed()) {
			Assert.assertEquals(prescriptionListingPage.getMailSendMsg().getText(), "Mail has been sent to the patient !");
		} 
		else {
		verifyHeaderInView("Update Patient Vitals");
		dataNameInSend();
		verifyPatientNameInSend(patientName);
		verifyPatientMobileInSend(mobile);
		addEmailInSend(email);
		clickSaveBtnInSend();
		successfullyMessage();
		}
	}
	
	/*Verifying Send button shown in Main list*/
	public static void verifySendBtnMainList(String brandName) {
		BaseClass.waitForPageLoad();
		WebElement webelement = driver.findElement(By.xpath("//td[text()='"+brandName+"']/../ancestor::div[@class='clearfix table-responsive']/preceding-sibling::div//span[text()='Send']"));
		Assert.assertTrue(checkedWebElementDisplayed(webelement));
	}
	
	/*-- Checking All head shown in View Pop-----*/
	public static void dataNameInSend() {
		BaseClass.waitForPageLoad();
		try {
			Thread.sleep(2000);
			Assert.assertTrue(checkedWebElementDisplayed(prescriptionListingPage.getPatientNameInSend())&&checkedWebElementDisplayed(prescriptionListingPage.getPatientMobileInSend())
					&& checkedWebElementDisplayed(prescriptionListingPage.getPatientEmailInSend()));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/*-- Verify Patient Name in Patient Vitals-----*/
	public static void verifyPatientNameInSend(String patientName) {
		BaseClass.waitForPageLoad();
		String str = driver.findElement(By.xpath("//b[text()='Patient Name']/../following-sibling::div")).getText();
		Assert.assertEquals(str, patientName);
	}
	
	/*-- Verify Patient Mobile in Patient Vitals-----*/
	public static void verifyPatientMobileInSend(String patientMobile) {
		BaseClass.waitForPageLoad();
		String str = driver.findElement(By.xpath("//b[text()='Patient Mobile']/../following-sibling::div")).getText();
		Assert.assertEquals(str, patientMobile);
	}
	
	/*-- Add Email Id in Patient Vitals Pop up-----*/
	public static void addEmailInSend(String email) {
		BaseClass.waitForPageLoad();
		prescriptionListingPage.getPatientEmailTxtBxInSend().clear();
		prescriptionListingPage.getPatientEmailTxtBxInSend().sendKeys(email);
	}
	
	/*-- Click on save button coming in Patient Vitals Pop up-----*/
	public static void clickSaveBtnInSend() {
		BaseClass.waitForPageLoad();
		prescriptionListingPage.getSaveVitalsButton().click();
	}

	/*-- Verify success msg coming after click on send button-----*/
	public static void successfullyMessage(){
		BaseClass.waitForPageLoad();
        try {
            Thread.sleep(2000);
            BaseClass.softAssert().assertTrue(checkedWebElementDisplayed(prescriptionListingPage.getMailSendMsg()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

	/*-- Checking the Header in Prescription view Screen--*/
	public static void verifyHeaderInView(String header) {
		BaseClass.waitForPageLoad();
//		BaseClass.waitForElementToBeClickable(prescriptionListingPage.getHeadInView());
		try {
			Thread.sleep(3000);
			Assert.assertTrue(prescriptionListingPage.getHeadInView().getText().contains(header));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*-- Checking All head shown in View Pop-----*/
	public static void dataNameInView() {
		BaseClass.waitForPageLoad();
		try {
			Thread.sleep(2000);
			Assert.assertTrue(checkedWebElementDisplayed(prescriptionListingPage.getHeaderViewPopUp())&&checkedWebElementDisplayed(prescriptionListingPage.getBrandNameInView())
					&& checkedWebElementDisplayed(prescriptionListingPage.getGenericNameInView()) && checkedWebElementDisplayed(prescriptionListingPage.getStrengthInView())
					&& checkedWebElementDisplayed(prescriptionListingPage.getDurationInView()) && checkedWebElementDisplayed(prescriptionListingPage.getRouteInView())
					&& checkedWebElementDisplayed(prescriptionListingPage.getDosageInView()) && checkedWebElementDisplayed(prescriptionListingPage.getInstructionInView())
					&& checkedWebElementDisplayed(prescriptionListingPage.getPrescribeByInView()) && checkedWebElementDisplayed(prescriptionListingPage.getNotesInView()));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*-- Verify Patient Name in View Pop-----*/
	public static void verifyPatientNameInView(String patientName) {
		BaseClass.waitForPageLoad();
		String str = driver.findElement(By.xpath("//span[@class='txt_medgry ng-binding']")).getText();
		String[] split = str.split(":");
		String actual = split[0].trim();
		Assert.assertEquals(actual, patientName);
	}

	/*-- Verifying the date in view Pop up-----*/
	public static void verifyDateInViewPopUp() {
		BaseClass.waitForPageLoad();
		try {
			Thread.sleep(4000);
			String string = prescriptionListingPage.getDateInView().getText().trim();
			String[] split = string.split(":");
			String actualDate = split[1].trim();
			Date dat = new Date();
			String expectedDate = new SimpleDateFormat("dd-MM-yy").format(dat);
			boolean flag = expectedDate.equals(actualDate);
			Assert.assertTrue(flag);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*-- Verifying GenericName in View-----*/
	public static void checkedGenericNameInView(String brandName,String genericName) {
		BaseClass.waitForPageLoad();
		String str = driver.findElement(By.xpath("//tbody[@class='ng-scope']//td[text()='" + genericName.toUpperCase() +"']")).getText();
			Assert.assertTrue(str.equalsIgnoreCase(genericName));
	}

	/* Verifying Brand Name,Route and Instruction in View */
	public static void checkedPrescriptionInView(String brandName,String prescription) {
		BaseClass.waitForPageLoad();
		String str = driver.findElement(By.xpath("//tbody[@class='ng-scope']//td[text()='" + prescription + "']")).getText();
		Assert.assertEquals(str, prescription);
	}

	/*-- Verifying Strength in View-----*/
	public static void strengthInView(String brandName,String strength, String drug) {
		BaseClass.waitForPageLoad();
		String str = strength + ".00 " + drug;
		Assert.assertTrue(checkedWebElementDisplayed(
				driver.findElement(By.xpath("//tbody[@class='ng-scope']//td[text()='"+brandName+"']/../td[contains(text(),'" + str + "')]"))));

	}

	/*-- Verifying Duration in View-----*/
	public static void durationInView(String brandName,String duration, String dur) {
		BaseClass.waitForPageLoad();
		String str = duration + " " + dur;
		Assert.assertTrue(checkedWebElementDisplayed(
				driver.findElement(By.xpath("//tbody[@class='ng-scope']//td[text()='"+brandName+"']/../td[contains(text(),'" + str + "')]"))));
	}

	/*-- Verifying Notes in View-----*/
	public static void notesInView(String brandname, String note) {
		BaseClass.waitForPageLoad();
		WebElement webelement = driver.findElement(By.xpath("//td[contains(text(),'" + brandname
				+ "')]/../following-sibling::tr//div[@class='textDataVisualizerFull ng-binding']"));
		Assert.assertTrue(webelement.getText().trim().contains(note));
	}

	/*-- Close the view pop up-----*/
	public static void closeViewPopup() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(prescriptionListingPage.getCloseViewButton());
		prescriptionListingPage.getCloseViewButton().click();
    
	}

	/*---Verifying deleted Prescription in main list------*/
	public static void verifyPrescriptionDeletedMainList(String Prescription) {
		BaseClass.waitForPageLoad();
		try {
			Thread.sleep(2000);
			WebElement web = driver.findElement(By.xpath("//td[contains(text(),'" + Prescription + "')]/.."));
			Assert.assertTrue(web.getAttribute("class").contains("ng-scope deleted"));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*---Verifying deleted Prescription in View modal------*/
	public static void verifyPrescriptionDeletedInViewMainList(String Prescription) {
		BaseClass.waitForPageLoad();
		try {
			Thread.sleep(2000);
			WebElement web = driver.findElement(By.xpath("//div[@id='prescriptionListbody']//td[text()='" + Prescription + "']/.."));
			Assert.assertTrue(web.getAttribute("class").contains("deleted"));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*Click on Delete button on Pop up---*/
	public static void clickDeletePop() {
		BaseClass.waitForPageLoad();
		driver.findElement(By.xpath("//span[@class='cmnicons yes-mdl']")).click();
	}

	/*checking view and edit button after deleting prescription---*/
	public static void checkBtnAfterDelete() {
		BaseClass.waitForPageLoad();
		Assert.assertTrue(checkedWebElementDisplayed(prescriptionListingPage.getViewBtn()) && checkedWebElementDisplayed(prescriptionListingPage.getEditBtn()));
	}

	private static boolean checkedWebElementDisplayed(WebElement webelement) {
		return (webelement.isDisplayed());
	}
}
