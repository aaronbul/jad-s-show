package com.jad.show.handler;

import com.jad.show.IShow;
import com.jad.show.MovieShow;
import com.jad.show.MovieType;
import com.jad.show.ShowFactory;

import java.util.Map;

public class MovieShowHandler extends CreateShowHandler {
    @Override
    public IShow handle(String showType, Map<String, String> parameters) {
        if ("MOVIE".equals(showType)) {
            return ShowFactory.makeMovieShow(
                parameters.get("name"),
                parameters.get("description"),
                parameters.get("director"),
                parameters.get("yearOfRelease"),
                MovieType.valueOf(parameters.get("movieType"))
            );
        }
        return nextHandler != null ? nextHandler.handle(showType, parameters) : null;
    }
} 