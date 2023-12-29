package pages.patientDashboard;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.TestData;

/**
 * 
 * @author Ajit Yadav
 *
 */
public class OralExamListingPage {



	@FindBy(xpath = "//h1[contains(@class,'pull-left')]")
	private WebElement title;
	@FindBy(xpath = "//table[@id='table_oelisting']//th[text()='Tooth No']")
	private WebElement toothNo;
	@FindBy(xpath = "//table[@id='table_oelisting']//th[text()='Tooth Site & Perio']")
	private WebElement toothSitePerio;
	@FindBy(xpath = "//table[@id='table_oelisting']//th[text()='Soft Tissue']")
	private WebElement softTissue;
	@FindBy(xpath = "//table[@id='table_oelisting']//th[text()='Hard Tissue']")
	private WebElement hardTissue;
	@FindBy(xpath = "//table[@id='table_oelisting']//th[text()='Created By']")
	private WebElement createdBy;
	@FindBy(xpath = "//table[@id='table_oelisting']//th[text()='Notes']")
	private WebElement notes;
	@FindBy(xpath = "//table[@class='table table-striped']//th[text()='Tooth No']")
	private WebElement viewToothNo;
	@FindBy(xpath = "//table[@class='table table-striped']//th[text()='Tooth Site/Perio']")
	private WebElement viewToothSitePerio;
	@FindBy(xpath = "//table[@class='table table-striped']//th[text()='Soft Tissue']")
	private WebElement viewSoftTissue;
	@FindBy(xpath = "//table[@class='table table-striped']//th[text()='Hard Tissue']")
	private WebElement viewHardTissue;
	@FindBy(xpath = "//table[@class='table table-striped']//th[text()='Created By']")
	private WebElement viewCreatedBy;
	@FindBy(xpath = "(//table[@class='table table-striped']//strong[contains(text(),'Notes')])[1]")
	private WebElement viewNotes;
	
	private static final String TODAY_DATE =TestData.getInstance().getTodayDate();

	
	public WebElement getTitle() {
		return title;
	}

	public WebElement getToothNo() {
		return toothNo;
	}

	public WebElement getToothSitePerio() {
		return toothSitePerio;
	}

	public WebElement getSoftTissue() {
		return softTissue;
	}

	public WebElement getHardTissue() {
		return hardTissue;
	}

	public WebElement getCreatedBy() {
		return createdBy;
	}

	public WebElement getNotes() {
		return notes;
	}

	public WebElement getViewToothNo() {
		return viewToothNo;
	}

	public WebElement getViewToothSitePerio() {
		return viewToothSitePerio;
	}

	public WebElement getViewSoftTissue() {
		return viewSoftTissue;
	}

	public WebElement getViewHardTissue() {
		return viewHardTissue;
	}

	public WebElement getViewCreatedBy() {
		return viewCreatedBy;
	}

	public WebElement getViewNotes() {
		return viewNotes;
	}

	public static String getTodayDate() {
		return TODAY_DATE;
	}

	
	
}
