package racingcar.domain.car;

public class Name {

    private static final int LENGTH_LIMIT = 5;
    private final String name;

    public Name(String name) {
        name = name.trim();
        validateNameLength(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void validateNameLength(String name) {
        if (name.isEmpty() || name.length() > LENGTH_LIMIT) {
            throw new IllegalArgumentException(String.format("[ERROR] 자동차 이름은 1자 이상 %d자 이하입니다.", LENGTH_LIMIT));
        }
    }

}
