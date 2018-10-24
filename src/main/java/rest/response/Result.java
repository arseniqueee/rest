package rest.response;

/**
 * Result class
 */
public class Result {

    private String result;

    private ErrorDto error;

    public Result(String result) {
        this.result = result;
    }

    public Result(ErrorDto error) {
        this.error = error;
    }

    public ErrorDto getError() {
        return error;
    }

    public void setError(ErrorDto error) {
        this.error = error;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public static Result success(){
        return new Result("success");
    }

    public static Result error(ErrorDto error){
        return new Result(error);
    }
}
