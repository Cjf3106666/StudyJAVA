package com.cjf.DesignPattern.Observer.Pub_Sub;

import java.util.LinkedList;
import java.util.List;

/**
 * @Descpription 主题
 * @Author CJF
 * @Date 2018/12/18 12:08
 **/
public class Topic {
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<Observer> getObservers() {
        return observers;
    }

    public void setObservers(List<Observer> observers) {
        this.observers = observers;
    }

    private List<Observer> observers = new LinkedList<>();

    public void register(Observer observer) {
        observer.setContent(content);
        observers.add(observer);
    }

    public void exit(Observer observer) {
        observers.remove(observer);
    }

    public void updateContent() {
        for (Observer e : observers
                ) {
            e.setContent(content);
        }
    }
}
