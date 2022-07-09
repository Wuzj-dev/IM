package com.han.common.event;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.jupiter.api.Assertions.*;


@RunWith(SpringJUnit4ClassRunner.class)
class EventBusTest {

    @Test
    void getBlockingQueue() {
    }

    @Autowired
    EventBus eventBus;


    @Test
    public void we(){
        EventHub eventHub = eventBus.eventHub;
        eventHub = eventBus.eventHub;
    }


    @Test
    void fire() {
    }

    @Test
    void fireAll() {
    }

    @Test
    void asyncFire() {
    }
}