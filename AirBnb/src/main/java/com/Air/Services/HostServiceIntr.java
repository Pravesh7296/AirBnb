package com.Air.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Air.Exception.SomethingWentWrong;
import com.Air.Model.Host;

@Service
public interface HostServiceIntr {
  public String addHost(Host host)  throws SomethingWentWrong;
  public String deleteHost(int hostId)  throws SomethingWentWrong;
  public List<Host> listOfHost()  throws  SomethingWentWrong;
  public List<Host> HostByStatus(String status)  throws SomethingWentWrong;
  public Host getHost(int hostId) throws  SomethingWentWrong;
}
