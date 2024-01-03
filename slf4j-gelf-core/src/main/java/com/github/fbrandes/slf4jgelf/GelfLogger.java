package com.github.fbrandes.slf4jgelf;

import org.slf4j.Logger;

public interface GelfLogger extends Logger {
    boolean isIncludeLoggerName();
    void setIncludeLoggerName(boolean includeLoggerName);
    boolean isIncludeClassName();
    void setIncludeClassName(boolean includeClassName);
    boolean isIncludeThreadName();
    void setIncludeThreadName(boolean includeThreadName);
    boolean isIncludeMdc();
    void setIncludeMdc(boolean includeMdc);
}
