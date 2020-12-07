package com.cse.helium.servicebus;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import com.microsoft.azure.servicebus.IMessage;
import com.microsoft.azure.servicebus.ITopicClient;
import com.microsoft.azure.servicebus.primitives.ServiceBusException;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ServiceBusProducerTest {

  @Mock
  ITopicClient topicClient;

  @InjectMocks
  ServiceBusProducer serviceBusProducer;

  @Test
  void testServiceBusProducer() throws InterruptedException, ServiceBusException {
    assertNotNull(serviceBusProducer);
    serviceBusProducer.produce();
    Mockito.verify(topicClient).send(Mockito.any(IMessage.class));
  }
}
