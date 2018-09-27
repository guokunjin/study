package com.error;

import com.ResultDto;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class AppExceptionMapper implements ExceptionMapper<Exception> {
    public Response toResponse(Exception e) {
        e.printStackTrace();
        Response.ResponseBuilder ResponseBuilder = null;

        if (e instanceof AppException){
            //截取自定义类型
            AppException exp = (AppException) e;
            ResultDto resultDto=new ResultDto(exp.getCode(),exp.getMsg());
            ResponseBuilder = Response.ok(resultDto, MediaType.APPLICATION_JSON);
        }else {
            ResultDto resultDto=new ResultDto(1001,"未知错误");
            ResponseBuilder = Response.ok(resultDto, MediaType.APPLICATION_JSON);
        }
        System.out.println("执行自定义异常");
        return ResponseBuilder.build();
    }
}
