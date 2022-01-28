package com.revistek.crs.protos.constants;

/**
 * Messages for the Message protobuf object.
 *
 * @author Chuong Ngo
 */
public final class ProtobufMessages {
  public static final String CAS_STORE_FAILED = "Failed to write the CAS to the repository.";
  public static final String CAS_STORE_SUCCESS = "Successfully wrote the CAS to the repository.";
  public static final String CAS_DELETE_FAILED =
      "Failed to delete the CAS from the repository, document id: %s";
  public static final String CAS_DELETE_SUCCESS =
      "Successfully deleted the CAS from the repository, document id: %s";
  public static final String CAS_GET_FAILED =
      "Failed to retrive the CAS from the repository, CAS id: %s";
  public static final String CAS_GET_SUCCESS =
      "Successfully retrived the CAS from the repository, CAS id: %s";
  public static final String INVALID_MESSAGE = "The protobuff message is invalid.";

  private ProtobufMessages() {}
}
