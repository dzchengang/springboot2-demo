package com.sdstc.com4j.lib  ;

import com4j.*;

/**
 * Application Lifecyle Management Site Administration Client
 */
@IID("{8068CA64-01CD-46DF-BCD9-45AB8821DEC9}")
public interface ISAapi5 extends com.sdstc.com4j.lib.ISAapi4 {
  // Methods:
  /**
   * <p>
   * Returns the properties of all projects or of all properties of the specified type.
   * </p>
   * @param projectType Optional parameter. Default value is ""
   * @return  Returns a value of type java.lang.String
   */

  @DISPID(84) //= 0x54. The runtime will prefer the VTID if present
  @VTID(89)
  java.lang.String getAllProjects(
    @Optional @DefaultValue("") java.lang.String projectType);


  /**
   * <p>
   * Returns the version of ALM core schema.
   * </p>
   * @return  Returns a value of type java.lang.String
   */

  @DISPID(85) //= 0x55. The runtime will prefer the VTID if present
  @VTID(90)
  java.lang.String getVersion();


  /**
   * <p>
   * Creates a new project of the specified type and enables extensions by the given extension names.
   * </p>
   * @param domainName Mandatory java.lang.String parameter.
   * @param projectName Mandatory java.lang.String parameter.
   * @param isTemplate Mandatory boolean parameter.
   * @param projectType Mandatory java.lang.String parameter.
   * @param dbType Mandatory int parameter.
   * @param dbServerName Mandatory java.lang.String parameter.
   * @param adminUser Mandatory java.lang.String parameter.
   * @param adminPassword Mandatory java.lang.String parameter.
   * @param tableSpace Mandatory java.lang.String parameter.
   * @param tempTableSpace Mandatory java.lang.String parameter.
   * @param creationOptions Mandatory int parameter.
   * @param vExtensionNames Mandatory java.lang.Object parameter.
   * @return  Returns a value of type java.lang.String
   */

  @DISPID(86) //= 0x56. The runtime will prefer the VTID if present
  @VTID(91)
  java.lang.String createProject3(
    java.lang.String domainName,
    java.lang.String projectName,
    boolean isTemplate,
    java.lang.String projectType,
    int dbType,
    java.lang.String dbServerName,
    java.lang.String adminUser,
    java.lang.String adminPassword,
    java.lang.String tableSpace,
    java.lang.String tempTableSpace,
    int creationOptions,
    @MarshalAs(NativeType.VARIANT) java.lang.Object vExtensionNames);


  /**
   * <p>
   * Returns the PPU licenses that were used in the specified domain during the specified time period.
   * </p>
   * @param domainName Mandatory java.lang.String parameter.
   * @param start Mandatory java.lang.String parameter.
   * @param end Mandatory java.lang.String parameter.
   * @return  Returns a value of type java.lang.String
   */

  @DISPID(87) //= 0x57. The runtime will prefer the VTID if present
  @VTID(92)
  java.lang.String getLicenseConsumption(
    java.lang.String domainName,
    java.lang.String start,
    java.lang.String end);


  /**
   * <p>
   * Deactivates an ALM site user.
   * </p>
   * @param userName Mandatory java.lang.String parameter.
   * @return  Returns a value of type java.lang.String
   */

  @DISPID(88) //= 0x58. The runtime will prefer the VTID if present
  @VTID(93)
  java.lang.String deactivateUser(
    java.lang.String userName);


  /**
   * <p>
   * Activates an ALM site user.
   * </p>
   * @param userName Mandatory java.lang.String parameter.
   * @return  Returns a value of type java.lang.String
   */

  @DISPID(89) //= 0x59. The runtime will prefer the VTID if present
  @VTID(94)
  java.lang.String activateUser(
    java.lang.String userName);


  /**
   * <p>
   * Sets an expiration date for an ALM site user.
   * </p>
   * @param userName Mandatory java.lang.String parameter.
   * @param expirationDate Mandatory java.lang.String parameter.
   * @return  Returns a value of type java.lang.String
   */

  @DISPID(90) //= 0x5a. The runtime will prefer the VTID if present
  @VTID(95)
  java.lang.String setUserExpirationDate(
    java.lang.String userName,
    java.lang.String expirationDate);


