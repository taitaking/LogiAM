package com.didichuxing.datachannel.agentmanager.common.bean.dto.receiver;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author huqidong
 * @date 2020-09-21
 * kafka集群对象
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReceiverCreateDTO {

    @ApiModelProperty(value = "kafka集群名 必填")
    private String kafkaClusterName;

    @ApiModelProperty(value = "kafka集群broker配置 必填")
    private String kafkaClusterBrokerConfiguration;

    @ApiModelProperty(value = "kafka集群对应生产端初始化配置 必填")
    private String kafkaClusterProducerInitConfiguration;

    public void setKafkaClusterName(String kafkaClusterName) {
        this.kafkaClusterName = kafkaClusterName;
    }

    public void setKafkaClusterBrokerConfiguration(String kafkaClusterBrokerConfiguration) {
        this.kafkaClusterBrokerConfiguration = kafkaClusterBrokerConfiguration;
    }

    public void setKafkaClusterProducerInitConfiguration(String kafkaClusterProducerInitConfiguration) {
        this.kafkaClusterProducerInitConfiguration = kafkaClusterProducerInitConfiguration;
    }

    public String getKafkaClusterName() {
        return kafkaClusterName;
    }

    public String getKafkaClusterBrokerConfiguration() {
        return kafkaClusterBrokerConfiguration;
    }

    public String getKafkaClusterProducerInitConfiguration() {
        return kafkaClusterProducerInitConfiguration;
    }

}