package com.w15104.dataengine.study.basic;

/*
 *
 * @Description 返回结果封装工具操作类
 *
 * @author w15104
 * @data: 2019-3-5
 *
 * @modified by:
 * @modified date:
 * @modified no:
 */
public class ResultUtil {


    private ResultUtil(){}


    /**
     * 构造成功报文
     * @param data 报文内容
     * @return T
     */
    public static <T> Result<T> ok(T data){
        return new Result<T>().setResult(true).setData(data);
    }

    /**
     * 构造成功报文
     * @return T
     */
    public static <T> Result<T> ok(){
        return new Result<T>().setResult(true);
    }

    /**
     * 构造失败报文
     * @param code 错误码
     * @return T
     */
    public static <T> Result<T> error(ErrorCode code){
        return new Result<T>().setResult(false).setCode(code);
    }

}
