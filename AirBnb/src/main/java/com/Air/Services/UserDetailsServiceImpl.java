package com.Air.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.Air.Model.Guest;
import com.Air.Model.Host;
import com.Air.Repository.GuestIntr;
import com.Air.Repository.HostIntr;
@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	@Autowired
	 private HostIntr hostintr;
	@Autowired
	private GuestIntr guestintr;
	
	@Override
	//load user from database
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
	Host host = hostintr.findAll().stream().filter(p->p.getName().equals(username)).toList().get(0);
	Guest guest = 	guestintr.findAll().stream().filter(p->p.getGuestName().equals(username)).toList().get(0);	
	if(host==null && guest==null) {
		throw new UsernameNotFoundException("Host Or Guest Not Found !");
	}else {
		if(host==null) {
			return guest;
		}else if(guest==null) {
			return host;
		}else {
			throw new UsernameNotFoundException("Found guest and host with same name and password !");
		}
	}

		
		
	}

	

}
