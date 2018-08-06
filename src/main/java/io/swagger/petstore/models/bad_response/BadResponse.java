package io.swagger.petstore.models.bad_response;

/**
 * Created by temaustimcik on 2018-07-26.
 */
public class BadResponse {

    private Integer code;
    private String type, message;

    public BadResponse(Integer code, String type, String message) {
        this.code = code;
        this.type = type;
        this.message = message;
    }

    public BadResponse() {
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
