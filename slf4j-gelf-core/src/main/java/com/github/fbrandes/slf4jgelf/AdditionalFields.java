package com.github.fbrandes.slf4jgelf;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
class AdditionalFields {
    private Map<String, String> fields;

    public AdditionalFields() {
        fields = new HashMap<>();
    }

    void add(String key, String value) {
        if (!key.startsWith("_")) {
            fields.put("_" + key, value);
        } else {
            fields.put(key, value);
        }
    }

    void addAll(Map<String, String> additionalFields) {
        if (additionalFields != null) {
            for (Map.Entry<String, String> entry : additionalFields.entrySet()) {
                add(entry.getKey(), entry.getValue());
            }
        }
    }
}
