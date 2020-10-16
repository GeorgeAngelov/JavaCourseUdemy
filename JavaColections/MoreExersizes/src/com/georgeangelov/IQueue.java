package com.georgeangelov;

public interface IQueue {

    String poll();
    String peek();
    boolean offer(String element);

}
