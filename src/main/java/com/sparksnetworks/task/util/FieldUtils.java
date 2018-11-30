package com.sparksnetworks.task.util;

/**
 * @author Maroju, Jithender on 30/11/18
 */
public class FieldUtils {

    public static <T,K> boolean isNotNull(T obj1, K obj2){
        return obj1 != null && obj2 != null;
    }

    public static <T,K> boolean isNull(T obj1, K obj2){
        return obj1 == null && obj2 == null;
    }

    public static <T> boolean isNotNull(T obj){
        return obj != null;
    }

    public static <T> boolean isNull(T obj){
        return obj == null;
    }

    public static <T> T getValue(T obj){
        return obj != null ? obj : null;
    }
}