  /**
   * <p>
   * For HP use. Creates a new project and retrieves project properties. Without smart repository. This was needed for the PC repository migration tool.
   * </p>
   * @param domainName Mandatory java.lang.String parameter.
   * @param projectName Mandatory java.lang.String parameter.
   * @param isTemplate Mandatory boolean parameter.
   * @param projectType Mandatory java.lang.String parameter.
   * @param dbType Mandatory int parameter.
   * @param dbServerName Mandatory java.lang.String parameter.
   * @param adminUser Mandatory java.lang.String parameter.
   * @param adminPassword Mandatory java.lang.String parameter.
   * @param tableSpace Mandatory java.lang.String parameter.
   * @param tempTableSpace Mandatory java.lang.String parameter.
   * @param creationOptions Mandatory int parameter.
   * @param callerID Mandatory java.lang.String parameter.
   * @return  Returns a value of type java.lang.String
   */

  @DISPID(91) //= 0x5b. The runtime will prefer the VTID if present
  @VTID(96)
  java.lang.String _CreateProject2(
    java.lang.String domainName,
    java.lang.String projectName,
    boolean isTemplate,
    java.lang.String projectType,
    int dbType,
    java.lang.String dbServerName,
    java.lang.String adminUser,
    java.lang.String adminPassword,
    java.lang.String tableSpace,
    java.lang.String tempTableSpace,
    int creationOptions,
    java.lang.String callerID);


  /**
   * <p>
   * For HP use. Sets the project's PR_SMART_REPOSITORY_ENABLED property to PENDING. This was needed for the PC repository migration tool.
   * </p>
   * @param domainName Mandatory java.lang.String parameter.
   * @param projectName Mandatory java.lang.String parameter.
   * @param callerID Mandatory java.lang.String parameter.
   */

  @DISPID(92) //= 0x5c. The runtime will prefer the VTID if present
  @VTID(97)
  void setProjectRepositoryStatusToPending(
    java.lang.String domainName,
    java.lang.String projectName,
    java.lang.String callerID);


  /**
   * <p>
   * Returns the site license status.
   * </p>
   * @param domainName Mandatory java.lang.String parameter.
   * @return  Returns a value of type java.lang.String
   */

  @DISPID(93) //= 0x5d. The runtime will prefer the VTID if present
  @VTID(98)
  java.lang.String getLicenseStatus(
    java.lang.String domainName);


  /**
   * <p>
   * Obsolete. Throws exception if invoked.
   * </p>
   * @param from Mandatory java.lang.String parameter.
   * @param to Mandatory java.lang.String parameter.
   * @param licenseTypes Mandatory java.lang.Object parameter.
   * @param licenseQuotas Mandatory java.lang.Object parameter.
   * @return  Returns a value of type boolean
   */

  @DISPID(94) //= 0x5e. The runtime will prefer the VTID if present
  @VTID(99)
  boolean moveLicenseQuotas(
    java.lang.String from,
    java.lang.String to,
    @MarshalAs(NativeType.VARIANT) java.lang.Object licenseTypes,
    @MarshalAs(NativeType.VARIANT) java.lang.Object licenseQuotas);


  /**
   * <p>
   * Sets the value of the specified project parameter. If the parameter is not defined, creates it.
   * </p>
   * @param domainName Mandatory java.lang.String parameter.
   * @param projectName Mandatory java.lang.String parameter.
   * @param paramName Mandatory java.lang.String parameter.
   * @param paramValue Mandatory java.lang.String parameter.
   */

  @DISPID(95) //= 0x5f. The runtime will prefer the VTID if present
  @VTID(100)
  void setProjectParam(
    java.lang.String domainName,
    java.lang.String projectName,
    java.lang.String paramName,
    java.lang.String paramValue);


  /**
   * <p>
   * Deletes the specified project parameter.
   * </p>
   * @param domainName Mandatory java.lang.String parameter.
   * @param projectName Mandatory java.lang.String parameter.
   * @param paramName Mandatory java.lang.String parameter.
   */

  @DISPID(96) //= 0x60. The runtime will prefer the VTID if present
  @VTID(101)
  void deleteProjectParam(
    java.lang.String domainName,
    java.lang.String projectName,
    java.lang.String paramName);


  /**
   * <p>
   * For HP use. Returns the Performance Monitor Configuration XML String.
   * </p>
   * <p>
   * Getter method for the COM property "PerformanceMonitorConfig"
   * </p>
   * @return  Returns a value of type java.lang.String
   */

  @DISPID(97) //= 0x61. The runtime will prefer the VTID if present
  @VTID(102)
  java.lang.String performanceMonitorConfig();


