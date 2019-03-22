package jnegmas;

import jnegmas.situated.Breach;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.*;

public class BaseCopyableTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void fromMap() throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        HashMap<String, Object> breach_map = new HashMap<String, Object>(){{
            put("perpetrator", "partner 1");
            put("type", "product");
            put("level", 0.5);
            put("step", 5);
            put("id", "123456abcdef");
            put("victims", new ArrayList<String>(){{
                add("partner 2");
            }});
            put("contract", new HashMap<String, Object>(){{
                put("partners", new ArrayList<String>(){{
                    add("partner 1"); add("partner 2");
                }});
                put("agreement", new HashMap<String, Object>(){{
                    put("time", 5);
                    put("unit_price", 1.3);
                    put("quantity", 3);
                }});
                put("annotation", new HashMap<String, Object>(){{
                    put("cfp", new HashMap<String, Object>(){{

                    }});
                    put("buyer", "partner 1");
                    put("seller", "partner 2");
                }});
                put("issues", new ArrayList<HashMap<String, Object>>(){{
                    add(new HashMap<String, Object>(){{
                        put("name", "time");
                        put("type", 1);
                        put("values", new ArrayList<Integer>(){{
                            add(1); add(2); add(3); add(4); add(5);
                        }});
                    }});
                    add(new HashMap<String, Object>(){{
                        put("name", "unit_price");
                        put("type", 4);
                        put("min", 0.0);
                        put("max", 10.0);
                    }});
                }});
                put("signed_at", null);
                put("to_be_signed_at", 4);
                put("concluded_at", 3);
                put("signatures", new ArrayList<String>(){{
                    add("partner 1"); add("partner 2");
                }});
                put("state", new HashMap<String, Object>(){{
                    put("running", false);
                    put("started", true);
                    put("broken", false);
                    put("timedout", false);
                    put("has_error", false);
                    put("step", 5);
                    put("n_negotiators", 2);
                    put("time", 0.23);
                    put("relative_time", 0.75);
                    put("agreement", new HashMap<String, Object>(){{
                        put("time", 5);
                        put("unit_price", 1.3);
                        put("quantity", 3);
                    }});
                    put("error_details", "");
                    put("info", new HashMap<String, Object>(){{
                        put("id", "9876");
                        put("n_outcomes", 10);
                        put("issues", new ArrayList<HashMap<String, Object>>(){{
                            add(new HashMap<String, Object>(){{
                                put("name", "time");
                                put("type", 1);
                                put("values", new ArrayList<Integer>(){{
                                    add(1); add(2); add(3); add(4); add(5);
                                }});
                            }});
                            add(new HashMap<String, Object>(){{
                                put("name", "unit_price");
                                put("type", 4);
                                put("min", 0.0);
                                put("max", 10.0);
                            }});
                        }});
                        put("outcomes", null);
                        put("time_limit", 9.1);
                        put("n_steps", 21);
                        put("max_n_agents", 2);
                        put("dynamic_entry", false);
                        put("annotation", new HashMap<String, Object>(){{
                            put("cfp", new HashMap<String, Object>(){{
                                put("is_buy", true);
                                put("publisher", "partner 1");
                                put("product", 1);
                                put("min_time", 1);
                                put("max_time", 1);
                                put("min_quantity", 1);
                                put("max_quantity", 10);
                            }});
                            put("buyer", "partner 1");
                            put("seller", "partner 2");
                        }});
                    }});
                }});
            }});

        }};

        Breach breach = new Breach();
        breach.fromMap(breach_map);
        assertEquals("partner 1", breach.perpetrator);
        assertEquals(4, (int)breach.contract.to_be_signed_at);
        assertTrue(breach.contract.state.started);
        //assertEquals("9876", breach.contract.state.info.id);
    }

    @Test
    public void toMap() {
        Breach breach = new Breach();
        try {
            breach.toMap();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getPythonClassName() {
        assertEquals(new Breach().getPythonClassName(), "negmas.situated.Breach");
    }

}