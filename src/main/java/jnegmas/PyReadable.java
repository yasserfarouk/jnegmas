package jnegmas;

import java.util.HashMap;

public interface PyReadable {
    void from_map(HashMap<String, Object> dict);
    HashMap<String, Object> to_map();
}
