import java.rmi.*;

public interface DBMonitor extends Remote {
    String getReplicationStatus() throws RemoteException;
    String getLastSyncTime() throws RemoteException;

}