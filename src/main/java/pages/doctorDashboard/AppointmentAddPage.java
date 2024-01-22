package pages.doctorDashboard;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

/*
 * @author Mohd-Umar
 * @version 0.1
 * @since 2023-12-01
 */

public class AppointmentAddPage {

    // WebElement on Appointment Add screen
    @FindBy(xpath = "//h1[text()='Add Appointment/Event']")
    private WebElement headerPage;
    @FindBy(xpath = "//li[@heading='Add Appointment']")
    private WebElement appointmentTab;
    @FindBy(xpath = "//label[text()='in-Clinic']")
    private WebElement inClinicAppointment;
   @FindBy(xpath = "//label[text()='e-Consult']")
    private WebElement eConsultAppointment;
   @FindBy(xpath = "//label[text()='Scan']")
   private WebElement scanAppointment;
   @FindBy(xpath = "//label[text()='e-Consult']/..//div[@class='stl-chkB-rdB']")
   private WebElement eConsultRadioBtn;
    @FindBy(css = "a[data-value='1']")
    private WebElement firstOperatory;
    @FindBy(id = "eCosultLabel")
    private WebElement rooms;
    //@FindBy(xpath = "//span[text()='Available']")
    @FindBy(xpath = "//label[@id='eCosultLabel']/..//span")
    private List<WebElement> totalRooms;
    @FindBy(id = "scannerLabel")
    private WebElement scanners;
    @FindBy(xpath = "//label[@id='scannerLabel']/..//span")
    private List<WebElement> totalScanners;
    @FindBy(xpath = "//a[contains(text(),'Go To Scheduler')]")
    private WebElement goToSchedularBtn;
    @FindBy(xpath = "//p[contains(text(),'Navigation to scheduler screen will result in loss of your selected information. Are you sure to continue?')]")
    private WebElement schedularTextMsg;
    @FindBy(xpath = "//span[@class='cmnicons yes-mdl']")
    private WebElement yesBtn;
    @FindBy(xpath = "//span[@class='cmnicons cncl-mdl']")
    private WebElement noBtn;
    @FindBy(xpath = "//label[contains(text(),'Patient ID')]/following-sibling::input[@id='patientid']")
    public WebElement patientId;
    @FindBy(xpath = "//label[contains(text(),'Patient Name')]/following-sibling::input[@id='patientname']")
    public WebElement patientName;
    @FindBy(xpath = "//label[contains(text(),'Email ID')]/following-sibling::input[@id='email']")
    public WebElement patientEmail;
    @FindBy(xpath = "//label[contains(text(),'Duration of Appt.')]/following-sibling::input[@id='duration']")
    private WebElement formDuration;
    @FindBy(xpath = "//label[contains(text(),'Mobile')]/following-sibling::input[@id='mobile']")
    public WebElement patientMobile;
//    @FindBy(xpath = "//label[contains(text(),'Clinic')]/following-sibling::custom-combo[@id='mainClinic']//select[@id='clinic']")
    @FindBy(id = "search_option_mainClinic")
    private WebElement clinicDropDown;
    @FindBy(xpath = "//label[contains(text(),'Doctor')]/following-sibling::custom-combo-new[@id='mainDoctor']//select")
    protected WebElement doctor;
//    @FindBy(xpath = "//label[contains(text(),'Date of App')]/following-sibling::input[@id='date']")
    @FindBy(id = "date")
    protected WebElement dateAppointment;
    @FindBy(xpath = "//label[contains(text(),'Slot Availability')]/following-sibling::custom-combo-new[@id='timeSlot']//select")
    protected WebElement timeSlot;
    @FindBy(xpath = "//div[text()='Enter patient name']")
    private WebElement enterPatientNameMsg;
    @FindBy(xpath = "//div[text()='Select doctor']")
    private WebElement pleaseSelectDoctorMsg;
    @FindBy(id = "tentative")
    public WebElement tentativeCheckbox;
//    @FindBy(xpath = "//label[text()='Referral']/following-sibling::custom-combo//select[@id='referral']")
    @FindBy(xpath = "//label[text()='Referral']/..//div[@class='custom-combo-new']//select")
    private WebElement referral;
//    @FindBy(xpath = "//label[text()='Referral Details']/following-sibling::input[@id='refDetails']")
    @FindBy(id = "refDetails")
    private WebElement referralDetails;
//    @FindBy(xpath = "//label[text()='Source']/following-sibling::custom-combo//select[@id='source']")
    @FindBy(xpath = "//label[text()='Source']/..//div[@class='custom-combo-new']//select")
    private WebElement source;
    @FindBy(xpath = "//label[text()='Notes']/following-sibling::textarea[@id='appointment_note']")
    private WebElement notes;
    @FindBy(id = "addAppointment")
    private WebElement addAppointmentTab;
    @FindBy(xpath = "//div[text()='Enter valid email address']")
    private WebElement enterValidEmailAddressMsg;
    @FindBy(xpath = "//p[text()='Select an operatory']")
    private WebElement operatoriesDisableMsg;
    @FindBy(xpath = "//span[@class='cmnicons aprsv']")
    private WebElement saveBtn;
    @FindBy(xpath = "//span[@class='cmnicons rst']")
    private WebElement appResetBtn;
    @FindBy(xpath = "//span[@class='cmnicons cncl']")
    private WebElement cancelBtn;
    @FindBy(xpath = "cmnicons apptAdd")
    private WebElement apptBtn;
    @FindBy(xpath = "//li[contains(@id,'typeahead')]")
    private WebElement AutoSeletwb;
    @FindBy(id = "sms")
    private WebElement smsEmailCheckbox;
    @FindBy(xpath = "//span[text()='Others']")
    private WebElement mentionsOtherTextBox;
    @FindBy(xpath = "//a[@data-ng-model='patient.appointmentData.operatory']")
    private List<WebElement> operatory;
    @FindBy(xpath = "//label[text()='Chief Complaint(s)']")
    private WebElement chiefComplaints;
    @FindBy(xpath = "//span[text()='Pain']")
    private WebElement pain;
    @FindBy(xpath = "//span[text()='Sensitivity']")
    private WebElement sensitivity;
    @FindBy(xpath = "//span[text()='Swollen Gums']")
    private WebElement swollenGums;
    @FindBy(xpath = "//span[text()='Chewing Difficulty']")
    private WebElement chewingDifficulty;
    @FindBy(xpath = "//span[text()='Bad Breath']")
    private WebElement badBreath;
    @FindBy(xpath = "//span[text()='Bleeding Gums']")
    private WebElement bleedingGums;
    @FindBy(xpath = "//span[text()='Discolored Tooth']")
    private WebElement discoloredTooth;
    @FindBy(xpath = "//span[text()='Plaque']")
    private WebElement plaque;
    @FindBy(xpath = "//span[text()='Tooth Decay']")
    private WebElement toothDecay;
    @FindBy(xpath = "//span[text()='Teeth Grinding']")
    private WebElement teethGrinding;
    @FindBy(xpath = "//span[text()='Loose Teeth']")
    private WebElement looseTeeth;
    @FindBy(id = "otherchiefComplaint")
    private WebElement otherChiefComplaintBox;
    @FindBy(xpath = "//label[contains(text(),'Tentative Appt.')]")
    private WebElement tentativeBtn;
    //web elements on Covid-19 form
    @FindBy(id = "patient_infDses_flag")
    private WebElement patientCovidStatus;
    @FindBy(xpath = "//span[text()='Covid-19 Declaration']")
    private WebElement headerCovid;
	/*
	 * @FindBy(xpath = "//span[@class='ng-binding ng-scope']") private WebElement
	 * CovidFlagAlertMsg;
	 * 
	 * @FindBy(xpath =
	 * "//div[@id='patient_infDses_flag']//span[contains(@class,'grey')]")
	 */
    @FindBy(xpath = "//div[@class='alert ng-binding ng-isolate-scope alert-danger alert-dismissable']")
    private WebElement CovidFlagAlertMsg;
    @FindBy(xpath = "//div[@id='patient_infDses_flag']//div[contains(@class,'grey')]")
    private WebElement greyFlag;
    @FindBy(xpath = "//div[@id='patient_infDses_flag']//h1[text()='Not Available']")
    private WebElement notAvailableGrey;
    @FindBy(xpath = "//div[@id='patient_infDses_flag_formInitialize']")
    private WebElement covidFormBtn;
    @FindBy(xpath = "//h1[text()='Treatment Allowed']")
    private WebElement greenCovidPatient;
    @FindBy(xpath = "//div[text()='Patient Covid-19 Declaration saved successfully!']")
    private WebElement covidUpdateSuccessMsg;
    @FindBy(xpath = "//h1[text()='Treatment not Allowed']")
    private WebElement redCovidPatient;
    @FindBy(xpath = "//div[text()='Enter mobile no.']")
    private WebElement enterMobileNoMsg;
    @FindBy(xpath = "//div[text()='Enter 10 digit mobile no.']")
    private WebElement enterTenDigitMobileNoMsg;
    @FindBy(xpath = "//div[text()='Enter a valid mobile no.']")
    private WebElement enterValidMobileNoMsg;
    @FindBy(xpath = "//label[contains(text(),'Slot Availability')]/..//..//select")
    private WebElement selectSlot;
    @FindBy(id = "@Home")
    private WebElement homeServiceType;
    @FindBy(xpath = "//label[contains(text(),'@Clinic')]")
    private WebElement clinicServiceType;
    @FindBy(id = "srvc_address")    
    private WebElement serviceAddress;
    @FindBy(xpath = "//input[@id='srvc_address']/..//div[@class='error ng-binding ng-scope']")    
    private WebElement serviceAddressErrMsg;
    @FindBy(id = "srvc_city")
    private WebElement serviceCity;
    @FindBy(xpath = "//input[@id='srvc_city']/..//div[@class='error ng-binding ng-scope']")    
    private WebElement serviceCityErrMsg;
    @FindBy(id = "srvc_pincode")
    private WebElement servicePincode;
    @FindBy(xpath = "//input[@id='srvc_pincode']/..//div[@class='error ng-binding ng-scope']")    
    private WebElement servicePincodeErrMsg;
    @FindBy(id = "state")
    private WebElement serviceState;
    @FindBy(xpath ="//select[@id='state']/../../..//div[@class='error ng-binding ng-scope']") // [Umar, 2-Jan-24]: xpath changed from "//select[@id='state']/../../..//div[@class='error mrgn-top5 ng-binding ng-scope']"   
    private WebElement serviceStateErrMsg;
    @FindBy(id = "service clinic")
    private WebElement serviceClinic;
    @FindBy(xpath = "//select[@id='service clinic']/../../..//div[@class='error mrgn-top5 ng-binding ng-scope']")    
    private WebElement serviceClinicErrMsg;
    @FindBy(xpath = "//div[@class='alert ng-isolate-scope alert-success alert-dismissable']//div//span")    
    private WebElement updateAppnmntTxt;
    @FindBy(xpath = "//div[@class='alert ng-binding ng-isolate-scope alert-danger alert-dismissable']")    
    private WebElement restrictUpdateAppnmntTxt;
    @FindBy(xpath = "//span[@class='glyphicon glyphicon-chevron-down customComboBtn cursor-pointer']")    
    private WebElement clinicDrpdwnBtn;
 
