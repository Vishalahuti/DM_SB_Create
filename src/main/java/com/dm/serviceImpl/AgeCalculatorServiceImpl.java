package com.dm.serviceImpl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import org.springframework.stereotype.Service;

import com.dm.service.AgeCalculatorService;

@Service
public class AgeCalculatorServiceImpl implements AgeCalculatorService{

	@Override
	public String calculateAge(String dob) {

		// Expected input format: "dd-MM-yyyy HH:mm"
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

        // Parse the input string to LocalDateTime
        LocalDateTime birthDateTime = LocalDateTime.parse(dob, formatter);

        // Get the current date and time
        LocalDateTime currentDateTime = LocalDateTime.now();

        // Calculate years, months, and days
        long years = ChronoUnit.YEARS.between(birthDateTime, currentDateTime);
        LocalDateTime tempDateTime = birthDateTime.plusYears(years);

        long months = ChronoUnit.MONTHS.between(tempDateTime, currentDateTime);
        tempDateTime = tempDateTime.plusMonths(months);

        long days = ChronoUnit.DAYS.between(tempDateTime, currentDateTime);
        tempDateTime = tempDateTime.plusDays(days);

        // Calculate hours, minutes, and seconds
        long hours = ChronoUnit.HOURS.between(tempDateTime, currentDateTime);
        tempDateTime = tempDateTime.plusHours(hours);

        long minutes = ChronoUnit.MINUTES.between(tempDateTime, currentDateTime);
        tempDateTime = tempDateTime.plusMinutes(minutes);

        long seconds = ChronoUnit.SECONDS.between(tempDateTime, currentDateTime);

        // Return the age breakdown
        return String.format(
            "Your exact age is: %d years %d months %d days %d hours %d minutes %d seconds",
            years, months, days, hours, minutes, seconds
        );
    }

}
