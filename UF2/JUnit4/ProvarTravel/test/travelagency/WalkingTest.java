package travelagency;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WalkingTest {

	private static Trip t1;

	private static Group g1;
	private static Group g2;

	private static Person adt1;
	private static Person adt2;
	private static Person alm1;
	private static Person alm2;
	private static Person alm3;
	private static Person alm4;
	private static Person alm5;
	private static Person alm6;
	private static Person alm7;
	private static Person alm8;
	private static Person alm9;
	private static Person alm10;

	@BeforeEach
	void setUp() throws Exception {
		t1 = new Walking("Passejant pel Montseny", 10, "10/06/2012", "10/06/2012", 30);

		adt1 = new Adult("11", "Adulto1");
		adt2 = new Adult("12", "Adulto2");

		alm1 = new Child("1", "alumno1");
		alm2 = new Child("2", "alumno2");
		alm3 = new Child("3", "alumno3");
		alm4 = new Child("4", "alumno4");
		alm5 = new Child("5", "alumno5");
		alm6 = new Child("6", "alumno6");
		alm7 = new Child("7", "alumno7");
		alm8 = new Child("8", "alumno8");
		alm9 = new Child("9", "alumno9");
		alm10 = new Child("10", "alumno10");

		g1 = new Group();
		g2 = new Group();
	}

	@Test
	void testAttendanceMoreThan75Percent() {
		g1.add(adt1);
		g1.add(adt2);

		g1.add(alm1);
		g1.add(alm2);
		g1.add(alm3);
		g1.add(alm4);
		g1.add(alm5);
		g1.add(alm6);
		g1.add(alm7);
		g1.add(alm8);

		t1.add(g1);
		assertEquals(27., t1.pricePerPerson(), 0);
	}

	// Por cada 5 alumnos un adulto.
	@Test
	void testAddMethod() {
		g1.add(adt1);
		g1.add(alm1);
		g1.add(alm2);
		g1.add(alm3);
		g1.add(alm4);
		g1.add(alm5);

		g2.add(adt2);
		g2.add(alm6);
		g2.add(alm7);
		g2.add(alm8);
		g2.add(alm9);
		g2.add(alm10);

		t1.add(g1);
		t1.add(g2);
	}

	// En el grupo g1 hay 6 alumnos y un adulto.
	@Test
	void testAddMethodError() {
		g1.add(adt1);
		g1.add(alm1);
		g1.add(alm2);
		g1.add(alm3);
		g1.add(alm4);
		g1.add(alm5);
		g1.add(alm6);

		g2.add(adt2);
		g2.add(alm7);
		g2.add(alm8);
		g2.add(alm9);
		g2.add(alm10);

		t1.add(g1);
		t1.add(g2);
	}
}
