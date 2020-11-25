package com.sdstc.service.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class EventService {
    @Autowired
    ApplicationEventPublisher eventPublisher;

    public void test() {
        eventPublisher.publishEvent(new MyEvent(new Object()));
    }

    @EventListener(classes = MyEvent.class)
    public void eventLisner1(MyEvent event){
        System.out.println("event1");
        eventPublisher.publishEvent(new MyEvent2(new Object()));
    }

    @EventListener(classes = MyEvent2.class)
    public void eventLisner2(MyEvent2 event){
        System.out.println("event2");
    }
}
