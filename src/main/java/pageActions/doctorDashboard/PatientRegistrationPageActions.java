package pageActions.doctorDashboard;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.BaseClass;
import pages.doctorDashboard.Login;
import pages.doctorDashboard.PatientRegistrationPage;

/**
 * 
 * @author Ajit
 *
 */
public class PatientRegistrationPageActions extends BaseClass  {
	
	static Login loginPage = PageFactory.initElements(driver, Login.class);
	static PatientRegistrationPage patientRegistrationPage = PageFactory.initElements(driver, PatientRegistrationPage.class);

	public static void nameAndPhoneAlreadyExit(){
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementVisibility(patientRegistrationPage.getNameAndPhoneAlreadyExit(), 5000);
		try {
			Thread.sleep(1000);
			Assert.assertTrue(checkedElementDisplayed(patientRegistrationPage.getNameAndPhoneAlreadyExit()));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void enterMedication(String medication){
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(patientRegistrationPage.getMedicationTextFields());
		patientRegistrationPage.getMedicationTextFields().sendKeys(medication);
	}
	public static void enterAllergy(String allergy){
		BaseClass.WaitTillElementIsPresent(patientRegistrationPage.getAllrgTxtArea());
		BaseClass.waitForElementToBeClickable(patientRegistrationPage.getAlleryTextField());
		patientRegistrationPage.getAlleryTextField().sendKeys(allergy);
	}
	public static void selectGenderMsg(){
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(patientRegistrationPage.getSelectGenderMsg());
		Assert.assertTrue(checkedElementDisplayed(patientRegistrationPage.getSelectGenderMsg()));
	}
	public static void enterMobileNoMsg(){
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(patientRegistrationPage.getEnterMobileNoMsg());
		Assert.assertTrue(checkedElementDisplayed(patientRegistrationPage.getEnterMobileNoMsg()));
	}
	public static void enterTenDigitMobileNoMsg(){
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(patientRegistrationPage.getEnterTenDigitMobileNoMsg());
		Assert.assertTrue(checkedElementDisplayed(patientRegistrationPage.getEnterTenDigitMobileNoMsg()));
	}
		
	public static void validateEnterEmailMsg(){
		BaseClass.waitForElementVisibility(patientRegistrationPage.getValidateEnterEmailErrMsg(), 4000);
		BaseClass.waitForElementToBeClickable(patientRegistrationPage.getValidateEnterEmailErrMsg());
		Assert.assertTrue(checkedElementDisplayed(patientRegistrationPage.getValidateEnterEmailErrMsg()));
	}
	
	public static void validateInvalidEmailMsg(){
		BaseClass.waitForElementVisibility(patientRegistrationPage.getValidateInvalidEmailErrMsg(), 4000);
		BaseClass.waitForElementToBeClickable(patientRegistrationPage.getValidateInvalidEmailErrMsg());
		Assert.assertTrue(checkedElementDisplayed(patientRegistrationPage.getValidateInvalidEmailErrMsg()));
	}
	
	public static void verificationOfValidEmail(){
		BaseClass.waitForSpinnerToDisappear();
		BaseClass.waitForElementVisibility(patientRegistrationPage.getVerifiedEmailMsg(), 4000);
		BaseClass.waitForElementToBeClickable(patientRegistrationPage.getVerifiedEmailMsg());
		Assert.assertTrue(checkedElementDisplayed(patientRegistrationPage.getVerifiedEmailMsg()));
	}
	
	public static void enterValidMobileNoMsg(){
//		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(patientRegistrationPage.getEnterValidMobileNoMsg());
		Assert.assertTrue(checkedElementDisplayed(patientRegistrationPage.getEnterValidMobileNoMsg()));
	}
	public static void enterAlternateContactNameMsg(){
//		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(patientRegistrationPage.getEnterAlternateContactNameMsg());
		Assert.assertTrue(checkedElementDisplayed(patientRegistrationPage.getEnterAlternateContactNameMsg()));
	}
	public static void enterAlternateContactNoMsg(){
//		BaseClass.waitForPageLoad();
		
//		BaseClass.waitForElementVisibility(enterAlternateContactNoMsg, 5000);
	BaseClass.waitForElementToBeClickable(patientRegistrationPage.getEnterAlternateContactNoMsg());
		Assert.assertTrue(checkedElementDisplayed(patientRegistrationPage.getEnterAlternateContactNoMsg()));
	}
	public static void enterGuardianNameMsg(){
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(patientRegistrationPage.getEnterGuardianNameMsg());
		Assert.assertTrue(checkedElementDisplayed(patientRegistrationPage.getEnterGuardianNameMsg()));
	}
	public static void enterGuardianContactNoMsg(){
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(patientRegistrationPage.getEnterGuardianContactNoMsg());
		Assert.assertTrue(checkedElementDisplayed(patientRegistrationPage.getEnterGuardianContactNoMsg()));
	}
	public static void patientPastHistory() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(patientRegistrationPage.getPatientName());
			Assert.assertTrue(checkedElementDisplayed(patientRegistrationPage.getMedicalHistory()) && checkedElementDisplayed(patientRegistrationPage.getPastHistory())
					&& checkedElementDisplayed(patientRegistrationPage.getDentalCheckup()) && checkedElementDisplayed(patientRegistrationPage.getMedication())
					&& checkedElementDisplayed(patientRegistrationPage.getAllergies()) && checkedElementDisplayed(patientRegistrationPage.getGroup())
					&& checkedElementDisplayed(patientRegistrationPage.getPatientNotes()));
	}
	public static void checkAge(){
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(patientRegistrationPage.getPatientName());
		Assert.assertTrue(checkedElementDisplayed(patientRegistrationPage.getDOB()) && (checkedElementDisplayed(patientRegistrationPage.getAge()) && checkedMandatory(patientRegistrationPage.getAge())));
	}
	
	public static void checkGender() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(patientRegistrationPage.getGender());
		Assert.assertTrue(checkedElementDisplayed(patientRegistrationPage.getGender())&&checkedElementDisplayed(patientRegistrationPage.getGenderRequired())&&checkedElementDisplayed(patientRegistrationPage.getGenderMale())&&checkedElementDisplayed(patientRegistrationPage.getGenderFemale())&&checkedElementDisplayed(patientRegistrationPage.getGenderOther()));
	}

//	public static void genderMaleSelected() {
//		BaseClass.waitForPageLoad();
//		Assert.assertTrue(driver.findElement(By.id("gender-male")).isSelected());
//
//	}
	
