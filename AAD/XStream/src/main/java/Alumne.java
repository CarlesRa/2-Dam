import com.thoughtworks.xstream.annotations.XStreamAlias;

public class Alumne {
    @XStreamAlias("Nombre")
    private String nom;
    @XStreamAlias("Apellido")
    private String cognom;
    @XStreamAlias("Edad")
    private int esdad;
    @XStreamAlias("Nota")
    private Double nota;

    public Alumne(String nom, String cognom, int esdad, Double nota) {
        this.nom = nom;
        this.cognom = cognom;
        this.esdad = esdad;
        this.nota = nota;
    }

    public Alumne() {
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCognom() {
        return cognom;
    }

    public void setCognom(String cognom) {
        this.cognom = cognom;
    }

    public int getEsdad() {
        return esdad;
    }

    public void setEsdad(int esdad) {
        this.esdad = esdad;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "Alumne{" +
                "nom='" + nom + '\'' +
                ", cognom='" + cognom + '\'' +
                ", esdad=" + esdad +
                ", nota=" + nota +
                '}';
    }
}
