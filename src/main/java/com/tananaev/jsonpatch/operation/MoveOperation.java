package com.tananaev.jsonpatch.operation;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.tananaev.jsonpatch.JsonPath;

public class MoveOperation extends AbsOperation {

    public final JsonPath from;

    public MoveOperation(JsonPath from, JsonPath path) {
        this.path = path;
        this.from = from;
    }

    @Override
    public String getOperationName() {
        return "move";
    }

    @Override
    public void applyInPlace(InPlaceElementWrapper inPlaceElement) {
        JsonElement sourceElement = inPlaceElement.getJsonElement();
        JsonElement value = from.navigate(sourceElement);

        JsonElement existingElement = from.head().navigate(sourceElement);
        JsonElement destination = path.head().navigate(sourceElement);

        removeValue(existingElement, from.tail());

        setValue(destination, path.tail(), value);
    }

}
