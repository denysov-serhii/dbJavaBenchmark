package name.SerhiiBobrov.core.userPoint;

import java.util.Collection;
import java.util.Map;

interface UserPointMapper {
    Collection<UserPoint> loadAll();
    UserPoint create(Map<String, String> data);
}
