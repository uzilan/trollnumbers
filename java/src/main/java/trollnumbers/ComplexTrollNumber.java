package trollnumbers;

import java.util.List;
import java.util.stream.Collectors;

public class ComplexTrollNumber extends TrollNumber {

    private final List<Integer> values;

    ComplexTrollNumber(List<Integer> values) {
        super(values.stream().mapToInt(Integer::intValue).sum());
        this.values = values;
    }

    @Override
    public String toString() {
        return values.stream()
                .map(v -> new TrollNumber(v).toString())
                .collect(Collectors.joining("-"));
    }
}
