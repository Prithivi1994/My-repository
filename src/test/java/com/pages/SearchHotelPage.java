package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class SearchHotelPage extends BaseClass {
	
	public SearchHotelPage() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="username_show")
	private WebElement textVerify;
	
	@FindBy(id="location")
	private WebElement dDnLocation;
	
	@FindBy(id="hotels")
	private WebElement dDnHotels;
	
	@FindBy(id="room_type")
	private WebElement dDnRoomType;
	
	@FindBy(id="room_nos")
	private WebElement dDnRoomNo;
	
	@FindBy(id="datepick_in")
	private WebElement txtDateCheckIn;
	
	@FindBy(id="datepick_out")
	private WebElement txtDateCheckOut;
	
	@FindBy(id="adult_room")
	private WebElement dDnAdultRoom;
	
	@FindBy(id="child_room")
	private WebElement dDnChildRoom;
	
	@FindBy(id="Submit")
	private WebElement btnSearch;
	
	
	
	

	public WebElement getTextVerify() {
		return textVerify;
	}

	public WebElement getdDnLocation() {
		return dDnLocation;
	}

	public WebElement getdDnHotels() {
		return dDnHotels;
	}

	public WebElement getdDnRoomType() {
		return dDnRoomType;
	}

	public WebElement getdDnRoomNo() {
		return dDnRoomNo;
	}

	public WebElement getTxtDateCheckIn() {
		return txtDateCheckIn;
	}

	public WebElement getTxtDateCheckOut() {
		return txtDateCheckOut;
	}

	public WebElement getdDnAdultRoom() {
		return dDnAdultRoom;
	}

	public WebElement getdDnChildRoom() {
		return dDnChildRoom;
	}
	public WebElement getbtnSearch() {
		return btnSearch;
		
	}
	
	public void searchHotel(String location,String hotels,String roomType,String numOfRooms,
			String checkInDate,String checkOutDate,String adultsPerRoom,String childrenPerRoom) {
		
		selectOptionByText(getdDnLocation(), location);
		selectOptionByText(getdDnHotels(), hotels);
		selectOptionByText(getdDnRoomType(), roomType);
		selectOptionByText(getdDnRoomNo(), numOfRooms);
		clear(getTxtDateCheckIn());
		sendKeys(getTxtDateCheckIn(), checkInDate);
		clear(getTxtDateCheckOut());
		sendKeys(getTxtDateCheckOut(), checkOutDate);
		selectOptionByText(getdDnAdultRoom(),adultsPerRoom);
		selectOptionByText(getdDnChildRoom(),childrenPerRoom);
		click(getbtnSearch());
		
	
		
	}

}
