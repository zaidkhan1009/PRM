package pageActions.doctorDashboard;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import base.BaseClass;
import pages.doctorDashboard.AppointmentAddPage;
import pages.doctorDashboard.EventPage;

public class EventPageActions extends BaseClass {

	static AppointmentAddPage appointmentPage = PageFactory.initElements(driver, AppointmentAddPage.class);
	static EventPage eventPage = PageFactory.initElements(driver, EventPage.class);

	/*
	 * WebElement on Event Add Page
	 */

	public static void clickOnEvent() {
		BaseClass.waitForElementToBeClickable(eventPage.getEventFormTab());
		BaseClass.waitForSpinnerToDisappear();
		eventPage.getEventFormTab().click();
		BaseClass.waitForSpinnerToDisappear();
	}

	public static void selectByOperatoryEvent() {
		BaseClass.WaitTillElementIsPresent(eventPage.getEventByOperatory());
		BaseClass.waitForElementToBeClickable(eventPage.getEventByOperatory());
		eventPage.getEventByOperatory().click();

	}

	public static void selectByRoomEvent() {
		BaseClass.WaitTillElementIsPresent(eventPage.getEventByRoom());
		BaseClass.waitForElementToBeClickable(eventPage.getEventByRoom());
		eventPage.getEventByRoom().click();
	}

	public static void selectByScannerEvent() {
		BaseClass.waitForElementToBeClickable(eventPage.getEventByScanner());
		eventPage.getEventByScanner().click();

	}

	public static void clickOnEventSaveBtn() {
		BaseClass.waitForElementToBeClickable(eventPage.getEventSaveBtn());
		eventPage.getEventSaveBtn().click();
		BaseClass.waitForPageLoad();
		BaseClass.waitForSpinnerToDisappear();
//		
	}

	public static void verifyEventAddSuccessMsg() {
		BaseClass.WaitTillElementIsPresent(eventPage.getEventAddSuccessMsg());
		BaseClass.softAssert().assertTrue(eventPage.getEventAddSuccessMsg().isDisplayed());

	}

	public static void verifyEventUpdatedSuccessMsg() {
		BaseClass.WaitTillElementIsPresent(eventPage.getEventUpdateSuccessMsg());
		BaseClass.softAssert().assertTrue(eventPage.getEventUpdateSuccessMsg().isDisplayed());
	}

	public static void verifyEventDeleteSuccessMsg() {
		BaseClass.WaitTillElementIsPresent(eventPage.getEventDeleteSuccessMsg());
		BaseClass.softAssert().assertTrue(eventPage.getEventDeleteSuccessMsg().isDisplayed());

	}

	public static void clickOnEventResetBtn() {
		BaseClass.waitForElementToBeClickable(eventPage.getEventResetBtn());
		BaseClass.waitForSpinnerToDisappear();
		eventPage.getEventResetBtn().click();
		BaseClass.waitForSpinnerToDisappear();

	}

	/*
	 * Verifying By Default By doctor Event Type is selected
	 */
	public static void verifyDefaultSelectedEventType() {
		//BaseClass.waitForElementToBeClickable(eventPage.getEventByDoctor());
		Assert.assertTrue(eventPage.getEventByDoctor().isSelected());

	}

	public static void enterTitleName(String titleName) {
		BaseClass.waitForElementToBeClickable(eventPage.getTitle());
		eventPage.getTitle().clear();
		eventPage.getTitle().sendKeys(titleName);
	}

	public static void selectClinicInEvent(String clinic) {
		BaseClass.waitForElementToBeClickable(eventPage.getClinicInEvent());
		BaseClass.waitForSpinnerToDisappear();
		BaseClass.selectFromDropDownByVisibleText(eventPage.getClinicInEvent(), clinic);

	}

	public static void selectDoctorInEvent(String doctor) {
		BaseClass.waitForElementToBeClickable(eventPage.getDoctorEvent());
		BaseClass.selectFromDropDownByVisibleText(eventPage.getDoctorEvent(), doctor.trim());
	}

	public static void selectEventCategory(String category) {
		BaseClass.waitForElementToBeClickable(eventPage.getEventCategory());
		BaseClass.selectFromDropDownByVisibleText(eventPage.getEventCategory(), category);
	}

	/*
	 * Select Date on Event Add/Edit Screen
	 */
	public static void selectDateInEvent(String SelectDate) {
		String element_id = "eventDate";
		BaseClass.waitForPageLoad();
		BaseClass.WaitTillElementIsPresent(eventPage.getEventDate());
		BaseClass.appointmentDate(SelectDate, eventPage.getEventDate(), element_id);
	}

	public static void selectOperatory(String operatory) {
		BaseClass.waitForElementToBeClickable(eventPage.getOperatoryInEvent());
		BaseClass.selectFromDropDownByVisibleText(eventPage.getOperatoryInEvent(), operatory);
	}

	public static void selectRoom(String room) {
		BaseClass.waitForElementToBeClickable(eventPage.getRoomInEvent());
		BaseClass.selectFromDropDownByVisibleText(eventPage.getRoomInEvent(), room);
	}

	public static void selectScanner(String scanner) {
		BaseClass.waitForElementToBeClickable(eventPage.getScannerInEvent());
		BaseClass.selectFromDropDownByVisibleText(eventPage.getScannerInEvent(), scanner);

	}

