package evidencePojistencu;

import java.util.Scanner;

/**
 * Třída obsahuje uživatelské rozhraní pro evidenci pojištěnců
 * autor: Slámová Lenka
 */
public class Rozhrani {
    /**
     * připojení evidence pojištěnců
     */
    public Evidence evidence;
    /**
     * scanner pro umožnění vstupu od uživatele
     */
    public Scanner scanner;

    /**
     * vytvoření nové instance uživatelského rozhraní s novou instancí evidence a scanneru pro vstup od uživatele
     */
    public Rozhrani() {
        evidence = new Evidence();
        scanner = new Scanner(System.in);
    }

    /**
     * spustí aplikaci rozhraní evidence pojištěnců
     */
    public void spustProgram() {
        String volba = "";

        while (!volba.equals("4")) {
            vypisUvodniText();
            volba = scanner.nextLine().trim();

            switch (volba) {
                case "1":
                    pridejPojistence();
                    break;
                case "2":
                    System.out.println(evidence.vypisVsechnyPojistence());
                    break;
                case "3":
                    vyhledejZaznam();
                    break;
                case "4":
                    System.out.println(evidence);
                    System.out.println("Děkuji za použití evidence pojištěnců. Hezký den.");
                    break;
                default:
                    System.out.println("Neplatná volba, prosím zadejte číslo od 1 do 4.");
                    break;
            }
        }
    }

    /**
     * vypíše úvodní text aplikace
     */
    private void vypisUvodniText() {
        System.out.println("-------------------------------------------------");
        System.out.println("Evidence pojištěných");
        System.out.println("-------------------------------------------------");
        System.out.println("Vyberte si akci:");
        System.out.println("1 - Přidat nového pojištěného");
        System.out.println("2 - Vypsat všechny pojištěné");
        System.out.println("3 - Vyhledat pojištěného");
        System.out.println("4 - Konec");
    }

    /**
     * validuje data od uživatele a přidá nového pojištěnce do listu evidence
     */
    public void pridejPojistence() {
        String jmeno;
        do {
            System.out.println("Zadejte jméno pojištěného:");
            jmeno = scanner.nextLine().trim();
            if (jmeno.isEmpty())
                System.out.println("Jméno musí být vyplněno.");
            else if (!jmeno.toLowerCase().matches("[a-záčďéěíňóřšťúůýžA-ZÁČĎÉĚÍŇÓŘŠŤÚŮÝŽ]+"))
                System.out.println("Jméno nesmí být číslo.");

        } while (jmeno.isEmpty() || !jmeno.toLowerCase().matches("[a-záčďéěíňóřšťúůýžA-ZÁČĎÉĚÍŇÓŘŠŤÚŮÝŽ]+"));

        String prijmeni;
        do {
            System.out.println("Zadejte příjmení pojištěného:");
            prijmeni = scanner.nextLine().trim();
            if (prijmeni.isEmpty())
                System.out.println("Příjmení musí být vyplněno.");
            else if (!prijmeni.toLowerCase().matches("[a-záčďéěíňóřšťúůýžA-ZÁČĎÉĚÍŇÓŘŠŤÚŮÝŽ]+"))
                System.out.println("Příjmení nesmí být číslo.");

        } while (prijmeni.isEmpty() || !prijmeni.toLowerCase().matches("[a-záčďéěíňóřšťúůýžA-ZÁČĎÉĚÍŇÓŘŠŤÚŮÝŽ]+"));

        System.out.println("Zadejte věk:");
        int vek = 0;
        while (vek == 0) {
            try {
                int vekVstup = Integer.parseInt(scanner.nextLine().trim());
                if (vekVstup >= 0 && vekVstup <= 110)
                    vek = vekVstup;
                else
                    System.out.println("Takový věk neexistuje, zadejte ho znovu prosím:");
            } catch (NumberFormatException e) {
                System.out.println("Věk musí být číslo! Zadej věk:");
            }
        }
        System.out.println("Zadejte telefonní číslo: ");
        String telefon = "";
        while (telefon.isEmpty()) {
            telefon = scanner.nextLine().trim();
            //formát telefonního čísla může být nejkratší: xxxxxxxxx nebo nejdelší: +420 xxx xxx xxx
            if (telefon.length() < 9 || telefon.length() > 16) {
                System.out.println("Telefonní číslo nemá správný formát, zadejte ho znovu prosím:");
                telefon = "";
            }

        }
        evidence.pridatPojistence(jmeno, prijmeni, vek, telefon);
        System.out.println("Data byla uložena. Můžete pokračovat další volbou z nabídky.");
    }

    /**
     * vyhledá záznam o uživateli v evidenci pojištěnců, podle jména a příjmené ze vstupu od uživatele
     */
    public void vyhledejZaznam() {
        System.out.println("Zadejte jméno:");
        String jmeno = scanner.nextLine();
        System.out.println("Zadejte příjmení:");
        String prijmeni = scanner.nextLine();

        System.out.println(evidence.vyhledejZaznamOPojistenci(jmeno, prijmeni));
    }

    /**
     * Popis třídy rozhraní
     *
     * @return vrátí informaci, že se jedná o uživatelské rozhraní
     */
    @Override
    public String toString() {
        return "Uživatelské rozhraní pro Evidenci pojištěnců.";
    }
}
