package evidencePojistencu;

/**
 * Třída obsahuje osobní údaje osoby, která se vkládá do evidence pojištěnců
 * autor: Slámová Lenka
 */
public class Pojistenec {
    /**
     * jméno pojištěnce
     */
    private String jmeno;
    /**
     * příjmení pojištěnce
     */
    private String prijmeni;
    /**
     * věk pojištěnce
     */
    private int vek;
    /**
     * telefonní číslo pojištěnce
     */
    private String telefon;

    /**
     * Vytvoří novou instanci pojištěnce
     *
     * @param jmeno    jméno pojištence
     * @param prijmeni příjmené pojištěnce
     * @param vek      věk pojištence
     * @param telefon  telefonní číslo pojištěnce
     */
    public Pojistenec(String jmeno, String prijmeni, int vek, String telefon) {
        this.jmeno = jmeno;
        this.prijmeni = prijmeni;
        this.vek = vek;
        this.telefon = telefon;
    }

    /**
     * Getter pro zjištění jména pojištěnce
     *
     * @return vrátí jméno pojištěnce
     */
    public String getJmeno() {
        return jmeno;
    }

    /**
     * Nastaví nový parametr pro jméno pojištěnce
     *
     * @param jmeno nové jméno pojištěnce
     */
    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }

    /**
     * Getter pro zjištění příjmení pojištěnce
     *
     * @return vrátí příjmení pojištěnce
     */
    public String getPrijmeni() {
        return prijmeni;
    }

    /**
     * Nastaví nový parametr pro příjmení pojištěnce
     *
     * @param prijmeni nové příjmení pojištěnce
     */
    public void setPrijmeni(String prijmeni) {
        this.prijmeni = prijmeni;
    }

    /**
     * Getter pro zjištění věku pojištěnce
     *
     * @return vrátí věk pojištěnce
     */
    public int getVek() {
        return vek;
    }

    /**
     * Nastaví nový parametr pro věk pojištěnce
     *
     * @param vek nový věk pojištěnce
     */
    public void setVek(int vek) {
        this.vek = vek;
    }

    /**
     * Getter pro zjištění telefonního čísla pojištěnce
     *
     * @return vrátí telefonní číslo pojištěnce
     */
    public String getTelefon() {
        return telefon;
    }

    /**
     * Nastaví nový parametr pro telefonní číslo
     *
     * @param telefon nové telefonní číslo pojištěnce
     */
    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    /**
     * Vypíše údaje o pojištěnci
     *
     * @return jméno a příjmení pojištěnce, jeho věk v závorkách a telefonní číslo.
     */
    @Override
    public String toString() {
        String roky = "let";
        if (vek == 1) {
            roky = "rok";
        } else if (vek > 1 && vek < 5) {
            roky = "roky";
        }
        return String.format("Pojištěnec: %s %s (%d %s) s telefonním číslem: %s.", jmeno, prijmeni, vek, roky, telefon);
    }
}