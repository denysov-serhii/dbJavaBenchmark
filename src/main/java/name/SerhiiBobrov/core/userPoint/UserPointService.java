package name.SerhiiBobrov.core.userPoint;

import name.SerhiiBobrov.infrastructure.Creatable;
import name.SerhiiBobrov.infrastructure.Loadable;

import java.util.Collection;
import java.util.Map;

public class UserPointService implements Creatable<UserPoint>, Loadable<UserPoint> {

    private UserPointMapper userPointMapper;

    public UserPointService(UserPointMapper userPointMapper) {
        this.userPointMapper = userPointMapper;
    }

    public Collection<UserPoint> loadAll() {
        return userPointMapper.loadAll();
    }

    public UserPoint create(Map<String, String> data) {
        return userPointMapper.create(data);
    }
}
