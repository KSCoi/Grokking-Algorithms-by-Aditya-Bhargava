package Glava_4.Task4_2;

import java.util.LinkedList;
import java.util.List;

public class RecursiveCountIndexesOfList {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i <16 ; i++) {
            list.add(0);
        }
        System.out.println(countOfIndexses(list));

    }

    public static int countOfIndexses(List<Integer> list){
        if(list.size()==1)
            return 1;
        else
            return 1+countOfIndexses(list.subList(1,list.size()));
    }
}
