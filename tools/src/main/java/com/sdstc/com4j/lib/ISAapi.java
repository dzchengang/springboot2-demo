package com.sdstc.com4j.lib  ;

import com4j.*;

/**
 * Application Lifecyle Management Site Administration Client
 */
@IID("{DCD37CAB-04B6-47D3-AD9A-ECE60B9D84C3}")
public interface ISAapi extends Com4jObject {
  // Methods:
  /**
   * <p>
   * Connects the Site Administrator client to the Site Administration server. Called before any other method in this interface.
   * </p>
   * @param domainserver Mandatory java.lang.String parameter.
   * @param password Mandatory java.lang.String parameter.
   * @return  Returns a value of type java.lang.String
   */

  @DISPID(1) //= 0x1. The runtime will prefer the VTID if present
  @VTID(7)
  java.lang.String connect(
    java.lang.String domainserver,
    java.lang.String password);


  /**
   * <p>
   * Creates a new project and retrieves project properties.
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
   * @return  Returns a value of type java.lang.String
   */

  @DISPID(2) //= 0x2. The runtime will prefer the VTID if present
  @VTID(8)
  java.lang.String createProject(
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
    int creationOptions);


  /**
   * <p>
   * Returns the properties of one site configuration parameter.
   * </p>
   * @param paramName Mandatory java.lang.String parameter.
   * @param appType Mandatory int parameter.
   * @return  Returns a value of type java.lang.String
   */

  @DISPID(3) //= 0x3. The runtime will prefer the VTID if present
  @VTID(9)
  java.lang.String getSiteSingleParam(
    java.lang.String paramName,
    int appType);


  /**
   * <p>
   * Returns the properties of all site configuration parameters.
   * </p>
   * @return  Returns a value of type java.lang.String
   */

  @DISPID(4) //= 0x4. The runtime will prefer the VTID if present
  @VTID(10)
  java.lang.String getSiteAllParams();


  /**
   * <p>
   * Sets the properties of one site configuration parameter.
   * </p>
   * @param paramName Mandatory java.lang.String parameter.
   * @param paramValue Mandatory java.lang.String parameter.
   * @param paramDescription Mandatory java.lang.String parameter.
   * @return  Returns a value of type java.lang.String
   */

  @DISPID(5) //= 0x5. The runtime will prefer the VTID if present
  @VTID(11)
  java.lang.String setSiteSingleParam(
    java.lang.String paramName,
    java.lang.String paramValue,
    java.lang.String paramDescription);


  /**
   * <p>
   * Deletes a site configuration parameter.
   * </p>
   * @param paramName Mandatory java.lang.String parameter.
   * @return  Returns a value of type java.lang.String
   */

  @DISPID(6) //= 0x6. The runtime will prefer the VTID if present
  @VTID(12)
  java.lang.String deleteSiteSingleParam(
    java.lang.String paramName);


  /**
   * <p>
   * Creates a new project by copying some, or all, data and properties from an existing project.
   * </p>
   * @param domainName Mandatory java.lang.String parameter.
   * @param newProjectName Mandatory java.lang.String parameter.
   * @param newDbType Mandatory int parameter.
   * @param sourceDomainName Mandatory java.lang.String parameter.
   * @param sourceProjectName Mandatory java.lang.String parameter.
   * @param dbServerName Mandatory java.lang.String parameter.
   * @param adminUser Mandatory java.lang.String parameter.
   * @param adminPassword Mandatory java.lang.String parameter.
   * @param tableSpace Mandatory java.lang.String parameter.
   * @param tempTableSpace Mandatory java.lang.String parameter.
   * @param tableSpaceSize Mandatory int parameter.
   * @param tempTableSpaceSize Mandatory int parameter.
   * @param copyOptions Mandatory int parameter.
   * @param creationOptions Mandatory int parameter.
   * @return  Returns a value of type java.lang.String
   */

  @DISPID(7) //= 0x7. The runtime will prefer the VTID if present
  @VTID(13)
  java.lang.String createProjectCopy(
    java.lang.String domainName,
    java.lang.String newProjectName,
    int newDbType,
    java.lang.String sourceDomainName,
    java.lang.String sourceProjectName,
    java.lang.String dbServerName,
    java.lang.String adminUser,
    java.lang.String adminPassword,
    java.lang.String tableSpace,
    java.lang.String tempTableSpace,
    int tableSpaceSize,
    int tempTableSpaceSize,
    int copyOptions,
    int creationOptions);


