package com.tananaev.jsonpatch.operation;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.tananaev.jsonpatch.JsonPath;

public class RemoveOperation extends AbsOperation{

    public RemoveOperation( JsonPath path ) {
        this.path = path;
    }

    @Override
    public String getOperationName() {
        return "remove";
    }

    @Override
    public void applyInPlace(InPlaceElementWrapper inPlaceElement) {

        JsonElement item = path.head().navigate(inPlaceElement.getJsonElement());

        removeValue(item, path.tail());
    }

}
