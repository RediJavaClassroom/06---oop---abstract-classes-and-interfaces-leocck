package com.redi.j2.proxies;

import com.redi.j2.utils.ReflectionProxy;

public class Swimmer extends ReflectionProxy {
    @Override
    public String getTargetClassName() {
        return "com.redi.j2.Swimmer";
    }
}
