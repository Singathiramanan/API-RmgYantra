package com.RmgYantra.PomRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProjectsPage {
	
	@FindBy(xpath="//span[.='Create Project']")
	private WebElement createProjectButton;
	
	@FindBy(xpath="//i[@title='Edit']")
	private WebElement editIcon;
	
	@FindBy(xpath="//i[@title='Delete']")
	private WebElement deleteIcon;
	
	
	WebDriver driver;
	public ProjectsPage(WebDriver driver){
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	public WebElement getCreateProjectButton() {
		return createProjectButton;
	}
	public void setCreateProjectButton(WebElement createProjectButton) {
		this.createProjectButton = createProjectButton;
	}
	public WebElement getEditIcon() {
		return editIcon;
	}
	public void setEditIcon(WebElement editIcon) {
		this.editIcon = editIcon;
	}
	public WebElement getDeleteIcon() {
		return deleteIcon;
	}
	public void setDeleteIcon(WebElement deleteIcon) {
		this.deleteIcon = deleteIcon;
	}
	public List<WebElement> getAllProjectname(){
		List<WebElement> projectNames = driver.findElements(By.xpath("//tbody/tr/td[2]"));
		return projectNames;
	}
	public String getProjectId(String projectName){
		
		WebElement ptId = driver.findElement(By.xpath("//tbody/tr/td[.='"+projectName+"']/../td[1]"));
		String projectId = ptId.getText();
		return projectId;
		
	}
	public void deleteProject(String projectId){
		driver.findElement(By.xpath("//tbody/tr/td[.='"+projectId+"']/following-sibling::td/a[@class='delete']")).click();
		deleteIcon.click();
	}
	public List<WebElement> getAllProjectId(){
		List<WebElement> projectIds = driver.findElements(By.xpath("//tbody/tr/td[1]"));
		return projectIds;
	}
	
}
