package pages.doctorDashboard;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


/*
 * @author Mohd-Umar
 * @version 0.1
 * @since 2023-12-01
 */

public class AppointmentSchedulerCalenderPage {

	@FindBy(xpath = "//div[text()='Day']")
	private WebElement dayBtn;
	@FindBy(className = "fancybox-iframe")
	private WebElement frame;
	@FindBy(className = "dhx_cal_next_button")
	private WebElement nextBtn;
	@FindBy(xpath = "//div[contains(@id,'11:00')]")
	private WebElement slotTime;
	@FindBy(xpath = "//p[contains(text(),'Appointment date/time selected has already booked!')]")
	private WebElement alreadyBookedMsg;
	@FindBy(xpath = "//span[text()='OK']")
	private WebElement okBtn;
	@FindBy(xpath = "//div[@class='fancybox-outer']/../a[@class='fancybox-item fancybox-close']")
	private WebElement closeBtn;
	@FindBy(xpath = "//div[@class='dhx_scale_bar']")
	private List<WebElement> weekDays;
	@FindBy(xpath = "//div[@class='dhx_scale_slots']")
	private List<WebElement> timeSlotOnScheduler;
	@FindBy(id = "clinicApptDoctorDDL")
	private WebElement DocDrpDwmScheduler;

	/*
	 * Getters for the locators
	 */

	public WebElement getDayBtn() {
		return dayBtn;
	}

	public WebElement getFrame() {
		return frame;
	}

	public WebElement getNextBtn() {
		return nextBtn;
	}

	public WebElement getSlotTime() {
		return slotTime;
	}

	public WebElement getAlreadyBookedMsg() {
		return alreadyBookedMsg;
	}

	public WebElement getOkBtn() {
		return okBtn;
	}

	public WebElement getCloseBtn() {
		return closeBtn;
	}

	public List<WebElement> getWeekDays() {
		return weekDays;
	}

	public List<WebElement> getTimeSlotOnScheduler() {
		return timeSlotOnScheduler;
	}

	public WebElement getDocDrpDwmScheduler() {
		return DocDrpDwmScheduler;
	}
}
