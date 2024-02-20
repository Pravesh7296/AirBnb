package com.Air.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Air.Model.Guest;
@Repository
public interface GuestIntr extends JpaRepository<Guest,Integer>{

}
