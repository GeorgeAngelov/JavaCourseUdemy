package com.georgeangelov;

public class QueMain {

    public static void main(String[] args) {

//        ArrayDeque queue = new ArrayDeque();
//        System.out.println(queue.peek());
//        for (int i = 1;i<20;i++){
//            queue.offer(""+i);
//        }
//        System.out.println(queue);
//        System.out.println(queue.poll());
//        System.out.println(queue);
//        System.out.println(queue.poll());
//        queue.offer(""+10);
//        queue.offer(""+11);
//        queue.offer(""+12);
//        queue.offer(""+13);
//        System.out.println(queue);
//        System.out.println(queue.peek());
//        System.out.println(queue);

        System.out.println("********************************");

        LinkedListQue listQue = new LinkedListQue();

//        listQue.peek();
     //   listQue.poll();
        for (int i = 20; i > -1; i--) {
            listQue.offer(""+i);
        }

        System.out.println(listQue);
        System.out.println(listQue.poll());
        System.out.println(listQue);
        System.out.println(listQue.peek());
        listQue.offer(""+1);
        System.out.println(listQue);
    }
}
