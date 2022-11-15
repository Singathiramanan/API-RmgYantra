package com.RmgYantra.PomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage {
	
	@FindBy(xpath="//input[@name='username']")
	private WebElement username;
	
	@FindBy(xpath="//input[@name='password']")
	private WebElement password;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement signIn;
	
	WebDriver driver;
	public LogInPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public WebElement getUsername() {
		return username;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getSignIn() {
		return signIn;
	}

	public void setUsername(WebElement username) {
		this.username = username;
	}

	public void setPassword(WebElement password) {
		this.password = password;
	}

	public void setSignIn(WebElement signIn) {
		this.signIn = signIn;
	}
	
	public void LoginToApplication(String uName,String pwd){
		username.sendKeys(uName);
		password.sendKeys(pwd);
		signIn.click();
	}
	
}
