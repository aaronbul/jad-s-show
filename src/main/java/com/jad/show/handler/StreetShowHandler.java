package com.jad.show.handler;

import com.jad.show.IShow;
import com.jad.show.ShowFactory;

import java.util.Map;

public class StreetShowHandler extends CreateShowHandler {
    @Override
    public IShow handle(String showType, Map<String, String> parameters) {
        if ("STREET_SHOW".equals(showType)) {
            return ShowFactory.makeStreetShow(
                parameters.get("name"),
                parameters.get("description"),
                parameters.get("performers").split(",")
            );
        }
        return nextHandler != null ? nextHandler.handle(showType, parameters) : null;
    }
} 