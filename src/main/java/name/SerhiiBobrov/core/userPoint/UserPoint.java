package name.SerhiiBobrov.core.userPoint;

import java.util.Date;

public class UserPoint {

    public final static String USER_ID = "userId";
    public final static String POINTS = "points";
    public final static String STORE_CREDITS = "storeCredits";
    public final static String KICKBACK_DATE = "kickbackDate";

    private final int userId;
    private final int points;
    private final int storeCredits;
    private final String kickbackDate;

    public UserPoint(int userId, int points, int storeCredits, String kickbackDate) {
        this.userId = userId;
        this.points = points;
        this.storeCredits = storeCredits;
        this.kickbackDate = kickbackDate;
    }
}
