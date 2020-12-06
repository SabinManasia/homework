package utilizatori;

public class ClientPJ extends Client {


    private static final String PJ = "PJ";
    private final String CUI;
    private String numeCompanie;
    private double costTranzactie = 0.1;


    public ClientPJ(String userName, String initialPassword, double income, String CUI, String numeCompanie){
        super(PJ, userName, initialPassword, income);
        this.CUI = CUI;
        this.numeCompanie = numeCompanie;
    }

    public String getCUI() {
        return CUI;
    }

    public String getNumeCompanie() {
        return numeCompanie;
    }

    public void setNumeCompanie(String numeCompanie) {
        this.numeCompanie = numeCompanie;
    }

    public double getCostTranzactie() {
        return costTranzactie;
    }

    public void setCostTranzactie(double costTranzactie){
        this.costTranzactie = costTranzactie;
    }

    @Override
    public String toString(){
        return "PJ, user: " + super.getUserName() + "\n";
    }


}
