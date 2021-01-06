    package travelagency;

/*
 * Trip.java        
 *
 * Modela un viatge.
 *
 * Copyright Mònica Ramírez Arceda <mramirez@escoladeltreball.org>
 *           Joaquim Laplana Tarragona <jlaplana@escoladeltreball.org>
 *
 * This is free software, licensed under the GNU General Public License v3.
 * See http://www.gnu.org/licenses/gpl.html for more information.
 */

import java.util.HashSet;

public abstract class Trip {

    /** Identificador del viatge */
    private int id;
    /** Màxim identificador atorgat. */
    private static int maxId;
    /** Nom del viatge */
    private String name;
    /** Màxim nombre de persones que es poden apuntar al viatge */
    protected int maxPeople;
    /** Data incial del viatge, en format DDMMYYYY */
    protected String iniDate;
    /** Data final del viatge, en format DDMMYYYY */
    protected String endDate;
    /** Preu base del viatge */
    protected double basePrice;
    /** Percentatge a aplicar per a descomptes o recàrrec */
    protected static final double EXTRA_PERCENTAGE = 10;
    /** Grups apuntats al viatge */
    protected HashSet<Group> groups;

    // Constructor
    public Trip(String name, int maxPeople, String iniDate, String endDate, double basePrice) {
        this.groups = new HashSet<Group>();
        this.id = Trip.maxId + 1;
        Trip.maxId++;
        this.name = name;
        this.maxPeople = maxPeople;
        this.iniDate = iniDate;
        this.endDate = endDate;
        this.basePrice = basePrice;
    }

    /**
     * Afegeix un grup al viatge.
     * 
     * @param g un grup
     * @return true si s'ha pogut afegir, false altrament.
     */
    public abstract boolean add(Group g);

    /**
     * Calcula el preu que ha de pagar cada persona pel viatge.
     * 
     * @return el preu.
     */
    public abstract double pricePerPerson();

    /**
     * Calcula el nombre de persones que s'han apuntat al viatge.
     * 
     * @return el nombre de persones.
     */
    public int numberOfPeople() {
        int nPeople = 0;
        for (Group curG : this.groups) {
            nPeople += curG.numberOfPeople();
        }
        return nPeople;
    }

    /**
     * Esbrina si un grup "cap" en un viatge. És a dir, si si l'afegíssim suèraríem la capciatat màxima del viatge.
     * Aquest mètode NO afegeix el grup al viatge.
     * 
     * @param g un grup
     * @return true si el grup cabria en el viatge, false altrament.
     */
    protected boolean groupFits(Group g) {
        return this.numberOfPeople() + g.numberOfPeople() <= this.maxPeople;
    }

    /**
     * Determina si el viatge pot ser cancel·lat amb l'ocupació actual. Un viage es cancel·la si no es supera el 50% de
     * l'ocupació màxima.
     * 
     * @return true si el viatge no arriba a l'ocupació mínima, false altrament.
     */
    public boolean mayBeCancelled() {
        return this.maxPeople / 2 >= this.numberOfPeople();
    }

    /**
     * Calcula el total recaptat per a aquest viatge.
     * 
     * @return el total.
     */
    public double totalAmount() {
        return this.numberOfPeople() * this.pricePerPerson();
    }

    // Getters i setters

    public HashSet<Group> getGroups() {
        return groups;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getMaxPeople() {
        return maxPeople;
    }

    public String getIniDate() {
        return iniDate;
    }

    public String getEndDate() {
        return endDate;
    }

}
