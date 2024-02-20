package com.Air.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Air.Model.Property;
@Repository
public interface PropertyIntr extends JpaRepository<Property,Integer>{

}
