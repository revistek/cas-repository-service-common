package com.revistek.crs.protos.constants;

/**
 * Message exceptions for the Message protobuf object.
 *
 * @author Chuong Ngo
 */
public final class MessageExceptions {
  public static final String ILLEGAL_ARGUMENT = IllegalArgumentException.class.getName();
  public static final String GENERAL_EXCEPTION = Exception.class.getName();

  private MessageExceptions() {}
}
