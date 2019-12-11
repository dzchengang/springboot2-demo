package com.sdstc.com4j.lib  ;

import com4j.*;

/**
 * <p>
 * Specifiers for user property fields.
 * </p>
 */
public enum ENUM_SA_SET_USER_PROPERTY_OPTIONS implements ComEnum {
  /**
   * <p>
   * User ID.
   * </p>
   * <p>
   * The value of this constant is 1
   * </p>
   */
  SA_USER_ID(1),
  /**
   * <p>
   * User name.
   * </p>
   * <p>
   * The value of this constant is 2
   * </p>
   */
  SA_USER_NAME(2),
  /**
   * <p>
   * User full name.
   * </p>
   * <p>
   * The value of this constant is 3
   * </p>
   */
  SA_USER_FULL_NAME(3),
  /**
   * <p>
   * User email address.
   * </p>
   * <p>
   * The value of this constant is 4
   * </p>
   */
  SA_USER_EMAIL(4),
  /**
   * <p>
   * User phone number.
   * </p>
   * <p>
   * The value of this constant is 5
   * </p>
   */
  SA_USER_PHONE_NUMBER(5),
  /**
   * <p>
   * User description.
   * </p>
   * <p>
   * The value of this constant is 6
   * </p>
   */
  SA_USER_DESCRIPTION(6),
  /**
   * <p>
   * User password.
   * </p>
   * <p>
   * The value of this constant is 7
   * </p>
   */
  SA_USER_PASSWORD(7),
  /**
   * <p>
   * User's LDAP distinguished name.
   * </p>
   * <p>
   * The value of this constant is 8
   * </p>
   */
  SA_USER_DOM_AUTH(8),
  /**
   * <p>
   * User can view advanced reports.
   * </p>
   * <p>
   * The value of this constant is 9
   * </p>
   */
  SA_USER_REPORT_ROLE(9),
  ;

  private final int value;
  ENUM_SA_SET_USER_PROPERTY_OPTIONS(int value) { this.value=value; }
  public int comEnumValue() { return value; }
}
