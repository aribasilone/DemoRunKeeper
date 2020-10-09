package com.example.runkeeperdemo;

public class TrophyData {
    private String name;
    private Boolean achieved;
    private String metric;
    private String value;

    public TrophyData(String tName, String tValue, Boolean a){
        name=tName;
        achieved=a;
        value=tValue;
    }

    public String getName(){
        return name;
    }

    public String getValue(){
        return value;
    }

    public Boolean isAchieved(){
        return achieved;
    }
}
