package rest.response;


import rest.response.dto.ErrorDto;
import rest.response.dto.ResultDto;

public class Response<T> {

    private T data;

//    private ErrorDto error;

    public Response(T data) {
        this.data = data;
    }

//    public Response(ErrorDto error) {
//        this.error = error;
//    }
//
//    public ErrorDto getError() {
//        return error;
//    }
//
//    public void setError(ErrorDto error) {
//        this.error = error;
//    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static Response<ResultDto> success(){
        return new Response<>(new ResultDto("success"));
    }

    public static <R >Response<R> dataResponse(R dataDto){
        return new Response<>(dataDto);
    }

}
