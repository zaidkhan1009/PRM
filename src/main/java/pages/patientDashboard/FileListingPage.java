package pages.patientDashboard;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FileListingPage {
    

    @FindBy(id = "OralImages")
    private WebElement oralImagesTab;
    @FindBy(id = "PastDocs")
    private WebElement pastDocsTab;
    @FindBy(id = "X-Rays")
    private WebElement xRaysTab;
    @FindBy(id = "Profile")
    private WebElement profileTab;
    @FindBy(xpath = "//div[contains(text(),'No record Found')]")
    private WebElement noRecordfound;
    @FindBy(id = "filesDateDDL")
    private WebElement fileDateFilter;
    @FindBy(xpath = "//span[@class='pull-left fileNamePlacement']")
    private WebElement fileName;
    @FindBy(xpath = "//div[@class='dateUpdated clearfix']/following-sibling::p")
    private WebElement notesFileListPopup;
    @FindBy(id = "closeBtn")
    private WebElement closeBtnFileListPopup;
    @FindBy(id = "zoomInOut")
    private WebElement zoomInOutFileListPopup;
    @FindBy(id = "downloadBtn")
    private WebElement downloadBtnFileListPopup;
    @FindBy(xpath = "//p[contains(text(),'Do you want to delete the selected file?')]")
    private WebElement msgDeletePopup;
    @FindBy(xpath = "//span[text()='Yes']")
    private WebElement yesBtnDeletePopup;
    @FindBy(xpath = "//span[text()='No']")
    private WebElement noBtnDeletePopup;
    @FindBy(xpath = "(//span[@id ='urgentPatientNamePid']/span)[1]")
    private  WebElement patientName;
    @FindBy(xpath = "(//span[@id ='urgentPatientNamePid']/span)[2]")
    private  WebElement patientId;
    
    
    
	public WebElement getOralImagesTab() {
		return oralImagesTab;
	}
	public WebElement getPastDocsTab() {
		return pastDocsTab;
	}
	public WebElement getxRaysTab() {
		return xRaysTab;
	}
	public WebElement getProfileTab() {
		return profileTab;
	}
	public WebElement getNoRecordfound() {
		return noRecordfound;
	}
	public WebElement getFileDateFilter() {
		return fileDateFilter;
	}
	public WebElement getFileName() {
		return fileName;
	}
	public WebElement getNotesFileListPopup() {
		return notesFileListPopup;
	}
	public WebElement getCloseBtnFileListPopup() {
		return closeBtnFileListPopup;
	}
	public WebElement getZoomInOutFileListPopup() {
		return zoomInOutFileListPopup;
	}
	public WebElement getDownloadBtnFileListPopup() {
		return downloadBtnFileListPopup;
	}
	public WebElement getMsgDeletePopup() {
		return msgDeletePopup;
	}
	public WebElement getYesBtnDeletePopup() {
		return yesBtnDeletePopup;
	}
	public WebElement getNoBtnDeletePopup() {
		return noBtnDeletePopup;
	}
	public WebElement getPatientName() {
		return patientName;
	}
	public WebElement getPatientId() {
		return patientId;
	}

    
    
}