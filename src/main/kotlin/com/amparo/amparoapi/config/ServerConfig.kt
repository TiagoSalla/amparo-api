package com.amparo.amparoapi.config

import org.springframework.boot.web.servlet.FilterRegistrationBean
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.UrlBasedCorsConfigurationSource
import org.springframework.web.filter.CorsFilter
import java.util.Collections


//
//import org.apache.catalina.Context
//import org.apache.catalina.connector.Connector
//import org.apache.tomcat.util.descriptor.web.SecurityCollection
//import org.apache.tomcat.util.descriptor.web.SecurityConstraint
//import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory
//import org.springframework.boot.web.servlet.server.ServletWebServerFactory
//import org.springframework.context.annotation.Bean
//import org.springframework.context.annotation.Configuration
//
//
//@Configuration
//class ServerConfig {
//    @Bean
//    fun servletContainer(): ServletWebServerFactory {
//        val tomcat: TomcatServletWebServerFactory = object : TomcatServletWebServerFactory() {
//            override fun postProcessContext(context: Context) {
//                val securityConstraint = SecurityConstraint()
//                securityConstraint.userConstraint = "CONFIDENTIAL"
//                val collection = SecurityCollection()
//                collection.addPattern("/*")
//                securityConstraint.addCollection(collection)
//                context.addConstraint(securityConstraint)
//            }
//        }
//        tomcat.addAdditionalTomcatConnectors(httpConnector)
//        return tomcat
//    }
//
//    private val httpConnector: Connector
//        get() {
//            val connector = Connector(TomcatServletWebServerFactory.DEFAULT_PROTOCOL)
//            connector.scheme = "http"
//            connector.port = 8080
//            connector.secure = false
//            connector.redirectPort = 8080
//            return connector
//        }
//}

@Configuration
class CorsConfig {
    @Bean
    fun corsConfiguration(): FilterRegistrationBean<CorsFilter> {
        val corsConfiguration = CorsConfiguration()
        corsConfiguration.allowCredentials = true
        corsConfiguration.addAllowedOrigin("*")
        corsConfiguration.addAllowedMethod("*")
        corsConfiguration.addAllowedHeader("*")
        corsConfiguration.exposedHeaders = Collections.singletonList("Location")
        val urlBasedCorsConfigurationSource = UrlBasedCorsConfigurationSource()
        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration)
        val filter: FilterRegistrationBean<CorsFilter> =
            FilterRegistrationBean<CorsFilter>(CorsFilter(urlBasedCorsConfigurationSource))
        filter.order = 0
        return filter
    }
}