package tests.visitor;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import visitor.*;
import bike.*;
import state.*;
import observer.*;

class RepairerTest {

    

    @Test
    public void testVisitDecoratedBike() {
            Repairer repairer = new Repairer("Tarik");
            ElectricalBike electricalBike = new ElectricalBike(10,false);
            DecoratedBike decoratedBike = new DecoratedBike(electricalBike,null);
            assertTrue(decoratedBike.getNbused()==0);
            Station station= new Station(1,10);
            station.addBike(decoratedBike);
            station.rentBike(decoratedBike);
            station.returnBike(decoratedBike);
            assertTrue(decoratedBike.getNbused()==1);
            station.rentBike(decoratedBike);
            repairer.visit(decoratedBike);
            assertTrue(decoratedBike.getBikeState() instanceof BikeIsWorking);
            assertTrue(decoratedBike.getNbused()==0);
    }

    @Test
    public void testVisitElectricalBike() {
            Repairer repairer = new Repairer("Tarik");
            ElectricalBike electricalBike = new ElectricalBike(1,false);
            assertTrue(electricalBike.getNbused()==0);
            Station station= new Station(1,10);
            station.addBike(electricalBike);
            station.rentBike(electricalBike);
            station.returnBike(electricalBike);
            assertTrue(electricalBike.getNbused()==1);
            station.rentBike(electricalBike);
            repairer.visit(electricalBike);
            assertTrue(electricalBike.getBikeState() instanceof BikeIsWorking);
            assertTrue(electricalBike.getNbused()==0);
    }

  @Test
    public void testVisitClassicBike() {
            Repairer repairer = new Repairer("Tarik");
            ElectricalBike classicBike = new ElectricalBike(1,false);
            assertTrue(classicBike.getNbused()==0);
            Station station= new Station(1,10);
            station.addBike(classicBike);
            station.rentBike(classicBike);
            station.returnBike(classicBike);
            assertTrue(classicBike.getNbused()==1);
            station.rentBike(classicBike);
            repairer.visit(classicBike);
            assertTrue(classicBike.getBikeState() instanceof BikeIsWorking);
            assertTrue(classicBike.getNbused()==0);
    }
}
