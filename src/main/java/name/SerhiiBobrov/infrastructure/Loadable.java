package name.SerhiiBobrov.infrastructure;

import java.util.Collection;

public interface Loadable<T> {
    public Collection<T> loadAll();
}
