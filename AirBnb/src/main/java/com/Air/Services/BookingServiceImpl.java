 package com.Air.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Air.Exception.SomethingWentWrong;
import com.Air.Model.Booking;
import com.Air.Repository.BookingIntr;
@Service
public class BookingServiceImpl implements BookingServiceIntr {
    @Autowired
	private BookingIntr bookingintr;
    
	@Override
	public String addBooking(Booking booking) throws SomethingWentWrong {
		if(booking == bookingintr.save(booking)) {
			return "Booking added successfully";
		}else {
			throw new SomethingWentWrong("Unsuccessfully !");
		}
		
	}

	@Override
	public String deleteBooking(int id) throws SomethingWentWrong {
		// TODO Auto-generated method stub
		Optional<Booking> b = bookingintr.findById(id);
		if(b.getClass()!=null) {
			bookingintr.deleteById(id);
			return "Booking Deleted Successfully";
		}else {
			throw new SomethingWentWrong("Booking Not Found ! ");
		}
		
	}

	@Override
	public List<Booking> listofBookingByGuestId(int guestId) throws SomethingWentWrong {
		// TODO Auto-generated method stub
	List<Booking>	 list = bookingintr.findAll();
		return list.stream().filter(t->t.getGuest().getGuestId()==guestId).toList();
	}

	@Override
	public List<Booking> listOfBookingByPropertyId(int propertyId) throws SomethingWentWrong {
		// TODO Auto-generated method stub
		List<Booking>	 list = bookingintr.findAll();
		return list.stream().filter(t->t.getGuest().getGuestId()==propertyId).toList();
	}

}
