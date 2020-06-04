package com.sdstc.sys.model;

import java.util.List;

import lombok.Data;

@Data
public class File {
   private String id;
   private Integer tenantId;
   private String name;
   
   List<File> files;
}