  /**
   * <p>
   * For HP use. Returns the Performance Monitor Configuration XML String.
   * </p>
   * <p>
   * Setter method for the COM property "PerformanceMonitorConfig"
   * </p>
   * @param pVal Mandatory java.lang.String parameter.
   */

  @DISPID(97) //= 0x61. The runtime will prefer the VTID if present
  @VTID(103)
  void performanceMonitorConfig(
    java.lang.String pVal);


  /**
   * <p>
   * Obsolete. Throws exception if invoked.
   * </p>
   */

  @DISPID(98) //= 0x62. The runtime will prefer the VTID if present
  @VTID(104)
  void activateDomainLicensePool();


  /**
   * <p>
   * Obsolete. Throws exception if invoked.
   * </p>
   */

  @DISPID(99) //= 0x63. The runtime will prefer the VTID if present
  @VTID(105)
  void deactivateDomainLicensePool();


  /**
   * <p>
   * Obsolete. Throws exception if invoked.
   * </p>
   * @return  Returns a value of type boolean
   */

  @DISPID(100) //= 0x64. The runtime will prefer the VTID if present
  @VTID(106)
  boolean isActiveDomainLicensePool();


  /**
   * <p>
   * Restores an existing project to a domain with option to replace and option to restore project with smart repository enabled.
   * </p>
   * @param domainName Mandatory java.lang.String parameter.
   * @param projectName Mandatory java.lang.String parameter.
   * @param dbType Mandatory int parameter.
   * @param physicalDirectory Mandatory java.lang.String parameter.
   * @param dbName Mandatory java.lang.String parameter.
   * @param dbServerName Mandatory java.lang.String parameter.
   * @param connStr Mandatory java.lang.String parameter.
   * @param dbUserPass Mandatory java.lang.String parameter.
   * @param prIsActive Mandatory boolean parameter.
   * @param prHasVcsDb Mandatory boolean parameter.
   * @param saqIsActive Mandatory boolean parameter.
   * @param userQuota Mandatory int parameter.
   * @param vmRepository Mandatory java.lang.String parameter.
   * @param description Mandatory java.lang.String parameter.
   * @param projectType Mandatory java.lang.String parameter.
   * @param prIsTemplate Mandatory boolean parameter.
   * @param projectUID Mandatory java.lang.String parameter.
   * @param replaceProject Mandatory boolean parameter.
   * @param smartRepositoryEnabled Mandatory boolean parameter.
   * @return  Returns a value of type java.lang.String
   */

  @DISPID(101) //= 0x65. The runtime will prefer the VTID if present
  @VTID(107)
  java.lang.String restoreProjectEx2(
    java.lang.String domainName,
    java.lang.String projectName,
    int dbType,
    java.lang.String physicalDirectory,
    java.lang.String dbName,
    java.lang.String dbServerName,
    java.lang.String connStr,
    java.lang.String dbUserPass,
    boolean prIsActive,
    boolean prHasVcsDb,
    boolean saqIsActive,
    int userQuota,
    java.lang.String vmRepository,
    java.lang.String description,
    java.lang.String projectType,
    boolean prIsTemplate,
    java.lang.String projectUID,
    boolean replaceProject,
    boolean smartRepositoryEnabled);


  /**
   * <p>
   * Returns the XML description of license types.
   * </p>
   * @return  Returns a value of type java.lang.String
   */

  @DISPID(102) //= 0x66. The runtime will prefer the VTID if present
  @VTID(108)
  java.lang.String getLicenseTypesList();


  /**
   * <p>
   * For HP use. Returns the Performance Monitor Default Configuration XML String.
   * </p>
   * @return  Returns a value of type java.lang.String
   */

  @DISPID(103) //= 0x67. The runtime will prefer the VTID if present
  @VTID(109)
  java.lang.String getPerformanceMonitorDefaultConfig();


  /**
   * <p>
   * Realigns an optimized repository that was created from a snapshot.
   * </p>
   * @param domainName Mandatory java.lang.String parameter.
   * @param projectName Mandatory java.lang.String parameter.
   * @param mode Mandatory java.lang.String parameter.
   * @return  Returns a value of type java.lang.String
   */

  @DISPID(104) //= 0x68. The runtime will prefer the VTID if present
  @VTID(110)
  java.lang.String alignRepository(
    java.lang.String domainName,
    java.lang.String projectName,
    java.lang.String mode);


  // Properties:
}
