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
import com.Air.Model.Host;
import com.Air.Services.HostServiceIntr;

@RestController("/host")
public class HostController {
  @Autowired 
  private HostServiceIntr hostSer;
  
  @PostMapping("/addHost")
  public ResponseEntity<String> addHost(@RequestBody Host host) throws SomethingWentWrong{
	  String str = hostSer.addHost(host);
	  return new ResponseEntity<String>(str,HttpStatus.OK);
  }
  
  @DeleteMapping("/deleteHost/{id}")
  public ResponseEntity<String> deleteGuest(@PathVariable int id) throws SomethingWentWrong{
	  String str = hostSer.deleteHost(id);
	  return new ResponseEntity<String>(str,HttpStatus.OK);
  }
  @GetMapping("/hostByStatus/{status}")
  public ResponseEntity<List<Host>> findGuestById(@PathVariable String status) throws SomethingWentWrong{
	  List<Host> hostlist = hostSer.HostByStatus(status);
	  return new ResponseEntity<List<Host>>(hostlist,HttpStatus.FOUND);
  }
  @GetMapping("/listOfAllhost/")
  public ResponseEntity<List<Host>> listOfAllHost() throws SomethingWentWrong{
	  List<Host> hostlist = hostSer.listOfHost();
	  return new ResponseEntity<List<Host>>(hostlist,HttpStatus.FOUND);
  }
  
}
