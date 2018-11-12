package team6.util;

import java.util.ArrayList;
import java.util.List;

public class CartesianProduct {
    /**
     * Returns the cartesian product of lists.
     * 
     * @param lists list of l_1, l_2, ..., l_n where l_i is a list
     * @return l_1 x l_2 x ... x l_n
     * @see https://stackoverflow.com/a/9496234
     */
    public static <T> List<List<T>> evaluate(List<List<T>> lists) {
        List<List<T>> resultLists = new ArrayList<List<T>>();
        if (lists.size() == 0) {
            resultLists.add(new ArrayList<T>());
            return resultLists;
        } else {
            List<T> firstList = lists.get(0);
            List<List<T>> remainingLists = evaluate(lists.subList(1, lists.size()));
            for (T condition : firstList) {
                for (List<T> remainingList : remainingLists) {
                    ArrayList<T> resultList = new ArrayList<T>();
                    resultList.add(condition);
                    resultList.addAll(remainingList);
                    resultLists.add(resultList);
                }
            }
        }
        return resultLists;
    }

    /**
     * Returns the cartesian product of lists.
     * 
     * @param lists list of l_1, l_2, ..., l_n where l_i is a list
     * @return l_1 x l_2 x ... x l_n
     * @see https://stackoverflow.com/a/9496234
     */
    public static <T> List<List<T>> evaluate(List<T> list1, List<T> list2) {
        List<List<T>> resultLists = new ArrayList<List<T>>();
        resultLists.add(list1);
        resultLists.add(list2);
        return evaluate(resultLists);
    }
}