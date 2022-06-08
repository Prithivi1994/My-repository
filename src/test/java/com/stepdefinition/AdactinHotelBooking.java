package com.stepdefinition;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.base.BaseClass;
import com.pages.BookAHotelPage;
import com.pages.BookingConfirmPage;
import com.pages.SearchHotelPage;
import com.pages.SelectHotelPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AdactinHotelBooking extends BaseClass {


	@When("User should verify {string}")
	public void userShouldVerify(String expValue) {
		
		SearchHotelPage searchHotel=new SearchHotelPage();
		Assert.assertEquals("Verify text", expValue, getAttribute(searchHotel.getTextVerify()));

	}

	@When("User should search hotel {string},{string},{string},{string},{string},{string},{string} and {string}")
	public void userShouldSearchHotelAnd(String location, String hotels, String roomType, String numOfRooms, String checkInDate, String checkOutDate, String adultsPerRoom, String childrenPerRoom) {
		SearchHotelPage searchHotel=new SearchHotelPage();
		searchHotel.searchHotel(location, hotels, roomType, numOfRooms, checkInDate, checkOutDate, adultsPerRoom, childrenPerRoom);
	}

	@When("User should verify text {string}")
	public void userShouldVerifyText(String expValue) {
		SelectHotelPage selectHotel=new SelectHotelPage();
		Assert.assertEquals("Verify text", expValue, getText(selectHotel.getTxtSelectHotel()));

	}

	@When("User should select hotel")
	public void userShouldSelectHotel() {
		SelectHotelPage selectHotel=new SelectHotelPage();
		selectHotel.selectHotels();

	}

	@When("User should confirm {string}")
	public void userShouldConfirm(String expValue) {
		BookAHotelPage bookHotel=new BookAHotelPage();
		Assert.assertEquals("Verify text", expValue, getText(bookHotel.getTxtBookHotel()));

	}

	@When("User should book hotel {string},{string},{string}, payment details and book hotel")
	public void userShouldBookHotelPaymentDetailsAndBookHotel(String firstName, String lastName, String address, io.cucumber.datatable.DataTable dataTable) {
		BookAHotelPage bookHotel=new BookAHotelPage();

		List<Map<String, String>> m = dataTable.asMaps();
		Map<String, String> map = m.get(2);

		String cardName = map.get("Credit Card Type");

		String cardNumber = map.get("Credit Card No");

		String cardMonth = map.get("Select Month");

		String cardYear = map.get("Select Year");

		String cardCvv = map.get("cvv");

		bookHotel.bookAHotel(firstName, lastName, address, cardName, cardNumber, cardMonth, cardYear, cardCvv); 
	}

	@Then("User should verify booking {string}")
	public void userShouldVerifyBooking(String expValue) {
		BookingConfirmPage bookingConfirm=new BookingConfirmPage();
		Assert.assertEquals("Verify text", expValue, getText(bookingConfirm.bookConfirm()));

	}

	@When("User should click on Book Now")
	public void userShouldClickOnBookNow() {
		BookAHotelPage bookHotel=new BookAHotelPage();
		click(bookHotel.getBtnBookNow());


	}

	@Then("User should verify error messages {string},{string},{string},{string},{string},{string} and {string}")
	public void userShouldVerifyErrorMessagesAnd(String expectedErrorMsgFirstName, String expectedErrorMsgLastName, String expectedErrorMsgAddress, String expectedErrorMsgCardNum, String expectedErrorMsgCardType, String expectedErrorMsgMonth, String expectedErrorMsgCvv) {
		BookAHotelPage bookHotel=new BookAHotelPage();


		Assert.assertEquals("Verify firstName Error Message", expectedErrorMsgFirstName, getText(bookHotel.getTextFirstName()));


		Assert.assertEquals("Verify lastName Error Message", expectedErrorMsgLastName,getText(bookHotel.getTextLastName()));


		Assert.assertEquals("Verify address Error Message", expectedErrorMsgAddress, getText(bookHotel.getTextAddress()));


		Assert.assertEquals("Verify cardNum Error Message", expectedErrorMsgCardNum, getText(bookHotel.getTextCardNum()));


		Assert.assertEquals("Verify cardType Error Message", expectedErrorMsgCardType, getText(bookHotel.getTextCardType()));


		Assert.assertEquals("Verify cardExpMonth Error Message", expectedErrorMsgMonth, getText(bookHotel.getTextCardMonth()));


		Assert.assertEquals("Verify cardCvv Error Message", expectedErrorMsgCvv, getText(bookHotel.getTextCardcvv()));

	}

}
