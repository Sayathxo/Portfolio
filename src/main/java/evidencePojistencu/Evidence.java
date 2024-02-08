package evidencePojistencu;
import java.util.ArrayList;

/**
 * Třída obsahuje evidenci pojištěnců
 * autor: Slámová Lenka
 */
public class Evidence {
    /**
     * list k zapisování nových pojištěnců
     */
    private ArrayList<Pojistenec> pojistenci;

    /**
     * vytvoří novou instanci evidence s novou databází objektů Pojistenec
     */
    public Evidence() {
        pojistenci = new ArrayList<>();
    }

    /**
     * přidá nového pojištěnce do evidence
     */
    public void pridatPojistence(String jmeno, String prijmeni, int vek, String telefon) {
        pojistenci.add(new Pojistenec(jmeno, prijmeni, vek, telefon));
    }

    /**
     * vypíše aktuální záznamy o všech pojištěncích v evidenci
     */
    public String vypisVsechnyPojistence() {
        String output = "";
        if (!(pojistenci.isEmpty())) {
            for (Pojistenec zaznam : pojistenci) {
                output += zaznam + "\n";
            }
        } else {
            output += "Evidence je zatím prázdná, prosím přidejte záznam.";
        }
        return output;
    }

    /**
     * vyhledá záznam o pojištěnci podle jména a příjmení
     */
    public String vyhledejZaznamOPojistenci(String jmeno, String prijmeni) {
        boolean nalezeno = false;
        String hledanyPojistenec = "";

        if (!(pojistenci.isEmpty())) {
            for (Pojistenec zaznam : pojistenci) {
                if (zaznam.getJmeno().equals(jmeno) && zaznam.getPrijmeni().equals(prijmeni)) {
                    hledanyPojistenec += zaznam + "\n";
                    nalezeno = true;
                }
            }
            if (!nalezeno) {
                hledanyPojistenec += "Osoba není v evidenci pojištěnců.\n";
            }
        } else {
            hledanyPojistenec += "Evidence je zatím prázdná, prosím přidejte záznam.\n";
        }
        return hledanyPojistenec;
    }

    /**
     * Vypíše údaje o evidenci
     *
     * @return vrátí název evidence a počet aktuálně evidovaných pojištěnců.
     */
    @Override
    public String toString() {
        String pojisteniPodlePoctu = "pojištěnců";
        if (pojistenci.size() == 1) {
            pojisteniPodlePoctu = "pojištěnec";
        } else if (pojistenci.size() > 1 && pojistenci.size() < 5) {
            pojisteniPodlePoctu = "pojištěnci";
        }
        return String.format("Evidence pojištěnců. Aktuálně evidováno: %d %s", pojistenci.size(), pojisteniPodlePoctu);
    }
}