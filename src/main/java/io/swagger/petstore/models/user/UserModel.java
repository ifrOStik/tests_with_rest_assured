package io.swagger.petstore.models.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;
import java.util.Objects;

@Generated("com.robohorse.robopojogenerator")
public class UserModel{

	@JsonProperty("firstName")
	private String firstName;

	@JsonProperty("lastName")
	private String lastName;

	@JsonProperty("password")
	private String password;

	@JsonProperty("userStatus")
	private int userStatus;

	@JsonProperty("phone")
	private String phone;

	@JsonProperty("id")
	private int id;

	@JsonProperty("email")
	private String email;

	@JsonProperty("username")
	private String username;

	public void setFirstName(String firstName){
		this.firstName = firstName;
	}

	public String getFirstName(){
		return firstName;
	}

	public void setLastName(String lastName){
		this.lastName = lastName;
	}

	public String getLastName(){
		return lastName;
	}

	public void setPassword(String password){
		this.password = password;
	}

	public String getPassword(){
		return password;
	}

	public void setUserStatus(int userStatus){
		this.userStatus = userStatus;
	}

	public int getUserStatus(){
		return userStatus;
	}

	public void setPhone(String phone){
		this.phone = phone;
	}

	public String getPhone(){
		return phone;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}

	public void setUsername(String username){
		this.username = username;
	}

	public String getUsername(){
		return username;
	}

	public UserModel() {
	}

	public UserModel(String firstName, String lastName, String password, int userStatus,
					 String phone, int id, String email, String username) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.userStatus = userStatus;
		this.phone = phone;
		this.id = id;
		this.email = email;
		this.username = username;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		UserModel userModel = (UserModel) o;
		return userStatus == userModel.userStatus &&
				id == userModel.id &&
				Objects.equals(firstName, userModel.firstName) &&
				Objects.equals(lastName, userModel.lastName) &&
				Objects.equals(password, userModel.password) &&
				Objects.equals(phone, userModel.phone) &&
				Objects.equals(email, userModel.email) &&
				Objects.equals(username, userModel.username);
	}


	@Override
 	public String toString(){
		return 
			"UserModel{" + 
			"firstName = '" + firstName + '\'' + 
			",lastName = '" + lastName + '\'' + 
			",password = '" + password + '\'' + 
			",userStatus = '" + userStatus + '\'' + 
			",phone = '" + phone + '\'' + 
			",id = '" + id + '\'' + 
			",email = '" + email + '\'' + 
			",username = '" + username + '\'' + 
			"}";
		}
}