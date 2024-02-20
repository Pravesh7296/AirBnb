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
import com.Air.Model.Guest;
import com.Air.Services.GuestServiceIntr;

@RestController("/guest")
public class GuestController {
  @Autowired
  private GuestServiceIntr guestSer;
  
  @PostMapping("/addGuest")
  public ResponseEntity<String> addGuest(@RequestBody Guest guest) throws SomethingWentWrong{
	  String str = guestSer.addGuest(guest);
	  return new ResponseEntity<String>(str,HttpStatus.OK);
  }
  
  @DeleteMapping("/deleteGuest/{id}")
  public ResponseEntity<String> deleteGuest(@PathVariable int id) throws SomethingWentWrong{
	  String str = guestSer.deleteGuest(id);
	  return new ResponseEntity<String>(str,HttpStatus.OK);
  }
  @GetMapping("/findGuest/{id}")
  public ResponseEntity<Guest> findGuestById(@PathVariable int id) throws SomethingWentWrong{
	  Guest guest = guestSer.findGuest(id);
	  return new ResponseEntity<Guest>(guest,HttpStatus.FOUND);
  }
  @GetMapping("/findGuestByName/{name}")
  public ResponseEntity<Guest> findGuestByName(@PathVariable String name) throws SomethingWentWrong{
	  Guest guest = guestSer.findGuestByName(name);
	  return new ResponseEntity<Guest>(guest,HttpStatus.FOUND);
  }
  @GetMapping("/listOfAllGuest")
  public ResponseEntity<List<Guest>> listOfAllGuest() throws SomethingWentWrong{
	  List<Guest> list = guestSer.listOfAllGuest();
	  return new ResponseEntity<List<Guest>>(list,HttpStatus.FOUND);
  }
}
