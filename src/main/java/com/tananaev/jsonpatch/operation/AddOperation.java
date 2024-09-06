package com.tananaev.jsonpatch.operation;

import com.google.gson.JsonElement;
import com.google.gson.annotations.SerializedName;
import com.tananaev.jsonpatch.JsonPath;

public class AddOperation extends AbsOperation{

    @SerializedName("value")
    public JsonElement data;

    public AddOperation(JsonPath path, JsonElement data) {
        this.data = data;
        this.path = path;
    }

    @Override
    public String getOperationName() {
        return "add";
    }

    @Override
    public void applyInPlace(InPlaceElementWrapper inPlaceElement){
        JsonElement sourceElement = inPlaceElement.getJsonElement();
        JsonElement item = path.head().navigate(sourceElement);
        setValue(item, path.tail(), data);
    }

}
