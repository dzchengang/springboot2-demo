package com.sdstc.service.event;

import org.springframework.context.ApplicationEvent;

public class MyEvent2 extends ApplicationEvent {

    public MyEvent2(Object source) {
        super(source);
    }
}