	public static void checkPatientName(){
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(patientRegistrationPage.getPatientName());
		Assert.assertTrue(checkedElementDisplayed(patientRegistrationPage.getPatientName()) && checkedMandatory(patientRegistrationPage.getPatientName()));
	}
	public static void checkEmailId(){
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(patientRegistrationPage.getEmail());
		Assert.assertTrue(checkedElementDisplayed(patientRegistrationPage.getEmail()));
	}
	public static void checkMobile(){
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(patientRegistrationPage.getPatientName());
		Assert.assertTrue(checkedElementDisplayed(patientRegistrationPage.getMobile()) && checkedMandatory(patientRegistrationPage.getMobile()));
	}
	
	public static void checkSmsCallEmailCheckbox(){
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(patientRegistrationPage.getPatientName());
		Assert.assertFalse(patientRegistrationPage.getCallCheckbox().isSelected() && patientRegistrationPage.getSmsCheckbox().isSelected() && patientRegistrationPage.getEmailCheckbox().isSelected());
	}
	
	public static void checkLandline(){
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(patientRegistrationPage.getLandline());
		Assert.assertTrue(checkedElementDisplayed(patientRegistrationPage.getLandline()));
	}
	public static void checkAlternateContactName(){
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(patientRegistrationPage.getAlternateName());
		Assert.assertTrue(checkedElementDisplayed(patientRegistrationPage.getAlternateName()) && checkedMandatory(patientRegistrationPage.getAlternateName()));
	}
	public static void checkAlternateContactNo(){
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(patientRegistrationPage.getAlternateContact());
		Assert.assertTrue(checkedElementDisplayed(patientRegistrationPage.getAlternateContact()) && checkedMandatory(patientRegistrationPage.getAlternateContact()));
	}
	public static void checkPrimaryDentist(String doctorName){
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(patientRegistrationPage.getPrimaryDentist());
		Assert.assertTrue(checkedElementDisplayed(patientRegistrationPage.getPrimaryDentist())&&BaseClass.firstSelectedOption(patientRegistrationPage.getPrimaryDentist()).equalsIgnoreCase(doctorName));
	}
	public static void checkReachTime(){
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(patientRegistrationPage.getReachtime());
		Assert.assertTrue(checkedElementDisplayed(patientRegistrationPage.getReachtime()));
	}
	public static void checkOccupation(){
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(patientRegistrationPage.getOccupation());
		Assert.assertTrue(checkedElementDisplayed(patientRegistrationPage.getOccupation())&&BaseClass.firstSelectedOption(patientRegistrationPage.getOccupation()).contains("Select Occupation"));
	}
	
	public static void checkOccupationOthers(){
		BaseClass.waitForPageLoad();
		Assert.assertTrue(checkedElementDisplayed(patientRegistrationPage.getOtherOccupation())&&!patientRegistrationPage.getOtherOccupation().isEnabled());
	}
	
	public static void checkAddress(){
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(patientRegistrationPage.getAddressTextBox());
		BaseClass.waitForSpinnerToDisappear();
		Assert.assertTrue(checkedElementDisplayed(patientRegistrationPage.getAddressTextBox())&&patientRegistrationPage.getAddressTextBox().getAttribute("placeholder").contains("» address") && checkedElementDisplayed(patientRegistrationPage.getCity())&& patientRegistrationPage.getCity().getAttribute("placeholder").contains("» city")
				&&checkedElementDisplayed(patientRegistrationPage.getCountry())&&BaseClass.firstSelectedOption(patientRegistrationPage.getCountry()).contains("India")&& checkedElementDisplayed(patientRegistrationPage.getState()) && BaseClass.firstSelectedOption(patientRegistrationPage.getState()).contains("Select State") &&checkedElementDisplayed(patientRegistrationPage.getPin()) && patientRegistrationPage.getPin().getAttribute("placeholder").contains("» Pin"));
	}
	
