package pageActions.patientDashboard;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import base.BaseClass;
import pages.patientDashboard.ChiefComplaintAddPage;

/**
 * 
 * @author Ajit Yadav
 *
 */
public class ChiefComplaintAddPageActions extends BaseClass {
	
	static ChiefComplaintAddPage chiefComplaintAddPage = PageFactory.initElements(driver, ChiefComplaintAddPage.class);

	
	/*checking chief complaint at the input listing*/
	public static void verifyChiefComplaintsInputList(String ChiefComplaints) {
		BaseClass.waitForPageLoad();
		WebElement element = driver.findElement(By.xpath("//div[@class='brdrBox']/div/div/button[contains(text(),'"+ChiefComplaints+"')]"));
				
				//div[@class='brdrBox']/div/div/button[contains(text(),'Other')]
		
		//driver.findElement(By.xpath("//td[contains(text(),'" + ChiefComplaints + "')]"));
		Assert.assertTrue(checkedElementDisplayed(element));
	}

	/*chief complaint added success message*/
	public static void chiefComplaintAddSuccessMsg() {
		BaseClass.waitForElementToBeClickable(chiefComplaintAddPage.getSuccessMsg());
		Assert.assertTrue(checkedElementDisplayed(chiefComplaintAddPage.getSuccessMsg()));
	}

	

	/*checking every chief comlaints boxes present at chief complaints Add page*/
	public static void VerifyChiefCompliantBoxes() {
		BaseClass.waitForPageLoad();
		boolean flag = (checkedElementDisplayed(chiefComplaint("Pain"))
				&& checkedElementDisplayed(chiefComplaint("Sensitivity"))
				&& checkedElementDisplayed(chiefComplaint("Chewing Difficulty"))
				&& checkedElementDisplayed(chiefComplaint("Loose Teeth"))
				&& checkedElementDisplayed(chiefComplaint("Bad Breath"))
				&& checkedElementDisplayed(chiefComplaint("Bleeding Gums"))
				&& checkedElementDisplayed(chiefComplaint("Discolored Tooth"))
				&& checkedElementDisplayed(chiefComplaint("Swollen Gums"))
				&& checkedElementDisplayed(chiefComplaint("Plaque"))
				&& checkedElementDisplayed(chiefComplaint("Tooth Decay"))
				&& checkedElementDisplayed(chiefComplaint("Teeth Grinding"))
				&& checkedElementDisplayed(chiefComplaint("Other")));
		Assert.assertTrue(flag);
	}

	/*Selecting the chief complaint at chief complaint add page*/
	public static void clickOnChiefComplaint(String chiefComplaint) {
		BaseClass.waitForSpinnerToDisappear();
		BaseClass.waitForPageToBecomeActive();
		BaseClass.waitForElementVisibility(chiefComplaint(chiefComplaint), 4000);
		BaseClass.waitForElementToBeClickable(chiefComplaint(chiefComplaint));
		if(chiefComplaint == "Pain" || chiefComplaint == "Sensitivity"){
			chiefComplaint(chiefComplaint).click();
			BaseClass.waitForElementVisibility(chiefComplaintAddPage.getChiefCmpltPopUp(), 4000);	
		}
		else
		{
			chiefComplaint(chiefComplaint).click();
			BaseClass.waitForSpinnerToDisappear();
		}	
	}
	
	
//	public static void clickOnChiefComplaint(String chiefComplaint) {
//		BaseClass.waitForPageLoad();
//		BaseClass.waitForElementToBeClickable(chiefComplaint(chiefComplaint));
//		try {
//			Thread.sleep(3500);
//			chiefComplaint(chiefComplaint).click();
//			Thread.sleep(3500);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

	/*checking the oral exam button*/
	public static void verifyOralExamBtn() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(chiefComplaintAddPage.getOralExamBtn());
		Assert.assertTrue(checkedElementDisplayed(chiefComplaintAddPage.getOralExamBtn()));
	}

	/*deleting the chief complaint from the input listing*/
	public static void clickOnDeleteBtn(String chiefComplaint) {
		BaseClass.waitForSpinnerToDisappear();
		BaseClass.waitForPageToBecomeActive();
		driver.findElement(By.xpath("//td[contains(text(),'"+chiefComplaint+"')]/following-sibling::td/a[@class='btn ng-isolate-scope']")).click();
		BaseClass.waitForSpinnerToDisappear();
		Assert.assertTrue(driver
				.findElement(By.xpath("//p[text()='Do you want to delete the selected Chief Complaint?']"))
				.isDisplayed());
		BaseClass.waitForElementToBeClickable(chiefComplaintAddPage.getYesOnDelete());
		chiefComplaintAddPage.getYesOnDelete().click();
	}
		
