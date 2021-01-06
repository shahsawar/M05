package travelagency;

/*
 * Walk.java    
 *
 * Modela un passeig.
 *
 * Copyright Mònica Ramírez Arceda <mramirez@escoladeltreball.org>
 *           Joaquim Laplana Tarragona <jlaplana@escoladeltreball.org>
 *
 * This is free software, licensed under the GNU General Public License v3.
 * See http://www.gnu.org/licenses/gpl.html for more information.
 */

public class Walking extends Trip {

    public Walking(String name, int maxPeople, String iniDate, String endDate, double basePrice) {
        super(name, maxPeople, iniDate, endDate, basePrice);
    }

    /**
     * Afegeix un grup al viatge. El viatge no s'afegirà si el grup no hi cap o bé si hi ha més de 5
     * nens per adult.
     * 
     * @param g el grup que es vol afegir
     * @return true si s'ha pogut afegir el grup, false altrament.
     */
    @Override
    public boolean add(Group g) {
        int nAdults = 0;
        int nChildren = 0;
        if (!this.groupFits(g))
            return false;

        for (Group gCur : this.groups) {
            for (Person p : gCur.getPeople()) {
                if (p instanceof Adult) {
                    nAdults++;
                } else {
                    nChildren++;
                }
            }
        }

        for (Person p : g.getPeople()) {
            if (p instanceof Adult) {
                nAdults++;
            } else {
                nChildren++;
            }
        }

        boolean cond = nChildren / 5. <= nAdults;
        if (cond) {
            return this.groups.add(g);
        }
        return false;
    }

    /**
     * Calcula le preu per persona. Si hi ha més del 75% de l'assistència màxima, s'afegirá un
     * EXTRA_PERCENTAGE% de descompte.
     * 
     * @return el preu
     */
    @Override
    public double pricePerPerson() {
        double price = this.basePrice;
        double attendanceDiscount = 3. * this.maxPeople / 4;
        if (this.numberOfPeople() > attendanceDiscount)
            price = this.basePrice - this.basePrice * Trip.EXTRA_PERCENTAGE / 100;
        return price;
    }
}
