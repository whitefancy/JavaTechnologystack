package javacore;

import java.time.LocalDate;

/**
 * 打印一个当月的日历，并用*标记今天
 *
 * @author white
 * @version 1.0 2019-07-20
 */
public class CalendarTest {
    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        int month = date.getMonthValue();
        int today = date.getDayOfMonth();

        date = date.minusDays(today - 1);//set to start of month

    }
}
