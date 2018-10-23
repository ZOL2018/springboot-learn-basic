package com.basic.learn15.validator;

import com.basic.learn15.entity.ValidatorEntity;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class FlagValidatorClass implements ConstraintValidator<FlagValidator, Object> {
    //临时变量保存flag值列表
    private String values;

    @Override
    public void initialize(FlagValidator flagValidator) {
        //将注解内配置的值赋值给临时变量
        this.values = flagValidator.values();
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        //分割定义的有效值
        String[] value_array = values.split(",");
        boolean isFlag = false;
        //遍历比对有效值
        for (int i =0;i<value_array.length;i++)
        {
            //o 是 传入需要验证的参数
            //存在一致跳出循环，赋值isFlag=true
            if(value_array[i].equals(o))
            {
                isFlag = true;
                break;
            }
        }
        System.out.println(isFlag);
        //返回是否存在boolean
        return isFlag;
    }
}
