package SafetyTreeMap;

import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

public class SafetyTreeMap<T> extends TreeMap<String, List<T>> {
    @Override
    public List<T> get(Object key) {
        List<T> result = super.get(key);
        if (result != null) {
            return result;
        }
        super.put((String) key, new LinkedList<T>());
        return super.get(key);
    }
}
