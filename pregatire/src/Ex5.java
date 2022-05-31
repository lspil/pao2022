import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Ex5 {

    public static void main(String[] args) {
        List<Suvenir> list = new ArrayList<>();

        Map<String, List<Suvenir>> result1 =
            list.stream()
                    .collect(Collectors.groupingBy(x -> x.material));


        Map<String, Set<Suvenir>> result3 =
                list.stream()
                        .collect(
                                Collectors.groupingBy(x -> x.material,
                                        Collectors.toSet()));

        Map<String, List<String>> result4 =
                list.stream()
                        .collect(
                                Collectors.groupingBy(x -> x.material,
                                        Collectors.mapping(a -> a.denumire,
                                                Collectors.toList())));
    }
}

class Suvenir {

    String denumire;
    String material;
}