//	public static void clickOnDeleteBtn(String chiefComplaint) {
//		BaseClass.waitForPageLoad();
//		try {
//			Thread.sleep(2000);
//			driver.findElement(By.xpath("//td[contains(text(),'"+chiefComplaint+"')]/following-sibling::td/a[@class='btn ng-isolate-scope']")).click();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		BaseClass.waitForPageLoad();
//		Assert.assertTrue(driver
//				.findElement(By.xpath("//p[text()='Do you want to delete the selected Chief Complaint?']"))
//				.isDisplayed());
//		BaseClass.waitForElementToBeClickable(chiefComplaintAddPage.getYesOnDelete());
//		chiefComplaintAddPage.getYesOnDelete().click();
//	}

	/*closing the pain popup*/
	public static void clickOnCloseBtn() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(chiefComplaintAddPage.getCloseBtn());
		chiefComplaintAddPage.getCloseBtn().click();
	}

	/*saving the chief complaint */
	public static void clickOnSaveBtn() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(chiefComplaintAddPage.getCloseBtn());
		chiefComplaintAddPage.getSaveBtn().click();
		BaseClass.waitForSpinnerToDisappear();
		BaseClass.waitForElementToDisappear(By.xpath("//div[@class='alert ng-isolate-scope alert-success alert-dismissable']"));
	}
	
