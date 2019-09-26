package com.example.demo.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class JsonUtil {
    private static Logger logger = LoggerFactory.getLogger(JsonUtil.class);

    private static ObjectMapper mapper = new ObjectMapper();

    private static ObjectMapper snakeMapper = new ObjectMapper();

    static {
        snakeMapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
    }

    /**
     * Json转List
     *
     * @param json
     * @param clazz
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> List<T> toList(final String json, final Class<T> clazz) {
        return toCollection(json, ArrayList.class, clazz);
    }

    /**
     * Json转Set
     *
     * @param json
     * @param clazz
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> Set<T> toSet(final String json, final Class<T> clazz) {
        return toCollection(json, HashSet.class, clazz);
    }

    /**
     * Json转对象
     *
     * @param json
     * @param clazz
     */
    public static <T> T toObject(final String json, final Class<T> clazz) {
        try {
            return mapper.readValue(json, clazz);
        } catch (Exception e) {
            logger.error("Json转换对象失败！", e);
        }
        return null;
    }

    /**
     * snake格式的Json串转对象
     *
     * @param json
     * @param clazz
     */
    public static <T> T toObjectFromSnakeJson(final String json, final Class<T> clazz) {
        try {
            return snakeMapper.readValue(json, clazz);
        } catch (Exception e) {
            logger.error("Json转换对象失败！", e);
        }
        return null;
    }

    /**
     * 对象转JSON
     *
     * @param obj
     * @return
     */
    public static String toJson(final Object obj) {
        try {
            return mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            logger.error("Json转换集合失败！", e);
        }
        return null;
    }

    /**
     * 对象转snake格式的Json串
     */
    public static String toSnakeJson(final Object obj) {
        try {
            return snakeMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            logger.error("Json转换集合失败！", e);
        }
        return null;
    }

    /**
     * Json转集合
     *
     * @param json
     * @param collection
     * @param clazz
     * @return
     */
    public static <C extends Collection<T>, T> C toCollection(final String json, final Class<C> collection,
                                                              final Class<T> clazz) {
        try {
            JavaType javaType = mapper.getTypeFactory().constructParametricType(collection, clazz);
            C list = mapper.readValue(json, javaType);
            return list;
        } catch (Exception e) {
            logger.error("Json转换集合失败！", e);
        }
        return null;
    }
}
