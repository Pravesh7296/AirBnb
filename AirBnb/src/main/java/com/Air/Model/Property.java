package com.Air.Model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Entity
public class Property {
	    @Id
	    @GeneratedValue(strategy=GenerationType.IDENTITY)
       private int propertyId;
	   private String propertyName;
	  
	   private String location;
       
	   @Pattern(regexp = "(Apartment|House|Unique Homes)", message = "Type must be Apartment or House or Unique Homes")
       private String propertyType;
      
       @ManyToOne
       private Host host;
       
       @OneToMany(mappedBy = "property")
       private List<Booking> booking;
	   
}
