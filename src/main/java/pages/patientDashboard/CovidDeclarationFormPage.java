package pages.patientDashboard;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CovidDeclarationFormPage {
    

    //web element of covid-19 form
    @FindBy(id = "infEvaluationFormLabel")
    private WebElement headerCovidForm;
    @FindBy(id = "selectedPatientName")
    private WebElement patientName;
    @FindBy(id = "selectedPatientMobile")
    private WebElement patientId;
    @FindBy(id = "infDiseaseFormSave")
    private WebElement saveCovidFormBtn;
    @FindBy(xpath = "//button[@id='infDiseaseFormSave']/following-sibling::button/span[@class='cmnicons cncl-mdl']")
    private WebElement cancelCovidFormBtn;
    @FindBy(id = "infDiseaseFormReset")
    private WebElement resetCovidFormBtn;
    @FindBy(id = "infDiseaseFormPrint")
    private WebElement printCovidFormBtn;
    @FindBy(xpath = "//span[text()='Have you suffered from any of these in the past 2 weeks?']/preceding-sibling::span[@class='hdrCount']/span[@class='red astrick']")
    private WebElement covidQue_1;
    @FindBy(xpath = "//h4[contains(@data-question,'Have you suffered from any of these in the past 2 weeks?')]/following-sibling::div/div/label[text()='High Fever']")
    private WebElement highFever;
    @FindBy(xpath = "//h4[contains(@data-question,'Have you suffered from any of these in the past 2 weeks?')]/following-sibling::div/div/label[text()='Difficulty in Breathing']")
    private WebElement difficultyBreathing;
    @FindBy(xpath = "//h4[contains(@data-question,'Have you suffered from any of these in the past 2 weeks?')]/following-sibling::div/div/label[text()='Cough / Sore Throat']")
    private WebElement coughSoreThroat;
    @FindBy(xpath = "//h4[contains(@data-question,'Have you suffered from any of these in the past 2 weeks?')]/following-sibling::div/div/label[text()='Sneezing / Running Nose']")
    private WebElement sneezingRunningNose;
    @FindBy(xpath = "//h4[contains(@data-question,'Have you suffered from any of these in the past 2 weeks?')]/following-sibling::div/div/label[text()='None of Them']")
    private WebElement noneOfThem;
    @FindBy(xpath = "//span[text()='Have you been asked to go in quarantine during past 2 months?']/preceding-sibling::span[@class='hdrCount']/span[@class='red astrick']")
    private WebElement covidQue_2;
    @FindBy(xpath = "//h4[contains(@data-question,'Have you been asked to go in quarantine during past 2 months?')]/following-sibling::div//label[text()='Yes']")
    private WebElement yesBtnCovidQue_2;
    @FindBy(xpath = "//h4[contains(@data-question,'Have you been asked to go in quarantine during past 2 months?')]/following-sibling::div//label[text()='No']")
    private WebElement noBtnCovidQue_2;
    @FindBy(xpath = "//span[text()='Any of your family members found COVID positive in last few months?']/preceding-sibling::span[@class='hdrCount']/span[@class='red astrick']")
    private WebElement covidQue_3;
    @FindBy(xpath = "//h4[contains(@data-question,'Any of your family members found COVID positive in last few months?')]/following-sibling::div//label[text()='Yes']")
    private WebElement yesBtnCovidQue_3;
    @FindBy(xpath = "//h4[contains(@data-question,'Any of your family members found COVID positive in last few months?')]/following-sibling::div//label[text()='No']")
    private WebElement noBtnCovidQue_3;
    @FindBy(xpath = "//span[text()='Have you travelled to any other state within India in the past 2 months?']/preceding-sibling::span[@class='hdrCount']/span[@class='red astrick']")
    private WebElement covidQue_4;
    @FindBy(xpath = "//h4[contains(@data-question,'Have you travelled to any other state within India in the past 2 months?')]/following-sibling::div//label[text()='Yes']")
    private WebElement yesBtnCovidQue_4;
    @FindBy(xpath = "//h4[contains(@data-question,'Have you travelled to any other state within India in the past 2 months?')]/following-sibling::div//label[text()='No']")
    private WebElement noBtnCovidQue_4;
    @FindBy(xpath = "//span[text()='Have you lived or travelled to any foreign country in the past 2 months?']/preceding-sibling::span[@class='hdrCount']/span[@class='red astrick']")
    private WebElement covidQue_5;
    @FindBy(xpath = "//h4[contains(@data-question,'Have you lived or travelled to any foreign country in the past 2 months?')]/following-sibling::div//label[text()='Yes']")
    private WebElement yesBtnCovidQue_5;
    @FindBy(xpath = "//h4[contains(@data-question,'Have you lived or travelled to any foreign country in the past 2 months?')]/following-sibling::div//label[text()='No']")
    private WebElement noBtnCovidQue_5;
    @FindBy(xpath = "//span[text()='Have you met someone who recently returned from Corona active country?']/preceding-sibling::span[@class='hdrCount']/span[@class='red astrick']")
    private WebElement covidQue_6;
    @FindBy(xpath = "//h4[contains(@data-question,'Have you met someone who recently returned from Corona active country?')]/following-sibling::div//label[text()='Yes']")
    private WebElement yesBtnCovidQue_6;
    @FindBy(xpath = "//h4[contains(@data-question,'Have you met someone who recently returned from Corona active country?')]/following-sibling::div//label[text()='No']")
    private WebElement noBtnCovidQue_6;
    @FindBy(xpath = "//span[text()='Have you been in contact with a suspected/confirmed case of COVID-19?']/preceding-sibling::span[@class='hdrCount']/span[@class='red astrick']")
    private WebElement covidQue_7;
    @FindBy(xpath = "//h4[contains(@data-question,'Have you been in contact with a suspected/confirmed case of COVID-19?')]/following-sibling::div//label[text()='Yes']")
    private WebElement yesBtnCovidQue_7;
    @FindBy(xpath = "//h4[contains(@data-question,'Have you been in contact with a suspected/confirmed case of COVID-19?')]/following-sibling::div//label[text()='No']")
    private WebElement noBtnCovidQue_7;
    @FindBy(xpath = "//span[text()='Have you been in a gathering or a meeting with unacquainted people or where people have returned from foreign country?']/preceding-sibling::span[@class='hdrCount']/span[@class='red astrick']")
    private WebElement covidQue_8;
    @FindBy(xpath = "//h4[contains(@data-question,'Have you been in a gathering or a meeting with unacquainted people or where people have returned from foreign country?')]/following-sibling::div//label[text()='Yes']")
    private WebElement yesBtnCovidQue_8;
    @FindBy(xpath = "//h4[contains(@data-question,'Have you been in a gathering or a meeting with unacquainted people or where people have returned from foreign country?')]/following-sibling::div//label[text()='No']")
    private WebElement noBtnCovidQue_8;
    @FindBy(xpath = "//span[text()='History of any medicine intake during last 2 weeks?']/preceding-sibling::span[@class='hdrCount']/span[@class='red astrick']")
    private WebElement covidQue_9;
    @FindBy(xpath = "//h4[contains(@data-question,'History of any medicine intake during last 2 weeks?')]/following-sibling::div//label[text()='Yes']")
    private WebElement yesBtnCovidQue_9;
    @FindBy(xpath = "//h4[contains(@data-question,'History of any medicine intake during last 2 weeks?')]/following-sibling::div//label[text()='No']")
    private WebElement noBtnCovidQue_9;
    @FindBy(xpath = "//span[text()='What is Your Temperature (In Fahrenheit)?']/preceding-sibling::span[@class='hdrCount']")
    private WebElement covidQue_10;
    @FindBy(xpath = "//h4[contains(@data-question,'What is Your Temperature (In Fahrenheit)?')]/following-sibling::div/input[contains(@placeholder,'enter details')]")
    private WebElement textFieldsCovidQue_10;
    @FindBy(xpath = "//span[text()='What is your Oximeter level?']/preceding-sibling::span[@class='hdrCount']")
    private WebElement covidQue_11;
    @FindBy(xpath = "//h4[contains(@data-question,'What is your Oximeter level?')]/following-sibling::div/input[contains(@placeholder,'enter details')]")
    private WebElement textFieldsCovidQue_11;
    @FindBy(xpath = "//span[text()='Do you want to overide the patient status manually?']/preceding-sibling::span[@class='hdrCount']")
    private WebElement covidQue_12;
    @FindBy(xpath = "//span[contains(text(),'Do you want to overide the patient status manually?')]/../following-sibling::div//label[@data-desc='Low Probability']")
    private WebElement greenBtnCovidQue_12;
    @FindBy(xpath = "//span[contains(text(),'Do you want to overide the patient status manually?')]/../following-sibling::div//label[@data-desc='Medium Probability']")
    private WebElement yellowBtnCovidQue_12;
    @FindBy(xpath = "//span[contains(text(),'Do you want to overide the patient status manually?')]/../following-sibling::div//label[@data-desc='High Probability']")
    private WebElement redBtnCovidQue_12;
    @FindBy(id = "status_remarks")
    private WebElement remarksTextFields;
    @FindBy(xpath = "//textarea[@id='status_remarks']/following-sibling::span[text()='Max. 768 character(s)']")
    private WebElement maxCarMsg;
    @FindBy(xpath = "//p[contains(text(),'This field is required')]")
    private WebElement errorMsg;
    @FindBy(xpath = "//span[contains(text(),'Do you want to overide the patient status manually?')]/../following-sibling::div//input[@data-desc='Green']")
    private WebElement lowProbability;
    @FindBy(xpath = "//span[contains(text(),'Do you want to overide the patient status manually?')]/../following-sibling::div//input[@data-desc='Yellow']")
    private WebElement mediumProbability;
    @FindBy(xpath = "//span[contains(text(),'Do you want to overide the patient status manually?')]/../following-sibling::div//input[@data-desc='Red']")
    private WebElement highProbability;
    
    
	public WebElement getHeaderCovidForm() {
		return headerCovidForm;
	}
	public WebElement getPatientName() {
		return patientName;
	}
	public WebElement getPatientId() {
		return patientId;
	}
	public WebElement getSaveCovidFormBtn() {
		return saveCovidFormBtn;
	}
	public WebElement getCancelCovidFormBtn() {
		return cancelCovidFormBtn;
	}
	public WebElement getResetCovidFormBtn() {
		return resetCovidFormBtn;
	}
	public WebElement getPrintCovidFormBtn() {
		return printCovidFormBtn;
	}
	public WebElement getCovidQue_1() {
		return covidQue_1;
	}
	public WebElement getHighFever() {
		return highFever;
	}
	public WebElement getDifficultyBreathing() {
		return difficultyBreathing;
	}
	public WebElement getCoughSoreThroat() {
		return coughSoreThroat;
	}
	public WebElement getSneezingRunningNose() {
		return sneezingRunningNose;
	}
	public WebElement getNoneOfThem() {
		return noneOfThem;
	}
	public WebElement getCovidQue_2() {
		return covidQue_2;
	}
	public WebElement getYesBtnCovidQue_2() {
		return yesBtnCovidQue_2;
	}
	public WebElement getNoBtnCovidQue_2() {
		return noBtnCovidQue_2;
	}
	public WebElement getCovidQue_3() {
		return covidQue_3;
	}
	public WebElement getYesBtnCovidQue_3() {
		return yesBtnCovidQue_3;
	}
	public WebElement getNoBtnCovidQue_3() {
		return noBtnCovidQue_3;
	}
	public WebElement getCovidQue_4() {
		return covidQue_4;
	}
	public WebElement getYesBtnCovidQue_4() {
		return yesBtnCovidQue_4;
	}
	public WebElement getNoBtnCovidQue_4() {
		return noBtnCovidQue_4;
	}
	public WebElement getCovidQue_5() {
		return covidQue_5;
	}
	public WebElement getYesBtnCovidQue_5() {
		return yesBtnCovidQue_5;
	}
	public WebElement getNoBtnCovidQue_5() {
		return noBtnCovidQue_5;
	}
	public WebElement getCovidQue_6() {
		return covidQue_6;
	}
	public WebElement getYesBtnCovidQue_6() {
		return yesBtnCovidQue_6;
	}
	public WebElement getNoBtnCovidQue_6() {
		return noBtnCovidQue_6;
	}
	public WebElement getCovidQue_7() {
		return covidQue_7;
	}
	public WebElement getYesBtnCovidQue_7() {
		return yesBtnCovidQue_7;
	}
	public WebElement getNoBtnCovidQue_7() {
		return noBtnCovidQue_7;
	}
	public WebElement getCovidQue_8() {
		return covidQue_8;
	}
	public WebElement getYesBtnCovidQue_8() {
		return yesBtnCovidQue_8;
	}
	public WebElement getNoBtnCovidQue_8() {
		return noBtnCovidQue_8;
	}
	public WebElement getCovidQue_9() {
		return covidQue_9;
	}
	public WebElement getYesBtnCovidQue_9() {
		return yesBtnCovidQue_9;
	}
	public WebElement getNoBtnCovidQue_9() {
		return noBtnCovidQue_9;
	}
	public WebElement getCovidQue_10() {
		return covidQue_10;
	}
	public WebElement getTextFieldsCovidQue_10() {
		return textFieldsCovidQue_10;
	}
	public WebElement getCovidQue_11() {
		return covidQue_11;
	}
	public WebElement getTextFieldsCovidQue_11() {
		return textFieldsCovidQue_11;
	}
	public WebElement getCovidQue_12() {
		return covidQue_12;
	}
	public WebElement getGreenBtnCovidQue_12() {
		return greenBtnCovidQue_12;
	}
	public WebElement getYellowBtnCovidQue_12() {
		return yellowBtnCovidQue_12;
	}
	public WebElement getRedBtnCovidQue_12() {
		return redBtnCovidQue_12;
	}
	public WebElement getRemarksTextFields() {
		return remarksTextFields;
	}
	public WebElement getMaxCarMsg() {
		return maxCarMsg;
	}
	public WebElement getErrorMsg() {
		return errorMsg;
	}
	public WebElement getLowProbability() {
		return lowProbability;
	}
	public WebElement getMediumProbability() {
		return mediumProbability;
	}
	public WebElement getHighProbability() {
		return highProbability;
	}

    
    
}
