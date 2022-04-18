package com.hehe.config;

import org.apache.catalina.filters.CorsFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class GlobalCorsConfig {

    /**
     * 1. 返回新的CorsFilter（全局跨域）
     * 在任意配置类，返回一个新的CorsFilter Bean，并添加映射路径和具体的CORS配置信息
     * @return
     */
//    @Bean
//    public CorsFilter corsFilter() {
//        //1.添加CORS配置信息
//        CorsConfiguration config = new CorsConfiguration();
//        //放行哪些原始域
//        config.addAllowedOrigin("*");
//        //是否发送Cookie信息
//        config.setAllowCredentials(true);
//        //放行哪些原始域(请求方式)
//        config.addAllowedMethod("*");
//        //放行哪些原始域(头部信息)
//        config.addAllowedHeader("*");
//        //暴露哪些头部信息（因为跨域访问默认不能获取全部头部信息）
//        config.addExposedHeader("*");
//
//        //2.添加映射路径
//        UrlBasedCorsConfigurationSource configSource = new UrlBasedCorsConfigurationSource();
//        configSource.registerCorsConfiguration("/**", config);
//
//        //3.返回新的CorsFilter.
////        return new CorsFilter(configSource);
//        return new CorsFilter(configSource);
//    }

    /**
     * 2. 重写WebMvcConfigurer（全局跨域）
     * 在任意配置类，返回一个新的WebMvcConfigurer Bean，并重写其提供的跨域请求处理的接口，目的是添加映射路径和具体的CORS配置信息
     * @return
     */
    @Order(Ordered.HIGHEST_PRECEDENCE)
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override   //重写父类提供的跨域请求处理的接口
            public void addCorsMappings(CorsRegistry registry) {
                        //添加映射路径 默认拦截路径
                registry.addMapping("/**")

                        //放行哪些原始域       表示允许哪些原始域进行跨域访问，这里"*"表示允许任意网站，实际开发建议修改为配置项。
                        .allowedOrigins("*")

                        //是否发送Cookie信息      表示是否允许客户端发送Cookie等凭证信息，这里"true"表示支持发送，涉及登陆此处必须开启。
                        .allowCredentials(true)

                        //放行哪些原始域(请求方式)     表示允许原始域发起哪些请求方式，这里"*"表示支持GET/POST等全部提交方式。
                        .allowedMethods("*")

                        //放行哪些原始域(头部信息)     表示允许原始域携带哪些请求头 这里"*"表示支持全部请求头
                        .allowedHeaders("*")

                        //暴露哪些头部信息（因为跨域访问默认不能获取全部头部信息）      表示允许暴露哪些响应头，这里特指那些非简单的头部信息，所以用"*"无效。 eg:exposedHeaders("Header1", "Header2");
                        .exposedHeaders(HttpHeaders.AUTHORIZATION);
            }
        };
    }

    /**
     * 3. 使用注解（局部跨域）
     * 在方法上（@RequestMapping）使用注解 @CrossOrigin ：
     *     @RequestMapping("/hello")
     *     @ResponseBody
     *     @CrossOrigin("http://localhost:8080")
     *     public String index( ){
     *         return "Hello World";
     *     }
     *
     * 或者在控制器（@Controller）上使用注解 @CrossOrigin ：
     *     @Controller
     *     @CrossOrigin(origins = "http://xx-domain.com", maxAge = 3600)
     *     public class AccountController {
     *          @RequestMapping("/hello")
     *          @ResponseBody
     *          public String index( ){
     *              return "Hello World";
     *          }
     *     }
     *
     *
     *  4. 手工设置响应头（局部跨域 ）
     *  使用HttpServletResponse对象添加响应头（Access-Control-Allow-Origin）来授权原始域，这里Origin的值也可以设置为"*" ，表示全部放行。
     *     @RequestMapping("/hello")
     *     @ResponseBody
     *     public String index(HttpServletResponse response){
     *         response.addHeader("Access-Control-Allow-Origin", "http://localhost:8080");
     *         return "Hello World";
     *     }
     */

}
