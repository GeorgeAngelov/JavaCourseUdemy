package com.georgeangelov;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class ArrayDeque implements IQueue {

    private String[] que;

    public ArrayDeque() {
        this.que = new String[5];
    }

    private String[] extendArray(){
        String[] temp = new String[que.length*2];
        for (int i = 0;i< que.length;i++){
            temp[i] = que[i];
        }
        que = new String[temp.length*2];
        for (int i = 0; i < temp.length; i++) {
            que[i] = temp[i];
        }
        return que;
    }

    private String[] shiftItems(){
        String [] temp = new String[que.length];
        int counter = 0;
        for (int i = 0;i<que.length;i++){
            if (que[i]!=null){
                temp[counter] = que[i];
                counter++;
            }
        }
        return temp;
    }

    @Override
    public String poll() {
//        for (int i = 0;i<= que.length;i++){
//            if (que[i]==null){
//                que = shiftItems();
//            }
//            if (que[i]!= null){
//                String temp = que[i];
//                que[i]= null;
//                que = shiftItems();
//                return temp;
//            }
//        }
        String temp = que[0];
        if (que[0]==null){
                que = shiftItems();
        }
        que[0] = null;
        que = shiftItems();

        return temp;
    }

    @Override
    public String peek() {
        if (que[0]!=null){
            return que[0];
        }
        return null;
    }

    @Override
    public boolean offer(String element) {
        for (int i = 0;i<= que.length;i++){
            if ((i== que.length-1) && (que[i] != null)){
                extendArray();
            }else if (que[i] == null){
                que[i] = element;
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "ArrayDeque{" +
                "que=" + Arrays.toString(que) +
                '}';
    }
}
