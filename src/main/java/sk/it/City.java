package sk.it;

public class City {
    private final int pop;
    private final String code;
    private final String district;
    private final String name;

    public City(int pop, String code, String district, String name) {
        this.pop = pop;
        this.code = code;
        this.district = district;
        this.name = name;
    }

    public int getPop() {
        return pop;
    }

    public String getCode() {
        return code;
    }

    @Override
    public String toString() {
        return "City{" +
                "pop=" + pop +
                ", code='" + code + '\'' +
                ", district='" + district + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}