package pages.doctorDashboard;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * @author Ajit
 */
public class CommonPage {

//    @FindBy(xpath = "//a[contains(@href,'home')]")
    @FindBy(id = "brand_logo")
    private WebElement logo;
    
    @FindBy(id = "logoutBtn")
    private WebElement logout;
    
    @FindBy(xpath ="//li[@id='topDropdownContainer']//input")
    private WebElement searchClinicDropdown;
    
    @FindBy(xpath = "//a[@class='searchBtn fa fa-search cursor-pointer']")
    private WebElement searchBtn;
    
    @FindBy(id = "patientbyall")
    private WebElement searchBox;
    
    @FindBy(xpath = "(//ul[@class='ui-autocomplete ui-front ui-menu ui-widget ui-widget-content ui-corner-all'])[1]")
    private List<WebElement> searchType;
    
    @FindBy(xpath = "//div[contains(@class,'clearfix topPagination pagingUI')]//a[contains(@class,'page')]")
    private List<WebElement> totalPagePatients;
    
    @FindBy(xpath = "//div[contains(@class,'clearfix topPagination pagingUI')]//a[contains(@class,'next')]")
    private WebElement nextPageBtn;
    
    @FindBy(xpath = "//h4[contains(text(),'Pending Actions')]")
    private WebElement pendingActionsNotificationLabel;
    
    @FindBy(xpath="//a[@class='close notActiveSec ui-link']")
    private WebElement snoozePendingActionsNotification;
    
    @FindBy(xpath="//a[@class='close btn-act-save dueApptSaveDataBtn ui-link']")
    private WebElement savePendingActionsNotification;
  

    public WebElement getSavePendingActionsNotification() {
    	return savePendingActionsNotification;
    }
    
    public WebElement getSnoozePendingActionsNotification() {
    	return snoozePendingActionsNotification;
    }
    
    public WebElement getPendingActionsNotification() {
    	return pendingActionsNotificationLabel;
    }
    
	public WebElement getLogo() {
		return logo;
	}
	public WebElement getLogout() {
		return logout;
	}
	public WebElement getSearchClinicDropdown() {
		return searchClinicDropdown;
	}
	public WebElement getSearchBtn() {
		return searchBtn;
	}
	public WebElement getSearchBox() {
		return searchBox;
	}
	public List<WebElement> getSearchType() {
		return searchType;
	}
	public List<WebElement> getTotalPagePatients() {
		return totalPagePatients;
	}
	public WebElement getNextPageBtn() {
		return nextPageBtn;
	}
    
    
    
    
}
