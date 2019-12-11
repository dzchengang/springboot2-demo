package com.sdstc.com4j.lib  ;

import com4j.*;

/**
 * <p>
 * Specifiers for project property fields.
 * </p>
 */
public enum ENUM_SA_PROJECT_PROPERTY_OPTIONS {
  /**
   * <p>
   * No project property options.
   * </p>
   * <p>
   * The value of this constant is 0
   * </p>
   */
  SA_PROJECT_PROPERTY_NONE, // 0
  /**
   * <p>
   * The project database connection string.
   * </p>
   * <p>
   * The value of this constant is 1
   * </p>
   */
  SA_PROJECT_DB_CONNECT_STRING, // 1
  /**
   * <p>
   * The database user password.
   * </p>
   * <p>
   * The value of this constant is 2
   * </p>
   */
  SA_PROJECT_DB_USER_PASSWORD, // 2
  /**
   * <p>
   * Project is active (Y/N).
   * </p>
   * <p>
   * The value of this constant is 3
   * </p>
   */
  SA_PROJECT_ACTIVE, // 3
  /**
   * <p>
   * The project name.
   * </p>
   * <p>
   * The value of this constant is 4
   * </p>
   */
  SA_PROJECT_NAME, // 4
  /**
   * <p>
   * Auto Mail (send defect emails) is active (Y/N).
   * </p>
   * <p>
   * The value of this constant is 5
   * </p>
   */
  SA_PROJECT_SEND_ALL_QUALIFIED, // 5
  /**
   * <p>
   * The maximum number of concurrent project connections. (-1 for unlimited).
   * </p>
   * <p>
   * The value of this constant is 6
   * </p>
   */
  SA_PROJECT_USER_QUOTA, // 6
  /**
   * <p>
   * The project description.
   * </p>
   * <p>
   * The value of this constant is 7
   * </p>
   */
  SA_PROJECT_DESCRIPTION, // 7
  /**
   * <p>
   * Obsolete.
   * </p>
   * <p>
   * The value of this constant is 8
   * </p>
   */
  SA_PROJECT_VM_REPOSITORY, // 8
  /**
   * <p>
   * Template ID to which project is linked.
   * </p>
   * <p>
   * The value of this constant is 9
   * </p>
   */
  SA_PROJECT_LINKED_TEMPLATE_ID, // 9
  /**
   * <p>
   * Project parameter (DATACONST).
   * </p>
   * <p>
   * The value of this constant is 10
   * </p>
   */
  SA_PROJECT_PARAM, // 10
}
