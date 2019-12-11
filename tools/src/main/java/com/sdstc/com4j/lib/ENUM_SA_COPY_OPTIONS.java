package com.sdstc.com4j.lib  ;

import com4j.*;

/**
 * <p>
 * Flags for project copy options.
 * </p>
 */
public enum ENUM_SA_COPY_OPTIONS implements ComEnum {
  /**
   * <p>
   * Do not copy.
   * </p>
   * <p>
   * The value of this constant is 0
   * </p>
   */
  SA_COPY_PROJECT_NONE(0),
  /**
   * <p>
   * Copy project customizations.
   * </p>
   * <p>
   * The value of this constant is 1
   * </p>
   */
  SA_COPY_PROJECT_CUSTOMIZATION(1),
  /**
   * <p>
   * Copy project requirements.
   * </p>
   * <p>
   * The value of this constant is 2
   * </p>
   */
  SA_COPY_PROJECT_REQUIREMENTS(2),
  /**
   * <p>
   * Copy project tests.
   * </p>
   * <p>
   * The value of this constant is 4
   * </p>
   */
  SA_COPY_PROJECT_TESTS(4),
  /**
   * <p>
   * Copy project test sets.
   * </p>
   * <p>
   * The value of this constant is 8
   * </p>
   */
  SA_COPY_PROJECT_TEST_SETS(8),
  /**
   * <p>
   * Copy project test runs.
   * </p>
   * <p>
   * The value of this constant is 16
   * </p>
   */
  SA_COPY_PROJECT_RUNS(16),
  /**
   * <p>
   * Copy project defects.
   * </p>
   * <p>
   * The value of this constant is 32
   * </p>
   */
  SA_COPY_PROJECT_DEFECTS(32),
  /**
   * <p>
   * Copy project history.
   * </p>
   * <p>
   * The value of this constant is 64
   * </p>
   */
  SA_COPY_PROJECT_INCLUDE_HISTORY(64),
  /**
   * <p>
   * Copy project public favorites views.
   * </p>
   * <p>
   * The value of this constant is 128
   * </p>
   */
  SA_COPY_PROJECT_PUBLIC_FAVORITES_VIEW(128),
  /**
   * <p>
   * Copy project users and user groups.
   * </p>
   * <p>
   * The value of this constant is 256
   * </p>
   */
  SA_COPY_PROJECT_USERS_AND_GROUPS(256),
  /**
   * <p>
   * Copy project private favorites views.
   * </p>
   * <p>
   * The value of this constant is 512
   * </p>
   */
  SA_COPY_PROJECT_PRIVATE_FAVORITES_VIEW(512),
  /**
   * <p>
   * Copy project mail conditions.
   * </p>
   * <p>
   * The value of this constant is 1024
   * </p>
   */
  SA_COPY_PROJECT_MAIL_CONDITIONS(1024),
  /**
   * <p>
   * Copy all available data from source project.
   * </p>
   * <p>
   * The value of this constant is 2048
   * </p>
   */
  SA_COPY_ALL(2048),
  ;

  private final int value;
  ENUM_SA_COPY_OPTIONS(int value) { this.value=value; }
  public int comEnumValue() { return value; }
}
