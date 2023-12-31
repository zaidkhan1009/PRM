package pages.doctorDashboard;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/*
 * @author Mohd-Umar
 * @version 0.1
 * @since 2023-12-01
 */

public class EventListingPage {

	@FindBy(xpath = "//button[normalize-space()='Events List']")
	private WebElement eventBtn;
	@FindBy(xpath = "//input[@id='fromDate']//following-sibling::button[@class='calenderBtn']")
	private WebElement eventFromDate;
	@FindBy(xpath = "//input[@id='toDate']//following-sibling::button[@class='calenderBtn']")
	private WebElement eventToDate;
	@FindBy(xpath = "//select[@id='type']")
	private WebElement selectEventType;
	@FindBy(xpath = "//select[@id='category']")
	private WebElement selEventCat;
	@FindBy(xpath = "//a//i[text()='Event +']")
	private WebElement addEventBtnOnEvent;
	@FindBy(xpath = "//i[text()='Search']//preceding-sibling::span")
	private WebElement searchBtnOnEvent;
	@FindBy(xpath = "//span[@class='actn-icn manualUpdate']")
	private WebElement resetBtnOnEvent;
	@FindBy(xpath = "//table[@id='eventListing']//th[text()='Date-Time']")
	private WebElement date;
	@FindBy(xpath = "//table[@id='eventListing']//th[text()='Duration']")
	private WebElement duration;
	@FindBy(xpath = "//table[@id='eventListing']//th[text()='Title']")
	private WebElement title;
	@FindBy(xpath = "//table[@id='eventListing']//th[text()='Type']")
	private WebElement eventType;
	@FindBy(xpath = "//table[@id='eventListing']//th[text()='Category']")
	private WebElement category;
	@FindBy(xpath = "//table[@id='eventListing']//th[text()='Doctor']")
	private WebElement doctor;
	@FindBy(xpath = "//table[@id='eventListing']//th[text()='Clinic']")
	private WebElement clinic;
	@FindBy(xpath = "//table[@id='eventListing']//th[text()='Notes']")
	private WebElement notes;
	@FindBy(xpath = "//table[@id='eventListing']//th[text()='Action']")
	private WebElement action;
	@FindBy(xpath = "//i[normalize-space()='No Record Found!']")
	private WebElement noRecordFoundMsg;
	@FindBy(xpath = "//span[@class='cmnicons cncl-mdl']")
	private WebElement cancelBtnDelete;
	@FindBy(xpath = "//span[@class='cmnicons yes-mdl']")
	private WebElement yesBtnDelete;
	@FindBy(xpath = "//table[@id='eventListing']/tbody/tr/td[1]")
	private List<WebElement> timeSlotApp;
	@FindBy(xpath = "//span[text()='From date cannot be greater than to date!']")
	private WebElement msgFrmDateLater;
	@FindBy(xpath = "//div[@class='clearfix topPagination pagingUI']//a[@class='next']")
	private WebElement nextBtn;

	public WebElement getEventBtn() {
		return eventBtn;
	}

	public WebElement getEventFromDate() {
		return eventFromDate;
	}

	public WebElement getEventToDate() {
		return eventToDate;
	}

	public WebElement getSelectEventType() {
		return selectEventType;
	}

	public WebElement getSelEventCat() {
		return selEventCat;
	}

	public WebElement getAddEventBtnOnEvent() {
		return addEventBtnOnEvent;
	}

	public WebElement getSearchBtnOnEvent() {
		return searchBtnOnEvent;
	}

	public WebElement getResetBtnOnEvent() {
		return resetBtnOnEvent;
	}

	public WebElement getDate() {
		return date;
	}

	public WebElement getDuration() {
		return duration;
	}

	public WebElement getTitle() {
		return title;
	}

	public WebElement getEventType() {
		return eventType;
	}

	public WebElement getCategory() {
		return category;
	}

	public WebElement getDoctor() {
		return doctor;
	}

	public WebElement getClinic() {
		return clinic;
	}

	public WebElement getNotes() {
		return notes;
	}

	public WebElement getAction() {
		return action;
	}

	public WebElement getNoRecordFoundMsg() {
		return noRecordFoundMsg;
	}

	public WebElement getCancelBtnDelete() {
		return cancelBtnDelete;
	}

	public WebElement getYesBtnDelete() {
		return yesBtnDelete;
	}

	public List<WebElement> getTimeSlotApp() {
		return timeSlotApp;
	}

	public WebElement getMsgFrmDateLater() {
		return msgFrmDateLater;
	}

	public WebElement getNextBtn() {
		return nextBtn;
	}

}
