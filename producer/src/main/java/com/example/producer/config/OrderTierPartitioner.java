package com.example.producer.config;

import org.apache.kafka.clients.producer.Partitioner;
import org.apache.kafka.common.Cluster;

import java.util.Map;

/**
 * Deterministic partitioner that pins each amount tier to a fixed partition:
 *   LOW    → partition 0
 *   MEDIUM → partition 1
 *   HIGH   → partition 2
 *
 * Kafka's default murmur2 hash does not guarantee that three keys spread
 * across three partitions uniformly — use this instead of relying on hashing.
 */
public class OrderTierPartitioner implements Partitioner {

    @Override
    public int partition(String topic, Object key, byte[] keyBytes,
                         Object value, byte[] valueBytes, Cluster cluster) {
        return switch (key == null ? "" : key.toString()) {
            case "LOW"    -> 0;
            case "MEDIUM" -> 1;
            case "HIGH"   -> 2;
            default       -> 0;
        };
    }

    @Override public void close() {}
    @Override public void configure(Map<String, ?> configs) {}
}

