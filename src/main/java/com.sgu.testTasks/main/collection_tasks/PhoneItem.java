package com.sgu.testTasks.main.collection_tasks;

public class PhoneItem {
    private String phoneNumber;
    private String ownerName;
    private String address;

    public PhoneItem(String phoneNumber, String ownerName, String address) {
        this.phoneNumber = phoneNumber;
        this.ownerName = ownerName;
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public String getAddress() {
        return address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Phone number: " + phoneNumber + "\n"
                + "Owner name: " + ownerName + "\n"
                + "Owner address: " + address + "\n";
    }
}
