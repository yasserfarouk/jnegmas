package jnegmas.situated;

import java.util.HashMap;
import java.util.Optional;

/**
 * The interface to a bulletin board. Each world has one such bulletin board.
 * Agents are not allowed to add sections to this bulletin board but can record to it and can remove
 * any records they created
 *
 */
public interface PyBulletinBoard {

    // void add_section(String name);

    Optional<HashMap<String, Object>> query(String section, Query query, boolean query_keys);
    Optional<Object> read(String section, String key);
    void record(String section, Object value, String key);
    void record(String section, Object value);
    void remove(String section, Query query, boolean query_keys);
    void remove(String section, Object value);
    void remove(String section, String key);


}

