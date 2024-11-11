package entites;

import java.time.LocalDate;

public class Animal {

    private Long id;
    private LocalDate birth;
    private String couleur;

    /** Constructeur vide */
    public Animal() {
    }

    /**
     * Getter
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * Setter
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Getter
     * @return birth
     */
    public LocalDate getBirth() {
        return birth;
    }

    /**
     * Setter
     * @param birth
     */
    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }

    /**
     * Getter
     * @return couleur
     */
    public String getCouleur() {
        return couleur;
    }

    /**
     * Setter
     * @param couleur
     */
    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }
}
