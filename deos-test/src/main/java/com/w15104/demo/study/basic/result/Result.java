package com.w15104.demo.study.basic.result;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.w15104.demo.study.basic.exception.ErrorCode;

import java.io.Serializable;


/*
 * @Description 统一返回
 *
 * @author w15104
 * @data: 2019-3-5
 *
 * @modified by:
 * @modified date:
 * @modified no:
 */
@JsonInclude
public class Result<T> implements Serializable {

    /**
	 * 序列化
	 */
	private static final long serialVersionUID = -3875991610101457115L;
	
	/**
     * 成功标志
     */
    private boolean status;

    /**
     * 错误码
     */
    private ErrorCode code;

    /**
     * 成功时的数据集
     */
    private T data;

    /**
     * 中文错误信息
     */
    private String msg;

    public T getData() {
        return data;
    }

    public Result<T> setData(T data){
        this.data = data;
        return  this;
    }

    public String getMsg() {
        return msg;
    }

    public Result<T> setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public boolean getStatus(){
        return status;
    }

    public Result<T> setStatus(boolean status) {
        this.status = status;
        return this;
    }

    public ErrorCode getCode(){
        return code;
    }


    public Result<T> setCode(ErrorCode code) {
        this.msg = code.getMessageCN();
        this.code = code;
        return this;
    }

    @Override
    public String toString() {
        return "Result{" +
                "status=" + status +
                ", code=" + code +
                ", data=" + data +
                ", msg='" + msg + '\'' +
                '}';
    }
}
