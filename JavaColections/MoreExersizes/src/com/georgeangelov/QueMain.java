package com.georgeangelov;

public class QueMain {

    public static void main(String[] args) {

        ArrayDeque queue = new ArrayDeque();

//        for (int i = 1;i<=11;i++){
//           // queue.add(""+i);
//            System.out.println(queue.offer(""+i));
//        }

//        System.out.println(queue.poll());
////        queue.remove();
//
//        System.out.println(queue.peek());
////        System.out.println(queue.element());

        for (int i = 1;i<11;i++){
            queue.add(""+i);
        }

        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.toString());
//        queue.add(""+4);
//        queue.add(""+4);
//        queue.add(""+4);
        System.out.println(queue.toString());


//        System.out.println(queue.poll());
//
//
//
        System.out.println(queue.peek());
        queue.remove();
        System.out.println(queue.toString());
//
////        queue.clear();
//        System.out.println(queue.size());
//
//        System.out.println(queue.contains("2"));
//
//        System.out.println(queue.toString());
    }
}
