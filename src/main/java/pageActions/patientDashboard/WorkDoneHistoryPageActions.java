package pageActions.patientDashboard;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import base.BaseClass;
import pages.patientDashboard.WorkDoneHistoryPage;

public class WorkDoneHistoryPageActions extends BaseClass{

	static WorkDoneHistoryPage workDoneHistoryPage = PageFactory.initElements(driver, WorkDoneHistoryPage.class);

	public static void notesRetreat(String notes){
		BaseClass.waitForPageLoad();
		if(checkedElementDisplayed(workDoneHistoryPage.getHeaderNotesRetreat())&&checkedElementDisplayed(workDoneHistoryPage.getMaxCharMsgREtreat())&&workDoneHistoryPage.getNotesRetreat().getAttribute("placeholder").contains("notes")){
			workDoneHistoryPage.getNotesRetreat().sendKeys(notes);
		}
	}

	public static void errorMessage(String errorMsg){
		BaseClass.waitForPageLoad();
		Assert.assertTrue(workDoneHistoryPage.getErrorMssage().getText().contains(errorMsg));
	}

	public static void stageDropDownFirstTime(){
		BaseClass.waitForPageLoad();
		Assert.assertTrue(checkedElementDisplayed(workDoneHistoryPage.getHeaderStageRetreat())&&BaseClass.firstSelectedOption(workDoneHistoryPage.getStageDrpDwnRetreat()).contains("In-Progress"));
	}
	public static void selectStage(String stage){
		BaseClass.waitForPageLoad();
		BaseClass.selectFromDropDownByVisibleText(workDoneHistoryPage.getStageDrpDwnRetreat(),stage);
	}

	public static void selectReason(String reason){
		BaseClass.waitForPageLoad();
		if(checkedElementDisplayed(workDoneHistoryPage.getHeadrReasonRetreat())&&BaseClass.firstSelectedOption(workDoneHistoryPage.getReasonDrpdwnRetreat()).contains("Select Reason")){
			BaseClass.selectFromDropDownByVisibleText(workDoneHistoryPage.getReasonDrpdwnRetreat(),reason);
		}
	}

	public static void closeBtnRetreatBtn(){
		BaseClass.waitForPageLoad();
		Assert.assertTrue(checkedElementDisplayed(workDoneHistoryPage.getCloseReTreatBtn()));
	}

