import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;

import org.junit.Test;

public class UndergraduateTest {

    @Test
    public void testClone() {
        Undergraduate u1 = new Undergraduate("Sam");
        Undergraduate u2 = u1.clone();
        assertNotSame(u1, u2);
    }
    
    @Test
    public void testAddScore() {
        Undergraduate u1 = new Undergraduate("test");
        u1.addScore(70);
        assertSame(u1.scores.get(0), 70);
        
    }
    
    @Test
    public void testCompareTo() {
        Undergraduate u1 = new Undergraduate("Sam");
        Undergraduate u2 = u1.clone();
        u1.addScore(70);
        u2.addScore(70);
        assertSame(0, u1.compareTo(u2));
    }
    
    @Test
    public void testGetLetterGrade() {
        Undergraduate u1 = new Undergraduate("Sam");
        u1.addScore(75);
        assertEquals('C', u1.getLetterGrade());
    }

}
