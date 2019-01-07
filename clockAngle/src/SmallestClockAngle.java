import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SmallestClockAngle {

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int hours = Integer.parseInt(br.readLine());
        int min = Integer.parseInt(br.readLine());
        Double angle = getAngleBetweenHourAndminute(hours,min);
        if(angle==-1.0){
            System.out.println("Invalid input");
        }else{
            System.out.println("Angle = "  + angle +" degrees");
        }
    }


    public static Double getAngleBetweenHourAndminute(int hours, int minutes) {


        Double hourHandperMin = 0.5; // 30/60
        Double minHandPermin = 6.0; // 360/6
        Double angle;

        if (hours < 1 || hours > 12 || minutes < 0 || minutes > 60) {
            return -1.0;
        }

        if (hours == 0 && minutes == 0) {
            return 0.0;
        }

        if (minutes == 60 ) {
            if (hours < 12) {
                minutes = 0;
                hours++;
            }else{
                return -1.0;
            }
        }

        Double hourAngle = minutes*hourHandperMin;

        int hmin = hours*5;
        if (hmin == minutes) {
            angle=hourAngle;
        }else if (hmin < minutes) {
            angle =  ((minutes-hmin)*minHandPermin)-hourAngle;
        }else {
            angle =  ((hmin-minutes)*minHandPermin)+hourAngle;
        }
        return angle>180 ? 360-angle : angle;
    }


}
