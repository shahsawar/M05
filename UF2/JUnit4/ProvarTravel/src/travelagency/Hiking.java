package travelagency;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/*
 * Hiking.java       
 *
 * Modela una excursió de muntanya.
 *
 * Copyright Mònica Ramírez Arceda <mramirez@escoladeltreball.org>
 *           Joaquim Laplana Tarragona <jlaplana@escoladeltreball.org>
 *
 * This is free software, licensed under the GNU General Public License v3.
 * See http://www.gnu.org/licenses/gpl.html for more information.
 */

public class Hiking extends Trip {
	DateTimeFormatter formatterDDMMYYYY = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Hiking(String name, int maxPeople, String iniDate, String endDate, double basePrice) {
        super(name, maxPeople, iniDate, endDate, basePrice);
    }

    /**
     * No hi pot haver cap nen
     */
    @Override
    public boolean add(Group g) {
        if (!this.groupFits(g))
            return false;
        for (Person p : g.getPeople()) {
            if (p instanceof Child) {
                return false;
            }
        }
        return this.groups.add(g);
    }

    /**
     * A l'hivern, si la data d'inici de l'excursió (novembre fins febrer) és un 10% més car
     */
    @Override
    public double pricePerPerson() {
        double price = this.basePrice;
        LocalDate iniDt = LocalDate.parse(this.iniDate, formatterDDMMYYYY);	
       // int month = iniDt.getMonthOfYear();
		int month = iniDt.getMonthValue();
		if (month == 12 || month == 1 || month == 2 || month == 3)
			price = this.basePrice + this.basePrice * Trip.EXTRA_PERCENTAGE / 100;
		return price;
	}
}




