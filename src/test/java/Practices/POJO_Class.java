package Practices;

public class POJO_Class {


    private int id;
    private String class_name;
    private int education_period;

    public POJO_Class(int id, String class_name, int education_period) {
        this.id = id;
        this.class_name = class_name;
        this.education_period = education_period;
    }

    public String getclass_name() {
        return class_name;
    }

    public void setclass_name(String class_name) {
        this.class_name = class_name;
    }

    @Override
    public String toString() {
        return "Class{" +
                "id=" + id +
                ", class_name='" + class_name + '\'' +
                ", education_period=" + education_period +
                '}';
    }

    public int geteducation_period() {
        return education_period;
    }

    public void seteducation_period(int education_period) {
        this.education_period = education_period;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;

    }
}
