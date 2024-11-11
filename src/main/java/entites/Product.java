package entites;

public class Product {

    private Long id;
    private String code;
    private String label;
    private ProdType type;
    private double price;

    /** Constructeur vide */
    public Product() {
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
     * @return code
     */
    public String getCode() {
        return code;
    }

    /**
     * Setter
     * @param code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Getter
     * @return label
     */
    public String getLabel() {
        return label;
    }

    /**
     * Setter
     * @param label
     */
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * Getter
     * @return type
     */
    public ProdType getType() {
        return type;
    }

    /**
     * Setter
     * @param type
     */
    public void setType(ProdType type) {
        this.type = type;
    }

    /**
     * Getter
     * @return price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Setter
     * @param price
     */
    public void setPrice(double price) {
        this.price = price;
    }
}
