package org.tds.epsib3;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu"); EntityManager em = emf.createEntityManager();) {
            em.getTransaction().begin();

            //<editor-fold desc="Création de la banque">
            Banque banque = new Banque("BNP");
            em.persist(banque);
            //</editor-fold>

            //<editor-fold desc="Création des clients avec un compte commun">
            Adresse adresseCommune = new Adresse(10,"Rue A",75000,"Paris");

            Client client1 = new Client("Dori", "Po",
                    LocalDate.of(1990,1,1),
                    adresseCommune,
                    banque);

            Client client2 = new Client("Dori", "Pi",
                    LocalDate.of(1990,1,1),
                    adresseCommune,
                    banque);

            em.persist(client1);
            em.persist(client2);

            // Insérer un compte associé à 2 clients
            LivretA compteCommun = new LivretA("C100", 5000, 2.0);

            client1.getComptes().add(compteCommun);
            client2.getComptes().add(compteCommun);

            compteCommun.getClients().add(client1);
            compteCommun.getClients().add(client2);

            em.persist(compteCommun);
            //</editor-fold>

            //<editor-fold desc="Un client avec 2 comptes">
            Client client3 = new Client(
                    "Pierre",
                    "Alexandre",
                    LocalDate.of(1999, 3, 15),
                    new Adresse(30, "Rue B", 13000, "Marseille"),
                    banque
            );

            em.persist(client3);

            // Compte Assurance Vie
            AssuranceVie assuranceVie = new AssuranceVie(
                    "AV200",
                    10000,
                    2.5,
                    java.time.LocalDateTime.of(2030, 12, 31, 0, 0)
            );
            // relation many-to-many
            client3.getComptes().add(assuranceVie);
            assuranceVie.getClients().add(client3);

            em.persist(assuranceVie);

            // Compte Livret A
            LivretA livretA = new LivretA("LA300", 4000, 3.0);
            client3.getComptes().add(livretA);
            livretA.getClients().add(client3);

            em.persist(livretA);
            //</editor-fold>

            //<editor-fold desc="Insérer des opérations de type opérations sur un compte">
            Operation operation1 = new Operation(
                    java.time.LocalDateTime.now(),
                    500,
                    "Depot espece",
                    livretA
            );

            Operation operation2 = new Operation(
                    java.time.LocalDateTime.now(),
                    200,
                    "Retrait",
                    livretA
            );

            em.persist(operation1);
            em.persist(operation2);
            //</editor-fold>

            //<editor-fold desc="Insérer des opérations de type virements">
            Virement virement1 = new Virement(
                    java.time.LocalDateTime.now(),
                    930,
                    "Virement salaire",
                    assuranceVie,
                    "Entreprise X"
            );

            Virement virement2 = new Virement(
                    java.time.LocalDateTime.now(),
                    500,
                    "Virement loyer",
                    assuranceVie,
                    "Proprietaire"
            );

            em.persist(virement1);
            em.persist(virement2);
            //</editor-fold>

            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("oups");
            throw new RuntimeException(e);
        }
    }
}