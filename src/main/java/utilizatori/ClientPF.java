package utilizatori;

public class ClientPF extends Client{

    private static final String PF = "PF";
    private final String CNP;
    private String nume;
    private String prenume;

    public ClientPF(String userName, String initialPassword, double income, String CNP, String nume, String prenume){
        super(PF, userName, initialPassword, income);
        this.CNP = CNP;
        this.nume = nume;
        this.prenume = prenume;
    }
    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getCNP() {
        return CNP;
    }

    @Override
    public String toString(){
        return "PF, user: " + super.getUserName() + "\n";
    }

}
