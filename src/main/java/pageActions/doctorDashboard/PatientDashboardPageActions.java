package pageActions.doctorDashboard;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.BaseClass;
import pages.doctorDashboard.Login;
import pages.doctorDashboard.PatientDashboardPage;

import java.util.ArrayList;

/**
 * 
 * @author Ajit
 *
 */
public class PatientDashboardPageActions extends BaseClass {

	static Login loginPage = PageFactory.initElements(driver, Login.class);
	static PatientDashboardPage patientDashboardPage = PageFactory.initElements(driver, PatientDashboardPage.class);

	public static void checkPatientRedFlag() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(patientDashboardPage.getRedFlag());
		Assert.assertTrue(checkedWebElementDisplayed(patientDashboardPage.getRedFlag()));
	}

	public static void patientNamePatientDashboard(String patient_name) {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(patientDashboardPage.getPatientNamePage());
		String[] split = patientDashboardPage.getPatientNamePage().getText().trim().split(":");
		String patient = split[0].trim();
		String patientId = split[1].trim();
		Assert.assertTrue(
				patient.equalsIgnoreCase(patient_name) && !(patientId.contains("NA") || patientId.contains("null")));
	}

	public static void openCovidForm() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(patientDashboardPage.getGreenFlagEdit());
		patientDashboardPage.getGreenFlagEdit().click();
	}

	public static void hideDueWarningPopup() {
		BaseClass.waitForSpinnerToDisappear();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (patientDashboardPage.getAmountDuePopup().isDisplayed()) {
			patientDashboardPage.getDueWarningYes().click();
		}
	}

