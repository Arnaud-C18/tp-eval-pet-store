package entites;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

/**
 * Represente une adresse physique, utilisee comme un composant embarqué dans l'entite PetStore
 * Elle contient le numero, la rue, le code postal et la ville
 */
@Embeddable
public class Address  implements Serializable {
    private Long id;
    private String number;
    private String street;
    private String zipCode;
    private String city;

    /** Constrcteur vide */
    public Address(){
    }

    /**
     * Constrcteur parametre
     *
     * @param number
     * @param street
     * @param zipCode
     * @param city
     */
    public Address(String number, String street, String zipCode, String city) {
        this.number = number;
        this.street = street;
        this.zipCode = zipCode;
        this.city = city;
    }

    /**
     * Retourne une représentation textuelle de l'adresse
     *
     * @return Chaîne décrivant l'adresse
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Address{");
        sb.append("id=").append(id);
        sb.append(", number='").append(number).append('\'');
        sb.append(", street='").append(street).append('\'');
        sb.append(", zipCode='").append(zipCode).append('\'');
        sb.append(", city='").append(city).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
