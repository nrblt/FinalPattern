//package com.company;
package Observer;

import java.util.ArrayList;
import java.util.List;

public class Observable implements IObservable {

    private List<Observer> observers=new ArrayList<>();
    private String message;
    private String name;
//    private int score=0;

    public Observable(String name) {
        setName(name);
    }

//    public String getName() {
//        return name;
//    }
//
    public void setName(String name) {
        this.name = name;
    }
//
//    public int getScore() {
//        return score;
//    }
//
//    public void setScore(int score) {
//        this.score = score;
//        sendMessage();
//    }

    @Override
    public void addUser(Observer obj) {
//        if (!observers.contains(obj)) {
            this.observers.add(obj);
//        }
    }

    @Override
    public void deleteUser(Observer obj) {
        observers.remove(obj);

    }

    @Override
    public void sendMessage() {
        for (Observer obj : observers) {
            obj.update(name);
        }
    }

    @Override
    public Object getUpdate(IObserver obj) {
        return null;
    }
}
