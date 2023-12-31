package pageActions.doctorDashboard;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.BaseClass;
import pages.doctorDashboard.AppointmentAddPage;
import pages.doctorDashboard.AppointmentSchedulerCalenderPage;
import pages.doctorDashboard.Login;

/**
 * @author Mohd-Umar
 * @version 0.1
 * @since 2023-12-01
 */
public class AppointmentSchedulerCalenderPageActions extends BaseClass {

	static AppointmentSchedulerCalenderPage appSchCalPge = PageFactory.initElements(driver, AppointmentSchedulerCalenderPage.class);

	public void checkAppointment(String patient,String timeSlot){
		BaseClass.waitForPageLoad();
		String str=timeSlot+": "+patient;
		Assert.assertTrue(driver.findElement(By.xpath("//span[contains(text(),'"+str+"')]/../preceding-sibling::div[contains(text(),'"+timeSlot+"')]")).isDisplayed());
	}

	public void selectTimeSlot(String timeSlot) {
		BaseClass.waitForElementToBeClickable(appSchCalPge.getDayBtn());
		appSchCalPge.getDayBtn().click();
		WebElement timeSlotsInScheduler = driver.findElement(By.xpath("(//div[text()='Operatory 2']/../..//div[contains(text(),'" + timeSlot + "')])[2]"));
		BaseClass.waitForElementToBeClickable(timeSlotsInScheduler);
		timeSlotsInScheduler.click();
		BaseClass.switchToFrame(appSchCalPge.getFrame());
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement slot=driver.findElement(By.xpath("//div[contains(@id,'"+timeSlot+"')]"));
		BaseClass.waitForElementToBeClickable(slot);
		slot.click();
		BaseClass.waitForPageLoad();
		if (driver.getTitle().contains("Appointment Scheduler Calender")) {
			driver.findElement(By.xpath("//p[text()='This time slot is already booked']/..//span[text()='OK']"))
					.click();
			BaseClass.waitForPageLoad();
			driver.findElement(By.xpath("(//span[@class='dashboardDeleteIcon'])[1]")).click();
			BaseClass.waitForElementToBeClickable(timeSlotsInScheduler);
			timeSlotsInScheduler.click();
			BaseClass.switchToFrame(appSchCalPge.getFrame());
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			BaseClass.waitForElementToBeClickable(slot);
			slot.click();
		}
		BaseClass.switchToDefaultContent();
		BaseClass.waitForPageLoad();
	}

	public void eventOnSchedular(String SelectDate) {
		BaseClass.waitForPageLoad();
		Date d = new Date(SelectDate);
		SimpleDateFormat dt = new SimpleDateFormat("MMMM/dd/yyyy");
		SimpleDateFormat dt1 = new SimpleDateFormat("EEE");
		String dayString = dt1.format(d);
		String date = dt.format(d);
		String[] split = date.split("/");
		String month = split[0];
		String day = split[1];
		String monthAndDay = dayString + ", " + month + " " + Integer.parseInt(day);
		for (int i = 0; i < appSchCalPge.getWeekDays().size(); i++) {
			System.out.println(appSchCalPge.getWeekDays().get(i).getText());
			if (appSchCalPge.getWeekDays().get(i).getText().contains(monthAndDay)) {
				++i;
				String str1 = "(//div[contains(text(),'" + monthAndDay + "')]/../..//div[text()='11:00-13:00'])[";
				String str2 = "]";
				String xpath = str1 + i + str2;
				BaseClass.waitForPageLoad();
				driver.findElement(By.xpath(xpath)).click();
				BaseClass.switchToFrame(appSchCalPge.getFrame());
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				BaseClass.WaitTillElementIsPresent(appSchCalPge.getSlotTime());
				appSchCalPge.getSlotTime().click();
				BaseClass.WaitTillElementIsPresent(appSchCalPge.getAlreadyBookedMsg());
				appSchCalPge.getAlreadyBookedMsg().isDisplayed();
				appSchCalPge.getOkBtn().click();
				BaseClass.switchToDefaultContent();
				BaseClass.WaitTillElementIsPresent(appSchCalPge.getCloseBtn());
				appSchCalPge.getCloseBtn().click();
			}
		}
	}

	public void timeSlotWhichIsNotAvailableOnwscheduler(String doctor, String SelectDate, String hour, String minuts,
			String amPm) {
		BaseClass.waitForPageLoad();
		BaseClass.WaitTillElementIsPresent(appSchCalPge.getDayBtn());
		BaseClass.hoverOnElement(appSchCalPge.getDayBtn());
		appSchCalPge.getDayBtn().click();
		BaseClass.waitForPageLoad();
		BaseClass.WaitTillElementIsPresent(appSchCalPge.getDocDrpDwmScheduler());
		BaseClass.selectFromDropDownByVisibleText(appSchCalPge.getDocDrpDwmScheduler(), doctor);
		try {
			Thread.sleep(3000);
			Date d = new Date(SelectDate);
			SimpleDateFormat dt = new SimpleDateFormat("MMM/dd/yyyy");
			String date = dt.format(d);
			String[] split = date.split("/");
			String finaldate = Integer.parseInt(split[1]) + " " + split[0] + " " + split[2];
			System.out.println(finaldate + " final date");
			Thread.sleep(3000);
			try {
				boolean flag = driver.findElement(By.xpath("//div[contains(text(),'" + finaldate + "')]"))
						.isDisplayed();
				while (!flag) {
					if (!flag) {
						BaseClass.waitForElementToBeClickable(appSchCalPge.getNextBtn());
						appSchCalPge.getNextBtn().click();
					} else {
						break;
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			String time = hour + ":" + minuts + " " + amPm;
			SimpleDateFormat displayFormat = new SimpleDateFormat("HH:mm");
			SimpleDateFormat parseFormat = new SimpleDateFormat("hh:mm a");
			Date dat2 = null;
			String dat = displayFormat.format(parseFormat.parse(time));
			System.out.println(dat + " dat");
			dat2 = displayFormat.parse(dat);
			int slotSize = appSchCalPge.getTimeSlotOnScheduler().size();
			int opratory1 = slotSize / 2;
			for (int i = 0; opratory1 > i; i++) {
				String slot = appSchCalPge.getTimeSlotOnScheduler().get(i).getText();
				String[] split1 = slot.split("-");
				String str1 = split1[0];
				String str2 = split1[1];
				Date beforeTime = null, afterTime = null;
				beforeTime = displayFormat.parse(str1);
				afterTime = displayFormat.parse(str2);
				if (dat2.after(beforeTime) && dat2.before(afterTime)) {
					Assert.assertTrue(false);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
