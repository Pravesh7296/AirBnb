package com.Air.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Air.Exception.SomethingWentWrong;
import com.Air.Model.Host;
import com.Air.Repository.HostIntr;
@Service
public class hostServiceImpl implements HostServiceIntr {
  @Autowired 
  private HostIntr  hostintr;
	@Override
	public String addHost(Host host) throws SomethingWentWrong {
	     if(host == hostintr.save(host)) {
	    	 return "Host Added Successfully ";
	     }else {
	    	 throw new  SomethingWentWrong("Not Added host !");
	     }
		
	}

	@Override
	public String deleteHost(int hostId) throws SomethingWentWrong {
		Optional<Host>host = hostintr.findById(hostId);
		if(host==null) {
			throw new  SomethingWentWrong("Host Not Exist !");
		}else {
			hostintr.deleteById(hostId);
			return "Host Deleted Successfully";
		}
	}

	@Override
	public List<Host> listOfHost() throws SomethingWentWrong {
		// TODO Auto-generated method stub
		return hostintr.findAll();
	}

	@Override
	public List<Host> HostByStatus(String status) throws SomethingWentWrong {
		// TODO Auto-generated method stub
		return hostintr.findAll().stream().filter(p->p.getHostStatus().equals(status)).toList();
	}

}
