import java.util.ArrayList;
import java.util.Scanner;

class Destination {
  String name;
  String date;
  String preferences;

  public Destination(String name, String date, String preferences) {
    this.name = name;
    this.date = date;
    this.preferences = preferences;
  }

  @Override
  public String toString() {
    return "Destination: " + name + "\nDate: " + date + "\nPreferences: " + preferences;
  }
}

class Budget {
  double accommodation;
  double food;
  double transport;
  double misc;

  public Budget(double accommodation, double food, double transport, double misc) {
    this.accommodation = accommodation;
    this.food = food;
    this.transport = transport;
    this.misc = misc;
  }

  public double getTotalBudget() {
    return accommodation + food + transport + misc;
  }

  @Override
  public String toString() {
    return "Accommodation: $" + accommodation + "\nFood: $" + food + "\nTransport: $" + transport + "\nMiscellaneous: $"
        + misc + "\nTotal Budget: $" + getTotalBudget();
  }
}

public class TravelItineraryPlanner {

  private ArrayList<Destination> destinations = new ArrayList<>();
  private Budget budget;

  public void addDestination(String name, String date, String preferences) {
    destinations.add(new Destination(name, date, preferences));
  }

  public void setBudget(double accommodation, double food, double transport, double misc) {
    budget = new Budget(accommodation, food, transport, misc);
  }

  public void displayItinerary() {
    System.out.println("Travel Itinerary:");
    for (Destination destination : destinations) {
      System.out.println(destination);
      System.out.println();
    }
    if (budget != null) {
      System.out.println(budget);
    }
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    TravelItineraryPlanner planner = new TravelItineraryPlanner();

    while (true) {
      System.out.println("\nTravel Itinerary Planner:");
      System.out.println("1. Add Destination");
      System.out.println("2. Set Budget");
      System.out.println("3. Display Itinerary");
      System.out.println("4. Exit");
      System.out.print("Choose an option (1-4): ");

      int choice = scanner.nextInt();
      scanner.nextLine(); // Consume newline

      switch (choice) {
        case 1:
          System.out.print("Enter destination name: ");
          String name = scanner.nextLine();
          System.out.print("Enter travel date (YYYY-MM-DD): ");
          String date = scanner.nextLine();
          System.out.print("Enter preferences: ");
          String preferences = scanner.nextLine();
          planner.addDestination(name, date, preferences);
          break;
        case 2:
          System.out.print("Enter accommodation budget: ");
          double accommodation = scanner.nextDouble();
          System.out.print("Enter food budget: ");
          double food = scanner.nextDouble();
          System.out.print("Enter transport budget: ");
          double transport = scanner.nextDouble();
          System.out.print("Enter miscellaneous budget: ");
          double misc = scanner.nextDouble();
          planner.setBudget(accommodation, food, transport, misc);
          break;
        case 3:
          planner.displayItinerary();
          break;
        case 4:
          System.out.println("Exiting the program. Enjoy your travels!");
          scanner.close();
          System.exit(0);
        default:
          System.out.println("Invalid option. Please choose a valid option (1-4).");
      }
    }
  }
}
