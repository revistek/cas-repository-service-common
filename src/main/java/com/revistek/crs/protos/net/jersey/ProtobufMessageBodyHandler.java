package com.revistek.crs.protos.net.jersey;

import com.google.protobuf.Message;
import com.revistek.net.constants.MediaTypes;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.MultivaluedMap;
import jakarta.ws.rs.ext.MessageBodyReader;
import jakarta.ws.rs.ext.MessageBodyWriter;
import jakarta.ws.rs.ext.Provider;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Handles the marshalling/unmarshalling for the Message protobuf object for Jersey.
 *
 * @author Chuong Ngo
 */
@Provider
@Consumes(MediaTypes.APPLICATION_XPROTOBUF)
@Produces(MediaTypes.APPLICATION_XPROTOBUF)
public class ProtobufMessageBodyHandler
    implements MessageBodyWriter<Message>, MessageBodyReader<Message> {
  private static final Logger LOGGER = LoggerFactory.getLogger(ProtobufMessageBodyHandler.class);

  @Override
  public boolean isWriteable(
      Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
    return Message.class.isAssignableFrom(type);
  }

  @Override
  public void writeTo(
      Message t,
      Class<?> type,
      Type genericType,
      Annotation[] annotations,
      MediaType mediaType,
      MultivaluedMap<String, Object> httpHeaders,
      OutputStream entityStream)
      throws IOException, WebApplicationException {
    LOGGER.trace("Marshaling the protobuf object.");

    entityStream.write(t.toByteArray());
  }

  @Override
  public long getSize(
      Message t, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
    return t.getSerializedSize();
  }

  @Override
  public boolean isReadable(
      Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
    return Message.class.isAssignableFrom(type);
  }

  @Override
  public Message readFrom(
      Class<Message> type,
      Type genericType,
      Annotation[] annotations,
      MediaType mediaType,
      MultivaluedMap<String, String> httpHeaders,
      InputStream entityStream)
      throws IOException {
    try {
      LOGGER.trace("Unmarshaling the protobuf object.");

      Method newBuilder = type.getMethod("newBuilder");
      Message.Builder builder = (Message.Builder) newBuilder.invoke(type);
      return builder.mergeFrom(entityStream).build();
    } catch (Exception e) {
      LOGGER.trace("Failed to unmarshal the protobuf object.");
      e.printStackTrace();

      return null;
    }
  }
}
