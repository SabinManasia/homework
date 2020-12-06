package dto;

import cache.DataBase;
import lombok.Getter;
import lombok.Setter;
import servicii.IdGenerator;

import java.io.Serializable;

public class CreditBankAccountDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final String CREDIT = "credit";
    @Getter
    private final String id;
    @Getter
    @Setter
    private double usedAmount;
    @Getter
    private final String ownerID;
    @Getter
    @Setter
    private double limitAmount;

    public CreditBankAccountDTO(String ownerID, double limitAmount){
        DataBase<IdGenerator> idGeneratorDataBase = new DataBase<>("idList.dat");
        IdGenerator idGenerator = idGeneratorDataBase.readObject();

        this.id = CREDIT + idGenerator.getCreditIdGenerator();

        idGenerator.setCreditIdGenerator();
        idGeneratorDataBase.writeObject(idGenerator);

        this.usedAmount = 0;
        this.ownerID = ownerID;
        this.limitAmount = limitAmount;
    }

    public void decreaseAmountBy(double amount){
        this.usedAmount -= amount;
    }

    public void increaseAmountBy(double amount){
        this.usedAmount += amount;
    }

    @Override
    public String toString(){
        return "Account: " + id +
                "\nOwner: " + ownerID +
                "\nUsedAmt: " + usedAmount +
                "\nLimit: " + limitAmount;
    }
}
