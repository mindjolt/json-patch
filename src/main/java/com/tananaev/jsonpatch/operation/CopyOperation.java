package com.tananaev.jsonpatch.operation;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.tananaev.jsonpatch.JsonPath;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CopyOperation extends AbsOperation{


    public final JsonPath from;

    public CopyOperation(JsonPath from, JsonPath path) {
        this.path = path;
        this.from = from;
    }

    @Override
    public String getOperationName() {
        return "copy";
    }

    @Override
    public void applyInPlace(InPlaceElementWrapper inPlaceElement) {
        JsonElement sourceElement = inPlaceElement.getJsonElement();
        JsonElement value = from.navigate(sourceElement);
        JsonElement destination = path.head().navigate(sourceElement);
        setValue(destination, path.tail(), value);
    }

}
