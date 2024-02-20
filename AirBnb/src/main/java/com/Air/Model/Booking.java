package com.Air.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Booking {
     @Id
     @GeneratedValue(strategy=GenerationType.IDENTITY)
	 private int bookingId;
     
     @ManyToOne
     private Property property;
     @ManyToOne
     private Guest guest;
}
