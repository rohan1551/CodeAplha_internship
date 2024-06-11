import java.util.ArrayList;
import java.util.Scanner;

public class StudentGradeTracker {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    ArrayList<Integer> grades = new ArrayList<>();

    System.out.println("Enter student grades (type 'done' to finish):");

    while (true) {
      String input = scanner.nextLine();

      if (input.equalsIgnoreCase("done")) {
        break;
      }

      try {
        int grade = Integer.parseInt(input);
        if (grade < 0 || grade > 100) {
          System.out.println("Please enter a valid grade between 0 and 100.");
        } else {
          grades.add(grade);
        }
      } catch (NumberFormatException e) {
        System.out.println("Invalid input. Please enter a number or 'done' to finish.");
      }
    }

    if (grades.isEmpty()) {
      System.out.println("No grades entered.");
    } else {
      int highest = findHighestGrade(grades);
      int lowest = findLowestGrade(grades);
      double average = calculateAverageGrade(grades);

      System.out.println("Grades Summary:");
      System.out.println("Highest Grade: " + highest);
      System.out.println("Lowest Grade: " + lowest);
      System.out.println("Average Grade: " + average);
    }

    scanner.close();
  }

  private static int findHighestGrade(ArrayList<Integer> grades) {
    int highest = grades.get(0);
    for (int grade : grades) {
      if (grade > highest) {
        highest = grade;
      }
    }
    return highest;
  }

  private static int findLowestGrade(ArrayList<Integer> grades) {
    int lowest = grades.get(0);
    for (int grade : grades) {
      if (grade < lowest) {
        lowest = grade;
      }
    }
    return lowest;
  }

  private static double calculateAverageGrade(ArrayList<Integer> grades) {
    int sum = 0;
    for (int grade : grades) {
      sum += grade;
    }
    return (double) sum / grades.size();
  }
}
