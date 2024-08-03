package org.obj;

import org.pag.BookHotelPage;
import org.pag.BookedPageReview;
import org.pag.BookingConfirmation;
import org.pag.LoginPage;
import org.pag.SearchHotelPage2;
import org.pag.SelectHotePage;

public class PageObjectManager  {
	
	private LoginPage loginpage;
	private SearchHotelPage2 searchHotel;
	private SelectHotePage selectHotel;
	private BookHotelPage bookHotel;
	private BookingConfirmation confirmation;
	private BookedPageReview bookedPage;
	
	public LoginPage getLoginpage() {
		return (loginpage==null) ? loginpage = new LoginPage():loginpage;
	}
	
	public SearchHotelPage2 getSearchHotel() {
		return (searchHotel==null) ? searchHotel=new SearchHotelPage2():searchHotel;
	}
	public SelectHotePage getSelectHotel() {
		return (selectHotel==null) ? selectHotel = new SelectHotePage():selectHotel;
	}
	
	public BookHotelPage getBookHotel() {
		return (bookHotel==null) ? bookHotel = new BookHotelPage():bookHotel ;
	}

	public BookingConfirmation getConfirmation() {
		return (confirmation==null) ?  confirmation= new BookingConfirmation():confirmation;
	}
	
	public BookedPageReview getBookedPage() {
		return (bookedPage==null) ? bookedPage =new BookedPageReview():bookedPage;
	}
}
