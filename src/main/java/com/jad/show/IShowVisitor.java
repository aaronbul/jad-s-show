package com.jad.show;

public interface IShowVisitor {
    void visitMovieShow(MovieShow movieShow);
    void visitTheaterShow(TheaterShow theaterShow);
    void visitStreetShow(StreetShow streetShow);
    void visitConcertShow(ConcertShow concertShow);
} 