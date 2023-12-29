package pages.patientDashboard;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class PrescriptionListingPage {
	
	/* -----webElement in Main List-----------*/
	@FindBy(xpath = "//*[text()='No Record Found!']")
	private WebElement noRecordFoundMsg;
	@FindBy(xpath = "//i[text()='Add New']")
	private WebElement addNewBtn;
	@FindBy(xpath = "//div[@class='dtNClncs orlExmDateNClnc']/following-sibling::div//th[text()='Brand Name']")
	private WebElement brandNameMainList;
	@FindBy(xpath = "//div[@class='dtNClncs orlExmDateNClnc']/following-sibling::div//th[text()='Generic Name']")
	private WebElement genericNameMainList;
	@FindBy(xpath = "//div[@class='dtNClncs orlExmDateNClnc']/following-sibling::div//th[text()='Strength']")
	private WebElement strengthNameMainList;
	@FindBy(xpath = "//div[@class='dtNClncs orlExmDateNClnc']/following-sibling::div//th[text()='Duration']")
	private WebElement durationNameMainList;
	@FindBy(xpath = "//div[@class='dtNClncs orlExmDateNClnc']/following-sibling::div//th[text()='Route']")
	private WebElement routeNameMainList;
	@FindBy(xpath = "//div[@class='dtNClncs orlExmDateNClnc']/following-sibling::div//th[text()='Dosage']")
	private WebElement dosageNameMainList;
	@FindBy(xpath = "//div[@class='dtNClncs orlExmDateNClnc']/following-sibling::div//th[text()='Instruction']")
	private WebElement instructionNameMainList;
	@FindBy(xpath = "//div[@class='dtNClncs orlExmDateNClnc']/following-sibling::div//th[text()='Prescribe By']")
	private WebElement prescribeByMainList;

	/*---WebElement in View Pop up----*/
	@FindBy(xpath = "//h4[contains(@class,'modal-title')]")
	private WebElement headInView;
	@FindBy(xpath = "(//a[@class='btn ng-scope']/span[text()='View'])[1]")
	private WebElement viewBtn;
	@FindBy(xpath = "(//a[@class='btn ng-scope']/span[text()='Edit'])[1]")
	private WebElement editBtn;
	@FindBy(xpath = "//h4[contains(text(),'Patient Prescription Detail')]/following-sibling::span[contains(@class,'text-right pnameid')]")
	private WebElement dateInView;
	@FindBy(xpath = "//h4[text()='Patient Prescription Detail']")
	private WebElement headerViewPopUp;
	@FindBy(xpath = "(//div[@class='modalBtns']/following-sibling::div/span)[1]")
	private WebElement userNameInView;
	@FindBy(xpath = "//table[@class='table table-striped']//th[text()='Brand Name']")
	private WebElement brandNameInView;
	@FindBy(xpath = "//table[@class='table table-striped']//th[text()='Generic Name']")
	private WebElement genericNameInView;
	@FindBy(xpath = "//table[@class='table table-striped']//th[text()='Strength']")
	private WebElement strengthInView;
	@FindBy(xpath = "//table[@class='table table-striped']//th[text()='Duration']")
	private WebElement durationInView;
	@FindBy(xpath = "//table[@class='table table-striped']//th[text()='Route']")
	private WebElement routeInView;
	@FindBy(xpath = "//table[@class='table table-striped']//th[text()='Dosage']")
	private WebElement dosageInView;
	@FindBy(xpath = "//table[@class='table table-striped']//th[text()='Instruction']")
	private WebElement instructionInView;
	@FindBy(xpath = "//table[@class='table table-striped']//th[text()='Prescribe By']")
	private WebElement prescribeByInView;
	@FindBy(xpath = "//strong[contains(text(),'Notes')]")
	private WebElement notesInView;
	@FindBy(className = "close")
	private WebElement closeViewButton;
	@FindBy(className = "//span[@class='ng-binding ng-scope']")
	private WebElement getMailSentTxt;
	
	/*---WebElement in Send Pop up----*/
	@FindBy(xpath = "//b[text()='Patient Name']")
	private WebElement patientNameInSend;
	@FindBy(xpath = "//b[text()='Patient Mobile']")
	private WebElement patientMobileInSend;
	@FindBy(xpath = "//b[text()='Patient Email']")
	private WebElement patientEmailInSend;
	@FindBy(id = "email")
	private WebElement patientEmailTxtBxInSend;
	@FindBy(xpath = "//button[contains(@ng-click,'save')]")
	private WebElement saveVitalsButton;
	@FindBy(xpath = "//button[contains(@ng-click,'cancel')]")
	private WebElement closeVitalsButton;
	@FindBy(xpath = "//span[text()='Mail has been sent to the patient !']")
	private WebElement mailSendMsg;
	
	
	public WebElement getNoRecordFoundMsg() {
		return noRecordFoundMsg;
	}
	public WebElement getAddNewBtn() {
		return addNewBtn;
	}
	public WebElement getBrandNameMainList() {
		return brandNameMainList;
	}
	public WebElement getGenericNameMainList() {
		return genericNameMainList;
	}
	public WebElement getStrengthNameMainList() {
		return strengthNameMainList;
	}
	public WebElement getDurationNameMainList() {
		return durationNameMainList;
	}
	public WebElement getRouteNameMainList() {
		return routeNameMainList;
	}
	public WebElement getDosageNameMainList() {
		return dosageNameMainList;
	}
	public WebElement getInstructionNameMainList() {
		return instructionNameMainList;
	}
	public WebElement getPrescribeByMainList() {
		return prescribeByMainList;
	}
	public WebElement getHeadInView() {
		return headInView;
	}
	public WebElement getViewBtn() {
		return viewBtn;
	}
	public WebElement getEditBtn() {
		return editBtn;
	}
	public WebElement getDateInView() {
		return dateInView;
	}
	public WebElement getHeaderViewPopUp() {
		return headerViewPopUp;
	}
	public WebElement getUserNameInView() {
		return userNameInView;
	}
	public WebElement getBrandNameInView() {
		return brandNameInView;
	}
	public WebElement getGenericNameInView() {
		return genericNameInView;
	}
	public WebElement getStrengthInView() {
		return strengthInView;
	}
	public WebElement getDurationInView() {
		return durationInView;
	}
	public WebElement getRouteInView() {
		return routeInView;
	}
	public WebElement getDosageInView() {
		return dosageInView;
	}
	public WebElement getInstructionInView() {
		return instructionInView;
	}
	public WebElement getPrescribeByInView() {
		return prescribeByInView;
	}
	public WebElement getNotesInView() {
		return notesInView;
	}
	public WebElement getCloseViewButton() {
		return closeViewButton;
	}
	public WebElement getGetMailSentTxt() {
		return getMailSentTxt;
	}
	public WebElement getPatientNameInSend() {
		return patientNameInSend;
	}
	public WebElement getPatientMobileInSend() {
		return patientMobileInSend;
	}
	public WebElement getPatientEmailInSend() {
		return patientEmailInSend;
	}
	public WebElement getPatientEmailTxtBxInSend() {
		return patientEmailTxtBxInSend;
	}
	public WebElement getSaveVitalsButton() {
		return saveVitalsButton;
	}
	public WebElement getCloseVitalsButton() {
		return closeVitalsButton;
	}
	public WebElement getMailSendMsg() {
		return mailSendMsg;
	}
	
	
	
}
