package io.swagger.petstore.models.pet;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class Category {

	@JsonProperty("name")
	private String name;

	@JsonProperty("id")
	private int id;

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	@Override
 	public String toString(){
		return 
			"Category{" + 
			"name = '" + name + '\'' + 
			",id = '" + id + '\'' + 
			"}";
		}

	public Category() {
	}

	public Category(String name, int id) {
		this.name = name;
		this.id = id;
	}
}