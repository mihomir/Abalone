package test;

import model.*;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class TestPosition extends TestCase {
	
	
	private Position p1;
	private Position p2;
	private Position p3;
	private Position p4;
	private Position p5;
	private Position p6;
	private Position p7;
	private Position p8;
	private Position p9;
	
	
    public TestPosition(String name) {
        super(name);
    }
	
    protected void setUp() throws Exception {
        super.setUp();
        p1 = new Position(1,1);
        p2 = new Position(1,1);
        p3 = new Position(2,2);
        p4 = new Position(3,2);
        p5 = new Position(3,3);
        p6 = new Position(2,3);
        p7 = new Position(1,2);
        p8 = new Position(1,1);
        p9 = new Position(2,1);
        }


protected void tearDown() throws Exception {
    super.tearDown();
    p1 = null;
    p2 = null;
    p3 = null;
    p4 = null;
    p5 = null;
    p6 = null;
    p7 = null;
    p8 = null;
    p9 = null;
}

public void testEquals(){
    assertFalse(p3.equals(p1));
    assertTrue(p2.equals(p1));
}

public void testNeighbour(){
    assertEquals(p4,p3.get_neighbour(1));
    assertEquals(p5,p3.get_neighbour(2));
    assertEquals(p6,p3.get_neighbour(3));
    assertEquals(p7,p3.get_neighbour(4));
    assertEquals(p8,p3.get_neighbour(5));
    assertEquals(p9,p3.get_neighbour(6));
    
    assertFalse(p9.equals(p3.get_neighbour(1)));
    assertFalse(p7.equals(p3.get_neighbour(3)));
    
    assertTrue(p9.equals(p3.get_neighbour(6)));
    assertTrue(p7.equals(p3.get_neighbour(4)));
    
//    assertNull(p1.get_neighbour(5));
  
}

public void testHashCode(){
	assertSame(p1.hashCode(),p2.hashCode());
	assertSame(p8.hashCode(),p2.hashCode());
//	assertNotSame(p9.hashCode(),p2.hashCode());
	}

public static Test suite(){
    TestSuite suite = new TestSuite();
    suite.addTest(new TestPosition("testEquals"));
    suite.addTest(new TestPosition("testNeighbour"));
    suite.addTest(new TestPosition("testHashCode"));
    return suite;
}
}