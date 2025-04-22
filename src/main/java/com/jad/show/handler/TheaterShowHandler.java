package com.jad.show.handler;

import com.jad.show.IShow;
import com.jad.show.ShowFactory;

import java.util.Map;

public class TheaterShowHandler extends CreateShowHandler {
    @Override
    public IShow handle(String showType, Map<String, String> parameters) {
        if ("THEATER".equals(showType)) {
            return ShowFactory.makeTheaterShow(
                parameters.get("name"),
                parameters.get("description"),
                parameters.get("director"),
                parameters.get("actors").split(",")
            );
        }
        return nextHandler != null ? nextHandler.handle(showType, parameters) : null;
    }
} 