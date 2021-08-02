package Glava_4.Task4_3;

import java.util.LinkedList;
import java.util.List;

public class RecursiveMaxElementOfList {

    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i <6 ; i++) {
            list.add((int)(Math.random()*500));
        }
        list.forEach(System.out::println);
        System.out.println("MAX IS " + findMax(list));
    }
    public static int findMax(List<Integer> list)   {
        if(list.size()==2)  {
            return list.get(0)>list.get(1)? list.get(0):list.get(1);
        }
        int subMax = findMax(list.subList(1,list.size()));
        return list.get(0)>subMax?list.get(0) : subMax;
    }
}

