package com.jad.show.handler;

import com.jad.show.IShow;
import com.jad.show.ShowFactory;

import java.util.Map;

public class ConcertShowHandler extends CreateShowHandler {
    @Override
    public IShow handle(String showType, Map<String, String> parameters) {
        if ("CONCERT".equals(showType)) {
            return ShowFactory.makeConcertShow(
                parameters.get("name"),
                parameters.get("description"),
                parameters.get("artist")
            );
        }
        return nextHandler != null ? nextHandler.handle(showType, parameters) : null;
    }
} 