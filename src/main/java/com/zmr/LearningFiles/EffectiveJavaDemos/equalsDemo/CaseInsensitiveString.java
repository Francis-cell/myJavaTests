package com.zmr.LearningFiles.EffectiveJavaDemos.equalsDemo;

import java.util.Objects;

public final class CaseInsensitiveString {
    private final String s;

    public CaseInsensitiveString(String s) {
        this.s = Objects.requireNonNull(s);
    }

    /**
     * this
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        // compare a CaseInsensitiveString object with a String
        if (o instanceof CaseInsensitiveString) {
            return s.equalsIgnoreCase(
                    ((CaseInsensitiveString) o).s
            );
        }
        // compare a String with a CaseInsensitiveString object
        if (o instanceof String) {
            return s.equalsIgnoreCase((String) o);
        }
        return false;
    }
}
