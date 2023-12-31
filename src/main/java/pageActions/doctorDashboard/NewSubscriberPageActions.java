package pageActions.doctorDashboard;
 
import base.BaseClass;
import pages.doctorDashboard.Login;
import pages.doctorDashboard.NewSubscriberPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class NewSubscriberPageActions extends BaseClass  {
	
	static Login loginPage = PageFactory.initElements(driver, Login.class);
	static NewSubscriberPage newSubscriberPage = PageFactory.initElements(driver, NewSubscriberPage.class);

    
    public static void nameTextField(){
        BaseClass.waitForPageLoad();
        BaseClass.waitForElementToBeClickable(newSubscriberPage.getName());
        Assert.assertTrue(checkedWebElementDisplayed(newSubscriberPage.getName())&&newSubscriberPage.getName().getAttribute("placeholder").contains("name"));
    }
    public static void genderRadioBtn(){
        BaseClass.waitForPageLoad();
        BaseClass.waitForElementToBeClickable(newSubscriberPage.getMale());
        Assert.assertTrue(checkedWebElementDisplayed(newSubscriberPage.getMale())&&newSubscriberPage.getMale().isSelected()&&checkedWebElementDisplayed(newSubscriberPage.getFemale())&&checkedWebElementDisplayed(newSubscriberPage.getOther()));
    }
    public static void dobTextFields(){
        BaseClass.waitForPageLoad();
        BaseClass.waitForElementToBeClickable(newSubscriberPage.getDob());
        Assert.assertTrue(newSubscriberPage.getDob().getAttribute("placeholder").contains("date of birth (dd-mm-yyyy)"));
    }
    public static void emailIdTextFields(){
        BaseClass.waitForPageLoad();
        BaseClass.waitForElementToBeClickable(newSubscriberPage.getEmail());
        Assert.assertTrue(checkedWebElementDisplayed(newSubscriberPage.getEmail())&&newSubscriberPage.getEmail().getAttribute("placeholder").contains("email"));
    }
    public static void mobileTextFields(){
        BaseClass.waitForPageLoad();
        BaseClass.waitForElementToBeClickable(newSubscriberPage.getMobile());
        Assert.assertTrue(checkedWebElementDisplayed(newSubscriberPage.getMobile())&&newSubscriberPage.getMobile().getAttribute("placeholder").contains("mobile no"));
    }
    public static void alternateContactNo(){
        BaseClass.waitForPageLoad();
        BaseClass.waitForElementToBeClickable(newSubscriberPage.getAlternatePhone());
        Assert.assertTrue(checkedWebElementDisplayed(newSubscriberPage.getAlternatePhone())&&newSubscriberPage.getAlternatePhone().getAttribute("placeholder").contains("alt. contact no."));
    }
    public static void typeDropDown(String firstOptions){
        BaseClass.waitForPageLoad();
        BaseClass.waitForElementToBeClickable(newSubscriberPage.getType());
        Assert.assertTrue(checkedWebElementDisplayed(newSubscriberPage.getType())&&BaseClass.firstSelectedOption(newSubscriberPage.getType()).contains(firstOptions));
    }
    public static void stageDropDown(String firstOptions){
        BaseClass.waitForPageLoad();
        BaseClass.waitForElementToBeClickable(newSubscriberPage.getStage());
        Assert.assertTrue(checkedWebElementDisplayed(newSubscriberPage.getStage())&&BaseClass.firstSelectedOption(newSubscriberPage.getStage()).contains(firstOptions));
    }
    public static void campaignDropDown(String firstOptions){
        BaseClass.waitForPageLoad();
        BaseClass.waitForElementToBeClickable(newSubscriberPage.getCampaign());
        Assert.assertTrue(checkedWebElementDisplayed(newSubscriberPage.getCampaign())&&BaseClass.firstSelectedOption(newSubscriberPage.getCampaign()).contains(firstOptions));
    }
    public static void sourceDropDown(String firstOptions){
        BaseClass.waitForPageLoad();
        BaseClass.waitForElementToBeClickable(newSubscriberPage.getSource());
        Assert.assertTrue(checkedWebElementDisplayed(newSubscriberPage.getSource())&&BaseClass.firstSelectedOption(newSubscriberPage.getSource()).contains(firstOptions));
    }
    public static void subSourceTextFields(){
        BaseClass.waitForPageLoad();
        BaseClass.waitForElementToBeClickable(newSubscriberPage.getSubSource());
        Assert.assertTrue(checkedWebElementDisplayed(newSubscriberPage.getSubSource())&&newSubscriberPage.getSubSource().getAttribute("placeholder").contains("sub source"));
    }
    public static void findingsDropDown(){
        BaseClass.waitForPageLoad();
        BaseClass.waitForElementToBeClickable(newSubscriberPage.getFindings());
        Assert.assertTrue(checkedWebElementDisplayed(newSubscriberPage.getFindings()));
    }
    public static void otherFindingTextFields(){
        BaseClass.waitForPageLoad();
        BaseClass.waitForElementToBeClickable(newSubscriberPage.getOtherFindingsTxt());
        Assert.assertTrue(checkedWebElementDisplayed(newSubscriberPage.getOtherFindingsTxt())&&newSubscriberPage.getOtherFindingsTxt().getAttribute("placeholder").contains("other findings"));
    }
    public static void regionDropDown(String firstOptions){
        BaseClass.waitForPageLoad();
        BaseClass.waitForElementToBeClickable(newSubscriberPage.getRegion());
        Assert.assertTrue(checkedWebElementDisplayed(newSubscriberPage.getRegion())&&BaseClass.firstSelectedOption(newSubscriberPage.getRegion()).contains(firstOptions));
    }
    public static void zoneDropDown(String firstOptions){
        BaseClass.waitForPageLoad();
        BaseClass.waitForElementToBeClickable(newSubscriberPage.getZone());
        Assert.assertTrue(checkedWebElementDisplayed(newSubscriberPage.getZone())&&BaseClass.firstSelectedOption(newSubscriberPage.getZone()).contains(firstOptions));
    }
    public static void addFilesBtn(){
        BaseClass.waitForPageLoad();
        BaseClass.waitForElementToBeClickable(newSubscriberPage.getAddFilesBtn());
        Assert.assertTrue(checkedWebElementDisplayed(newSubscriberPage.getAddFilesBtn()));
    }
    public static void saveBtn(){
        BaseClass.waitForPageLoad();
        BaseClass.waitForElementToBeClickable(newSubscriberPage.getSaveBtn());
        Assert.assertTrue(checkedWebElementDisplayed(newSubscriberPage.getSaveBtn()));
    }
    public static void resetBtn(){
        BaseClass.waitForPageLoad();
        BaseClass.waitForElementToBeClickable(newSubscriberPage.getResetBtn());
        Assert.assertTrue(checkedWebElementDisplayed(newSubscriberPage.getResetBtn()));
    }
    public static void cancelBtn(){
        BaseClass.waitForPageLoad();
        BaseClass.waitForElementToBeClickable(newSubscriberPage.getCancelBtn());
        Assert.assertTrue(checkedWebElementDisplayed(newSubscriberPage.getCancelBtn()));
    }

    private static boolean checkedWebElementDisplayed(WebElement webElement){
        return (webElement.isDisplayed());
    }

}
