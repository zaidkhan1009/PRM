package pages.patientDashboard;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class AppointmentsListPage {
    
    /*storing the webelement*/
    @FindBy(xpath = "//table[@id='appLis']//td[1]")
    private List<WebElement> dates;
    @FindBy(xpath = "//span[text()='No Record Found']")
    private WebElement noRecordFoundMsg;
    @FindBy(xpath = "//table[@id='appLis']/tbody/tr")
    private List<WebElement> appointmentsPatient;
    @FindBy(xpath = "//span[contains(@class,'infPatientFlag')]/a[contains(@class,'green')]")
    private WebElement covidStatus;
//    @FindBy(xpath = "//th[text()='Date-Time']")
    @FindBy(xpath = "//th[text()='Date-Time']")
    private WebElement dateTimeColumn;
    @FindBy(xpath = "//th[contains(text(),'Chief Compalint(s)')]")
    private WebElement chiefComplaintColumn;
    @FindBy(xpath = "//th[text()='Renewals']")
    private WebElement renewalsColumn;
    @FindBy(xpath = "//th[text()='Type']")
    private WebElement typeColumn;
    @FindBy(xpath = "//th[text()='Clinic']")
    private WebElement clinicColumn;
    @FindBy(xpath = "//th[text()='Doctor']")
    private WebElement doctorColumn;
    @FindBy(xpath = "//th[text()='Action']")
    private WebElement actionColumn;
    @FindBy(xpath = "//table[@id='appLis']//td")
    private List<WebElement> cells;
    @FindBy(xpath="(//span[@class='actn-icn delete']/../../../../..//span[@class='dis-block ng-binding'])[2]")
    private WebElement clinicName;
    @FindBy(xpath="//span[@class='actn-icn delete']/../../../../..//td[@class='ng-binding']")
    private WebElement doctorName;
    @FindBy(xpath = "//span[@class='actn-icn delete']/../../../../..//td[@class='ng-binding']")
    private List<WebElement> doctorNameAndClinic;
    @FindBy(xpath="//i[text()='DashBoard']")
	private WebElement dashBoardBtn;
//    @FindBy(xpath = "//iframe[contains(@id,'fancybox-frame')]")
//    private WebElement viewFrame;
	
    
    public List<WebElement> getDates() {
		return dates;
	}
	public WebElement getNoRecordFoundMsg() {
		return noRecordFoundMsg;
	}
	public List<WebElement> getAppointmentsPatient() {
		return appointmentsPatient;
	}
	public WebElement getCovidStatus() {
		return covidStatus;
	}
	public WebElement getDateTimeColumn() {
		return dateTimeColumn;
	}
	public WebElement getChiefComplaintColumn() {
		return chiefComplaintColumn;
	}
	public WebElement getRenewalsColumn() {
		return renewalsColumn;
	}
	public WebElement getTypeColumn() {
		return typeColumn;
	}
	public WebElement getClinicColumn() {
		return clinicColumn;
	}
	public WebElement getDoctorColumn() {
		return doctorColumn;
	}
	public WebElement getActionColumn() {
		return actionColumn;
	}
	public List<WebElement> getCells() {
		return cells;
	}
	public WebElement getClinicName() {
		return clinicName;
	}
	public WebElement getDoctorName() {
		return doctorName;
	}
	public List<WebElement> getDoctorNameAndClinic() {
		return doctorNameAndClinic;
	}
	public WebElement getDashBoardBtn() {
		return dashBoardBtn;
	}

    
    
}
