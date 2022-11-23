package com.zpasthapana.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserPojo {

	private Long userId;

	private String userName;

	private String password;

	private String IPAddress;

	private String userType;

	private Integer userReferenceID;

	private String profilePhoto;

	private String userFullName;

	private Integer themeColor;

	private Integer addEditAccessFlag;

	private Integer reportAccessFlag;

	private Integer accessFlag;

	private Integer divisionID;

	private Integer zillaParishadID;

	private Integer departmentID;

	private Integer talukaID;

	private Integer subDivisionID;

	private Integer properOfficeID;

	private Integer isActive;

	private String email;

}
