package visitor;

import bike.*;

public abstract class AbstractVisitor implements Visitor { 
    /**
     * Visits a Bike object. This method defines the default action to be performed when a visitor
     * encounters a Bike. It delegates the handling back to the Bike, allowing the Bike to accept 
     * this visitor and perform appropriate actions based on the visitor's type.
     *
     * @param bike The Bike object being visited.
     */
   public void visit(Bike bike) {
         bike.accept(this);
   }
    
}
