package pages.doctorDashboard;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * 
 * @author Ajit
 *
 */
public class PatientDashboardPage {


	@FindBy(id = "patientDasbboardALId")
	private WebElement appOnPdList;
	@FindBy(xpath = "//div[@id='profileview']//button[@class='close']")
	private WebElement closeBTn;
	@FindBy(id = "patientTimeAmPm")
	private WebElement reachTime;
	@FindBy(id = "patientOccupation")
	private WebElement patientOccupation;
	@FindBy(id = "patientAddress")
	private WebElement patientAddress;
	@FindBy(id = "patientCity")
	private WebElement patientCity;
	@FindBy(id = "patientProfileEditBtn")
	private WebElement patientProfileEditBtn;
	
	@FindBy(xpath = "//a[@id='patientDasbboardWDId']") // removed 'span' to check xpath //a[@id='patientDasbboardWDId']/span
	private WebElement profileViewBtn;

	/*------------Patient Profile View Section-------*/
	@FindBy(className = "patientName")
	private WebElement patientName;
	@FindBy(id = "patientPublicId")
	private WebElement patientId;
	@FindBy(id = "profileviewLabel")
	private WebElement patientDetailsHeadInView;
	@FindBy(xpath="//a[text()='Info']")
	private WebElement patientProfileInfo;
	@FindBy(id = "patientInfoHistory")
	private WebElement patientProfileHistory;
	@FindBy(xpath = "//div[contains(text(),'Patient Information')]")
	private WebElement patientInformation;
	@FindBy(xpath="//b[text()='Gender']")
	private WebElement genderLabelInView;
	@FindBy(id = "patientGender")
	private WebElement patientGenderValue;
	@FindBy(xpath="//b[text()='Date of Birth']")
	private WebElement dobLabelInView;
	@FindBy(id = "patientDOB")
	private WebElement patientDOBValue;
	@FindBy(xpath="//b[text()='Age']")
	private WebElement ageLabelInView;
	@FindBy(id = "patientAge")
	private WebElement patientAgeValue;
	@FindBy(xpath="//b[text()='Email']")
	private WebElement emailLabelInView;
	@FindBy(id = "patientEmail")
	private WebElement patientEmailValue;
	@FindBy(xpath="//b[text()='Mobile']")
	private WebElement mobileLabelInView;
	@FindBy(id = "patientMobile")
	private WebElement patientMobile;
	@FindBy(xpath="//b[text()='Landline']")
	private WebElement landlineLabelInView;
	@FindBy(id = "patientLandline")
	private WebElement patientLandlineValue;
	@FindBy(xpath="//b[text()='Alternate Contact Name']")
	private WebElement alternateNameLabelInView;
	@FindBy(id = "patientEmergencyNext")
	private WebElement patientAlternateNameValue;
	@FindBy(xpath="//b[text()='Alternate Contact no.']")
	private WebElement alternateContactLabelInView;
	@FindBy(id = "patientRelationshipContact")
	private WebElement patientAlternateContactValue;
	@FindBy(xpath="//b[text()='Primary Dentist']")
	private WebElement primaryDentistLabelInView;
	@FindBy(id = "pDentist")
	private WebElement patientDentistValue;
	@FindBy(xpath="//b[text()='Best time to reach you']")
	private WebElement bestTimeReachLabelInView;
	@FindBy(id = "patientTimeAmPm")
	private WebElement patientTimeReachValue;
	@FindBy(xpath="//b[text()='Occupation']")
	private WebElement occupationLabelInView;
	@FindBy(id = "patientOccupation")
	private WebElement patientOccupationValue;
	@FindBy(xpath = "//div[contains(text(),'Address Information')]")
	private WebElement patientAddressInformation;
	@FindBy(xpath="//b[text()='Address']")
	private WebElement addressLabelInView;
	@FindBy(id = "patientAddress")
	private WebElement patientAddressValue;
	@FindBy(xpath="//b[text()='State']")
	private WebElement stateLabelInView;
	@FindBy(id = "patientState")
	private WebElement patientStateValue;
	@FindBy(xpath="//b[text()='Country']")
	private WebElement countryLabelInView;
	@FindBy(id = "patientCountry")
	private WebElement patientCountryValue;
	@FindBy(xpath="//b[text()='City']")
	private WebElement cityLabelInView;
	@FindBy(id = "patientCity")
	private WebElement patientCityValue;
	@FindBy(xpath="//b[text()='Postal Code']")
	private WebElement postalCodeLabelInView;
	@FindBy(id = "patientPostalCode")
	private WebElement patientPostalCodeValue;
	@FindBy(xpath = "//div[contains(text(),'Past History Information')]")
	private WebElement patientPastHistoryInformation;
	@FindBy(xpath="//div[@id='pastHistory']//th[text()='Date']")
	private WebElement dateLabelInView;
	@FindBy(xpath="//div[@id='pastHistory']//th[text()='Tooth no.(s)']")
	private WebElement toothNoLabelInView;
	@FindBy(xpath="//div[@id='pastHistory']//div[contains(@class,'tdvTooth')]")
	private WebElement patientToothNoInPastHistoryValue;
	@FindBy(xpath="//div[@id='pastHistory']//th[text()='Notes']")
	private WebElement notesLabelInView;
	@FindBy(xpath="//div[@id='pastHistory']//div[contains(@class,'tdvNotes')]")
	private WebElement patientNotesInPastHistoryValue;
	@FindBy(xpath = "//div[contains(text(),'Group Information')]")
	private WebElement patientGroupInformation;
	@FindBy(id = "patientGroup")
	private WebElement patientGroupValue;
	@FindBy(xpath = "//div[contains(text(),'Patient Notes')]")
	private WebElement patientPatientNotes;
	@FindBy(id = "patientNotes")
	private WebElement patientNotesValue;

