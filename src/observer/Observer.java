
package observer;
public interface Observer { 
      /**
     * This method is called when an observable object, typically a Station, has changed its state.
     * Implementing classes should define the specific actions to be taken when notified of such changes.
     *
     * @param updatedStation The Station object that has undergone a change and is notifying its observers.
     */
    public  void update(Station updatedStation);
}
