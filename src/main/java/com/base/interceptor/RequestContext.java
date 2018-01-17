package com.base.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by DaiLiang on 2018/1/13.
 */
public class RequestContext {
    private final static ThreadLocal<HttpServletRequest>  CONTEXT = new ThreadLocal<HttpServletRequest>();



    /**
     *
     * Author: zou yao
     * Description: {绑定Request}
     * Date: 2017/8/3 9:08
     *
     **/
    public static void setRequest(HttpServletRequest request){
        CONTEXT.set(request);
    }


    /**
     *
     * Author: dailiang
     * Description: {取消绑定}
     * Date: 2017/1/13 9:09
     *
     **/
    public static void clear(){
        CONTEXT.remove();
    }


    /**
     *
     * Author: dailiang
     * Description: {获取发到Request}
     * Date: 2017/1/13 9:09
     *
     **/
    public static  HttpServletRequest getRequest(){
        return CONTEXT.get();
    }



    /**
     *
     * Author: dailiang
     * Description: {获取到Session}
     * Date: 2017/1/13 9:09
     *
     **/
    public static HttpSession getSession(){
        return CONTEXT.get() == null ? null : CONTEXT.get().getSession();
    }
}
