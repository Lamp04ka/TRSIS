package labs.lb2;

public class ClassBirja {

    String NameCompany;
    int KolActives;
    double PriceActive;
    int id = 0;

    public ClassBirja(String input_name, int input_kol_actives, double input_price_active) {
        NameCompany = input_name;
        KolActives = input_kol_actives;
        PriceActive = input_price_active;
    }

    public void setNameCompany(String nameCompany) {
        this.NameCompany = nameCompany;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setKolActives(int kolActives) {
        this.KolActives = kolActives;
    }

    public void setPriceActive(double priceActive) {
        this.PriceActive = priceActive;
    }

    public double getPriceActive() {
        return PriceActive;
    }

    public int getId() {
        return id;
    }

    public int getKolActives() {
        return KolActives;
    }

    public String getNameCompany() {
        return NameCompany;
    }
}

