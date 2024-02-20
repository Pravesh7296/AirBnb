package com.Air.seurity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class jwtResponse {
  private String jwtToken;
  private String userName;

}
