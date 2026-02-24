package org.tds.epsib3;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Banque")
public class Banque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nom", length = 255, nullable = false)
    private String nom;

    // Une banque peut avoir plusieurs clients
    @OneToMany(mappedBy = "banque", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Client> clients = new ArrayList<>();

    //<editor-fold desc="Constructeurs">
    public Banque () {}

    public Banque(String nom) {
        this.nom = nom;
    }
    //</editor-fold>

    //<editor-fold desc="Getter">
    public Integer getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public List<Client> getClients() {
        return clients;
    }
    //</editor-fold>

    //<editor-fold desc="Setter">
    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }
    //</editor-fold>
}
