package com.canoo.dolphin.demo.spring;

import com.canoo.dolphin.impl.BeanManagerImpl;
import com.canoo.dolphin.server.DolphinAction;
import com.canoo.dolphin.server.DolphinController;

import javax.inject.Inject;

@DolphinController
public class DemoController {

    @Inject
    private BeanManagerImpl manager;

    @DolphinAction
    public void callMe() {
    }

    @DolphinAction
    public void actionCall() {
    }

}
