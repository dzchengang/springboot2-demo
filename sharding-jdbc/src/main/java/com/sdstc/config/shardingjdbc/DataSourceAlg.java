package com.sdstc.config.shardingjdbc;

import java.util.Collection;

import org.apache.shardingsphere.api.sharding.complex.ComplexKeysShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.complex.ComplexKeysShardingValue;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class DataSourceAlg implements ComplexKeysShardingAlgorithm<String>{

	@Override
	public Collection<String> doSharding(Collection<String> availableTargetNames, ComplexKeysShardingValue<String> shardingValue) {
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			log.info("availableTargetNames:" + mapper.writeValueAsString(availableTargetNames)+ ",shardingValues:" + mapper.writeValueAsString(shardingValue));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}

	

}