  /**
   * <p>
   * Returns all users and their properties.
   * </p>
   * @return  Returns a value of type java.lang.String
   */

  @DISPID(8) //= 0x8. The runtime will prefer the VTID if present
  @VTID(14)
  java.lang.String getAllUsers();


  /**
   * <p>
   * Returns the user properties.
   * </p>
   * @param userName Mandatory java.lang.String parameter.
   * @return  Returns a value of type java.lang.String
   */

  @DISPID(9) //= 0x9. The runtime will prefer the VTID if present
  @VTID(15)
  java.lang.String getUser(
    java.lang.String userName);


  /**
   * <p>
   * Deletes an ALM site user.
   * </p>
   * @param userName Mandatory java.lang.String parameter.
   * @return  Returns a value of type java.lang.String
   */

  @DISPID(10) //= 0xa. The runtime will prefer the VTID if present
  @VTID(16)
  java.lang.String deleteUser(
    java.lang.String userName);


  /**
   * <p>
   * method GetUsersVersion
   * </p>
   * @return  Returns a value of type java.lang.String
   */

  @DISPID(11) //= 0xb. The runtime will prefer the VTID if present
  @VTID(17)
  java.lang.String getUsersVersion();


  /**
   * <p>
   * Creates a new user and retrieves the user properties.
   * </p>
   * @param userName Mandatory java.lang.String parameter.
   * @param fullName Mandatory java.lang.String parameter.
   * @param email Mandatory java.lang.String parameter.
   * @param phone Mandatory java.lang.String parameter.
   * @param description Mandatory java.lang.String parameter.
   * @param password Mandatory java.lang.String parameter.
   * @return  Returns a value of type java.lang.String
   */

  @DISPID(12) //= 0xc. The runtime will prefer the VTID if present
  @VTID(18)
  java.lang.String createUser(
    java.lang.String userName,
    java.lang.String fullName,
    java.lang.String email,
    java.lang.String phone,
    java.lang.String description,
    java.lang.String password);


  /**
   * <p>
   * For HP use. Returns domains and users in each domain.
   * </p>
   * @param domainName Mandatory java.lang.String parameter.
   * @param userName Mandatory java.lang.String parameter.
   * @return  Returns a value of type java.lang.String
   */

  @DISPID(13) //= 0xd. The runtime will prefer the VTID if present
  @VTID(19)
  java.lang.String getDcUsers(
    java.lang.String domainName,
    java.lang.String userName);


  /**
   * <p>
   * Sets a specific user property and retrieves the user properties.
   * </p>
   * @param userName Mandatory java.lang.String parameter.
   * @param propertyNumber Mandatory int parameter.
   * @param propertyValue Mandatory java.lang.String parameter.
   * @return  Returns a value of type java.lang.String
   */

  @DISPID(14) //= 0xe. The runtime will prefer the VTID if present
  @VTID(20)
  java.lang.String setUserProperty(
    java.lang.String userName,
    int propertyNumber,
    java.lang.String propertyValue);


  /**
   * <p>
   * Creates a new site configuration parameter.
   * </p>
   * @param paramName Mandatory java.lang.String parameter.
   * @param paramValue Mandatory java.lang.String parameter.
   * @param paramDescription Mandatory java.lang.String parameter.
   * @return  Returns a value of type java.lang.String
   */

  @DISPID(15) //= 0xf. The runtime will prefer the VTID if present
  @VTID(21)
  java.lang.String createSiteSingleParam(
    java.lang.String paramName,
    java.lang.String paramValue,
    java.lang.String paramDescription);


  /**
   * <p>
   * Returns the properties of all domains.
   * </p>
   * @return  Returns a value of type java.lang.String
   */

  @DISPID(16) //= 0x10. The runtime will prefer the VTID if present
  @VTID(22)
  java.lang.String getAllDomains();


  /**
   * <p>
   * Returns the properties and projects of a domain.
   * </p>
   * @param domainName Mandatory java.lang.String parameter.
   * @return  Returns a value of type java.lang.String
   */

