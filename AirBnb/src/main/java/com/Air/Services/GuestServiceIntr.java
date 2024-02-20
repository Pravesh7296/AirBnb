package com.Air.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Air.Exception.SomethingWentWrong;
import com.Air.Model.Guest;

@Service
public interface GuestServiceIntr {
   public String addGuest(Guest guest)  throws SomethingWentWrong;
   public String deleteGuest(int guestId)  throws SomethingWentWrong;
   public List<Guest> listOfAllGuest()  throws SomethingWentWrong;
   public Guest findGuest(int guestId)  throws SomethingWentWrong;
   public Guest findGuestByName(String guestName)  throws SomethingWentWrong;
}