	public static void checkActionsButton(){
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(patientRegistrationPage.getApproveSave());
		Assert.assertTrue(checkedElementDisplayed(patientRegistrationPage.getApproveSave())&&checkedElementDisplayed(patientRegistrationPage.getApproveAppBtn())&&checkedElementDisplayed(patientRegistrationPage.getCancel())&checkedElementDisplayed(patientRegistrationPage.getReset()));
	}

	public static void clickOnResetBtn() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(patientRegistrationPage.getReset());
		patientRegistrationPage.getReset().click();
	}

	public static void clickOnCancelBtn() {
		BaseClass.waitForSpinnerToDisappear();
		BaseClass.waitForModalOverlayToDisappear();
		BaseClass.waitForElementToBeClickable(patientRegistrationPage.getCancel());
		BaseClass.hoverOnElement(patientRegistrationPage.getCancel());
		patientRegistrationPage.getCancel().click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void clickOnApproveApp() {
		BaseClass.waitForSpinnerToDisappear();
		BaseClass.waitForElementToBeClickable(patientRegistrationPage.getApproveAppBtn());
		patientRegistrationPage.getApproveAppBtn().click();
	}

	public static void print() {
		Assert.assertTrue(driver.findElement(By.xpath("//span[contains(@text(),'Name and phone already exist')]")).isDisplayed());
	}

	public static void clickOnDeleteBtn() {
		BaseClass.waitForElementToBeClickable(patientRegistrationPage.getDeleteBtnInPastHistory());
		//BaseClass.waitForModalBackdropToDisappear();
		try{
			Thread.sleep(3000);
		}
		 catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		 }
		patientRegistrationPage.getDeleteBtnInPastHistory().click();
	}

	public static void verifyPastHistoryAfterDelete() {
		Assert.assertTrue(driver
				.findElement(By.xpath("(//tr[@data-ng-repeat='data in patient.PastMedicalHistory'])[1]"))
				.getAttribute("class").contains("strikeOff"));
	}

	public static void enterNotes(String note) {
		BaseClass.waitForElementToBeClickable(patientRegistrationPage.getNotes());
		patientRegistrationPage.getNotes().sendKeys(note);
	}

	public static void clickOnSaveBtnOfPastHistory() {
		BaseClass.waitForElementToBeClickable(patientRegistrationPage.getSaveBtn());
		patientRegistrationPage.getSaveBtn().click();
	}
	
	public static void clickOnAddBtnPastHistory() {
//			BaseClass.scrollPage(500);
		    BaseClass.waitForSpinnerToDisappear();
			BaseClass.scrollToView(patientRegistrationPage.getAddBtnPastHistory());
			BaseClass.waitForPageLoad();
			patientRegistrationPage.getAddBtnPastHistory().click();
	}

//	public static void clickOnAddBtnPastHistory() {
//		try {
//			Thread.sleep(3000);
//			BaseClass.scrollPage(500);
//			BaseClass.waitForPageLoad();
//			patientRegistrationPage.getAddBtnPastHistory().click();
//		} catch (NoSuchElementException|InterruptedException e1) {
//			e1.printStackTrace();
//		}
//	}

	public static void clickOnAdult() {
		BaseClass.waitForElementToBeClickable(patientRegistrationPage.getAdult());
		patientRegistrationPage.getAdult().click();
	}

	public static void clickOnPedo() {
		BaseClass.waitForElementToBeClickable(patientRegistrationPage.getPedo());
		patientRegistrationPage.getPedo().click();
	}

	public static void clickOnMixed() {
		BaseClass.waitForElementToBeClickable(patientRegistrationPage.getMixed());
		patientRegistrationPage.getMixed().click();
	}

	public static void clickOnAllTeeth() {
		BaseClass.waitForElementToBeClickable(patientRegistrationPage.getAllToothCheckBox());
		patientRegistrationPage.getAllToothCheckBox().click();
	}

	public static void isAllTeethIsSelected() {
		BaseClass.waitForElementToBeClickable(patientRegistrationPage.getAllToothCheckBox());
		Assert.assertTrue(!patientRegistrationPage.getAllToothCheckBox().isSelected());
	}

//	public static void selectTeeth(String teethNo) {
//		WebElement teeth = driver.findElement(By.id(teethNo));
//		BaseClass.waitForElementToBeClickable(teeth);
//		teeth.click();
//	}
	
	public static void selectTeeth(String[] teeths) {
		for(int i =0;i<teeths.length;i++)
		{
			String teethNo = teeths[i];
			WebElement teeth = driver.findElement(By.id(teethNo));
			BaseClass.waitForElementToBeClickable(teeth);
			teeth.click();
		}
		
	}
	
	public static void verifyTeethIsSelected(String[] teeths) {
		for(int i =0;i<teeths.length;i++)
		{
			String teethNo = teeths[i];
			WebElement teeth = driver.findElement(By.id(teethNo));
			BaseClass.waitForElementToBeClickable(teeth);
			Assert.assertTrue(teeth.getAttribute("class").contains("selected"));
		}
	}

