package pageActions.patientDashboard;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import base.BaseClass;
import pages.patientDashboard.DiagnosticTestsPage;

public class DiagnosticTestsPageActions extends BaseClass {
	
	static DiagnosticTestsPage diagnosticTestsPage = PageFactory.initElements(driver, DiagnosticTestsPage.class);


	/* Checked diagnosis Added successfully message */
	public static void checkedSuccessAlert() {
		    BaseClass.waitForSpinnerToDisappear();
			BaseClass.softAssert().assertTrue(checkedElementDisplayed(diagnosticTestsPage.getDiagnosisAddSuccessAlertMsg()));
			BaseClass.waitForElementToDisappear(diagnosticTestsPage.getDiagnosisAddSuccessAlertMsg());
		BaseClass.waitForElementToDisappear((By.xpath("//span[@class='ng-binding ng-scope']")));
			
	}
	
	
		
			public static void checkedUpdateSuccessAlert() {
	    BaseClass.waitForSpinnerToDisappear();
	    WebElement wb = driver.findElement((By.xpath("//span[contains(text(),'Investigation(s) added successfully!')]")));
		BaseClass.softAssert().assertTrue(checkedElementDisplayed(wb));
		BaseClass.waitForElementToDisappear((By.xpath("//span[@class='ng-binding ng-scope']")));
}
	
//	public static void checkedSuccessAlert() {
//		BaseClass.WaitTillElementIsPresent(diagnosticTestsPage.getDiagnosisAddSuccessAlertMsg());
//		try {
//			Thread.sleep(1000);
//			BaseClass.softAssert().assertTrue(checkedElementDisplayed(diagnosticTestsPage.getDiagnosisAddSuccessAlertMsg()));
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

	/* checked message when saving diagnosis without selecting any diagnosis */
	public static void withoutDiagnosisAlert() {
		BaseClass.WaitTillElementIsPresent(diagnosticTestsPage.getDiagnosisSelectAlertMsg());
		Assert.assertTrue(checkedElementDisplayed(diagnosticTestsPage.getDiagnosisSelectAlertMsg()));
		BaseClass.waitForElementToDisappear((By.xpath("//span[contains(text(),'Please select an Investigation')]")));
	}

	/* checked message when saving IOPAR without selecting any teeth */
	public static void withoutIoparAlert() {
		    BaseClass.waitForElementVisibility(diagnosticTestsPage.getIoparToothSelectAlertMsg(), 4000);
			BaseClass.softAssert().assertTrue(checkedElementDisplayed(diagnosticTestsPage.getIoparToothSelectAlertMsg()));
			BaseClass.waitForElementToDisappear((By.xpath("//span[@class='ng-binding ng-scope']")));
	}
	
//	public static void withoutIoparAlert() {
//		try {
//			Thread.sleep(1500);
//			BaseClass.softAssert().assertTrue(checkedElementDisplayed(diagnosticTestsPage.getIoparToothSelectAlertMsg()));
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//	}

	/* clicking on the IOPAR */
//	public static void clickIopar() {
//		try {
//			Thread.sleep(2000);
//			BaseClass.waitForElementToBeClickable(diagnosticTestsPage.getIoparButton());
//			diagnosticTestsPage.getIoparButton().click();
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//	}
	
	public static void clickIopar() {
		    BaseClass.waitForSpinnerToDisappear();
		    BaseClass.waitForModalOverlayToDisappear();
		    BaseClass.waitForPageToBecomeActive();
			BaseClass.waitForElementVisibility(diagnosticTestsPage.getIoparButton(),4000);
			diagnosticTestsPage.getIoparButton().click();
			BaseClass.waitForSpinnerToDisappear();
	}

	/* clicking on the Imaging */
	public static void clickImaging() {
		BaseClass.waitForSpinnerToDisappear();
		BaseClass.waitForPageToBecomeActive();
		BaseClass.waitForElementVisibility(diagnosticTestsPage.getImagingButton(),4000);
		BaseClass.waitForElementToBeClickable(diagnosticTestsPage.getImagingButton());
		diagnosticTestsPage.getImagingButton().click();
		BaseClass.waitForSpinnerToDisappear();
	}
	
//	public static void clickImaging() {
//		try {
//			Thread.sleep(3500);
//			diagnosticTestsPage.getImagingButton().click();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