//	public static void clickOnSaveBtn() {
//		BaseClass.waitForPageLoad();
//		BaseClass.waitForElementToBeClickable(chiefComplaintAddPage.getCloseBtn());
//		try {
//			chiefComplaintAddPage.getSaveBtn().click();
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

	/*entering the notes inside the notes text fields*/
	public static void enterNote(String note) {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(chiefComplaintAddPage.getNotes());
		chiefComplaintAddPage.getNotes().sendKeys(note);
	}

	/*checking the webelemnt of the pain popup*/
	public static void checkedPopupElement() {
		BaseClass.waitForElementVisibility(chiefComplaintAddPage.getIntensity(), 4000);
		BaseClass.waitForElementToBeClickable(chiefComplaintAddPage.getLocation());
		boolean flag = checkedElementDisplayed(chiefComplaintAddPage.getLocation()) && checkedElementDisplayed(chiefComplaintAddPage.getIntensity())
				&& checkedElementDisplayed(chiefComplaintAddPage.getPeriod()) && checkedElementDisplayed(chiefComplaintAddPage.getNotes())
				&& (chiefComplaintAddPage.getNotes().getAttribute("maxlength").contains("768")) && checkedElementDisplayed(chiefComplaintAddPage.getMaxillary())
				&& checkedElementDisplayed(chiefComplaintAddPage.getMandibular())&&checkedElementDisplayed(chiefComplaintAddPage.getSaveBtn())&& 
				checkedElementDisplayed(chiefComplaintAddPage.getCloseBtn()) && checkedElementDisplayed(chiefComplaintAddPage.getDayInMonth())
				&& checkedElementDisplayed(chiefComplaintAddPage.getSevere()) && checkedElementDisplayed(chiefComplaintAddPage.getModerate()) && checkedElementDisplayed(chiefComplaintAddPage.getMild())
		&& (chiefComplaintAddPage.getLocations().size() == 8) && checkedElementDisplayed(chiefComplaintAddPage.getRight())&& 
		checkedElementDisplayed(chiefComplaintAddPage.getLeft()) && checkedElementDisplayed(chiefComplaintAddPage.getDay()) && checkedElementDisplayed(chiefComplaintAddPage.getMonth());
		Assert.assertTrue(flag);
	}

	/*checking the location is multi selection*/
	public static void multiSelectOfLocation() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(chiefComplaintAddPage.getLocation());
		for (int i = 0; chiefComplaintAddPage.getLocations().size() > i; i++) {
			chiefComplaintAddPage.getLocations().get(i).click();
			Assert.assertTrue(chiefComplaintAddPage.getLocations().get(i).getAttribute("class").contains("selected"));
		}
		// checking all location have multiselect
		for (int i = 0; chiefComplaintAddPage.getLocations().size() > i; i++) {
			Assert.assertTrue(chiefComplaintAddPage.getLocations().get(i).getAttribute("class").contains("selected"));
		}
	}


	public static void clickOnSevere() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(chiefComplaintAddPage.getSevere());
		chiefComplaintAddPage.getSevere().click();
	}

	public static void clickOnModerate() {
		BaseClass.waitForPageLoad();
		chiefComplaintAddPage.getModerate().click();
	}

	public static void verifySevereIsNotSelected() {
		BaseClass.waitForPageLoad();
		Assert.assertTrue(!chiefComplaintAddPage.getSevere().getAttribute("class").contains("selected"));
	}

	/*selecting the months from the chief complaint popup */
	public static void SelectMonth(int month) {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(chiefComplaintAddPage.getMonthSliderUp());
		for (int i = 1; month >= i; i++) {
			try {
				Thread.sleep(1000);
				chiefComplaintAddPage.getMonthSliderUp().click();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/*selecting the date from chief complaint popup*/
	public static void SelectDays(int day) {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(chiefComplaintAddPage.getDaySliderUp());
		for (int i = 1; day >= i; i++) {
			try {
				Thread.sleep(1000);
				chiefComplaintAddPage.getDaySliderUp().click();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/*checking the column name at input listing*/
	public static void checkedInputlistDataName() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(chiefComplaintAddPage.getChiefComplaintInputList());
		Assert.assertTrue(checkedElementDisplayed(chiefComplaintAddPage.getChiefComplaintInputList()) && checkedElementDisplayed(chiefComplaintAddPage.getLocationInputList())
				&& checkedElementDisplayed(chiefComplaintAddPage.getIntensityInputList()) && checkedElementDisplayed(chiefComplaintAddPage.getPeriodInputList())
				&& checkedElementDisplayed(chiefComplaintAddPage.getNotesInputList()) && checkedElementDisplayed(chiefComplaintAddPage.getActionInputList()));
	}

	/*checking periods behavior at chief complaint add page*/
	public static void periodsBehaviour(String chiefComplaint, int expectedMonth, int expectedDay, String periods) {
		BaseClass.waitForPageLoad();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		if (periods.equals("NA")) {
			WebElement webelement = driver.findElement(By.xpath("//td[contains(text(),'" + chiefComplaint
					+ "')]/following-sibling::td//span[@data-ng-show='input.CCdetails.ChiefcomplaintPeriod.length < 1']"));
			BaseClass.waitForElementToBeClickable(webelement);
			Assert.assertTrue(webelement.getText().contains(periods));
		} else {
			List<WebElement> webelement = driver.findElements(By.xpath("//td[contains(text(),'"
					+ chiefComplaint
					+ "')]/following-sibling::td//span[contains(@data-ng-class,'{\"deleted\":period.ccp_deletestatus}')]"));
			for (int i = 0; webelement.size() > i; i++) {
//				System.out.println(!webelement.get(i).getAttribute("class").contains("deleted"));
				if (!webelement.get(i).getAttribute("class").contains("deleted")) {		
					String actualString = webelement.get(i).getText();
					String expectedString = expectedMonth + " month(s) " + expectedDay + " day(s)";
					System.out.println("Actual Strinng"+actualString+" "+"Expected String"+expectedString);
//					Assert.assertTrue(actualString.equals(expectedString));
//					Assert.assertEquals(actualString, expectedString);
				}
			}
		}
	}

	/*checking the without location at input listing*/
	public static void withoutLocationInputList(String chiefComplaints, String location) {
		BaseClass.waitForPageLoad();
		WebElement webelement = driver.findElement(By.xpath("//td[contains(text(),'" + chiefComplaints
				+ "')]/following-sibling::td//span[@data-ng-hide='input.CCdetails.Chiefcomplaintlocation.length']"));
		BaseClass.waitForElementToBeClickable(webelement);
		boolean flag = webelement.getText().contains(location);
		Assert.assertTrue(flag);		
	}

	/*checking the intensity at input listing*/
	public static void intensityInputList(String chiefComplaints, String intensity) {
		BaseClass.waitForPageLoad();
		WebElement webelement;
		if (intensity.equals("NA")) {
			webelement = driver.findElement(By.xpath("//td[contains(text(),'" + chiefComplaints
					+ "')]/following-sibling::td/span[@data-ng-show='input.CCdetails.ChiefcomplaintIntensity.length < 1']"));
			BaseClass.waitForElementToBeClickable(webelement);
		} else {
			webelement = driver.findElement(By.xpath("//td[contains(text(),'" + chiefComplaints
					+ "')]/following-sibling::td/span[@data-ng-repeat='intensity in input.CCdetails.ChiefcomplaintIntensity']"));
			BaseClass.waitForElementToBeClickable(webelement);
		}
		Assert.assertTrue(webelement.getText().contains(intensity));
	}

	/*checking the notes in input listing*/
	public static void notesInputList(String chiefComplaints, String notes) {
		   BaseClass.waitForPageToBecomeActive();
			WebElement webelement = driver.findElement(By.xpath("//td[contains(text(),'" + chiefComplaints
					+ "')]/following-sibling::td[contains(@class,'wrd-brk')]//div[contains(@class,'tdvNotes')]"));
			BaseClass.WaitTillElementIsPresent(webelement);
			Assert.assertTrue(webelement.getText().contains(notes));
	}
		
//	public static void notesInputList(String chiefComplaints, String notes) {
//		BaseClass.waitForPageLoad();
//		try {
//			Thread.sleep(2000);
//			WebElement webelement = driver.findElement(By.xpath("//td[contains(text(),'" + chiefComplaints
//					+ "')]/following-sibling::td[contains(@class,'wrd-brk')]//div[contains(@class,'tdvNotes')]"));
//			BaseClass.WaitTillElementIsPresent(webelement);
//			Assert.assertTrue(webelement.getText().contains(notes));
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//	}
	
	public static void clickEditInInputList(String chiefComplaints) {
		    BaseClass.waitForSpinnerToDisappear();
			WebElement webelement = driver.findElement(
			By.xpath("//td[contains(text(),'" + chiefComplaints + "')]/following-sibling::td/a[@class='btn']"));
			BaseClass.waitForElementToBeClickable(webelement);
			webelement.click();
	}


//	public static void clickEditInInputList(String chiefComplaints) {
//		try {
//			Thread.sleep(4000);
//			WebElement webelement = driver.findElement(
//					By.xpath("//td[contains(text(),'" + chiefComplaints + "')]/following-sibling::td/a[@class='btn']"));
//			BaseClass.waitForElementToBeClickable(webelement);
//			webelement.click();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

	/*chief complaint after edit at chief complaint Add page*/
	public static void chiefComplaintsInputEdit(String chiefComplaints) {
		BaseClass.waitForPageLoad();
		WebElement notesInput = driver.findElement(
				By.xpath("//td[contains(text(),'" + chiefComplaints + "')]/following-sibling::td//textarea"));
		WebElement limitMessageNote = driver.findElement(By.xpath("//td[contains(text(),'" + chiefComplaints
				+ "')]/following-sibling::td//textarea/following-sibling::span"));
		WebElement saveBtn = driver.findElement(By.xpath("//td[contains(text(),'" + chiefComplaints
				+ "')]/following-sibling::td//span[@class='actn-icn save']"));
		WebElement cancelBtn = driver.findElement(By.xpath("//td[contains(text(),'" + chiefComplaints
				+ "')]/following-sibling::td//span[@class='actn-icn cancel']"));
		Assert.assertTrue(checkedElementDisplayed(notesInput) && checkedElementDisplayed(limitMessageNote)
				&& checkedElementDisplayed(saveBtn) && checkedElementDisplayed(cancelBtn));
	}

	/*cancel the edit from the input listing*/
	public static void cancelInputListEdit(String chiefComplaints) {
		BaseClass.waitForPageLoad();
		WebElement cancelBtn = driver.findElement(By.xpath("//td[contains(text(),'" + chiefComplaints
				+ "')]/following-sibling::td//span[@class='actn-icn cancel']"));
		cancelBtn.click();
	}

	/*entering the notes after edit at input listing*/
	public static void enterNotesInputList(String chiefComplaints, String notes) {
		BaseClass.waitForPageLoad();
		WebElement notesInput = driver.findElement(
				By.xpath("//td[contains(text(),'" + chiefComplaints + "')]/following-sibling::td//textarea"));
		BaseClass.WaitTillElementIsPresent(notesInput);
		notesInput.sendKeys(notes);
	}

	/*saving after edit from the input listing*/
	public static void saveInputListEdit(String chiefComplaints) {
		BaseClass.waitForPageLoad();
		WebElement saveBtn = driver.findElement(By.xpath("//td[contains(text(),'" + chiefComplaints
				+ "')]/following-sibling::td//span[@class='actn-icn save']"));
		saveBtn.click();
	}

	/*action button at input listing*/
	public static void actionBtnInputList(String chiefComplaints) {
		BaseClass.waitForPageLoad();
		WebElement deleteBtn = driver.findElement(By.xpath("//td[contains(text(),'" + chiefComplaints
				+ "')]/following-sibling::td/a[@class='btn ng-isolate-scope']"));
		WebElement editBtn = driver.findElement(
				By.xpath("//td[contains(text(),'" + chiefComplaints + "')]/following-sibling::td/a[@class='btn']"));
		Assert.assertTrue(checkedElementDisplayed(deleteBtn) && checkedElementDisplayed(editBtn));
	}

	/*checking chief complaint after deleteing*/
    public static void deletedChiefComplaintInInputList(String chiefComplaint){
        try {
            Thread.sleep(2000);
            WebElement ele = driver.findElement(By.xpath("//table[@id='ccInputListTable']//td[contains(text(),'" + chiefComplaint + "')]"));
            Assert.assertTrue(ele.getAttribute("class").contains("deleted"));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
	private static boolean checkedElementDisplayed(WebElement webelement) {
		return (webelement.isDisplayed());
	}

	private static WebElement chiefComplaint(String chiefComplaints) {
		WebElement chiefCmplnt = driver.findElement(By.xpath("//button[contains(text(),'" + chiefComplaints + "')]"));
		BaseClass.waitForElementVisibility(chiefCmplnt, 4000);
		return chiefCmplnt;
	}

}