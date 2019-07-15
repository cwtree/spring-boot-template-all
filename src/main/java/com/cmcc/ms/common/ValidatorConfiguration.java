package com.cmcc.ms.common;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.hibernate.validator.HibernateValidator;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

/**  
 * ClassName:ValidatorConfiguration <br/>  
 * Function: TODO ADD FUNCTION. <br/>  
 * Reason:   TODO ADD REASON. <br/>  
 * Date:     2019年5月14日 下午2:40:39 <br/>  
 * @author   chiwei  
 * @version    
 * @since    JDK 1.6  
 * @see        
 */
//该注解类比spring xml里的<beans>
@Configuration
@EnableAutoConfiguration
public class ValidatorConfiguration {
    
    /**
     * 
     * methodValidationPostProcessor:(). <br/>  
      
     *  
     * @author chiwei  
     * @return  
     * @since JDK 1.6
     */
    @Bean
    public MethodValidationPostProcessor methodValidationPostProcessor() {
        MethodValidationPostProcessor postProcessor = new MethodValidationPostProcessor();
        postProcessor.setValidator(validator());
        return postProcessor;
    }
    
    /**
     * 
     * validator:(). <br/>  
      
     *  
     * @author chiwei  
     * @return  
     * @since JDK 1.6
     */
    @Bean
    public Validator validator() {
        ValidatorFactory validatorFactory = Validation.byProvider(HibernateValidator.class)
                //.configure().addProperty("hibernate.validator.fail_fast", "true")  true快速返回，一个错误就返回
                .configure().failFast(true).buildValidatorFactory();
        return validatorFactory.getValidator();
    }
}
