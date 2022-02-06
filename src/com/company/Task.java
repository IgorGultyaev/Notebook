package com.company;

import java.util.Date;

public class Task {
    private String note;
    private Date date;

    @Override
    public String toString() {
        return "Task{" +
                "note='" + note + '\'' +
                ", date=" + date +
                '}';
    }

    public Task(String note) {
        this.note = note;
        date = new Date();
    }

}
