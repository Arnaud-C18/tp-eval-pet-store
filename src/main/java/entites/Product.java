package entites;

import enumeration.ProdType;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Represente un produit vendu dans un magasin d'animaux, avec des attributs comme le code, le label,
 * le type de produit, et le prix.
 * Cette entite est mappee a la table "product" dans la base de donnees.
 */
@Entity
@Table(name = "product")
public class Product implements Serializable {

    /**
     * Identifiant unique du produit, genere automatiquement.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Code unique du produit (longueur maximale : 50 caracteres).
     */
    @Column(name = "CODE", length = 50)
    private String code;

    /**
     * Nom ou label du produit (longueur maximale : 50 caracteres).
     */
    @Column(name = "LABEL", length = 50)
    private String label;

    /**
     * Type de produit, defini par l'enumeration `ProdType`.
     */
    @Column(name = "TYPE")
    private ProdType type;

    /**
     * Prix du produit.
     */
    @Column(name = "PRICE")
    private double price;

    /**
     * Ensemble des magasins d'animaux (PetStore) qui vendent ce produit.
     * Relation ManyToMany mappee par l'attribut "pet_store" dans l'entite `PetStore`.
     */
    @ManyToMany(mappedBy = "products")
    private Set<PetStore> petStores;

    /** Variable presente dans tous les constructeurs */
    {
        petStores=new HashSet<PetStore>();
    }

    /** Constructeur vide */
    public Product() {
    }

    /**
     * Constructeur parametre
     *
     * @param code
     * @param label
     * @param type
     * @param price
     */
    public Product(String code, String label, ProdType type, double price) {
        this.code = code;
        this.label = label;
        this.type = type;
        this.price = price;
    }

    /**
     * Getter
     *
     * @return petStores
     */
    public Set<PetStore> getPetStores() {
        return petStores;
    }

    /**
     * Ajout d'un lien entre un petStore et un product
     * @param petStore
     */
    public void addPetStore(PetStore petStore){
        petStores.add(petStore);
        if (!petStore.getProducts().contains(this)) {
            petStore.addProduct(this);
        }
    }

    /**
     * Suppression d'un lien entre un petStore et un product
     * @param petStore
     */
    public void removePetStore(PetStore petStore){
        petStores.remove(petStore);
        if (!petStore.getProducts().contains(this)) {
            petStore.removeProduct(this);
        }
    }

    /**
     * @return Retourne une représentation textuelle d'un Product
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Product{");
        sb.append("code='").append(code).append('\'');
        sb.append(", label='").append(label).append('\'');
        sb.append(", type=").append(type);
        sb.append(", price=").append(price);
        sb.append('}');
        return sb.toString();
    }
}