	//-------Patient History Section --------//
	@FindBy(id = "patientInfoHistory")
	private WebElement patientHistoryTab;
	@FindBy(xpath = "//table[@id='communicationHistoryTable']//th[text()='Date']")
	private WebElement dateLabelInPatientHistory;
	@FindBy(xpath = "//table[@id='communicationHistoryTable']//th[text()='Created/Updated by']")
	private WebElement createdByLabelInPatientHistory;
	@FindBy(xpath = "//table[@id='communicationHistoryTable']//th[text()='Name']")
	private WebElement nameLabelInPatientHistory;
	@FindBy(xpath = "//table[@id='communicationHistoryTable']//th[text()='Mobile']")
	private WebElement mobileLabelInPatientHistory;
	@FindBy(xpath = "//table[@id='communicationHistoryTable']//th[text()='Email']")
	private WebElement emailLabelInPatientHistory;
	@FindBy(xpath = "(//table[@id='communicationHistoryTable']//span[@class='hightLighttext'])[1]")
	private WebElement updatedPatientName;


	@FindBy(id = "patientProfilePrintBtn")
	private WebElement print;
	@FindBy(xpath = "//div[@id='pastHistory']//div[contains(@class,'tdvTooth')]")
	private WebElement teethInPastHistory;
	@FindBy(id = "patientGroup")
	private WebElement patientGroup;
	@FindBy(id = "patientNotes")
	private WebElement patientNotes;
	// ---------------chief complaint webelement and reusable method--------
	@FindBy(id = "patientDasbboardCCList")
	private WebElement chiefComplaintListBtn;

	@FindBy(id = "patientDasbboardCCId")
	private WebElement chiefComplaintAddBtn;
	@FindBy(id = "patientAppointmentCallId")
	private WebElement appAddBtn;
	@FindBy(id = "oeAddBtn")
	private WebElement oralExamAddBtn;
	@FindBy(id = "oeListBtn")
	private WebElement oralExamListBtn;
	@FindBy(xpath = "//a[@id='diagAddBtn']/span")
	private WebElement diagnosticsTestAdd;
	@FindBy(id = "diagListBtn")
	public WebElement diagnosticsTestList;
	@FindBy(id = "patientDasbboardPreAddId")
	public WebElement prescriptionTestAdd;
	@FindBy(id="patientDasbboardPreListId")
	public WebElement prescriptionTestList;
	@FindBy(id="wonlistingaccess")
	public WebElement labWorkOrderBtn;
	@FindBy(id = "tpAddBtn")
	private WebElement TreatmentPlanAddBtn;
	@FindBy(id = "tpListBtn")
	private WebElement TreatmentPlanListBtn;
	@FindBy(id = "wdAddBtn")
	private WebElement WorkDoneAddBtn;
	@FindBy(id="wdhListBtn")
	private WebElement workDoneHistoryBtn;
	@FindBy(id="patientInvoiceCallId")
	private WebElement invoiceListBtn;
	@FindBy(id="patientRecieptCallId")
	private WebElement receiptListBtn;
	@FindBy(id="patientDasbboardFList")
	private WebElement filesListingBtn;
	@FindBy(id="patientDasbboardFId")
	private WebElement filesAddBtn;
	@FindBy(xpath = "//p[contains(text(),'I understand that this patient has amount overdue, but I want to continue with the treatment for this patient!')]")
	public WebElement amountDuePopup;
	@FindBy(xpath = "//div[@id='dueWarningView']//button[@id='dueYes']")
	public WebElement dueWarningYes;
	@FindBy(xpath = "//div[@class='modal fade in']")
	public static List<WebElement> dueWarningPopup;
	@FindBy(xpath = "//a[@class='inf_flag_blck green']")
	public WebElement greenFlagEdit;
	@FindBy(id="urgentPatientNamePidPD")
	private WebElement patientNamePage;
	@FindBy(xpath = "//span[contains(text(),'Medical Problems')]/following-sibling::span")
	private WebElement medicalProblemAlert;
	@FindBy(xpath = "//span[contains(text(),'Medications')]/following-sibling::span")
	private WebElement medicationAlert;
	@FindBy(xpath = "//span[contains(text(),'Allergies')]/following-sibling::span")
	private WebElement allergyAlert;
	@FindBy(xpath = "//a[@class='inf_flag_blck red']")
	private WebElement redFlag;
	@FindBy(xpath = "//*[text()='Appointments']")
	private WebElement appointments;
	@FindBy(xpath = "//div[@class='text-center lineHght12 ng-binding']")
	private List<WebElement> clickOnPatients;
	
