package pageActions.patientDashboard;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import base.BaseClass;
import pages.patientDashboard.AppointmentsListPage;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Ajit Yadav
 */
public class AppointmentsListPageActions extends BaseClass {

	static AppointmentsListPage appointmentsListPage = PageFactory.initElements(driver, AppointmentsListPage.class);

    
    public static void checkAppointmentTime(String date, String slot) {
        BaseClass.waitForElementToBeClickable(appointmentsListPage.getDateTimeColumn());
        String[] split = date.split("/");
        String year = split[2].substring(2);
//        String[] sp = split[0].split("'");
        String dateMonth = split[0]+ "-" + split[1] + "-" +year;
        String time = null;
        try {
            final SimpleDateFormat sdf = new SimpleDateFormat("H:mm");
            final Date dateObj = sdf.parse(slot);
            time = new SimpleDateFormat("K:mm").format(dateObj);
        } catch (final ParseException e) {
            e.printStackTrace();
        }      
        boolean flag = checkedWebElementDisplayed(appointmentsListPage.getDateTimeColumn()) && checkedWebElementDisplayed(appointmentsListPage.getChiefComplaintColumn()) && checkedWebElementDisplayed(appointmentsListPage.getTypeColumn())
                && checkedWebElementDisplayed(appointmentsListPage.getClinicColumn()) && checkedWebElementDisplayed(appointmentsListPage.getDoctorColumn()) && checkedWebElementDisplayed(appointmentsListPage.getActionColumn());
        if (flag) {
            String str = appointmentsListPage.getCells().get(0).getText().trim().split("New")[0];
            String getDateTime =time+" "+"pm";
            System.out.println("The time is"+ " "+getDateTime);
            Assert.assertTrue(str.contains(getDateTime));
//           Assert.assertTrue(str.contains(time) && str.contains(dateMonth));
//            Assert.assertEquals(str, getDateTime);
        } else {
            Assert.fail();
        }
    }

    public static void chiefComplaint(String complaint) {
        BaseClass.waitForPageLoad();
        String chiefComplaint = appointmentsListPage.getCells().get(1).getText().trim();
        Assert.assertEquals(chiefComplaint, complaint);
    }

    public static void appointmentType(String appointment_type) {
        BaseClass.waitForPageLoad();
        String appointmentType = appointmentsListPage.getCells().get(3).getText().trim();
        Assert.assertEquals(appointmentType, appointmentType);
    }

    public static void type(String appointment_type) {
        BaseClass.waitForPageLoad();
        String appointmentType = appointmentsListPage.getCells().get(3).getText().trim();
        Assert.assertEquals(appointmentType, appointmentType);
    }
    
    public static void clinicName(String clinic) {
        BaseClass.waitForPageLoad();
        String clnName = appointmentsListPage.getClinicName().getText().trim();
        Assert.assertEquals(clnName, clinic);
    }


//    public static void appointmentsListPage.getClinicName()(String clinic) {
//        BaseClass.waitForPageLoad();
//        String doctor = appointmentsListPage.getCells().get(5).getText().trim();
//        Assert.assertEquals(appointmentsListPage.getClinicName(), clinic);
//    }
    
    public static void doctorName(String doctor) {
        BaseClass.waitForPageLoad();
        String drName = appointmentsListPage.getDoctorName().getText().trim();
        Assert.assertEquals(drName, doctor);
    }

//    public static void doctorName(String doctor) {
//        BaseClass.waitForPageLoad();
//        String doctorName = appointmentsListPage.getCells().get(4).getText().trim();
//        Assert.assertEquals(appointmentsListPage.getDoctorName(), doctor);
//    }

    public static void checkViewBtn() {
        BaseClass.waitForPageLoad();
        WebElement web = appointmentsListPage.getCells().get(6).findElement(By.xpath("//span[@class='actn-icn view']"));
        Assert.assertTrue(checkedWebElementDisplayed(web));
    }
    

    public static void openViewModal() {
//        BaseClass.waitForPageLoad();
    	BaseClass.waitForSpinnerToDisappear();
        WebElement web = appointmentsListPage.getCells().get(6).findElement(By.xpath("//span[@class='actn-icn view']"));
        web.click();
//        BaseClass.switchToFrame(viewFrame);
    }

