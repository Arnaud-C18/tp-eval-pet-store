package entites;

public class Fish {

    private FishLivEnv livingEnv;

    /** Constructeur vide */
    public Fish() {
    }

    /**
     * Getter
     * @return livingEnv
     */
    public FishLivEnv getLivingEnv() {
        return livingEnv;
    }

    /**
     * Setter
     * @param livingEnv
     */
    public void setLivingEnv(FishLivEnv livingEnv) {
        this.livingEnv = livingEnv;
    }
}
