package pages.doctorDashboard;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


/*
 *  @author NIKHIL TYAGI*
 */

public class     MiscellaneousCallListingPage {
	
	// ------WebElement of Main List---------
	@FindBy(xpath = "//span[text()='Date/Time']")
	private WebElement dateOnMiscList;
	@FindBy(xpath = "//span[text()='Name']")
	private WebElement nameMainList;
	@FindBy(xpath = "//span[text()='Mobile']")
	private WebElement mobileMainList;
	@FindBy(xpath = "//span[text()='Type']")
	private WebElement typeMainList;
	@FindBy(xpath = "//span[text()='Disposition']")
	private WebElement dispositionMainList;
	@FindBy(xpath = "//span[text()='Info']")
	private WebElement infoMainList;
	@FindBy(xpath = "//span[text()='Caller']")
	private WebElement callerMainList;
	@FindBy(xpath = "//span[text()='Notes']")
	private WebElement notesMainList;
	@FindBy(xpath = "//span[contains(text(),'Call details added successfully!')]")
	private WebElement successfullMsg;

	// ------WebElement of Filter in Miscellaneous Call List---------
	@FindBy(id="type")
	private WebElement typeDrpDwn;
	@FindBy(id="disposition")
	private WebElement dispDrpDwn;
	@FindBy(id="caller Name")
	private WebElement callerNameDrpDwn;
	@FindBy(id="details")
	private WebElement detailsTxtBx;
	@FindBy(id="fromDate")
	private WebElement fromDateBtn;
	@FindBy(id="toDate")
	private WebElement toDateBtn;

	/*----Subscriber listing---*/
	@FindBy(xpath="//i[text()='Misc. Calls']")
	private WebElement miscCallsListBtn;

	/* ------WebElement of header in Miscellaneous Call List---------*/
	@FindBy(xpath = "//i[text()='Add New']")
	private WebElement addNewBtnOnMiscList;
	@FindBy(xpath="//i[text()='Subscribers']")
	private WebElement subscribersBtn;
	@FindBy(xpath="//i[text()='DashBoard']")
	private WebElement dashBoardBtn;
	@FindBy(xpath="//i[text()='Search']")
	private WebElement searchBtn;
	@FindBy(xpath="//i[text()='Reset']")
	private WebElement resetBtn;
	/* Button is for Admin
	@FindBy(xpath="//i[text()='Export']")
	private WebElement exportBtn;*/
	
	/*
	 * 
	 */
	@FindBy(xpath = "//table[@class='table']/tbody/tr")
	private List<WebElement> callRecordOnListing; 
	@FindBy(xpath="//div[@class='clearfix topPagination pagingUI']//a[@class='next']")
	private WebElement nextPageButton;
	@FindBy(xpath="//div[@class='clearfix topPagination pagingUI']//a[@class='previous']")
	private WebElement previousPageButton;
	@FindBy(xpath="//div[@class='clearfix topPagination pagingUI']//a[contains(@class,'pageNo')]")
	private List<WebElement> listOfPages;
	@FindBy(xpath = "//i[@class='ng-binding' and text()='No Record Found!']")
	private WebElement noRecordFoundMsg;
	@FindBy(xpath="//span[contains(text(),'The date range selected is more than 90 no. of day')]")
	private WebElement dateRangeMoreErrorMsg;
	@FindBy(xpath="//span[normalize-space()='From Date cannot exceed To Date.']")
	private WebElement fromDateExceedToDateMsg;
	
	
	public WebElement getDateOnMiscList() {
		return dateOnMiscList;
	}
	public WebElement getNameMainList() {
		return nameMainList;
	}
	public WebElement getMobileMainList() {
		return mobileMainList;
	}
	public WebElement getTypeMainList() {
		return typeMainList;
	}
	public WebElement getDispositionMainList() {
		return dispositionMainList;
	}
	public WebElement getInfoMainList() {
		return infoMainList;
	}
	public WebElement getCallerMainList() {
		return callerMainList;
	}
	public WebElement getNotesMainList() {
		return notesMainList;
	}
	public WebElement getSuccessfullMsg() {
		return successfullMsg;
	}
	public WebElement getTypeDrpDwn() {
		return typeDrpDwn;
	}
	public WebElement getDispDrpDwn() {
		return dispDrpDwn;
	}
	public WebElement getCallerNameDrpDwn() {
		return callerNameDrpDwn;
	}
	public WebElement getDetailsTxtBx() {
		return detailsTxtBx;
	}
	public WebElement getFromDateBtn() {
		return fromDateBtn;
	}
	public WebElement getToDateBtn() {
		return toDateBtn;
	}
	public WebElement getMiscCallsListBtn() {
		return miscCallsListBtn;
	}
	public WebElement getAddNewBtnOnMiscList() {
		return addNewBtnOnMiscList;
	}
	public WebElement getSubscribersBtn() {
		return subscribersBtn;
	}
	public WebElement getDashBoardBtn() {
		return dashBoardBtn;
	}
	public WebElement getSearchBtn() {
		return searchBtn;
	}
	public WebElement getResetBtn() {
		return resetBtn;
	}
	public List<WebElement> getCallRecordOnListing() {
		return callRecordOnListing;
	}
	public WebElement getNextPageButton() {
		return nextPageButton;
	}
	public WebElement getPreviousPageButton() {
		return previousPageButton;
	}
	public List<WebElement> getListOfPages() {
		return listOfPages;
	}
	public WebElement getNoRecordFoundMsg() {
		return noRecordFoundMsg;
	}
	public WebElement getDateRangeMoreErrorMsg() {
		return dateRangeMoreErrorMsg;
	}
	public WebElement getFromDateExceedToDateMsg() {
		return fromDateExceedToDateMsg;
	}

	
	

}
