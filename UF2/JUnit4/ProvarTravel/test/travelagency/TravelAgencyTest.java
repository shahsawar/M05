package travelagency;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TravelAgencyTest {
    private static TravelAgency ta;
    private static Trip t1;
    private static Person a1;
    private static Person a2;
    private static Person a3;
    private static Person a4;
    private static Group g1;
    private static Group g2;
    
	@BeforeEach
	void setUp() throws Exception {
        ta = new TravelAgency();
        t1 = ta.add("Carros de Foc", 10, "10/06/2012", "20/06/2012", 30, false);
        a1 = new Adult("11", "Joan Grau");
        a2 = new Adult("22", "Roger Garcia");
        a3 = new Adult("33", "Lluís Borrell");
        a4 = new Adult("44", "Marta Gómez");
        g1 = new Group();
        g2 = new Group();
	}

    @Test
    public void testgetAttendeesNoGroupsAttendees() {
        assertEquals(null, ta.getAttendees(t1.getId()));
    }

    @Test
    public void testgetAttendeesNoAttendees() {
        assertTrue(t1.add(g1));
        assertEquals(null, ta.getAttendees(t1.getId()));
    }

    @Test
    public void testgetAttendeesOneAttendee() {
        assertTrue(g1.add(a1));
        assertTrue(t1.add(g1));
        HashSet<Person> people = new HashSet<Person>();
        people.add(a1);
        assertEquals(people, ta.getAttendees(t1.getId()));
    }

    @Test
    public void testgetAttendeesSomeAttendees() {
        assertTrue(g1.add(a1));
        assertTrue(g1.add(a2));
        assertTrue(t1.add(g1));
        HashSet<Person> people = new HashSet<Person>();
        people.add(a1);
        people.add(a2);
        assertEquals(people, ta.getAttendees(t1.getId()));
    }

    @Test
    public void testgetAttendeesSomeGroups() {
        assertTrue(g1.add(a1));
        assertTrue(g1.add(a2));
        assertTrue(g2.add(a3));
        assertTrue(g2.add(a4));
        assertTrue(t1.add(g1));
        assertTrue(t1.add(g2));
        HashSet<Person> people = new HashSet<Person>();
        people.add(a1);
        people.add(a2);
        people.add(a3);
        people.add(a4);
        assertEquals(people, ta.getAttendees(t1.getId()));
    }

}