	/*
	 * Product Sale Button WebElement within Patient Dashboard
	 */
	@FindBy(xpath = "//span[@class='cmnicons prdcts']")
	private WebElement productSaleButton;

	
	public WebElement getAppOnPdList() {
		return appOnPdList;
	}
	public WebElement getappointments() {
		return appointments;
	}
	public List<WebElement> getclickOnPatients() {
		return clickOnPatients;
	}
	public WebElement getCloseBTn() {
		return closeBTn;
	}

	public WebElement getReachTime() {
		return reachTime;
	}

	public WebElement getPatientOccupation() {
		return patientOccupation;
	}

	public WebElement getPatientAddress() {
		return patientAddress;
	}

	public WebElement getPatientCity() {
		return patientCity;
	}

	public WebElement getPatientProfileEditBtn() {
		return patientProfileEditBtn;
	}

	public WebElement getProfileViewBtn() {
		return profileViewBtn;
	}

	public WebElement getPatientName() {
		return patientName;
	}

	public WebElement getPatientId() {
		return patientId;
	}

	public WebElement getPatientDetailsHeadInView() {
		return patientDetailsHeadInView;
	}

	public WebElement getPatientProfileInfo() {
		return patientProfileInfo;
	}

	public WebElement getPatientProfileHistory() {
		return patientProfileHistory;
	}

	public WebElement getPatientInformation() {
		return patientInformation;
	}

	public WebElement getGenderLabelInView() {
		return genderLabelInView;
	}

	public WebElement getPatientGenderValue() {
		return patientGenderValue;
	}

	public WebElement getDobLabelInView() {
		return dobLabelInView;
	}

	public WebElement getPatientDOBValue() {
		return patientDOBValue;
	}

	public WebElement getAgeLabelInView() {
		return ageLabelInView;
	}

	public WebElement getPatientAgeValue() {
		return patientAgeValue;
	}

	public WebElement getEmailLabelInView() {
		return emailLabelInView;
	}

	public WebElement getPatientEmailValue() {
		return patientEmailValue;
	}

	public WebElement getMobileLabelInView() {
		return mobileLabelInView;
	}

	public WebElement getPatientMobile() {
		return patientMobile;
	}

	public WebElement getLandlineLabelInView() {
		return landlineLabelInView;
	}

	public WebElement getPatientLandlineValue() {
		return patientLandlineValue;
	}

	public WebElement getAlternateNameLabelInView() {
		return alternateNameLabelInView;
	}

	public WebElement getPatientAlternateNameValue() {
		return patientAlternateNameValue;
	}

	public WebElement getAlternateContactLabelInView() {
		return alternateContactLabelInView;
	}

	public WebElement getPatientAlternateContactValue() {
		return patientAlternateContactValue;
	}

	public WebElement getPrimaryDentistLabelInView() {
		return primaryDentistLabelInView;
	}

	public WebElement getPatientDentistValue() {
		return patientDentistValue;
	}

	public WebElement getBestTimeReachLabelInView() {
		return bestTimeReachLabelInView;
	}

	public WebElement getPatientTimeReachValue() {
		return patientTimeReachValue;
	}

	public WebElement getOccupationLabelInView() {
		return occupationLabelInView;
	}

	public WebElement getPatientOccupationValue() {
		return patientOccupationValue;
	}

	public WebElement getPatientAddressInformation() {
		return patientAddressInformation;
	}

	public WebElement getAddressLabelInView() {
		return addressLabelInView;
	}

	public WebElement getPatientAddressValue() {
		return patientAddressValue;
	}

	public WebElement getStateLabelInView() {
		return stateLabelInView;
	}

	public WebElement getPatientStateValue() {
		return patientStateValue;
	}

	public WebElement getCountryLabelInView() {
		return countryLabelInView;
	}

