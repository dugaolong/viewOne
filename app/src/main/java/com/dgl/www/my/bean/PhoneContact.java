package com.dgl.www.my.bean;

/**
 * Created by dugaolong on 16/8/19.
 */
public class PhoneContact {

    private String name;
    private int hasNumber;
    private int contactId;
    private String sortKey;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getSortKey() {
        return sortKey;
    }

    public void setSortKey(String sortKey) {
        this.sortKey = sortKey;
    }

    public int getHasNumber() {
        return hasNumber;
    }

    public void setHasNumber(int hasNumber) {
        this.hasNumber = hasNumber;
    }

    public int getContactId() {
        return contactId;
    }

    public void setContactId(int contactId) {
        this.contactId = contactId;
    }


    @Override
    public String toString() {
        return "TxrjContact{" +
                "name='" + name + '\'' +
                ", hasNumber=" + hasNumber +
                ", contactId=" + contactId +
                ", sortKey='" + sortKey + '\'' +
                '}';
    }
}
