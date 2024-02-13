package tests.sharingStrategies;

import observer.Station;
import bike.Bike;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import sharingStrategies.*;
import java.util.ArrayList;
import sharingStrategies.RandomSharing;
import sharingStrategies.RoundRobinSharing;
import java.util.List;
import bike.*;
import observer.*;

public class RoundRobinTest {

    private SharingStrategy roundRobinSharing;

    @BeforeEach
    void setUp() {
        roundRobinSharing = new RoundRobinSharing();
    }

    @Test
    void testShareBikesWithEmptyInputs() {
        List<Station> result = roundRobinSharing.shareBikes(new ArrayList<>(), new ArrayList<>());
        assertTrue(result.isEmpty());
    }

    @Test
    void testShareBikesWithEmptyStations() {
        List<Station> stations = new ArrayList<>();
        List<Bike> bikes = createBikes(5);

        List<Station> result = roundRobinSharing.shareBikes(stations, bikes);
        assertTrue(result.isEmpty());
    }

    @Test
    void testShareBikesWithEmptyBikes() {
        List<Station> stations = createStations(3);
        List<Bike> bikes = new ArrayList<>();

        List<Station> result = roundRobinSharing.shareBikes(stations, bikes);
        assertFalse(result.isEmpty());
        assertEquals(0, result.get(0).nbBikes());
        assertEquals(0, result.get(1).nbBikes());
        assertEquals(0, result.get(2).nbBikes());
    }

    @Test
    void testShareBikes() {
        List<Station> stations = createStations(3);
        List<Bike> bikes = createBikes(5);

        List<Station> result = roundRobinSharing.shareBikes(stations, bikes);

        // Verify that bikes are distributed in a round-robin manner among the stations
        assertEquals(2, result.get(0).nbBikes());
        assertEquals(2, result.get(1).nbBikes());
        assertEquals(1, result.get(2).nbBikes());
    }

 
    private List<Bike> createBikes(int count) {
        List<Bike> bikes = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            bikes.add(new ElectricalBike(10,false)); 
        }
        return bikes;
    }

    private List<Station> createStations(int count) {
        List<Station> stations = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            stations.add(new Station(1,100)); 
        }
        return stations;
    }
}
