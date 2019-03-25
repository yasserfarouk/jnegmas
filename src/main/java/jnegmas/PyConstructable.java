package jnegmas;

import java.util.HashMap;

/**
 * Defines an object that can be constructed from Python
 */
public interface PyConstructable {
    void construct(HashMap<String, Object> map);
}
