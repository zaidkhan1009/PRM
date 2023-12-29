package pageActions.patientDashboard;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import base.BaseClass;
import pages.patientDashboard.PrescriptionPage;

public class PrescriptionPageActions extends BaseClass {
	
	static PrescriptionPage prescriptionPage = PageFactory.initElements(driver, PrescriptionPage.class);

	
	/*-------------Functions---------------------*/

	/*-- Checking the BrandName and Generic Name-----*/
	public static void checkBrandAndGenericName() {
		BaseClass.waitForPageLoad();
		Assert.assertTrue(checkedWebElementDisplayed(prescriptionPage.getBrandName()) && checkedWebElementDisplayed(prescriptionPage.getGenericNameTxtBx())
				&& prescriptionPage.getGenericNameTxtBx().getAttribute("placeholder").contains("generic name")
				&& checkedWebElementDisplayed(prescriptionPage.getBrandNameTxtBx())
				&& prescriptionPage.getBrandNameTxtBx().getAttribute("placeholder").contains("brand name"));
	}

	/*-- Enter BrandName in Add Prescription Page----*/
	public static void addBrandName(String brandName) {
		BaseClass.waitForPageLoad();
		prescriptionPage.getBrandNameTxtBx().clear();
		prescriptionPage.getBrandNameTxtBx().sendKeys(brandName);
	}
	

	/*-- Checking the Strength TextField in Add Prescription Page---*/
	public static void checkStrength() {
		BaseClass.waitForPageLoad();
		Assert.assertTrue(checkedWebElementDisplayed(prescriptionPage.getStrength()) && checkedWebElementDisplayed(prescriptionPage.getStrengthTxtBx())
				&& prescriptionPage.getStrengthTxtBx().getAttribute("placeholder").contains("strength"));
	}

	/*-- Enter Strength in Add Prescription Page----*/
	public static void addStrength(String strength) {
		BaseClass.waitForPageLoad();
		prescriptionPage.getStrengthTxtBx().clear();
		prescriptionPage.getStrengthTxtBx().sendKeys(strength);
	}

	/*-- Checking the duration TextField in Add Prescription Page---*/
	public static void checkDuration() {
		BaseClass.waitForPageLoad();
		Assert.assertTrue(checkedWebElementDisplayed(prescriptionPage.getDuration()) && checkedWebElementDisplayed(prescriptionPage.getDurationUnitTxtBx())
				&& prescriptionPage.getDurationUnitTxtBx().getAttribute("placeholder").contains("duration"));
	}

	/*-- Enter Duration in Add Prescription Page----*/
	public static void addDuration(String duration) {
		BaseClass.waitForPageLoad();
		prescriptionPage.getDurationUnitTxtBx().clear();
		prescriptionPage.getDurationUnitTxtBx().sendKeys(duration);

	}