	/*
	*	Getters for the locators
	*/
    
    public WebElement getHeaderPage() {
		return headerPage;
	}

	public WebElement getAppointmentTab() {
		return appointmentTab;
	}

	public WebElement getInClinicAppointment() {
		return inClinicAppointment;
	}

	public WebElement geteConsultAppointment() {
		return eConsultAppointment;
	}

	public WebElement getScanAppointment() {
		return scanAppointment;
	}

	public WebElement geteConsultRadioBtn() {
		return eConsultRadioBtn;
	}

	public WebElement getFirstOperatory() {
		return firstOperatory;
	}

	public WebElement getRooms() {
		return rooms;
	}

	public List<WebElement> getTotalRooms() {
		return totalRooms;
	}

	public WebElement getScanners() {
		return scanners;
	}

	public List<WebElement> getTotalScanners() {
		return totalScanners;
	}

	public WebElement getGoToSchedularBtn() {
		return goToSchedularBtn;
	}

	public WebElement getSchedularTextMsg() {
		return schedularTextMsg;
	}

	public WebElement getYesBtn() {
		return yesBtn;
	}

	public WebElement getNoBtn() {
		return noBtn;
	}

	public WebElement getPatientId() {
		return patientId;
	}

	public WebElement getPatientName() {
		return patientName;
	}

