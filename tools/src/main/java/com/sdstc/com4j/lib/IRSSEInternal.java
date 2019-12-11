package com.sdstc.com4j.lib  ;

import com4j.*;

/**
 * For HP use. IRSSEInternal
 */
@IID("{43787016-4777-4D98-BA76-6E236FCD1DC8}")
public interface IRSSEInternal extends Com4jObject {
  // Methods:
  /**
   * <p>
   * For HP use. GetAllGroups
   * </p>
   * @return  Returns a value of type java.lang.String
   */

  @DISPID(1) //= 0x1. The runtime will prefer the VTID if present
  @VTID(7)
  java.lang.String getAllGroups();


  /**
   * <p>
   * For HP use. GetAllRoles
   * </p>
   * @return  Returns a value of type java.lang.String
   */

  @DISPID(2) //= 0x2. The runtime will prefer the VTID if present
  @VTID(8)
  java.lang.String getAllRoles();


  /**
   * <p>
   * For HP use. GetUsersInGroup
   * </p>
   * @param groupName Mandatory java.lang.String parameter.
   * @return  Returns a value of type java.lang.String
   */

  @DISPID(3) //= 0x3. The runtime will prefer the VTID if present
  @VTID(9)
  java.lang.String getUsersInGroup(
    java.lang.String groupName);


  /**
   * <p>
   * For HP use. GetUsersInRole
   * </p>
   * @param roleId Mandatory int parameter.
   * @return  Returns a value of type java.lang.String
   */

  @DISPID(4) //= 0x4. The runtime will prefer the VTID if present
  @VTID(10)
  java.lang.String getUsersInRole(
    int roleId);


  /**
   * <p>
   * For HP use. Authenticate
   * </p>
   * @param userName Mandatory java.lang.String parameter.
   * @param password Mandatory java.lang.String parameter.
   * @return  Returns a value of type java.lang.String
   */

  @DISPID(5) //= 0x5. The runtime will prefer the VTID if present
  @VTID(11)
  java.lang.String authenticate(
    java.lang.String userName,
    java.lang.String password);


  /**
   * <p>
   * For HP use. GetRolesOfUser
   * </p>
   * @param userName Mandatory java.lang.String parameter.
   * @return  Returns a value of type java.lang.String
   */

  @DISPID(6) //= 0x6. The runtime will prefer the VTID if present
  @VTID(12)
  java.lang.String getRolesOfUser(
    java.lang.String userName);


  /**
   * <p>
   * For HP use. GetGroupsOfUser
   * </p>
   * @param userName Mandatory java.lang.String parameter.
   * @return  Returns a value of type java.lang.String
   */

  @DISPID(7) //= 0x7. The runtime will prefer the VTID if present
  @VTID(13)
  java.lang.String getGroupsOfUser(
    java.lang.String userName);


  // Properties:
}