	/*-- Enter GenericName in Add Prescription Page----*/
	public static void addGenericName(String genericname) {
		BaseClass.waitForPageLoad();
		prescriptionPage.getGenericNameTxtBx().clear();
		try {
			prescriptionPage.getGenericNameTxtBx().sendKeys(genericname);
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*-- Checking all options present in Strength dropDown in Add Prescription Page---*/
	public static void chckStrengthDropDownWebelemet() {
		BaseClass.waitForPageLoad();
		boolean flag1, flag2, match = false;
		flag1 = checkedWebElementDisplayed(prescriptionPage.getStrengthDrpDwn());
		String[] exp = { "Select Strength Unit", "mg", "mg/1cc", "mg/2cc", "mg/3cc", "mg/4cc", "mg/5cc", "mcg", "grams" };
		Select select = new Select(prescriptionPage.getStrengthDrpDwn());
		List<WebElement> options = select.getOptions();
		for (WebElement we : options) {
			for (int i = 0; i < exp.length; i++) {
				if (flag2 = we.getText().equals(exp[i])) {
					match = flag1 && flag2;
				}
			}
			Assert.assertTrue(match);
		}
	}

	/*-- Select any value from Drug DropDown present in Add Prescription Page----*/
	public static void selectDrug(String drugValue) {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BaseClass.waitForPageLoad();
		BaseClass.selectFromDropDownByVisibleText(prescriptionPage.getStrengthDrpDwn(), drugValue);
	}

	/*-- Checking all options present in Duration dropDown in Add Prescription Page---*/
	public static void chckDurationDropDownWebelement() {
		BaseClass.waitForPageLoad();
		boolean flag1, flag2, match = false;
		flag1 = checkedWebElementDisplayed(prescriptionPage.getDurationDrpDwn());
		String[] exp = { "Select Duration Unit", "Day(s)", "Week(s)", "Month(s)", "Year(s)", "s.o.s." };
		Select select = new Select(prescriptionPage.getDurationDrpDwn());
		List<WebElement> options = select.getOptions();
		for (WebElement we : options) {
			for (int i = 0; i < exp.length; i++) {
				if (flag2 = we.getText().equals(exp[i])) {
					match = flag1 && flag2;
				}
			}
			Assert.assertTrue(match);
		}
	}

	/*-- Select any value from Duration DropDown present in Add Prescription Page----*/
	public static void selectDuration(String durationValue) {
		BaseClass.waitForPageLoad();
		try {
			Thread.sleep(2000);
			BaseClass.selectFromDropDownByVisibleText(prescriptionPage.getDurationDrpDwn(), durationValue);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*-- Checking all options present in Route dropDown in Add Prescription Page---*/
	public static void chckRouteDropDownWebelement() {
		BaseClass.waitForPageLoad();
		boolean flag1, flag2, match = false;
		flag1 = checkedWebElementDisplayed(prescriptionPage.getRoute()) && checkedWebElementDisplayed(prescriptionPage.getRouteDrpDwn());
		String[] exp = { "Select Route", "Injectible", "Oral", "Parenteral", "Rectal", "Topical" };
		Select select = new Select(prescriptionPage.getRouteDrpDwn());
		List<WebElement> options = select.getOptions();
		for (WebElement we : options) {
			for (int i = 0; i < exp.length; i++) {
				if (flag2 = we.getText().equals(exp[i])) {
					match = flag1 && flag2;
				}
			}
			Assert.assertTrue(match);
		}
	}

	/*-- Select any value from Route DropDown present in Add Prescription Page----*/
	public static void selectRoute(String routeValue) {
		BaseClass.waitForPageLoad();
		BaseClass.selectFromDropDownByVisibleText(prescriptionPage.getRouteDrpDwn(), routeValue);
	}

	/*-- Checking all Checkbox like Morning,AfterNoon,Evening in Add Prescription Page---*/
	public static void checkAllCheckbox() {
		BaseClass.waitForPageLoad();
		Assert.assertTrue(checkedWebElementDisplayed(prescriptionPage.getMorning()) && checkedWebElementDisplayed(prescriptionPage.getAfternoon())
				&& checkedWebElementDisplayed(prescriptionPage.getNight()));
	}

	/*-- Select Morning checkbox in Add Prescription Page----*/
	public static void clickOnMorning() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(prescriptionPage.getMorningBtn());
		prescriptionPage.getMorningBtn().click();
	}

	/*-- Select Afternoon checkbox in Add Prescription Page----*/
	public static void clickOnAfternoon() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(prescriptionPage.getAfternoonBtn());
		prescriptionPage.getAfternoonBtn().click();
	}

	/*-- Select Evening checkbox in Add Prescription Page----*/
	public static void clickOnNight() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(prescriptionPage.getNightBtn());
		prescriptionPage.getNightBtn().click();
	}

	/*-- Checking Instructions in Add Prescription Page---*/
	public static void checkInstruction() {
		BaseClass.waitForPageLoad();
		Assert.assertTrue(checkedWebElementDisplayed(prescriptionPage.getInstruction()) && checkedWebElementDisplayed(prescriptionPage.getBefFoodBtn())
				&& checkedWebElementDisplayed(prescriptionPage.getAftFoodBtn()));
	}

	/*-- Select BeforeFood in Add Prescription Page----*/
	public static void beforeFood() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(prescriptionPage.getBefFoodBtn());
		prescriptionPage.getBefFoodBtn().click();
	}

