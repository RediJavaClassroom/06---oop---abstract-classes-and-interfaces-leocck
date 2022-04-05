package com.redi.j2.proxies;

import com.redi.j2.BloodType;
import com.redi.j2.utils.ReflectionProxy;

public class Mammal extends ReflectionProxy {

    public Mammal() {
        super(new Object[]{});
    }

    public Mammal(Object target) {
        super(target);
    }

    @Override
    public String getTargetClassName() {
        return "com.redi.j2.Mammal";
    }

    public BloodType getBloodType() {
        return invokeMethod("getBloodType", new Class[]{}, new Object[]{});
    }

    public void breastfeed() {
        invokeMethod("breastfeed", new Class[]{}, new Object[]{});
    }
}
