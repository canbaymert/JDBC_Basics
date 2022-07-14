public class Urun {

    private int id;
    private String name;
    private double fiyat;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }

    public double getFiyat() {
        return fiyat;
    }

    public void setFiyat(double fiyat) {
        this.fiyat = fiyat;
    }

    public Urun(int id, String name, double fiyat) {
        this.id = id;
        this.name = name;
        this.fiyat = fiyat;
    }

    @Override
    public String toString() {
        return "Urun{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", fiyat=" + fiyat +
                '}';
    }


}
