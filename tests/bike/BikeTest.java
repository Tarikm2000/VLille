package tests.bike;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.BeforeEach;

import bike.*;
import state.*;


public abstract class BikeTest {
    protected Bike bike;
    protected  abstract Bike createBike(); 


    @BeforeEach
    public void init() {
       this.bike=this.createBike();
    } 

    @Test
    public void testGetNbMaxUsage() {
        assertEquals(10, bike.getNbMaxUsage());
    }

    @Test
    public void testSetNbMaxUsage() {
        bike.setNbMaxUsage(20);
        assertEquals(20, bike.getNbMaxUsage());
    }

    @Test
    public void testIsRented() {
        assertFalse(bike.isRented());
    }

    @Test
    public void testSetRented() {
        bike.setRented(true);
        assertTrue(bike.isRented());
    }

    @Test 
    public void testState() {
        assertTrue(bike.getBikeState() instanceof BikeIsWorking);
    }

    
}
