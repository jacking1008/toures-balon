package com.touresbalon.api.kafka;

import java.util.HashMap;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;
import io.vertx.core.Vertx;
import io.vertx.kafka.client.producer.KafkaProducer;
import io.vertx.kafka.client.producer.KafkaProducerRecord;
import io.vertx.kafka.client.producer.RecordMetadata;
import kafka.common.KafkaException;

@ApplicationScoped
public class KafkaProducerService {

	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducerService.class);

    @Inject
    Vertx vertx;

    private KafkaProducer<String, String> producer;

    @Inject
    ObjectMapper objectMapper;

    @ConfigProperty(name = "kafka.bootstrap.servers")
    static String servers;

    private static Map<String, String> config;

    static {
        config = new HashMap<>();
        // Config values can be moved to application.properties
        config.put("bootstrap.servers", "10.0.1.153:9092");
//        config.put("bootstrap.servers", "ec2-18-219-44-85.us-east-2.compute.amazonaws.com:9092");
        config.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        config.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        config.put("acks", "1");
    }

    void onStart(@Observes StartupEvent ev) {
        LOGGER.info("onStart");
    }

    public void sendOrderToKafka(ReservaMessage reserva) throws KafkaException {
        try {
            KafkaProducerRecord<String, String> record = KafkaProducerRecord.create(
                    "RealizarReserva",reserva.getIdProductoDetalle().toString(), objectMapper.writeValueAsString(reserva));

            // use producer for interacting with Apache Kafka
            producer = KafkaProducer.create(vertx, config);
            producer.exceptionHandler(e -> {
                LOGGER.error("Error en envio a kafka  " , e);
                producer.close();
                throw new KafkaException(e);
            });
            producer.send(record, done -> {
                if (done.succeeded()) {
                    RecordMetadata recordMetadata = done.result();
                    LOGGER.info("Message " + record + " written on topic=" + recordMetadata.getTopic() +
                            ", partition=" + recordMetadata.getPartition() +
                            ", offset=" + recordMetadata.getOffset());
                } else {
                    LOGGER.error("Error en envio a kafka ", done.cause());
                    throw new KafkaException(done.cause());
                }
            });
        } catch (
                JsonProcessingException e) {
            LOGGER.error("Error en serializacion ", e);
            throw new KafkaException(e);
        }
    }

    void onStop(@Observes ShutdownEvent ev) {
        LOGGER.info("onStop");
        //producer.close();
        //vertx.close();
    }
}