  @DISPID(17) //= 0x11. The runtime will prefer the VTID if present
  @VTID(23)
  java.lang.String getDomain(
    java.lang.String domainName);


  /**
   * <p>
   * Deletes a domain.
   * </p>
   * @param domainName Mandatory java.lang.String parameter.
   * @return  Returns a value of type java.lang.String
   */

  @DISPID(18) //= 0x12. The runtime will prefer the VTID if present
  @VTID(24)
  java.lang.String deleteDomain(
    java.lang.String domainName);


  /**
   * <p>
   * Creates a new domain and retrieves the domain properties.
   * </p>
   * @param domainName Mandatory java.lang.String parameter.
   * @param contactName Mandatory java.lang.String parameter.
   * @param contactEmail Mandatory java.lang.String parameter.
   * @param userQuota Mandatory int parameter.
   * @return  Returns a value of type java.lang.String
   */

  @DISPID(19) //= 0x13. The runtime will prefer the VTID if present
  @VTID(25)
  java.lang.String createDomain(
    java.lang.String domainName,
    java.lang.String contactName,
    java.lang.String contactEmail,
    int userQuota);


  /**
   * <p>
   * Sets a domain property and retrieves all domain properties.
   * </p>
   * @param domainName Mandatory java.lang.String parameter.
   * @param propertyNumber Mandatory int parameter.
   * @param propertyValue Mandatory java.lang.String parameter.
   * @return  Returns a value of type java.lang.String
   */

  @DISPID(20) //= 0x14. The runtime will prefer the VTID if present
  @VTID(26)
  java.lang.String setDomainProperty(
    java.lang.String domainName,
    int propertyNumber,
    java.lang.String propertyValue);


  /**
   * <p>
   * Deletes a project.
   * </p>
   * @param domainName Mandatory java.lang.String parameter.
   * @param projectName Mandatory java.lang.String parameter.
   * @param adminName Mandatory java.lang.String parameter.
   * @param adminPassword Mandatory java.lang.String parameter.
   * @return  Returns a value of type java.lang.String
   */

  @DISPID(21) //= 0x15. The runtime will prefer the VTID if present
  @VTID(27)
  java.lang.String deleteProject(
    java.lang.String domainName,
    java.lang.String projectName,
    java.lang.String adminName,
    java.lang.String adminPassword);


  /**
   * <p>
   * Returns the properties of all projects in a domain.
   * </p>
   * @param domainName Mandatory java.lang.String parameter.
   * @return  Returns a value of type java.lang.String
   */

  @DISPID(22) //= 0x16. The runtime will prefer the VTID if present
  @VTID(28)
  java.lang.String getAllDomainProjects(
    java.lang.String domainName);


  /**
   * <p>
   * Returns the properties of a project.
   * </p>
   * @param domainName Mandatory java.lang.String parameter.
   * @param projectName Mandatory java.lang.String parameter.
   * @return  Returns a value of type java.lang.String
   */

  @DISPID(23) //= 0x17. The runtime will prefer the VTID if present
  @VTID(29)
  java.lang.String getProject(
    java.lang.String domainName,
    java.lang.String projectName);


  /**
   * <p>
   * Returns project properties and database information.
   * </p>
   * @param domainName Mandatory java.lang.String parameter.
   * @param projectName Mandatory java.lang.String parameter.
   * @param getSchema Mandatory int parameter.
   * @param getVersion Mandatory int parameter.
   * @return  Returns a value of type java.lang.String
   */

  @DISPID(24) //= 0x18. The runtime will prefer the VTID if present
  @VTID(30)
  java.lang.String getProjectExtendedData(
    java.lang.String domainName,
    java.lang.String projectName,
    int getSchema,
    int getVersion);


  /**
   * <p>
   * Runs the SQL statement on the project database and retrieves results.
   * </p>
   * @param domainName Mandatory java.lang.String parameter.
   * @param projectName Mandatory java.lang.String parameter.
   * @param sqlQuery Mandatory java.lang.String parameter.
   * @param maxRecords Mandatory int parameter.
   * @param fromRecord Mandatory int parameter.
   * @return  Returns a value of type java.lang.String
   */

  @DISPID(25) //= 0x19. The runtime will prefer the VTID if present
  @VTID(31)
  java.lang.String runQuery(
    java.lang.String domainName,
    java.lang.String projectName,
    java.lang.String sqlQuery,
    int maxRecords,
    int fromRecord);


