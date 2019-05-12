package utils;

import com.google.gson.JsonElement;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter
public class StandardResponse {

    private StatusResponse status;
    private String message;
    private JsonElement students;

    public StandardResponse(StatusResponse status) {
        this.status = status;
    }

    public StandardResponse(StatusResponse status, String message) {
        this.status = status;
        this.message = message;
    }

    public StandardResponse(StatusResponse status, JsonElement students) {
        this.status = status;
        this.students = students;
    }

}
