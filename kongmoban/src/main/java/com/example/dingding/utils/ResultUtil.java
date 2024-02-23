package com.example.dingding.utils;


/**
 * 返回统一格式数据的工具类
 * 1、操作成功,code(100),message(操作成功)，返回数据data
 * 2、操作成功,code(100),message(操作成功)，不返回数据data
 * 3、操作失败,返回code(101)、(102)，message错误消息提示;101是要弹出的提示,102是不弹出的提示;返回data null
 * 4、操作失败,返回code(101)、(102)，message错误消息提示;101是要弹出的提示,102是不弹出的提示;返回data null;
 * 使用枚举类的方式,在枚举类ResultErrorEnum中统一管理了错误的提示信息message和错误码code
 */
public class ResultUtil<T> {


    /**
     * 操作成功,返回数据
     *
     * @param data 返回的数据
     * @return Result
     */
    public static Result success(Object data) {
        Result result = new Result();
        result.setState(100);
        result.setMessage("操作成功!");
        result.setData(data);
        return result;
    }

    /**
     * 操作成功,返回数据和消息提示，适用于批量操作
     *
     * @param data 返回的数据
     * @return Result
     */
    public static Result success(Object data, String message) {
        Result result = new Result();
        result.setState(100);
        result.setMessage(message);
        result.setData(data);
        return result;
    }

    /**
     * 操作成功,不返回数据
     *
     * @return Result
     */
    public static Result success() {
        return success(null);
    }

    /**
     * 操作失败，返回提示
     *
     * @param state   错误码
     * @param message 消息提示
     * @return Result
     */
    public static Result error(Integer state, String message) {
        Result result = new Result();
        result.setState(state);
        result.setMessage(message);
        return result;
    }

    /**
     * 操作失败，返回提示，通过枚举类来获取返回的错误类型
     *
     * @param resultErrorEnum
     * @return
     */
    public static Result error(ResultErrorEnum resultErrorEnum) {
        return error(resultErrorEnum.getState(), resultErrorEnum.getMessage());
    }

    /**
     * 操作失败，返回提示，通过枚举类来获取返回的错误类型
     *
     * @param resultErrorEnum 枚举类
     * @param data            必要的数据
     * @return
     */
    public static Result error(ResultErrorEnum resultErrorEnum, Object data) {
        return error(resultErrorEnum.getState(), resultErrorEnum.getMessage(), data);
    }

    /**
     * 操作失败，返回提示,以及必要的数据
     *
     * @param state   错误码
     * @param message 消息提示
     * @param data    必要的数据
     * @return Result
     */
    public static Result error(Integer state, String message, Object data) {
        Result result = new Result();
        result.setState(state);
        result.setMessage(message);
        result.setData(data);
        return result;
    }
}