  /**
   * <p>
   * Disables project version control and retrieves project properties.
   * </p>
   * @param domainName Mandatory java.lang.String parameter.
   * @param projectName Mandatory java.lang.String parameter.
   * @return  Returns a value of type java.lang.String
   */

  @DISPID(26) //= 0x1a. The runtime will prefer the VTID if present
  @VTID(32)
  java.lang.String disableVersionControl(
    java.lang.String domainName,
    java.lang.String projectName);


  /**
   * <p>
   * Enables project version control and retrieves project properties.
   * </p>
   * @param domainName Mandatory java.lang.String parameter.
   * @param projectName Mandatory java.lang.String parameter.
   * @return  Returns a value of type java.lang.String
   */

  @DISPID(27) //= 0x1b. The runtime will prefer the VTID if present
  @VTID(33)
  java.lang.String enableVersionControl(
    java.lang.String domainName,
    java.lang.String projectName);


  /**
   * <p>
   * Removes a project from the list of projects in a domain without deleting the project database.
   * </p>
   * @param domainName Mandatory java.lang.String parameter.
   * @param projectName Mandatory java.lang.String parameter.
   * @return  Returns a value of type java.lang.String
   */

  @DISPID(28) //= 0x1c. The runtime will prefer the VTID if present
  @VTID(34)
  java.lang.String removeProject(
    java.lang.String domainName,
    java.lang.String projectName);


  /**
   * <p>
   * Restores an existing project to a domain.
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
   * @return  Returns a value of type java.lang.String
   */

  @DISPID(29) //= 0x1d. The runtime will prefer the VTID if present
  @VTID(35)
  java.lang.String restoreProject(
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
    java.lang.String description);


  /**
   * <p>
   * Obsolete. Use Upgrade.
   * </p>
   * @param domainName Mandatory java.lang.String parameter.
   * @param projectName Mandatory java.lang.String parameter.
   * @param upgradeOptions Mandatory int parameter.
   * @return  Returns a value of type java.lang.String
   */

  @DISPID(30) //= 0x1e. The runtime will prefer the VTID if present
  @VTID(36)
  java.lang.String upgradeProject(
    java.lang.String domainName,
    java.lang.String projectName,
    int upgradeOptions);


  /**
   * <p>
   * Tests a project’s current connection string.
   * </p>
   * @param domainName Mandatory java.lang.String parameter.
   * @param projectName Mandatory java.lang.String parameter.
   * @param connectString Mandatory java.lang.String parameter.
   * @return  Returns a value of type java.lang.String
   */

  @DISPID(31) //= 0x1f. The runtime will prefer the VTID if present
  @VTID(37)
  java.lang.String testConnection(
    java.lang.String domainName,
    java.lang.String projectName,
    java.lang.String connectString);


  /**
   * <p>
   * Sends pending emails to the users as configured in the specified project.
   * </p>
   * @param domainName Mandatory java.lang.String parameter.
   * @param projectName Mandatory java.lang.String parameter.
   * @return  Returns a value of type java.lang.String
   */

  @DISPID(32) //= 0x20. The runtime will prefer the VTID if present
  @VTID(38)
  java.lang.String sendAllQualifiedNow(
    java.lang.String domainName,
    java.lang.String projectName);


  /**
   * <p>
   * Sets the specified property to a selected value  and retrieves project properties.
   * </p>
   * @param domainName Mandatory java.lang.String parameter.
   * @param projectName Mandatory java.lang.String parameter.
   * @param propertyNumber Mandatory int parameter.
   * @param propertyValue Mandatory java.lang.String parameter.
   * @return  Returns a value of type java.lang.String
   */

  @DISPID(33) //= 0x21. The runtime will prefer the VTID if present
  @VTID(39)
  java.lang.String setProjectProperty(
    java.lang.String domainName,
    java.lang.String projectName,
    int propertyNumber,
    java.lang.String propertyValue);


  /**
   * <p>
   * Activates the project and retrieves project properties.
   * </p>
   * @param domainName Mandatory java.lang.String parameter.
   * @param projectName Mandatory java.lang.String parameter.
   * @return  Returns a value of type java.lang.String
   */

