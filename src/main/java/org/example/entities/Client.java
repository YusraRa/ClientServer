package org.example.entities;

public class Client extends User{
    private int clientID;
    private long ID;
    private long CardNum;
    private int cvv;
    private String AccountType;
    //__ paymentlist &&  cancellist

    public long getID() {
        return ID;
    }
    public void setID(long ID) {
        this.ID = ID;
    }

    public long getCardNum() {
        return CardNum;
    }
    public void setCardNum(long cardNum) {
        CardNum = cardNum;
    }

    public int getCvv() {
        return cvv;
    }
    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public String getAccountType() {
        return AccountType;
    }
    public void setAccountType(String accountType) {
        AccountType = accountType;
    }
}