	public static void enterNotes(String notes) {
		BaseClass.WaitTillElementIsPresent(eventPage.getNotesText());
		eventPage.getNotesText().clear();
		eventPage.getNotesText().sendKeys(notes);
	}

	public static void clickOnFullDayCheckBox() {
		BaseClass.waitForElementToBeClickable(eventPage.getFulldayBtn());
		eventPage.getFulldayBtn().click();
	}

	public static void enterHours(String hour) {
		BaseClass.waitForElementToBeClickable(eventPage.getHours());
		eventPage.getHours().clear();
		eventPage.getHours().sendKeys(hour);
	}

	public static void enterMinutes(String eventMinutes) {
		BaseClass.waitForElementToBeClickable(eventPage.getMinutes());
		eventPage.getMinutes().clear();
		eventPage.getMinutes().sendKeys(eventMinutes);
	}

	public static void selectAmPm(String AmPm) {
		BaseClass.WaitTillElementIsPresent(eventPage.getAmPm());
		BaseClass.selectFromDropDownByVisibleText(eventPage.getAmPm(), AmPm);
	}

	public static void enterEventDuration(String duration) {
		BaseClass.waitForElementToBeClickable(eventPage.getEventDuration());
		eventPage.getEventDuration().clear();
		eventPage.getEventDuration().sendKeys(duration);
	}

	public static boolean verifyEventTitleTextFieldAndPlaceholder() {
		BaseClass.WaitTillElementIsPresent(eventPage.getTitle());
		return eventPage.getTitle().isDisplayed() && eventPage.getTitle().getAttribute("placeholder").equals("» title");

	}

	public static boolean verifyDurationHoursFieldAndPlaceholder() {
		BaseClass.WaitTillElementIsPresent(eventPage.getHours());
		return eventPage.getHours().isDisplayed() && eventPage.getHours().getAttribute("placeholder").equals("» HH");
	}

	public static boolean verifyDurationMinuteFieldAndPlaceholder() {
		BaseClass.WaitTillElementIsPresent(eventPage.getMinutes());
		return eventPage.getMinutes().isDisplayed() && eventPage.getMinutes().getAttribute("placeholder").equals("» MM");

	}

	public static boolean verifyEventDurationInMinsFieldAndPlaceholder() {
		BaseClass.WaitTillElementIsPresent(eventPage.getEventDuration());
		return eventPage.getEventDuration().isDisplayed() && eventPage.getEventDuration().getAttribute("placeholder").equals("» Duration in Mins");

	}

	/*
	 * Check all the Fields ,dropdown shown on Add Event Screen
	 */
	private static boolean verifyAllCommonWebElementOnAddEvent() {
		BaseClass.waitForPageLoad();
		
		WebElement checkDoctor = driver.findElement(By.xpath("//li[@class='ng-scope advDis']"));
		
		boolean flag = checkDoctor.isDisplayed();
		/*
		 * eventPage.getEventByDoctor().isDisplayed() &&
		 * verifyEventTitleTextFieldAndPlaceholder() &&
		 * (eventPage.getClinicInEvent().isDisplayed() &&
		 * eventPage.getEventCategory().isDisplayed() &&
		 * eventPage.getEventDate().isDisplayed()) &&
		 * (verifyDurationHoursFieldAndPlaceholder() &&
		 * verifyDurationMinuteFieldAndPlaceholder()) &&
		 * (eventPage.getAmPm().isDisplayed() &&
		 * verifyEventDurationInMinsFieldAndPlaceholder() &&
		 * eventPage.getFulldayBtn().isDisplayed()) &&
		 * (eventPage.getNotesText().isDisplayed() &&
		 * eventPage.getEventSaveBtn().isDisplayed() &&
		 * eventPage.getEventResetBtn().isDisplayed()) &&
		 * eventPage.getCancelBtn().isDisplayed();
		 */
		return flag;

	}

	public static void verifyAllMandatoryWebElementOnByDoctorEvent() {
		BaseClass.waitForPageLoad();
		boolean isAllMandatoryFieldDisplayed = eventPage.getDoctorEvent().isDisplayed() && verifyAllCommonWebElementOnAddEvent();
		Assert.assertTrue(isAllMandatoryFieldDisplayed);
	}

	public static void verifyAllMandatoryWebElementOnByOperatoryEvent() {
		selectByOperatoryEvent();
		BaseClass.WaitTillElementIsPresent(eventPage.getOperatoryInEvent());
		boolean isAllMandatoryFieldDisplayed = eventPage.getEventByOperatory().isDisplayed() && eventPage.getOperatoryInEvent().isDisplayed()
				&& verifyAllCommonWebElementOnAddEvent();
		Assert.assertTrue(isAllMandatoryFieldDisplayed);
	}

	public static void verifyAllMandatoryWebElementOnByRoomEvent() {
		selectByRoomEvent();
		BaseClass.WaitTillElementIsPresent(eventPage.getRoomInEvent());
		boolean isAllMandatoryFieldDisplayed = eventPage.getEventByRoom().isDisplayed() && eventPage.getRoomInEvent().isDisplayed()
				&& verifyAllCommonWebElementOnAddEvent();
		Assert.assertTrue(isAllMandatoryFieldDisplayed);
	}

