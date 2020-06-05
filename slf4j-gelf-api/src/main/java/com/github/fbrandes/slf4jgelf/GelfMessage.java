package com.github.fbrandes.slf4jgelf;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashMap;
import java.util.Map;

@Getter
@Setter
@Builder
@AllArgsConstructor
class GelfMessage {
    @SerializedName("version")
    private static final String GELF_VERSION = "1.1";

    private String host;
    @SerializedName("short_message")
    private String shortMessage;
    @SerializedName("full_message")
    private String fullMessage;
    private long timestamp;
    private Level level;
    private AdditionalFields additionalFields;

    Map<String, String> getFields() {
        Map<String, String> fields = new LinkedHashMap<>();

        fields.put("host", host);
        fields.put("short_message", shortMessage);
        fields.put("full_message", fullMessage);
        fields.put("timestamp", String.valueOf(timestamp));
        fields.put("level", level.toString());
        if (notNull(additionalFields)) {
            fields.putAll(additionalFields.getFields());
        }
        return fields;
    }

    private boolean notNull(AdditionalFields additionalFields) {
        return additionalFields != null && additionalFields.getFields() != null;
    }
}
