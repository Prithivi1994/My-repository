package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class BookAHotelPage extends BaseClass{
	
	public BookAHotelPage() {
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath="//td[text()='Book A Hotel ']")
	private WebElement txtBookHotel;
	
	@FindBy(id="first_name")
	private WebElement txtFirstName;
	
	@FindBy(id="last_name")
	private WebElement txtLastName;
	
	@FindBy(id="address")
	private WebElement txtAddress;
	
	@FindBy(id="cc_num")
	private WebElement txtCcNum;
	
	@FindBy(id="cc_type")
	private WebElement dDnCcType;
	
	@FindBy(id="cc_exp_month")
	private WebElement dDnExpMonth;
	
	@FindBy(id="cc_exp_year")
	private WebElement dDnExpYear;
	
	@FindBy(id="cc_cvv")
	private WebElement txtCvvNum;
	
	@FindBy(id="book_now")
	private WebElement btnBookNow;
	

	
	@FindBy(xpath="//label[text()='Please Enter your First Name']")
	private WebElement textFirstName;
	
	@FindBy(xpath="//label[text()='Please Enter you Last Name']")
	private WebElement textLastName;
	
	@FindBy(xpath="//label[text()='Please Enter your Address']")
	private WebElement textAddress;
	
	@FindBy(xpath="//label[text()='Please Enter your 16 Digit Credit Card Number']")
	private WebElement textCardNum;
	
	@FindBy(xpath="//label[text()='Please Select your Credit Card Type']")
	private WebElement textCardType;
	
	@FindBy(xpath="//label[text()='Please Select your Credit Card Expiry Month']")
	private WebElement textCardMonth;
	
	@FindBy(xpath="//label[text()='Please Enter your Credit Card CVV Number']")
	private WebElement textCardcvv;
	
	
	
	
	public WebElement getTxtBookHotel() {
		return txtBookHotel;
	}
	
	public WebElement getTextFirstName() {
		return textFirstName;
	}

	public WebElement getTextLastName() {
		return textLastName;
	}

	public WebElement getTextAddress() {
		return textAddress;
	}

	public WebElement getTextCardNum() {
		return textCardNum;
	}

	public WebElement getTextCardType() {
		return textCardType;
	}

	public WebElement getTextCardMonth() {
		return textCardMonth;
	}

	public WebElement getTextCardcvv() {
		return textCardcvv;
	}

	

	public WebElement getTxtFirstName() {
		return txtFirstName;
	}

	public WebElement getTxtLastName() {
		return txtLastName;
	}

	public WebElement getTxtAddress() {
		return txtAddress;
	}

	public WebElement getTxtCcNum() {
		return txtCcNum;
	}

	public WebElement getdDnCcType() {
		return dDnCcType;
	}

	public WebElement getdDnExpMonth() {
		return dDnExpMonth;
	}

	public WebElement getdDnExpYear() {
		return dDnExpYear;
	}

	public WebElement getTxtCvvNum() {
		return txtCvvNum;
	}

	public WebElement getBtnBookNow() {
		return btnBookNow;
	}
	
	public void bookAHotel(String firstName,String lastName,String address,String cardName,String cardNum,String cardMonth,String cardYear,String cardCvv) {
		
		sendKeys(getTxtFirstName(), firstName);
		sendKeys(getTxtLastName(),lastName);
		sendKeys(getTxtAddress(), address);
		sendKeys(getdDnCcType(), cardName);
		sendKeys(getTxtCcNum(), cardNum);
		sendKeys(getdDnExpMonth(), cardMonth);
		sendKeys(getdDnExpYear(), cardYear);
		sendKeys(getTxtCvvNum(), cardCvv);
		getBtnBookNow().click();
		

	}
	
	
	
	
	

}
