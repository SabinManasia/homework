package servicii;

import java.io.Serializable;

public class IdGenerator implements Serializable {

    private static final long serialVersionUID = 1L;
    private int debitIdGenerator = 0;
    private int creditIdGenerator = 0;
    private int clientId = 0;

    public int getDebitIdGenerator() {
        return this.debitIdGenerator;
    }

    public void setDebitIdGenerator() {
        this.debitIdGenerator++;
    }

    public int getCreditIdGenerator() {
        return this.creditIdGenerator;
    }

    public void setCreditIdGenerator() {
        this.creditIdGenerator++;
    }

    public int getClientId() {
        return this.clientId;
    }

    public void setClientId() {
        this.clientId++;
    }


    @Override
    public String toString(){
        return "debit id: " + this.debitIdGenerator +
                "\ncredit id: " + this.creditIdGenerator +
                "\nclient id: " + this.clientId;
    }

}
