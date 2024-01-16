package pageActions.doctorDashboard;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.apache.commons.lang3.time.DateUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import base.BaseClass;
import pages.doctorDashboard.AppointmentsLisitngPage;
import pages.doctorDashboard.EventListingPage;
import pages.doctorDashboard.Login;

public class EventListingPageActions extends BaseClass {

	static EventListingPage eventListingpage = PageFactory.initElements(driver, EventListingPage.class);
	static AppointmentsLisitngPage clinicAppointmentsPage = PageFactory.initElements(driver, AppointmentsLisitngPage.class);

    public static void selectFrmdateInEvent(String SelectDate) {
        String fromDateElementId ="fromDate";
        BaseClass.WaitTillElementIsPresent(eventListingpage.getEventFromDate());
        BaseClass.waitForSpinnerToDisappear();
        BaseClass.appointmentDate(SelectDate, eventListingpage.getEventFromDate(), fromDateElementId );
    }

    public static void selectTodateInEvent(String SelectDate) {
        String toDateElementId ="toDate";
        BaseClass.WaitTillElementIsPresent(eventListingpage.getEventToDate());
        BaseClass.waitForSpinnerToDisappear();
        BaseClass.appointmentDate(SelectDate, eventListingpage.getEventToDate(), toDateElementId );
    }

    public static void selectType(String eventType) {
    	BaseClass.waitForElementToBeClickable(eventListingpage.getSelectEventType());
    	BaseClass.selectFromDropDownByVisibleText(eventListingpage.getSelectEventType(), eventType);
    }

    public static void verifyOptionInEventTypeFilter() {
        BaseClass.waitForElementToBeClickable(eventListingpage.getSelectEventType());
        Select eventTypeOption = new Select(eventListingpage.getSelectEventType());
        List<WebElement> eventTypeList = eventTypeOption.getOptions();
        for (WebElement eventType : eventTypeList) {
            if (eventType.getText().equals("Select Type") || eventType.getText().equals("By Doctor") || eventType.getText().equals("By Operatory")
                    || eventType.getText().equals("By Room") || eventType.getText().equals("By Scanner")) {
            } else {
                Assert.assertTrue(false);
                break;
            }
        }

    }
    public static void selectCategroy(String categoryName) {
        BaseClass.waitForElementToBeClickable(eventListingpage.getSelEventCat());
        BaseClass.selectFromDropDownByVisibleText(eventListingpage.getSelEventCat(), categoryName);
    }

    public static void clickOnSearch() {
        BaseClass.waitForElementToBeClickable(eventListingpage.getSearchBtnOnEvent());
        eventListingpage.getSearchBtnOnEvent().click();
        BaseClass.waitForSpinnerToDisappear();
    }

    public static void clickOnEventBtn() {
        BaseClass.waitForElementToBeClickable(eventListingpage.getEventBtn());
        BaseClass.waitForSpinnerToDisappear();
        eventListingpage.getEventBtn().click();
        BaseClass.waitForPageLoad();
        BaseClass.waitForSpinnerToDisappear();
    }

    public static void clickOnAddEventBtnOnEventListing() {
        BaseClass.waitForElementToBeClickable(eventListingpage.getAddEventBtnOnEvent());
        BaseClass.executeScript(eventListingpage.getAddEventBtnOnEvent());
        BaseClass.waitForPageLoad();
    }

    public static void clickonResetBtn() {
        BaseClass.waitForElementToBeClickable(eventListingpage.getResetBtnOnEvent());
        eventListingpage.getResetBtnOnEvent().click ();
//		BaseClass.executeScript(eventListingpage.getResetBtnOnEvent());
        BaseClass.waitForPageLoad();
    }

