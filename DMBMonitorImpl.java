import java.rmi.*;
import java.rmi.server.*;
import java.sql.*;
import java.time.LocalDateTime;

public class DBMonitorImpl extends UnicastRemoteObject implements DBMonitor {

    protected DBMonitorImpl() throws RemoteException {
        super();
    }

    public String getReplicationStatus() throws RemoteException {
        // Dummy check for example purpose
        int primaryCount = 1000;
        int replicaCount = 995;

        if (primaryCount == replicaCount)
            return "Replication Status: Synchronized ✅";
        else if (replicaCount >= primaryCount - 5)
            return "Replication Status: Lagging ⏳";
        else
            return "Replication Status: Out of Sync ❌";
    }

    public String getLastSyncTime() throws RemoteException {
        return "Last Sync Time: " + LocalDateTime.now().minusMinutes(2);
    }

    public static void main(String[] args) {
        try {
            DBMonitorImpl obj = new DBMonitorImpl();
            Naming.rebind("rmi://localhost:1099/DBMonitorService", obj);
            System.out.println("Database Replication Monitor Server is running...");
        } catch (Exception e) {
            System.out.println("Server Error: " + e);
        }
    }
}