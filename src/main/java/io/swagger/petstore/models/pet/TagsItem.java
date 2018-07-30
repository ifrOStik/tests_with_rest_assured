package io.swagger.petstore.models.pet;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class TagsItem{

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
			"TagsItem{" + 
			"name = '" + name + '\'' + 
			",id = '" + id + '\'' + 
			"}";
		}

	public TagsItem() {

	}

	public TagsItem(String name, int id) {
		this.name = name;
		this.id = id;
	}
}