  @DISPID(34) //= 0x22. The runtime will prefer the VTID if present
  @VTID(40)
  java.lang.String activateProject(
    java.lang.String domainName,
    java.lang.String projectName);


  /**
   * <p>
   * Deactivates a project and retrieves project properties.
   * </p>
   * @param domainName Mandatory java.lang.String parameter.
   * @param projectName Mandatory java.lang.String parameter.
   * @return  Returns a value of type java.lang.String
   */

  @DISPID(35) //= 0x23. The runtime will prefer the VTID if present
  @VTID(41)
  java.lang.String deactivateProject(
    java.lang.String domainName,
    java.lang.String projectName);


  /**
   * <p>
   * Activates the Auto Mail option and retrieves project properties.
   * </p>
   * @param domainName Mandatory java.lang.String parameter.
   * @param projectName Mandatory java.lang.String parameter.
   * @return  Returns a value of type java.lang.String
   */

  @DISPID(36) //= 0x24. The runtime will prefer the VTID if present
  @VTID(42)
  java.lang.String activateSendAllQualified(
    java.lang.String domainName,
    java.lang.String projectName);


  /**
   * <p>
   * Deactivates the Auto Mail option for a specific project and retrieves project properties.
   * </p>
   * @param domainName Mandatory java.lang.String parameter.
   * @param projectName Mandatory java.lang.String parameter.
   * @return  Returns a value of type java.lang.String
   */

  @DISPID(37) //= 0x25. The runtime will prefer the VTID if present
  @VTID(43)
  java.lang.String deactivateSendAllQualified(
    java.lang.String domainName,
    java.lang.String projectName);


  /**
   * <p>
   * Moves a deactivated project to another domain and retrieves project properties.
   * </p>
   * @param sourceDomain Mandatory java.lang.String parameter.
   * @param projectName Mandatory java.lang.String parameter.
   * @param destinationDomain Mandatory java.lang.String parameter.
   * @return  Returns a value of type java.lang.String
   */

  @DISPID(38) //= 0x26. The runtime will prefer the VTID if present
  @VTID(44)
  java.lang.String moveProjectToDomain(
    java.lang.String sourceDomain,
    java.lang.String projectName,
    java.lang.String destinationDomain);


  /**
   * <p>
   * Continues an interrupted project creation and retrieves project properties.
   * </p>
   * @param domainName Mandatory java.lang.String parameter.
   * @param projectName Mandatory java.lang.String parameter.
   * @return  Returns a value of type java.lang.String
   */

  @DISPID(39) //= 0x27. The runtime will prefer the VTID if present
  @VTID(45)
  java.lang.String continueProject(
    java.lang.String domainName,
    java.lang.String projectName);


  /**
   * <p>
   * Returns the properties of all connections to the server.
   * </p>
   * @return  Returns a value of type java.lang.String
   */

  @DISPID(40) //= 0x28. The runtime will prefer the VTID if present
  @VTID(46)
  java.lang.String getConnections();


  /**
   * <p>
   * Returns the number of active connections to the server.
   * </p>
   * @param domainName Mandatory java.lang.String parameter.
   * @param projectName Mandatory java.lang.String parameter.
   * @return  Returns a value of type java.lang.String
   */

  @DISPID(41) //= 0x29. The runtime will prefer the VTID if present
  @VTID(47)
  java.lang.String getConnectionsCount(
    java.lang.String domainName,
    java.lang.String projectName);


  /**
   * <p>
   * Disconnects all connections to a project.
   * </p>
   * @param domainName Mandatory java.lang.String parameter.
   * @param projectName Mandatory java.lang.String parameter.
   * @return  Returns a value of type java.lang.String
   */

  @DISPID(42) //= 0x2a. The runtime will prefer the VTID if present
  @VTID(48)
  java.lang.String disconnectProject(
    java.lang.String domainName,
    java.lang.String projectName);


  /**
   * <p>
   * Disconnects all of a given user's connections to the ALM server.
   * </p>
   * @param userName Mandatory java.lang.String parameter.
   * @return  Returns a value of type java.lang.String
   */

  @DISPID(43) //= 0x2b. The runtime will prefer the VTID if present
  @VTID(49)
  java.lang.String disconnectUser(
    java.lang.String userName);


