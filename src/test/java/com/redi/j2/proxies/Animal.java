package com.redi.j2.proxies;

import com.redi.j2.BloodType;
import com.redi.j2.utils.ReflectionProxy;

public class Animal extends ReflectionProxy {

    public Animal(Object... args) {
        super(args);
    }

    public Animal(Object target) { super(target); }

    @Override
    public String getTargetClassName() {
        return "com.redi.j2.Animal";
    }

    public BloodType getBloodType() {
        return invokeMethod("getBloodType", new Class[]{}, new Object[]{});
    }
}
