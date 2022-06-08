package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class BookingConfirmPage extends BaseClass {
	public BookingConfirmPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//td[text()='Booking Confirmation ']")
	private WebElement textConfirm;


	public WebElement getTextConfirm() {
		return textConfirm;
	}
	
	public WebElement bookConfirm() {
		WebElement element = explicitWait(getTextConfirm());
		return element;

	}
	

	



}
