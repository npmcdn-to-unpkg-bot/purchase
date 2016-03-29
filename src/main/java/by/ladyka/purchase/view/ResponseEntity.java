package by.ladyka.purchase.view;

import java.io.Serializable;

public class ResponseEntity implements Serializable {

    private boolean success;
    private String message;
    private Object data;

    public ResponseEntity(boolean success, Object data) {
        this.success = success;
        this.message = "";
        this.data = data;
    }

    public ResponseEntity(Object data) {
        this.success = true;
        this.message = "success";
        this.data = data;
    }

    public ResponseEntity(boolean success, String message) {
        this.success = success;
        this.message = message;
        this.data = "Object is empty";
    }

    public ResponseEntity(boolean success, String message, Object data) {
        this.success = success;
        if (success) {
            message = "";
        } else {
            this.message = message;
        }
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
