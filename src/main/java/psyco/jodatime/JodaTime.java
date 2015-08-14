package psyco.jodatime;

import org.joda.time.*;
import org.junit.Test;


/**
 * Created by lipeng on 15/8/15.
 */
public class JodaTime {

    @Test
    public void newInstance() {
        System.out.println(new DateTime());
        System.out.println(new DateTime(2012, 5, 20, 13, 14, 0, 0));
    }

    @Test
    public void operator() {
        DateTime d = new DateTime();
        System.out.println(d);
        d = d.plusYears(1).plusDays(2).plusHours(12).plusMinutes(2);
        System.out.println(d.toString("yyyy/MM/dd hh:mm:ss.SSSa"));
    }

    @Test
    public void zone_global() {
        System.out.println(new DateTime());
        DateTimeZone.setDefault(DateTimeZone.forID("Europe/London"));
        System.out.println(new DateTime());
    }

    @Test
    public void period() {
        DateTime begin = new DateTime("2012-02-01");
        DateTime end = new DateTime("2012-05-01");

        //计算区间毫秒数
        Duration d = new Duration(begin, end);
        long time = d.getMillis();
        System.out.println(time);
        //计算区间天数
        Period p = new Period(begin, end, PeriodType.days());
        int days = p.getDays();
        System.out.println(days);

        //计算特定日期是否在该区间内
        Interval i = new Interval(begin, end);
        boolean contained = i.contains(new DateTime("2012-03-01"));
        System.out.println(contained);
    }
}
