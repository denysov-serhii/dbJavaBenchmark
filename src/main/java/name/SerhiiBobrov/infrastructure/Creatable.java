package name.SerhiiBobrov.infrastructure;

import java.util.Map;

public interface Creatable<T> {
    public T create(Map<String, String> data);
}
