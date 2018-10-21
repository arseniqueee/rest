package rest.response;




public class Response<T> {

    private T data;



    public Response(T data) {
        this.data = data;
    }



    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static <R> Response<R> dataResponse(R data){
        return new Response<>(data);
    }

}
