package com.jad.customer;

import com.jad.show.*;

public class Spectator implements ISpectator, IShowVisitor {
    private final String firstName;
    private final String lastName;

    public Spectator(final String firstName, final String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String getFirstName() {
        return this.firstName;
    }

    @Override
    public String getLastName() {
        return this.lastName;
    }

    @Override
    public void watch(final IShow show) {
        show.accept(this);
    }

    @Override
    public void visitMovieShow(MovieShow movieShow) {
        System.out.println("J'ai assisté au film " + movieShow.getName() + " de " + movieShow.getDirector() + " sorti en " + movieShow.getYearOfRelease());
    }

    @Override
    public void visitTheaterShow(TheaterShow theaterShow) {
        System.out.println("J'ai assisté à la pièce de théâtre " + theaterShow.getName() + " de " + theaterShow.getDirector() + ".");
        System.out.print("Il y avait : ");
        theaterShow.getActors().forEach(actor -> System.out.print(actor + ", "));
        System.out.println();
    }

    @Override
    public void visitStreetShow(StreetShow streetShow) {
        System.out.println("J'ai assisté au spectacle de rue " + streetShow.getName() + ".");
        System.out.print("Il y avait : ");
        streetShow.getPerformers().forEach(performer -> System.out.print(performer + ", "));
        System.out.println();
    }

    @Override
    public void visitConcertShow(ConcertShow concertShow) {
        System.out.println("J'ai assisté au concert " + concertShow.getName() + " de " + concertShow.getArtist());
    }
}
