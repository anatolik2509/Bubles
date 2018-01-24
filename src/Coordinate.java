/**
 * Created by 1 on 05.06.2017.
 */
public class Coordinate {
    public static double lineLength(double x1,double y1,double x2,double y2){
        return Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
    }

    public static double degrees(double x1,double y1,double x2,double y2){
        return Math.toDegrees(Math.atan2(y1-y2,x1-x2));
    }

}
