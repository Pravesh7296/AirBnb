package com.Air.Model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Entity
public class Guest {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int guestId;
	private  String guestName;
	
    @Pattern(regexp = "(Male|Female|Other)", message = "Gender Must have male or female or other")
    private String Gender;
    
    private LocalDate guestDob;
    
    private String Bio;
    
    @OneToMany(mappedBy = "guest")
    private List<Booking> booking;
    
    

}
