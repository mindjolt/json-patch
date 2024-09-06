package com.tananaev.jsonpatch.test.operation;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.tananaev.jsonpatch.JsonPath;
import com.tananaev.jsonpatch.operation.AddOperation;
import com.tananaev.jsonpatch.operation.CopyOperation;
import com.tananaev.jsonpatch.operation.InPlaceElementWrapper;
import org.junit.Assert;
import org.junit.Test;

public class CopyOperationTest {

    @Test
    public void basicCopyWorks(){
        JsonObject element = new JsonObject();
        element.add("b", new JsonPrimitive(1));
        String originalData = element.toString();
        JsonObject expected = new JsonObject();
        expected.add("a", new JsonPrimitive(1));
        expected.add("b", new JsonPrimitive(1));

        JsonElement result = new CopyOperation(new JsonPath("/b"), new JsonPath("/a")).apply(element);
        Assert.assertEquals(originalData, element.toString());
        Assert.assertEquals(expected, result);
    }

    @Test
    public void basicInPlaceCopyWorks(){
        JsonObject element = new JsonObject();
        element.add("b", new JsonPrimitive(1));
        JsonObject expected = new JsonObject();
        expected.add("a", new JsonPrimitive(1));
        expected.add("b", new JsonPrimitive(1));
        InPlaceElementWrapper inPlaceElement = new InPlaceElementWrapper(element);
        CopyOperation copyOperation = new CopyOperation(new JsonPath("/b"), new JsonPath("/a"));

        copyOperation.applyInPlace(inPlaceElement);
        JsonElement result = inPlaceElement.getJsonElement();

        Assert.assertEquals(expected, result);
    }
}
