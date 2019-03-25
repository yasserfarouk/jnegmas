package jnegmas.situated;

import jnegmas.PyCallable;

import java.util.HashMap;

/**
 * The interface to a bulletin board. Each world has one such bulletin board.
 * Agents are not allowed to add sections to this bulletin board but can record to it and can remove
 * any records they created
 *
 */
public interface BulletinBoard extends PyCallable {

    void addSection(String name);
    HashMap<String, Object> query(String section, HashMap<String, Object> query, boolean queryKeys);
    Object read(String section, String key);
    void record(String section, Object value, String key);
    void record(String section, Object value);
    void remove(String section, HashMap<String, Object> query, boolean queryKeys);
    void remove(String section, Object value);
    void remove(String section, String key);


}