//	public static void verifyTeethIsSelected(String teethNo) {
//		WebElement teeth = driver.findElement(By.id(teethNo));
//		BaseClass.waitForElementToBeClickable(teeth);
//		Assert.assertTrue(teeth.getAttribute("class").contains("selected"));
//	}

	public static void pedoCheckInMixedAfterSelectedInPedo() {
		boolean flag;
		if (flag = patientRegistrationPage.getTeethsUpperPedo().size() == patientRegistrationPage.getTeethslowerPedo().size()) {
			for (int i = 0; i < patientRegistrationPage.getTeethslowerPedo().size(); i++) {
				flag = patientRegistrationPage.getTeethsUpperPedo().get(i).getAttribute("class").contains("selected")
						&& patientRegistrationPage.getTeethslowerPedo().get(i).getAttribute("class").contains("selected");
				Assert.assertTrue(flag);
			}
		} else {
			Assert.assertTrue(flag);
		}
	}

	public static void adultCheckInMixedAfterSelectedInAdult() {
		if (patientRegistrationPage.getTeethslowerAdult().size() == patientRegistrationPage.getTeethsUpperAdult().size()) {
			for (int i = 0; i < patientRegistrationPage.getTeethslowerAdult().size(); i++) {
				boolean flag = patientRegistrationPage.getTeethslowerAdult().get(i).getAttribute("class").contains("selected")
						&& patientRegistrationPage.getTeethsUpperAdult().get(i).getAttribute("class").contains("selected");
				Assert.assertTrue(flag);
			}
		}
	}

	public static void pedoCheckedAllTeethDeselected() {
		if (patientRegistrationPage.getTeethsUpperPedo().size() == patientRegistrationPage.getTeethslowerPedo().size()) {
			for (int i = 0; i < patientRegistrationPage.getTeethslowerPedo().size(); i++) {
				boolean flag = !patientRegistrationPage.getTeethsUpperPedo().get(i).getAttribute("class").contains("selected")
						&& !patientRegistrationPage.getTeethslowerPedo().get(i).getAttribute("class").contains("selected");
				Assert.assertTrue(flag);
			}
		}
	}

	public static void adultCheckedAllTeethDeselected() {
		if (patientRegistrationPage.getTeethslowerAdult().size() == patientRegistrationPage.getTeethsUpperAdult().size()) {
			for (int i = 0; i < patientRegistrationPage.getTeethslowerAdult().size(); i++) {
				boolean flag = !patientRegistrationPage.getTeethslowerAdult().get(i).getAttribute("class").contains("selected")
						&& !patientRegistrationPage.getTeethsUpperAdult().get(i).getAttribute("class").contains("selected");
				Assert.assertTrue(flag);
			}
		}
	}
	
	
	public static void verifySelectedTeethPastHistory(String[] teeths) {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(patientRegistrationPage.getDateColumn());
		WebElement deleteButtonOnPastHistory = driver.findElement(By.xpath("//span[@class='actn-icn delete']"));
		BaseClass.waitForElementToBeClickable(deleteButtonOnPastHistory);
		if(checkedElementDisplayed(patientRegistrationPage.getDateColumn())&&checkedElementDisplayed(patientRegistrationPage.getToothNoColumn())&&checkedElementDisplayed(patientRegistrationPage.getCreatedByColumn())&&checkedElementDisplayed(patientRegistrationPage.getNotesColumn())&&checkedElementDisplayed(patientRegistrationPage.getActionColumn())){
			String expectedTeeths = patientRegistrationPage.getToothNoInPasstHistory().getText();
			System.out.println("Teeths fetched from application -> "+expectedTeeths);
			int noOfTeeth = teeths.length;
			if(noOfTeeth > 1)
			{
				String[] expectedTeethsArr = expectedTeeths.split(",");
				System.out.println("Teeth array after split" +Arrays.toString(expectedTeethsArr));
				Assert.assertEquals(expectedTeethsArr.length, noOfTeeth);
				for(int i = 0;i<noOfTeeth;i++)
				{
					System.out.println(expectedTeethsArr[i]);
					Assert.assertEquals(expectedTeethsArr[i], teeths[i]);
				}
			}
			else
			{
				Assert.assertEquals(expectedTeeths.length(), teeths.length);
				Assert.assertEquals(expectedTeeths, teeths[0]);
			}
			
		}else {
			Assert.fail();
		}
	}

