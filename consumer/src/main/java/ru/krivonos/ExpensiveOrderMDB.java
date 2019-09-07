package ru.krivonos;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.*;
import java.util.logging.Level;
import java.util.logging.Logger;

@MessageDriven(mappedName = "OrderQueue", activationConfig = {
        @ActivationConfigProperty(propertyName="destinationType", propertyValue="javax.jms.Queue"),
        @ActivationConfigProperty(propertyName="destination", propertyValue="java:/jms/javaee7/OrderQueue"),
        @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge"),
        @ActivationConfigProperty(propertyName = "connectionFactoryLookup", propertyValue = "java:/jms/javaee7/OrderConnectionFactory"),
        @ActivationConfigProperty(propertyName = "messageSelector", propertyValue = "orderPrice >= 1000")
})

public class ExpensiveOrderMDB implements MessageListener {
    private static final Logger LOGGER = Logger.getLogger(ExpensiveOrderMDB.class.getName());
    public void onMessage(Message message) {
        try {
            Order order = message.getBody(Order.class);
            LOGGER.log(Level.INFO, "Expensive order: " + order.toString());
        } catch (JMSException e) {
            LOGGER.log(Level.WARNING, e.getMessage(), e);
        }
    }
}