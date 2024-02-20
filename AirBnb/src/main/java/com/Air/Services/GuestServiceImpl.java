package com.Air.Services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Air.Exception.SomethingWentWrong;
import com.Air.Model.Guest;
import com.Air.Repository.GuestIntr;
@Service
public class GuestServiceImpl implements GuestServiceIntr {
  @Autowired
  private GuestIntr guestintr;
	@Override
	public String addGuest(Guest guest) throws SomethingWentWrong {
		if((guest == guestintr.save(guest))) {
			return "guest Added Successfully";
		}else {
			throw new SomethingWentWrong("guest Not Added !");
		}
		
	}

	@Override
	public String deleteGuest(int guestId) throws SomethingWentWrong {
	    Optional <Guest> g =  guestintr.findById(guestId);
	    if(g!=null) {
	    	guestintr.deleteById(guestId);
	    	return "Guest Deleted ";
	    }else {
	    	throw new SomethingWentWrong("Guest not Exists");
	    }
		
	}

	@Override
	public List<Guest> listOfAllGuest() throws SomethingWentWrong {
		
		return guestintr.findAll();
	}

	@Override
	public Guest findGuest(int guestId) throws SomethingWentWrong {
		
		  Optional <Guest> g =  guestintr.findById(guestId);
		    if(g!=null) {
		    return g.get();
		    	
		    }else {
		    	throw new SomethingWentWrong("Guest not Exists");
		    }
	}

	@Override
	public Guest findGuestByName(String guestName) throws SomethingWentWrong {
		List <Guest> glist =  guestintr.findAll().stream().filter(p->p.getGuestName().equals(guestName)).toList();
	
		    if(glist.size()==0) {
		     throw new SomethingWentWrong("Guest not Exists");
		    	
		    }else {
		    return glist.get(0)	;
		    }
		
	}

}
