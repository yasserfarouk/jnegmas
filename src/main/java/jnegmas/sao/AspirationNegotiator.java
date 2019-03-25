package jnegmas.sao;

import jnegmas.negotiators.Controller;

import java.util.HashMap;

public class AspirationNegotiator extends PythonSAONegotiator {

    public AspirationNegotiator() throws NoSuchFieldException {
        super();
        createPythonShadow(new HashMap<>());
    }

    public AspirationNegotiator(String name, Controller parent, double maxAspiration, String aspirationType
            , boolean dynamicUfun, boolean randomizeOffer, boolean canPropose, boolean assumeNormalized) throws NoSuchFieldException {
        super();
        createPythonShadow(new HashMap<String, Object>() {{
            put("name", name);
            put("parent", parent);
            put("maxAspiration", maxAspiration);
            put("aspirationType", aspirationType);
            put("dynamicUfun", dynamicUfun);
            put("randomizeOffer", randomizeOffer);
            put("canPropose", canPropose);
            put("assumeNormalized", assumeNormalized);
        }});
    }

    public AspirationNegotiator(String name, Controller parent, double maxAspiration, double aspirationType
            , boolean dynamicUfun, boolean randomizeOffer, boolean canPropose, boolean assumeNormalized) throws NoSuchFieldException {
        super();
        createPythonShadow(new HashMap<String, Object>() {{
            put("name", name);
            put("parent", parent);
            put("maxAspiration", maxAspiration);
            put("aspirationType", aspirationType);
            put("dynamicUfun", dynamicUfun);
            put("randomizeOffer", randomizeOffer);
            put("canPropose", canPropose);
            put("assumeNormalized", assumeNormalized);
        }});
    }

    public AspirationNegotiator(String name) throws NoSuchFieldException {
        super();
        createPythonShadow(new HashMap<String, Object>() {{
            put("name", name);
        }});
    }

    public AspirationNegotiator(SAONegotiator shadow) {

        super(shadow);
    }
}