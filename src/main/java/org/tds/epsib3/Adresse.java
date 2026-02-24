package org.tds.epsib3;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Adresse {
    @Column(name = "numero")
    private Integer numero;

    @Column(name = "rue", length = 100, nullable = false)
    private String rue;

    @Column(name = "codePostal")
    private Integer codePostal;

    @Column(name = "ville", length = 100, nullable = false)
    private String ville;

    //<editor-fold desc="Constructeurs">
    public Adresse() {}

    public Adresse(Integer numero, String rue, Integer codePostal, String ville) {
        this.numero = numero;
        this.rue = rue;
        this.codePostal = codePostal;
        this.ville = ville;
    }
    //</editor-fold>

    //<editor-fold desc="Getter">
    public Integer getNumero() {
        return numero;
    }

    public String getRue() {
        return rue;
    }

    public Integer getCodePostal() {
        return codePostal;
    }

    public String getVille() {
        return ville;
    }
    //</editor-fold>

    //<editor-fold desc="Setter">
    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public void setCodePostal(Integer codePostal) {
        this.codePostal = codePostal;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }
    //</editor-fold>
}