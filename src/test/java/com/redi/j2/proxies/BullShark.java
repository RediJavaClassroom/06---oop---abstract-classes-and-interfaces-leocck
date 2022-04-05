package com.redi.j2.proxies;

import com.redi.j2.utils.ReflectionProxy;

public class BullShark extends ReflectionProxy {

    @Override
    public String getTargetClassName() {
        return "com.redi.j2.BullShark";
    }

    public Integer getMaxEggs() {
        return invokeMethod("getMaxEggs", new Class[]{}, new Object[]{});
    }

    public Integer layEggs() {
        return invokeMethod("layEggs", new Class[]{}, new Object[]{});
    }

    public void eat() {
        invokeMethod("eat", new Class[]{}, new Object[]{});
    }
}