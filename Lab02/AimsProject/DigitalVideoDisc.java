public class DigitalVideoDisc {
    private String tilte;
    private String category;
    private String director;
    private int length;
    private float cost;

    public DigitalVideoDisc() {
    }

    public DigitalVideoDisc(String tilte) {
        this.tilte = tilte;
    }

    public DigitalVideoDisc(String tilte, String category, float cost) {
        this.tilte = tilte;
        this.category = category;
        this.cost = cost;
    }

    public DigitalVideoDisc(String tilte, String category, String director, float cost) {
        this.tilte = tilte;
        this.category = category;
        this.director = director;
        this.cost = cost;
    }

    public DigitalVideoDisc(String tilte, String category, String director, int length, float cost) {
        this.tilte = tilte;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;
    }

    public String getTilte() {
        return tilte;
    }

    public String getCategory() {
        return category;
    }

    public String getDirector() {
        return director;
    }

    public int getLength() {
        return length;
    }

    public float getCost() {
        return cost;
    }


}
