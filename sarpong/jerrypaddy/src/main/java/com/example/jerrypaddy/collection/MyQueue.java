package com.example.jerrypaddy.collection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;

public class MyQueue<T> implements Queue_Interface<T>{
    ArrayList<T> arr = new ArrayList<T>();
    @Override
    public void enqueue(T x) {
        arr.add(x);



    }

    @Override
    public T dequeue() {
        T x = (T) arr.get(0);
        arr.remove(0);
        return x ;
    }
    @Override
    public boolean isEmpty() {
        if (!arr.isEmpty()){
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public int size() {
        return arr.size();
    }

    @Override
    public T first() {
        T x = (T) arr.get(0);
        return x;
    }

    @Override
    public void printQueue() {
        System.out.println(arr);
    }
}