	public WebElement getPatientEmail() {
		return patientEmail;
	}

	public WebElement getFormDuration() {
		return formDuration;
	}

	public WebElement getPatientMobile() {
		return patientMobile;
	}

	public WebElement getClinicDropDown() {
		return clinicDropDown;
	}

	public WebElement getDoctor() {
		return doctor;
	}

	public WebElement getDateAppointment() {
		return dateAppointment;
	}

	public WebElement getTimeSlot() {
		return timeSlot;
	}

	public WebElement getEnterPatientNameMsg() {
		return enterPatientNameMsg;
	}

	public WebElement getPleaseSelectDoctorMsg() {
		return pleaseSelectDoctorMsg;
	}

	public WebElement getTentativeCheckbox() {
		return tentativeCheckbox;
	}

	public WebElement getReferral() {
		return referral;
	}

	public WebElement getReferralDetails() {
		return referralDetails;
	}

	public WebElement getSource() {
		return source;
	}

	public WebElement getNotes() {
		return notes;
	}

	public WebElement getAddAppointmentTab() {
		return addAppointmentTab;
	}

	public WebElement getEnterValidEmailAddressMsg() {
		return enterValidEmailAddressMsg;
	}

	public WebElement getOperatoriesDisableMsg() {
		return operatoriesDisableMsg;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getAppResetBtn() {
		return appResetBtn;
	}

	public WebElement getCancelBtn() {
		return cancelBtn;
	}

	public WebElement getApptBtn() {
		return apptBtn;
	}

	public WebElement getAutoSeletwb() {
		return AutoSeletwb;
	}

	public WebElement getSmsEmailCheckbox() {
		return smsEmailCheckbox;
	}

	public WebElement getMentionsOtherTextBox() {
		return mentionsOtherTextBox;
	}

	public List<WebElement> getOperatory() {
		return operatory;
	}

	public WebElement getChiefComplaints() {
		return chiefComplaints;
	}

	public WebElement getPain() {
		return pain;
	}

	public WebElement getSensitivity() {
		return sensitivity;
	}

	public WebElement getSwollenGums() {
		return swollenGums;
	}

	public WebElement getChewingDifficulty() {
		return chewingDifficulty;
	}

	public WebElement getBadBreath() {
		return badBreath;
	}

	public WebElement getBleedingGums() {
		return bleedingGums;
	}

	public WebElement getDiscoloredTooth() {
		return discoloredTooth;
	}

	public WebElement getPlaque() {
		return plaque;
	}

	public WebElement getToothDecay() {
		return toothDecay;
	}

	public WebElement getTeethGrinding() {
		return teethGrinding;
	}

	public WebElement getLooseTeeth() {
		return looseTeeth;
	}

	public WebElement getOtherChiefComplaintBox() {
		return otherChiefComplaintBox;
	}

	public WebElement getTentativeBtn() {
		return tentativeBtn;
	}

	public WebElement getPatientCovidStatus() {
		return patientCovidStatus;
	}

	public WebElement getHeaderCovid() {
		return headerCovid;
	}

	public WebElement getCovidFlagAlertMsg() {
		return CovidFlagAlertMsg;
	}

	public WebElement getGreyFlag() {
		return greyFlag;
	}

	public WebElement getNotAvailableGrey() {
		return notAvailableGrey;
	}

	public WebElement getCovidFormBtn() {
		return covidFormBtn;
	}

	public WebElement getGreenCovidPatient() {
		return greenCovidPatient;
	}

	public WebElement getCovidUpdateSuccessMsg() {
		return covidUpdateSuccessMsg;
	}

	public WebElement getRedCovidPatient() {
		return redCovidPatient;
	}

	public WebElement getEnterMobileNoMsg() {
		return enterMobileNoMsg;
	}

	public WebElement getEnterTenDigitMobileNoMsg() {
		return enterTenDigitMobileNoMsg;
	}

	public WebElement getEnterValidMobileNoMsg() {
		return enterValidMobileNoMsg;
	}

	public WebElement getSelectSlot() {
		return selectSlot;
	}

	public WebElement getHomeServiceType() {
		return homeServiceType;
	}

	public WebElement getClinicServiceType() {
		return clinicServiceType;
	}

	public WebElement getServiceAddress() {
		return serviceAddress;
	}

	public WebElement getServiceAddressErrMsg() {
		return serviceAddressErrMsg;
	}

	public WebElement getServiceCity() {
		return serviceCity;
	}

	public WebElement getServiceCityErrMsg() {
		return serviceCityErrMsg;
	}

	public WebElement getServicePincode() {
		return servicePincode;
	}

	public WebElement getServicePincodeErrMsg() {
		return servicePincodeErrMsg;
	}

	public WebElement getServiceState() {
		return serviceState;
	}

	public WebElement getServiceStateErrMsg() {
		return serviceStateErrMsg;
	}

	public WebElement getServiceClinic() {
		return serviceClinic;
	}

	public WebElement getServiceClinicErrMsg() {
		return serviceClinicErrMsg;
	}

	public WebElement getUpdateAppnmntTxt() {
		return updateAppnmntTxt;
	}

	public WebElement getRestrictUpdateAppnmntTxt() {
		return restrictUpdateAppnmntTxt;
	}

	public WebElement getClinicDrpdwnBtn() {
		return clinicDrpdwnBtn;
	}
}
