package com.jad.show;

import com.jad.show.handler.ShowHandlerChain;

public abstract class ShowFactory {
    public static IShow makeShow(final String showDescription) {
        return ShowHandlerChain.getInstance().processShowDescription(showDescription);
    }

    public static MovieShow makeMovieShow(final String name,
                                        final String description,
                                        final String director,
                                        final String yearOfRelease,
                                        final MovieType movieType) {
        return new MovieShow(name, description, director, yearOfRelease, movieType);
    }

    public static TheaterShow makeTheaterShow(final String name,
                                            final String description,
                                            final String director,
                                            final String... actors) {
        return new TheaterShow(name, description, director, actors);
    }

    public static StreetShow makeStreetShow(final String name,
                                          final String description,
                                          final String... performers) {
        return new StreetShow(name, description, performers);
    }

    public static ConcertShow makeConcertShow(final String name,
                                            final String description,
                                            final String artist) {
        return new ConcertShow(name, description, artist);
    }
} 