package pages.doctorDashboard;

import java.util.List;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

public class EventPage {
	
	/*
	 * WebElement on Event Add Page
	 */
	@FindBy(xpath="//div[@class='modal overlay']")
	private WebElement loader;
	@FindBy(xpath="//li[@id='addEvent']/a[text()='Add Event']")
	private WebElement eventFormTab;
	@FindBy(xpath="//input[@value='doctor']")
	private WebElement eventByDoctor;
	@FindBy(xpath="//label[text()='By Operatory']")
	private WebElement eventByOperatory;
	@FindBy(xpath="//label[text()='By Room']")
	private WebElement eventByRoom;
	@FindBy(xpath="//label[@for='apptType-byscanner']")
	private WebElement eventByScanner;
	@FindBy(xpath="//label[text()='Title ']//following-sibling::input[@id='title']")
	private WebElement title;
	@FindBy(xpath="//label[text()='Clinic ']/following::custom-combo[@id='clinic']//select")
	private WebElement clinicInEvent;
	@FindBy(xpath="//select[@id='doctor']")
	private WebElement doctorEvent;
	@FindBy(xpath="//label[text()='Category ']/following::custom-combo[@id='category']//select")
	private WebElement eventCategory;
	@FindBy(xpath="//label[text()='Date ']/following-sibling::input[@id='eventDate']")
	private WebElement eventDate;
	@FindBy(xpath="//select[@id='operatory']")
	private WebElement operatoryInEvent;
	@FindBy(xpath="//select[@id='room']")
	private WebElement roomInEvent;
	@FindBy(xpath="//select[@id='scanner']")
	private WebElement scannerInEvent;
	@FindBy(xpath="//label[text()='Notes']//following::textarea[@id='eventNotes']")
	private WebElement notesText;
	@FindBy(xpath="//div[@class='error ng-binding ng-scope']")
	private List<WebElement> eventErrMsg;
	@FindBy(xpath="//a[@data-ng-click='resetEvent(addAppointment.eventForm)']//span[@class='cmnicons rst']")
	private WebElement eventResetBtn;
	@FindBy(xpath="//div//ul[@data-spy='affix']//span[@class='cmnicons aprsv']")
	private WebElement eventSaveBtn;
	@FindBy(xpath="//ul[@data-spy='affix']//i[text()='Cancel']")
	private WebElement cancelBtn;
	@FindBy(xpath = "//span[normalize-space()='Event added successfully!']")
	private WebElement eventAddSuccessMsg;
	@FindBy(xpath = "//span[normalize-space()='Event updated successfully!']")
	private WebElement eventUpdateSuccessMsg;
	@FindBy(xpath = "//span[normalize-space()='Event deleted successfully!']")
	private WebElement eventDeleteSuccessMsg;
	@FindBy(xpath="//label[normalize-space()='Full Day Event']")
	private WebElement fulldayBtn;
	@FindBy(xpath="//input[@id='hours']")
	private WebElement hours;
	@FindBy(xpath="//input[@id='minutes']")
	private WebElement minutes;
	@FindBy(xpath="//select[@id='ampm']")
	private WebElement amPm;
	@FindBy(xpath="//div[@class='eventTyp']//input[@id='duration']")
	private WebElement eventDuration;
	@FindBy(xpath = "//div[@role='alert']")
	private WebElement alreadyAppMsg;
	@FindBy(xpath="//div[contains(text(),'Enter event duration')]")
	private WebElement invalidDuratinMsg;
	@FindBy(xpath="//div[contains(text(),'Enter event title')]")
    private WebElement tittleErrorMsg;
	@FindBy(xpath="//div[contains(text(),'Select category')]")
	private WebElement selectCategoryErrorMsg;
	@FindBy(xpath="//div[contains(text(),'Select doctor')]")
	private WebElement selectDoctorErrorMsg;
	@FindBy(xpath="//div[contains(text(),'Select operatory')]")
	private WebElement selectOperatoryErrorMsg;
	@FindBy(xpath="//div[contains(text(),'Select room')]")
	private WebElement selectRoomErrorMsg;
	@FindBy(xpath="//div[contains(text(),'Select scanner')]")
	private WebElement selectScannerErrorMsg;
	@FindBy(xpath="//div[text()='Enter event duration']")
	private WebElement eventDurationErrorMsg;
	@FindBy(xpath="//div[text()='Time slot selected for event has already passed!']")
	private WebElement timeAlreadyPassErrorMsg;
	@FindBy(xpath="//div[text()='Max limit reached for event booking by operatory for the time range!']")
	private WebElement lastOperatoryAvailableErrorMsg;
	@FindBy(xpath="//div[text()='Max limit reached for event booking by scanner for the time range!']")
	private WebElement lastScannerAvailableErrorMsg;
	@FindBy(xpath="//div[text()='Time slot selected for event is already booked!']")
	private WebElement eventAlreadyBookedForSlotErrorMsg;
	@FindBy(xpath="//div[normalize-space()='Enter Minutes between 0 - 59']")
	private WebElement invalidMinutesErrorMsg;
	@FindBy(xpath="//div[normalize-space()='Enter Hours between 1 - 12']")
	private WebElement invalidHoursErrorMsg;
	@FindBy(xpath="//div[text()='Event duration cannot be zero !']")
	private WebElement eventDurationCannotBeZeroErrorMsg;
	@FindBy(xpath="//div[text()='Duration can only be remaining minutes available for the day!']")
	private WebElement durationMoreThanAvailableMinInDayErrorMsg;
	public WebElement getLoader() {
		return loader;
	}
	public WebElement getEventFormTab() {
		return eventFormTab;
	}
	public WebElement getEventByDoctor() {
		return eventByDoctor;
	}
	public WebElement getEventByOperatory() {
		return eventByOperatory;
	}
	public WebElement getEventByRoom() {
		return eventByRoom;
	}
	public WebElement getEventByScanner() {
		return eventByScanner;
	}
	public WebElement getTitle() {
		return title;
	}
	public WebElement getClinicInEvent() {
		return clinicInEvent;
	}
	public WebElement getDoctorEvent() {
		return doctorEvent;
	}
	public WebElement getEventCategory() {
		return eventCategory;
	}
	public WebElement getEventDate() {
		return eventDate;
	}
	public WebElement getOperatoryInEvent() {
		return operatoryInEvent;
	}
	public WebElement getRoomInEvent() {
		return roomInEvent;
	}
	public WebElement getScannerInEvent() {
		return scannerInEvent;
	}
	public WebElement getNotesText() {
		return notesText;
	}
	public List<WebElement> getEventErrMsg() {
		return eventErrMsg;
	}
	public WebElement getEventResetBtn() {
		return eventResetBtn;
	}
	public WebElement getEventSaveBtn() {
		return eventSaveBtn;
	}
	public WebElement getCancelBtn() {
		return cancelBtn;
	}
	public WebElement getEventAddSuccessMsg() {
		return eventAddSuccessMsg;
	}
	public WebElement getEventUpdateSuccessMsg() {
		return eventUpdateSuccessMsg;
	}
	public WebElement getEventDeleteSuccessMsg() {
		return eventDeleteSuccessMsg;
	}
	public WebElement getFulldayBtn() {
		return fulldayBtn;
	}
	public WebElement getHours() {
		return hours;
	}
	public WebElement getMinutes() {
		return minutes;
	}
	public WebElement getAmPm() {
		return amPm;
	}
	public WebElement getEventDuration() {
		return eventDuration;
	}
	public WebElement getAlreadyAppMsg() {
		return alreadyAppMsg;
	}
	public WebElement getInvalidDuratinMsg() {
		return invalidDuratinMsg;
	}
	public WebElement getTittleErrorMsg() {
		return tittleErrorMsg;
	}
	public WebElement getSelectCategoryErrorMsg() {
		return selectCategoryErrorMsg;
	}
	public WebElement getSelectDoctorErrorMsg() {
		return selectDoctorErrorMsg;
	}
	public WebElement getSelectOperatoryErrorMsg() {
		return selectOperatoryErrorMsg;
	}
	public WebElement getSelectRoomErrorMsg() {
		return selectRoomErrorMsg;
	}
	public WebElement getSelectScannerErrorMsg() {
		return selectScannerErrorMsg;
	}
	public WebElement getEventDurationErrorMsg() {
		return eventDurationErrorMsg;
	}
	public WebElement getTimeAlreadyPassErrorMsg() {
		return timeAlreadyPassErrorMsg;
	}
	public WebElement getLastOperatoryAvailableErrorMsg() {
		return lastOperatoryAvailableErrorMsg;
	}
	public WebElement getLastScannerAvailableErrorMsg() {
		return lastScannerAvailableErrorMsg;
	}
	public WebElement getEventAlreadyBookedForSlotErrorMsg() {
		return eventAlreadyBookedForSlotErrorMsg;
	}
	public WebElement getInvalidMinutesErrorMsg() {
		return invalidMinutesErrorMsg;
	}
	public WebElement getInvalidHoursErrorMsg() {
		return invalidHoursErrorMsg;
	}
	public WebElement getEventDurationCannotBeZeroErrorMsg() {
		return eventDurationCannotBeZeroErrorMsg;
	}
	public WebElement getDurationMoreThanAvailableMinInDayErrorMsg() {
		return durationMoreThanAvailableMinInDayErrorMsg;
	}

}
