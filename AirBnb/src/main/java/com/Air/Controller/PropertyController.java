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
import com.Air.Model.Host;
import com.Air.Model.Property;
import com.Air.Services.PropertyServiceIntr;

@RestController("/property")
public class PropertyController {
       @Autowired
       private PropertyServiceIntr propertyser;
       
       @PostMapping("/addProperty")
       public ResponseEntity<String> addProperty(@RequestBody Property property) throws SomethingWentWrong{
     	  String str = propertyser.addProperty(property);
     	  return new ResponseEntity<String>(str,HttpStatus.OK);
       }
       
       @DeleteMapping("/deleteProperty/{id}")
       public ResponseEntity<String> deleteProperty(@PathVariable int id) throws SomethingWentWrong{
     	  String str =  propertyser.deleteProperty(id);
     	  return new ResponseEntity<String>(str,HttpStatus.OK);
       }
       @GetMapping("/propertyByType/{type}")
       public ResponseEntity<List<Property>> propertyByType(@PathVariable String type) throws SomethingWentWrong{
     	  List<Property> list =   propertyser.propertyByType(type);
     	  return new ResponseEntity<List<Property>>(list,HttpStatus.FOUND);
       }
       
       @GetMapping("/propertyByHost/{id}")
       public ResponseEntity<List<Property>> propertyByHost(@PathVariable int id) throws SomethingWentWrong{
     	  List<Property> list =   propertyser.propertyByHost(id);
     	  return new ResponseEntity<List<Property>>(list,HttpStatus.FOUND);
       }
       
       @GetMapping("/listOfAllProperty/")
       public ResponseEntity<List<Property>> listOfAllProperty() throws SomethingWentWrong{
     	  List<Property> list =  propertyser.listOfProperty();
     	  return new ResponseEntity<List<Property>>(list,HttpStatus.FOUND);
       }
}
