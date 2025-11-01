package sri;
import java.util.ArrayList;
class Transport {
 private int id;
 private String type;
 private String source;
 private String destination;
 private String departure;
 private String arrival;
 // Constructor
 public Transport(int id, String type, String source, String destination,
String departure, String arrival) {
 this.id = id;
 this.type = type;
 this.source = source;
 this.destination = destination;
 this.departure = departure;
 this.arrival = arrival;
 }
 // Getter methods
 public int getId() { return id; }
 public String getType() { return type; }
 public String getSource() { return source; }
 public String getDestination() { return destination; }
 public String getDeparture() { return departure; }
 public String getArrival() { return arrival; }
 // Display details of one transport
 public void display() {
 System.out.printf("%-5d | %-6s | %-10s | %-12s | %-8s | %-8s%n",
 id, type, source, destination, departure, arrival);
 }
}
class TransportManager {
 private ArrayList<Transport> schedules = new ArrayList<>();
// Add a new schedule
 public void addSchedule(Transport t) {
 schedules.add(t);
 }
 // Display all schedules
 public void showAll() {
 System.out.println("\nID | Type | Source | Destination | Depart | 
Arrive ");
 System.out.println("---------------------------------------------------------------");
 for (Transport t : schedules) {
 t.display();
 }
 }
 // Filter schedules by type (Bus/Train)
 public void filterByType(String type) {
 System.out.println("\nShowing all " + type + " schedules:");
 System.out.println("---------------------------------------------------------------");
 boolean found = false;
 for (Transport t : schedules) {
 if (t.getType().equalsIgnoreCase(type)) {
 t.display();
 found = true;
 }
 }
 if (!found) {
 System.out.println("No records found for type: " + type);
 }
 }
 // Search by source and destination
 public void searchByRoute(String source, String destination) {
 System.out.println("\nSearching for route from " + source + " to " +
destination + ":");
 System.out.println("---------------------------------------------------------------");
 boolean found = false;
 for (Transport t : schedules) {
 if (t.getSource().equalsIgnoreCase(source)
 && t.getDestination().equalsIgnoreCase(destination)) {
 t.display();
 found = true;
 }
 }
 if (!found) {
 System.out.println("No transport found for this route.");
}
 }
}
public class TransportScheduleManager {
 public static void main(String[] args) {
 TransportManager manager = new TransportManager();
 // Add some schedules
 manager.addSchedule(new Transport(101, "Bus", "Delhi", "Agra",
"07:00", "11:00"));
 manager.addSchedule(new Transport(102, "Train", "Delhi", "Jaipur",
"09:00", "13:00"));
 manager.addSchedule(new Transport(103, "Bus", "Agra", "Delhi",
"15:00", "19:00"));
 manager.addSchedule(new Transport(104, "Train", "Delhi", "Mumbai",
"18:00", "08:00"));
 // Display all
 manager.showAll();
 // Filter by type
 manager.filterByType("Bus");
 // Search by route
 manager.searchByRoute("Delhi", "Jaipur");
 }
}