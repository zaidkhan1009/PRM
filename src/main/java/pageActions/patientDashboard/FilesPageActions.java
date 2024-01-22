package pageActions.patientDashboard;

import base.BaseClass;
import pages.patientDashboard.FilesPage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import java.awt.*;
import java.util.List;

public class FilesPageActions extends BaseClass {
   
	static FilesPage filesPage = PageFactory.initElements(driver, FilesPage.class);

	
	public static void enterTitleFile(String title){
        BaseClass.waitForPageLoad();
        filesPage.getFileNameTextFields().clear();
        filesPage.getFileNameTextFields().sendKeys(title);
    }
    public static void errorMsgFileNotSelected(){
        BaseClass.waitForPageLoad();
        try {
            Thread.sleep(1000);
            Assert.assertTrue(filesPage.getFileNotSelectedErrorMsg().getText().contains("Please select a file to upload!"));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void selectCategory(String categoryDropdownValue){
        BaseClass.waitForPageLoad();
        BaseClass.selectFromDropDownByVisibleText(filesPage.getCategoryDropdown(),categoryDropdownValue);
    }
    public static void clickSaveBtn(){
        BaseClass.waitForPageLoad();
        try {
            filesPage.getSaveBtn().click();
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void clickResetBtn(){
        BaseClass.waitForPageLoad();
        filesPage.getResetBtn().click();
    }
    public static void clickCancelBtn(){
        BaseClass.waitForPageLoad();
        filesPage.getCancelBtn().click();
    }

    public static void checkedErrorCategory(String errorMsg){
        BaseClass.waitForPageLoad();
        Assert.assertTrue(filesPage.getErrorCategoryMsg().getText().contains(errorMsg));
    }
    public static void checkedErrorTitle(String errorMsg){
        BaseClass.waitForPageLoad();
        Assert.assertTrue(filesPage.getErrorFileTitle().getText().contains(errorMsg));
    }
    public static void verifyPatientName(String patientName) {
        BaseClass.waitForPageLoad();
        BaseClass.waitForElementToBeClickable(filesPage.getPatietName());
        String str = filesPage.getPatietName().getText();
        String[] split = str.split(" : ");
        boolean flag = split[0].contains(patientName) && !(split[1].equals("NA") || split[1].equals("Null"));
        Assert.assertTrue(flag);
    }
    public static void headerPage(String header){
        BaseClass.waitForPageLoad();
        Assert.assertTrue(filesPage.getHeaderPage().getText().contains(header));
    }
    public static void categoryDropDownWebelemet(){
        BaseClass.waitForPageLoad();
        boolean flag1,flag2,match = false;
        flag1=checkElementDisplayed(filesPage.getCategoryDopdownHeader())&&checkElementDisplayed(filesPage.getCategoryDropdown());
        String[] exp = {"Select Category","Oral Images","Past Docs","X-Rays","Profile"};
        Select select = new Select(filesPage.getCategoryDropdown());
        List<WebElement> options = select.getOptions();
        for(WebElement we:options)
        {
            for (int i=0; i<exp.length; i++){
                if (flag2=we.getText().equals(exp[i])){
                    match = flag1&&flag2;
                }
            }
            Assert.assertTrue(match);
        }
    }

    public static void fileTitleWebElementCheckBoxNotSelected(){
        BaseClass.waitForPageLoad();
        Assert.assertTrue(checkElementDisplayed(filesPage.getFileNameCheckbox())&&checkElementDisplayed(filesPage.getFileNameHeader())&&filesPage.getFileNameTextFields().getAttribute("class").contains("disabled"));
    }
    public static void fileTitleWebElementCheckBoxSelected(){
        BaseClass.waitForPageLoad();
        Assert.assertTrue(checkElementDisplayed(filesPage.getFileNameCheckbox())&&checkElementDisplayed(filesPage.getFileNameHeader())&&!filesPage.getFileNameTextFields().getAttribute("class").contains("disabled"));
    }
    public static void notesWebElement(){
        BaseClass.waitForPageLoad();
        Assert.assertTrue(checkElementDisplayed(filesPage.getNotesHeader())&&checkElementDisplayed(filesPage.getNotesCharactersLimitMsg())&&checkElementDisplayed(filesPage.getNotesTextField())&&filesPage.getNotesTextField().getAttribute("maxlength").contains("768"));
    }
    public static void enterNotes(String notes){
        BaseClass.waitForPageLoad();
        filesPage.getNotesTextField().sendKeys(notes);
    }
    public static void fileUploadBtnDisplayed(){
        BaseClass.waitForPageLoad();
        Assert.assertTrue(checkElementDisplayed(filesPage.getUploadFilesBtn())&&checkElementDisplayed(filesPage.getUploadFilesBtnText()));
    }
    public static void singleFileUploadBtn(String path){
        BaseClass.waitForPageLoad();
        BaseClass.WaitTillElementIsPresent(filesPage.getUploadFilesBtn());
      //  filesPage.getUploadFilesBtn().click();
        try {
            filesPage.getUploadFilesBtn().click();
            Thread.sleep(2000);
            BaseClass.uploadFile(path);
            Thread.sleep(2000);
        } catch (AWTException e) {
            e.printStackTrace();
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void uploadMultipleFiles(String path1,String path2){
        BaseClass.waitForPageLoad();
        String path="\""+path1+"\"\""+path2+"\"";
        filesPage.getUploadFilesBtn().click();
        try {
            filesPage.getUploadFilesBtn().click();
            Thread.sleep(2000);
            BaseClass.uploadFile(path);
        } catch (AWTException e) {
            e.printStackTrace();
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void saveBtnDisplayed(){
        BaseClass.waitForPageLoad();
        Assert.assertTrue(checkElementDisplayed(filesPage.getSaveBtn())&&checkElementDisplayed(filesPage.getSaveBtnText()));
    }

    public static void resetBtnDisplayed(){
        BaseClass.waitForPageLoad();
        Assert.assertTrue(checkElementDisplayed(filesPage.getResetBtn())&&checkElementDisplayed(filesPage.getResetBtnText()));
    }
    public static void cancelBtnDisplayed(){
        BaseClass.waitForPageLoad();
        Assert.assertTrue(checkElementDisplayed(filesPage.getCancelBtn())&&checkElementDisplayed(filesPage.getCancelBtntext()));
    }

    public static void checkFileNameCheckbox(){
        BaseClass.waitForPageLoad();
        filesPage.getFileNameCheckbox().click();
        Assert.assertTrue(!filesPage.getFileNameTextFields().getAttribute("class").contains("disabled"));
    }
    public static void checkDeleteBtnFileAddPage(String fileName){
        BaseClass.waitForPageLoad();
        Assert.assertTrue(checkElementDisplayed(driver.findElement(By.xpath("//span[contains(text(),'"+fileName+"')]/following-sibling::span/a[contains(@class,'deleteFilesBtn')]"))));
    }
    
    public static void checkVisibletoPatientFileAddPage(String fileName){
        BaseClass.waitForPageLoad();
        Assert.assertTrue(checkElementDisplayed(driver.findElement(By.xpath("//span[contains(text(),'"+fileName+"')]/following-sibling::span/label[contains(text(),'Patient Visible')]"))));
    }
    
    public static void checkedDeletedFileAddPage(String fileName){
        BaseClass.waitForPageLoad();
        List<WebElement> web = driver.findElements(By.xpath("//span[contains(text(),'" + fileName + "')]/following-sibling::span/a[contains(@class,'deleteFilesBtn')]"));
        Assert.assertTrue(web.size()<1);
    }
    public static void checkedImagefileAddPage(String fileName){
        BaseClass.waitForPageLoad();
        Assert.assertTrue(checkElementDisplayed(driver.findElement(By.xpath("//span[contains(text(),'"+fileName+"')]/preceding-sibling::span/img[@class='obj']"))));
    }
    public static void clickDeleteBtnFileAddPage(String fileName){
        BaseClass.waitForPageLoad();
        driver.findElement(By.xpath("//span[contains(text(),'"+fileName+"')]/following-sibling::span/a[contains(@class,'deleteFilesBtn')]")).click();
    }
    
    public static void clickVisibletoPatientBtnFileAddPage(String fileName){
        BaseClass.waitForPageLoad();
        driver.findElement(By.xpath("//span[contains(text(),'"+fileName+"')]/following-sibling::span/label[contains(text(),'Patient Visible')]/span[@class='checkmark']")).click();
    }
    
    public static void clickVisibletoPatientBtnForEditFileAddPage(String fileName){
        BaseClass.waitForPageLoad();
        driver.findElement(By.xpath("//span[contains(text(),'"+fileName+"')]/following-sibling::span//span[contains(text(),'Patient Visible')]/following-sibling::span")).click();
    }
    
    public static void successfullyMessage(){
        BaseClass.waitForPageLoad();
        try {
            Thread.sleep(2000);
            BaseClass.softAssert().assertTrue(checkElementDisplayed(filesPage.getSuccessMsg()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
            BaseClass.softAssert().assertTrue(checkElementDisplayed(filesPage.getSuccessMsg()));
    }
    public static void getFirstSelectOptions(String category){
        BaseClass.waitForPageLoad();
        Select sel=new Select(filesPage.getCategoryDropdown());
        Assert.assertTrue(sel.getFirstSelectedOption().getText().contains(category));
    }
    public static void getFileName(String expected) {
        BaseClass.waitForPageLoad();
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        Object obj = javascriptExecutor.executeScript("return document.getElementById('form_file_name').value;");
        String actual = (String) obj;
        Assert.assertEquals(actual, expected);
    }
    public static void getFileNotes(String expected) {
        BaseClass.waitForPageLoad();
        BaseClass.waitForElementToBeClickable(filesPage.getNotesTextField());
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        Object obj = javascriptExecutor.executeScript("return document.getElementById('form_file_notes').value;");
        String actual = (String) obj;
        Assert.assertEquals(actual, expected);
    }
    public static void editCheckDeleteBtnFileAddPage(String fileName){
       BaseClass.waitForPageLoad();
       Assert.assertTrue(checkElementDisplayed(driver.findElement(By.xpath("//span[contains(text(),'"+fileName+"')]/following-sibling::span/a[@id='filesDeleteOnEditPg']"))));
    }
    public static void editDeleteFileAddPage(String fileName){
        BaseClass.waitForPageLoad();
        driver.findElement(By.xpath("//span[contains(text(),'"+fileName+"')]/following-sibling::span/a[@id='filesDeleteOnEditPg']")).click();
    }
    public static void editCheckImageFileAddPage(String fileName){
        BaseClass.waitForPageLoad();
        Assert.assertTrue(checkElementDisplayed(driver.findElement(By.xpath("//span[contains(text(),'"+fileName+"')]/preceding-sibling::span/img"))));
    }
    public static void fileDeleted(String fileName){
        BaseClass.waitForPageLoad();
        WebElement web = driver.findElement(By.xpath("//span[contains(text(),'" + fileName + "')]"));
        Assert.assertTrue(web.getAttribute("class").contains("strikeOff"));
    }
    public static void uploadFileNotPresent(){
        BaseClass.waitForPageLoad();
        Assert.assertFalse(checkElementDisplayed(filesPage.getUploadFilesBtn()));
    }
    private static Boolean checkElementDisplayed(WebElement webElement){
        return (webElement.isDisplayed());
    }
}