	public static void saveRetreatDetails(){
		BaseClass.waitForPageLoad();
		try {
			workDoneHistoryPage.getSaveRetreatBtn().click();
			Thread.sleep(3500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static  void selectTreatingDentistReTreatModal(String treatingDentist){
		BaseClass.waitForPageLoad();
		if(checkedElementDisplayed(workDoneHistoryPage.getHeaderTreatingDentistRetreat())&&BaseClass.firstSelectedOption(workDoneHistoryPage.getTreatingDentistRetreat()).equalsIgnoreCase(treatingDentist)){
		}else{
			Assert.fail();
		}
	}

	public static void headerReTreatModal(String header){
		BaseClass.waitForPageLoad();
		Assert.assertTrue(workDoneHistoryPage.getHeaderRetreatModal().getText().contains(header));
	}
	public static void errorMessageDisplayed(){
		BaseClass.waitForPageLoad();
		Assert.assertTrue(checkedElementDisplayed(workDoneHistoryPage.getErrorMsgNote()));
	}
	public static void notesFollowUp(String note){
		BaseClass.waitForPageLoad();
		if(checkedElementDisplayed(workDoneHistoryPage.getHeaderNotesFollowup())&&checkedElementDisplayed(workDoneHistoryPage.getMaxCharLimitNotesMsg())&&workDoneHistoryPage.getNotesFollowUp().getAttribute("placeholder").contains("notes")){
			workDoneHistoryPage.getNotesFollowUp().sendKeys(note);
		}
	}

	public static  void selectTreatingDentistFollowUpModal(String treatingDentist){
		BaseClass.waitForPageLoad();
		if(checkedElementDisplayed(workDoneHistoryPage.getHeaderTreatingDentist())&&BaseClass.firstSelectedOption(workDoneHistoryPage.getTreatingDoctorFollowUp()).equalsIgnoreCase(treatingDentist)){
		}else{
			Assert.fail();
		}
	}

	public static void selectSpentTime(String spentTime){
		BaseClass.waitForPageLoad();
		try {
			Thread.sleep(2000);
			if(checkedElementDisplayed(workDoneHistoryPage.getHeaderTimeSpent())&&BaseClass.firstSelectedOption(workDoneHistoryPage.getTimeSpentFollowup()).contains("Select Time")){
				BaseClass.selectFromDropDownByVisibleText(workDoneHistoryPage.getTimeSpentFollowup(),spentTime);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public static void headerFollowUpModal(String header){
		BaseClass.waitForPageLoad();
		Assert.assertTrue(workDoneHistoryPage.getFollowUpModalHeader().getText().contains(header));
	}

	public static void saveFollowUpDetails(){
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(workDoneHistoryPage.getFollowUpSaveBtn());
		try {
			workDoneHistoryPage.getFollowUpSaveBtn().click();
			Thread.sleep(3500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void closeFollowUp(){
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(workDoneHistoryPage.getFollowUpModalCloseBtn());
		workDoneHistoryPage.getFollowUpModalCloseBtn().click();
	}

	public static void closeBtnFollowUpModal(){
		BaseClass.waitForPageLoad();
		Assert.assertTrue(checkedElementDisplayed(workDoneHistoryPage.getFollowUpModalCloseBtn()));
	}

	public static void treatmentFollowUpModal(String treatment){
		BaseClass.waitForPageLoad();
		Assert.assertTrue(workDoneHistoryPage.getTreatmentFollowUpModal().getText().contains(treatment));
	}

	public static void sourceFollowUpModal(String source){
		BaseClass.waitForPageLoad();
		Assert.assertTrue(workDoneHistoryPage.getTeethFollowUpModal().getText().contains(source));
	}

	public static void clinicNameFollowUpModal(String clinic){
		BaseClass.waitForPageLoad();
		Assert.assertTrue(workDoneHistoryPage.getClinicNameFollowUpModal().getText().contains(clinic));
	}


	public static void checkedInvoiceListBtn() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(workDoneHistoryPage.getInvoiceListBtn());
		Assert.assertTrue(checkedElementDisplayed(workDoneHistoryPage.getInvoiceListBtn()));
	}

	public static void checkedPrintBtn() {
		BaseClass.WaitTillElementIsPresent(workDoneHistoryPage.getPrintBtn());
		Assert.assertTrue(checkedElementDisplayed(workDoneHistoryPage.getPrintBtn()));
	}

	public static void checkLabWorkOrderBtn() {
		BaseClass.waitForPageLoad();
		Assert.assertTrue(checkedElementDisplayed(workDoneHistoryPage.getLabWorkOrderAddBtn()));
	}
	public static void checkPrintButtonDisplayed() {
		BaseClass.waitForPageLoad();
		Assert.assertTrue(checkedElementDisplayed(workDoneHistoryPage.getPrint()));
	}

	public static void checkDateTreatment(String treatment, String todayDate) {
		BaseClass.waitForPageLoad();
		for (int i = 0; workDoneHistoryPage.getTreatmentStartedDate().size() > i; i++) {
			if (workDoneHistoryPage.getTreatments().get(i).getText().trim().contains(treatment)) {
				Assert.assertTrue(workDoneHistoryPage.getTreatmentStartedDate().get(i).getText().trim().contains(todayDate)
						&& workDoneHistoryPage.getTreatments().get(i).getText().trim().contains(treatment));
				break;
			} else {
				continue;
			}
		}
	}

	public static void checkSourceNo(String treatment, String source) {
		BaseClass.waitForPageLoad();
		WebElement web = driver.findElement(By.xpath("//span[contains(text(),'" + treatment
				+ "')]/../..//span[text()='Source']/following-sibling::span[@class='toothNoCont ng-binding']"));
		Assert.assertTrue(web.getText().trim().contains(source));
	}

	public static void checkedStatusTreatment(String treatment, String status) {
		List<WebElement> web = driver.findElements(
				By.xpath("//span[contains(text(),'" + treatment + "')]/../..//span[contains(@class,'indicator_txt')]"));
		for (int i = 0; web.size() > i; i++) {
			if (web.get(i).getText().trim().contains(status)) {
				Assert.assertTrue(web.get(i).getText().trim().contains(status));
				break;
			} else {
				continue;
			}
		}
	}

	public static void checkDataName(String treatment) {
		BaseClass.waitForPageLoad();
		List<WebElement> dateTime = driver.findElements(By.xpath(
				"//span[contains(text(),'" + treatment + "')]/../../following-sibling::div//th[text()='Date/Time']"));
		List<WebElement> trtDentist = driver.findElements(By.xpath("//span[contains(text(),'" + treatment
				+ "')]/../../following-sibling::div//th[text()='Trt. Dentist']"));
		List<WebElement> clinicName = driver.findElements(By.xpath(
				"//span[contains(text(),'" + treatment + "')]/../../following-sibling::div//th[text()='Clinic Name']"));
		List<WebElement> time = driver.findElements(By
				.xpath("//span[contains(text(),'" + treatment + "')]/../../following-sibling::div//th[text()='Time']"));
		List<WebElement> trtStage = driver.findElements(By.xpath(
				"//span[contains(text(),'" + treatment + "')]/../../following-sibling::div//th[text()='Trt. Stage']"));
		List<WebElement> notes = driver.findElements(By.xpath(
				"//span[contains(text(),'" + treatment + "')]/../../following-sibling::div//span[text()='Clinical Notes']"));
		for (int i = 0; dateTime.size() > i; i++) {
			BaseClass.waitForElementToBeClickable(dateTime.get(i));
			Assert.assertTrue(checkedElementDisplayed(dateTime.get(i)) && checkedElementDisplayed(trtDentist.get(i))
					&& checkedElementDisplayed(clinicName.get(i)) && checkedElementDisplayed(time.get(i))
					&& checkedElementDisplayed(trtStage.get(i)) && checkedElementDisplayed(notes.get(i)));
		}
	}

	public static void modifiedDate(String treatment, String todayDate) {
		List<WebElement> web = driver.findElements(By.xpath("//span[contains(text(),'"+todayDate+"')]/.."
				+ "//span[contains(text(),'"+treatment+"')]"
				+ "/../../following-sibling::div//span[@class='legendOriginal legendOrgNoMrg ng-binding']"));
		for (int i = 0; web.size() > i; i++) {
			LocalDate localDate = LocalDate.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yy");
			String formate = localDate.format(formatter);
			Assert.assertTrue(web.get(i).getText().trim().contains(formate));
		}
	}

	public static void checkDoctorTreated(String treatment, String doctor) {
		BaseClass.waitForPageLoad();
		List<WebElement> webElements = driver.findElements(
				By.xpath("//span[contains(text(),'" + treatment + "')]/../../following-sibling::div//select[@id='Doctor']/../../../div"));
		for (int i =0; webElements.size() > i; i++) {
			Assert.assertTrue(webElements.get(i).getText().contains(doctor));
		}
	}

	public static void checkedClinic(String treatment, String clinic) {
		BaseClass.waitForPageLoad();
		List<WebElement> webElements = driver.findElements(
				By.xpath("//span[contains(text(),'" + treatment + "')]/../../following-sibling::div/table/tbody/tr"));
		boolean flag;
		for (int i = 1; webElements.size() > i; i++) {

			//flag = driver.findElement(By.xpath("(//span[contains(text(),'" + treatment+ "')]/../../following-sibling::div/table/tbody/tr[" + i + "]//td[@class='ng-binding'])[2]"))

			flag = driver.findElement(By.xpath("//span[contains(text(),'" + treatment
					+ "')]/../../following-sibling::div/table/tbody/tr[" + i + "]/td[5]"))

					.getText().trim().contains(clinic);
			Assert.assertTrue(flag);
		}
	}

	public static void checkSpentTime(String treatment, String timeSpent) {
		BaseClass.waitForPageLoad();
		WebElement web = driver.findElement(By.xpath("//span[contains(text(),'" + treatment
				+ "')]/../../following-sibling::div//custom-combo[@data-list='TimeSpentOptions']/preceding-sibling::div"));
		Assert.assertTrue(web.getText().trim().contains(timeSpent));
	}

	public static void checkStageTreatment(String treatment, String stages) {
		BaseClass.waitForPageLoad();
		//WebElement web = driver.findElement(By.xpath("(//span[contains(text(),'" + treatment+ "')]/../../following-sibling::div//td[@class='ng-binding'])[3]"));

		WebElement web = driver.findElement(By.xpath("//span[contains(text(),'"+treatment+"')]/../../following-sibling::div//td[@class='ng-binding']"));

		Assert.assertTrue(web.getText().trim().contains(stages));
	}

	public static void checkedRemarks(String treatment, String remarks) {
		BaseClass.waitForPageLoad();
		WebElement web = driver.findElement(By.xpath("//span[contains(text(),'" + treatment
				+ "')]/../../following-sibling::div//div[@class='notesWorkDone ng-binding']"));
		Assert.assertTrue(web.getText().trim().equalsIgnoreCase(remarks));
	}
	/*checking all option in Reason after click on ReTreat button from Reason Dropdown field*/
	public static void checkRetreatOptionDropDwn() {
		BaseClass.waitForPageLoad();
		boolean flag1,flag2, match= false;
		flag1=checkedElementDisplayed(workDoneHistoryPage.getReasonDrpDwn());
		String[] exp = { "Select Reason", "Accidentally completed the treatment on PRM.", "Not satisfied with the treatment.", "Re-infection.","Others"};
		Select select = new Select(workDoneHistoryPage.getReasonDrpDwn());
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
	
	/*Select the Reason after click on ReTreat/Reopen button from Reason Dropdown field*/
	public static void selectRequire(String reasonValue) {
		BaseClass.waitForPageLoad();
		try {
			Thread.sleep(3000);
			BaseClass.selectFromDropDownByVisibleText(workDoneHistoryPage.getReasonDrpDwn(), reasonValue);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void clickReOpenBtn(String teethNo) {
		BaseClass.waitForPageLoad();
		WebElement ele = driver.findElement(By.xpath("//span[contains(text(),'"+teethNo+"')]/../following-sibling::div//span[@class='actn-icn reopen']"));
		ele.click();
	}
	
	public static void clickSaveBtnOnReasonPopUp() {
		BaseClass.waitForPageLoad();
		workDoneHistoryPage.getReasonSaveBtn().click();
	}
	
	public static void clickAddNewBtn() {
		BaseClass.waitForPageLoad();
		try {
			Thread.sleep(2000);
			workDoneHistoryPage.getAddNewBtn().click();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static void followUpBtn(String treatment){
		BaseClass.waitForPageLoad();
		Assert.assertTrue(checkedElementDisplayed(driver.findElement(By.xpath("//span[contains(text(),'"+treatment+"')]/../..//span[@class='actn-icn followup']"))));
	}
	public static void followUpBtnRedCovidFlag(String treatment){
		BaseClass.waitForPageLoad();
		Assert.assertFalse(checkedElementDisplayed(driver.findElement(By.xpath("//span[contains(text(),'"+treatment+"')]/../..//span[@class='actn-icn followup']"))));
	}
	public static void clickFollowUpBtn(String treatment){
		BaseClass.waitForPageLoad();
		try {
			driver.findElement(By.xpath("//span[contains(text(),'"+treatment+"')]/../..//span[@class='actn-icn followup']")).click();
			Thread.sleep(4500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void reTreatBtn(String treatment){
		BaseClass.waitForPageLoad();
		Assert.assertTrue(checkedElementDisplayed(driver.findElement(By.xpath("//span[contains(text(),'"+treatment+"')]/../..//span[@class='actn-icn retreat']"))));
	}

	public static void clickReTreatBtn(String treatment){
		BaseClass.waitForPageLoad();
		try {
			driver.findElement(By.xpath("//span[contains(text(),'"+treatment+"')]/../..//span[@class='actn-icn retreat']")).click();
			Thread.sleep(2500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private static boolean checkedElementDisplayed(WebElement webElement) {
		return (webElement.isDisplayed());
	}

}
