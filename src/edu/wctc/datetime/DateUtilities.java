package edu.wctc.datetime;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Year;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;
import java.time.Period;

public class DateUtilities {
    

    public String formatDateToString(LocalDateTime date){
        DateTimeFormatter format = DateTimeFormatter.ofPattern("MMM d yyy");
        String strDate = date.format(format);
        return strDate;
    }
    
    public String formatDateTimeToString(LocalDateTime date){
        DateTimeFormatter format = DateTimeFormatter.ofPattern("MMM d yyy  hh:mm a");
        String strDate = date.format(format);
        return strDate;
    }
    
    public void payDay(){
        LocalDate today = LocalDate.now();
        LocalDate payday = today.with(TemporalAdjusters.lastDayOfMonth());
        System.out.println("Paday is on: " + payday.format(DateTimeFormatter.ofPattern("M/d/yy")));
         
    }
    
    public void timeTillBirthday(){
        LocalDate today = LocalDate.now();
        LocalDate bDay = today.of(1996, Month.AUGUST, 21);
        LocalDate nextBDay = bDay.withYear(today.getYear());
        
        if(nextBDay.isBefore(today) || nextBDay.isEqual(today)){
            nextBDay = nextBDay.plusYears(1);
        }
        
        Period p = Period.between(today, nextBDay);
        long p2 = ChronoUnit.DAYS.between(today, nextBDay);
        System.out.println("There are " + p.getMonths() + " months, and "+ p.getDays() + " days until your next birthday. (" + p2 + " total days)");
        
        
    }

    
    
}
