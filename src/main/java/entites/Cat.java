package entites;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Represente un chat, sous-classe de l'entite Animal, avec un identifiant de puce electronique
 * Cette entite est mappee a la table "cat" et utilise une cle etrangère "animal_id" pour la jointure avec la table parent "animal"
 */
@Entity
@Table(name = "cat")
@PrimaryKeyJoinColumn(name = "animal_id")  // Jointure avec la cle primaire de la table "animal".
public class Cat extends Animal  implements Serializable {

    /**
     * Identifiant de la puce electronique du chat, unique et de type chaîne de caracteres
     * Enregistre sous forme de chaîne dans la colonne "CHIP_ID" avec une longueur maximale de 50
     */
    @Column(name = "CHIP_ID", length = 50)
    private String chipId;

    /** Constructeur vide */
    public Cat() {
        super();
    }

    /**
     * Constructeur parametre
     *
     * @param birth
     * @param color
     * @param petstore
     * @param chipId
     */
    public Cat(LocalDate birth, String color, PetStore petstore, String chipId) {
        super(birth, color, petstore);
        this.chipId = chipId;
    }

    /**
     * @return Retourne une représentation textuelle d'un Chat
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Chat{");
        sb.append(super.toString());
        sb.append("chipId='").append(chipId).append('\'');
        sb.append("}\n");
        return sb.toString();
    }

}
