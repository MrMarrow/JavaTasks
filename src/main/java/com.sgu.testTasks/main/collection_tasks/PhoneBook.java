package com.sgu.testTasks.main.collection_tasks;

import java.util.ArrayList;
import java.util.List;

public class PhoneBook {

    private List<PhoneItem> phoneItems;

    public PhoneBook() {
        phoneItems = new ArrayList<>();
    }

    public void addPhoneItem(PhoneItem phoneItem) {
        phoneItems.add(phoneItem);
    }

    public void deletePhoneItem(int index) {
        phoneItems.remove(index);
    }

    public List<PhoneItem> getPhoneItems() {
        return phoneItems;
    }

    public PhoneItem getPhoneItemById(int index) {
        try {
            return phoneItems.get(index);
        } catch (Exception e) {
            System.out.println("Некорректный ввод");
            return null;
        }

    }

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();

        PhoneBookInterface phoneBookInterface = new PhoneBookInterface(phoneBook);
        phoneBookInterface.run();

    }
}
