import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Scanner;

public class Ex2 {

    public static void main(String[] args) {
        String url = "jdbc:derby://localhost:1527/Angajati";
        String table = "DateAngajati";

        try {
            Scanner s = new Scanner(System.in);
            double min = s.nextDouble();

            var c = DriverManager.getConnection(url);

            var ps = c.prepareStatement("SELECT * FROM " + table + " WHERE salariu >= ?");
            ps.setDouble(1, min);

            ResultSet rs = ps.executeQuery();

            int contor = 0;
            while (rs.next()) {
                Angajat a = new Angajat();
                a.setNume(rs.getString("nume"));
                a.setCnp(rs.getString("cnp"));
                a.setSalariu(rs.getDouble("salariu"));
                a.setVarsta(rs.getInt("varsta"));

                System.out.println(a);
                contor++;
            }

            if (contor == 0) {
                System.out.println("No employees!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

    class Angajat {
        String cnp;
        String nume;
        int varsta;
        double salariu;

        public String getCnp() {
            return cnp;
        }

        public void setCnp(String cnp) {
            this.cnp = cnp;
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

        @Override
        public String toString() {
            return "Angajat{" +
                    "cnp='" + cnp + '\'' +
                    ", nume='" + nume + '\'' +
                    ", varsta=" + varsta +
                    ", salariu=" + salariu +
                    '}';
        }
    }
