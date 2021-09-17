//package ps.espa.calendar;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

public class calendar {
    static String weekends[] = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat","Sun"};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("./calendar.inp"));
        BufferedWriter pw = new BufferedWriter(new FileWriter("calendar.out"));
        while(true){
            String value = br.readLine();
            if(value.equals("-1")){
                break;
            }
            String[] s = value.split(" ");
            LocalDate start = null, end = null;
            switch (s[0]){
                case "0":
                    start = getDays(s[1]);
                    end = getDays(s[2]);
                    break;
                case "1":
                    start = getDays(s[1]);
                    end = getWeeks(s[2]);
                    break;
                case "2":
                    start = getWeeks(s[1]);
                    end = getDays(s[2]);
                    break;
                default:
                    start = getWeeks(s[1]);
                    end = getWeeks(s[2]);
                    break;
            }
            if(start==null||end==null){
                pw.write("-1\n");
            }else{
                Duration duration = Duration.between(start.atStartOfDay(), end.atStartOfDay());
                pw.write(Math.abs(duration.toDays())+"\n");
            }
        }
        br.close();
        pw.close();
    }
    public static LocalDate getDays(String value){
        String[] split = value.split("-");
        for(;split[0].length()!=4;split[0]="0"+split[0]);
        split[1] = (split[1].length() == 1)?"0"+split[1]:split[1];
        split[2] = (split[2].length() == 1)?"0"+split[2]:split[2];
        value = split[0] + "-" + split[1] + "-" + split[2];
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(value, formatter);
        if(date.getDayOfMonth()!=Integer.parseInt(split[2])){
            return null;
        }else{
            return date;
        }
    }

    public static LocalDate getWeeks(String value){
        String[] split = value.split("-");
        int year = Integer.parseInt(split[0]);
        int month = Integer.parseInt(split[1]);
        int nums = Integer.parseInt(split[2]);
        DayOfWeek dayOfWeek = getDayOfWeek(split[3]);
        LocalDate date = LocalDate.of(year, month, 1)
                .with(TemporalAdjusters.dayOfWeekInMonth(nums,dayOfWeek));
        if(date.getMonthValue()!=month){
            return null;
        }
        return date;
    }
    public static DayOfWeek getDayOfWeek(String weekend){
        DayOfWeek day = null;
        for(int i=0;i< weekends.length;i++){
            if(weekends[i].equals(weekend)){
                day = DayOfWeek.of(i+1);
                break;
            }
        }
        return day;
    }
}