	/* clicking on the blood */
	public static void clickBlood() {
		    BaseClass.waitForSpinnerToDisappear();
		    BaseClass.waitForPageToBecomeActive();
			BaseClass.waitForElementVisibility(diagnosticTestsPage.getBloodButton(),4000);
			diagnosticTestsPage.getBloodButton().click();
	}
	
	
	
	
//	public static void clickBlood() {
//		try {
//			Thread.sleep(2500);
//			diagnosticTestsPage.getBloodButton().click();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

	/* clicking on the Urine */
	public static void clickUrine() {
            BaseClass.waitForSpinnerToDisappear();
            BaseClass.waitForPageToBecomeActive();
			BaseClass.waitForElementVisibility(diagnosticTestsPage.getUrineButton(),4000);
			diagnosticTestsPage.getUrineButton().click();
	}
	
	
//	public static void clickUrine() {
//		try {
//			Thread.sleep(1500);
//			diagnosticTestsPage.getUrineButton().click();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

	/* clicking on the biochemical */
	public static void clickBiochemicalButton() {
		    BaseClass.waitForSpinnerToDisappear();
		    BaseClass.waitForPageToBecomeActive();
			BaseClass.waitForElementVisibility(diagnosticTestsPage.getBiochemicalButton(),4000);
			diagnosticTestsPage.getBiochemicalButton().click();
	}
	
	
	
//	public static void clickBiochemicalButton() {
//		try {
//			Thread.sleep(1500);
//			diagnosticTestsPage.getBiochemicalButton().click();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

	/* clicking on the Markers */
	
	public static void clickMarkersButton() {
		BaseClass.waitForSpinnerToDisappear();
		 BaseClass.waitForPageToBecomeActive();
		BaseClass.waitForElementVisibility(diagnosticTestsPage.getMarkersButton(),4000);
			diagnosticTestsPage.getMarkersButton().click();
	}
	
//	public static void clickMarkersButton() {
//		try {
//			Thread.sleep(1500);
//			diagnosticTestsPage.getMarkersButton().click();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

	/* selecting teeth from the IOPAR popup */
	
	public static void selectTeeth(String teethType, String teethNo) {
			WebElement webElement = driver.findElement(By.xpath(
					"//div[contains(@ng-include,'" + teethType + "IOPAR.shtml')]//span[text()='" + teethNo + "']"));
			BaseClass.waitForElementToBeClickable(webElement);
			webElement.click();
	}
//	public static void selectTeeth(String teethType, String teethNo) {
//		try {
//			Thread.sleep(1500);
//			WebElement webElement = driver.findElement(By.xpath(
//					"//div[contains(@ng-include,'" + teethType + "IOPAR.shtml')]//span[text()='" + teethNo + "']"));
//			BaseClass.waitForElementToBeClickable(webElement);
//			webElement.click();
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//	}

	/* saving the diagnosis */
	public static void saveDiagnosis() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(diagnosticTestsPage.getSaveButton());
		BaseClass.executeScript(diagnosticTestsPage.getSaveButton());
	}

	/* closing the diagnosis popup */
	public static void closeDiagnosisPopup() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(diagnosticTestsPage.getCloseButton());
		diagnosticTestsPage.getCloseButton().click();
	}

	/* clicking the diagnosticTestsPage.getPedo() */
	
	public static void clickPedo() {
		   BaseClass.waitForElementVisibility(diagnosticTestsPage.getPedo(), 4000);
			diagnosticTestsPage.getPedo().click();
			WebElement element = driver.findElement((By.xpath("//li[@heading='Pedo']/../..//span[@id='55']")));
			BaseClass.waitForElementVisibility(element, 4000);
	}
