import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class DaysSinceDate {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Please enter a date (format: MM-DD-YYYY): ");
            String inputDate = scanner.nextLine();

            try {
                LocalDate enteredDate = LocalDate.parse(inputDate, DateTimeFormatter.ofPattern("MM-dd-yyyy"));
                LocalDate currentDate = LocalDate.now();

                long daysSinceDate = calculateDaysBetween(enteredDate, currentDate);

                System.out.println("Calculation Result:");
                System.out.println("-------------------");
                System.out.println("Entered Date : " + inputDate);
                System.out.println("Current Date : " + currentDate);
                System.out.println("Days Since Date : " + daysSinceDate + " " + "Days Since Current Date.");
            } catch (Exception e) {
                System.out.println("Invalid date format. Please enter a date in the format MM-DD-YYYY.");
            }
        }
    }

    private static long calculateDaysBetween(LocalDate startDate, LocalDate endDate) {
        long days = 0;
        LocalDate tempDate = startDate;

        while (tempDate.isBefore(endDate)) {
            tempDate = tempDate.plusDays(1);
            days++;
        }

        return days;
    }
}
