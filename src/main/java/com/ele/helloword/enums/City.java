package com.ele.helloword.enums;

/**
 * @name: City
 * @author: xiangyf
 * @create: 2019-09-30 11:36
 * @description:
 */
public enum City {
    BEIJING  ("北京", 1),
    HEBEI    ("河北", 2),
    SHANGHAI ("上海", 3),
    GUANGZHOU("广州", 4),
    CHONGQING("重庆", 5),
    CHENGDU  ("成都", 6);

    private String name;
    private Integer index;

    City(String name, Integer index) {
        this.name = name;
        this.index = index;
    }

    public static String getNameByIndex(int index){
        for (City c: City.values()){
            if (c.getIndex() == index){
                return c.getName();
            }
        }
        return null;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }
}
