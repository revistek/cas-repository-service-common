package com.revistek.crs.constants;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * Constants for use with the configuration file.
 *
 * @author Chuong Ngo
 */
public final class ConfigurationValues {
  public static final String FILENAME = "web.config.properties";
  public static final Charset FILE_ENCODING = StandardCharsets.UTF_8;
  public static final String CACHE_URL = "cache_url";

  private ConfigurationValues() {}
}
