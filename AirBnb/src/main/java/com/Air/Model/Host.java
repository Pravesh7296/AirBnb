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
public class Host {
	    @Id
	    @GeneratedValue(strategy=GenerationType.IDENTITY)
       private int hostId;
       private String name;
       @Pattern(regexp = "(Active|Inactive)", message = "Status must be Active either Inactive")
       private String hostStatus;
      
       private String about;
       private LocalDate hostingSince;
       
       @OneToMany(mappedBy = "host")
       private List<Property> list;
       
       
}
