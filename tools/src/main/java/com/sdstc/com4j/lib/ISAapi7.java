package com.sdstc.com4j.lib  ;

import com4j.*;

/**
 * Application Lifecyle Management Site Administration Client
 */
@IID("{3541A26C-5298-420B-85EA-1C9A78A5E3C9}")
public interface ISAapi7 extends com.sdstc.com4j.lib.ISAapi6 {
  // Methods:
  /**
   * <p>
   * Returns the ALM Product Version.
   * </p>
   * @return  Returns a value of type java.lang.String
   */

  @DISPID(114) //= 0x72. The runtime will prefer the VTID if present
  @VTID(120)
  java.lang.String getProductVersion();


  /**
   * <p>
   * Get QC Sense information for SyH.
   * </p>
   * @param queryID Mandatory java.lang.String parameter.
   * @param columns Mandatory java.lang.Object parameter.
   * @param tables Mandatory java.lang.Object parameter.
   * @param arguments Mandatory java.lang.Object parameter.
   * @return  Returns a value of type java.lang.Object
   */

  @DISPID(115) //= 0x73. The runtime will prefer the VTID if present
  @VTID(121)
  @ReturnValue(type=NativeType.VARIANT)
  java.lang.Object getSyHInfo(
    java.lang.String queryID,
    @MarshalAs(NativeType.VARIANT) java.lang.Object columns,
    @MarshalAs(NativeType.VARIANT) java.lang.Object tables,
    @MarshalAs(NativeType.VARIANT) java.lang.Object arguments);


  /**
   * <p>
   * Get QC Debug Console information for SyH.
   * </p>
   * @param debugInfoID Mandatory java.lang.String parameter.
   * @return  Returns a value of type java.lang.Object
   */

  @DISPID(116) //= 0x74. The runtime will prefer the VTID if present
  @VTID(122)
  @ReturnValue(type=NativeType.VARIANT)
  java.lang.Object getSyHDebugInfo(
    java.lang.String debugInfoID);


  // Properties:
}
