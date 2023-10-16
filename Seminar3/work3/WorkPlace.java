package Seminar3.work3;

public class WorkPlace<T extends Person> {
    private T[] community;

    public WorkPlace(T[] community) {
        this.community = community;
    }

    public void workForAll(){
        for (T t : community) {
            t.doWork();
        }
    }
}