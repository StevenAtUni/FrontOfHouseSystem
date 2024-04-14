package Utils;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * Provides type or format conversion of time.
 */
public class TimeHelper {

    /**
     * Generates a LocalDateTime object.
     * @param timestamp The desired time measured in seconds since the UNIX epoch
     * @return LocalDateTime object of the desired timestamp
     */
    public static LocalDateTime unixToLocalDateTimeInt(int timestamp) {
        return LocalDateTime.ofInstant(Instant.ofEpochSecond(timestamp), ZoneId.of("GMT"));
    }

    /**
     * Generates a LocalDateTime object.
     * @param timestamp The desired time measured in seconds since the UNIX epoch
     * @return LocalDateTime object of the desired timestamp
     */
    public static LocalDateTime unixToLocalDateTimeLong(long timestamp) {
        return LocalDateTime.ofInstant(Instant.ofEpochSecond(timestamp), ZoneId.of("GMT"));
    }

    /**
     * Obtains the UNIX timestamp of a LocalDateTime object as an integer
     * @param date The LocalDateTime object to convert
     * @return UNIX timestamp as an integer
     */
    public static int localDateTimeToUnixInt(LocalDateTime date) {
        return (int) date.atZone(ZoneId.of("GMT")).toEpochSecond(); // Cast as an int before returning
    }

    /**
     * Obtains the UNIX timestamp of a LocalDateTime object as a long
     * @param date The LocalDateTime object to convert
     * @return UNIX timestamp as a long
     */
    public static long localDateTimeToUnixLong(LocalDateTime date) {
        return date.atZone(ZoneId.of("GMT")).toEpochSecond();
    }

    /**
     * Obtains, as a string, the hours and minutes (HH:mm) of a UNIX timestamp
     * @param timestamp The desired time measured in seconds since the UNIX epoch
     * @return HH:mm String
     */
    public static String unixToHHmm(long timestamp) {
        LocalDateTime date = unixToLocalDateTimeLong(timestamp);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        return date.format(formatter);
    }

    /**
     * Obtains, as a string, the hours and minutes (HH:mm:ss) of a UNIX timestamp
     * @param timestamp The desired time measured in seconds since the UNIX epoch
     * @return HH:mm:ss String
     */
    public static String unixToHHmmss(long timestamp) {
        LocalDateTime date = unixToLocalDateTimeLong(timestamp);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        return date.format(formatter);
    }

    /**
     * Obtains, as a string, the hours, minutes, seconds, days, months, years (HH:mm:ss dd/MM/yyyy) of a UNIX timestamp
     * @param timestamp The desired time measured in seconds since the UNIX epoch
     * @return HH:mm:ss dd/MM/yyyy String
     */
    public static String unixToFull(long timestamp) {
        LocalDateTime date = unixToLocalDateTimeLong(timestamp);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss dd/MM/yyyy");
        return date.format(formatter);
    }

    /**
     * Obtains, as a string, the days, months, and years (dd/MM/yyyy) of a UNIX timestamp
     * @param timestamp The desired time measured in seconds since the UNIX epoch
     * @return dd/MM/yyyy String
     */
    public static String unixToDMY(long timestamp) {
        LocalDateTime date = unixToLocalDateTimeLong(timestamp);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return date.format(formatter);
    }

    /**
     * Obtains, as a string, the hours, minutes, days, months, and years (HH:mm dd/MM/yyyy) of a UNIX timestamp
     * @param timestamp The desired time measured in seconds since the UNIX epoch
     * @return HH:mm dd/MM/yyyy String
     */
    public static String unixToHHmmDMY(long timestamp) {
        LocalDateTime date = unixToLocalDateTimeLong(timestamp);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm dd/MM/yyyy");
        return date.format(formatter);
    }
}
