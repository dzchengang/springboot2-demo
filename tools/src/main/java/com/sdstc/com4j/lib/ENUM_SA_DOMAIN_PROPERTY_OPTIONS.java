package com.sdstc.com4j.lib  ;

import com4j.*;

/**
 * <p>
 * Specifiers for domain property fields.
 * </p>
 */
public enum ENUM_SA_DOMAIN_PROPERTY_OPTIONS implements ComEnum {
  /**
   * <p>
   * Domain ID.
   * </p>
   * <p>
   * The value of this constant is 1
   * </p>
   */
  SA_DOMAIN_ID(1),
  /**
   * <p>
   * Domain name.
   * </p>
   * <p>
   * The value of this constant is 2
   * </p>
   */
  SA_DOMAIN_NAME(2),
  /**
   * <p>
   * Location of domain repository.
   * </p>
   * <p>
   * The value of this constant is 3
   * </p>
   */
  SA_DOMAIN_PHYSICAL_DIRECTORY(3),
  /**
   * <p>
   * Not used by ALM.
   * </p>
   * <p>
   * The value of this constant is 4
   * </p>
   */
  SA_DOMAIN_COMPANY_NAME(4),
  /**
   * <p>
   * Not used by ALM.
   * </p>
   * <p>
   * The value of this constant is 5
   * </p>
   */
  SA_DOMAIN_CONTACT_NAME(5),
  /**
   * <p>
   * Not used by ALM.
   * </p>
   * <p>
   * The value of this constant is 6
   * </p>
   */
  SA_DOMAIN_CONTACT_EMAIL(6),
  /**
   * <p>
   * The maximum number of concurrent domain connections. -1 for unlimited.
   * </p>
   * <p>
   * The value of this constant is 7
   * </p>
   */
  SA_DOMAIN_USERS_QUOTA(7),
  /**
   * <p>
   * Obsolete.
   * </p>
   * <p>
   * The value of this constant is 8
   * </p>
   */
  SA_DOMAIN_DEFECTS_QUOTA(8),
  /**
   * <p>
   * Obsolete.
   * </p>
   * <p>
   * The value of this constant is 9
   * </p>
   */
  SA_DOMAIN_PROJECTS_QUOTA(9),
  /**
   * <p>
   * Obsolete.
   * </p>
   * <p>
   * The value of this constant is 10
   * </p>
   */
  SA_DOMAIN_FILE_SYSTEM_QUOTA(10),
  /**
   * <p>
   * The projects in the domain.
   * </p>
   * <p>
   * The value of this constant is 11
   * </p>
   */
  SA_DOMAIN_PROJECT_LIST(11),
  /**
   * <p>
   * Obsolete.
   * </p>
   * <p>
   * The value of this constant is 12
   * </p>
   */
  SA_DOMAIN_USERS_VERSION(12),
  /**
   * <p>
   * Obsolete.
   * </p>
   * <p>
   * The value of this constant is 13
   * </p>
   */
  SA_DOMAIN_PASSWORD(13),
  /**
   * <p>
   * Obsolete.
   * </p>
   * <p>
   * The value of this constant is 14
   * </p>
   */
  SA_DOMAIN_ADMIN_PASSWORD(14),
  ;

  private final int value;
  ENUM_SA_DOMAIN_PROPERTY_OPTIONS(int value) { this.value=value; }
  public int comEnumValue() { return value; }
}