    public static void checkEditBtn() {
        BaseClass.waitForPageLoad();
        WebElement web = appointmentsListPage.getCells().get(6).findElement(By.xpath("//span[@class='actn-icn edit']"));
        Assert.assertTrue(checkedWebElementDisplayed(web));
    }

    public static void checkDeleteBtn() {
        BaseClass.waitForPageLoad();
        WebElement web = appointmentsListPage.getCells().get(6).findElement(By.xpath("//span[@class='actn-icn delete']"));
        Assert.assertTrue(checkedWebElementDisplayed(web));
    }

    public static void openCovidForm() {
        BaseClass.waitForPageLoad();
        BaseClass.waitForElementToBeClickable(appointmentsListPage.getCovidStatus());
        appointmentsListPage.getCovidStatus().click();
    }

    /*checking Appointment added successfully for the patient*/
    public static void appointmentAdded() {
        BaseClass.waitForPageLoad();
        if (appointmentsListPage.getAppointmentsPatient().size() > 0) {
            BaseClass.visibilityOfListLocated(appointmentsListPage.getDates());
            for (int i = 0; appointmentsListPage.getDates().size() > i; i++) {
                String appdate = appointmentsListPage.getDates().get(i).getText().trim();
                String[] str = appdate.split(" ");
                String appDate = str[0];
                SimpleDateFormat simple = new SimpleDateFormat("dd-MM-yy");
                Date date = new Date();
                String todayDate = simple.format(date);
                boolean flag;
                if (flag = appDate.equals(todayDate)) {
                    Assert.assertTrue(flag);
                } else {
                    continue;
                }
            }
        } else {
            Reporter.log("No Record Found!", true);
        }
    }

    public static void checkFeedbackBtn(String todayDate) {
        BaseClass.waitForPageLoad();
        BaseClass.waitForSpinnerToDisappear();
        BaseClass.visibilityOfListLocated(appointmentsListPage.getAppointmentsPatient());
//        BaseClass.waitForElementToBeClickable(appointmentsListPage.getDashBoardBtn());
        Assert.assertTrue(driver.findElement(By.xpath("//td//span[contains(text(),'"+todayDate+"')]//../following-sibling::td//div//span[@class='actn-icn feedback']/..")).isDisplayed());
    }

    public static void clickOnFeedbackBtn(String todayDate) {
       BaseClass.waitForSpinnerToDisappear();
       BaseClass.visibilityOfListLocated(appointmentsListPage.getAppointmentsPatient());
       BaseClass.waitForElementToBeClickable(appointmentsListPage.getDashBoardBtn());
       WebElement feedbackButton=driver.findElement(By.xpath("//td//span[contains(text(),'"+todayDate+"')]//../following-sibling::td//div//span[@class='actn-icn feedback']/.."));
//       BaseClass.waitForElementToBeClickable(feedbackButton);
       feedbackButton.click();
       BaseClass.waitForSpinnerToDisappear();
    }

    /*checked there are any Appointment available for the patient within 24 hr or not*/
    public static void appointmentAvailable() {
        BaseClass.waitForPageLoad();
        boolean flag = false;
        final long MILLIS_PER_DAY = 24 * 60 * 60 * 1000L;
        if (appointmentsListPage.getAppointmentsPatient().size() > 0) {
            BaseClass.visibilityOfListLocated(appointmentsListPage.getDates());
            for (int i = 0; appointmentsListPage.getDates().size() > i; i++) {
                String appdate = appointmentsListPage.getDates().get(i).getText().trim();
                SimpleDateFormat simple = new SimpleDateFormat("dd-MM-yy");
                Date date = new Date();
                Date appointmentDate = null;
                try {
                    appointmentDate = simple.parse(appdate);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
              
                if (flag = Math.abs(date.getTime() - appointmentDate.getTime()) < MILLIS_PER_DAY) {
                    Assert.assertFalse(flag);
                } else {
                    Reporter.log("Appointment not available in 24 hr", true);
                }
            }
        } else {
            Reporter.log("There are no Appointment.", true);
        }
    }

    private static boolean checkedWebElementDisplayed(WebElement webElement) {
        return (webElement.isDisplayed());
    }
}
