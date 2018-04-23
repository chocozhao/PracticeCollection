package com.example.uitest.DBTest;

/**
 *  black_number表对应的实体类
 * Created by chocozhao on 2018/3/20.
 */

public class BlackNumber {
    private String number;
    private int id;

    public BlackNumber(int id, String number) {
    }

    public BlackNumber(String number, int id) {
        this.number = number;
        this.id = id;
    }


    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "BlackNumber{" +
                "number='" + number + '\'' +
                ", id=" + id +
                '}';
    }
}
