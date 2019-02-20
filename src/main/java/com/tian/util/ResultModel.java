package com.tian.util;

public class ResultModel<T> {
    private int code = 1;
    private String msg = "";
    private T result;

    //通用错误码
    public static final int SUCCESS = 1;

    public ResultModel(int errCode, String errMsg) {
        this.code = errCode;
        this.msg = errMsg;
    }

    public ResultModel() {

    }

    public static <T> ResultModel<T> success(T result){
        ResultModel<T> response = new ResultModel<T>(SUCCESS, null);
        response.result = result;
        return response;
    }

    public static <T> ResultModel<T> success(String msg){
        return new ResultModel<T>(SUCCESS, msg);
    }

    public static <T> ResultModel<T> success(){
        return new ResultModel<T>(SUCCESS, null);
    }

    public static <T> ResultModel<T> error(int code,String msg){
        ResultModel<T> response = new ResultModel<T>();
        response.setCode(code);
        response.setMsg(msg);
        return response;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
