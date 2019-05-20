import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.rule.FuzzyRuleSet;

public class Main {

    public static void main(String[] args) {

        try {
            String filename = args[0];

            int ilosc_zadan = Integer.parseInt(args[1]);
            int trudnosc_zadan = Integer.parseInt(args[2]);
            int dostepne_zasoby = Integer.parseInt(args[3]);

            FIS fis = FIS.load(filename, false);

            //wyswietl wykresy funkcji fuzyfikacji i defuzyfikacji
            FuzzyRuleSet fuzzyRuleSet = fis.getFuzzyRuleSet();
            fuzzyRuleSet.chart();

            //zadaj wartosci wejsciowe
            fuzzyRuleSet.setVariable("ilosc_zadan", ilosc_zadan);
            fuzzyRuleSet.setVariable("trudnosc_zadan", trudnosc_zadan);
            fuzzyRuleSet.setVariable("dostepne_zasoby", dostepne_zasoby);

            //logika sterownika
            fuzzyRuleSet.evaluate();

            //graficzna prezentacja wyjscia
            fuzzyRuleSet.getVariable("wymagany_czas").chartDefuzzifier(true);

        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("Niepoprawna liczba parametrow. Przyklad: java FuzzyPraca driverPraca.fcl int<ilosc_zadan> int<trudnosc_zadan> int<dostepne_zasoby>");
        } catch (NumberFormatException ex) {
            System.out.println("Niepoprawny parametr. Przyklad: java FuzzyPraca driverPraca.fcl int<ilosc_zadan> int<trudnosc_zadan> int<dostepne_zasoby>");
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }

}