//	public static void verifySelectedTeethPastHistory(String firstSelect, String secondSelect) {
//		BaseClass.waitForPageLoad();
//		BaseClass.waitForElementToBeClickable(patientRegistrationPage.getDateColumn());
//		if(checkedElementDisplayed(patientRegistrationPage.getDateColumn())&&checkedElementDisplayed(patientRegistrationPage.getToothNoColumn())&&checkedElementDisplayed(patientRegistrationPage.getCreatedByColumn())&&checkedElementDisplayed(patientRegistrationPage.getNotesColumn())&&checkedElementDisplayed(patientRegistrationPage.getActionColumn())){
//			String expected = firstSelect + "," + secondSelect;
//			String actual = patientRegistrationPage.getToothNoInPasstHistory().getText();
//			Assert.assertEquals(actual, expected);
//		}else {
//			Assert.fail();
//		}
//	}
	
	

	public static void verifyNotesPastHistory(String notes) {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(patientRegistrationPage.getDateColumn());
		if(checkedElementDisplayed(patientRegistrationPage.getDateColumn())&&checkedElementDisplayed(patientRegistrationPage.getToothNoColumn())&&checkedElementDisplayed(patientRegistrationPage.getCreatedByColumn())&&checkedElementDisplayed(patientRegistrationPage.getNotesColumn())&&checkedElementDisplayed(patientRegistrationPage.getActionColumn())){
			String actual = patientRegistrationPage.getNotesPastHistory().getText();
			Assert.assertEquals(actual, notes);
		}else {
			Assert.fail();
		}
	}

	public static void checkDeleteBtnPastHistory(){
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(patientRegistrationPage.getActionBtn());
		Assert.assertTrue(checkedElementDisplayed(patientRegistrationPage.getActionBtn()));
	}
	public static void clickMedication() {
		BaseClass.waitForElementToBeClickable(patientRegistrationPage.getMedication());
		patientRegistrationPage.getMedication().click();
	}

	public static void medicationAllRdioBtn() {
		BaseClass.waitForElementToBeClickable(patientRegistrationPage.getYesOnMedication());
		boolean flag = checkedElementDisplayed(patientRegistrationPage.getYesOnMedication()) && checkedElementDisplayed(patientRegistrationPage.getNoOnMedication())
				&& checkedElementDisplayed(patientRegistrationPage.getNaOnMedication());
		Assert.assertTrue(flag);
	}
	
	public static void clickOnMedicationCheckUpYesBtn() {
		BaseClass.waitForElementToBeClickable(patientRegistrationPage.getMedicationCheckUpYesBtn());
		patientRegistrationPage.getMedicationCheckUpYesBtn().click();
	}

	public static void checkMedicationDetailsTextField() {
//		BaseClass.WaitTillElementIsPresent(enterMedicationDetails);
		BaseClass.waitForElementVisibility(patientRegistrationPage.getEnterMedicationDetails(), 4000);
		Assert.assertTrue(checkedElementDisplayed(patientRegistrationPage.getEnterMedicationDetails()));
	}

	public static void clickOnDentalCheckUP() {
		BaseClass.waitForElementToBeClickable(patientRegistrationPage.getDentalCheckup());
		patientRegistrationPage.getDentalCheckup().click();
	}

	public static void dentalCheckUpAllRdioBtn() {
		BaseClass.waitForElementToBeClickable(patientRegistrationPage.getMoreThanOneYr());
		boolean flag = checkedElementDisplayed(patientRegistrationPage.getLessThanSixMonth()) && checkedElementDisplayed(patientRegistrationPage.getMoreThanOneYr())
				&& checkedElementDisplayed(patientRegistrationPage.getMoreThanSixMonth());
		Assert.assertTrue(flag);
	}
	
	public static void selectDentalCheckUpOptions(String duration)
	{
		driver.findElement(By.xpath("//label[contains(text(),'"+duration+"')]")).click();
	}
	
	

	public static void clickOnAllergies() {
		BaseClass.waitForElementToBeClickable(patientRegistrationPage.getAllergies());
		patientRegistrationPage.getAllergies().click();
	}

	public static void allRadioInsideAllergies() {
		BaseClass.waitForElementToBeClickable(patientRegistrationPage.getAllergiesYesBtn());
		Assert.assertTrue(checkedElementDisplayed(patientRegistrationPage.getAllergiesNABtn())&&checkedElementDisplayed(patientRegistrationPage.getAllergiesNoBtn())&&checkedElementDisplayed(patientRegistrationPage.getAllergiesYesBtn()));
	}

	public static void checkAllergyDetailsTextField() {
		BaseClass.WaitTillElementIsPresent(patientRegistrationPage.getEnterAllergyDetails());
		Assert.assertTrue(checkedElementDisplayed(patientRegistrationPage.getEnterAllergyDetails()));
	}

	public static void clickOnAllergiesYesBtn() {
		BaseClass.waitForElementToBeClickable(patientRegistrationPage.getAllergiesYesBtn());
		patientRegistrationPage.getAllergiesYesBtn().click();
	}
	
