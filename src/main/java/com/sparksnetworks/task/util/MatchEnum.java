package com.sparksnetworks.task.util;

/**
 * @author Maroju, Jithender on 28/11/18
 */
public enum MatchEnum {

    YES("yes"),
    NO("no"),
    ALL("all");

    String value;

    public String getValue() {
        return value;
    }

    MatchEnum(String value){
        this.value = value;
    }

    public static String getMatchEnum(String filterType){
        for (MatchEnum matchEnum : values()){
            if(matchEnum.getValue().equals(filterType))
                return filterType;
        }
        return ALL.getValue();
    }

    public static boolean isValidFilter(String filterType){
        for (MatchEnum matchEnum : values()){
            if(matchEnum.getValue().equals(filterType))
                return true;
        }
        return false;
    }
}
