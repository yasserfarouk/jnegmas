package jnegmas.apps.scml.factory_managers;

import jnegmas.apps.scml.common.CFP;
import jnegmas.sao.SAONegotiator;

/**
 * An example of a factory manager that inherits from the GreedyFactoryManager and modifies it.
 *
 * <b>ALL classes inheriting from GreedyFactoryManager must have names ending with GreedyFactoryManager or GFM</b>
 */
public class RandomizingGFM extends GreedyFactoryManager {

    @Override
    public SAONegotiator respondToNegotiationRequest(CFP cfp, String partner) {
        if (Math.random() < 0.5){
            return null;
        }
        return super.respondToNegotiationRequest(cfp, partner);
    }
}
