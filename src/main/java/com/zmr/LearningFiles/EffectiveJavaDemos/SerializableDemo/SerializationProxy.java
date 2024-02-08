package com.zmr.LearningFiles.EffectiveJavaDemos.SerializableDemo;

import java.io.Serializable;
import java.util.Date;

/**
 * 序列化代理 demo
 */
public class SerializationProxy implements Serializable {
    private final Date start;

    private final Date end;

    SerializationProxy(Period p) {
        this.start = p.start();
        this.end = p.end();
    }

    private static final Long serialVersionUID = 234216236122312L;
}
