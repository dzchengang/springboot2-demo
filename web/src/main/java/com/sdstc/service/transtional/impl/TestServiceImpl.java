package com.sdstc.service.transtional.impl;

import com.sdstc.dao.UserDao;
import com.sdstc.model.User;
import com.sdstc.service.transtional.TestService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

import java.util.HashMap;
import java.util.Map;

import static com.sdstc.config.RabbitConfig.TOPIC_EXCHANGE;

@Service
public class TestServiceImpl implements TestService {
    @Autowired
    private UserDao userDao;
    @Autowired
    Test2Service test2Service;
    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    ApplicationEventPublisher eventPublisher;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void test(String id)  {
       //this.test();
        test2Service.test();
        int i=1/0;
    }

    /**
     * 在同一类中无法实现独立事务
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void test()  {
        userDao.insertUser(new User("cheng"));
    }

    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = {Exception.class})
    public void test1()  {
        eventPublisher.publishEvent(new MapEvent(new HashMap<>()));
        userDao.insertUser(new User("cheng"));
        int i=1/0;
    }

    class MapEvent extends ApplicationEvent{
        private Map<String,String> params=new HashMap<>();
        public MapEvent(Map<String,String> params){
            super(params);
            this.params=params;
        }
    }
    /**
     * 事务监听
     * phase 这个注解取值有：BEFORE_COMMIT、AFTER_COMMIT、AFTER_ROLLBACK、AFTER_COMPLETION
     * fallbackExecution：表明若没有事务的时候，对应的event是否需要执行，默认值为false表示，没事务就不执行了。
     *
     */
    @TransactionalEventListener(phase= TransactionPhase.AFTER_COMMIT,classes = MapEvent.class)
    public void handleCOMMITEvent() {
        System.out.println("commit");
        rabbitTemplate.convertAndSend(TOPIC_EXCHANGE,"a.sdstc",new HashMap<>());
    }

    @TransactionalEventListener(phase= TransactionPhase.AFTER_ROLLBACK,classes = MapEvent.class)
    public void handleCALLBACKEvent() {
        System.out.println("rooback");
    }

}
