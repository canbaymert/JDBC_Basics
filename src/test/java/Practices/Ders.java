package Practices;

public class Ders {


    private int id;
    private String ders_name;
    private int egitim_suresi;

    public Ders(int id, String ders_name, int egitim_suresi) {
        this.id = id;
        this.ders_name = ders_name;
        this.egitim_suresi = egitim_suresi;
    }

    public String getDers_name() {
        return ders_name;
    }

    public void setDers_name(String ders_name) {
        this.ders_name = ders_name;
    }

    @Override
    public String toString() {
        return "Ders{" +
                "id=" + id +
                ", ders_name='" + ders_name + '\'' +
                ", egitim_suresi=" + egitim_suresi +
                '}';
    }

    public int getEgitim_suresi() {
        return egitim_suresi;
    }

    public void setEgitim_suresi(int egitim_suresi) {
        this.egitim_suresi = egitim_suresi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;

    }
}