    public static void selectDoctor(String doctor) {
        BaseClass.waitForPageLoad();
        BaseClass.waitForSpinnerToDisappear();
        WebElement ele=driver.findElement(By.xpath("//span[@class='glyphicon glyphicon-chevron-down customComboBtn cursor-pointer']"));
        ele.click();
        WebElement element=driver.findElement(By.xpath("//ul[@class='menu fnt_cali']/li[contains(text(),'"+doctor+"')]"));
        BaseClass.waitForElementToBeClickable(element);
        element.click();
        BaseClass.waitForPageLoad();
        BaseClass.waitForSpinnerToDisappear();
    }

    public static void verifyTitleDisplayOnEventlist(String titleOnEvent) {
        BaseClass.waitForPageLoad();
        WebElement title = driver.findElement(By.xpath("//td[contains(text(),'"+titleOnEvent+"')]"));
        BaseClass.WaitTillElementIsPresent(title);
        boolean flag = title.isDisplayed();
        if (flag) {
            Assert.assertTrue(title.getText().trim().contains(titleOnEvent));
        } else {
            Assert.assertTrue(flag);
        }
    }

    /*
     * New method added
     */
    public static void verifyDateTimeDisplayOnEventList(String eventTitle,String expectedDateTimeOnEventListing ) {
        BaseClass.waitForPageLoad();
        BaseClass.waitForSpinnerToDisappear();
        String actualDateTimeOfEvent =driver.findElement(By.xpath("//tr[@data-ng-repeat='record in eventListData']//td[contains(normalize-space(),'"+eventTitle+"')]/preceding-sibling::td[2]")).getText ().trim ();
        System.out.println("Actual Date "+actualDateTimeOfEvent);
        System.out.println("Expected Date "+expectedDateTimeOnEventListing);
        Assert.assertTrue (actualDateTimeOfEvent.equals ( expectedDateTimeOnEventListing ));

    }

    public static void verifyDurationDisplayOnEventList(String eventTitle,String expectedDurationOfEvent) {
        BaseClass.waitForPageLoad();
        BaseClass.waitForSpinnerToDisappear();
        String actualDurationOfEvent =driver.findElement(By.xpath("//tr[@data-ng-repeat='record in eventListData']//td[contains(normalize-space(),'"+eventTitle+"')]/preceding-sibling::td[1]")).getText ().trim ();
        Assert.assertTrue (actualDurationOfEvent.contains ( expectedDurationOfEvent ));

    }

    public static void verifyEventTypeDisplayOnEventList(String eventTitle,String expectedEventType ) {
        BaseClass.waitForPageLoad();
        String actualTypeOfEvent=driver.findElement(By.xpath("//tr[@data-ng-repeat='record in eventListData']//td[contains(normalize-space(),'"+eventTitle+"')]/following-sibling::td[1]")).getText ().trim ();
        Assert.assertTrue (actualTypeOfEvent.equalsIgnoreCase ( expectedEventType ));
    }

    public static void verifyCategoryDisplayOnEventList(String eventTitle,String expectedCategoryOfEvent ) {
        BaseClass.waitForPageLoad();
        String actualCategoryOfEvent =driver.findElement(By.xpath("//tr[@data-ng-repeat='record in eventListData']//td[contains(normalize-space(),'"+eventTitle+"')]/following-sibling::td[2]")).getText ().trim ();
        Assert.assertTrue ( actualCategoryOfEvent.equals ( expectedCategoryOfEvent ) );

    }




    public static void verifyDoctorDisplayOnEventList(String eventTitle,String expectedEventDoctor ) {
        BaseClass.waitForPageLoad();
        String actualEventDoctor =driver.findElement(By.xpath("//tr[@data-ng-repeat='record in eventListData']//td[contains(normalize-space(),'"+eventTitle+"')]/following-sibling::td[3]")).getText ();
        Assert.assertTrue (actualEventDoctor.equalsIgnoreCase ( expectedEventDoctor ));
    }

