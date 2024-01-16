package pages.doctorDashboard;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SubscriberListingPage {
    
    public WebElement getHeaderSubscriberListing() {
		return headerSubscriberListing;
	}
	public WebElement getNewSubscriberAddBtn() {
		return newSubscriberAddBtn;
	}
	public WebElement getAppointmentAddBtn() {
		return appointmentAddBtn;
	}
	public WebElement getComplaintAddBtn() {
		return complaintAddBtn;
	}
	public WebElement getComplaintsListingBtn() {
		return complaintsListingBtn;
	}
	public WebElement getDropCallBtn() {
		return dropCallBtn;
	}
	public WebElement getAssignBtn() {
		return assignBtn;
	}
	public WebElement getImportBtn() {
		return importBtn;
	}
	public WebElement getCsvFmtBtn() {
		return csvFmtBtn;
	}
	public WebElement getMiscCallsListBtn() {
		return miscCallsListBtn;
	}
	public WebElement getMiscCallsAddBtn() {
		return miscCallsAddBtn;
	}
	public WebElement getDashBoardBtn() {
		return dashBoardBtn;
	}
	public WebElement getRegion() {
		return region;
	}
	public WebElement getAssignee() {
		return assignee;
	}
	public WebElement getStage() {
		return stage;
	}
	public WebElement getDetails() {
		return details;
	}
	public WebElement getFromDate() {
		return fromDate;
	}
	public WebElement getToDate() {
		return toDate;
	}
	public WebElement getStageRbtn() {
		return stageRbtn;
	}
	public WebElement getCreatedRbtn() {
		return createdRbtn;
	}
	public WebElement getUpdatedRbtn() {
		return updatedRbtn;
	}
	public WebElement getSearchBtn() {
		return searchBtn;
	}
	public WebElement getAdvanceBtn() {
		return advanceBtn;
	}
	public WebElement getResetBtn() {
		return resetBtn;
	}
	public WebElement getType() {
		return type;
	}
	public WebElement getSource() {
		return source;
	}
	public WebElement getSubsource() {
		return subsource;
	}
	public WebElement getAge() {
		return age;
	}
	public WebElement getLeadType() {
		return leadType;
	}
	public WebElement getCampaign() {
		return campaign;
	}
	public WebElement getFinding() {
		return finding;
	}
	public WebElement getNoRecordFound() {
		return noRecordFound;
	}
	//storing web element of subscriber listing
    @FindBy(xpath = "//h1[text()='Subscriber Listing']")
    private WebElement headerSubscriberListing;
    @FindBy(xpath = "//span[@class='cmnicons ccAdd']/../following-sibling::i[text()='Add New']")
    private WebElement newSubscriberAddBtn;
    @FindBy(xpath = "//span[@class='cmnicons apptAdd']/../following-sibling::i[text()='Appt.+']")
    private WebElement appointmentAddBtn;
    @FindBy(xpath = "//span[@class='cmnicons dashBoardCMAdd']/../following-sibling::i[text()='Complaint+']")
    private WebElement complaintAddBtn;
    @FindBy(xpath = "//span[@class='cmnicons cpmlnt']/../following-sibling::i[text()='Complaints']")
    private WebElement complaintsListingBtn;
    @FindBy(xpath = "//span[@class='cmnicons drpCall']/../following-sibling::i[text()='Drop Call(']")
    private WebElement dropCallBtn;
    @FindBy(xpath = "//span[@class='cmnicons glyphicon fa fa-exchange icon']/../following-sibling::i[text()='Assign']")
    private WebElement assignBtn;
    @FindBy(xpath = "//span[@class='cmnicons glyphicon fa fa-sign-in icon']/../following-sibling::i[text()='Import']")
    private WebElement importBtn;
    @FindBy(xpath = "//span[@class='cmnicons csv']/../following-sibling::i[text()='CSV fmt.']")
    private WebElement csvFmtBtn;
    @FindBy(xpath = "//span[@class='cmnicons miscList']/../following-sibling::i[text()='Misc. Calls']")
    private WebElement miscCallsListBtn;
    @FindBy(xpath = "//span[@class='cmnicons miscAdd']/../following-sibling::i[text()='Misc. Call+']")
    private WebElement miscCallsAddBtn;
    @FindBy(xpath = "//span[@class='cmnicons dashB']/../following-sibling::i[text()='DashBoard']")
    private WebElement dashBoardBtn;
    @FindBy(id= "region")
    private WebElement region;
    @FindBy(id= "assignee")
    private WebElement assignee;
    @FindBy(id= "stage")
    private WebElement stage;
    @FindBy(id = "details")
    private WebElement details;
    @FindBy(id="fromDate")
    private WebElement fromDate;
    @FindBy(id="toDate")
    private WebElement toDate;
    @FindBy(xpath="//label[@for='stageRbtn']")  // [Sumit Kumar - 3-Jan-24]: changed the locator from : //label[@for='stageRbtn']   "//input[@id='stageRbtn']"
    private WebElement stageRbtn;
    @FindBy(xpath="//label[@for='createdRbtn']")  // changed the locator from: (id="createdRbtn")
    private WebElement createdRbtn;
    @FindBy(xpath="//label[@for='updatedRbtn']") // changed the locator from: (id="updatedRbtn")
    private WebElement updatedRbtn;
    @FindBy(xpath = "//span[@class='cmnicons srch']/../following-sibling::i[text()='Search']")
    private WebElement searchBtn;
    @FindBy(xpath = "//span[@class='cmnicons advSerch']")
    private WebElement advanceBtn;
    @FindBy(xpath = "//span[@class='cmnicons rst']/../following-sibling::i[text()='Reset']")
    private WebElement resetBtn;
    @FindBy(id = "type")
    private WebElement type;
    @FindBy(xpath="//button[@class='dropdown-toggle ng-binding btn btn-default']")	//changed the xpath from "id = "source")
    private WebElement source;
    @FindBy(id = "subsource")
    private WebElement subsource;
    @FindBy(id = "age")
    private WebElement age;
    @FindBy(id = "lead type")
    private WebElement leadType;
    @FindBy(id = "campaign")
    private WebElement campaign;
    @FindBy(id = "finding")
    private WebElement finding;
    @FindBy(xpath = "//i[text()='No Record Found']")
    private WebElement noRecordFound;

    
}
