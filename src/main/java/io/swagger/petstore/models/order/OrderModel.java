package io.swagger.petstore.models.order;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class OrderModel{

	@JsonProperty("petId")
	private int petId;

	@JsonProperty("quantity")
	private int quantity;

	@JsonProperty("id")
	private int id;

	@JsonProperty("shipDate")
	private String shipDate;

	@JsonProperty("complete")
	private boolean complete;

	@JsonProperty("status")
	private String status;

	public void setPetId(int petId){
		this.petId = petId;
	}

	public int getPetId(){
		return petId;
	}

	public void setQuantity(int quantity){
		this.quantity = quantity;
	}

	public int getQuantity(){
		return quantity;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setShipDate(String shipDate){
		this.shipDate = shipDate;
	}

	public String getShipDate(){
		return shipDate;
	}

	public void setComplete(boolean complete){
		this.complete = complete;
	}

	public boolean isComplete(){
		return complete;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}

	public OrderModel() {
	}

	public OrderModel(int petId, int quantity, int id, String shipDate, boolean complete, String status) {
		this.petId = petId;
		this.quantity = quantity;
		this.id = id;
		this.shipDate = shipDate;
		this.complete = complete;
		this.status = status;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		OrderModel that = (OrderModel) o;

		if (petId != that.petId) return false;
		if (quantity != that.quantity) return false;
		if (id != that.id) return false;
		if (complete != that.complete) return false;
		if (shipDate != null ? !shipDate.equals(that.shipDate) : that.shipDate != null) return false;
		if (status != null ? !status.equals(that.status) : that.status != null) return false;

		return true;
	}

	@Override
 	public String toString(){
		return 
			"OrderModel{" + 
			"petId = '" + petId + '\'' + 
			",quantity = '" + quantity + '\'' + 
			",id = '" + id + '\'' + 
			",shipDate = '" + shipDate + '\'' + 
			",complete = '" + complete + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}