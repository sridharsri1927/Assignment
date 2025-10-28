import java.rmi.*;

public class DBClient {
    public static void main(String[] args) {
        try {
            DBMonitor monitor = (DBMonitor) Naming.lookup("rmi://localhost:1099/DBMonitorService");
            System.out.println(monitor.getReplicationStatus());
            System.out.println(monitor.getLastSyncTime());
        } catch (Exception e) {
            System.out.println("Client Error: " + e);
        }
    }
}