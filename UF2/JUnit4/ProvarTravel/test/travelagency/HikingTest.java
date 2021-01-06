package travelagency;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.List;
import java.util.ArrayList;
import java.util.Iterator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HikingTest {

    private static Trip t1;
    private static Person a1;
    private static Group g1;
    private static Group g2;
    private static Group g3;
    private static Group g4;
    private static Group g5;
    private static Group g6;

    @BeforeEach
    void setUp() {
        t1 = new Hiking("Passejant pel Montseny", 5, "10/06/2012", "10/06/2012", 30);
        a1 = new Adult("11", "Joan Grau");
        g1 = new Group();
        g2 = new Group();
        g3 = new Group();
        g4 = new Group();
        g5 = new Group();
        g6 = new Group();
    }

    @Test
    public void testPriceMes() {
        g1.add(a1);
        t1.add(g1);
        assertEquals(30., t1.pricePerPerson(), 0);
    }
    
	@Test
	public void testMaxGroupInTrip() {
		g1.add(a1);
		g2.add(a1);
		g3.add(a1);
		g4.add(a1);
		g5.add(a1);
		g6.add(a1);

		t1.add(g1);
		t1.add(g2);
		t1.add(g3);
		t1.add(g4);
		t1.add(g5);
		t1.add(g6);
		assertFalse(t1.add(g6));
	}
    
	
	@Test
	public void testForChildInTrip() {
		Person pChild = new Child("22", "children");
		g1.add(pChild);
		t1.add(g1);
		assertEquals(false, g1.add(pChild));
	}
	
    
	@Test
	public void testWinterMonth() {
		t1 = new Hiking("Passejant pel Montseny", 5, "10/12/2012", "10/12/2012", 10);
		assertEquals(11, t1.pricePerPerson());
	}
    
	@Test
	public void testNoWinterMonth() {
		t1 = new Hiking("Passejant pel Montseny", 5, "10/06/2012", "10/12/2012", 10);
		assertEquals(10, t1.pricePerPerson());
	}
}
