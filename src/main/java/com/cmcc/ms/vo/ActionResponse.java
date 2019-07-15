package com.cmcc.ms.vo;

import com.cmcc.ms.common.ResMsg;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: ActionResponse <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2016年11月15日 上午11:01:38 <br/>
 *
 * @author chiwei
 * @since JDK 1.6
 */
public class ActionResponse implements Serializable {
    /**
     * 序列号
     */
    private static final long serialVersionUID = 1263409874505172235L;

    private static final String RESULT_KEY = "result";

    private static final String REDIRECT_KEY = "redirect";

    private static final String DATA_KEY = "data";

    private static final String PAGE_KEY = "page";

    private static final Map<Integer, String> MESSAGES = new HashMap<>();

    private int status;

    private String message;

    private Map<String, Object> results = new HashMap<String, Object>();

    public ActionResponse(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public ActionResponse(int status, String message, Object data) {
        this.status = status;
        this.message = message;
        results.put(DATA_KEY, data);
    }

    public ActionResponse() {

    }

    /**
     * @param status  status
     * @param message message
     * @return ActionResponse
     */
    public static ActionResponse result(int status, String message) {
        return new ActionResponse(status, message);
    }

    /**
     * @param status  status
     * @param message message
     * @param data    data
     * @return ActionResponse
     */
    public static ActionResponse result(int status, String message, Object data) {
        return new ActionResponse(status, message, data);
    }

    /**
     * @param resMsg resMsg
     * @return ActionResponse
     */
    public static ActionResponse result(ResMsg resMsg) {
        return new ActionResponse(resMsg.getCode(), resMsg.getMsg());
    }

    /**
     * @return ActionResponse
     */
    public static ActionResponse success() {
        return new ActionResponse(ResMsg.SUCCESS.getCode(), ResMsg.SUCCESS.getMsg());
    }

    /**
     * @return ActionResponse
     */
    public static ActionResponse success(Object data) {
        return new ActionResponse(ResMsg.SUCCESS.getCode(), ResMsg.SUCCESS.getMsg(), data);
    }

    public void setStatusAndMessage(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public void setRedirectInResult(Object value) {
        results.put(REDIRECT_KEY, value);
    }

    public void setDataInResult(Object value) {
        results.put(DATA_KEY, value);
    }

    public void setPageInResult(Object value) {
        results.put(PAGE_KEY, value);
    }

    /**
     * @param key
     * @param value
     */
    public void put(String key, Object value) {
        results.put(key, value);
    }

    /**
     * @param values
     */
    public void putAll(Map<String, Object> values) {
        results.putAll(values);
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
        this.message = MESSAGES.get(status);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getResult() {
        if (results.size() == 1) {
            Object result = results.get(RESULT_KEY);
            if (result != null) {
                return result;
            }
        }
        return results;
    }

    public void setResult(Object value) {
        results.put(RESULT_KEY, value);
    }

    @Override
    public String toString() {
        return "ActionResponse [status=" + status + ", message=" + message + ", results=" + results
                + "]";
    }

}
