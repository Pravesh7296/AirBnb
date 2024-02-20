package com.Air.seurity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Air.Exception.SomethingWentWrong;
import com.Air.Model.Guest;
import com.Air.Model.Host;
import com.Air.Services.GuestServiceImpl;
import com.Air.Services.hostServiceImpl;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
   
    private AuthenticationManager manager;
    

    @Autowired
    private jwtHelper helper;
    
    
    @Autowired 
    private GuestServiceImpl guestser;
    
    @Autowired 
    private hostServiceImpl hostser;
    
    @Autowired 
    private PasswordEncoder pe;

    private Logger logger = LoggerFactory.getLogger(AuthController.class);


    @PostMapping("/login/host")
    public ResponseEntity<jwtResponse> loginHost(@RequestBody Host host) {

        this.doAuthenticate(host.getName(), host.getPassword());


        UserDetails userDetails = userDetailsService.loadUserByUsername(host.getName());
        String token = this.helper.generateToken(userDetails);

        jwtResponse response = jwtResponse.builder()
                .jwtToken(token)
                .userName(userDetails.getUsername()).build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @PostMapping("/login/guest")
    public ResponseEntity<jwtResponse> loginGuest(@RequestBody  Guest guest) {

        this.doAuthenticate(guest.getGuestName(), guest.getPassword());


        UserDetails userDetails = userDetailsService.loadUserByUsername(guest.getGuestName());
        String token = this.helper.generateToken(userDetails);

        jwtResponse response = jwtResponse.builder()
                .jwtToken(token)
                .userName(userDetails.getUsername()).build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @PostMapping("/signUp/host")
    public String addHost(@RequestBody Host host) throws SomethingWentWrong {
    	if(hostser.getHost(host.getHostId())!=null) {
    		throw new SomethingWentWrong("Host already exist !");
    	}else {
    		hostser.addHost(host);
    		Host h  = hostser.getHost(host.getHostId());
    		h.setPassword(pe.encode(h.getPassword()));
    		hostser.addHost(host);
    		return "Host Added Successfully";
    	}
    	
    }
    @PostMapping("/signUp/guest")
    public String addGuest(@RequestBody Guest guest) throws SomethingWentWrong {
    	if(guestser.findGuest(guest.getGuestId())!=null) {
    		throw new SomethingWentWrong("Guest already exist !");
    	}else {
    		guestser.addGuest(guest);
    		Guest g  = guestser.findGuest(guest.getGuestId());
    		g.setPassword(pe.encode(g.getPassword()));
    		guestser.addGuest(guest);
    		return "Guest Added Successfully";
    	}
    }

    private void doAuthenticate(String email, String password) {

        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(email, password);
        try {
            manager.authenticate(authentication);


        } catch (BadCredentialsException e) {
            throw new BadCredentialsException(" Invalid Username or Password  !!");
        }

    }

    @ExceptionHandler(BadCredentialsException.class)
    public String exceptionHandler() {
        return "Credentials Invalid !!";
    }

}
