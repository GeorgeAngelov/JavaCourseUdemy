package com.georgeangelov;

import java.util.LinkedList;
import java.util.List;

public class LinkedListQue  implements IQueue{

    private List<String> que;

    public LinkedListQue() {
        this.que = new LinkedList<String>();
    }

    @Override
    public String poll() {
        if (que.isEmpty()){
            System.out.println("Queue is Empty!");
//            throw new NullPointerException();
           return  null;
        }
        String temp = que.get(0);
        que.remove(0);
        return temp;
    }

    @Override
    public String peek() {
        if (que.isEmpty()){
            System.out.println("Queue is Empty!");
            return null;
        }
        if (que.get(0)!=null) {
            return que.get(0);
        }
        return null;
    }

    @Override
    public boolean offer(String element) {
        que.add(element);
        return true;
    }

    @Override
    public String toString() {
        return "LinkedListQue{" +
                "que=" + que +
                '}';
    }
}
