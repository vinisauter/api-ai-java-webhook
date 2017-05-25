package hello.model;

/**
 * Created by Vinicius Sauter on 25/05/2017.
 * ...
 */
public class Status {
    private String errorType;
    private int code;

    public String getErrorType() {
        return errorType;
    }

    public void setErrorType(String errorType) {
        this.errorType = errorType;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