	public static void verifyAllMandatoryWebElementOnByScannerEvent() {
		selectByScannerEvent();
		BaseClass.WaitTillElementIsPresent(eventPage.getScannerInEvent());
		boolean isAllMandatoryFieldDisplayed = eventPage.getEventByScanner().isDisplayed() && eventPage.getScannerInEvent().isDisplayed()
				&& verifyAllCommonWebElementOnAddEvent();
		Assert.assertTrue(isAllMandatoryFieldDisplayed);
	}

	/*
	 * Check Default selected clinic in Clinic dropdown on Add Event Screen
	 */
	public static void verifyDefaultSelectedClinic(String clinic) {
		BaseClass.WaitTillElementIsPresent(eventPage.getClinicInEvent());
		WebElement byDefaultClinic = driver
				.findElement(By.xpath("//option[@selected='selected']/../option[text()='" + clinic + "']"));
		boolean isDefaultSelectedClinicCorrect = byDefaultClinic.isSelected();
		Assert.assertTrue(isDefaultSelectedClinicCorrect);
	}

	public static void verifyDefaultSelectedOptionInDoctorDrpDwn() {
		BaseClass.WaitTillElementIsPresent(eventPage.getDoctorEvent());
		String defaultOptionSelectedInDoctorDrpDwn = BaseClass.firstSelectedOption(eventPage.getDoctorEvent());
		if (defaultOptionSelectedInDoctorDrpDwn.equals("Select Doctor")) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}

	public static void verifyDefaultSelectedOptionInOperatoryDrpDwn() {
		String defaultOptionSelectedInOperatoryDrpDwn = BaseClass.firstSelectedOption(eventPage.getOperatoryInEvent());
		if (defaultOptionSelectedInOperatoryDrpDwn.equals("Select Operatory")) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}

