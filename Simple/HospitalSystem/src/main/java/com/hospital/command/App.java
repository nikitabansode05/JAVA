package com.hospital.command;
import com.hospital.command.service.*;
import com.hospital.command.router.*;
import java.util.*;

public class App 
{
    public static void main( String[] args )
    {
       HospitalService hospitalService=new HospitalService();
       CommandRouter router=new CommandRouter();
       
        router.register("admit",hospitalService::admitPanel);
        router.register("bill", hospitalService::calculateBill);
        router.register("dosage", hospitalService::medicineDosage);

        // Lambda-based command
        router.register("discharge", (patientId, unused) -> {
            System.out.println("Patient " + patientId + " discharged successfully.");
            return 1;
        });

        // Help command
        router.register("help", (a, b) -> {
            router.showHelp();
            return 0;
        });

        Scanner scanner = new Scanner(System.in);
        String command;

        System.out.println("🏥 Welcome to Hospital Management System");

        while (true) {
            System.out.print("\nEnter command (or 'exit'): ");
            command = scanner.next();

            if (command.equalsIgnoreCase("exit")) {
                System.out.println("System shutting down...");
                break;
            }

            if (!router.contains(command)) {
                System.out.println("❌ Invalid command. Type 'help'");
                continue;
            }

            int a = 0, b = 0;

            if (!command.equals("help")) {
                System.out.print("Enter first value: ");
                a = scanner.nextInt();
                System.out.print("Enter second value: ");
                b = scanner.nextInt();
            }

            router.execute(command, a, b);
        }

        scanner.close();
    }
}
