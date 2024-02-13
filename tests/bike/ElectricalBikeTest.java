package tests.bike;

import bike.*;
import org.junit.jupiter.api.BeforeEach;

public class ElectricalBikeTest extends BikeTest {
    

    protected Bike createBike () {
        return new ElectricalBike(10, false);
    }

    


    
}
