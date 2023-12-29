package pages.patientDashboard;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class FilesPage {
    
    @FindBy(xpath = "//div[@id='categoryContainer']//label[contains(text(),'Category')]")
    private WebElement categoryDopdownHeader;
    @FindBy(id="formCategory")
    private WebElement categoryDropdown;
    @FindBy(xpath = "//span[contains(@class,'ui-icon ui-icon-checkbox')]")
    private WebElement fileNameCheckbox;
    @FindBy(xpath = "//div[@id='fileNameContainer']/label[contains(text(),'File title')]")
    private WebElement fileNameHeader;
    @FindBy(xpath = "//div[@id='fileNameContainer']//input[@id='form_file_name']")
    private WebElement fileNameTextFields;
    @FindBy(xpath = "//div[@id='notesContainer']//label[text()='Notes']")
    private WebElement notesHeader;
    @FindBy(xpath = "//div[@id='notesContainer']//textarea[@id='form_file_notes']")
    private WebElement notesTextField;
    @FindBy(xpath = "//div[@id='notesContainer']//span[text()='Max. 768 character(s)']")
    private WebElement notesCharactersLimitMsg;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement saveBtn;
    @FindBy(xpath = "//button[@type='submit']//b[text()='Save']")
    private WebElement saveBtnText;
    @FindBy(xpath = "//button[@id='fileResetter']")
    private WebElement resetBtn;
    @FindBy(xpath = "//button[@id='fileResetter']//b[text()='Reset']")
    private WebElement resetBtnText;
    @FindBy(id = "cancelCTA")
    private WebElement cancelBtn;
    @FindBy(xpath = "//a[@id='cancelCTA']//b[text()='Cancel']")
    private WebElement cancelBtntext;
    @FindBy(xpath = "//label[@id='dropzoneId']/span")
    private  WebElement uploadFilesBtn;
    @FindBy(xpath = "//label[@id='dropzoneId']//b[text()=' Add file(s)']")
    private WebElement uploadFilesBtnText;
    @FindBy(xpath = "//h1[@class='h1tSpace1']")
    private WebElement headerPage;
    @FindBy(id = "urgentPatientNamePid")
    private  WebElement patietName;
    @FindBy(xpath = "//p[@for='formCategory']")
    private WebElement errorCategoryMsg;
    @FindBy(xpath = "//p[@for='form_file_name']")
    private WebElement errorFileTitle;
    @FindBy(xpath = "//div[@class='clearfix alertMessage']")
    private WebElement fileNotSelectedErrorMsg;
    @FindBy(xpath = "//div[text()='File(s) saved/updated sucessfully!']")
    private WebElement successMsg;
    
    
	public WebElement getCategoryDopdownHeader() {
		return categoryDopdownHeader;
	}
	public WebElement getCategoryDropdown() {
		return categoryDropdown;
	}
	public WebElement getFileNameCheckbox() {
		return fileNameCheckbox;
	}
	public WebElement getFileNameHeader() {
		return fileNameHeader;
	}
	public WebElement getFileNameTextFields() {
		return fileNameTextFields;
	}
	public WebElement getNotesHeader() {
		return notesHeader;
	}
	public WebElement getNotesTextField() {
		return notesTextField;
	}
	public WebElement getNotesCharactersLimitMsg() {
		return notesCharactersLimitMsg;
	}
	public WebElement getSaveBtn() {
		return saveBtn;
	}
	public WebElement getSaveBtnText() {
		return saveBtnText;
	}
	public WebElement getResetBtn() {
		return resetBtn;
	}
	public WebElement getResetBtnText() {
		return resetBtnText;
	}
	public WebElement getCancelBtn() {
		return cancelBtn;
	}
	public WebElement getCancelBtntext() {
		return cancelBtntext;
	}
	public WebElement getUploadFilesBtn() {
		return uploadFilesBtn;
	}
	public WebElement getUploadFilesBtnText() {
		return uploadFilesBtnText;
	}
	public WebElement getHeaderPage() {
		return headerPage;
	}
	public WebElement getPatietName() {
		return patietName;
	}
	public WebElement getErrorCategoryMsg() {
		return errorCategoryMsg;
	}
	public WebElement getErrorFileTitle() {
		return errorFileTitle;
	}
	public WebElement getFileNotSelectedErrorMsg() {
		return fileNotSelectedErrorMsg;
	}
	public WebElement getSuccessMsg() {
		return successMsg;
	}
    
    
    
}
