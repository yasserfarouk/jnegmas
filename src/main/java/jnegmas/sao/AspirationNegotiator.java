package jnegmas.sao;


import jnegmas.negotiators.Controller;


public class AspirationNegotiator extends PythonSAONegotiator {
    public double maxAspiration;
    public double aspirationType;
    public boolean randomizeOffer;
    public boolean canPropose;
    public boolean assumeNormalized;

    public AspirationNegotiator(double maxAspiration, String aspirationType, boolean randomizeOffer
            , boolean canPropose, boolean assumeNormalized) throws IllegalAccessException, NoSuchFieldException {
        super();
        this.maxAspiration = maxAspiration;
        this.aspirationType = aspirationType == "boulware"? 10.0 : aspirationType == "conceder"? .4 : 1.0;
        this.randomizeOffer = randomizeOffer;
        this.canPropose = canPropose;
        this.assumeNormalized = assumeNormalized;
        createPythonShadow(this.toMap());
    }
    public AspirationNegotiator(SAONegotiator pythonObject, String name, Controller parent, double maxAspiration
            , String aspirationType, boolean randomizeOffer, boolean canPropose
            , boolean assumeNormalized) throws IllegalAccessException, NoSuchFieldException {
        super(pythonObject, name, parent);
        this.maxAspiration = maxAspiration;
        this.aspirationType = aspirationType == "boulware"? 10.0 : aspirationType == "conceder"? .4 : 1.0;
        this.randomizeOffer = randomizeOffer;
        this.canPropose = canPropose;
        this.assumeNormalized = assumeNormalized;
        createPythonShadow(this.toMap());
    }


    public AspirationNegotiator(SAONegotiator pythonObject, String name, Controller parent, double maxAspiration
            , double aspirationType, boolean randomizeOffer, boolean canPropose
            , boolean assumeNormalized) throws IllegalAccessException, NoSuchFieldException {
        super(pythonObject, name, parent);
        this.maxAspiration = maxAspiration;
        this.aspirationType = aspirationType;
        this.randomizeOffer = randomizeOffer;
        this.canPropose = canPropose;
        this.assumeNormalized = assumeNormalized;
        createPythonShadow(this.toMap());
    }

    public AspirationNegotiator(double maxAspiration, double aspirationType, boolean randomizeOffer
            , boolean canPropose, boolean assumeNormalized) throws IllegalAccessException, NoSuchFieldException {
        super();
        this.maxAspiration = maxAspiration;
        this.aspirationType = aspirationType;
        this.randomizeOffer = randomizeOffer;
        this.canPropose = canPropose;
        this.assumeNormalized = assumeNormalized;
        createPythonShadow(this.toMap());
    }


    public AspirationNegotiator() throws NoSuchFieldException, IllegalAccessException {
        super();
        createPythonShadow(this.toMap());
    }

    public AspirationNegotiator(SAONegotiator shadow) throws IllegalAccessException, NoSuchFieldException {
        super(shadow);
        createPythonShadow(this.toMap());
    }

}