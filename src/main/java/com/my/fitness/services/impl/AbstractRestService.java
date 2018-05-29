package com.my.fitness.services.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Abstract rest service
 */
@Component
public abstract class AbstractRestService {

    /**
     * Properties
     */
    @Value("${my.fitness.api.app.host}")
    private String apiAppHost;

    /**
     * Object mapper
     */
    private ObjectMapper objectMapper = new ObjectMapper();

    /**
     * Date format
     */
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

    /**
     * Rest template
     */
    @Autowired
    private RestTemplate restTemplate;

    /**
     * Get for object
     * @param serviceMethod Service method
     * @param params Params
     * @param objectClass Return object class
     * @param <T>
     * @return Return object
     */
    protected <T> T getForObject(String serviceMethod, MultiValueMap<String, Object> params, Class<T> objectClass) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromPath(serviceMethod);
        for (String key : params.keySet()) {
            if (!CollectionUtils.isEmpty(params.get(key))) {
                if (params.get(key).size() > 1) {
                    builder.queryParam(key, params.get(key));
                } else {
                    Object first = params.getFirst(key);
                    builder.queryParam(key, first);
                }
            }
        }
        return restTemplate.getForObject(apiAppHost + builder.build().toString(), objectClass, params);
    }

    /**
     * Post for object
     * @param serviceMethod Service method
     * @param params Params
     * @param objectClass Return object class
     * @param <T>
     * @return Return object
     */
    protected <T> T postForObject(String serviceMethod, MultiValueMap<String, Object> params, Class<T> objectClass) {
        /** Header */
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        /** Body params */
        ObjectNode objectNode = getParamsNode(params);
        HttpEntity requestEntity = new HttpEntity<>(objectNode.toString(), headers);
        return restTemplate.postForObject(apiAppHost + serviceMethod, requestEntity, objectClass);
    }

    /**
     * Get parameters object node
     * @param params Parameters
     * @return Object node
     */
    private ObjectNode getParamsNode(MultiValueMap<String, Object> params) {
        ObjectNode objectNode = objectMapper.createObjectNode();
        if (params == null) {
            return objectNode;
        }
        for (String key : params.keySet()) {
            if (!CollectionUtils.isEmpty(params.get(key))) {
                if (params.get(key).size() > 1) {
                    ArrayNode arrayNode = objectMapper.createArrayNode();
                    putValuesToArrayNode(params.get(key), arrayNode);
                    objectNode.put(key, arrayNode);
                } else {
                    Object first = params.getFirst(key);
                    putValueToNode(key, first, objectNode);
                }
            }
        }
        return objectNode;
    }

    /**
     * Put value to the object node
     * @param key Key
     * @param value Value
     * @param objectNode Object node
     */
    private void putValueToNode(String key, Object value, ObjectNode objectNode) {
        if (value == null) {
            objectNode.putNull(key);
            return;
        }
        if (String.class.equals(value.getClass())) {
            objectNode.put(key, (String) value);
            return;
        }
        if (Boolean.class.equals(value.getClass())) {
            objectNode.put(key, (Boolean) value);
            return;
        }
        if (Integer.class.equals(value.getClass())) {
            objectNode.put(key, (Integer) value);
            return;
        }
        if (Long.class.equals(value.getClass())) {
            objectNode.put(key, (Long) value);
            return;
        }
        if (BigDecimal.class.equals(value.getClass())) {
            objectNode.put(key, (BigDecimal) value);
            return;
        }
        if (Double.class.equals(value.getClass())) {
            objectNode.put(key, (Double) value);
            return;
        }
        if (Float.class.equals(value.getClass())) {
            objectNode.put(key, (Float) value);
            return;
        }
        if (Date.class.equals(value.getClass())) {
            objectNode.put(key, dateFormat.format((Date) value));
            return;
        }
        throw new RuntimeException("Unknown object type " + value.getClass() + " object value - " + value);
    }

    /**
     * Put values to the array node
     * @param objects Objects
     * @param arrayNode Array node
     */
    private void putValuesToArrayNode(List<Object> objects, ArrayNode arrayNode) {
        for (Object value : objects) {
            if (value == null) {
                arrayNode.addNull();
                continue;
            }
            if (String.class.equals(value.getClass())) {
                arrayNode.add((String) value);
                continue;
            }
            if (Boolean.class.equals(value.getClass())) {
                arrayNode.add((Boolean) value);
                continue;
            }
            if (Integer.class.equals(value.getClass())) {
                arrayNode.add((Integer) value);
                continue;
            }
            if (Long.class.equals(value.getClass())) {
                arrayNode.add((Long) value);
                continue;
            }
            if (BigDecimal.class.equals(value.getClass())) {
                arrayNode.add((BigDecimal) value);
                continue;
            }
            if (Double.class.equals(value.getClass())) {
                arrayNode.add((Double) value);
                continue;
            }
            if (Float.class.equals(value.getClass())) {
                arrayNode.add((Float) value);
                continue;
            }
            if (Date.class.equals(value.getClass())) {
                arrayNode.add(dateFormat.format((Date) value));
                continue;
            }
            throw new RuntimeException("Unknown object type " + value.getClass() + " object value - " + value);
        }
    }

}
