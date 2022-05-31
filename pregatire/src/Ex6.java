import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Ex6 {



}

class CitireScrierePersoane {
    private static CitireScrierePersoane citireScrierePersoane;

    private String fisier;
    private List<Persoana> persoane;


    private CitireScrierePersoane(String fisier, List<Persoana> persoane) {
        this.fisier = fisier;
        this.persoane = persoane;
    }


    public static synchronized CitireScrierePersoane getInstance(String fisier, List<Persoana> persoane) {
        if (citireScrierePersoane == null) {
            citireScrierePersoane = new CitireScrierePersoane(fisier, persoane);
        }
        return citireScrierePersoane;
    }

    public List<Persoana> readPersonFromFile() {
        try {
            return Files.lines(Path.of(fisier))
                    .map(s -> s.split(","))
                    .map(r -> new Persoana(
                            r[0],
                            Integer.parseInt(r[1]),
                            Double.parseDouble(r[2])
                    )).collect(Collectors.toCollection(ArrayList::new));
        } catch (IOException e) {
            return List.of();
        }
    }

    public void savePersonList() {
        var result = persoane.stream()
                .map(p -> p.getNume() + "," + p.getVarsta() + "," + p.getSalariu() + "\n")
                .collect(Collectors.joining());

        try {
            PrintStream out = new PrintStream(fisier);
            out.print(result);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

class Persoana {
    String nume;
    int varsta;
    double salariu;

    public Persoana(String nume, int varsta, double salariu) {
        this.nume = nume;
        this.varsta = varsta;
        this.salariu = salariu;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public int getVarsta() {
        return varsta;
    }

    public void setVarsta(int varsta) {
        this.varsta = varsta;
    }

    public double getSalariu() {
        return salariu;
    }

    public void setSalariu(double salariu) {
        this.salariu = salariu;
    }
}