    public static void verifyClinicDisplayOnEventList( String eventTitle, String expectedEventClinic ) {
        BaseClass.waitForPageLoad();
        String actualEventClinic=driver.findElement(By.xpath("//tr[@data-ng-repeat='record in eventListData']//td[contains(normalize-space(),'"+ eventTitle +"')]/following-sibling::td[4]")).getText ().trim ();
        Assert.assertTrue (actualEventClinic.equals ( expectedEventClinic ));
    }

    public static void verifyNotesDisplayOnEventList(String eventTitle,String expectedEventNotes) {
        BaseClass.waitForPageLoad();
        String actualEventNotes=driver.findElement(By.xpath("//tr[@data-ng-repeat='record in eventListData'][@class='ng-scope']//td[contains(normalize-space(),'"+eventTitle+"')]/following-sibling::td[5]")).getText ().trim ();
        Assert.assertTrue (actualEventNotes.contains ( expectedEventNotes ));
    }

    public static void verifyAllMandatoryWebElement() {
        BaseClass.waitForPageLoad();
        boolean isAllMandatoryFieldDisplayed = eventListingpage.getEventFromDate().isDisplayed() && eventListingpage.getEventToDate().isDisplayed() && eventListingpage.getSelectEventType().isDisplayed()
                && eventListingpage.getSelEventCat().isDisplayed() && eventListingpage.getSearchBtnOnEvent().isDisplayed() && eventListingpage.getResetBtnOnEvent().isDisplayed()
                && clinicAppointmentsPage.docDropDoownBtn.isDisplayed() && eventListingpage.getAddEventBtnOnEvent().isDisplayed();
        Assert.assertTrue ( isAllMandatoryFieldDisplayed );
    }

    public static void verifyEditAndDeletBtn(String eventTitle) {
        BaseClass.waitForPageLoad();
        BaseClass.waitForSpinnerToDisappear();
        WebElement editBtn=driver.findElement(By.xpath("//td[normalize-space()='" + eventTitle + "']/following-sibling::td//span[@class='actn-icn edit']"));
        WebElement deleteBtn=driver.findElement(By.xpath("//td[normalize-space()='" + eventTitle + "']/following-sibling::td//span[@class='actn-icn delete']"));
        BaseClass.WaitTillElementIsPresent(deleteBtn);
        boolean isEditAndDeleteBtnDisplayed=editBtn.isDisplayed() && deleteBtn.isDisplayed();
        Assert.assertTrue ( isEditAndDeleteBtnDisplayed );
    }

    public static void clickOnEditBtn ( String eventTitle) {
        BaseClass.waitForSpinnerToDisappear();
        WebElement editBtn=driver.findElement(By.xpath("//td[normalize-space()='"+ eventTitle + "']/following-sibling::td//span[@class='actn-icn edit']"));
        BaseClass.waitForElementToBeClickable(editBtn);
        editBtn.click();
        BaseClass.waitForPageLoad();
        BaseClass.waitForSpinnerToDisappear();
    }

    public static void clickOnDeleteBtn(String eventTitle) {
        WebElement deleteBtn=driver.findElement(By.xpath("//td[normalize-space()='" + eventTitle + "']/following-sibling::td//span[@class='actn-icn delete']"));
        BaseClass.waitForElementToBeClickable(deleteBtn);
        deleteBtn.click();
    }

    public static void clickOnNoBtnDeletePopUp(String eventTitle) {
    	BaseClass.waitForElementToBeClickable(eventListingpage.getCancelBtnDelete());
        eventListingpage.getCancelBtnDelete().click();
        try {
        Thread.sleep(2000);
        } catch (InterruptedException e) {
        	e.printStackTrace();
        }
    }

    public static void clickOnYesBtnDeletePopUp() {
        BaseClass.waitForElementToBeClickable(eventListingpage.getYesBtnDelete());
        eventListingpage.getYesBtnDelete().click();
    }

