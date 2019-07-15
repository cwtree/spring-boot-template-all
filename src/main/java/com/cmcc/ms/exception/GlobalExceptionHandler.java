package com.cmcc.ms.exception;

import java.util.Iterator;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cmcc.ms.common.ResMsg;
import com.cmcc.ms.vo.ActionResponse;

import lombok.extern.slf4j.Slf4j;

/**
 * ClassName:GlobalExceptionHandler <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2016年12月9日 上午11:04:38 <br/>
 * 
 * @author chiwei
 * @version
 * @since JDK 1.6
 * @see
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

	/**
	 * 
	 * @param req
	 * @param e
	 * @return
	 * @throws Exception
	 */
	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public ActionResponse handler(HttpServletRequest req, Exception e) throws Exception {
		log.error("统一异常信息 ", e);
        return ActionResponse.result(ResMsg.FAIL.getCode(),
                req.getRequestURL() + "-" + e.getMessage());
	}
	
	/**
	 * 
	 * @param ex
	 * @return
	 */
	@ExceptionHandler(value = ConstraintViolationException.class)
    @ResponseBody
    public ActionResponse constraintException(ConstraintViolationException ex) {
        log.error("统一约束校验异常信息 ", ex);
        Set<ConstraintViolation<?>> constraintViolations = ex.getConstraintViolations();
        Iterator<ConstraintViolation<?>> iterator = constraintViolations.iterator();
        StringBuilder sb = new StringBuilder("");
        while (iterator.hasNext()) {
            ConstraintViolation<?> cvl = iterator.next();
            sb.append(cvl.getMessage());
        }
        return StringUtils.isEmpty(sb.toString()) ? ActionResponse.result(ResMsg.SUCCESS)
                : ActionResponse.result(ResMsg.PARAM_ERROR.getCode(), sb.toString());
    }
}
