package name.SerhiiBobrov.core.userPoint;

import java.util.Map;

public class UserPointFactory {
    UserPoint create(Map<String, String> data){
        return new UserPoint(
                Integer.valueOf(data.get(UserPoint.USER_ID)),
                Integer.valueOf(data.get(UserPoint.POINTS)),
                Integer.valueOf(data.get(UserPoint.STORE_CREDITS)),
                data.get(UserPoint.KICKBACK_DATE)
        );
    }
}