	public WebElement getPatientCountryValue() {
		return patientCountryValue;
	}

	public WebElement getCityLabelInView() {
		return cityLabelInView;
	}

	public WebElement getPatientCityValue() {
		return patientCityValue;
	}

	public WebElement getPostalCodeLabelInView() {
		return postalCodeLabelInView;
	}

	public WebElement getPatientPostalCodeValue() {
		return patientPostalCodeValue;
	}

	public WebElement getPatientPastHistoryInformation() {
		return patientPastHistoryInformation;
	}

	public WebElement getDateLabelInView() {
		return dateLabelInView;
	}

	public WebElement getToothNoLabelInView() {
		return toothNoLabelInView;
	}

	public WebElement getPatientToothNoInPastHistoryValue() {
		return patientToothNoInPastHistoryValue;
	}

	public WebElement getNotesLabelInView() {
		return notesLabelInView;
	}

	public WebElement getPatientNotesInPastHistoryValue() {
		return patientNotesInPastHistoryValue;
	}

	public WebElement getPatientGroupInformation() {
		return patientGroupInformation;
	}

	public WebElement getPatientGroupValue() {
		return patientGroupValue;
	}

	public WebElement getPatientPatientNotes() {
		return patientPatientNotes;
	}

	public WebElement getPatientNotesValue() {
		return patientNotesValue;
	}

	public WebElement getPatientHistoryTab() {
		return patientHistoryTab;
	}

	public WebElement getDateLabelInPatientHistory() {
		return dateLabelInPatientHistory;
	}

	public WebElement getCreatedByLabelInPatientHistory() {
		return createdByLabelInPatientHistory;
	}

	public WebElement getNameLabelInPatientHistory() {
		return nameLabelInPatientHistory;
	}

	public WebElement getMobileLabelInPatientHistory() {
		return mobileLabelInPatientHistory;
	}

	public WebElement getEmailLabelInPatientHistory() {
		return emailLabelInPatientHistory;
	}

	public WebElement getUpdatedPatientName() {
		return updatedPatientName;
	}

	public WebElement getPrint() {
		return print;
	}

	public WebElement getTeethInPastHistory() {
		return teethInPastHistory;
	}

	public WebElement getPatientGroup() {
		return patientGroup;
	}

	public WebElement getPatientNotes() {
		return patientNotes;
	}

	public WebElement getChiefComplaintListBtn() {
		return chiefComplaintListBtn;
	}

	public WebElement getChiefComplaintAddBtn() {
		return chiefComplaintAddBtn;
	}

	public WebElement getAppAddBtn() {
		return appAddBtn;
	}

	public WebElement getOralExamAddBtn() {
		return oralExamAddBtn;
	}

	public WebElement getOralExamListBtn() {
		return oralExamListBtn;
	}

	public WebElement getDiagnosticsTestAdd() {
		return diagnosticsTestAdd;
	}

	public WebElement getDiagnosticsTestList() {
		return diagnosticsTestList;
	}

	public WebElement getPrescriptionTestAdd() {
		return prescriptionTestAdd;
	}

	public WebElement getPrescriptionTestList() {
		return prescriptionTestList;
	}

	public WebElement getLabWorkOrderBtn() {
		return labWorkOrderBtn;
	}

	public WebElement getTreatmentPlanAddBtn() {
		return TreatmentPlanAddBtn;
	} 

	public WebElement getTreatmentPlanListBtn() {
		return TreatmentPlanListBtn;
	}

	public WebElement getWorkDoneAddBtn() {
		return WorkDoneAddBtn;
	}

	public WebElement getWorkDoneHistoryBtn() {
		return workDoneHistoryBtn;
	}

	public WebElement getInvoiceListBtn() {
		return invoiceListBtn;
	}

	public WebElement getReceiptListBtn() {
		return receiptListBtn;
	}

	public WebElement getFilesListingBtn() {
		return filesListingBtn;
	}

	public WebElement getFilesAddBtn() {
		return filesAddBtn;
	}

	public WebElement getAmountDuePopup() {
		return amountDuePopup;
	}

	public WebElement getDueWarningYes() {
		return dueWarningYes;
	}

	public List<WebElement> getDueWarningPopup() {
		return dueWarningPopup;
	}

	public WebElement getGreenFlagEdit() {
		return greenFlagEdit;
	}

	public WebElement getPatientNamePage() {
		return patientNamePage;
	}

	public WebElement getMedicalProblemAlert() {
		return medicalProblemAlert;
	}

	public WebElement getMedicationAlert() {
		return medicationAlert;
	}

	public WebElement getAllergyAlert() {
		return allergyAlert;
	}

	public WebElement getRedFlag() {
		return redFlag;
	}

	public WebElement getProductSaleButton() {
		return productSaleButton;
	}

	
}
