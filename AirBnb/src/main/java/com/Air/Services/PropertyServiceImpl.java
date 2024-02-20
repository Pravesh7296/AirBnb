package com.Air.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Air.Exception.SomethingWentWrong;
import com.Air.Model.Host;
import com.Air.Model.Property;
import com.Air.Repository.HostIntr;
import com.Air.Repository.PropertyIntr;
@Service
public class PropertyServiceImpl implements PropertyServiceIntr {
  @Autowired 
  private PropertyIntr propertyintr;
  @Autowired 
  private HostIntr hostintr;
	@Override
	public String addProperty(Property property) throws SomethingWentWrong {
		if(property==propertyintr.save(property)) {
			return "property Aded Successfully" ;
		}else {
			throw new  SomethingWentWrong("SomeThing Went Wrong !");
		}
		
	}

	@Override
	public String deleteProperty(int propertyId) throws SomethingWentWrong {
		if(propertyintr.findById(propertyId)==null) {
			throw new  SomethingWentWrong("Property Not Exists !");
		}else {
			propertyintr.deleteById(propertyId);
			return "Property Deleted Successfully";
		}
		
	}

	@Override
	public List<Property> listOfProperty() throws SomethingWentWrong {
		// TODO Auto-generated method stub
		return propertyintr.findAll();
	}

	@Override
	public List<Property> propertyByType(String propertyType) throws SomethingWentWrong {
		// TODO Auto-generated method stub
		return propertyintr.findAll().stream().filter(p->p.getPropertyType().equals(propertyType)).toList();
	}

	@Override
	public List<Property> propertyByHost(int hostId) throws SomethingWentWrong {
		// TODO Auto-generated method stub
		Optional<Host> host = hostintr.findById(hostId);
		if(host==null) {
			throw new  SomethingWentWrong("Host Not Exists !");
		}else {
			return propertyintr.findAll().stream().filter(p->p.getHost().equals(host.get().getHostId())).toList();
		}
		
	}

}
