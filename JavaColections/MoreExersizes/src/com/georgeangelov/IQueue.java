package com.georgeangelov;

public interface IQueue {

    String poll();
    String element();
    void remove();
    String peek();
    void add(String element);
    void clear();
    int size();
    boolean contains(String element);
    boolean offer(String element);

}
