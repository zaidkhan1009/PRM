package pageActions.patientDashboard;


import base.BaseClass;
import pages.patientDashboard.FileListingPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

public class FileListingPageActions extends BaseClass {
    
	static FileListingPage fileListingPage = PageFactory.initElements(driver, FileListingPage.class);

    
    public static void checkFileAddedDate(String fileName) {
        BaseClass.waitForPageLoad();
        try {
            WebElement addedFileDate = driver.findElement(By.xpath("//span[contains(text(),'" + fileName + "')]/following-sibling::span[@class='pull-right']"));
            Date date1 = new SimpleDateFormat("dd-MM-yy").parse(addedFileDate.getText());
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(String.valueOf(LocalDate.now()));
            Assert.assertTrue(date.equals(date1));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    
    public static void verifyPatientName(String Name) {
        BaseClass.waitForPageLoad();
        BaseClass.waitForElementToBeClickable(fileListingPage.getPatientName());
        String str = fileListingPage.getPatientName().getText();
        String str1 = fileListingPage.getPatientId().getText();
        boolean flag = str.contains(Name) && !(str1.equals("NA") || str1.equals("Null"));
        Assert.assertTrue(flag);
    }

    public static void multipleFilesRenameAddedDate(String fileName, int totalFile) {
        BaseClass.waitForPageLoad();
        List<WebElement> addedFileDate = driver.findElements(By.xpath("//span[contains(text(),'" + fileName + "')]/following-sibling::span[@class='pull-right']"));
        Assert.assertTrue(addedFileDate.size() == totalFile);
    }

    public static void checkedFileEditBtn(String fileName) {
        BaseClass.waitForPageLoad();
        WebElement web = driver.findElement(By.xpath("//span[contains(text(),'" + fileName + "')]/../../preceding-sibling::div/a[contains(@class,'editFileButton')]"));
        Assert.assertTrue(checkElementDisplayed(web) && web.getText().contains("Edit"));
    }

    public static void checkedFileVisibleToPatientIcon(String fileName) {
        BaseClass.waitForPageLoad();
        WebElement web = driver.findElement(By.xpath("//span[contains(text(),'"+fileName+"')]/following-sibling::span[@class='pull-right']/span[@id='fileIcon']"));
        Assert.assertTrue(checkElementDisplayed(web));
    }
    
    public static void multipleFilesRenameEditBtn(String fileName, int totalFile) {
        BaseClass.waitForPageLoad();
        List<WebElement> web = driver.findElements(By.xpath("//span[contains(text(),'" + fileName + "')]/../../preceding-sibling::div/a[contains(@class,'editFileButton')]"));
        Assert.assertTrue(web.size() == totalFile);
    }

    public static void clickFileEditBtn(String fileName) {
        BaseClass.waitForPageLoad();
        try {
            driver.findElement(By.xpath("//span[contains(text(),'" + fileName + "')]/../../preceding-sibling::div/a[contains(@class,'editFileButton')]")).click();
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void checkedFileDownloadBtn(String fileName) {
        BaseClass.waitForPageLoad();
        WebElement web = driver.findElement(By.xpath("//span[contains(text(),'" + fileName + "')]/../../preceding-sibling::div/a[contains(@class,'downloadFileButton')]"));
        Assert.assertTrue(checkElementDisplayed(web) && web.getText().contains("Download"));
    }

    public static void multipleFilesRenameDownloadBtn(String fileName, int totalFile) {
        BaseClass.waitForPageLoad();
        List<WebElement> web = driver.findElements(By.xpath("//span[contains(text(),'" + fileName + "')]/../../preceding-sibling::div/a[contains(@class,'downloadFileButton')]"));
        Assert.assertTrue(web.size() == totalFile);
    }

    public static void clickFileDownloadBtn(String fileName) {
        BaseClass.waitForPageLoad();
        driver.findElement(By.xpath("//span[contains(text(),'" + fileName + "')]/../../following-sibling::div/a[@class='downloadFileButton']")).click();
    }

    public static void checkedFileDeleteBtn(String fileName) {
        BaseClass.waitForPageLoad();
        WebElement web = driver.findElement(By.xpath("//span[contains(text(),'"+fileName+"')]/../../preceding-sibling::div/a[contains(@class,'deleteFileListButton')]"));
        Assert.assertTrue(checkElementDisplayed(web) && web.getText().contains("Delete"));
    }

    public static void multipleFilesRenameDeleteBtn(String fileName, int totalFile) {
        BaseClass.waitForPageLoad();
        List<WebElement> web = driver.findElements(By.xpath("//span[contains(text(),'" + fileName + "')]/../../preceding-sibling::div/a[contains(@class,'deleteFileListButton')]"));
        Assert.assertTrue(web.size() == totalFile);
    }

    public static void clickFileDeleteBtn(String fileName) {
        BaseClass.waitForPageLoad();
        driver.findElement(By.xpath("//span[contains(text(),'" + fileName + "')]/../../following-sibling::div/a[@class='deleteFileListButton deleteConfirm']")).click();
    }

    public static void clickPastDocsTab() {
        BaseClass.waitForPageLoad();
        fileListingPage.getPastDocsTab().click();
        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void clickXRayTab() {
        BaseClass.waitForPageLoad();
        fileListingPage.getxRaysTab().click();
        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void clickProfileTab() {
        BaseClass.waitForPageLoad();
        fileListingPage.getProfileTab().click();
        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void oralExamTabSelected() {
        BaseClass.waitForPageLoad();
        Assert.assertTrue(checkElementDisplayed(fileListingPage.getOralImagesTab()) && fileListingPage.getOralImagesTab().getAttribute("class").contains("selectedTab"));
    }

    public static void oralExamTabNotSelected() {
        BaseClass.waitForPageLoad();
        Assert.assertTrue(checkElementDisplayed(fileListingPage.getOralImagesTab()) && !fileListingPage.getOralImagesTab().getAttribute("class").contains("selectedTab"));
    }

    public static void pastDocsTabSelected() {
        BaseClass.waitForPageLoad();
        Assert.assertTrue(checkElementDisplayed(fileListingPage.getPastDocsTab()) && fileListingPage.getPastDocsTab().getAttribute("class").contains("selectedTab"));
    }

    public static void pastDocsTabNotSelected() {
        BaseClass.waitForPageLoad();
        Assert.assertTrue(checkElementDisplayed(fileListingPage.getPastDocsTab()) && !fileListingPage.getPastDocsTab().getAttribute("class").contains("selectedTab"));
    }

    public static void xRaysTabSelected() {
        BaseClass.waitForPageLoad();
        Assert.assertTrue(checkElementDisplayed(fileListingPage.getxRaysTab()) && fileListingPage.getxRaysTab().getAttribute("class").contains("selectedTab"));
    }

    public static void xRaysTabNotSelected() {
        BaseClass.waitForPageLoad();
        Assert.assertTrue(checkElementDisplayed(fileListingPage.getxRaysTab()) && !fileListingPage.getxRaysTab().getAttribute("class").contains("selectedTab"));
    }

    public static void profileTabSelected() {
        BaseClass.waitForPageLoad();
        Assert.assertTrue(checkElementDisplayed(fileListingPage.getProfileTab()) && fileListingPage.getProfileTab().getAttribute("class").contains("selectedTab"));
    }

    public static void profileTabNotSelected() {
        BaseClass.waitForPageLoad();
        Assert.assertTrue(checkElementDisplayed(fileListingPage.getProfileTab()) && !fileListingPage.getProfileTab().getAttribute("class").contains("selectedTab"));
    }

    public static void noRecordMessageDisplayed() {
        BaseClass.waitForPageLoad();
        Assert.assertTrue(checkElementDisplayed(fileListingPage.getNoRecordfound()));
    }

    public static void fileDateFilter() {
        BaseClass.waitForPageLoad();
        boolean flag1, flag2, match = false;
        flag1 = checkElementDisplayed(fileListingPage.getFileDateFilter());
        String[] exp = {"All Dates"};
        Select select = new Select(fileListingPage.getFileDateFilter());
        List<WebElement> options = select.getOptions();
        for (WebElement we : options) {
            for (int i = 0; i < exp.length; i++) {
                if (flag2 = we.getText().equals(exp[i])) {
                    match = flag1 && flag2;
                }
            }
            Assert.assertTrue(match);
        }
    }

    public static void checkedFileAddedDateInDropdown() {
        BaseClass.waitForPageLoad();
        Select select = new Select(fileListingPage.getFileDateFilter());
        List<WebElement> options = select.getOptions();
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yy");
        String formattedString = localDate.format(formatter);
        boolean flag = false;
        for (WebElement we : options) {
            if (flag = we.getText().contains(formattedString)) {
            }
        }
        Assert.assertTrue(flag);
    }

    //functions for file list Popup
    public static void openFile(String fileName) {
        BaseClass.waitForPageLoad();
        driver.findElement(By.xpath("//span[contains(text(),'" + fileName + "')]")).click();
    }

    public static void checkHeaderFileListPopup(String fileName) {
        BaseClass.waitForPageLoad();
        Assert.assertTrue(checkElementDisplayed(driver.findElement(By.xpath("//h2[text()='" + fileName + "']"))));
    }

    public static void checkFileAddedDateFileListPopup() {
        BaseClass.waitForPageLoad();
        try {
            WebElement addedFileDate = driver.findElement(By.xpath("//div[@class='dateUpdated clearfix']"));
            Date date1 = new SimpleDateFormat("dd-MM-yy").parse(addedFileDate.getText());
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(String.valueOf(LocalDate.now()));
            Assert.assertTrue(date.equals(date1));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public static void notesFileListPopup(String notes) {
        BaseClass.waitForPageLoad();
        Assert.assertTrue(fileListingPage.getNotesFileListPopup().getText().contains(notes));
    }

    public static void actionsBtnFileListPopup() {
        BaseClass.waitForPageLoad();
        Assert.assertTrue(checkElementDisplayed(fileListingPage.getCloseBtnFileListPopup()) && checkElementDisplayed(fileListingPage.getZoomInOutFileListPopup()) && checkElementDisplayed(fileListingPage.getDownloadBtnFileListPopup()));
    }

    public static void closeFileListPopup() {
        BaseClass.waitForPageLoad();
        BaseClass.hoverOnElement(fileListingPage.getCloseBtnFileListPopup());
        fileListingPage.getCloseBtnFileListPopup().click();
    }

    public static void deletedFileListing(String fileName) {
    	BaseClass.waitForPageLoad();
    	List < WebElement > web = driver.findElements(By.xpath("//span[contains(@class,'strikeOff') and contains(text(),'"+fileName+"')]"));
    	for(int i=0;web.size()>i;i++) {
    		Assert.assertTrue(web.get(i).getAttribute("class").contains("strikeOff"));
    	}
    }

    public static void deletePopupWebElement() {
        BaseClass.waitForPageLoad();
        Assert.assertTrue(checkElementDisplayed(fileListingPage.getMsgDeletePopup()) && checkElementDisplayed(fileListingPage.getYesBtnDeletePopup()) && checkElementDisplayed(fileListingPage.getNoBtnDeletePopup()));
    }
    public static void clickNoButton(){
        BaseClass.waitForPageLoad();
        BaseClass.hoverOnElement(fileListingPage.getNoBtnDeletePopup());
        fileListingPage.getNoBtnDeletePopup().click();
    }
    public static void clickYesButton(){
        BaseClass.waitForPageLoad();
        try {
            BaseClass.hoverOnElement(fileListingPage.getYesBtnDeletePopup());
            fileListingPage.getYesBtnDeletePopup().click();
            Thread.sleep(3500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    private static Boolean checkElementDisplayed(WebElement webElement) {
        return (webElement.isDisplayed());
    }
}