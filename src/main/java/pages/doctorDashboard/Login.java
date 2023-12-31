package pages.doctorDashboard;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login {

	@FindBy(id = "username_lgn")
	private WebElement unTxBx;
	
	@FindBy(id = "pwd_lgn")
	private WebElement pwdTxBx;
	
	@FindBy(xpath= "//input[@id='loginButton']")
	//xpath= "//input[@id='loginButton']"
	//id = "loginButton"
	private WebElement loginBtn;
	
	public WebElement getUnTxBx() {
		return unTxBx;
	}
	public WebElement getPwdTxBx() {
		return pwdTxBx;
	}
	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	
}
