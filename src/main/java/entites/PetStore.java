package entites;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Represente un magasin d'animaux, avec des informations de base comme le nom, le nom du gerant,
 * ainsi qu'une relation avec les animaux et les produits associes au magasin
 * Cette entite est mappee a la table "pet_store" dans la base de donnees
 */
@Entity
@Table(name = "pet_store")
public class PetStore implements Serializable {

    /**
     * Identifiant unique du magasin, genere automatiquement
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    /**
     * Nom du magasin d'animaux
     * Longueur maximale : 50 caracteres
     */
    @Column(name = "NAME", length = 50)
    private String name;

    /**
     * Nom du gerant du magasin
     * Longueur maximale : 50 caracteres
     */
    @Column(name = "MANAGER_NAME", length = 50)
    private String managerName;

    /**
     * Ensemble des animaux disponibles dans le magasin
     * Relation OneToMany avec l'entite `Animal`, mappee par l'attribut "animal" dans `Animal`
     */
    @OneToMany(mappedBy = "petStore", cascade = CascadeType.ALL)
    private Set<Animal> animals;

    /**
     * Ensemble des produits disponibles dans le magasin
     * Relation ManyToMany avec l'entite `Product`, utilisant une table de jointure "contient" avec les colonnes
     * "ID_PET_STORE" pour les magasins et "ID_PRODUCT" pour les produits
     */
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "contient",
            joinColumns = @JoinColumn(name = "ID_PET_STORE", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "ID_PRODUCT", referencedColumnName = "ID")
    )
    private Set<Product> products;

    /**
     * Adresse du magasin
     * Relation Embedded avec le composant `Address`
     */
    @Embedded
    private Address address;

    /** Variable presente dans tous les constructeurs */
    {
        products=new HashSet<Product>();
        animals=new HashSet<Animal>();
    }

    /** Constructeru vide */
    public PetStore() {
    }

    /**
     * Construteur parametre
     *
     * @param name
     * @param managerName
     * @param address
     */
    public PetStore(String name, String managerName, Address address) {
        this.name = name;
        this.managerName = managerName;
        this.address = address;
    }

    /**
     * Getter
     *
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * Setter
     *
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Getter
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter
     *
     * @return managerName
     */
    public String getManagerName() {
        return managerName;
    }

    /**
     * Setter
     *
     * @param managerName
     */
    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    /**
     * Getter
     *
     * @return address
     */
    public Address getAddress() {
        return address;
    }

    /**
     * Setter
     *
     * @param address
     */
    public void setAddress(Address address) {
        this.address = address;
    }

    /**
     * Getter
     *
     * @return animals
     */
    public Set<Animal> getAnimals() {
        return animals;
    }

    /**
     * Setter
     *
     * @param animals
     */
    public void setAnimals(Set<Animal> animals) {
        this.animals = animals;
    }

    /**
     * Getter
     *
     * @return products
     */
    public Set<Product> getProducts() {
        return products;
    }

    /**
     * Ajout d'un produit dans petStore
     * @param product
     */
    public void addProduct(Product product){
        products.add(product);
        if (!product.getPetStores().contains(this)) {
            product.addPetStore(this);
        }
    }

    /**
     * Suppression d'un produit dans petStore
     * @param product
     */
    public void removeProduct(Product product){
        products.remove(product);
        if (!product.getPetStores().contains(this)) {
            product.removePetStore(this);
        }
    }

    /**
     * @return Retourne une représentation textuelle d'un PetStore
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PetStore{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", managerName='").append(managerName).append('\'');
        sb.append(", animals=").append(animals);
        sb.append(", products=").append(products);
        sb.append(", address=").append(address);
        sb.append('}');
        return sb.toString();
    }
}
