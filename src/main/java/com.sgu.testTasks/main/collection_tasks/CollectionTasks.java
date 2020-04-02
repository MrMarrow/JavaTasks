package com.sgu.testTasks.main.collection_tasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class CollectionTasks {

    private List<Integer> list;

    public CollectionTasks() {
        list = new ArrayList<>();
    }

    public List<Integer> getList() {
        return list;
    }

    public void add(Integer... integers) {
        list.addAll(Arrays.asList(integers));
    }

    public void sort() {
        list.sort(Comparator.reverseOrder());
    }

    public int getSum() {
        return list.stream().mapToInt(Integer::intValue).sum();
    }

    public boolean isMapHasValue(Map<String, Integer> map, Integer value) {
        return map.containsValue(value);
    }

    public void addValueToStartLinkList(LinkedList<Integer> list, int value) {
        list.addFirst(value);
    }

    public void addValueToEndLinkList(LinkedList<Integer> list, int value) {
        list.addLast(value);
    }

    public Integer findElement(int index) {
        try {
            return list.get(index);
        } catch (Exception e) {
            System.out.println("Unacceptable input");
            return null;
        }
    }

    public static void main(String[] args) {
        CollectionTasks collectionTasks = new CollectionTasks();
        collectionTasks.add(1, 5, 9);
        collectionTasks.sort();
        System.out.println("List after sorting: " + collectionTasks.getList());
        System.out.println("Sum of list elements: " + collectionTasks.getSum());

        Map<String, Integer> map = new HashMap<>();
        map.put("first", 6);
        map.put("second", 5);
        map.put("third", 15);
        int value1 = 5;
        System.out.println("Is map has value " + value1 + ": " + collectionTasks.isMapHasValue(map, value1));
        int value2 = 4;
        System.out.println("Is map has value " + value2 + ": " + collectionTasks.isMapHasValue(map, value2));
        LinkedList<Integer> linkList = new LinkedList<>();
        linkList.add(2);
        linkList.add(3);
        System.out.println("Linked list before adding: " + linkList);
        collectionTasks.addValueToEndLinkList(linkList, 1);
        System.out.println("Linked list after added to end of list: " + linkList);
        collectionTasks.addValueToStartLinkList(linkList, 4);
        System.out.println("Linked list after added to start of list: " + linkList);

        System.out.println(collectionTasks.findElement(9));

    }
}
