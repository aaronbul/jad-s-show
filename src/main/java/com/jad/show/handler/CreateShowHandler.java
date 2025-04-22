package com.jad.show.handler;

import com.jad.show.IShow;

import java.util.HashMap;
import java.util.Map;

public abstract class CreateShowHandler {
    protected CreateShowHandler nextHandler;
    
    public void setNext(CreateShowHandler handler) {
        this.nextHandler = handler;
    }
    
    public abstract IShow handle(String showType, Map<String, String> parameters);
    
    protected Map<String, String> parseParameters(String showDescription) {
        Map<String, String> parameters = new HashMap<>();
        String[] mainParts = showDescription.split(":", 2);
        if (mainParts.length != 2) {
            return parameters;
        }
        
        String[] parts = mainParts[1].split(";");
        for (String part : parts) {
            String[] keyValue = part.split("=");
            if (keyValue.length == 2) {
                parameters.put(keyValue[0].trim(), keyValue[1].trim());
            }
        }
        
        return parameters;
    }
    
    protected String getShowType(String showDescription) {
        String[] parts = showDescription.split(":", 2);
        return parts[0].trim();
    }
} 