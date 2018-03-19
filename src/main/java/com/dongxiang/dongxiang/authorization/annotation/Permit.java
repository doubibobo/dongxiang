package com.dongxiang.dongxiang.authorization.annotation;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Permit {
    String[] value() default {};
    String[] authorities() default {};
    String[] modules() default {};
}
