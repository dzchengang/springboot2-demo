package com.sdstc.com4j.lib  ;

import com4j.*;

/**
 * Application Lifecyle Management Site Administration Client
 */
@IID("{744B2094-AEBB-4057-887F-0A66AFB598D4}")
public interface ISAapi4 extends com.sdstc.com4j.lib.ISAapi3 {
  // Methods:
  /**
   * <p>
   * Verifies the project.
   * </p>
   * @param domainName Mandatory java.lang.String parameter.
   * @param projectName Mandatory java.lang.String parameter.
   * @param level Mandatory java.lang.String parameter.
   * @return  Returns a value of type java.lang.String
   */

  @DISPID(66) //= 0x42. The runtime will prefer the VTID if present
  @VTID(71)
  java.lang.String verify(
    java.lang.String domainName,
    java.lang.String projectName,
    java.lang.String level);


  /**
   * <p>
   * Repairs the project.
   * </p>
   * @param domainName Mandatory java.lang.String parameter.
   * @param projectName Mandatory java.lang.String parameter.
   * @param mode Mandatory java.lang.String parameter.
   * @return  Returns a value of type java.lang.String
   */

  @DISPID(67) //= 0x43. The runtime will prefer the VTID if present
  @VTID(72)
  java.lang.String repair(
    java.lang.String domainName,
    java.lang.String projectName,
    java.lang.String mode);


  /**
   * <p>
   * Upgrades the project.
   * </p>
   * @param domainName Mandatory java.lang.String parameter.
   * @param projectName Mandatory java.lang.String parameter.
   * @param mode Mandatory java.lang.String parameter.
   * @return  Returns a value of type java.lang.String
   */

  @DISPID(68) //= 0x44. The runtime will prefer the VTID if present
  @VTID(73)
  java.lang.String upgrade(
    java.lang.String domainName,
    java.lang.String projectName,
    java.lang.String mode);


  /**
   * <p>
   * Returns the progress of Verify, Repair, and Upgrade tasks.
   * </p>
   * @param domainName Mandatory java.lang.String parameter.
   * @param projectName Mandatory java.lang.String parameter.
   * @return  Returns a value of type java.lang.String
   */

  @DISPID(69) //= 0x45. The runtime will prefer the VTID if present
  @VTID(74)
  java.lang.String readMaintenanceTaskProgress(
    java.lang.String domainName,
    java.lang.String projectName);


  /**
   * <p>
   * Cancels Verify, Repair, and Upgrade tasks
   * </p>
   * @param domainName Mandatory java.lang.String parameter.
   * @param projectName Mandatory java.lang.String parameter.
   */

  @DISPID(70) //= 0x46. The runtime will prefer the VTID if present
  @VTID(75)
  void abortMaintenanceTask(
    java.lang.String domainName,
    java.lang.String projectName);


  /**
   * <p>
   * Pauses Verify, Repair, and Upgrade tasks.
   * </p>
   * @param domainName Mandatory java.lang.String parameter.
   * @param projectName Mandatory java.lang.String parameter.
   */

  @DISPID(71) //= 0x47. The runtime will prefer the VTID if present
  @VTID(76)
  void pauseMaintenanceTask(
    java.lang.String domainName,
    java.lang.String projectName);


  /**
   * <p>
   * Resumes paused Verify, Repair, and Upgrade tasks.
   * </p>
   * @param domainName Mandatory java.lang.String parameter.
   * @param projectName Mandatory java.lang.String parameter.
   */

  @DISPID(72) //= 0x48. The runtime will prefer the VTID if present
  @VTID(77)
  void continueMaintenanceTask(
    java.lang.String domainName,
    java.lang.String projectName);


  /**
   * <p>
   * Returns the list of users in a project.
   * </p>
   * @param domainName Mandatory java.lang.String parameter.
   * @param projectName Mandatory java.lang.String parameter.
   * @return  Returns a value of type java.lang.String
   */

  @DISPID(73) //= 0x49. The runtime will prefer the VTID if present
  @VTID(78)
  java.lang.String getUsersInProject(
    java.lang.String domainName,
    java.lang.String projectName);


  /**
   * <p>
   * Removes a list of users from a project.
   * </p>
   * @param domainName Mandatory java.lang.String parameter.
   * @param projectName Mandatory java.lang.String parameter.
   * @param users Mandatory java.lang.String parameter.
   * @return  Returns a value of type java.lang.String
   */

  @DISPID(74) //= 0x4a. The runtime will prefer the VTID if present
  @VTID(79)
  java.lang.String removeUsersFromProject(
    java.lang.String domainName,
    java.lang.String projectName,
    java.lang.String users);


  /**
   * <p>
   * Creates a new project of the specified type with option to create a template project.
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
   * @return  Returns a value of type java.lang.String
   */

  @DISPID(75) //= 0x4b. The runtime will prefer the VTID if present
  @VTID(80)
  java.lang.String createProject2(
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
    int creationOptions);


