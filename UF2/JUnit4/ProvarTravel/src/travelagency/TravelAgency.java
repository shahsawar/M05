package travelagency;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/*
 * TravelAgency.java      
 *
 * Modela una agència de viatges.
 *
 * Copyright Mònica Ramírez Arceda <mramirez@escoladeltreball.org>
 *           Joaquim Laplana Tarragona <jlaplana@escoladeltreball.org>
 *
 * This is free software, licensed under the GNU General Public License v3.
 * See http://www.gnu.org/licenses/gpl.html for more information.
 */

public class TravelAgency {

    /** Els viatges de l'agència */
    private ArrayList<Trip> trips;

    // Constructor
    public TravelAgency() {
        this.trips = new ArrayList<Trip>();
    }

    /**
     * Afegeix un viatge a l'agència.
     * 
     * @param name el nom del viatge
     * @param maxPeople la capacitat màxima del viatge
     * @param iniDate la data inicial del viatge
     * @param endDate la data final del viatge
     * @param basePrice el preu base per persona del viatge
     * @param isWalking true si és un viatge de tipus Walking, false si és un viatge de tipus
     *        Hiking.
     * @return el viatge si s'ha afegit, null altrament
     */
    public Trip add(String name, int maxPeople, String iniDate, String endDate, double basePrice,
            boolean isWalking) {
        Trip t = null;
        if (isWalking) {
            t = new Walking(name, maxPeople, iniDate, endDate, basePrice);
        } else {
            t = new Hiking(name, maxPeople, iniDate, endDate, basePrice);
        }
        if (this.trips.add(t)) {
            return t;
        } else {
            return null;
        }
    }

    /**
     * Calcula la quantitat total de recaptació dels viatges. En aquest total no es comptablitzaran
     * les recaptacions dels viatges que poden ser cancel·lats.
     * 
     * @return la recaptatció total.
     */
    public double totalAmount() {
        double total = 0;
        for (Trip t : trips) {
            if (!t.mayBeCancelled()) {
                total += t.totalAmount();
            }
        }
        return total;
    }

    /**
     * donat un viatge, obté les persones que van al viatge.
     * 
     * @param id l'identificador del viatge
     * @return les persones que van al viatge
     */
    public HashSet<Person> getAttendees(int id) {
        
    	HashSet<Person> persons = new HashSet<Person>();
    	
    	for (Trip trip : trips) {
			if (trip.getId() == id) {
				for (Group g : trip.groups) {
					for (Person p : g.getPeople()) {
						persons.add(p);
					}
				}
			}
		}
    	
    	if (persons.isEmpty()) {
			return null;
		}
    	
        return persons;
    }
}
