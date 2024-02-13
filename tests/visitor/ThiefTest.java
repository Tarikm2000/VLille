package tests.visitor;

import observer.Station;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import visitor.*;
import observer.*;
import bike.*;


import static org.junit.jupiter.api.Assertions.*;

class ThiefTest {

    private Station station;
    private Thief thief;

    @BeforeEach
    void setUp() {
        station = new Station(1, 10); 
        thief = new Thief(station);
    }

    @Test
    void testStealDecoratedBike() {
        DecoratedBike decoratedBike = new DecoratedBike(new ClassicBike(10, false),null);
        station.addBike(decoratedBike);
        thief.steal(decoratedBike);
        assertFalse(station.getBikes().contains(decoratedBike));
    }


    @Test
    void testStealElectricalBike() {
        ElectricalBike electricalBike = new ElectricalBike(10,false);
        station.addBike(electricalBike);
        thief.steal(electricalBike);
        assertFalse(station.getBikes().contains(electricalBike));
    }

    @Test
    void testStealClassicBike() {
        ClassicBike classicBike = new ClassicBike(10,false);
        station.addBike(classicBike);
        thief.steal(classicBike);
        assertFalse(station.getBikes().contains(classicBike));
    }
}
