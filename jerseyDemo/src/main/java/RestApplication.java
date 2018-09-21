import org.codehaus.jackson.jaxrs.JacksonJsonProvider;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.core.env.ConfigurableEnvironment;

public class RestApplication extends ResourceConfig {

    public RestApplication(){
        packages("com.resources","com.filter","com.error");
        //加载json转换器,异常处理里面ResponseBuilder需要
        register(JacksonJsonProvider.class);
        this.register(MultiPartFeature.class);
        this.property("contextConfigLocation","classpath:applicationContext.xml");

    }
}