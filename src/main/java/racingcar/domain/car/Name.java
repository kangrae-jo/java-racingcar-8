package racingcar.domain.car;

public class Name {

    private static final int LENGTH_LIMIT = 5;
    private final String name;

    public Name(String name) {
        name = name.trim();
        validateName(name);
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    private void validateName(String name) {
        if (name.isEmpty() || name.length() > LENGTH_LIMIT) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 1자 이상 5자 이하입니다.");
        }
    }

}
