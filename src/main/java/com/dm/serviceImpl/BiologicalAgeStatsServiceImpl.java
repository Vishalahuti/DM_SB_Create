package com.dm.serviceImpl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import org.springframework.stereotype.Service;

import com.dm.service.BiologicalAgeStatsService;

@Service
public class BiologicalAgeStatsServiceImpl implements BiologicalAgeStatsService{

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
        
        // Additional biological stats
        long totalMinutesLived = ChronoUnit.MINUTES.between(birthDateTime, currentDateTime);
        long totalDaysLived = ChronoUnit.DAYS.between(birthDateTime, currentDateTime);
        long totalMonthsLived = ChronoUnit.MONTHS.between(birthDateTime, currentDateTime);

        // Heartbeats calculation (average 70 beats per minute)
        long averageHeartRate = 70;
        long heartBeats = totalMinutesLived * averageHeartRate;

        // Breaths taken (average 16 breaths per minute)
        long averageBreathsPerMinute = 16;
        long totalBreaths = totalMinutesLived * averageBreathsPerMinute;

        // Sleep duration (average 8 hours per day)
        long totalSleepHours = totalDaysLived * 8;

        // Distance walked (average 3,500 steps per day, 0.75 meters per step)
        long averageStepsPerDay = 3500;
        double strideLengthInMeters = 0.75;
        double totalSteps = totalDaysLived * averageStepsPerDay;
        double totalDistanceWalked = totalSteps * strideLengthInMeters / 1000; // Convert to kilometers

        // Blinks of the eye (average 18 blinks per minute)
        long averageBlinksPerMinute = 18;
        long totalBlinks = totalMinutesLived * averageBlinksPerMinute;

        // Calories burned (average 2200 calories per day)
        long averageCaloriesBurnedPerDay = 2200;
        long totalCaloriesBurned = totalDaysLived * averageCaloriesBurnedPerDay;

        // Hair growth (1.25 cm per month)
        double hairGrowthPerMonth = 1.25;
        double totalHairGrowth = totalMonthsLived * hairGrowthPerMonth;

        // Skin regeneration (every 27 days)
        long daysForSkinRegeneration = 27;
        long skinRegenerationCycles = totalDaysLived / daysForSkinRegeneration;

        // Laughter count (average 17 times per day)
        long averageLaughsPerDay = 17;
        long totalLaughs = totalDaysLived * averageLaughsPerDay;

        // Return the complete biological stats report
        return String.format(
        		"This is Amazing facts about your biological age\n" +
                "Your exact age is: %d years %d months %d days %d hours %d minutes %d seconds\n" +
                "Your heart has beaten approximately: %d times\n" +
                "You have taken approximately: %d breaths\n" +
                "You have slept for approximately: %d hours\n" +
                "You have walked approximately: %.2f kilometers\n" +
                "You have blinked approximately: %d times\n" +
                "You have burned approximately: %d calories\n" +
                "Your hair has grown approximately: %.2f cm\n" +
                "Your skin has regenerated approximately: %d times\n" +
                "You have laughed approximately: %d times",
                years, months, days, hours, minutes, seconds,
                heartBeats, totalBreaths, totalSleepHours, totalDistanceWalked,
                totalBlinks, totalCaloriesBurned, totalHairGrowth, skinRegenerationCycles, totalLaughs
            );
    }

}
