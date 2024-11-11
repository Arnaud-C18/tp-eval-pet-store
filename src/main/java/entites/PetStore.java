package entites;

public class PetStore {

    private Long id;
    private String name;
    private String managerName;

    /** Constructeru vide */
    public PetStore() {
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
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter
     * @return managerName
     */
    public String getManagerName() {
        return managerName;
    }

    /**
     * Setter
     * @param managerName
     */
    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }
}