//	public static void addAllergiesDetails(String allergyDetails)
//	{
//		
//		BaseClass.waitForElementToBeClickable(patientRegistrationPage.getPatientNotes());
//		allrgTxtArea.sendKeys(allergyDetails);
//	}

	public static void clickOnGroup() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(patientRegistrationPage.getGroup());
		patientRegistrationPage.getGroup().click();
	}

	public static void enterGroup(String groupName) {
		BaseClass.waitForElementToBeClickable(patientRegistrationPage.getGroupTextfields());
		patientRegistrationPage.getGroupTextfields().sendKeys(groupName);
	}
	
	public static void clickOnPatientNotes() {
		    BaseClass.waitForSpinnerToDisappear();
		    BaseClass.WaitTillElementIsPresent(patientRegistrationPage.getPatientNotes());
			BaseClass.waitForElementToBeClickable(patientRegistrationPage.getPatientNotes());
			patientRegistrationPage.getPatientNotes().click();
	}

//	public static void clickOnPatientNotes() {
//		BaseClass.waitForPageLoad();
//		try {
//			Thread.sleep(3000);
//			BaseClass.waitForElementToBeClickable(patientRegistrationPage.getPatientNotes());
//			patientRegistrationPage.getPatientNotes().click();
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//	}

	public static void enterPatientNotes(String PatientNotes) {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(patientRegistrationPage.getPatientNotesTextFields());
		patientRegistrationPage.getPatientNotesTextFields().sendKeys(PatientNotes);
	}

	public static void enterPinCode(String pincode) {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(patientRegistrationPage.getReachtime());
		patientRegistrationPage.getPin().sendKeys(pincode);
	}

	public static void enterCity(String cityName) {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(patientRegistrationPage.getReachtime());
		patientRegistrationPage.getCity().sendKeys(cityName);
	}

	public static void enterInReachTime(String reachTimeInformation) {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(patientRegistrationPage.getReachtime());
		patientRegistrationPage.getReachtime().sendKeys(reachTimeInformation);
	}

	public static void selectOccupation(String occupationInfo) {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementVisibility(patientRegistrationPage.getOccupation(), 5000);
		BaseClass.waitForElementToBeClickable(patientRegistrationPage.getOccupation());
		BaseClass.waitForSpinnerToDisappear();
		BaseClass.selectFromDropDownByVisibleText(patientRegistrationPage.getOccupation(), occupationInfo);
	}
	
	public static void selectState(String stateName) {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementVisibility(patientRegistrationPage.getState(), 5000);
		BaseClass.waitForElementToBeClickable(patientRegistrationPage.getState());
		BaseClass.selectFromDropDownByVisibleText(patientRegistrationPage.getState(), stateName);
	}

	public static void enterAddress(String address) {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(patientRegistrationPage.getOccupation());
		patientRegistrationPage.getAddressTextBox().sendKeys(address);
	}

	public static void enterGuardianName(String gurdianName) {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(patientRegistrationPage.getGuardianName());
		patientRegistrationPage.getGuardianName().clear();
		patientRegistrationPage.getGuardianName().sendKeys(gurdianName);
	}

	public static void enterGuardianNo(String gurdianNo) {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(patientRegistrationPage.getGuardianContact());
		patientRegistrationPage.getGuardianContact().clear();
		patientRegistrationPage.getGuardianContact().sendKeys(gurdianNo);
	}

	public static void guardianDetailsHide(){
		BaseClass.waitForPageLoad();
		Assert.assertEquals(patientRegistrationPage.getGuardianContactSet().size(),0);
	}

	public static void scrollDown() {
		try {
			BaseClass.scrollPage(-600);
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void scrollUp() {
		try {
			BaseClass.scrollPage(500);
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void clickOnApproveSave() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForSpinnerToDisappear();
		BaseClass.waitForElementVisibility(patientRegistrationPage.getApproveSave(),5000);
		BaseClass.moveToElementAndClick(patientRegistrationPage.getApproveSave());
		
		BaseClass.waitForSpinnerToDisappear();
		BaseClass.waitForPageLoad();
		BaseClass.waitForSpinnerToDisappear();
	}

//	public static void clickOnApproveSave() {
//		try {
//			Thread.sleep(5000);
//			BaseClass.waitForPageLoad();
//			BaseClass.waitForElementToBeClickable(patientRegistrationPage.getApproveSave());
//			patientRegistrationPage.getApproveSave().click();
//			Thread.sleep(10000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//	}
	
	public static void enterPatientName(String name) {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementVisibility(patientRegistrationPage.getPatientName(),5000);
		BaseClass.waitForElementToBeClickable(patientRegistrationPage.getPatientName());
			patientRegistrationPage.getPatientName().clear();
			patientRegistrationPage.getPatientName().sendKeys(name);
	}
	
	public static void enterEmailAddress(String emailText) {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementVisibility(patientRegistrationPage.getPatientName(),5000);
		BaseClass.waitForElementToBeClickable(patientRegistrationPage.getPatientName());
			patientRegistrationPage.getEmail().clear();
			patientRegistrationPage.getEmail().sendKeys(emailText);
	}

//	public static void enterPatientName(String name) {
//		BaseClass.waitForPageLoad();
//		BaseClass.waitForElementToBeClickable(patientRegistrationPage.getPatientName());
//		try {
//			Thread.sleep(4000);
//			patientRegistrationPage.getPatientName().clear();
//			patientRegistrationPage.getPatientName().sendKeys(name);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//	}

	public static void enterAlternateMobileNO(String alterNateMoblieNum) {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementVisibility(patientRegistrationPage.getAlternateContact(), 5000);
		BaseClass.waitForElementToBeClickable(patientRegistrationPage.getAlternateContact());
		patientRegistrationPage.getAlternateContact().clear();
		patientRegistrationPage.getAlternateContact().sendKeys(alterNateMoblieNum);
	}

	public static void enterMobileNO(String MoblieNum) {
		BaseClass.waitForSpinnerToDisappear();
//		BaseClass.waitForPageLoad();
		BaseClass.waitForElementVisibility(patientRegistrationPage.getMobile(), 5000);
		BaseClass.waitForElementToBeClickable(patientRegistrationPage.getMobile());
		patientRegistrationPage.getMobile().clear();
		patientRegistrationPage.getMobile().sendKeys(MoblieNum);
	}

	public static void enterAlterContactName(String alterNateContactName) {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(patientRegistrationPage.getAlternateName());
		patientRegistrationPage.getAlternateName().clear();
		patientRegistrationPage.getAlternateName().sendKeys(alterNateContactName);
	}

	public static void enterAge(String Age) {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(patientRegistrationPage.getAge());
		patientRegistrationPage.getAge().clear();
		patientRegistrationPage.getAge().sendKeys(Age);
	}

	public static void checkAgeCalculation(String dob) {
		BaseClass.waitForElementToBeClickable(patientRegistrationPage.getDOB());
		patientRegistrationPage.getDOB().clear();
		patientRegistrationPage.getDOB().sendKeys(dob);
		if (driver instanceof JavascriptExecutor) {
			JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
			
			Object obj = javascriptExecutor.executeScript("return document.getElementById('age').value;");
			String str = (String) obj;
			Date date = new Date();
			SimpleDateFormat simple = new SimpleDateFormat("dd-MM-yyyy");
			String currentDate = simple.format(date);
			String[] split = currentDate.split("-");
			String currentYear = split[2];
			String[] year = dob.split("-");
			String dobYear = year[2];
			int actual = Integer.parseInt(currentYear) - Integer.parseInt(dobYear);
			int expected = Integer.parseInt(str);
			Assert.assertEquals(actual, expected);
		}
	}

	public static void enterPatientNameMsg(){
		BaseClass.waitForPageLoad();
		Assert.assertTrue(checkedElementDisplayed(patientRegistrationPage.getEnterPatientNameMsg()));
	}
		
	public static void selectGenderMale(String gender) {
    	BaseClass.waitForPageLoad();
		BaseClass.waitForElementVisibility(patientRegistrationPage.getGenderMale(),5000);
		BaseClass.hoverOnElement(patientRegistrationPage.getGenderMale());
		if(gender.equals("Male"))
		{
			BaseClass.waitForElementToBeClickable(patientRegistrationPage.getGenderMale());
			BaseClass.waitForSpinnerToDisappear();
     		BaseClass.moveToElementAndClick(patientRegistrationPage.getGenderMale());
//			patientRegistrationPage.getGenderMale().click();
		}
		else
		BaseClass.moveToElementAndClick(patientRegistrationPage.getGenderFemale());
//		patientRegistrationPage.getGenderFemale().click();
	}

	public static void landlineMaxLength() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(patientRegistrationPage.getLandline());
		int expected = 15;
		int actual = Integer.parseInt(patientRegistrationPage.getLandline().getAttribute("maxlength"));
		Assert.assertEquals(actual, expected);
	}

	public static void byDefaultCountry(String countryName) {
		BaseClass.waitForElementToBeClickable(patientRegistrationPage.getCountry());
		Assert.assertTrue(BaseClass.firstSelectedOption(patientRegistrationPage.getCountry()).contains(countryName));
	}

	public static void verifyStatesAccordingToCountry(String stateName) {
		BaseClass.waitForPageLoad();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		BaseClass.waitForElementToBeClickable(patientRegistrationPage.getState());
		Assert.assertTrue(patientRegistrationPage.getState().getText().contains(stateName));
	}

	public static void selectCountry(String countryName) {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(patientRegistrationPage.getCountry());
		try {
			Thread.sleep(3000);
			BaseClass.selectFromDropDownByVisibleText(patientRegistrationPage.getCountry(), countryName);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void verifyCharacterLimitOfPinText() {
		BaseClass.waitForElementToBeClickable(patientRegistrationPage.getPin());
		Assert.assertTrue(patientRegistrationPage.getPin().getAttribute("maxlength").contains("10"));
	}

	public static void clickOnMedicalHistory() {
		BaseClass.waitForElementToBeClickable(patientRegistrationPage.getMedicalHistory());
		patientRegistrationPage.getMedicalHistory().click();
	}

	public static void selectMedicalHistory(String Disease, String level) {
		BaseClass.waitForPageLoad();
		WebElement radioBtn = driver
				.findElement(By.xpath("//label[contains(text(),'" + Disease + "')]/..//label[text()='" + level + "']"));
		radioBtn.click();
	}
	
	public static void selectAllMedicalHistory(String options){
		BaseClass.waitForPageLoad();
		for(int i = 2; i<=patientRegistrationPage.getMedicalHistoryDomains().size();i++)
		{
		
			if(i == 3)
			{
				continue;
			}
			else
			{
			 driver
			 .findElement(By.xpath("//div[@class='form-group col-xs-12 col-sm-6 col-md-6 col-lg-6 ng-scope']["+i+"]//input/..//label[text()='"+options+"']")).click();
			}
		}
	}
	
	public static void verifyEditPatientName(String patient_name) {
		BaseClass.waitForPageLoad();
		BaseClass.waitForSpinnerToDisappear();
		BaseClass.waitForElementToBeClickable(patientRegistrationPage.getPatientName());
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
		Object obj = javascriptExecutor.executeScript("return document.getElementById('name').value;");
		String actual = (String) obj;
		Assert.assertEquals(actual,patient_name);
	}
	
	public static void editPatientName(String patient_name) {
		BaseClass.waitForPageLoad();
		BaseClass.waitForSpinnerToDisappear();
		BaseClass.waitForElementToBeClickable(patientRegistrationPage.getPatientName());
		patientRegistrationPage.getPatientName().clear();
		patientRegistrationPage.getPatientName().sendKeys(patient_name);
	}
	
	public static void verifyEditMobile(String patient_mobile) {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(patientRegistrationPage.getPatientName());
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
		Object obj = javascriptExecutor.executeScript("return document.getElementById('mobile').value;");
		String actual = (String) obj;
		Assert.assertEquals(actual,patient_mobile);
	}
	
	
	public static void editMobile(String patient_mobile) {
		BaseClass.waitForPageLoad();
		BaseClass.waitForSpinnerToDisappear();
		BaseClass.waitForElementToBeClickable(patientRegistrationPage.getMobile());
		patientRegistrationPage.getMobile().clear();
		patientRegistrationPage.getMobile().sendKeys(patient_mobile);
	}
	
	public static void verifyEditEmail(String patient_email) {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(patientRegistrationPage.getEmail());
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
		Object obj = javascriptExecutor.executeScript("return document.getElementById('email').value;");
		String actual = (String) obj;
		Assert.assertEquals(actual,patient_email);
	}
	
	public static void editEmail(String patient_email) {
		BaseClass.waitForPageLoad();
		BaseClass.waitForSpinnerToDisappear();
		BaseClass.waitForElementToBeClickable(patientRegistrationPage.getEmail());
		patientRegistrationPage.getEmail().clear();
		patientRegistrationPage.getEmail().sendKeys(patient_email);
	}
	

	public static void editAge(String patient_age) {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(patientRegistrationPage.getPatientName());
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
		Object obj = javascriptExecutor.executeScript("return document.getElementById('age').value;");
		String actual = (String) obj;
		Assert.assertEquals(actual.trim(),patient_age.trim());
	}
	public static void editAlternateName(String patient_alternate_mobile) {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(patientRegistrationPage.getPatientName());
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
		Object obj = javascriptExecutor.executeScript("return document.getElementById('alternateName').value;");
		String actual = (String) obj;
		Assert.assertEquals(actual,patient_alternate_mobile);
	}
	public static void editAlternateMobile(String patient_alternate_mobile) {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(patientRegistrationPage.getAlternateName());
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
		Object obj = javascriptExecutor.executeScript("return document.getElementById('alternateContact').value;");
		String actual = (String) obj;
		Assert.assertEquals(actual,patient_alternate_mobile);
	}
	
	public static boolean  checkCallCheckBoxChecked(){
		BaseClass.WaitTillElementIsPresent ( patientRegistrationPage.getCallCheckbox() );
		return patientRegistrationPage.getCallCheckbox().isSelected ();
	}
	public static boolean checkSMSCheckBoxChecked(){
		BaseClass.WaitTillElementIsPresent ( patientRegistrationPage.getSmsCheckbox() );
		return  patientRegistrationPage.getSmsCheckbox().isSelected ();

	}
	public static boolean  checkEmailCheckBoxChecked(){
		BaseClass.WaitTillElementIsPresent ( patientRegistrationPage.getEmailCheckbox() );
		return  patientRegistrationPage.getEmailCheckbox().isSelected ();

	}

	public static boolean  checkEmailCheckBoxDisable(){
		BaseClass.WaitTillElementIsPresent ( patientRegistrationPage.getEmailCheckbox() );
		if(patientRegistrationPage.getEmailCheckbox().getAttribute ( "disabled" ).equals ( "true" )){
			return true;
		}
		else {
			return false;
		}
	}
	private static boolean checkedMandatory(WebElement webElement) {
		return (webElement.getAttribute("class").contains("required"));
	}

	private static boolean checkedElementDisplayed(WebElement webElement) {
		return (webElement.isDisplayed());
	}
}
