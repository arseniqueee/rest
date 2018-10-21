package rest.response;

import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
import rest.exception.DocsDataNotFoundException;
import rest.exception.UserNotFoundException;


import java.io.Writer;
import java.util.List;

@ControllerAdvice(basePackages = "rest")
public class ResponseHandler implements ResponseBodyAdvice<Object>{

    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return true;
    }


    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        return Response.dataResponse(body);
    }

    @ExceptionHandler(value = DocsDataNotFoundException.class)
    @ResponseBody
    public Result handleDocs(DocsDataNotFoundException ex){
        ErrorDto errorDto = new ErrorDto(ex.getMessage());
        return Result.error(errorDto);
    }

    @ExceptionHandler(value = UserNotFoundException.class)
    @ResponseBody
    public Result handleUser(UserNotFoundException ex){
        ErrorDto errorDto = new ErrorDto(ex.getMessage());
        return Result.error(errorDto);
    }





}
