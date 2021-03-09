package com.damai.core.converter;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.ObjectWriter;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

public final class JacksonConverterFactory extends Converter.Factory {
    /**
     * Create an instance using a default {@link ObjectMapper} instance for conversion.
     */
    public static JacksonConverterFactory create() {
        return create(new ObjectMapper(), new ObjectMapper());
    }

    /**
     * Create an instance using {@code mapper} for conversion.
     */
    @SuppressWarnings("ConstantConditions") // Guarding public API nullability.
    public static JacksonConverterFactory create(ObjectMapper requestMapper, ObjectMapper responseMapper) {
        if (requestMapper == null) throw new NullPointerException("requestMapper == null");
        if (responseMapper == null) throw new NullPointerException("responseMapper == null");
        return new JacksonConverterFactory(requestMapper, responseMapper);
    }

    private final ObjectMapper responseMapper;
    private final ObjectMapper requestMapper;

    private JacksonConverterFactory(ObjectMapper requestMapper, ObjectMapper responseMapper) {
        this.requestMapper = requestMapper;
        this.responseMapper = responseMapper;
    }

    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations,
                                                            Retrofit retrofit) {
        JavaType javaType = responseMapper.getTypeFactory().constructType(type);
        ObjectReader reader = responseMapper.readerFor(javaType);
        return new JacksonResponseBodyConverter<>(reader);
    }

    @Override
    public Converter<?, RequestBody> requestBodyConverter(Type type,
                                                          Annotation[] parameterAnnotations, Annotation[] methodAnnotations, Retrofit retrofit) {
        JavaType javaType = requestMapper.getTypeFactory().constructType(type);
        ObjectWriter writer = requestMapper.writerFor(javaType);
        return new JacksonRequestBodyConverter<>(writer);
    }
}