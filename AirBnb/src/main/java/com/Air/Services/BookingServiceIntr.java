package com.Air.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Air.Exception.SomethingWentWrong;
import com.Air.Model.Booking;

@Service
public interface BookingServiceIntr {
     public String addBooking(Booking booking) throws SomethingWentWrong;
     public String deleteBooking(int id)  throws SomethingWentWrong;
     public List<Booking> listofBookingByGuestId(int guestId)  throws SomethingWentWrong;
     public List<Booking> listOfBookingByPropertyId(int propertyId)  throws SomethingWentWrong;
}