//	public static void clickPedo() {
//		try {
//			Thread.sleep(1500);
//			BaseClass.waitForElementToBeClickable(diagnosticTestsPage.getPedo());
//			diagnosticTestsPage.getPedo().click();
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//	}

	/* clicking the adult */
	public static void clickAdult() {
		BaseClass.waitForElementVisibility(diagnosticTestsPage.getAdult(), 4000);
		diagnosticTestsPage.getAdult().click();
		WebElement element = driver.findElement((By.xpath("(//li[@heading='Mixed']/../..//span[@class='tooth18'])[]")));
		BaseClass.waitForElementVisibility(element, 4000);
	}

	/* clicking the mixed */
	public static void clickMixed() {
		   BaseClass.waitForElementVisibility(diagnosticTestsPage.getMixed(), 4000);
		    diagnosticTestsPage.getMixed().click();
			WebElement element = driver.findElement((By.xpath("(//li[@heading='Mixed']/../..//span[@class='tooth18'])[2]")));
			BaseClass.waitForElementVisibility(element, 4000);	
	}
	
//	public static void clickMixed() {
//		try {
//			Thread.sleep(1500);
//			BaseClass.waitForElementToBeClickable(diagnosticTestsPage.getMixed());
//			diagnosticTestsPage.getMixed().click();
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//	}

	/* entering the diagnosis notes */
	public static void enterDiagnosisNotes(String note) {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(diagnosticTestsPage.getDiagnosticsNotes());
		diagnosticTestsPage.getDiagnosticsNotes().sendKeys(note);
	}

	/* Diagnostic Notes should be shown entered in edit */
	public static void verifyEnteredDiagnosisNotes() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(diagnosticTestsPage.getDiagnosticsNotes());
		Assert.assertFalse(diagnosticTestsPage.getNotesLimitMsg().getText().contains("768 Character"));
	}

	/* checked diagnosticTestsPage.getPedo() total teeths */
	public static void checkedPedoTeeths() {
		BaseClass.waitForPageLoad();
		Assert.assertTrue(diagnosticTestsPage.getPedoTeeths().size() == 20);
	}

	/* checked adult total teeths */
	public static void checkedAdultTeeths() {
		BaseClass.waitForPageLoad();
		Assert.assertTrue(diagnosticTestsPage.getAdultTeeths().size() == 32);
	}

	/* checked mixed total teeths */
	public static void checkedMixedTeeths() {
		BaseClass.waitForPageLoad();
		Assert.assertTrue(diagnosticTestsPage.getMixedTeeths().size() == 52);
	}

	/* checking the oral Exam button, file upload and treatment plan */
	public static void checked_Trt_oralExam_file_Btn() {
		BaseClass.waitForSpinnerToDisappear();
		BaseClass.waitForElementToBeClickable(diagnosticTestsPage.getFileButton());
		Assert.assertTrue(checkedElementDisplayed(diagnosticTestsPage.getOralExamButton()) && checkedElementDisplayed(diagnosticTestsPage.getFileButton())
				&& checkedElementDisplayed(diagnosticTestsPage.getTreatmentButton()));
	}

	/* checking the diagnosis boxes appears on the Diagnosis Add page */
	public static void checkedDiagnosisBox() {
		BaseClass.waitForElementVisibility(diagnosticTestsPage.getIoparButton(), 4000);
		Assert.assertTrue(checkedElementDisplayed(diagnosticTestsPage.getIoparButton()) && checkedElementDisplayed(diagnosticTestsPage.getImagingButton())
				&& checkedElementDisplayed(diagnosticTestsPage.getBloodButton()) && checkedElementDisplayed(diagnosticTestsPage.getUrineButton())
				&& checkedElementDisplayed(diagnosticTestsPage.getBiochemicalButton()) && checkedElementDisplayed(diagnosticTestsPage.getMarkersButton()));
	}

	/*
	 * checking the header of the popup when we open any diagnosis for selecting
	 * Particular test
	 */
	public static void checkedDiagnosisHeader(String diagnosisHeader) {
		BaseClass.waitForSpinnerToDisappear();
		BaseClass.WaitTillElementIsPresent(diagnosticTestsPage.getHeaderDiagnosis());
		Assert.assertTrue(diagnosticTestsPage.getHeaderDiagnosis().getText().contains(diagnosisHeader));
	}

	/* checking the save button, notes fields and close button */
	public static void checked_Save_Close_Notes() {
		BaseClass.waitForElementVisibility(diagnosticTestsPage.getSaveButton(),4000);
		Assert.assertTrue(checkedElementDisplayed(diagnosticTestsPage.getSaveButton()) && checkedElementDisplayed(diagnosticTestsPage.getCloseButton())
				&& checkedElementDisplayed(diagnosticTestsPage.getDiagnosticsNotes()) && checkedElementDisplayed(diagnosticTestsPage.getNotesLimitMsg())
				&& diagnosticTestsPage.getDiagnosticsNotes().getAttribute("maxlength").contains("768"));
	}

	/* checking the Adult selected at the iopar */
	public static void checkedAdultSelected() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(diagnosticTestsPage.getAdult());
		Assert.assertTrue(diagnosticTestsPage.getSelectedAdult().getAttribute("class").contains("first-nav ng-isolate-scope active")
				&& checkedElementDisplayed(diagnosticTestsPage.getAdult()) && checkedElementDisplayed(diagnosticTestsPage.getPedo()) && checkedElementDisplayed(diagnosticTestsPage.getMixed()));
	}

	/* checking the diagnosticTestsPage.getPedo() selected at the iopar */
	public static void checkedPedoSelected() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(diagnosticTestsPage.getPedo());
		Assert.assertTrue(diagnosticTestsPage.getSelectedPedo().getAttribute("class").contains("first-nav ng-isolate-scope active")
				&& checkedElementDisplayed(diagnosticTestsPage.getAdult()) && checkedElementDisplayed(diagnosticTestsPage.getPedo()) && checkedElementDisplayed(diagnosticTestsPage.getMixed()));
	}

	/* checking the mixed selected at the iopar */
	public static void checkedMixedSelected() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(diagnosticTestsPage.getMixed());
		Assert.assertTrue(diagnosticTestsPage.getSelectedMixed().getAttribute("class").contains("first-nav ng-isolate-scope active")
				&& checkedElementDisplayed(diagnosticTestsPage.getAdult()) && checkedElementDisplayed(diagnosticTestsPage.getPedo()) && checkedElementDisplayed(diagnosticTestsPage.getMixed()));
	}

	/* checking all Imaging diagnosis */
	public static void checkedImagingDiagnosis() {
		BaseClass.waitForSpinnerToDisappear();;
		BaseClass.waitForElementVisibility(diagnosticTestsPage.getSaveButton(),4000);
		Assert.assertTrue(checkedElementDisplayed(diagnosticTestsPage.getOpg()) && checkedElementDisplayed(diagnosticTestsPage.getLateralCephalogram())
				&& checkedElementDisplayed(diagnosticTestsPage.getcBCT()) && checkedElementDisplayed(diagnosticTestsPage.getcECT()) && checkedElementDisplayed(diagnosticTestsPage.getBitewing())
				&& checkedElementDisplayed(diagnosticTestsPage.getOcclusal()) && checkedElementDisplayed(diagnosticTestsPage.getuSG())
				&& checkedElementDisplayed(diagnosticTestsPage.getSubmentovertex()) && checkedElementDisplayed(diagnosticTestsPage.getpAView())
				&& checkedElementDisplayed(diagnosticTestsPage.getOccipetoMental()));
	}

	/* checking all Blood diagnosis */
	public static void checkedBloodDiagnosis() {
		BaseClass.waitForSpinnerToDisappear();
		BaseClass.waitForElementToBeClickable(diagnosticTestsPage.getSaveButton());
		Assert.assertTrue(checkedElementDisplayed(diagnosticTestsPage.getmCH()) && checkedElementDisplayed(diagnosticTestsPage.getmPV()) && checkedElementDisplayed(diagnosticTestsPage.getmCV())
				&& checkedElementDisplayed(diagnosticTestsPage.getmCHC()) && checkedElementDisplayed(diagnosticTestsPage.getbT_CT())
				&& checkedElementDisplayed(diagnosticTestsPage.getHematocrit()) && checkedElementDisplayed(diagnosticTestsPage.getHemoglobin())
				&& checkedElementDisplayed(diagnosticTestsPage.getPlatletCount()) && checkedElementDisplayed(diagnosticTestsPage.getpT_INR())
				&& checkedElementDisplayed(diagnosticTestsPage.getrBC()) && checkedElementDisplayed(diagnosticTestsPage.getwBC()) && checkedElementDisplayed(diagnosticTestsPage.getrBS())
				&& checkedElementDisplayed(diagnosticTestsPage.gettLC()) && checkedElementDisplayed(diagnosticTestsPage.getdLC()) && checkedElementDisplayed(diagnosticTestsPage.getHbA1C())
				&& checkedElementDisplayed(diagnosticTestsPage.getBloodSugarFasting()) && checkedElementDisplayed(diagnosticTestsPage.getBloodSugarPP()));
	}

	/* checking all Urine diagnosis */
	public static void checkedUrineDiagnosis() {
		BaseClass.waitForSpinnerToDisappear();;
		BaseClass.waitForElementToBeClickable(diagnosticTestsPage.getSaveButton());
		Assert.assertTrue(checkedElementDisplayed(diagnosticTestsPage.getUrineRoutine()) && checkedElementDisplayed(diagnosticTestsPage.getUrineMicroscopic()));
	}

	/* checking all Bio chemical diagnosis */
	public static void checkedBioChemicalDiagnosis() {
		BaseClass.waitForSpinnerToDisappear();;
		BaseClass.waitForElementToBeClickable(diagnosticTestsPage.getSaveButton());
		Assert.assertTrue(checkedElementDisplayed(diagnosticTestsPage.getlFT()) && checkedElementDisplayed(diagnosticTestsPage.getaLP()) && checkedElementDisplayed(diagnosticTestsPage.getaLT())
				&& checkedElementDisplayed(diagnosticTestsPage.getaSt()) && checkedElementDisplayed(diagnosticTestsPage.getBilirubin()) && checkedElementDisplayed(diagnosticTestsPage.getgGT())
				&& checkedElementDisplayed(diagnosticTestsPage.getColour()) && checkedElementDisplayed(diagnosticTestsPage.getDensity()) && checkedElementDisplayed(diagnosticTestsPage.getpH())
				&& checkedElementDisplayed(diagnosticTestsPage.getAlbumin()));
	}

	/* checking all Markers diagnosis */
	public static void checkedMarkersDiagnosis() {
		BaseClass.waitForSpinnerToDisappear();;
		BaseClass.waitForElementToBeClickable(diagnosticTestsPage.getSaveButton());
		Assert.assertTrue(checkedElementDisplayed(diagnosticTestsPage.getC_RP()) && checkedElementDisplayed(diagnosticTestsPage.getViralAntibodies())
				&& checkedElementDisplayed(diagnosticTestsPage.getBiopsy()) && checkedElementDisplayed(diagnosticTestsPage.getCulture_Sensitivity())
				&& checkedElementDisplayed(diagnosticTestsPage.getThroatSwab()) && checkedElementDisplayed(diagnosticTestsPage.getpCR()));
	}

	/* checking all column name at diagnosis Add page */
	public static void checkedDiagnosisInputListData() {
		try {
			Thread.sleep(2000);
			BaseClass.WaitTillElementIsPresent(diagnosticTestsPage.getCategoryDiagnosisInputList());
			Assert.assertTrue(checkedElementDisplayed(diagnosticTestsPage.getCategoryDiagnosisInputList())
					&& checkedElementDisplayed(diagnosticTestsPage.getInvestigationDiagnosisInputList())
					&& checkedElementDisplayed(diagnosticTestsPage.getNotesDiagnosisInputList())
					&& checkedElementDisplayed(diagnosticTestsPage.getActionDiagnosisInputList()));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/* checking the category name at input list */
	public static void checkedCategory(String category) {
		BaseClass.waitForPageLoad();
		Assert.assertTrue(checkedElementDisplayed(driver
				.findElement(By.xpath("//table[@id='diagnoInputList']//td[text()='" + category + "']"))));
	}

	/* checking the investigation at input list */
	public static void checkedInvestigation(String category, String investigation) {
		BaseClass.waitForPageLoad();
		if (category.equals("IOPAR")) {
			Assert.assertTrue(checkedElementDisplayed(driver.findElement(By.xpath(
					"//td[text()='" + category + "']/following-sibling::td//div[text()='" + investigation + "']"))));
		} else {
			Assert.assertTrue(checkedElementDisplayed(driver.findElement(By.xpath(
					"//td[text()='" + category + "']/following-sibling::td//span[text()='" + investigation + "']"))));
		}
	}

	/* selecting the diagnosis */
	public static void selectDiagnosis(String diagnosis) {		
			WebElement webElement = driver.findElement(By.xpath("//span[@class ='ng-binding' and contains(text(),'"+diagnosis+"')]"));
			BaseClass.waitForElementVisibility(webElement, 4000);
			webElement.click();
	}
	
//	public static void selectDiagnosis(String diagnosis) {
//		try {
//			Thread.sleep(1500);
//			WebElement webElement = driver.findElement(By.xpath("//span[text()='" + diagnosis + "']"));
//			BaseClass.waitForElementToBeClickable(webElement);
//			webElement.click();
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//	}

	/* check Investigation is selected at the time of Diagnostic Edit */
	public static void checkSelectedInvestigation(String investigation) {
	        BaseClass.waitForSpinnerToDisappear();
	        BaseClass.waitForElementVisibility(diagnosticTestsPage.getSaveButton(),4000);
			WebElement webElement = driver.findElement(By.xpath("//div[contains(@data-ng-class,'selected')]/span[text()='"+investigation+"']"));
			BaseClass.waitForElementToBeClickable(webElement);
			webElement.isSelected();
	}
	
	
//	public static void checkSelectedInvestigation(String investigation) {
//		try {
//			Thread.sleep(1500);
//			WebElement webElement = driver.findElement(By.xpath("//div[contains(@data-ng-class,'selected')]/span[text()='"+investigation+"']"));
//			BaseClass.waitForElementToBeClickable(webElement);
//			webElement.isSelected();
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//	}

	/* checking the delete button with investigation */
	public static void checkedDeleteWithInvestigation(String category, String investigation) {
		BaseClass.waitForPageLoad();
		if (category.equals("IOPAR")) {
			Assert.assertTrue(checkedElementDisplayed(driver
					.findElement(By.xpath("//td[text()='" + category + "']/following-sibling::td//div[text()='"
							+ investigation + "']/following-sibling::div[@class='actnsVertIcns DiagDelInvest']"))));
		} else {
			Assert.assertTrue(checkedElementDisplayed(driver
					.findElement(By.xpath("//td[text()='" + category + "']/following-sibling::td//span[text()='"
							+ investigation + "']/following-sibling::div[@class='actnsVertIcns DiagDelInvest']"))));
		}
	}

	/* click deleted button with investigation */
	public static void clickDeleteWithInvestigation(String category, String investigation) {
		BaseClass.waitForPageLoad();
		if (category.equals("IOPAR")) {
			WebElement deleteBtn = driver
					.findElement(By.xpath("//td[text()='" + category + "']/following-sibling::td//div[text()='"
							+ investigation + "']/following-sibling::div[@class='actnsVertIcns DiagDelInvest']"));
			deleteBtn.click();
		} else {
			WebElement deleteBtn = driver
					.findElement(By.xpath("//td[text()='" + category + "']/following-sibling::td//span[text()='"
							+ investigation + "']/following-sibling::div[@class='actnsVertIcns DiagDelInvest']"));
			deleteBtn.click();
		}
	}
	
	/* checking the notes at the input listing */
	public static void notesDiagnosisInputList(String category, String investigation, String notes) {
		BaseClass.waitForPageLoad();
		if (category.equals("IOPAR")) {
			Assert.assertTrue(driver.findElement(By.xpath("//td[text()='" + category
					+ "']/following-sibling::td//div[text()='" + investigation
					+ "']/following-sibling::div[@class='actnsVertIcns DiagDelInvest']/../following-sibling::div[contains(@class,'ioparInListNotes ')]"))
					.getText().equalsIgnoreCase(notes));
		} else {
			Assert.assertTrue(driver
					.findElement(By.xpath("//td[text()='" + category
							+ "']/following-sibling::td/div[contains(@class,'wrd-brk-wrd')]"))
					.getText().equalsIgnoreCase(notes));
		}
	}

	/* checking the Delete button at input list for diagnosis */
	public static void checkedDeleteBtnInputlist(String category) {
		BaseClass.waitForPageLoad();
		Assert.assertTrue(checkedElementDisplayed(driver.findElement(
				By.xpath("//td[text()='" + category + "']/following-sibling::td//span[text()='Delete']"))));
	}

	/* click the Delete button at input list for diagnosis */
	public static void clickDeleteBtnInputlist(String category) {
		BaseClass.waitForPageLoad();
		WebElement deleteBtn = driver.findElement(By.xpath("//td[text()='" + category + "']/following-sibling::td//span[text()='Delete']"));
		deleteBtn.click();
	}

	/* checking the Edit button at input list for diagnosis */
	public static void checkedEditBtnInputlist(String category) {
		BaseClass.waitForPageLoad();
		if (category.equals("IOPAR")) {
			Assert.assertTrue(driver.findElement(By.xpath("//td[text()='" + category + "']/following-sibling::td//span[text()='Edit']/.."))
					.getAttribute("data-ng-class").contains("hide"));
		} else {
			Assert.assertTrue(checkedElementDisplayed(driver.findElement(
					By.xpath("//td[text()='" + category + "']/following-sibling::td//span[text()='Edit']"))));
		}
	}

	/* click on Edit button at input list for diagnosis */
	public static void clickEditBtnInputlist(String category) {
		BaseClass.waitForPageLoad();
		if (category.equals("IOPAR")) {
			Assert.assertTrue(driver.findElement(By.xpath("//td[text()='" + category + "']/following-sibling::td//span[text()='Edit']/.."))
					.getAttribute("data-ng-class").contains("hide"));
		} else {
			WebElement editBtn = driver.findElement(By.xpath("//td[text()='" + category + "']/following-sibling::td//span[text()='Edit']"));
			editBtn.click();
		}
	}
	
	/* check delete Message against Investigation and from main action button*/
	public static void checkMsgOnDeleteModal(String delete){
		BaseClass.waitForPageLoad();
		if(delete.equals("Investigation")) 
			Assert.assertTrue(checkedElementDisplayed(diagnosticTestsPage.getDeleteInvestigationMsg())); 
		else
			Assert.assertTrue(checkedElementDisplayed(diagnosticTestsPage.getDeleteCategoryMsg()));
	}
	
	/* click on Yes button shown after click on Delete button at input list for diagnosis */
	public static void clickYesDeleteBtn() {
		BaseClass.waitForPageLoad();
		diagnosticTestsPage.getYesDeleteBtn().click();
	}
	
	/* click on No button shown after click on Delete button at input list for diagnosis */
	public static void clickNoDeleteBtn() {
		BaseClass.waitForPageLoad();
		diagnosticTestsPage.getNoDeleteBtn().click();
	}

	/* Checked diagnosis Added successfully message */
	public static void checkedSuccessDeleteAlert() {
		    BaseClass.WaitTillElementIsPresent(diagnosticTestsPage.getDiagnosisDeleteSuccessAlertMsg());
			BaseClass.softAssert().assertTrue(checkedElementDisplayed(diagnosticTestsPage.getDiagnosisDeleteSuccessAlertMsg()));
	}
	
//	public static void checkedSuccessDeleteAlert() {
//		BaseClass.WaitTillElementIsPresent(diagnosticTestsPage.getDiagnosisDeleteSuccessAlertMsg());
//		try {
//			Thread.sleep(1000);
//			BaseClass.softAssert().assertTrue(checkedElementDisplayed(diagnosticTestsPage.getDiagnosisDeleteSuccessAlertMsg()));
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
	private static boolean checkedElementDisplayed(WebElement webElement) {
		return (webElement.isDisplayed());
	}

}
