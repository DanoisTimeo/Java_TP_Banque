package org.tds.epsib3;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nom", length = 100, nullable = false)
    private String nom;

    @Column(name = "prenom", length = 100, nullable = false)
    private String prenom;

    @Column(name = "dateNaissance", nullable = false)
    private LocalDate dateNaissance;

    @Embedded
    Adresse adresse;

    @ManyToOne(optional = false)
    @JoinColumn(name = "banque_id", nullable = false)
    private Banque banque;

    // Relation avec Compte
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Compte> comptes = new ArrayList<>();

    //<editor-fold desc="Constructeurs">
    public Client() {}

    public Client(String nom, String prenom, LocalDate dateNaissance, Adresse adresse, Banque banque) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.adresse = adresse;
        this.banque = banque;
    }
    //</editor-fold>

    //<editor-fold desc="Getter">
    public Integer getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public Banque getBanque() {
        return banque;
    }

    public List<Compte> getComptes() {
        return comptes;
    }
    //</editor-fold>

    //<editor-fold desc="Setter">
    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public void setBanque(Banque banque) {
        this.banque = banque;
    }

    public void setComptes(List<Compte> comptes) {
        this.comptes = comptes;
    }
    //</editor-fold>
}
