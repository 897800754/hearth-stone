package cn.cg.hearthstone.support;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public final class JsonUtil {
    private static final Logger log = LoggerFactory.getLogger(JsonUtil.class);
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public static void main(String[] args) {
        System.out.println(toJsonString(LocalDateTime.now()));
    }

    public static String toJsonString(Object object) {
        if (object == null) {
            return null;
        } else {
            try {
                return OBJECT_MAPPER.writeValueAsString(object);
            } catch (JsonProcessingException var2) {
                log.error("parse json string error ", var2);
                return null;
            }
        }
    }

    public static Map<String, Object> objectToMap(Object object) {
        return (Map) OBJECT_MAPPER.convertValue(object, Map.class);
    }

    public static <T> T parseObject(String str, Class<T> clazz) {
        if (str == null) {
            return null;
        } else {
            try {
                return OBJECT_MAPPER.readValue(str, clazz);
            } catch (IOException var3) {
                log.error("parse string to object error", var3);
                return null;
            }
        }
    }

    public static <T> List<T> parseArray(String str, Class<T> clazz) {
        if (str == null) {
            return Collections.emptyList();
        } else {
            try {
                JavaType javaType = OBJECT_MAPPER.getTypeFactory().constructParametricType(List.class, new Class[]{clazz});
                return (List) OBJECT_MAPPER.readValue(str, javaType);
            } catch (IOException var3) {
                log.error("parse string to object error", var3);
                return Collections.emptyList();
            }
        }
    }

    public static <K, V> Map<K, V> parseMap(String str, Class<K> keyClazz, Class<V> valueClazz) {
        if (str == null) {
            return Collections.emptyMap();
        } else {
            try {
                JavaType javaType = OBJECT_MAPPER.getTypeFactory().constructParametricType(Map.class, new Class[]{keyClazz, valueClazz});
                return (Map) OBJECT_MAPPER.readValue(str, javaType);
            } catch (IOException var4) {
                log.error("parse string to object error", var4);
                return Collections.emptyMap();
            }
        }
    }

    public static List<Map<String, Object>> parseArray(String json) {
        ObjectMapper mapper = new ObjectMapper();

        try {
            return (List) mapper.readValue(json, new TypeReference<List<Map<String, Object>>>() {
            });
        } catch (IOException var3) {
            var3.printStackTrace();
            return Collections.emptyList();
        }
    }

    public static Map<String, Object> parseMap(String str) {
        return parseMap(str, String.class, Object.class);
    }

    public static <T> T mapToObject(Map map, Class<T> clazz) {
        return OBJECT_MAPPER.convertValue(map, clazz);
    }

    public static <T> List<T> mapsToObjects(List<Map<String, Object>> maps, Class<T> clazz) {
        return maps != null && maps.size() > 0 ? (List) maps.stream().map((x) -> {
            return OBJECT_MAPPER.convertValue(x, clazz);
        }).collect(Collectors.toList()) : Collections.emptyList();
    }

    private JsonUtil() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    static {
        OBJECT_MAPPER.registerModule(new ParameterNamesModule());
        OBJECT_MAPPER.registerModule(new Jdk8Module());
        OBJECT_MAPPER.registerModule(new JavaTimeModule());
        OBJECT_MAPPER.setSerializationInclusion(Include.NON_NULL);
        OBJECT_MAPPER.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        OBJECT_MAPPER.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        OBJECT_MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }
}
