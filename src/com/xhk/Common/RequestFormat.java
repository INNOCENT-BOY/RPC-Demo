package com.xhk.Common;
import java.io.Serializable;

public class RequestFormat implements Serializable {

    String className;
    String methodName;
    Class[] paramsType;

    Object[] params;


    public RequestFormat(String className, String methodName, Object... args) {
        this.className = className;
        this.methodName = methodName;
        int len = args.length;
        params = new Object[len];
        paramsType = new Class[len];
        for (int i = 0; i < args.length; i++) {
            paramsType[i] = args[i].getClass();
            params[i] = args[i];
        }
    }
    @Override
    public String toString() {
        String str = this.methodName;
        return str;
    }
    public String getClassName() {
        return className;
    }

    public String getMethodName() {
        return methodName;
    }

    public Class[] getParamsType() {
        return paramsType;
    }

    public Object[] getParams() {
        return params;
    }

}
