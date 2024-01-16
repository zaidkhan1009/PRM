package pages.doctorDashboard;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewSubscriberPage {
    

    @FindBy(xpath = "//h1[text()='New Subscriber']")
    private WebElement newSubscriberHeader;
    @FindBy(xpath = "//span[contains(text(),'Creation Date')]")
    private WebElement creationDate;
    @FindBy(xpath = "//div[contains(@class,'sideNavigatio')]//span[@class='cmnicons aprsv']")
    private WebElement saveBtn;
    @FindBy(xpath = "//div[contains(@class,'sideNavigatio')]//span[@class='cmnicons rst']")
    private WebElement resetBtn;
    @FindBy(xpath = "//div[contains(@class,'sideNavigatio')]//span[@class='cmnicons cncl']")
    private WebElement cancelBtn;
    @FindBy(xpath = "//label[contains(text(),'Name')]/following-sibling::div/input[@id='name']")
    private WebElement name;
    @FindBy(xpath ="//label[@for='male']/following-sibling::div[@class='stl-chkB-rdB']") // changed the xpath from  "//label[contains(text(),'Gender')]/following-sibling::div//input[@id='male']")
    private WebElement male;
    @FindBy(xpath ="//label[@for='female']/following-sibling::div[@class='stl-chkB-rdB']") // changed the xpath from "//label[contains(text(),'Gender')]/following-sibling::div//input[@id='female']")
    private WebElement female;
    @FindBy(xpath ="//label[@for='other']/following-sibling::div[@class='stl-chkB-rdB']") // changed the xpath from "//label[contains(text(),'Gender')]/following-sibling::div//input[@id='other']")
    private WebElement other;
    @FindBy(xpath = "//label[contains(text(),'Date of Birth')]/following-sibling::input[@id='dob']")
    private WebElement dob;
    @FindBy(xpath = "//label[contains(text(),'Email ID')]/following-sibling::div//input[@id='email']")
    private  WebElement email;
    @FindBy(xpath = "//label[contains(text(),'Mobile')]/following-sibling::div//input[@id='mobile']")
    private WebElement mobile;
    @FindBy(xpath = "//label[contains(text(),'Alternate Contact No')]/following-sibling::input[@id='alternatePhone']")
    private WebElement alternatePhone;
    @FindBy(xpath = "//label[contains(text(),'Type')]/following-sibling::custom-combo//select[@id='type']")
    private WebElement type;
    @FindBy(xpath = "//label[contains(text(),'Stage')]/following-sibling::custom-combo//select[@id='stage']")
    private WebElement stage;
    @FindBy(xpath = "//label[contains(text(),'Campaign')]/following-sibling::custom-combo//select[@id='campaign']")
    private WebElement campaign;
    @FindBy(xpath = "//label[contains(text(),'Source')]/following-sibling::custom-combo//select[@id='source']")
    private WebElement source;
    @FindBy(xpath = "//label[contains(text(),'Sub-Source')]/following-sibling::input[@id='subSource']")
    private WebElement subSource;
    @FindBy(xpath = "//label[contains(text(),'Findings')]/following-sibling::div/div[@class='multiselect-parent btn-group dropdown-multiselect']")
    private WebElement findings;
    @FindBy(xpath = "//label[contains(text(),'Other Findings')]/following-sibling::input[@id='otherFindingsTxt']")
    private WebElement otherFindingsTxt;
    @FindBy(xpath = "//label[contains(text(),'Region')]/following-sibling::custom-combo//select[@id='region']")
    private WebElement region;
    @FindBy(xpath = "//label[contains(text(),'Zone')]/following-sibling::custom-combo//select[@id='zone']")
    private WebElement zone;
    @FindBy(xpath = "//span[@class='cmnicons ccAdd']")
    private WebElement addFilesBtn;
	public WebElement getNewSubscriberHeader() {
		return newSubscriberHeader;
	}
	public WebElement getCreationDate() {
		return creationDate;
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
	public WebElement getName() {
		return name;
	}
	public WebElement getMale() {
		return male;
	}
	public WebElement getFemale() {
		return female;
	}
	public WebElement getOther() {
		return other;
	}
	public WebElement getDob() {
		return dob;
	}
	public WebElement getEmail() {
		return email;
	}
	public WebElement getMobile() {
		return mobile;
	}
	public WebElement getAlternatePhone() {
		return alternatePhone;
	}
	public WebElement getType() {
		return type;
	}
	public WebElement getStage() {
		return stage;
	}
	public WebElement getCampaign() {
		return campaign;
	}
	public WebElement getSource() {
		return source;
	}
	public WebElement getSubSource() {
		return subSource;
	}
	public WebElement getFindings() {
		return findings;
	}
	public WebElement getOtherFindingsTxt() {
		return otherFindingsTxt;
	}
	public WebElement getRegion() {
		return region;
	}
	public WebElement getZone() {
		return zone;
	}
	public WebElement getAddFilesBtn() {
		return addFilesBtn;
	}

    
    

}