	/*-- Select AfterFood in Add Prescription Page----*/
	public static void afterFood() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(prescriptionPage.getAftFoodBtn());
		prescriptionPage.getAftFoodBtn().click();
	}

	/*-- Checking Notes in Add Prescription Page---*/
	public static void checkNotes() {
		BaseClass.waitForPageLoad();
		Assert.assertTrue(checkedWebElementDisplayed(prescriptionPage.getNotes()) && checkedWebElementDisplayed(prescriptionPage.getNotesTxtBx())
				&& prescriptionPage.getNotesTxtBx().getAttribute("placeholder").contains("notes"));
	}

	/*-- Enter Notes in Add Prescription Page----*/
	public static void enterNote(String notes) {
		BaseClass.waitForPageLoad();
		prescriptionPage.getNotesTxtBx().clear();
		prescriptionPage.getNotesTxtBx().sendKeys(notes);
	}

	/*-- Checking Save button in Add Prescription Page---*/
	public static void checkSave() {
		BaseClass.waitForPageLoad();
		Assert.assertTrue(checkedWebElementDisplayed(prescriptionPage.getSaveBtn()));
	}

	/*-- Click on Save button in Add Prescription Page---*/
	public static void clickOnSaveBtn() {
		BaseClass.waitForPageLoad();
		BaseClass.WaitTillElementIsPresent(prescriptionPage.getSaveBtn());
		try {
			Thread.sleep(4000);
			prescriptionPage.getSaveBtn().click();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*-- Checking Cancel button in Add Prescription Page---*/
	public static void checkCancel() {
		BaseClass.waitForPageLoad();
		Assert.assertTrue(checkedWebElementDisplayed(prescriptionPage.getCancelBtn()));
	}

	/*-- Click on Cancel button in Add Prescription Page---*/
	public static void clickOnCancelBtn() {
		BaseClass.waitForElementToBeClickable(prescriptionPage.getCancelBtn());
		try {
			Thread.sleep(3000);
			prescriptionPage.getCancelBtn().click();
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*-- Checking Reset button in Add Prescription Page---*/
	public static void checkReset() {
		BaseClass.waitForPageLoad();
		Assert.assertTrue(checkedWebElementDisplayed(prescriptionPage.getResetBtn()));
	}

	/*-- Click on Reset button in Add Prescription Page---*/
	public static void clickOnResetBtn() {
		BaseClass.waitForElementToBeClickable(prescriptionPage.getResetBtn());
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		prescriptionPage.getResetBtn().click();
	}

	/*---Checking all element in Prescription Input List---*/
	public static void checkedInputListDataName() {
		BaseClass.waitForPageLoad();
		try {
			Thread.sleep(6000);
			Assert.assertTrue(checkedWebElementDisplayed(prescriptionPage.getBrandNameInputList())
					&& checkedWebElementDisplayed(prescriptionPage.getGenericNameInputList()) && checkedWebElementDisplayed(prescriptionPage.getStrengthInputList())
					&& checkedWebElementDisplayed(prescriptionPage.getDurationInputList()) && checkedWebElementDisplayed(prescriptionPage.getRouteInputList())
					&& checkedWebElementDisplayed(prescriptionPage.getDosageInputList()) && checkedWebElementDisplayed(prescriptionPage.getInstructionInputList())
					&& checkedWebElementDisplayed(prescriptionPage.getNotesInputList()) && checkedWebElementDisplayed(prescriptionPage.getActionInputList()));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/* Verifying Generic Name in Input list */
	public static void verifyGenericNameInputListData(String genericName) {
		BaseClass.waitForPageLoad();
		String actual = driver
				.findElement(By.xpath("//td[contains(text(),'" + genericName.toUpperCase() + "')]")).getText();
		Assert.assertTrue(actual.equalsIgnoreCase(genericName));
	}

	/* Verifying BrandName,Route and Notes in Input list */
	public static void verifyPrescriptionInputListData(String Prescription) {
		BaseClass.waitForPageLoad();
		String actual = driver.findElement(By.xpath("//td[contains(text(),'" + Prescription + "')]"))
				.getText();
		Assert.assertEquals(actual, Prescription);
	}

	/* Verifying Strength in Input list */
	public static void verifyStrengthInputListData(String Strength, String Drug) {
		BaseClass.waitForPageLoad();
		String str = Strength + ".00 " + Drug;
		Assert.assertTrue(checkedWebElementDisplayed(
				driver.findElement(By.xpath("//td[contains(text(),'" + str + "')]"))));
	}

	/* Verifying Duration in Input list */
	public static void verifyDurationInputListData(String Duration, String dur) {
		BaseClass.waitForPageLoad();
		String exp_str = Duration + " " + dur;
		String actual_str = driver.findElement(By.xpath("//td[contains(text(),'" + exp_str + "')]"))
				.getText();
		Assert.assertEquals(actual_str, exp_str);
	}

	/* Verifying Notes in Input list */
	public static void verifyNotesInputList(String brandName, String notes) {
		BaseClass.waitForPageLoad();
		try {
			Thread.sleep(2000);
			WebElement webelement = driver.findElement(By.xpath("//td[contains(text(),'" + brandName
					+ "')]/following-sibling::td//div[contains(@class,'tdvNotes')]"));
			BaseClass.WaitTillElementIsPresent(webelement);
			Assert.assertTrue(webelement.getText().contains(notes));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/* Click on Edit button shown against the given entry in Input list */
	public static void clickEditInputList(String brandName) {
		try {
			Thread.sleep(4000);
			BaseClass.waitForPageLoad();
			WebElement webelement = driver.findElement(By.xpath(
					"//td[contains(text(),'" + brandName + "')]/following-sibling::td//span[@class='actn-icn edit']"));
			webelement.click();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/* Get BrandName value from TextBox in Add Prescription */
	public static void getBrandName(String expected) {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(prescriptionPage.getBrandNameTxtBx());
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
		Object obj = javascriptExecutor.executeScript("return document.getElementById('brandName').value;");
		String actual = (String) obj;
		Assert.assertEquals(actual, expected);
	}

	/* Get Strength value from TextBox in Add Prescription */
	public static void getStrength(String expected) {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(prescriptionPage.getStrengthTxtBx());
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
		Object obj = javascriptExecutor.executeScript("return document.getElementById('strength').value;");
		String actual = (String) obj;
		Assert.assertEquals(actual, expected);
	}

	/* Get Duration value from TextBox in Add Prescription */
	public static void getDuration(String expected) {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(prescriptionPage.getDurationUnitTxtBx());
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
		Object obj = javascriptExecutor.executeScript("return document.getElementsByName('durationUnit')[0].value;");
		String actual = (String) obj;
		Assert.assertEquals(actual, expected);
	}

	/* Get GenericName value from TextBox in Add Prescription */
	public static void getGenericName(String expected) {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(prescriptionPage.getGenericNameTxtBx());
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
		Object obj = javascriptExecutor.executeScript("return document.getElementById('genericName').value;");
		String actual = (String) obj;
		Assert.assertTrue(expected.equalsIgnoreCase(actual));
	}

	/* Get Drug value from DropDown in Add Prescription */
	public static void getDrug(String expected) {
		BaseClass.waitForPageLoad();
		Assert.assertTrue(BaseClass.firstSelectedOption(prescriptionPage.getStrengthDrpDwn()).contains(expected));
	}

	/* Get Duration value from DropDown in Add Prescription */
	public static void getDurationDrpDwn(String expected) {
		BaseClass.waitForPageLoad();
		Assert.assertTrue(BaseClass.firstSelectedOption(prescriptionPage.getDurationDrpDwn()).contains(expected));
	}

	/* Get Route value from DropDown in Add Prescription */
	public static void getRoute(String expected) {
		BaseClass.waitForPageLoad();
		Assert.assertTrue(BaseClass.firstSelectedOption(prescriptionPage.getRouteDrpDwn()).contains(expected));
	}

	/* Get Instruction value from TextBox in Add Prescription */
	public static void getInstruction(String expected) {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(prescriptionPage.getInstruction());
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
		Object obj = javascriptExecutor.executeScript("return document.getElementById('instruction').value;");
		String actual = (String) obj;
		Assert.assertEquals(actual, expected);
	}

	/* Get Notes value from TextBox in Add Prescription */
	public static void getNotes(String expected) {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(prescriptionPage.getNotesTxtBx());
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
		Object obj = javascriptExecutor.executeScript("return document.getElementById('notes').value;");
		String actual = (String) obj;
		Assert.assertEquals(actual, expected);
	}

	/* Click on Cancel button shown in Add Prescription */
	public static void cancelInputList(String brandName) {
		BaseClass.waitForPageLoad();
		WebElement cancelBtn = driver.findElement(By.xpath(
				"//td[contains(text(),'" + brandName + "')]/following-sibling::td//span[@class='actn-icn cancel']"));
		cancelBtn.click();
	}

	/* Checking Edit and Delete button in Add Prescription */
	public static void actionBtnInputList(String brandName) {
		BaseClass.waitForPageLoad();
		try {
			Thread.sleep(1000);
			WebElement deleteBtn = driver.findElement(By.xpath("//td[contains(text(),'" + brandName
					+ "')]/following-sibling::td//a[@class='btn ng-isolate-scope']"));
			WebElement editBtn = driver.findElement(
					By.xpath("//td[contains(text(),'" + brandName + "')]/following-sibling::td//a[@class='btn']"));
			Assert.assertTrue(checkedWebElementDisplayed(deleteBtn) && checkedWebElementDisplayed(editBtn));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/* Checking Delete button on Pop up--- */
	public static void checkDeleteBtn(String brandName) {
		BaseClass.waitForPageLoad();
		Assert.assertTrue(checkedWebElementDisplayed(driver
				.findElement(By.xpath("//td[text()='" + brandName + "']/..//span[@class='actn-icn delete']"))));
	}

	/* Click on Delete button on Pop up--- */
	public static void clickOnDeleteBtn(String brandName) {
		BaseClass.waitForPageLoad();
		try {
			Thread.sleep(4000);
			driver
					.findElement(By.xpath("//td[text()='" + brandName + "']/..//span[@class='actn-icn delete']"))
					.click();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/* Click on yes for Delete on Pop up--- */
	public static void clickOnYesDelete() {
		BaseClass.waitForPageLoad();
		Assert.assertTrue(driver.findElement(By.xpath("//p[text()='Are you sure to delete this record?']"))
				.isDisplayed());
		BaseClass.waitForElementToBeClickable(prescriptionPage.getYesOnDelete());
		prescriptionPage.getYesOnDelete().click();
	}

	/* Checking Deleted Prescription entry in Input listing--- */
	public static void verifyPrescriptionDeletedInputList(String Prescription) {
		BaseClass.waitForPageLoad();
		WebElement web = driver.findElement(By.xpath("//td[contains(text(),'" + Prescription + "')]/.."));
		try {
			Thread.sleep(3000);
			Assert.assertTrue(web.getAttribute("class").contains("ng-scope deleted"));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/* Checking Error brand Validation Msg--- */
	public static void checkedErrorBrand(String errorMsg) {
		BaseClass.waitForPageLoad();
		Assert.assertTrue(prescriptionPage.getErrorBrandMsg().getText().contains(errorMsg));
	}

	/* Checking Error Duration Validation Msg--- */
	public static void checkedErrorDuration(String errorMsg) {
		BaseClass.waitForPageLoad();
		Assert.assertTrue(prescriptionPage.getErrorDurationMsg().getText().contains(errorMsg));
	}

	/* Checking Error Duration in digit Validation Msg--- */
	public static void checkedErrorDurationInDigit(String errorMsg) {
		BaseClass.waitForPageLoad();
		Assert.assertTrue(prescriptionPage.getErrorDurationDigitMsg().getText().contains(errorMsg));
	}

	/* Checking Error Generic Validation Msg--- */
	public static void checkedErrorGeneric(String errorMsg) {
		BaseClass.waitForPageLoad();
		Assert.assertTrue(prescriptionPage.getErrorGenericMsg().getText().contains(errorMsg));
	}

	/* Checking Error Drug Validation Msg--- */
	public static void checkedErrorDurationDrpDwn(String errorMsg) {
		BaseClass.waitForPageLoad();
		Assert.assertTrue(prescriptionPage.getErrorDurationDrpDwnMsg().getText().contains(errorMsg));
	}

	/* Checking Error Frequency Validation Msg--- */
	public static void checkedErrorDosage(String errorMsg) {
		BaseClass.waitForPageLoad();
		Assert.assertTrue(prescriptionPage.getErrorFreqMsg().getText().contains(errorMsg));
	}

	/* Checking Error Instruction Validation Msg--- */
	public static void checkedErrorInstruction(String errorMsg) {
		BaseClass.waitForPageLoad();
		Assert.assertTrue(prescriptionPage.getErrorInstructionMsg().getText().contains(errorMsg));
	}

	private static boolean checkedWebElementDisplayed(WebElement webElement) {
		return (webElement.isDisplayed());
	}
}
