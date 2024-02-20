package com.Air.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Air.Exception.SomethingWentWrong;
import com.Air.Model.Booking;
import com.Air.Services.BookingServiceImpl;

@RestController("/booking")
public class BookingController {
	@Autowired
	private BookingServiceImpl book;
   @PostMapping("/addBooking")
   public ResponseEntity<String> addBooking(@RequestBody Booking booking) throws SomethingWentWrong{
	   String str = book.addBooking(booking);
	   return new ResponseEntity<String>(str,HttpStatus.OK);
   }
   @GetMapping("/getBookingByGuestId/{id}")
   public ResponseEntity<List<Booking>> getBookingByGuestId(@PathVariable int id) throws SomethingWentWrong{
	   List<Booking> list = book.listofBookingByGuestId(id);
	   return  new ResponseEntity<List<Booking>>(list,HttpStatus.FOUND);
   }
   @GetMapping("/getBookingByPropertyId/{id}")
   public ResponseEntity<List<Booking>> getBookingByPropertytId(@PathVariable int id) throws SomethingWentWrong{
	   List<Booking> list = book.listOfBookingByPropertyId(id);
	   return  new ResponseEntity<List<Booking>>(list,HttpStatus.FOUND);
   }
   @DeleteMapping("/deleteBooking/{id}")
   public ResponseEntity<String> deleteBooking(@PathVariable int id) throws SomethingWentWrong{
	   String str = book.deleteBooking(id);
	   return new ResponseEntity<String>(str,HttpStatus.OK);
   }
}
