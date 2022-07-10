package com.han.common.event;

import com.han.common.dto.SingleResponse;
import org.springframework.stereotype.Component;

/**
 * @ClassNAME TestEventHandler
 * @Description
 * @Author wuj
 * @Date 2022/7/10 12:36
 */
@Component
public class TestEventHandler
        implements EventHandlerI<TestEvent, SingleResponse> {
    @Override
    public SingleResponse execute(TestEvent event) {

        TestEvent testEvent = new TestEvent();
        testEvent.setName("12");
        return null;
    }
}
