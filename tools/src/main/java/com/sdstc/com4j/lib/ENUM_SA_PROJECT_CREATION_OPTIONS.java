package com.sdstc.com4j.lib  ;

import com4j.*;

/**
 * <p>
 * Flags for project creation options.
 * </p>
 */
public enum ENUM_SA_PROJECT_CREATION_OPTIONS implements ComEnum {
  /**
   * <p>
   * No options selected.
   * </p>
   * <p>
   * The value of this constant is 0
   * </p>
   */
  SA_PROJECT_CREATION_NONE(0),
  /**
   * <p>
   * Activate a newly created project.
   * </p>
   * <p>
   * The value of this constant is 1
   * </p>
   */
  SA_ACTIVATE_NEW_PROJECT(1),
  /**
   * <p>
   * Create project with version control enabled.
   * </p>
   * <p>
   * The value of this constant is 2
   * </p>
   */
  SA_CREATE_VERSION_CONTROL_DB(2),
  /**
   * <p>
   * Obsolete. This option has no effect. Copy project even if the source project is active.
   * </p>
   * <p>
   * The value of this constant is 4
   * </p>
   */
  _OBSOLETE_SA_PROJECT_CREATION_FORCE_IF_ACTIVE(4),
  /**
   * <p>
   * Obsolete. This option has no effect. Project repository is in file system.
   * </p>
   * <p>
   * The value of this constant is 8
   * </p>
   */
  _OBSOLETE_SA_PROJECT_REPOSITORY_IN_FS(8),
  ;

  private final int value;
  ENUM_SA_PROJECT_CREATION_OPTIONS(int value) { this.value=value; }
  public int comEnumValue() { return value; }
}
