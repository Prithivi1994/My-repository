package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class SelectHotelPage extends BaseClass {
	public SelectHotelPage() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="radiobutton_0")
	private WebElement btnSelectHotel;
	
	@FindBy(id="continue")
	private WebElement btnContinue;
	
	@FindBy(xpath="//td[text()='Select Hotel ']")
	private WebElement txtSelectHotel;

	public WebElement getTxtSelectHotel() {
		return txtSelectHotel;
	}

	public WebElement getBtnSelectHotel() {
		return btnSelectHotel;
	}

	public WebElement getBtnContinue() {
		return btnContinue;
	}
	
	public void selectHotels() {
		click(getBtnSelectHotel());
		click(getBtnContinue());
		
	}

}
