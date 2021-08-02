package Glava_4.Task4_bonus;

import java.util.ArrayList;
import java.util.List;

public class QuickSort {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
//        for (int i = 0; i <4 ; i++) {
//            list.add((int)(Math.random()*100));
//        }
        list.add(7);
        list.add(91);
        list.add(72);
        list.add(37);
        list.forEach(System.out::println);
        System.out.println("QUICKSORT:");
        List<Integer> result = quickSort(list);
        for (int i = 0; i< result.size() ; i++) {
            System.out.println(result.get(i));
        }
    }
    public static List<Integer> quickSort(List<Integer> list)    {
        if(list.size()<2)
            return list;
        else   {
            int elem = list.get(0);
            List<Integer> less = new ArrayList<>();
            List<Integer> greater = new ArrayList<>();
            for (int i = 1; i <list.size() ; i++) {
                if(list.get(i)<=elem)
                    less.add(list.get(i));
                else greater.add(list.get(i));
            }
            List<Integer> tmp = quickSort(less);
          tmp.add(elem);
          tmp.addAll(quickSort(greater));
          return tmp;
        }

    }
}
