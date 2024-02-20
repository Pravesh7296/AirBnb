package com.Air.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Air.Exception.SomethingWentWrong;

import com.Air.Model.Property;

@Service
public interface PropertyServiceIntr {
	 public String addProperty(Property property)  throws SomethingWentWrong;
	  public String deleteProperty(int propertyId)  throws SomethingWentWrong;
	  public List<Property> listOfProperty()  throws SomethingWentWrong;
	  public List<Property> propertyByType(String propertyType)  throws SomethingWentWrong;
      public List<Property> propertyByHost(int hostId) throws SomethingWentWrong;
}
