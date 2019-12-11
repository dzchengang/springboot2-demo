package com.sdstc.com4j.lib  ;

import com4j.*;

/**
 * Application Lifecyle Management Site Administration Client
 */
@IID("{266BB225-D9ED-413F-AA62-9FC23D9FE96D}")
public interface ISAapi6 extends com.sdstc.com4j.lib.ISAapi5 {
  // Methods:
  /**
   * <p>
   * For HP use. Get status of the DB Configuration for QC Sense.
   * </p>
   * @param dbConfig Mandatory java.lang.String parameter.
   * @return  Returns a value of type int
   */

  @DISPID(105) //= 0x69. The runtime will prefer the VTID if present
  @VTID(111)
  int getPerformanceMonitorDbConfigurationStatus(
    java.lang.String dbConfig);


  /**
   * <p>
   * For HP use. Create DB storage for QC Sense.
   * </p>
   * @param dbConfig Mandatory java.lang.String parameter.
   */

  @DISPID(106) //= 0x6a. The runtime will prefer the VTID if present
  @VTID(112)
  void createPerformanceMonitorStorage(
    java.lang.String dbConfig);


  /**
   * <p>
   * For HP use. Returns table space info in XML format.
   * </p>
   * @param dbServerUrl Mandatory java.lang.String parameter.
   * @param dbAdminUser Mandatory java.lang.String parameter.
   * @param dbAdminPassword Mandatory java.lang.String parameter.
   * @return  Returns a value of type java.lang.String
   */

  @DISPID(107) //= 0x6b. The runtime will prefer the VTID if present
  @VTID(113)
  java.lang.String getTablespaceInfo(
    java.lang.String dbServerUrl,
    java.lang.String dbAdminUser,
    java.lang.String dbAdminPassword);


  /**
   * <p>
   * Validates Rich Text before conversion to ALM version 11 format.
   * </p>
   * @param domainName Mandatory java.lang.String parameter.
   * @param projectName Mandatory java.lang.String parameter.
   * @return  Returns a value of type int
   */

  @DISPID(108) //= 0x6c. The runtime will prefer the VTID if present
  @VTID(114)
  int verifyRichText(
    java.lang.String domainName,
    java.lang.String projectName);


  /**
   * <p>
   * Converts Rich Text to ALM version 11 format.
   * </p>
   * @param domainName Mandatory java.lang.String parameter.
   * @param projectName Mandatory java.lang.String parameter.
   * @return  Returns a value of type int
   */

  @DISPID(109) //= 0x6d. The runtime will prefer the VTID if present
  @VTID(115)
  int convertRichText(
    java.lang.String domainName,
    java.lang.String projectName);


  /**
   * <p>
   * Sets the ALM Platform log level for a particular server.
   * </p>
   * @param serverName Mandatory java.lang.String parameter.
   * @param logLevel Mandatory int parameter.
   */

  @DISPID(110) //= 0x6e. The runtime will prefer the VTID if present
  @VTID(116)
  void setTDLogLevel(
    java.lang.String serverName,
    int logLevel);


  /**
   * <p>
   * Returns the ALM Platform log level for a particular server.
   * </p>
   * @param serverName Mandatory java.lang.String parameter.
   * @return  Returns a value of type int
   */

  @DISPID(111) //= 0x6f. The runtime will prefer the VTID if present
  @VTID(117)
  int getTDLogLevel(
    java.lang.String serverName);


  /**
   * <p>
   * Sets the Site Administration log level for a particular server.
   * </p>
   * @param serverName Mandatory java.lang.String parameter.
   * @param logLevel Mandatory int parameter.
   */

  @DISPID(112) //= 0x70. The runtime will prefer the VTID if present
  @VTID(118)
  void setSALogLevel(
    java.lang.String serverName,
    int logLevel);


  /**
   * <p>
   * Returns the Site Administration log level for a particular server.
   * </p>
   * @param serverName Mandatory java.lang.String parameter.
   * @return  Returns a value of type int
   */

  @DISPID(113) //= 0x71. The runtime will prefer the VTID if present
  @VTID(119)
  int getSALogLevel(
    java.lang.String serverName);


  // Properties:
}
