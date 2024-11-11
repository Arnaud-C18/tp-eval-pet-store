package entites;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Represente un animal avec des informations de base, y compris la date de naissance, la couleur et le magasin d'animaux associe
 * Cette entite est mappee a la table "animal" dans la base de donnees
 * Utilise une strategie d'heritage JOINED pour les sous-classes
 */
@Entity
@Table(name = "animal")
@Inheritance(strategy = InheritanceType.JOINED)
public class Animal  implements Serializable {

    /** Identifiant unique de l'animal, genere automatiquement */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    /** Date de naissance de l'animal */
    @Column(name = "BIRTH")
    private LocalDate birth;

    /** Couleur de l'animal (max 50 caracteres) */
    @Column(name = "COULEUR", length = 50)
    private String couleur;

    /** Magasin d'animaux auquel appartient cet animal, reference par une cle etrangere */
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="PET_STORE_ID")
    private PetStore petStore;

    /** Constructeur vide */
    public Animal() {
    }

    /**
     * Constructeur parametre
     *
     * @param birth
     * @param couleur
     * @param petStore
     */
    public Animal(LocalDate birth, String couleur, PetStore petStore) {
        this.birth = birth;
        this.couleur = couleur;
        this.petStore = petStore;
    }

    /**
     * Setter
     *
     * @param petstore
     */
    public void setPetstore(PetStore petstore) {
        if(this.petStore != null){
            this.petStore.getAnimals().remove(this);
        }
        this.petStore = petstore;
        if (this.petStore == null) {
            this.petStore.getAnimals().add(this);
        }
    }

    /**
     * @return Retourne une représentation textuelle d'un animal
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("naissance=");
        sb.append(", couleur='").append(couleur).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
