package com.grond.object.store.api.objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.annotation.Nonnull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import netscape.javascript.JSObject;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class JsonKeyValue {
    @Nonnull
    private String key;
    @Nonnull
    private JSObject value;
}

