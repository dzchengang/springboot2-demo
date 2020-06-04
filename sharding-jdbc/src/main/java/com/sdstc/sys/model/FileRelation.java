package com.sdstc.sys.model;

import org.apache.shardingsphere.shardingjdbc.jdbc.core.statement.ShardingPreparedStatement;

import lombok.Data;

@Data
public class FileRelation {
   private String id;
   private Integer tenantId;
   private String fileId;
   private String name;
}
