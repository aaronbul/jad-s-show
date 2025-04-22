package com.jad.show.handler;

import com.jad.show.IShow;

public class ShowHandlerChain {
    private static ShowHandlerChain instance;
    private final CreateShowHandler chain;

    private ShowHandlerChain() {
        // Création de la chaîne
        CreateShowHandler movieHandler = new MovieShowHandler();
        CreateShowHandler theaterHandler = new TheaterShowHandler();
        CreateShowHandler streetHandler = new StreetShowHandler();
        CreateShowHandler concertHandler = new ConcertShowHandler();

        // Configuration de la chaîne
        movieHandler.setNext(theaterHandler);
        theaterHandler.setNext(streetHandler);
        streetHandler.setNext(concertHandler);

        this.chain = movieHandler;
    }

    public static ShowHandlerChain getInstance() {
        if (instance == null) {
            instance = new ShowHandlerChain();
        }
        return instance;
    }

    public IShow processShowDescription(String showDescription) {
        String showType = chain.getShowType(showDescription);
        return chain.handle(showType, chain.parseParameters(showDescription));
    }
} 