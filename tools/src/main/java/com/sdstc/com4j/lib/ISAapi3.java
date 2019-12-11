package com.sdstc.com4j.lib  ;

import com4j.*;

/**
 * Application Lifecyle Management Site Administration Client
 */
@IID("{5E6F6F91-CAC2-4063-8919-81005D362737}")
public interface ISAapi3 extends com.sdstc.com4j.lib.ISAapi2 {
  // Methods:
  /**
   * <p>
   * Exports project to file.
   * </p>
   * @param domainName Mandatory java.lang.String parameter.
   * @param projectName Mandatory java.lang.String parameter.
   * @param fileName Mandatory java.lang.String parameter.
   */

  @DISPID(60) //= 0x3c. The runtime will prefer the VTID if present
  @VTID(66)
  void exportProject(
    java.lang.String domainName,
    java.lang.String projectName,
    java.lang.String fileName);


  /**
   * <p>
   * Imports project from file.
   * </p>
   * @param domainName Mandatory java.lang.String parameter.
   * @param projectName Mandatory java.lang.String parameter.
   * @param dbType Mandatory int parameter.
   * @param dbServerName Mandatory java.lang.String parameter.
   * @param adminUser Mandatory java.lang.String parameter.
   * @param adminPassword Mandatory java.lang.String parameter.
   * @param tableSpace Mandatory java.lang.String parameter.
   * @param tempTableSpace Mandatory java.lang.String parameter.
   * @param tableSpaceSize Mandatory int parameter.
   * @param tempTableSpaceSize Mandatory int parameter.
   * @param creationOptions Mandatory int parameter.
   * @param fileName Mandatory java.lang.String parameter.
   */

  @DISPID(61) //= 0x3d. The runtime will prefer the VTID if present
  @VTID(67)
  void importProject(
    java.lang.String domainName,
    java.lang.String projectName,
    int dbType,
    java.lang.String dbServerName,
    java.lang.String adminUser,
    java.lang.String adminPassword,
    java.lang.String tableSpace,
    java.lang.String tempTableSpace,
    int tableSpaceSize,
    int tempTableSpaceSize,
    int creationOptions,
    java.lang.String fileName);


  /**
   * <p>
   * Defines a new database server.
   * </p>
   * @param dbType Mandatory int parameter.
   * @param dbServerName Mandatory java.lang.String parameter.
   * @param dbAdminUser Mandatory java.lang.String parameter.
   * @param dbAdminPassword Mandatory java.lang.String parameter.
   * @param dbUserPassword Mandatory java.lang.String parameter.
   * @param connectionStringFormat Mandatory java.lang.String parameter.
   * @param isSQLWinAuth Optional parameter. Default value is false
   * @return  Returns a value of type java.lang.String
   */

  @DISPID(62) //= 0x3e. The runtime will prefer the VTID if present
  @VTID(68)
  java.lang.String addDBServerExt(
    int dbType,
    java.lang.String dbServerName,
    java.lang.String dbAdminUser,
    java.lang.String dbAdminPassword,
    java.lang.String dbUserPassword,
    java.lang.String connectionStringFormat,
    @Optional @DefaultValue("0") boolean isSQLWinAuth);


  /**
   * <p>
   * Enables extensions for the specified project.
   * </p>
   * @param domainName Mandatory java.lang.String parameter.
   * @param projectName Mandatory java.lang.String parameter.
   * @param vExtensionNames Mandatory java.lang.Object parameter.
   * @return  Returns a value of type java.lang.String
   */

  @DISPID(63) //= 0x3f. The runtime will prefer the VTID if present
  @VTID(69)
  java.lang.String enableExtensionsForProject(
    java.lang.String domainName,
    java.lang.String projectName,
    @MarshalAs(NativeType.VARIANT) java.lang.Object vExtensionNames);


  /**
   * <p>
   * Returns the list of enabled extensions.
   * </p>
   * @param domainName Mandatory java.lang.String parameter.
   * @param projectName Mandatory java.lang.String parameter.
   * @return  Returns a value of type java.lang.String
   */

  @DISPID(64) //= 0x40. The runtime will prefer the VTID if present
  @VTID(70)
  java.lang.String getEnabledExtensionsForProject(
    java.lang.String domainName,
    java.lang.String projectName);


  // Properties:
}
