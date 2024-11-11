package executables;

import entites.*;
import enumeration.*;
import jakarta.persistence.*;
import java.time.LocalDate;

public class App {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("petstore");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        PetStore petStore1 = new PetStore("Le royaume du compagnon","Jean",new Address("11","route du Berry","1800","Bourges"));
        PetStore petStore2 = new PetStore("Au bon toutou","Luc",new Address("2","rue des etudes","37000","Tours"));
        PetStore petStore3 = new PetStore("L'animalerie exotique","Reichmann",new Address("23","avenue du boulot","33000","Bordeaux"));
        Cat cat1 = new Cat(LocalDate.of(2017,9,10),"Gris",petStore1,"A0278");
        Cat cat2 = new Cat(LocalDate.of(2020,10,18),"Blanc",petStore2,"32B48");
        Cat cat3 = new Cat(LocalDate.of(2024,2,2),"Noir",petStore3,"G45G4");
        Fish fish1 = new Fish(LocalDate.of(2024,1,1),"Bleu",petStore1, FishLivEnv.FRESH_WATER);
        Fish fish2 = new Fish(LocalDate.of(2023,8,4),"Rouge",petStore2,FishLivEnv.SEA_WATER);
        Fish fish3 = new Fish(LocalDate.of(2024,9,2),"Doré",petStore3,FishLivEnv.SEA_WATER);
        Product product1 = new Product("1","Baton",ProdType.ACCESSORY,5);
        Product product2 = new Product("2","Filtre à aquarium",ProdType.CLEANING,40);
        Product product3 = new Product("3","Graines pour oiseaux",ProdType.FOOD,8.50);

        product1.addPetStore(petStore1);
        product2.addPetStore(petStore2);
        product3.addPetStore(petStore3);
        em.persist(cat1);
        em.persist(cat2);
        em.persist(cat3);
        em.persist(fish1);
        em.persist(fish2);
        em.persist(fish3);

    }
}
