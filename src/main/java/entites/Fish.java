package entites;

import enumeration.FishLivEnv;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Represente un poisson, sous-classe de l'entite Animal, avec un environnement de vie specifique
 * Cette entite est mappee a la table "fish" et utilise une cle etrangere "animal_id" pour la jointure avec la table parent "animal"
 */
@Entity
@Table(name = "fish")
public class Fish extends Animal  implements Serializable {

    /**
     * Environnement de vie du poisson, defini a partir de l'enumeration `FishLivEnv`
     * Enregistre dans la colonne "LIVING_ENV" en tant que chaîne de caracteres
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "FISH_LIVING_ENV")
    private FishLivEnv livingEnv;

    /** Constructeur vide */
    public Fish() {
    }

    /**
     * Constructeur parametre
     *
     * @param birth
     * @param couleur
     * @param petStore
     * @param livingEnv
     */
    public Fish(LocalDate birth, String couleur, PetStore petStore, FishLivEnv livingEnv) {
        super(birth, couleur, petStore);
        this.livingEnv = livingEnv;
    }

    /**
     * @return Retourne une représentation textuelle d'un Poisson
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Fish{");
        sb.append("livingEnv=").append(livingEnv);
        sb.append('}');
        return sb.toString();
    }
}
