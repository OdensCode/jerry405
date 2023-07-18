package com.example.jerrypaddy.collection;

import java.util.*;
public interface Queue_Interface<T>{
    public void enqueue(T x);

    public T dequeue();

    public boolean isEmpty();

    public int size();

    public T first();

    public void printQueue();

}