//	public static void hideDueWarningPopup() {
//		BaseClass.waitForPageLoad();
//		if(patientDashboardPage.getAmountDuePopup().isDisplayed()) {
//			try {
//				Thread.sleep(5500);
//				patientDashboardPage.getDueWarningYes().click();
//				//			for (WebElement ele:patientDashboardPage.getDueWarningYes()) {
//				//				patientDashboardPage.getDueWarningYes().get(0).click();
//				//			}
//				Thread.sleep(3000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
//	}

	public static void clickOnFilesAdd() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(patientDashboardPage.getFilesAddBtn());
		try {
			patientDashboardPage.getFilesAddBtn().click();
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void clickOnFilesList() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(patientDashboardPage.getFilesListingBtn());
		try {
			patientDashboardPage.getFilesListingBtn().click();
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void clickOnInvoiceList() {
		BaseClass.waitForSpinnerToDisappear();
		BaseClass.waitForModalBackdropToDisappear();
		BaseClass.waitForElementVisibility(patientDashboardPage.getInvoiceListBtn(), 4000);
		BaseClass.waitForElementToBeClickable(patientDashboardPage.getInvoiceListBtn());
		patientDashboardPage.getInvoiceListBtn().click();
		driver.navigate().refresh();
		BaseClass.waitForSpinnerToDisappear();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

//	public static void clickOnInvoiceList() {
//		BaseClass.waitForPageLoad();
//		BaseClass.waitForElementToBeClickable(patientDashboardPage.getInvoiceListBtn());
//		try {
//			patientDashboardPage.getInvoiceListBtn().click();
//			Thread.sleep(3000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

	public static void clickOnReceiptList() {
		BaseClass.waitForSpinnerToDisappear();
		BaseClass.waitForElementVisibility(patientDashboardPage.getReceiptListBtn(), 4000);
		BaseClass.waitForModalBackdropToDisappear();
		BaseClass.waitForUIWidgetOverlayToDisappear();
		patientDashboardPage.getReceiptListBtn().click();
		BaseClass.waitForSpinnerToDisappear();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void clickOnWorkDoneAdd() {
		BaseClass.waitForElementVisibility(patientDashboardPage.getWorkDoneAddBtn(), 4000);
		patientDashboardPage.getWorkDoneAddBtn().click();
		BaseClass.waitForPageLoad();
		BaseClass.waitForSpinnerToDisappear();
	}

//	public static void clickOnWorkDoneAdd() {
//		BaseClass.waitForPageLoad();
//		BaseClass.waitForElementToBeClickable(patientDashboardPage.getWorkDoneAddBtn());
//		try {
//			patientDashboardPage.getWorkDoneAddBtn().click();
//			Thread.sleep(6000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

	public static void clickOnWorkDoneHistory() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(patientDashboardPage.getWorkDoneHistoryBtn());
		try {
			patientDashboardPage.getWorkDoneHistoryBtn().click();
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void clickOnTreatmentPlanListBtn() {
		BaseClass.waitForSpinnerToDisappear();
		BaseClass.waitForElementVisibility(patientDashboardPage.getTreatmentPlanListBtn(), 4000);
		BaseClass.waitForUIWidgetOverlayToDisappear();
		patientDashboardPage.getTreatmentPlanListBtn().click();
		BaseClass.waitForSpinnerToDisappear();
		BaseClass.waitForModalOverlayToDisappear();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

//	public static void clickOnTreatmentPlanListBtn() {
//		BaseClass.waitForPageLoad();
//		BaseClass.waitForElementToBeClickable(patientDashboardPage.getTreatmentPlanListBtn());
//		try {
//			patientDashboardPage.getTreatmentPlanListBtn().click();
//			Thread.sleep(3000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

	public static void clickOnTreatmentPlanAddBtn() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForSpinnerToDisappear();
		BaseClass.waitForElementVisibility(patientDashboardPage.getTreatmentPlanAddBtn(), 4000);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		patientDashboardPage.getTreatmentPlanAddBtn().click();
		BaseClass.waitForPageLoad();
		BaseClass.waitForSpinnerToDisappear();
	}

//	public static void clickOnTreatmentPlanAddBtn() {
//		BaseClass.waitForPageLoad();
//		BaseClass.waitForElementToBeClickable(patientDashboardPage.getTreatmentPlanAddBtn());
//		try {
//			patientDashboardPage.getTreatmentPlanAddBtn().click();
//			Thread.sleep(5000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//	}

	public static void clickOnOralExamAdd() {
		BaseClass.waitForPageLoad();
		BaseClass.WaitTillElementIsPresent(patientDashboardPage.getOralExamAddBtn());
		patientDashboardPage.getOralExamAddBtn().click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

	public static void clickOnOralExamList() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(patientDashboardPage.getOralExamListBtn());
		patientDashboardPage.getOralExamListBtn().click();
	}

	public static void clickOnAppList() {
		BaseClass.waitForSpinnerToDisappear();
//		BaseClass.waitForPageToBecomeActive();
//		BaseClass.waitForPageLoad();
		BaseClass.waitForUIWidgetOverlayToDisappear();
		BaseClass.waitForElementToBeClickable(patientDashboardPage.getAppOnPdList());
		patientDashboardPage.getAppOnPdList().click();
	}

	public static void clickOnAppAdd() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(patientDashboardPage.getAppAddBtn());
		try {
			Thread.sleep(2000);
			patientDashboardPage.getAppAddBtn().click();
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void clickOnChiefComplaintAddBtn() {
		BaseClass.waitForSpinnerToDisappear();
//		BaseClass.waitForPageLoad();\BaseClass
		BaseClass.waitForElementVisibility(patientDashboardPage.getChiefComplaintAddBtn(), 4000);
		BaseClass.waitForElementToBeClickable(patientDashboardPage.getChiefComplaintAddBtn());
		patientDashboardPage.getChiefComplaintAddBtn().click();
		BaseClass.waitForSpinnerToDisappear();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void clickOnChiefComplaintlistBtn() {
		BaseClass.waitForSpinnerToDisappear();
		BaseClass.waitForElementVisibility(patientDashboardPage.getChiefComplaintListBtn(), 4000);
		BaseClass.waitForElementToBeClickable(patientDashboardPage.getChiefComplaintListBtn());
		patientDashboardPage.getChiefComplaintListBtn().click();
	}

//	public static void clickOnChiefComplaintlistBtn() {
//		BaseClass.waitForPageLoad();
//		BaseClass.waitForElementToBeClickable(patientDashboardPage.getChiefComplaintListBtn());
//		try {
//			Thread.sleep(2000);
//			patientDashboardPage.getChiefComplaintListBtn().click();
//			Thread.sleep(6000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

	public static void clickOnDiagnosticsTestAdd() {
		BaseClass.waitForPageLoad();
		BaseClass.WaitTillElementIsPresent(patientDashboardPage.getDiagnosticsTestAdd());
		patientDashboardPage.getDiagnosticsTestAdd().click();
		driver.navigate().refresh();
	}

	public static void clickOnDiagnosticsTestList() {
		BaseClass.waitForPageLoad();
		BaseClass.WaitTillElementIsPresent(patientDashboardPage.getDiagnosticsTestList());
		patientDashboardPage.getDiagnosticsTestList().click();
		BaseClass.waitForSpinnerToDisappear();
	}

	public static void clickOnPrescriptionTestAdd() {
		BaseClass.waitForPageLoad();
		BaseClass.WaitTillElementIsPresent(patientDashboardPage.getPrescriptionTestAdd());
		patientDashboardPage.getPrescriptionTestAdd().click();
		driver.navigate().refresh();
	}

	public static void clickOnPrescriptionTestList() {
		BaseClass.waitForPageLoad();
		BaseClass.WaitTillElementIsPresent(patientDashboardPage.getPrescriptionTestList());
		patientDashboardPage.getPrescriptionTestList().click();
	}

	public static void clickOnLabWorkOrderAdd() {
		BaseClass.waitForPageLoad();
		BaseClass.WaitTillElementIsPresent(patientDashboardPage.getLabWorkOrderBtn());
		patientDashboardPage.getLabWorkOrderBtn().click();
		BaseClass.waitForPageLoad();
		BaseClass.waitForSpinnerToDisappear();
	}

	/*---------------------reusable method-----------------------*/
	public static void clickOnProfileViewBtn() {

		BaseClass.waitForModalOverlayToDisappear();
		BaseClass.waitForElementVisibility(patientDashboardPage.getProfileViewBtn(), 4000);
		try {
		System.out.println(patientDashboardPage.getProfileViewBtn().isDisplayed());
		BaseClass.waitForElementToBeClickable(patientDashboardPage.getProfileViewBtn());
		patientDashboardPage.getProfileViewBtn().click();
		BaseClass.waitForSpinnerToDisappear();
		}
		catch(NoSuchElementException e) {
			
		}

	}

	public static void clickProfileEditBtn() {
		BaseClass.waitForSpinnerToDisappear();
		BaseClass.waitForElementToBeClickable(patientDashboardPage.getPatientProfileEditBtn());
		BaseClass.hoverOnElement(patientDashboardPage.getPatientProfileEditBtn());
		patientDashboardPage.getPatientProfileEditBtn().click();
		driver.navigate().refresh();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void clickOnClosePopUp() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(patientDashboardPage.getCloseBTn());
		patientDashboardPage.getCloseBTn().click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/* These all are related to Patient Profile View */
	public static void verifyPatientProfileViewPopUp(String PatientName) {
		BaseClass.waitForElementToBeClickable(patientDashboardPage.getPatientName());
		Assert.assertTrue(patientDashboardPage.getPatientName().getText().contains(PatientName));
	}

	public static void checkAllDataInPatientProfileView() {
		BaseClass.waitForPageLoad();
		Assert.assertTrue(checkedWebElementDisplayed(patientDashboardPage.getPatientProfileInfo())
				&& checkedWebElementDisplayed(patientDashboardPage.getPatientInformation())
				&& checkedWebElementDisplayed(patientDashboardPage.getGenderLabelInView())
				&& checkedWebElementDisplayed(patientDashboardPage.getDobLabelInView())
				&& checkedWebElementDisplayed(patientDashboardPage.getAgeLabelInView())
				&& checkedWebElementDisplayed(patientDashboardPage.getAgeLabelInView())
				&& checkedWebElementDisplayed(patientDashboardPage.getMobileLabelInView())
				&& checkedWebElementDisplayed(patientDashboardPage.getPrimaryDentistLabelInView())
				&& checkedWebElementDisplayed(patientDashboardPage.getLandlineLabelInView())
				&& checkedWebElementDisplayed(patientDashboardPage.getAlternateContactLabelInView())
				&& checkedWebElementDisplayed(patientDashboardPage.getBestTimeReachLabelInView())
				&& checkedWebElementDisplayed(patientDashboardPage.getOccupationLabelInView())
				&& checkedWebElementDisplayed(patientDashboardPage.getPatientAddressInformation())
				&& checkedWebElementDisplayed(patientDashboardPage.getAddressLabelInView())
				&& checkedWebElementDisplayed(patientDashboardPage.getStateLabelInView())
				&& checkedWebElementDisplayed(patientDashboardPage.getCityLabelInView())
				&& checkedWebElementDisplayed(patientDashboardPage.getCountryLabelInView())
				&& checkedWebElementDisplayed(patientDashboardPage.getPostalCodeLabelInView())
				&& checkedWebElementDisplayed(patientDashboardPage.getPatientPastHistoryInformation())
				&& checkedWebElementDisplayed(patientDashboardPage.getDateLabelInView())
				&& checkedWebElementDisplayed(patientDashboardPage.getToothNoLabelInView())
				&& checkedWebElementDisplayed(patientDashboardPage.getNotesLabelInView())
				&& checkedWebElementDisplayed(patientDashboardPage.getPatientGroupInformation())
				&& checkedWebElementDisplayed(patientDashboardPage.getPatientGroupValue())
				&& checkedWebElementDisplayed(patientDashboardPage.getPatientPatientNotes()));
	}

	public static void verifyHeadInProfileView() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForSpinnerToDisappear();
		BaseClass.waitForElementVisibility(patientDashboardPage.getPatientDetailsHeadInView(), 4000);
		Assert.assertTrue(checkedWebElementDisplayed(patientDashboardPage.getPatientDetailsHeadInView()));
	}

	public static void verifyGenderOnPatientProfile(String gender) {
		BaseClass.waitForElementToBeClickable(patientDashboardPage.getPatientName());
		Assert.assertTrue(patientDashboardPage.getPatientGenderValue().getText().contains(gender));
	}

	public static void verifyPatientNameIDOnPatientProfile(String PatientName) {
		BaseClass.waitForElementToBeClickable(patientDashboardPage.getPatientName());
		String patientID = patientDashboardPage.getPatientId().getText().trim();
		Assert.assertTrue(patientDashboardPage.getPatientName().getText().contains(PatientName)
				&& !(patientID.contains("NA") || patientID.contains("null") || patientID.contains(" ")));
	}

	public static void verifyPatientEmailOnPatientProfile(String patientEmail) {
		BaseClass.waitForElementToBeClickable(patientDashboardPage.getPatientEmailValue());
//		Assert.assertTrue(patientDashboardPage.getPatientEmailValue().getText().contains(patientEmail));
		Assert.assertEquals(patientDashboardPage.getPatientEmailValue().getText(), patientEmail.trim());
	}

	public static void verifyPatientMoblieOnPatientProfile(String PatientMobile) {
		BaseClass.waitForElementToBeClickable(patientDashboardPage.getPatientMobile());
		Assert.assertTrue(patientDashboardPage.getPatientMobile().getText().contains(PatientMobile));
	}

	public static void verifyAgeOnPatientProfile(String PatientAge) {
		BaseClass.waitForElementToBeClickable(patientDashboardPage.getPatientAgeValue());
		BaseClass.waitForElementVisibility(patientDashboardPage.getPatientAgeValue(), 4000);
		String patntAgeVal = patientDashboardPage.getPatientAgeValue().getText().trim();
		Assert.assertEquals(patntAgeVal, PatientAge.trim());
	}

	public static void verifyAlternateNameOnPatientProfile(String AlternateName) {
		BaseClass.waitForElementToBeClickable(patientDashboardPage.getPatientAlternateNameValue());
		Assert.assertTrue(patientDashboardPage.getPatientAlternateNameValue().getText().contains(AlternateName));
	}

	public static void verifyAlterNateNoOnPatientProfile(String AlternateNo) {
		BaseClass.waitForElementToBeClickable(patientDashboardPage.getPatientAlternateContactValue());
		Assert.assertTrue(patientDashboardPage.getPatientAlternateContactValue().getText().contains(AlternateNo));
	}

	public static void verifyPrimaryDentistOnPatientProfile(String primaryDentist) {
		BaseClass.waitForElementToBeClickable(patientDashboardPage.getPatientDentistValue());
		Assert.assertTrue(patientDashboardPage.getPatientDentistValue().getText().contains(primaryDentist));
	}

	public static void verifyTimeReachOnPatientProfile(String bestTime) {
		BaseClass.waitForElementToBeClickable(patientDashboardPage.getPatientTimeReachValue());
		Assert.assertTrue(patientDashboardPage.getPatientTimeReachValue().getText().contains(bestTime));
	}

	public static void verifyOccupationOnPatientProfile(String occupation) {
		BaseClass.waitForElementToBeClickable(patientDashboardPage.getPatientOccupationValue());
		Assert.assertTrue(patientDashboardPage.getPatientOccupationValue().getText().contains(occupation));
	}

	public static void verifyAddressOnPatientProfile(String address) {
		BaseClass.waitForElementToBeClickable(patientDashboardPage.getPatientAddressValue());
		Assert.assertTrue(patientDashboardPage.getPatientAddressValue().getText().contains(address));
	}

	public static void verifyStateOnPatientProfile(String state) {
		BaseClass.waitForElementToBeClickable(patientDashboardPage.getPatientStateValue());
		Assert.assertTrue(patientDashboardPage.getPatientStateValue().getText().contains(state));
	}

	public static void verifyCountryOnPatientProfile(String country) {
		BaseClass.waitForElementToBeClickable(patientDashboardPage.getPatientCountryValue());
		Assert.assertTrue(patientDashboardPage.getPatientCountryValue().getText().contains(country));
	}

	public static void verifyCityOnPatientProfile(String city) {
		BaseClass.waitForElementToBeClickable(patientDashboardPage.getPatientCityValue());
		Assert.assertTrue(patientDashboardPage.getPatientCityValue().getText().contains(city));
	}

	public static void verifyPostalCodeOnPatientProfile(String postalCode) {
		BaseClass.waitForElementToBeClickable(patientDashboardPage.getPatientPostalCodeValue());
		Assert.assertTrue(patientDashboardPage.getPatientPostalCodeValue().getText().contains(postalCode));
		Assert.assertEquals(postalCode.trim(), patientDashboardPage.getPatientPostalCodeValue().getText().trim());
	}

	public static void verifyToothNoOnPatientProfile(String[] teeths) {
		BaseClass.waitForPageLoad();
		String expectedTeeths = patientDashboardPage.getPatientToothNoInPastHistoryValue().getText();
		int noOfTeeth = teeths.length;
		if (noOfTeeth > 1) {
			String[] expectedTeethsArr = expectedTeeths.split(",");
			Assert.assertEquals(expectedTeethsArr.length, noOfTeeth);
			for (int i = 0; i < noOfTeeth; i++) {
				System.out.println(expectedTeethsArr[i]);
				Assert.assertEquals(expectedTeethsArr[i], teeths[i]);
			}
		} else {
			Assert.assertEquals(expectedTeeths.length(), teeths.length);
			Assert.assertEquals(expectedTeeths, teeths[0]);
		}
	}

//	public static void verifyToothNoOnPatientProfile(String toothNo) {
//		BaseClass.waitForElementToBeClickable(patientDashboardPage.getPatientToothNoInPastHistoryValue());
//		Assert.assertTrue(patientDashboardPage.getPatientToothNoInPastHistoryValue().getText().contains(toothNo));
//	}

	public static void verifyNotesOnPastHistoryPatientProfile(String notes) {
		BaseClass.waitForElementToBeClickable(patientDashboardPage.getPatientNotesInPastHistoryValue());
		Assert.assertTrue(patientDashboardPage.getPatientNotesInPastHistoryValue().getText().contains(notes));
	}

	public static void verifyGroupNameOnPatientProfile(String group) {
		BaseClass.waitForElementToBeClickable(patientDashboardPage.getPatientGroup());
		Assert.assertTrue(patientDashboardPage.getPatientGroup().getText().contains(group));
	}

	public static void verifyPatientNotesOnPatientProfile(String patientNotes) {
		BaseClass.waitForElementToBeClickable(patientDashboardPage.getPatientNotesValue());
		Assert.assertTrue(patientDashboardPage.getPatientNotesValue().getText().contains(patientNotes));
	}

	/** Patient History functions ***/
	public static void clickHistoryOnPatientProfile() {
		BaseClass.waitForElementToBeClickable(patientDashboardPage.getPatientHistoryTab());
		patientDashboardPage.getPatientHistoryTab().click();
	}

	public static void checkAllDataInPatientHistoryView() {
		BaseClass.waitForPageLoad();
		Assert.assertTrue(checkedWebElementDisplayed(patientDashboardPage.getDateLabelInPatientHistory())
				&& checkedWebElementDisplayed(patientDashboardPage.getCreatedByLabelInPatientHistory())
				&& checkedWebElementDisplayed(patientDashboardPage.getNameLabelInPatientHistory())
				&& checkedWebElementDisplayed(patientDashboardPage.getMobileLabelInPatientHistory())
				&& checkedWebElementDisplayed(patientDashboardPage.getEmailLabelInPatientHistory()));
	}

	public static void clickOnPrint() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(patientDashboardPage.getPrint());
		BaseClass.hoverOnElement(patientDashboardPage.getPrint());
		patientDashboardPage.getPrint().click();
	}

	public static void selectedTeethVerificationPatientDashboard(String teeth) {
		BaseClass.waitForElementToBeClickable(patientDashboardPage.getTeethInPastHistory());
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertTrue(patientDashboardPage.getTeethInPastHistory().getText().contains(teeth));
	}

	public static void medicalProblemAlertModal(String medicalProblem, String medicalStatus) {
		BaseClass.waitForElementToBeClickable(patientDashboardPage.getMedicalProblemAlert());
		String medicalProblemOnAlert = patientDashboardPage.getMedicalProblemAlert().getText();
		String medicalProbleAndStatus = medicalProblem + " " + medicalStatus;
		boolean result = medicalProblemOnAlert.contains(",");
		if (result) {
			String[] medicalProbAlrtArr = medicalProblemOnAlert.split(",");
			ArrayList<String> medicalProbList = new ArrayList<String>(medicalProbAlrtArr.length);
			for (int i = 0; i < medicalProbAlrtArr.length; i++) {
				medicalProbList.add(medicalProbAlrtArr[i].trim());
			}
			boolean isMedicalProblemPresent = medicalProbList.contains(medicalProbleAndStatus);
			Assert.assertEquals(isMedicalProblemPresent, true);
		} else {
			Assert.assertEquals(medicalProblemOnAlert.trim(), medicalProbleAndStatus);
		}

//		Assert.assertTrue(patientDashboardPage.getMedicalProblemAlert().getText().contains(medication));
	}

	public static void medicationAlertModal(String medication) {
		BaseClass.waitForElementToBeClickable(patientDashboardPage.getMedicationAlert());
		Assert.assertTrue(patientDashboardPage.getMedicationAlert().getText().contains(medication));
	}

	public static void allergiesAlertModal(String allergies) {
		BaseClass.waitForElementToBeClickable(patientDashboardPage.getAllergyAlert());
		Assert.assertTrue(patientDashboardPage.getAllergyAlert().getText().contains(allergies));
	}

	public static boolean verifyProductSalesButton() {
		BaseClass.waitForPageLoad();
		BaseClass.WaitTillElementIsPresent(patientDashboardPage.getProductSaleButton());
		BaseClass.waitForElementToBeClickable(patientDashboardPage.getProductSaleButton());
		return patientDashboardPage.getProductSaleButton().isDisplayed();
	}

	public static void clickOnProductSaleButton() {
		BaseClass.waitForPageLoad();
		BaseClass.WaitTillElementIsPresent(patientDashboardPage.getProductSaleButton());
		BaseClass.waitForElementToBeClickable(patientDashboardPage.getProductSaleButton());
		patientDashboardPage.getProductSaleButton().click();
	}

	private static boolean checkedWebElementDisplayed(WebElement webElement) {
		return (webElement.isDisplayed());
	}
}
