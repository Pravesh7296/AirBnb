package com.Air.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Air.Model.Booking;
@Repository
public interface BookingIntr extends JpaRepository<Booking,Integer>{

}
