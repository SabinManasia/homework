package dto;

import cache.DataBase;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import servicii.IdGenerator;

import java.io.Serializable;


public class DebitBankAccountDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final String DEBIT = "debit";
    private static final String RODBT = "RODBT";
    private static int IBANGenerator = 1000000;
    @Getter
    private final String id;
    @Getter
    private final String IBAN;
    @Getter
    @Setter
    private double amount;
    @Getter
    private final String ownerID;

    public DebitBankAccountDTO(String ownerID){
        DataBase<IdGenerator> idGeneratorDataBase = new DataBase<IdGenerator>("idList.dat");
        IdGenerator idGenerator = idGeneratorDataBase.readObject();

        this.id = DEBIT + idGenerator.getDebitIdGenerator();
        this.IBAN = RODBT + IBANGenerator + idGenerator.getDebitIdGenerator();

        idGenerator.setDebitIdGenerator();
        idGeneratorDataBase.writeObject(idGenerator);

        this.amount = 0;
        this.ownerID = ownerID;
    }

    public void decreaseAmountBy(double amount){
        this.amount -= amount;
    }

    public void increaseAmountBy(double amount){
        this.amount += amount;
    }

    @Override
    public String toString() {
        return "Account id: " + this.id +
                "\nIBAN: " + this.IBAN +
                "\nOwner: " + this.ownerID +
                "\nAmount " + this.amount + "\n";
    }
}
