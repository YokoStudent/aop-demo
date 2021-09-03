package pers.yoko.aopdemo.advice;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author yoko
 * @date 2021/9/3 14:13
 * @since 1.0
 */
public class LogResutlAdvice implements AfterReturningAdvice {
    @Override
    public void afterReturning(Object returnVal, Method method, Object[] objects, Object target) {
        System.out.println("执行方法：" + method.getName() + ",参数列表:" + Arrays.toString(objects) + ",返回结果:" + returnVal);
    }


    public static void main(String[] args) {
        String sql = "update tbl_channel_kind_config t set t.max_term_count='{\"000\":\"%s\"}' where t.hx_channel_kind='%s';";
        String str = "'10':'1','11':'1','12':'1','13':'1','21':'1','22':'1','14':'1','24':'1','25':'1','16':'2','26':'2','17':'1','27':'1','15':'1','18':'1','28':'1','19':'15','29':'1','1b':'1','1c':'1','1d':'1','1e':'15','2c':'1','2d':'1','1k':'2','2k':'2','1f':'15','2m':'2','2n':'2','1m':'2','1n':'2'";
        String[] split = str.split(",");
        for (String s: split){
            String[] split1 = s.replaceAll("'", "").split(":");
            String out = String.format(sql,split1[1],split1[0]);
            System.out.println(out);
        }
    }
}
