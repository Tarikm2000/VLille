package observer;
public interface Subject {

    /**
     * Attaches an observer to this subject.
     * Observers attached to this subject will be notified of state changes.
     *
     * @param o The observer to be attached.
     */
     public void attach(Observer o); 

     /**
     * Detaches an observer from this subject.
     * The observer will no longer receive notifications of state changes.
     *
     * @param o The observer to be detached.
     */
     public void detach(Observer o); 

     /**
     * Notifies all attached observers of a state change in this subject.
     */
     public void notifyObserver();
}