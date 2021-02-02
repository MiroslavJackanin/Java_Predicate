package sk.it;

import java.util.function.Predicate;

public class FromNetherlands<C> implements Predicate<City> {
    @Override
    public boolean test(City city) {
        return city.getCode().equals("NLD");
    }
}