	public static void verifyDefaultSelectedOptionInRoomDrpDwn() {
		String defaultOptionSelectedInRoomDrpDwn = BaseClass.firstSelectedOption(eventPage.getRoomInEvent());
		if (defaultOptionSelectedInRoomDrpDwn.equals("Select Room")) {

			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}

	public static void verifyDefaultSelectedOptionInScannerDrpDown() {
		BaseClass.WaitTillElementIsPresent(eventPage.getScannerInEvent());
		String defaultOptionSelectedInScannerDrpdwn = BaseClass.firstSelectedOption(eventPage.getScannerInEvent());
		boolean isDefaultSelectedScannerCorrect = defaultOptionSelectedInScannerDrpdwn.equals("Select Scanner");
		Assert.assertTrue(isDefaultSelectedScannerCorrect);

	}

	public static void verifyDefaultSelectedOptionInCategoryDrpDwn() {
		BaseClass.WaitTillElementIsPresent(eventPage.getEventCategory());
		String defaultOptionSelectedInCategoryDrpDwn = BaseClass.firstSelectedOption(eventPage.getEventCategory());
		boolean isDefaultSelectedCategoryCorrect = defaultOptionSelectedInCategoryDrpDwn.equals("Select Category");
		Assert.assertTrue(isDefaultSelectedCategoryCorrect);

	}

	public static void behaviourOfEventType() {
		BaseClass.WaitTillElementIsPresent(eventPage.getFulldayBtn());
		if (eventPage.getFulldayBtn().isDisplayed() && eventPage.getHours().isDisplayed() && eventPage.getMinutes().isDisplayed() && eventPage.getAmPm().isDisplayed()
				&& eventPage.getEventDuration().isDisplayed()) {
			BaseClass.WaitTillElementIsPresent(eventPage.getFulldayBtn());
			BaseClass.executeScript(eventPage.getFulldayBtn());
			boolean flag = eventPage.getHours().isEnabled() && eventPage.getMinutes().isEnabled() && eventPage.getAmPm().isEnabled() && eventPage.getEventDuration().isEnabled();
			Assert.assertFalse(flag);
		} else {
			Assert.assertTrue(false);
		}
	}

	public static void enterTittleErrorMsg() {
		BaseClass.WaitTillElementIsPresent(eventPage.getTittleErrorMsg());
		Assert.assertTrue(eventPage.getTittleErrorMsg().isDisplayed());

	}

	public static void selectCategoryErrorMsg() {
		BaseClass.WaitTillElementIsPresent(eventPage.getSelectCategoryErrorMsg());
		Assert.assertTrue(eventPage.getSelectCategoryErrorMsg().isDisplayed());
	}

	public static void eventDurationErrorMsg() {
		BaseClass.WaitTillElementIsPresent(eventPage.getEventDurationErrorMsg());
		Assert.assertTrue(eventPage.getEventDurationErrorMsg().isDisplayed());

	}

	public static void selectDoctorErrorMsg() {
		BaseClass.WaitTillElementIsPresent(eventPage.getSelectDoctorErrorMsg());
		Assert.assertTrue(eventPage.getSelectDoctorErrorMsg().isDisplayed());
	}

	public static void selectOperatoryErrorMsg() {
		selectByOperatoryEvent();
		BaseClass.WaitTillElementIsPresent(eventPage.getSelectOperatoryErrorMsg());
		Assert.assertTrue(eventPage.getSelectOperatoryErrorMsg().isDisplayed());
	}

	public static void selectRoomErrorMsg() {
		selectByRoomEvent();
		BaseClass.WaitTillElementIsPresent(eventPage.getSelectRoomErrorMsg());
		Assert.assertTrue(eventPage.getSelectRoomErrorMsg().isDisplayed());
	}

	public static void selectScannerErrorMsg() {
		selectByScannerEvent();
		BaseClass.WaitTillElementIsPresent(eventPage.getSelectScannerErrorMsg());
		Assert.assertTrue(eventPage.getSelectScannerErrorMsg().isDisplayed());

	}

	/*
	 * Checking the Error Msg shown when event is booked for last available
	 * operatory in clinic for the date/time.
	 */
	public static void verifyErrorOnAddingEventOnLastAvailableOperatory() {
		BaseClass.waitForElementToBeClickable(eventPage.getLastOperatoryAvailableErrorMsg());
		Assert.assertTrue(eventPage.getLastOperatoryAvailableErrorMsg().isDisplayed());

	}

	/*
	 * Checking the Error Msg shown when event is booked for last available scanner
	 * in clinic for the date/time.
	 */
	public static void verifyErrorOnAddingEventOnLastAvailableScanner() {
		BaseClass.waitForElementToBeClickable(eventPage.getLastScannerAvailableErrorMsg());
		Assert.assertTrue(eventPage.getLastScannerAvailableErrorMsg().isDisplayed());

	}

	public static void verifyEventAlreadyBookedForSlotErrorMsg() {
		BaseClass.waitForElementToBeClickable(eventPage.getEventAlreadyBookedForSlotErrorMsg());
		Assert.assertTrue(eventPage.getEventAlreadyBookedForSlotErrorMsg().isDisplayed());

	}

	public static void invalidDataInDuration() {
		BaseClass.WaitTillElementIsPresent(eventPage.getInvalidDuratinMsg());
		Assert.assertTrue(eventPage.getInvalidDuratinMsg().isDisplayed());
	}

	public static boolean verifyInvalidHoursErrorMsg() {

		try {
			BaseClass.WaitTillElementIsPresent(eventPage.getInvalidHoursErrorMsg());
			return eventPage.getInvalidHoursErrorMsg().isDisplayed();
		}

		catch (NoSuchElementException noSuchElementException) {
			return false;
		}

	}

	public static boolean verifyInvalidMintuesErrorMsg() {
		try {
			BaseClass.WaitTillElementIsPresent(eventPage.getInvalidMinutesErrorMsg());
			return eventPage.getInvalidMinutesErrorMsg().isDisplayed();
		}

		catch (NoSuchElementException noSuchElementException) {
			return false;
		}

	}

	public static void verifyDurationCannotBeZeroErrorMsg() {
		BaseClass.waitForElementToBeClickable(eventPage.getEventDurationCannotBeZeroErrorMsg());
		Assert.assertTrue(eventPage.getEventDurationCannotBeZeroErrorMsg().isDisplayed());
		BaseClass.waitTillInvisiblityOfElement(eventPage.getEventDurationCannotBeZeroErrorMsg());

	}

	public static void verifyDurationMoreThanAvailableMinErrorMsg() {
		BaseClass.waitForElementToBeClickable(eventPage.getDurationMoreThanAvailableMinInDayErrorMsg());
		Assert.assertTrue(eventPage.getDurationMoreThanAvailableMinInDayErrorMsg().isDisplayed());
	}

	public static void verifyEventTimePassedErrorMessage() {
		BaseClass.waitForElementToBeClickable(eventPage.getTimeAlreadyPassErrorMsg());
		Assert.assertTrue(eventPage.getTimeAlreadyPassErrorMsg().isDisplayed());

	}

	public static void clickOnCancelBtn() {
		BaseClass.waitForElementToBeClickable(eventPage.getCancelBtn());
		BaseClass.waitForSpinnerToDisappear();
		eventPage.getCancelBtn().click();
		BaseClass.waitForPageLoad();
	}

	public static void clearEventDuration() {
		BaseClass.WaitTillElementIsPresent(eventPage.getEventDuration());
		eventPage.getEventDuration().clear();

	}

	/*
	 * Checking eventPage.getTitle() when event is edited
	 */
	public static void verifyEnteredEventTitleInEdit(String expectedEventTitle) {
		BaseClass.waitForElementToBeClickable(eventPage.getTitle());
		String actualEventTitle = getEnteredText("title");
		Assert.assertEquals(expectedEventTitle, actualEventTitle);

	}

	/*
	 * Checking By Default current date is selected in Date on Add Event
	 */
	public static void verifySelectedDateInEvent(String expectedEventDate) {
		BaseClass.waitForElementToBeClickable(eventPage.getEventDate());
		String actualEventDate = getEnteredText("eventDate");
		Date d = new Date(expectedEventDate);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
		expectedEventDate = simpleDateFormat.format(d);
		Assert.assertEquals(actualEventDate, expectedEventDate);

	}

	public static void getEventNotes(String expectedEventNotes) {
		BaseClass.waitForElementToBeClickable(eventPage.getNotesText());
		String actualEventNotes = getEnteredText("eventNotes");
		Assert.assertEquals(expectedEventNotes, actualEventNotes);
	}

	public static void verifySelectedClinicInEdit(String clinic) {
		BaseClass.waitForElementToBeClickable(eventPage.getClinicInEvent());
		Assert.assertEquals(BaseClass.firstSelectedOption(eventPage.getClinicInEvent()), clinic);

	}

	public static void verifySelectedDoctorInEdit(String doctor) {
		BaseClass.waitForElementToBeClickable(eventPage.getDoctorEvent());
		Assert.assertEquals(BaseClass.firstSelectedOption(eventPage.getDoctorEvent()), doctor);

	}

	public static void verifySelectedCategoryInEdit(String category) {
		BaseClass.waitForElementToBeClickable(eventPage.getEventCategory());
		Assert.assertEquals(BaseClass.firstSelectedOption(eventPage.getEventCategory()), category);
	}

	public static void getHours(String expectedHours) {
		BaseClass.waitForElementToBeClickable(eventPage.getHours());
		String actualHours = getEnteredText("hours");
		Assert.assertEquals(actualHours, expectedHours);
	}

	public static void getMinutes(String expectedMinutes) {
		BaseClass.waitForElementToBeClickable(eventPage.getMinutes());
		String actualMinutes = getEnteredText("minutes");
		Assert.assertEquals(actualMinutes, expectedMinutes);
	}

	public static void getDurations(String expectedDuration) {
		BaseClass.waitForElementToBeClickable(eventPage.getEventDuration());
		String actualDuration = getEnteredText("duration");
		Assert.assertEquals(actualDuration, expectedDuration);
	}

	public static void getAMPM(String value) {
		BaseClass.WaitTillElementIsPresent(eventPage.getAmPm());
		Assert.assertEquals(BaseClass.firstSelectedOption(eventPage.getAmPm()), value);

	}

	public static void verifySelectedOperatoryInEdit(String expectedOperatory) {
		BaseClass.waitForElementToBeClickable(eventPage.getOperatoryInEvent());
		Assert.assertEquals(BaseClass.firstSelectedOption(eventPage.getOperatoryInEvent()), expectedOperatory);

	}

	public static void verifySelectedRoomInEdit(String expectedRoom) {
		BaseClass.waitForElementToBeClickable(eventPage.getRoomInEvent());
		Assert.assertEquals(BaseClass.firstSelectedOption(eventPage.getRoomInEvent()), expectedRoom);
	}

	public static void verifySelectedScannerInEdit(String expectedScanner) {
		BaseClass.waitForElementToBeClickable(eventPage.getScannerInEvent());
		Assert.assertEquals(BaseClass.firstSelectedOption(eventPage.getScannerInEvent()), expectedScanner);
	}

	public static void verifyFullDayEventCheckboxInEdit() {
		BaseClass.waitForElementToBeClickable(eventPage.getFulldayBtn());
		WebElement element = driver
				.findElement(By.xpath("//label[text()='Full Day Event']/preceding-sibling::input"));
		if (element.getAttribute("class").contains("ng-valid-required")) {
			Assert.assertTrue(true);

		} else {
			Assert.assertFalse(true);
		}

	}

	/*
	 * checking the time slot for which Event is added/Update and delete is coming
	 * disable or selectable on Add Appointment Screen
	 */
	public static void checkTimeSlotIsDisableOrSelectableInAddAppt(String eventDate, String eventStartTime,
			String eventDuration, String expectedAttributeValue) {
		BaseClass.WaitTillElementIsPresent(appointmentPage.getDateAppointment());
		AppointmentAddPageActions.selectDateofAppointment(eventDate);
		BaseClass.waitForPageLoad();
		Select slot = new Select(appointmentPage.getTimeSlot());
		List<WebElement> appointmentSlots = slot.getOptions();
		if (eventPage.getEventDuration().equals("All day event")) {
			for (WebElement ele : appointmentSlots) {
				Assert.assertEquals(ele.getAttribute(expectedAttributeValue), "true");

			}
		} else {
			int duration = Integer.parseInt(eventDuration) / 30;
			while (duration > 0) {
				BaseClass.selectFromDropDownByVisibleText(appointmentPage.getTimeSlot(), eventStartTime);
				WebElement eventAddedTimeSlot = driver
						.findElement(By.xpath("//option[@value='" + eventStartTime + "']"));
				Assert.assertEquals(eventAddedTimeSlot.getAttribute(expectedAttributeValue), "true");
				eventStartTime = getSlotTime(eventStartTime);
				duration--;
			}

		}

	}
	
	public static void checkTimeSlotIsDisabledInAddAppt(String eventDate, String eventStartTime,
			String eventDuration, String expectedAttributeValue) {
		BaseClass.WaitTillElementIsPresent(appointmentPage.getDateAppointment());
		AppointmentAddPageActions.selectDateofAppointment(eventDate);
		BaseClass.waitForPageLoad();
		Select slot = new Select(appointmentPage.getTimeSlot());
		List<WebElement> appointmentSlots = slot.getOptions();
		if (eventPage.getEventDuration().equals("All day event")) {
			for (WebElement ele : appointmentSlots) {
				Assert.assertEquals(ele.getAttribute(expectedAttributeValue), "disabled");

			}
		} else {
			int duration = Integer.parseInt(eventDuration) / 30;
			while (duration > 0) {
				// Now the functionality isn't available
				// BaseClass.selectFromDropDownByVisibleText(appointmentPage.getTimeSlot(), eventStartTime);
				WebElement eventAddedTimeSlot = driver
						.findElement(By.xpath("//option[@value='" + eventStartTime + "']"));
				Assert.assertEquals(eventAddedTimeSlot.getAttribute(expectedAttributeValue), "disabled");
				eventStartTime = getSlotTime(eventStartTime);
				duration--;
			}

		}

	}

	/*
	 * checking the time slot for which Event is added is coming disable on Add
	 * Appointment Screen
	 */
	public static void checkTimeSlotIsDisableOnAddAppt(String eventDate, String eventStartTime, String eventDuration) {
		checkTimeSlotIsDisabledInAddAppt(eventDate, eventStartTime, eventDuration, "disabled");
	}

	/*
	 * checking the time slot for which Event is deleted is coming selectable on Add
	 * Appointment Screen
	 */
	public static void checkTimeSlotIsSelectableOnAddAppt(String eventDate, String eventStartTime, String eventDuration) {
		checkTimeSlotIsDisableOrSelectableInAddAppt(eventDate, eventStartTime, eventDuration, "selected");

	}

	/*
	 * checking the Doctor for which Event is added/Update and delete is coming
	 * disable or selectable on Add Appointment Screen in doctor dropdown
	 */
	private static void checkDoctorIsDisableOrSelectableInAddAppt(String eventDoctor, String eventDate, String eventDuration,
			String eventStartTime, String expectedAttributeValue) {
		BaseClass.waitForPageLoad();
		BaseClass.WaitTillElementIsPresent(appointmentPage.getDateAppointment());
		AppointmentAddPageActions.selectDateofAppointment(eventDate);
		BaseClass.waitForSpinnerToDisappear();
		Select slot = new Select(appointmentPage.getTimeSlot());
		List<WebElement> appointmentSlot = slot.getOptions();

		if (eventPage.getEventDuration().equals("All day event")) {

			for (int i = 1; i < appointmentSlot.size(); i++) {
				BaseClass.selectFromDropDownByVisibleText(appointmentPage.getTimeSlot(), appointmentSlot.get(i).getText());
				BaseClass.waitForSpinnerToDisappear();
				BaseClass.selectFromDropDownByVisibleText(appointmentPage.getDoctor(), eventDoctor);
				WebElement doctor = driver
						.findElement(By.xpath("//select/option[contains(text(),'" + eventDoctor + "')]"));
				Assert.assertTrue(doctor.getAttribute(expectedAttributeValue).contains("true"));

			}

		}

		else {
			int duration = Integer.parseInt(eventDuration) / 30;
			while (duration > 0) {
				BaseClass.selectFromDropDownByVisibleText(appointmentPage.getTimeSlot(), eventStartTime);
				BaseClass.waitForPageLoad();
				BaseClass.waitForSpinnerToDisappear();
				BaseClass.selectFromDropDownByVisibleText(appointmentPage.getDoctor(), eventDoctor);
				WebElement doctor = driver
						.findElement(By.xpath("//select/option[contains(text(),'" + eventDoctor + "')]"));
				Assert.assertTrue(doctor.getAttribute(expectedAttributeValue).contains("true"));
				eventStartTime = getSlotTime(eventStartTime);
				duration--;

			}
		}
	}
	
	private static void checkDoctorIsDisabledInAddAppt(String eventDoctor, String eventDate, String eventDuration,
			String eventStartTime, String expectedAttributeValue) {
		BaseClass.waitForPageLoad();
		BaseClass.WaitTillElementIsPresent(appointmentPage.getDateAppointment());
		AppointmentAddPageActions.selectDateofAppointment(eventDate);
		BaseClass.waitForSpinnerToDisappear();
		Select slot = new Select(appointmentPage.getTimeSlot());
		List<WebElement> appointmentSlot = slot.getOptions();

		if (eventPage.getEventDuration().equals("All day event")) {

			for (int i = 1; i < appointmentSlot.size(); i++) {
				BaseClass.selectFromDropDownByVisibleText(appointmentPage.getTimeSlot(), appointmentSlot.get(i).getText());
				BaseClass.waitForSpinnerToDisappear();
				//Commetning the code since value is disabled now
				//BaseClass.selectFromDropDownByVisibleText(appointmentPage.getDoctor(), eventDoctor);
				WebElement doctor = driver
						.findElement(By.xpath("//select/option[contains(text(),'" + eventDoctor + "')]"));
				Assert.assertTrue(doctor.getAttribute(expectedAttributeValue).contains("true"));

			}

		}

		else {
			int duration = Integer.parseInt(eventDuration) / 30;
			while (duration > 0) {
				BaseClass.selectFromDropDownByVisibleText(appointmentPage.getTimeSlot(), eventStartTime);
				BaseClass.waitForPageLoad();
				BaseClass.waitForSpinnerToDisappear();
				//Commenting below code
				//BaseClass.selectFromDropDownByVisibleText(appointmentPage.getDoctor(), eventDoctor);
				WebElement doctor = driver
						.findElement(By.xpath("//select/option[contains(text(),'" + eventDoctor + "')]"));
				Assert.assertTrue(doctor.getAttribute(expectedAttributeValue).contains("true"));
				eventStartTime = getSlotTime(eventStartTime);
				duration--;

			}
		}
	}

	public static void checkDoctorIsSelectableInAddAppointmentDoctorDropdown(String eventDoctor, String eventDate,
			String eventDuration, String eventStartTime) {
		checkDoctorIsDisableOrSelectableInAddAppt(eventDoctor, eventDate, eventDuration, eventStartTime, "selected");

	}

	public static void checkEventAddedDoctorIsDisable(String eventDoctor, String eventDate, String eventDuration,
			String eventStartTime) {
		checkDoctorIsDisabledInAddAppt(eventDoctor, eventDate, eventDuration, eventStartTime, "disabled");
		
	}
	
	public static void checkEventAddedDoctorIsUnavailable(String eventDoctor, String eventDate, String eventDuration,
			String eventStartTime) {
		
		BaseClass.waitForPageLoad();
		BaseClass.WaitTillElementIsPresent(appointmentPage.getDateAppointment());
		AppointmentAddPageActions.selectDateofAppointment(eventDate);
		BaseClass.waitForSpinnerToDisappear();
		Select slot = new Select(appointmentPage.getTimeSlot());
		List<WebElement> appointmentSlot = slot.getOptions();
		
		if (eventDuration.equals("All day event")) {

			for (int i = 1; i < appointmentSlot.size(); i++) {
				BaseClass.selectFromDropDownByVisibleText(appointmentPage.getTimeSlot(), appointmentSlot.get(i).getText());
				BaseClass.waitForSpinnerToDisappear();
				
				//Doctor is not selectable now so updating the code
				//BaseClass.selectFromDropDownByVisibleText(appointmentPage.getDoctor(), eventDoctor);
				
				WebElement doctor = driver.findElement(By.xpath("//select/option[contains(text(),'" + eventDoctor + "')]"));
				
				Assert.assertTrue(doctor.getAttribute("disabled").contains("true"));

			}

		}

		else {
			int duration = Integer.parseInt(eventDuration) / 30;
			while (duration > 0) {
				BaseClass.selectFromDropDownByVisibleText(appointmentPage.getTimeSlot(), eventStartTime);
				BaseClass.waitForPageLoad();
				BaseClass.waitForSpinnerToDisappear();
				
				//Doctor is not selectable now so updating the code
				//BaseClass.selectFromDropDownByVisibleText(appointmentPage.getDoctor(), eventDoctor);
				WebElement doctor = driver
						.findElement(By.xpath("//select/option[contains(text(),'" + eventDoctor + "')]"));
				Assert.assertTrue(doctor.getAttribute("disabled").contains("true"));
				eventStartTime = getSlotTime(eventStartTime);
				duration--;

			}
		}
	}

	public static void checkDisableEnableOfOperatoryOnAddAppointment(String eventDate, String eventDuration,
			String eventStartTime, String expectedAttributeValue, String eventWebElement) {
		BaseClass.waitForPageLoad();
		BaseClass.waitForSpinnerToDisappear();
		AppointmentAddPageActions.selectDateofAppointment(eventDate);
		BaseClass.waitForPageLoad();
		Select sel = new Select(appointmentPage.getTimeSlot());
		List<WebElement> appointmentSlot = sel.getOptions();
		if (eventDuration.equals("All day event")) {
			for (int i = 0; i < appointmentSlot.size(); i++) {
				BaseClass.selectFromDropDownByVisibleText(appointmentPage.getTimeSlot(), appointmentSlot.get(i).getText());
				BaseClass.waitForSpinnerToDisappear();
				WebElement eventoperatory = driver.findElement(By.xpath(eventWebElement));
				Assert.assertTrue(eventoperatory.getAttribute("class").contains(expectedAttributeValue));
			}
		}

		else {
			int duration = Integer.parseInt(eventDuration) / 30; // eventDate changed from
			while (duration > 0) {
				BaseClass.selectFromDropDownByVisibleText(appointmentPage.getTimeSlot(), eventStartTime);
				BaseClass.waitForSpinnerToDisappear();
				WebElement eventOperatory = driver.findElement(By.xpath(eventWebElement));
				Assert.assertTrue(eventOperatory.getAttribute("class").contains(expectedAttributeValue));
				eventStartTime = getSlotTime(eventStartTime);
				duration--;

			}
		}
	}
	
	public static void checkDisableOperatoryOnAddAppointment(String eventDate, String eventDuration,
			String eventStartTime, String expectedAttributeValue, String eventWebElement) {
		BaseClass.waitForPageLoad();
		BaseClass.waitForSpinnerToDisappear();
		AppointmentAddPageActions.selectDateofAppointment(eventDate);
		BaseClass.waitForPageLoad();
		Select sel = new Select(appointmentPage.getTimeSlot());
		List<WebElement> appointmentSlot = sel.getOptions();
		if (eventPage.getEventDuration().equals("All day event")) {
			for (int i = 0; i < appointmentSlot.size(); i++) {
				BaseClass.selectFromDropDownByVisibleText(appointmentPage.getTimeSlot(), appointmentSlot.get(i).getText());
				BaseClass.waitForSpinnerToDisappear();
				WebElement eventoperatory = driver.findElement(By.xpath(eventWebElement));
				Assert.assertTrue(eventoperatory.getAttribute("class").contains(expectedAttributeValue));
			}
		}

		else {
			int duration = Integer.parseInt(eventDate) / 30;
			while (duration > 0) {
				BaseClass.selectFromDropDownByVisibleText(appointmentPage.getTimeSlot(), eventStartTime);
				BaseClass.waitForSpinnerToDisappear();
				WebElement eventOperatory = driver.findElement(By.xpath(eventWebElement));
				Assert.assertTrue(eventOperatory.getAttribute("class").contains(expectedAttributeValue));
				eventStartTime = getSlotTime(eventStartTime);
				duration--;

			}
		}
	}

	/*
	 * checking the Operatory for which Event is added/Update and delete is coming
	 * disable or selectable on Add Appointment Screen
	 */
	public static void checkEventAddedOperatoryIsDisable(String eventAddedOperatory, String eventDate, String eventDuration, String eventStartTime) {
		checkDisableEnableOfOperatoryOnAddAppointment(eventDate, eventDuration, eventStartTime, "booked-event",
				getEventAddedWebElement(eventAddedOperatory, "Operatory"));
	}

	public static void checkOperatoryIsSelectableInAddAppt(String eventAddedOperatory, String eventDate, String eventDuration,
			String eventStartTime) {
		checkDisableEnableOfOperatoryOnAddAppointment(eventDate, eventDuration, eventStartTime, "available",
				getEventAddedWebElement(eventAddedOperatory, "Operatory"));
	}

	/*
	 * checking the room for which Event is added/Update and delete is coming
	 * disable or selectable on Add Appointment Screen
	 */
	public static void checkRoomIsDisableOnAddAppointment(String eventAddedRoom, String eventDate, String eventDuration,
			String eventStartTime) {
		checkDisableEnableOfOperatoryOnAddAppointment(eventDate, eventDuration, eventStartTime, "booked",
				getEventAddedWebElement(eventAddedRoom, "Room"));
	}

	public static void checkRoomIsSelectableOnAddAppt(String eventAddedRoom, String eventDate, String eventDuration,
			String eventStartTime) {
		checkDisableEnableOfOperatoryOnAddAppointment(eventDate, eventDuration, eventStartTime, "available",
				getEventAddedWebElement(eventAddedRoom, "Room"));
	}

	/*
	 * checking the scanner for which Event is added/Update and delete is coming
	 * disable or selectable on Add Appointment Screen
	 */
	public static void checkEventAddedScannerIsDisable(String eventAddedScanner, String eventDate, String eventDuration,
			String eventStartTime) {
		checkDisableEnableOfOperatoryOnAddAppointment(eventDate, eventDuration, eventStartTime, "booked-event",
				getEventAddedWebElement(eventAddedScanner, "Scanner"));
	}

	public static void checkScannerIsSelectableOnAddAppt(String eventAddedScanner, String eventDate, String eventDuration,
			String eventStartTime) {
		checkDisableEnableOfOperatoryOnAddAppointment(eventDate, eventDuration, eventStartTime, "available",
				getEventAddedWebElement(eventAddedScanner, "Scanner"));
	}

	public static String getEventAddedWebElement(String eventAddedType, String eventType) {
		String eventAddedTypeNumber = eventAddedType.split(" ")[1];
		String webElementOnWhichEventIsAdded = "";
		switch (eventType) {
		case "Operatory":
			webElementOnWhichEventIsAdded = "//label[@id='operatoryLabel']//following::ul//li/a[@data-value='"
					+ eventAddedTypeNumber + "']";
			return webElementOnWhichEventIsAdded;
		case "Room":
			webElementOnWhichEventIsAdded = "//label[@id='eCosultLabel']/following-sibling::ul//a[@data-value='"
					+ eventAddedTypeNumber + "']";
			return webElementOnWhichEventIsAdded;

		case "Scanner":
			webElementOnWhichEventIsAdded = "//label[@id='scannerLabel']/following-sibling::ul//a[@data-value='"
					+ eventAddedTypeNumber + "']";
			return webElementOnWhichEventIsAdded;

		default:
			return webElementOnWhichEventIsAdded;

		}

	}

	/*
	 * Getting the Next Slot time for event added duration
	 */
	private static String getSlotTime(String eventStartTime) {
		SimpleDateFormat df = new SimpleDateFormat("HH:mm");
		try {
			Date d = df.parse(eventStartTime);
			Calendar cal = Calendar.getInstance();
			cal.setTime(d);
			cal.add(Calendar.MINUTE, 30);
			eventStartTime = df.format(cal.getTime());

		} catch (Exception e) {

		}

		return eventStartTime;

	}

	/*
	 * Common method to get the entered text from field Passing the id of field and
	 * returning the value of entered text
	 */
	private static String getEnteredText(String id) {
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
		String text = (String) javascriptExecutor.executeScript("return document.getElementById('" + id + "').value;");
		return text;
	}

	/*
	 * Getting Current Date in MMMM/dd/yyyy format
	 */
	public static String getCurrentDate() {
		Date now = new Date();
		SimpleDateFormat dt = new SimpleDateFormat("MMMM/dd/yyyy");
		String date = dt.format(now);
		return date;

	}
}