  /**
   * <p>
   * Disconnects all connections to a domain.
   * </p>
   * @param domainName Mandatory java.lang.String parameter.
   * @return  Returns a value of type java.lang.String
   */

  @DISPID(44) //= 0x2c. The runtime will prefer the VTID if present
  @VTID(50)
  java.lang.String disconnectDomain(
    java.lang.String domainName);


  /**
   * <p>
   * Disconnects all connections to the ALM server.
   * </p>
   * @return  Returns a value of type java.lang.String
   */

  @DISPID(45) //= 0x2d. The runtime will prefer the VTID if present
  @VTID(51)
  java.lang.String disconnectAll();


  /**
   * <p>
   * Disconnects a specific connection to the ALM server.
   * </p>
   * @param connectionId Mandatory int parameter.
   * @return  Returns a value of type java.lang.String
   */

  @DISPID(46) //= 0x2e. The runtime will prefer the VTID if present
  @VTID(52)
  java.lang.String disconnect(
    int connectionId);


  /**
   * <p>
   * method ConnectReports
   * </p>
   * @param domainserver Mandatory java.lang.String parameter.
   * @return  Returns a value of type java.lang.String
   */

  @DISPID(47) //= 0x2f. The runtime will prefer the VTID if present
  @VTID(53)
  java.lang.String connectReports(
    java.lang.String domainserver);


  /**
   * <p>
   * Obsolete: Defines a new database server.
   * </p>
   * @param dbType Mandatory int parameter.
   * @param dbServerName Mandatory java.lang.String parameter.
   * @param dbAdminUser Mandatory java.lang.String parameter.
   * @param dbAdminPassword Mandatory java.lang.String parameter.
   * @param dbUserPassword Mandatory java.lang.String parameter.
   * @param connectionStringFormat Mandatory java.lang.String parameter.
   * @return  Returns a value of type java.lang.String
   */

  @DISPID(48) //= 0x30. The runtime will prefer the VTID if present
  @VTID(54)
  java.lang.String addDBServer(
    int dbType,
    java.lang.String dbServerName,
    java.lang.String dbAdminUser,
    java.lang.String dbAdminPassword,
    java.lang.String dbUserPassword,
    java.lang.String connectionStringFormat);


  /**
   * <p>
   * Deletes a database server from the database server list.
   * </p>
   * @param dbServerName Mandatory java.lang.String parameter.
   * @param dbType Mandatory int parameter.
   * @return  Returns a value of type java.lang.String
   */

  @DISPID(49) //= 0x31. The runtime will prefer the VTID if present
  @VTID(55)
  java.lang.String removeDBServer(
    java.lang.String dbServerName,
    int dbType);


  /**
   * <p>
   * Returns properties of all the database servers.
   * </p>
   * @return  Returns a value of type java.lang.String
   */

  @DISPID(50) //= 0x32. The runtime will prefer the VTID if present
  @VTID(56)
  java.lang.String getAllDBServers();


  /**
   * <p>
   * Returns properties of a database server.
   * </p>
   * @param dbServerName Mandatory java.lang.String parameter.
   * @param dbType Mandatory int parameter.
   * @return  Returns a value of type java.lang.String
   */

  @DISPID(51) //= 0x33. The runtime will prefer the VTID if present
  @VTID(57)
  java.lang.String getDBServer(
    java.lang.String dbServerName,
    int dbType);


  /**
   * <p>
   * Creates a new user and retrieves the user properties.
   * </p>
   * @param userName Mandatory java.lang.String parameter.
   * @param fullName Mandatory java.lang.String parameter.
   * @param email Mandatory java.lang.String parameter.
   * @param phone Mandatory java.lang.String parameter.
   * @param description Mandatory java.lang.String parameter.
   * @param password Mandatory java.lang.String parameter.
   * @param domainAuth Mandatory java.lang.String parameter.
   * @return  Returns a value of type java.lang.String
   */

  @DISPID(52) //= 0x34. The runtime will prefer the VTID if present
  @VTID(58)
  java.lang.String createUserEx(
    java.lang.String userName,
    java.lang.String fullName,
    java.lang.String email,
    java.lang.String phone,
    java.lang.String description,
    java.lang.String password,
    java.lang.String domainAuth);


  // Properties:
}
