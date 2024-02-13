package tests.observer;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import observer.*;
import org.junit.jupiter.api.Test;

import bike.Bike;
import bike.ElectricalBike;

public class StationTest { 



    @Test 
    public void testNbCalled() {
        MockObserver mock=new MockObserver(0); 
        Station st=new Station(1,10);
        st.attach(mock);
        assertEquals(mock.getNbCalled(),0);
        st.notifyObserver();
        assertTrue(mock.getNbCalled()==1);
    }
    @Test
    void testAddBike() {
        Station station = new Station(1, 10);
        Bike bike = new ElectricalBike(10,false); 

        station.addBike(bike);

        List<Bike> bikes = station.getBikes();
        assertTrue(bikes.contains(bike));
    }

    @Test
    void testRemoveBike() {
        Station station = new Station(1, 10);
        ElectricalBike bike = new ElectricalBike(10,false);     
           station.addBike(bike);

        station.removeBike(bike);

        List<Bike> bikes = station.getBikes();
        assertFalse(bikes.contains(bike));
    }

    @Test
    void testRentBikeSuccess() {
        Station station = new Station(1, 10);
        ElectricalBike bike = new ElectricalBike(10,false);        
        station.addBike(bike);

        station.rentBike(bike);

        assertTrue(station.getRentedBikes().contains(bike));
        assertFalse(station.getBikes().contains(bike));
        assertEquals(1, bike.getNbused());
    }

    @Test
    void testRentBikeFailure() {
        Station station = new Station(1, 10);
        ElectricalBike bike = new ElectricalBike(0,false); 
        station.addBike(bike);     
        station.rentBike(bike);

        assertFalse(station.getRentedBikes().contains(bike));
        assertTrue(station.getBikes().contains(bike));
    }

    @Test
    void testReturnBike() {
        Station station = new Station(1, 10);
        ElectricalBike bike = new ElectricalBike(10,false); 
        station.addBike(bike);
        station.rentBike(bike);

        station.returnBike(bike);

        assertFalse(station.getRentedBikes().contains(bike));
        assertTrue(station.getBikes().contains(bike));
    }

    @Test
    void testAttachObserver() {
        Station station = new Station(1, 10);
        Observer mockObserver = new MockObserver(0);

        station.attach(mockObserver);

        List<Observer> observers = station.getObservers();
        assertTrue(observers.contains(mockObserver));
    }

    @Test
    void testDetachObserver() {
        Station station = new Station(1, 10);
        Observer mockObserver = new MockObserver(0);
        station.attach(mockObserver);

        station.detach(mockObserver);

        assertFalse(station.getObservers().contains(mockObserver));
    }





    
}
