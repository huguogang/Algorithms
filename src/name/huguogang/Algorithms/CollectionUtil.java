package name.huguogang.Algorithms;

import java.util.Collection;

/**
 * Utilities for Java collections
 * 
 * @author ghu
 *
 */
public class CollectionUtil {
    public static<E> void addAll(Collection<E> c, E... args) {
        for(E ele : args) {
            c.add(ele);
        }
    }
}
