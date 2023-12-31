package pages.doctorDashboard;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


/**
 * 
 * @author Ajit
 *
 */
public class PatientRegistrationPage {
	
	@FindBy(id = "name")
	private WebElement patientName;
	@FindBy(xpath = "//label[text()='Gender']")
	private WebElement gender;
	@FindBy(xpath = "//label[text()='Gender']/sup[@class='required']")
	private WebElement genderRequired;
	@FindBy(xpath = "//label[text()='Male']")
	private WebElement genderMale;
	@FindBy(xpath = "//label[text()='Female']")
	private WebElement genderFemale;
	@FindBy(xpath = "//label[text()='Other']")
	private WebElement genderOther;
	@FindBy(id = "dob")
	private WebElement DOB;
	@FindBy(id = "age")
	private WebElement age;
	@FindBy(id = "email")
	private WebElement email;
	@FindBy(id = "mobile")
	private WebElement mobile;
	@FindBy(xpath = "//label[text()='Call']/preceding-sibling::input")
	private WebElement callCheckbox;
	@FindBy(xpath = "//label[text()='SMS']/preceding-sibling::input")
	private WebElement smsCheckbox;
	@FindBy(xpath = "//label[text()='Email']/preceding-sibling::input")
	private WebElement emailCheckbox;
	@FindBy(id = "landline")
	private WebElement landline;
	@FindBy(id = "alternateName")
	private WebElement alternateName;
	@FindBy(id = "alternateContact")
	private WebElement alternateContact;
	@FindBy(id = "primaryDentist")
	private WebElement primaryDentist;
	@FindBy(id = "reachtime")
	private WebElement reachtime;
	@FindBy(xpath = "//select[@id='occupation']")
	private WebElement occupation;
	@FindBy(xpath = "//input[@id='occupation']")
	private WebElement otherOccupation;
	@FindBy(id = "address")
	private WebElement addressTextBox;
	@FindBy(id = "city")
	private WebElement city;
	@FindBy(id = "Country")
	private WebElement country;
	@FindBy(id = "State")
	private WebElement state;
	@FindBy(id = "pin")
	private WebElement pin;
	@FindBy(xpath = "//div[contains(@class,'sideNavigation')]//i[text()='Approve & Save']")
	private WebElement approveSave;
	@FindBy(xpath = "//div[contains(@class,'sideNavigation')]//i[text()='Approve & Appt+']")
	private WebElement approveAppBtn;
	@FindBy(xpath = "//div[contains(@class,'sideNavigation')]//i[text()='Reset']")
	private WebElement Reset;
	@FindBy(xpath = "//div[contains(@class,'sideNavigation')]//i[text()='Cancel']")
	private WebElement Cancel;
	@FindBy(xpath = "//div[@id='wrapper']//input")
	private List<WebElement> allWebElements;
	@FindBy(xpath = "//div[@class='error ng-binding ng-scope']")
	private List<WebElement> errorMsg;
	@FindBy(id = "guardianName")
	private WebElement guardianName;
	@FindBy(id = "guardianContact")
	private WebElement guardianContact;
	@FindBy(id = "guardianContact")
	private List<WebElement> guardianContactSet;
	@FindBy(xpath = "//span[contains(text(),'Medical History')]")
	private WebElement medicalHistory;
	@FindBy(xpath = "//div[@class='form-group col-xs-12 col-sm-6 col-md-6 col-lg-6 ng-scope']")
	private List<WebElement> medicalHistoryDomains;
	@FindBy(xpath = "//span[contains(text(),'Past History')]")
	private WebElement pastHistory;
	@FindBy(xpath = "//span[contains(text(),'Add')]")
	private WebElement addBtnPastHistory;
	@FindBy(xpath = "//a[text()='Adult']")
	private WebElement adult;
	@FindBy(xpath = "//a[text()='Pedo']")
	private WebElement pedo;
	@FindBy(xpath = "//a[text()='Mixed']")
	private WebElement mixed;
	@FindBy(xpath = "//label[@for='alltooth']")
	private WebElement allToothCheckBox;
	@FindBy(xpath = "//ul[@id='childLowerJaw']//li")
	private List<WebElement> teethslowerPedo;
	@FindBy(xpath = "//ul[@id='childUpperJaw']//li")
	private List<WebElement> teethsUpperPedo;
	@FindBy(xpath = "//ul[@id='adultUpperJaw']//li")
	private List<WebElement> teethslowerAdult;
	@FindBy(xpath = "//ul[@id='adultUpperJaw']//li")
	private List<WebElement> teethsUpperAdult;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement saveBtn;
//	@FindBy(xpath = "//table[@class='table table-striped']//div[contains(@class,'tdvTooth')]")
	@FindBy(xpath = "//span[@class='btnLabel']/../../../..//div[contains(@class,'tdvTooth')]")
	private WebElement toothNoInPasstHistory;
	@FindBy(xpath = "//table[@class='table table-striped']//div[contains(@class,'tdvNotes')]")
	private WebElement notesPastHistory;
	@FindBy(xpath = "//table[@class='table table-striped']//span[contains(@class,'actn-icn delete')]")
	private WebElement actionBtn;
//	@FindBy(xpath = "(//div[contains(text(),'Note(s)')]/following-sibling::div//textarea[@id='notes'])[2]")
	@FindBy(id = "notes")
	private WebElement notes;
	@FindBy(xpath = "(//span[text()='Delete'])[1]")
	private WebElement DeleteBtnInPastHistory;
	@FindBy(xpath = "//span[contains(text(),'Medication')]")
	private WebElement medication;
	@FindBy(xpath = "//label[contains(text(),'Are you on medication?')]/following-sibling::div//label[text()='Yes']")
	private WebElement yesOnMedication;
	@FindBy(xpath = "//label[contains(text(),'Are you on medication?')]/following-sibling::div//label[text()='No']")
	private WebElement noOnMedication;
	@FindBy(xpath = "//label[contains(text(),'Are you on medication?')]/following-sibling::div//label[text()='NA']")
	private WebElement naOnMedication;
	@FindBy(xpath = "//label[contains(text(),'Are you on medication?')]/..//label[text()='Yes']")
	private WebElement medicationCheckUpYesBtn;
	@FindBy(xpath = "//div[text()='Enter medication details']")
	private WebElement enterMedicationDetails;
	@FindBy(xpath = "//div[text()='Enter allergy(s) details']")
	private WebElement enterAllergyDetails;
	@FindBy(xpath = "//span[contains(text(),'Dental Checkup')]")
	private WebElement dentalCheckup;
	@FindBy(xpath = "//label[contains(text(),'Less than 6 month')]")
	private WebElement lessThanSixMonth;
	@FindBy(xpath = "//label[contains(text(),'More than 6 month')]")
	private WebElement moreThanSixMonth;
	@FindBy(xpath = "//label[contains(text(),'More than 1 year')]")
	private WebElement moreThanOneYr;
	@FindBy(xpath = "//span[contains(text(),'Allergies')]")
	private WebElement allergies;
	@FindBy(xpath = "//label[contains(text(),'Allergies to any medications?')]/..//label[text()='Yes']")
	private WebElement allergiesYesBtn;
	@FindBy(xpath = "//label[contains(text(),'Allergies to any medications?')]/..//label[text()='No']")
	private WebElement allergiesNoBtn;
	@FindBy(xpath = "//label[contains(text(),'Allergies to any medications?')]/..//label[text()='NA']")
	private WebElement allergiesNABtn;
	@FindBy(id = "specifyallrg")
	private WebElement allrgTxtArea;
	@FindBy(xpath = "//Span[contains(text(),'Group')]")
	private WebElement group;
	@FindBy(id = "groups")
	private WebElement groupTextfields;
	@FindBy(xpath = "//Span[contains(text(),'Patient Notes')]")
	private WebElement patientNotes;
	@FindBy(id = "patientnotes")
	private WebElement patientNotesTextFields;
	@FindBy(id = "patientInfoHistory")
	private WebElement patientHistory;
	@FindBy(xpath = "//div[@id='patientHistoryInfoList']//th[text()='Date']")
	private WebElement datePatientHistory;
	@FindBy(xpath = "//div[@id='patientHistoryInfoList']//th[text()='Created/Updated by']")
	private WebElement createdDatePatientHistory;
	@FindBy(xpath = "//div[@id='patientHistoryInfoList']//th[text()='Name']")
	private WebElement namePatientHistory;
	@FindBy(xpath = "//div[@id='patientHistoryInfoList']//th[text()='Mobile']")
	private WebElement mobliePatientHistory;
	@FindBy(xpath = "//div[@id='patientHistoryInfoList']//th[text()='Email']")
	private WebElement emailPatientHistory;
	@FindBy(xpath = "//div[@id='patientHistoryInfoList']//strong[text()='Address » ']")
	private List<WebElement> address;
	@FindBy(xpath = "//div[text()='Enter patient name']")
	private WebElement enterPatientNameMsg;
	@FindBy(xpath = "//div[text()='Select gender']")
	private WebElement selectGenderMsg;
	@FindBy(xpath = "//div[text()='Enter mobile no.']")
	private WebElement enterMobileNoMsg;
	@FindBy(xpath = "//div[text()='Enter 10 digit mobile no.']")
	private WebElement enterTenDigitMobileNoMsg;
	@FindBy(xpath = "//div[text()='Enter a valid mobile no.']")
	private WebElement enterValidMobileNoMsg;
	@FindBy(xpath = "//div[text()='Enter alternate contact name']")
	private WebElement enterAlternateContactNameMsg;
	@FindBy(xpath = "//div[text()='Enter alternate contact no.']")
	private WebElement enterAlternateContactNoMsg;
	@FindBy(xpath = "//div[text()='Enter guardian name']")
	private WebElement enterGuardianNameMsg;
	@FindBy(xpath = "//div[text()='Enter guardian contact no.']")
	private WebElement enterGuardianContactNoMsg;
	@FindBy(xpath = "//div[contains(text(),'Enter email id')]")
	private WebElement validateEnterEmailErrMsg;
	@FindBy(xpath = "//div[contains(text(),'Invalid Email!')]")
	private WebElement validateInvalidEmailErrMsg;
	@FindBy(xpath = "//span[contains(text(),'Verified!')]")
	private WebElement verifiedEmailMsg;
	//past history column name
	@FindBy(xpath = "//td[text()='Date']")
	private WebElement dateColumn;
	@FindBy(xpath = "//td[text()='Tooth No(s)']")
	private WebElement toothNoColumn;
	@FindBy(xpath = "//td[text()='Created By']")
	private WebElement createdByColumn;
	@FindBy(xpath = "//td[text()='Notes']")
	private WebElement notesColumn;
	@FindBy(xpath = "//td[text()='Action']")
	private WebElement actionColumn;
	@FindBy(id="specifymedictn")
	private WebElement medicationTextFields;
	@FindBy(id="specifyallrg")
	private WebElement alleryTextField;
	@FindBy(xpath = "//span[text()='Name and phone already exist']")
	private WebElement nameAndPhoneAlreadyExit;
	@FindBy(xpath = "//img[@class='spinner']")
	private WebElement spinnerLogo;
	
	
	public WebElement getPatientName() {
		return patientName;
	}
	public WebElement getGender() {
		return gender;
	}
	public WebElement getGenderRequired() {
		return genderRequired;
	}
	public WebElement getGenderMale() {
		return genderMale;
	}
	public WebElement getGenderFemale() {
		return genderFemale;
	}
	public WebElement getGenderOther() {
		return genderOther;
	}
	public WebElement getDOB() {
		return DOB;
	}
	public WebElement getAge() {
		return age;
	}
	public WebElement getEmail() {
		return email;
	}
	public WebElement getMobile() {
		return mobile;
	}
	public WebElement getCallCheckbox() {
		return callCheckbox;
	}
	public WebElement getSmsCheckbox() {
		return smsCheckbox;
	}
	public WebElement getEmailCheckbox() {
		return emailCheckbox;
	}
	public WebElement getLandline() {
		return landline;
	}
	public WebElement getAlternateName() {
		return alternateName;
	}
	public WebElement getAlternateContact() {
		return alternateContact;
	}
	public WebElement getPrimaryDentist() {
		return primaryDentist;
	}
	public WebElement getReachtime() {
		return reachtime;
	}
	public WebElement getOccupation() {
		return occupation;
	}
	public WebElement getOtherOccupation() {
		return otherOccupation;
	}
	public WebElement getAddressTextBox() {
		return addressTextBox;
	}
	public WebElement getCity() {
		return city;
	}
	public WebElement getCountry() {
		return country;
	}
	public WebElement getState() {
		return state;
	}
	public WebElement getPin() {
		return pin;
	}
	public WebElement getApproveSave() {
		return approveSave;
	}
	public WebElement getApproveAppBtn() {
		return approveAppBtn;
	}
	public WebElement getReset() {
		return Reset;
	}
	public WebElement getCancel() {
		return Cancel;
	}
	public List<WebElement> getAllWebElements() {
		return allWebElements;
	}
	public List<WebElement> getErrorMsg() {
		return errorMsg;
	}
	public WebElement getGuardianName() {
		return guardianName;
	}
	public WebElement getGuardianContact() {
		return guardianContact;
	}
	public List<WebElement> getGuardianContactSet() {
		return guardianContactSet;
	}
	public WebElement getMedicalHistory() {
		return medicalHistory;
	}
	public List<WebElement> getMedicalHistoryDomains() {
		return medicalHistoryDomains;
	}
	public WebElement getPastHistory() {
		return pastHistory;
	}
	public WebElement getAddBtnPastHistory() {
		return addBtnPastHistory;
	}
	public WebElement getAdult() {
		return adult;
	}
	public WebElement getPedo() {
		return pedo;
	}
	public WebElement getMixed() {
		return mixed;
	}
	public WebElement getAllToothCheckBox() {
		return allToothCheckBox;
	}
	public List<WebElement> getTeethslowerPedo() {
		return teethslowerPedo;
	}
	public List<WebElement> getTeethsUpperPedo() {
		return teethsUpperPedo;
	}
	public List<WebElement> getTeethslowerAdult() {
		return teethslowerAdult;
	}
	public List<WebElement> getTeethsUpperAdult() {
		return teethsUpperAdult;
	}
	public WebElement getSaveBtn() {
		return saveBtn;
	}
	public WebElement getToothNoInPasstHistory() {
		return toothNoInPasstHistory;
	}
	public WebElement getNotesPastHistory() {
		return notesPastHistory;
	}
	public WebElement getActionBtn() {
		return actionBtn;
	}
	public WebElement getNotes() {
		return notes;
	}
	public WebElement getDeleteBtnInPastHistory() {
		return DeleteBtnInPastHistory;
	}
	public WebElement getMedication() {
		return medication;
	}
	public WebElement getYesOnMedication() {
		return yesOnMedication;
	}
	public WebElement getNoOnMedication() {
		return noOnMedication;
	}
	public WebElement getNaOnMedication() {
		return naOnMedication;
	}
	public WebElement getMedicationCheckUpYesBtn() {
		return medicationCheckUpYesBtn;
	}
	public WebElement getEnterMedicationDetails() {
		return enterMedicationDetails;
	}
	public WebElement getEnterAllergyDetails() {
		return enterAllergyDetails;
	}
	public WebElement getDentalCheckup() {
		return dentalCheckup;
	}
	public WebElement getLessThanSixMonth() {
		return lessThanSixMonth;
	}
	public WebElement getMoreThanSixMonth() {
		return moreThanSixMonth;
	}
	public WebElement getMoreThanOneYr() {
		return moreThanOneYr;
	}
	public WebElement getAllergies() {
		return allergies;
	}
	public WebElement getAllergiesYesBtn() {
		return allergiesYesBtn;
	}
	public WebElement getAllergiesNoBtn() {
		return allergiesNoBtn;
	}
	public WebElement getAllergiesNABtn() {
		return allergiesNABtn;
	}
	public WebElement getAllrgTxtArea() {
		return allrgTxtArea;
	}
	public WebElement getGroup() {
		return group;
	}
	public WebElement getGroupTextfields() {
		return groupTextfields;
	}
	public WebElement getPatientNotes() {
		return patientNotes;
	}
	public WebElement getPatientNotesTextFields() {
		return patientNotesTextFields;
	}
	public WebElement getPatientHistory() {
		return patientHistory;
	}
	public WebElement getDatePatientHistory() {
		return datePatientHistory;
	}
	public WebElement getCreatedDatePatientHistory() {
		return createdDatePatientHistory;
	}
	public WebElement getNamePatientHistory() {
		return namePatientHistory;
	}
	public WebElement getMobliePatientHistory() {
		return mobliePatientHistory;
	}
	public WebElement getEmailPatientHistory() {
		return emailPatientHistory;
	}
	public List<WebElement> getAddress() {
		return address;
	}
	public WebElement getEnterPatientNameMsg() {
		return enterPatientNameMsg;
	}
	public WebElement getSelectGenderMsg() {
		return selectGenderMsg;
	}
	public WebElement getEnterMobileNoMsg() {
		return enterMobileNoMsg;
	}
	public WebElement getEnterTenDigitMobileNoMsg() {
		return enterTenDigitMobileNoMsg;
	}
	public WebElement getEnterValidMobileNoMsg() {
		return enterValidMobileNoMsg;
	}
	public WebElement getEnterAlternateContactNameMsg() {
		return enterAlternateContactNameMsg;
	}
	public WebElement getEnterAlternateContactNoMsg() {
		return enterAlternateContactNoMsg;
	}
	public WebElement getEnterGuardianNameMsg() {
		return enterGuardianNameMsg;
	}
	public WebElement getEnterGuardianContactNoMsg() {
		return enterGuardianContactNoMsg;
	}
	public WebElement getValidateEnterEmailErrMsg() {
		return validateEnterEmailErrMsg;
	}
	public WebElement getValidateInvalidEmailErrMsg() {
		return validateInvalidEmailErrMsg;
	}
	public WebElement getVerifiedEmailMsg() {
		return verifiedEmailMsg;
	}
	public WebElement getDateColumn() {
		return dateColumn;
	}
	public WebElement getToothNoColumn() {
		return toothNoColumn;
	}
	public WebElement getCreatedByColumn() {
		return createdByColumn;
	}
	public WebElement getNotesColumn() {
		return notesColumn;
	}
	public WebElement getActionColumn() {
		return actionColumn;
	}
	public WebElement getMedicationTextFields() {
		return medicationTextFields;
	}
	public WebElement getAlleryTextField() {
		return alleryTextField;
	}
	public WebElement getNameAndPhoneAlreadyExit() {
		return nameAndPhoneAlreadyExit;
	}
	public WebElement getSpinnerLogo() {
		return spinnerLogo;
	}

	
}
