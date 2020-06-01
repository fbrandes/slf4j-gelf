package com.fbrandes.slf4jgelf;

import com.google.gson.annotations.SerializedName;

public enum Level {
    @SerializedName("0") OFF,
    @SerializedName("0") FATAL,
    @SerializedName("3") ERROR,
    @SerializedName("4") WARN,
    @SerializedName("6") INFO,
    @SerializedName("7") DEBUG,
    @SerializedName("7") TRACE,
    @SerializedName("7") ALL;
}