  /**
   * <p>
   * Creates a new project of the specified type with option to create a template project by copying the specifed data and properties from an existing project.
   * </p>
   * @param domainName Mandatory java.lang.String parameter.
   * @param newProjectName Mandatory java.lang.String parameter.
   * @param isTemplate Mandatory boolean parameter.
   * @param projectType Mandatory java.lang.String parameter.
   * @param newDbType Mandatory int parameter.
   * @param sourceDomainName Mandatory java.lang.String parameter.
   * @param sourceProjectName Mandatory java.lang.String parameter.
   * @param dbServerName Mandatory java.lang.String parameter.
   * @param adminUser Mandatory java.lang.String parameter.
   * @param adminPassword Mandatory java.lang.String parameter.
   * @param tableSpace Mandatory java.lang.String parameter.
   * @param tempTableSpace Mandatory java.lang.String parameter.
   * @param copyOptions Mandatory int parameter.
   * @param creationOptions Mandatory int parameter.
   * @return  Returns a value of type java.lang.String
   */

  @DISPID(76) //= 0x4c. The runtime will prefer the VTID if present
  @VTID(81)
  java.lang.String createProjectCopy2(
    java.lang.String domainName,
    java.lang.String newProjectName,
    boolean isTemplate,
    java.lang.String projectType,
    int newDbType,
    java.lang.String sourceDomainName,
    java.lang.String sourceProjectName,
    java.lang.String dbServerName,
    java.lang.String adminUser,
    java.lang.String adminPassword,
    java.lang.String tableSpace,
    java.lang.String tempTableSpace,
    int copyOptions,
    int creationOptions);


  /**
   * <p>
   * Links a project to a set of projects.
   * </p>
   * @param remoteDomain Mandatory java.lang.String parameter.
   * @param remoteProject Mandatory java.lang.String parameter.
   * @param localDomain Mandatory java.lang.String parameter.
   * @param localProjects Mandatory java.lang.String parameter.
   * @param linkType Mandatory java.lang.String parameter.
   * @return  Returns a value of type java.lang.String
   */

  @DISPID(77) //= 0x4d. The runtime will prefer the VTID if present
  @VTID(82)
  java.lang.String linkProjects(
    java.lang.String remoteDomain,
    java.lang.String remoteProject,
    java.lang.String localDomain,
    java.lang.String localProjects,
    java.lang.String linkType);


  /**
   * <p>
   * Unlinks a project from a set of projects.
   * </p>
   * @param remoteDomain Mandatory java.lang.String parameter.
   * @param remoteProject Mandatory java.lang.String parameter.
   * @param localDomain Mandatory java.lang.String parameter.
   * @param localProjects Mandatory java.lang.String parameter.
   * @param linkType Mandatory java.lang.String parameter.
   * @return  Returns a value of type java.lang.String
   */

  @DISPID(78) //= 0x4e. The runtime will prefer the VTID if present
  @VTID(83)
  java.lang.String unlinkProjects(
    java.lang.String remoteDomain,
    java.lang.String remoteProject,
    java.lang.String localDomain,
    java.lang.String localProjects,
    java.lang.String linkType);


  /**
   * <p>
   * Unlinks all projects from the specified project by link type.
   * </p>
   * @param remoteDomain Mandatory java.lang.String parameter.
   * @param remoteProject Mandatory java.lang.String parameter.
   * @param linkType Mandatory java.lang.String parameter.
   * @return  Returns a value of type java.lang.String
   */

  @DISPID(79) //= 0x4f. The runtime will prefer the VTID if present
  @VTID(84)
  java.lang.String unlinkProjectsByType(
    java.lang.String remoteDomain,
    java.lang.String remoteProject,
    java.lang.String linkType);


  /**
   * <p>
   * Unlinks all projects from the specified project.
   * </p>
   * @param remoteDomain Mandatory java.lang.String parameter.
   * @param remoteProject Mandatory java.lang.String parameter.
   * @return  Returns a value of type java.lang.String
   */

  @DISPID(80) //= 0x50. The runtime will prefer the VTID if present
  @VTID(85)
  java.lang.String unlinkAllProjects(
    java.lang.String remoteDomain,
    java.lang.String remoteProject);


  /**
   * <p>
   * Returns a list of projects linked to a project and returns their properties.
   * </p>
   * @param remoteDomain Mandatory java.lang.String parameter.
   * @param remoteProject Mandatory java.lang.String parameter.
   * @param linkType Mandatory java.lang.String parameter.
   * @return  Returns a value of type java.lang.String
   */

  @DISPID(81) //= 0x51. The runtime will prefer the VTID if present
  @VTID(86)
  java.lang.String getLinkedProjects(
    java.lang.String remoteDomain,
    java.lang.String remoteProject,
    java.lang.String linkType);


  /**
   * <p>
   * Restores an existing project to a domain with option to replace.
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
   * @return  Returns a value of type java.lang.String
   */

  @DISPID(82) //= 0x52. The runtime will prefer the VTID if present
  @VTID(87)
  java.lang.String restoreProjectEx(
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
    boolean replaceProject);


  /**
   * <p>
   * Imports a project from file with option to replace.
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
   * @param replaceProject Mandatory boolean parameter.
   * @param fileName Mandatory java.lang.String parameter.
   */

  @DISPID(83) //= 0x53. The runtime will prefer the VTID if present
  @VTID(88)
  void importProjectEx(
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
    boolean replaceProject,
    java.lang.String fileName);


  // Properties:
}
