package tests.bike;

import bike.Bike;
import bike.ClassicBike;

public class ClassicBikeTest extends BikeTest {

    protected Bike createBike() {
        return new ClassicBike(10, false);
    }
    
}
