package travelagency;
/*
 * Person.java  
 *
 * Modela una persona.
 *
 * Copyright Mònica Ramírez Arceda <mramirez@escoladeltreball.org>
 *           Joaquim Laplana Tarragona <jlaplana@escoladeltreball.org>
 *
 * This is free software, licensed under the GNU General Public License v3.
 * See http://www.gnu.org/licenses/gpl.html for more information.
 */

public abstract class Person {
    private String dni;
    private String name;
    
    public Person(String dni, String name) {
        this.dni = dni;
        this.name = name;
    }

    public String getDni() {
        return dni;
    }

    public String getName() {
        return name;
    }
    
}
