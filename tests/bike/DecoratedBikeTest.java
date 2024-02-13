package tests.bike;

import bike.*;

public class DecoratedBikeTest extends BikeTest {

    protected DecoratedBike createBike() {
             ElectricalBike b=new ElectricalBike(10, false);
        return new DecoratedBike(b,null);
    }
    
}
