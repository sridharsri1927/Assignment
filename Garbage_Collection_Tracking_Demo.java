package sri;
public class TrackableObject {
    private static int objectCount = 0;
    private static int gcCount = 0;
    private int id;

    public TrackableObject() {
        objectCount++;
        id = objectCount;
        System.out.println("Object " + id + " created");
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Object " + id + " is being garbage collected");
        gcCount++;
        super.finalize();
    }

    public static void main(String[] args) {
        System.out.println("Garbage Collection Tracking Demo");
        System.out.println("=================================");

        TrackableObject obj1 = new TrackableObject(); // Object 1
        TrackableObject obj2 = new TrackableObject(); // Object 2
        TrackableObject obj3 = new TrackableObject(); // Object 3

        // Make obj1 and obj2 eligible for GC
        obj1 = null;
        obj2 = null;

        // Suggest GC
        System.gc();

        
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Total objects created: " + objectCount);
        System.out.println("Objects garbage collected: " + gcCount);
    }
}
