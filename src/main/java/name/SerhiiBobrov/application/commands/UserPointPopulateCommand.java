package name.SerhiiBobrov.application.commands;

import name.SerhiiBobrov.core.userPoint.UserPoint;
import name.SerhiiBobrov.core.userPoint.UserPointService;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class UserPointPopulateCommand extends DataPopulateCommand {
    public UserPointPopulateCommand(UserPointService service) {
        super(service);
    }

    @Override
    public String getCommandName() {
        return "userPointPopulate";
    }

    @Override
    protected Map<String, String> createFakeData() {
        HashMap<String, String> map = new HashMap<>();

        Random random = new Random();

        map.put(UserPoint.USER_ID, String.valueOf(random.nextInt()));
        map.put(UserPoint.POINTS, String.valueOf(random.nextInt()));
        map.put(UserPoint.STORE_CREDITS, String.valueOf(random.nextInt()));
        map.put(UserPoint.KICKBACK_DATE, new Date().toString());

        return map;
    }
}
