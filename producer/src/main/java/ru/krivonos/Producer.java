package ru.krivonos;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.Queue;
import java.util.Date;

/**
 * Created by Admin on 30.08.2019.
 */
@Stateless
public class Producer {
    @Inject
    @JMSConnectionFactory("java:/jms/javaee7/OrderConnectionFactory")
    private JMSContext jmsContext;
    @Resource(lookup = "java:/jms/javaee7/OrderQueue")
    private Queue queue;

    public void sendMessage(long price) {
        Order order = new Order(1234l, new Date(), "Mihail", price);
        jmsContext.createProducer().setProperty("orderPrice", price).send(queue, order);
    }
}
