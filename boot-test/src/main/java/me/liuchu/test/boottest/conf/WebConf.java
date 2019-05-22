package me.liuchu.test.boottest.conf;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuchu
 * Date 2019/5/22
 * Time 17:18
 */
@Configuration
public class WebConf {

    @Bean
    public HttpMessageConverters fastJsonHttpMessageConverters() {
        // 定义一个convert 转换消息的对象
        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
        //日期格式 使用默认,为JSON.DEFAULT_DATA_FORMAT="yyyy-MM-dd HH:mm:ss"
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        // 2 添加fastjson 的配置信息 比如 是否要格式化 返回的json数据
        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
        fastConverter.setFastJsonConfig(fastJsonConfig);
        // 解决乱码的问题
        List<MediaType> fastMediaTypes = new ArrayList<>();
        fastMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
        fastConverter.setSupportedMediaTypes(fastMediaTypes);

        return new HttpMessageConverters(fastConverter);
    }
}
