package com.example.weichatsell.config;

import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * @author zhanghao
 * @date 2018/05/07
 */
@Data
@Component
public class WebSocketConfig {
    //    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }
}
