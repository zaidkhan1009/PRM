package pages.doctorDashboard;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class MiscellaneousCallPage {
	

	// WebElement on New Miscellaneous Call Screen
	@FindBy(id = "type")
	private WebElement typeDrpDwn;
	@FindBy(xpath = "//label[text()='Type']")
	private WebElement type;
	@FindBy(id = "callDuration")
	private WebElement durationTxtBx;
	@FindBy(xpath = "//label[text()='Duration']")
	private WebElement duration;
	@FindBy(id = "disposition")
	private WebElement dispositionDrpDwn;
	@FindBy(xpath = "//label[text()='Disposition']")
	private WebElement disposition;
	@FindBy(id = "info")
	private WebElement infoDrpDwn;
	@FindBy(xpath = "//label[text()='Info']")
	private WebElement info;
	@FindBy(id = "name")
	private WebElement nameTxtBx;
	@FindBy(xpath = "//label[text()='Name']")
	private WebElement name;
	@FindBy(id = "mobile")
	private WebElement mobileTxtBx;
	@FindBy(xpath = "//label[text()='Name']")
	private WebElement mobile;
	@FindBy(id = "notes")
	private WebElement notesTxtBx;
	@FindBy(xpath = "//label[text()='Notes:']")
	private WebElement notes;

	/*-------All Right Navigations buttons-----*/
	@FindBy(xpath = "//div[contains(@class,'sideNavigation')]//i[text()='Save']")
	private WebElement saveBtn;
	@FindBy(xpath = "//div[contains(@class,'sideNavigation')]//i[text()='Reset']")
	private WebElement resetBtn;
	@FindBy(xpath = "//div[contains(@class,'sideNavigation')]//i[text()='Cancel']")
	private WebElement cancelBtn;

	/*-------All Header Navigations buttons-------*/
	@FindBy(xpath = "//div[contains(@class,'jumbotron')]//i[text()='Work Area']")
	private WebElement workAreaBtn;
	@FindBy(xpath = "//div[contains(@class,'jumbotron')]//i[text()='Misc. Calls']")
	private WebElement miscCallsListBtn;
	@FindBy(xpath = "//div[contains(@class,'jumbotron')]//i[text()='Subscribers']")
	private WebElement subscribersBtn;

	/*----Subscriber listing---*/
	@FindBy(xpath="//i[text()='Misc. Call+']")
	private WebElement miscCallsAddBtn;

	/*-----My Work Area----*/
	@FindBy(xpath="//b[text()='Dashboard']")
	private WebElement dashBoardBtn;

	/*-----Validation Error messages---*/
	@FindBy(xpath = "//label[text()='Disposition']/following-sibling::div/div[@class='error ng-scope']")
	private WebElement errorDispositionMsg;
	@FindBy(xpath = "//label[text()='Info']/following-sibling::div/div[@class='error ng-scope']")
	private WebElement errorInfoMsg;
	@FindBy(xpath = "//label[text()='Name']/following-sibling::div/div[@class='error ng-scope']")
	private WebElement errorNameMsg;
	@FindBy(xpath = "//label[text()='Mobile']/following-sibling::div/div[@class='error ng-scope']")
	private WebElement errorMobileMsg;
	public WebElement getTypeDrpDwn() {
		return typeDrpDwn;
	}
	public WebElement getType() {
		return type;
	}
	public WebElement getDurationTxtBx() {
		return durationTxtBx;
	}
	public WebElement getDuration() {
		return duration;
	}
	public WebElement getDispositionDrpDwn() {
		return dispositionDrpDwn;
	}
	public WebElement getDisposition() {
		return disposition;
	}
	public WebElement getInfoDrpDwn() {
		return infoDrpDwn;
	}
	public WebElement getInfo() {
		return info;
	}
	public WebElement getNameTxtBx() {
		return nameTxtBx;
	}
	public WebElement getName() {
		return name;
	}
	public WebElement getMobileTxtBx() {
		return mobileTxtBx;
	}
	public WebElement getMobile() {
		return mobile;
	}
	public WebElement getNotesTxtBx() {
		return notesTxtBx;
	}
	public WebElement getNotes() {
		return notes;
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
	public WebElement getWorkAreaBtn() {
		return workAreaBtn;
	}
	public WebElement getMiscCallsListBtn() {
		return miscCallsListBtn;
	}
	public WebElement getSubscribersBtn() {
		return subscribersBtn;
	}
	public WebElement getMiscCallsAddBtn() {
		return miscCallsAddBtn;
	}
	public WebElement getDashBoardBtn() {
		return dashBoardBtn;
	}
	public WebElement getErrorDispositionMsg() {
		return errorDispositionMsg;
	}
	public WebElement getErrorInfoMsg() {
		return errorInfoMsg;
	}
	public WebElement getErrorNameMsg() {
		return errorNameMsg;
	}
	public WebElement getErrorMobileMsg() {
		return errorMobileMsg;
	}

	
	
}
