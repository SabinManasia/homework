package utilizatori;

import cache.DataBase;
import dto.CreditBankAccountDTO;
import dto.DebitBankAccountDTO;
import lombok.Getter;
import lombok.Setter;
import servicii.IdGenerator;

import java.io.Serializable;
import java.util.ArrayList;


public abstract class Client implements Serializable {

    private static final long serialVersionUID = 1L;
    @Getter
    private final String id;
    @Getter
    private final String userName;
    @Getter
    @Setter
    private String password;
    @Getter
    @Setter
    private ArrayList<DebitBankAccountDTO> debitAccountList;
    @Getter
    @Setter
    private ArrayList<CreditBankAccountDTO> creditAccountList;
    @Getter
    @Setter
    private double income;

    public Client(String id, String userName, String initialPassword, double income){
        DataBase<IdGenerator> idGeneratorDataBase = new DataBase<IdGenerator>("idList.dat");
        IdGenerator idGenerator = idGeneratorDataBase.readObject();

        this.id = id + idGenerator.getClientId();
        idGenerator.setClientId();
        idGeneratorDataBase.writeObject(idGenerator);

        this.userName = userName;
        this.income = income;
        this.debitAccountList = new ArrayList<DebitBankAccountDTO>();
        this.creditAccountList = new ArrayList<CreditBankAccountDTO>();
    }

    public void addDebitAccountDTO(DebitBankAccountDTO dbtAccount){
        this.debitAccountList.add(dbtAccount);
    }

    public void addCreditAccountDTO(CreditBankAccountDTO crdAccount){
        this.creditAccountList.add(crdAccount);
    }

    public DebitBankAccountDTO getDebitAccountByIban(String Iban){
        for(DebitBankAccountDTO dbt : this.debitAccountList){
            if(dbt.getIBAN().equalsIgnoreCase(Iban)){
                return dbt;
            }
        }
        System.out.println("IBAN not found");
        return null;
    }

    public CreditBankAccountDTO getCreditAccountById(String id){
        for (CreditBankAccountDTO crd : this.creditAccountList) {
            if(crd.getId().equalsIgnoreCase(id)){
                return crd;
            }
        }
        System.out.println("Credit Account Id not found!");
        return null;
    }

}
