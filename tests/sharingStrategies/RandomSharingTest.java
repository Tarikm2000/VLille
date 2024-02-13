package tests.sharingStrategies;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import observer.*;


import sharingStrategies.*;
import bike.*;


import java.util.ArrayList;
import java.util.List;


public class RandomSharingTest {

    private SharingStrategy randomSharing;

    @BeforeEach
    void setUp() {
         randomSharing = new RandomSharing();
    }

    @Test
    void testShareBikesWithEmptyInputs() {
        List<Station> result = randomSharing.shareBikes(new ArrayList<>(), new ArrayList<>());
        assertTrue(result.isEmpty());
    }

    @Test
    void testShareBikesWithEmptyStations() {
        List<Station> stations = new ArrayList<>();
        List<Bike> bikes = createBikes(5);

        List<Station> result = randomSharing.shareBikes(stations, bikes);
        assertTrue(result.isEmpty());
    }

    @Test
    void testShareBikesWithEmptyBikes() {
        List<Station> stations = createStations(3);
        List<Bike> bikes = new ArrayList<>();
        List<Station> result = randomSharing.shareBikes(stations, bikes);
        assertFalse(result.isEmpty());
        assertEquals(0, result.get(0).nbBikes());
        assertEquals(0, result.get(1).nbBikes());
        assertEquals(0, result.get(2).nbBikes());
    }

    @Test
    void testShareBikes() {
        List<Station> stations = createStations(3);
        List<Bike> bikes = createBikes(5);
        List<Station> result = randomSharing.shareBikes(stations, bikes);

    }

    private List<Bike> createBikes(int count) {
        List<Bike> bikes = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            bikes.add(new ClassicBike(10,false)); 
        }
        return bikes;
    }

    private List<Station> createStations(int count) {
        List<Station> stations = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            stations.add(new Station(10,10)); 
        }
        return stations;
    }
}
