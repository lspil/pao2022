public class Firma {

    private final String denumire;
    private final int numarAngajati;

    public Firma(String denumire, int numarAngajati) {
        this.denumire = denumire;
        this.numarAngajati = numarAngajati;
    }

    public String getDenumire() {
        return denumire;
    }

    public int getNumarAngajati() {
        return numarAngajati;
    }
}
