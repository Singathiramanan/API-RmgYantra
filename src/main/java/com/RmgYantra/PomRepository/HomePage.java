package com.RmgYantra.PomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	@FindBy(xpath="//a[.='Home']")
	private WebElement homeTab;
	
	@FindBy(xpath="//a[.='Projects']")
	private WebElement projectTab;
	
	@FindBy(xpath="//a[.='Users']")
	private WebElement usersTab;
	
	@FindBy(xpath="//a[.='Settings']")
	private WebElement settingsTab;
	
	@FindBy(xpath="//a[.='Logout']")
	private WebElement logoutTab;
	
	WebDriver driver;
	public HomePage(WebDriver driver){
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	public WebElement getHomeTab() {
		return homeTab;
	}
	public void setHomeTab(WebElement homeTab) {
		this.homeTab = homeTab;
	}
	public WebElement getProjectTab() {
		return projectTab;
	}
	public void setProjectTab(WebElement projectTab) {
		this.projectTab = projectTab;
	}
	public WebElement getUsersTab() {
		return usersTab;
	}
	public void setUsersTab(WebElement usersTab) {
		this.usersTab = usersTab;
	}
	public WebElement getSettingsTab() {
		return settingsTab;
	}
	public void setSettingsTab(WebElement settingsTab) {
		this.settingsTab = settingsTab;
	}
	public WebElement getLogoutTab() {
		return logoutTab;
	}
	public void setLogoutTab(WebElement logoutTab) {
		this.logoutTab = logoutTab;
	}
	public void LogoutApplication(){
		logoutTab.click();
	}
	
}
