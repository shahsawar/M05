package travelagency;

/*
 * Group.java        
 *
 * Modela un grup de persones.
 *
 * Copyright Mònica Ramírez Arceda <mramirez@escoladeltreball.org>
 *           Joaquim Laplana Tarragona <jlaplana@escoladeltreball.org>
 *
 * This is free software, licensed under the GNU General Public License v3.
 * See http://www.gnu.org/licenses/gpl.html for more information.
 */

import java.util.HashSet;

public class Group {
    /** Persones que conformen el grup */
    private HashSet<Person> people;

    // Constructor
    public Group() {
        this.people = new HashSet<Person>();
    }

    /**
     * Afegeix una persona al grup.
     * 
     * @param p una persona
     * @return true si s'ha pogut afegir la persona al grup, false altrament.
     */
    public boolean add(Person p) {
        return people.add(p);
    }

    /**
     * Calcula quantes persones hi ha al grup.
     * @return
     */
    public int numberOfPeople() {
        return people.size();
    }

    public HashSet<Person> getPeople() {
        return this.people;
    }

}
