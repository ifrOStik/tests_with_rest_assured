package io.swagger.petstore.models.bad_response;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class BadResponse {

    @JsonProperty("code")
    private int code;

    @JsonProperty("type")
    private String type;

    @JsonProperty("message")
    private String message;

    public void setCode(int code){
        this.code = code;
    }

    public int getCode(){
        return code;
    }

    public void setType(String type){
        this.type = type;
    }

    public String getType(){
        return type;
    }

    public void setMessage(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }

    public BadResponse() {
    }

    public BadResponse(int code, String type, String message) {
        this.code = code;
        this.type = type;
        this.message = message;
    }

    @Override
    public String toString(){
        return
            "Response{" +
            "code = '" + code + '\'' +
            ",type = '" + type + '\'' +
            ",message = '" + message + '\'' +
            "}";
    }
}
