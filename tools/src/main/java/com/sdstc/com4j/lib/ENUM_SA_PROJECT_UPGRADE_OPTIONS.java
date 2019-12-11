package com.sdstc.com4j.lib  ;

import com4j.*;

/**
 * <p>
 * Flags for project upgrade options.
 * </p>
 */
public enum ENUM_SA_PROJECT_UPGRADE_OPTIONS {
  /**
   * <p>
   * No upgrade options.
   * </p>
   * <p>
   * The value of this constant is 0
   * </p>
   */
  SA_PROJECT_UPGRADE_NONE, // 0
  /**
   * <p>
   * Force upgrade even if project is latest version.
   * </p>
   * <p>
   * The value of this constant is 1
   * </p>
   */
  SA_PROJECT_UPGRADE_FORCE, // 1
  /**
   * <p>
   * Obsolete. In previous versions, was 'move project repository to database'.
   * </p>
   * <p>
   * The value of this constant is 2
   * </p>
   */
  SA_PROJECT_UPGRADE_REPOSITORY_TO_DB, // 2
}
