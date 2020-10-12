package com.georgeangelov;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class ArrayDeque implements IQueue {

    String[] que;

    public ArrayDeque() {
        this.que = new String[10];
    }

    @Override
    public String poll() {
        String temp = null;
        for (int i=0;i<= que.length-1;i++){
            if (que[i]!=null){
                temp=que[i];
                que[i]=null;
                return temp;
            }
        }
        return null;
    }

    @Override
    public String element() {
        for (int i=0;i<= que.length-1;i++){
            if (que[i]!=null){
                return que[i];
            }
        }
        throw new NoSuchElementException();
    }

    @Override
    public void remove() {
        boolean isRemoved=false;
        for (int i=0;i<= que.length-1;i++){
            if (que[i]!=null){
                que[i]=null;
                isRemoved = true;
                break;
            }
        }
        if (!isRemoved){
            throw new NoSuchElementException();
        }
    }

    @Override
    public String peek() {
        for (int i=0;i<= que.length-1;i++){
            if (que[i]!=null){
                return que[i];
            }
        }
        return null;
    }

    @Override
    public void add(String element) {
        boolean possible = false;
        for (int i = 0;i<que.length;i++){
            if (que[i]==null){
                que[i]=element;
                possible=true;
                break;
            }
        }
        if (!possible){
            throw new IllegalStateException();
        }
    }

    @Override
    public void clear() {
        for (int i=0;i<= que.length-1;i++){
            if (que[i]!=null){
               que[i]=null;
            }
        }
    }

    @Override
    public int size() {
        int counter=0;
        for (int i=0;i< que.length;i++){
            if (que[i]!=null){
                counter++;
            }
        }
        return counter;
    }

    @Override
    public boolean contains(String element) {
        for (int i=0;i<= que.length-1;i++){
            if (element.equals(que[i])){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean offer(String element) {
        boolean possible = false;
        for (int i = que.length-1;i>=0;i--){
            if (que[i]==null){
                que[i]=element;
                possible=true;
                break;
            }
        }
        return possible;
    }

    @Override
    public String toString() {
        return "ArrayDeque{" +
                "que=" + Arrays.toString(que) +
                '}';
    }
}
