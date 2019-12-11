package com.sdstc.com4j.lib  ;

import com4j.*;

/**
 * Application Lifecyle Management Site Administration Client
 */
@IID("{D24EC6A3-17AF-4AFF-8A1E-17EEDF04263C}")
public interface ISAapi2 extends com.sdstc.com4j.lib.ISAapi {
  // Methods:
  /**
   * <p>
   * Logs the specified user on to the site administration application.
   * </p>
   * @param serverURL Mandatory java.lang.String parameter.
   * @param userName Mandatory java.lang.String parameter.
   * @param password Mandatory java.lang.String parameter.
   */

  @DISPID(53) //= 0x35. The runtime will prefer the VTID if present
  @VTID(59)
  void login(
    java.lang.String serverURL,
    java.lang.String userName,
    java.lang.String password);


  /**
   * <p>
   * Disconnects the logged on user from the site administration application.
   * </p>
   */

  @DISPID(54) //= 0x36. The runtime will prefer the VTID if present
  @VTID(60)
  void logout();


  /**
   * <p>
   * Sends a message to the specified sessions.
   * </p>
   * @param loginSessionsIDsArray Mandatory java.lang.Object parameter.
   * @param messageBody Mandatory java.lang.String parameter.
   */

  @DISPID(55) //= 0x37. The runtime will prefer the VTID if present
  @VTID(61)
  void sendMessage(
    @MarshalAs(NativeType.VARIANT) java.lang.Object loginSessionsIDsArray,
    java.lang.String messageBody);


  /**
   * <p>
   * Sends a message to all open sessions.
   * </p>
   * @param messageBody Mandatory java.lang.String parameter.
   */

  @DISPID(56) //= 0x38. The runtime will prefer the VTID if present
  @VTID(62)
  void sendMessageToAll(
    java.lang.String messageBody);


  /**
   * <p>
   * Sends a message to all users connected to the specified project.
   * </p>
   * @param domainName Mandatory java.lang.String parameter.
   * @param projectName Mandatory java.lang.String parameter.
   * @param messageBody Mandatory java.lang.String parameter.
   */

  @DISPID(57) //= 0x39. The runtime will prefer the VTID if present
  @VTID(63)
  void sendMessageToProjectConnectedUsers(
    java.lang.String domainName,
    java.lang.String projectName,
    java.lang.String messageBody);


  /**
   * <p>
   * Adds a list of users to the specified project.
   * </p>
   * @param domainName Mandatory java.lang.String parameter.
   * @param projectName Mandatory java.lang.String parameter.
   * @param usersNames Mandatory java.lang.String parameter.
   */

  @DISPID(58) //= 0x3a. The runtime will prefer the VTID if present
  @VTID(64)
  void addUsersToProject(
    java.lang.String domainName,
    java.lang.String projectName,
    java.lang.String usersNames);


  /**
   * <p>
   * Adds a list of project users to the specified group.
   * </p>
   * @param domainName Mandatory java.lang.String parameter.
   * @param projectName Mandatory java.lang.String parameter.
   * @param groupName Mandatory java.lang.String parameter.
   * @param usersNames Mandatory java.lang.String parameter.
   */

  @DISPID(59) //= 0x3b. The runtime will prefer the VTID if present
  @VTID(65)
  void addUsersToGroup(
    java.lang.String domainName,
    java.lang.String projectName,
    java.lang.String groupName,
    java.lang.String usersNames);


  // Properties:
}