    public static void verifyAfterDelete(String eventTitle) {
        BaseClass.waitForPageLoad();
        BaseClass.waitForSpinnerToDisappear();
        WebElement title = driver.findElement(By.xpath("//td[normalize-space()='"+eventTitle+"']/parent::tr"));
        BaseClass.WaitTillElementIsPresent(title);
        boolean isDeletedRecordStrikeOff = title.getAttribute("class").contains("deleted");
        Assert.assertTrue ( isDeletedRecordStrikeOff );
    }

	public static void dateFilter(String frmDate, String toDate) {
		SimpleDateFormat dt = new SimpleDateFormat("MM/dd/yy");
		try {
			Date Date1 = dt.parse(frmDate);
			Date Date2 = dt.parse(toDate);
			BaseClass.waitForPageLoad();
			BaseClass.waitForSpinnerToDisappear();

			List<WebElement> pageNumbers = driver.findElements(By.xpath(
					"//div[contains(@class,'topPagination')][1]//pagination2[@data-page-no='eventCurrentPageNo']/following-sibling::div/a[contains(@class,'pageNo')]"));
			if (pageNumbers.size() > 0) {
				int lastPageNumber = Integer.valueOf(pageNumbers.get(pageNumbers.size() - 1).getText());
				int currentPage = 1;
				while (currentPage <= lastPageNumber) {
					for (int i = 0; i < eventListingpage.getTimeSlotApp().size(); i++) {
						boolean flag;
						if (flag = eventListingpage.getTimeSlotApp().get(i).isDisplayed()) {
							String eventTime = eventListingpage.getTimeSlotApp().get(i).getText();
							SimpleDateFormat dt1 = new SimpleDateFormat("dd-MM-yy");
							Date eventDate = dt1.parse(eventTime);
							boolean samedate = DateUtils.isSameDay(Date1, eventDate)
									|| DateUtils.isSameDay(Date2, eventDate);
							boolean counter = eventDate.before(Date2) && eventDate.after(Date1);
							if (counter || samedate) {
							} else {
								Assert.assertTrue(counter);
							}
						} else {
							Assert.assertTrue(flag);
						}
					}
					eventListingpage.getNextBtn().click();
					BaseClass.waitForPageLoad();
					currentPage++;
				}
			} 
			else {
				Assert.assertTrue(eventListingpage.getNoRecordFoundMsg().isDisplayed());
			}
		} 
		catch (ParseException e) {
			e.printStackTrace();
		}
	}

    public static void checkFrmDateIsNotLaterToToDate() {
        BaseClass.waitForElementToBeClickable(eventListingpage.getMsgFrmDateLater());
        Assert.assertTrue(eventListingpage.getMsgFrmDateLater().isDisplayed());
        Assert.assertTrue(eventListingpage.getMsgFrmDateLater().getText().contains("From date cannot be greater than to date!"));
    }

    public static void verifyFilterDoctorInEventList(String doctorNickName) {
        BaseClass.waitForPageLoad();
        BaseClass.waitForSpinnerToDisappear();
        List<WebElement> pageNumbers=driver.findElements(By.xpath("//div[contains(@class,'topPagination')][1]//pagination2[@data-page-no='eventCurrentPageNo']/following-sibling::div/a[contains(@class,'pageNo')]"));
        int lastPageNumber=Integer.valueOf(pageNumbers.get(pageNumbers.size()-1).getText());
        int currentPage=1;
        while (currentPage<=lastPageNumber) {
            BaseClass.waitForPageLoad();
            BaseClass.waitForElementToBeClickable(eventListingpage.getNextBtn());
            List<WebElement> allDoctor = driver
                    .findElements(By.xpath("//table[@id='eventListing']/tbody/tr/td[6]"));
            int allDoctorSize = allDoctor.size();
            List<WebElement> filterDoctor = driver.findElements(By.xpath(
                    "//table[@id='eventListing']/tbody/tr/td[normalize-space()='"+doctorNickName+"']"));
            List<WebElement> allDoctorFilter = driver.findElements(
                    By.xpath("//table[@id='eventListing']/tbody/tr/td[normalize-space()='All Doctors']"));
            int total = filterDoctor.size() + allDoctorFilter.size();
            boolean flag = (allDoctorSize == total);
            if (flag) {
                BaseClass.waitForElementToBeClickable(eventListingpage.getNextBtn());
                eventListingpage.getNextBtn().click();
            } else {
                Assert.assertTrue(flag);
            }
            currentPage++;

        }
    }

