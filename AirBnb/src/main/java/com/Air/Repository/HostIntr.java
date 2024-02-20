package com.Air.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Air.Model.Host;
@Repository
public interface HostIntr extends JpaRepository<Host,Integer>{

}
