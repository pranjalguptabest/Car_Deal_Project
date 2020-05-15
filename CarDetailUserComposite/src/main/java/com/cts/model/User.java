package com.cts.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
	private Long userId;
	private String userName;
	private String email;
	private Long mobileNumber;
	private String city;

}
