package pages.patientDashboard;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class PrescriptionPage {

	/* Web Elements in Prescription Add Page */
	@FindBy(id = "brandName")
	public WebElement brandNameTxtBx;
	@FindBy(xpath = "//label[text()='Brand Name']")
	public WebElement brandName;
	@FindBy(id = "strength")
	public WebElement strengthTxtBx;
	@FindBy(id = "strength Unit")
	public WebElement strengthDrpDwn;
	@FindBy(xpath = "//label[text()='Strength']")
	public WebElement strength;
	
	@FindBy(name = "durationUnit")
	public WebElement durationUnitTxtBx;
	@FindBy(xpath = "//label[text()='Duration']")
	public WebElement duration;
	@FindBy(id = "genericName")
	public WebElement genericNameTxtBx;
		
//	@FindBy(xpath = "//select[@id='duration']")
	@FindBy(id = "duration unit")
	public WebElement durationDrpDwn;
	@FindBy(id = "route")
	public WebElement routeDrpDwn;
	@FindBy(xpath = "//label[text()='Route']")
	public WebElement route;
	@FindBy(xpath = "//label[text()='Morning']")
	public WebElement morningBtn;
	@FindBy(xpath = "//label[text()='Morning']")
	public WebElement morning;
	@FindBy(xpath = "//label[text()='Morning']/../span/input")
	public WebElement incUnitMorning;
	@FindBy(xpath = "//label[text()='Afternoon']")
	public WebElement afternoonBtn;
	@FindBy(xpath = "//label[text()='Afternoon']")
	public WebElement afternoon;
	@FindBy(xpath = "//label[text()='Afternoon']/../span/input")
	public WebElement incUnitAfternoon;
	@FindBy(xpath = "//label[text()='Night']")
	public WebElement nightBtn;
	@FindBy(xpath = "//label[text()='Night']")
	public WebElement night;
	@FindBy(xpath = "//label[text()='Night']/../span/input")
	public WebElement incUnitNight;
	@FindBy(xpath = "//label[text()='Instruction']")
	public WebElement instruction;
	@FindBy(xpath = "//label[text()='Before Food']")
	public WebElement befFoodBtn;
	@FindBy(xpath = "//label[text()='After Food']")
	public WebElement aftFoodBtn;
	@FindBy(xpath = "//label[text()='Notes']")
	public WebElement notes;
	@FindBy(id = "notes")
	public WebElement notesTxtBx;

	/*------WebEelement of input list in Prescription----*/
	@FindBy(xpath = "//th[text()='Brand Name']")
	private WebElement brandNameInputList;
	@FindBy(xpath = "//th[text()='Generic Name']")
	private WebElement genericNameInputList;
	@FindBy(xpath = "//th[text()='Strength']")
	private WebElement strengthInputList;
	@FindBy(xpath = "//th[text()='Duration']")
	private WebElement durationInputList;
	@FindBy(xpath = "//th[text()='Route']")
	private WebElement routeInputList;
	@FindBy(xpath = "//th[text()='Dosage']")
	private WebElement dosageInputList;
	@FindBy(xpath = "//th[text()='Instruction']")
	private WebElement instructionInputList;
	@FindBy(xpath = "//th[text()='Notes']")
	private WebElement notesInputList;
	@FindBy(xpath = "//th[text()='Action']")
	private WebElement actionInputList;

	/*-------------All buttons in Prescription Add Page-----------*/
	@FindBy(xpath = "//button[contains(@class,'btn-circular ui-link ng-scope')]//i[text()='save']")
	private WebElement saveBtn;
	@FindBy(xpath = "//i[text()='Reset']")
	private WebElement resetBtn;
	@FindBy(xpath = "//i[text()='Cancel']")
	private WebElement cancelBtn;
	@FindBy(xpath = "//span[@class='actn-icn delete']")
	private WebElement deleteBtn;
	@FindBy(xpath = "//span[@class='cmnicons yes-mdl']")
	private WebElement yesOnDelete;

	/*---------------------Validation Message-------*/
	@FindBy(xpath = "//label[text()='Brand Name']/following-sibling::div//div[contains(text(),'Enter Brand Name')]")
	private WebElement errorBrandMsg;
	@FindBy(xpath = "//label[text()='Duration']/following-sibling::div//div[contains(text(),'Enter Duration')]")
	private WebElement errorDurationMsg;
	@FindBy(xpath = "//input[@id='genericName']/..//div[contains(text(),'Enter Generic Name')]")
	private WebElement errorGenericMsg;
	@FindBy(xpath = "//div[contains(text(),'Select Duration Unit')]")
	private WebElement errorDurationDrpDwnMsg;
	@FindBy(xpath = "//div[contains(text(),'Select Dosage')]")
	private WebElement errorFreqMsg;
	@FindBy(xpath = "//div[contains(text(),'Select Instruction')]")
	private WebElement errorInstructionMsg;
	@FindBy(xpath = "//div[contains(text(),'Enter Duration in Digits only')]")
	private WebElement errorDurationDigitMsg;
	@FindBy(xpath = "//div[contains(text(),'Enter Drug Strength in Digits only')]")
	private WebElement errorDrugDigitMsg;
	
	
	public WebElement getBrandNameTxtBx() {
		return brandNameTxtBx;
	}
	public WebElement getBrandName() {
		return brandName;
	}
	public WebElement getStrengthTxtBx() {
		return strengthTxtBx;
	}
	public WebElement getStrengthDrpDwn() {
		return strengthDrpDwn;
	}
	public WebElement getStrength() {
		return strength;
	}
	public WebElement getDurationUnitTxtBx() {
		return durationUnitTxtBx;
	}
	public WebElement getDuration() {
		return duration;
	}
	public WebElement getGenericNameTxtBx() {
		return genericNameTxtBx;
	}
	public WebElement getDurationDrpDwn() {
		return durationDrpDwn;
	}
	public WebElement getRouteDrpDwn() {
		return routeDrpDwn;
	}
	public WebElement getRoute() {
		return route;
	}
	public WebElement getMorningBtn() {
		return morningBtn;
	}
	public WebElement getMorning() {
		return morning;
	}
	public WebElement getIncUnitMorning() {
		return incUnitMorning;
	}
	public WebElement getAfternoonBtn() {
		return afternoonBtn;
	}
	public WebElement getAfternoon() {
		return afternoon;
	}
	public WebElement getIncUnitAfternoon() {
		return incUnitAfternoon;
	}
	public WebElement getNightBtn() {
		return nightBtn;
	}
	public WebElement getNight() {
		return night;
	}
	public WebElement getIncUnitNight() {
		return incUnitNight;
	}
	public WebElement getInstruction() {
		return instruction;
	}
	public WebElement getBefFoodBtn() {
		return befFoodBtn;
	}
	public WebElement getAftFoodBtn() {
		return aftFoodBtn;
	}
	public WebElement getNotes() {
		return notes;
	}
	public WebElement getNotesTxtBx() {
		return notesTxtBx;
	}
	public WebElement getBrandNameInputList() {
		return brandNameInputList;
	}
	public WebElement getGenericNameInputList() {
		return genericNameInputList;
	}
	public WebElement getStrengthInputList() {
		return strengthInputList;
	}
	public WebElement getDurationInputList() {
		return durationInputList;
	}
	public WebElement getRouteInputList() {
		return routeInputList;
	}
	public WebElement getDosageInputList() {
		return dosageInputList;
	}
	public WebElement getInstructionInputList() {
		return instructionInputList;
	}
	public WebElement getNotesInputList() {
		return notesInputList;
	}
	public WebElement getActionInputList() {
		return actionInputList;
	}
	public WebElement getSaveBtn() {
		return saveBtn;
	}
	public WebElement getResetBtn() {
		return resetBtn;
	}
	public WebElement getCancelBtn() {
		return cancelBtn;
	}
	public WebElement getDeleteBtn() {
		return deleteBtn;
	}
	public WebElement getYesOnDelete() {
		return yesOnDelete;
	}
	public WebElement getErrorBrandMsg() {
		return errorBrandMsg;
	}
	public WebElement getErrorDurationMsg() {
		return errorDurationMsg;
	}
	public WebElement getErrorGenericMsg() {
		return errorGenericMsg;
	}
	public WebElement getErrorDurationDrpDwnMsg() {
		return errorDurationDrpDwnMsg;
	}
	public WebElement getErrorFreqMsg() {
		return errorFreqMsg;
	}
	public WebElement getErrorInstructionMsg() {
		return errorInstructionMsg;
	}
	public WebElement getErrorDurationDigitMsg() {
		return errorDurationDigitMsg;
	}
	public WebElement getErrorDrugDigitMsg() {
		return errorDrugDigitMsg;
	}

	
	
}
