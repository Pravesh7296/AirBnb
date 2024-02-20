package com.Air.seurity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class jwtRequest {
 private String email;
 private String password;
 
 
}