    public static void verifyFilterEventTypeInEventList(String eventType) {
        BaseClass.waitForPageLoad();
        List<WebElement> pageNumbers = driver.findElements(By.xpath(
                "//div[contains(@class,'topPagination')][1]//pagination2[@data-page-no='eventCurrentPageNo']/following-sibling::div/a[contains(@class,'pageNo')]"));
        int lastPageNumber = Integer.valueOf(pageNumbers.get(pageNumbers.size() - 1).getText());
        int currentPage = 1;
        while (currentPage <= lastPageNumber) {
            BaseClass.waitForPageLoad();
            List<WebElement> eventTypeList = driver.findElements(By.xpath("//table[@id='eventListing']/tbody/tr/td[4]"));
            for (WebElement type : eventTypeList) {
                Assert.assertTrue ( type.getText().equals(eventType) );

            }
            BaseClass.waitForElementToBeClickable(eventListingpage.getNextBtn());
            eventListingpage.getNextBtn().click();
            currentPage++;

        }


    }
    public static void verifyFilterCategoryInEventList(String filterCategory) {
        BaseClass.waitForPageLoad();
        List<WebElement> pageNumbers=driver.findElements(By.xpath("//div[contains(@class,'topPagination')][1]//pagination2[@data-page-no='eventCurrentPageNo']/following-sibling::div/a[contains(@class,'pageNo')]"));
        int lastPageNumber=Integer.valueOf(pageNumbers.get(pageNumbers.size()-1).getText());
        int currentPage=1;
        while (currentPage<=lastPageNumber) {
            BaseClass.waitForPageLoad();
            List<WebElement> eventCategoryList=driver.findElements(By.xpath("//table[@id='eventListing']/tbody/tr/td[5]"));
            for(WebElement eventCategory:eventCategoryList) {
                Assert.assertTrue (eventCategory.getText().equals(filterCategory));

            }
            BaseClass.waitForElementToBeClickable(eventListingpage.getNextBtn());
            eventListingpage.getNextBtn().click();
            currentPage++;

        }
    }

    public static void verifyResetBtnWorking() {
        BaseClass.waitForPageLoad();
        clickonResetBtn();
        BaseClass.waitForSpinnerToDisappear();
        boolean flag=eventListingpage.getSelectEventType().getText().contains("Select Type") && eventListingpage.getSelEventCat().getText().contains("Select Category");
        boolean isFromDateBlankAfterReset=getSelectedFromDateOnEventListing ().equals ( "" );
        boolean isToDateBlankAfterReset=getSelectedToDateOnEventListing ().equals ( "" );
        boolean isAllFilterValueReset=flag && isFromDateBlankAfterReset && isToDateBlankAfterReset;
        Assert.assertTrue ( isAllFilterValueReset );
    }


    public static String getSelectedFromDateOnEventListing(){
        BaseClass.waitForElementToBeClickable ( eventListingpage.getEventFromDate() );
        JavascriptExecutor javascriptExecutor=(JavascriptExecutor) driver;
        String fromDate=(String)javascriptExecutor.executeScript ( "return document.getElementById('fromDate').value;" );
        return  fromDate;

    }

    public static String getSelectedToDateOnEventListing(){
        BaseClass.waitForElementToBeClickable ( eventListingpage.getEventToDate() );
        JavascriptExecutor javascriptExecutor=(JavascriptExecutor) driver;
        String toDate=(String)javascriptExecutor.executeScript ( "return document.getElementById('toDate').value;" );
        return  toDate;
    }

}
