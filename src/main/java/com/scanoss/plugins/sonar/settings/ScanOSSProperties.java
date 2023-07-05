  package com.scanoss.plugins.sonar.settings;

  import org.sonar.api.PropertyType;
  import org.sonar.api.config.PropertyDefinition;
  import org.sonar.api.resources.Qualifiers;

  import java.util.List;

  import static java.util.Arrays.asList;

  public class ScanOSSProperties {

    public static final String SCANOSS_ENABLE_SCAN_KEY = "sonar.scanoss.scan.enable";
    public static final Boolean SCANOSS_ENABLE_SCAN_DEFAULT_VALUE = true;
    public static final String SCANOSS_API_URL_KEY = "sonar.scanoss.scan.apiurl";
    public static final String SCANOSS_API_URL_DEFAULT_VALUE = "https://osskb.org/api/scan/direct";
    public static final String SCANOSS_API_TOKEN_KEY = "sonar.scanoss.scan.key";
    public static final String SCANOSS_API_TOKEN_DEFAULT_VALUE = "";
    public static final String SCANOSS_DOCKER_IMAGE_KEY = "sonar.scanoss.scan.dockerimage";
    public static final String SCANOSS_DOCKER_IMAGE_DEFAULT_VALUE = "";

    private ScanOSSProperties() {
      // only statics
    }

    public static List<PropertyDefinition> getProperties() {
      PropertyDefinition enableScan = PropertyDefinition.builder(SCANOSS_ENABLE_SCAN_KEY)
              .type(PropertyType.BOOLEAN)
              .multiValues(false)
              .defaultValue(String.valueOf(SCANOSS_ENABLE_SCAN_DEFAULT_VALUE))
              .category("SCANOSS")
              .name("Enable SCANOSS Scanner")
              .description("This setting enables or disables the SCANOSS analysis")
              .onQualifiers(Qualifiers.PROJECT)
              .index(0)
              .build();
      PropertyDefinition apiUrl = PropertyDefinition.builder(SCANOSS_API_URL_KEY)
              .multiValues(false)
              .defaultValue(SCANOSS_API_URL_DEFAULT_VALUE)
              .category("SCANOSS")
              .name("Scan API URL")
              .description("Scan API Endpoint with format \"http(s)://host:ip/api/scan/direct\". The --apiurl argument is used to pass it to the CLI.")
              .onQualifiers(Qualifiers.PROJECT)
              .index(1)
              .build();
      PropertyDefinition apiToken = PropertyDefinition.builder(SCANOSS_API_TOKEN_KEY)
              .multiValues(false)
              .defaultValue(SCANOSS_API_TOKEN_DEFAULT_VALUE)
              .category("SCANOSS")
              .name("Scan API Token")
              .description("Scan API token. The --key argument is used to pass it to the CLI.")
              .onQualifiers(Qualifiers.PROJECT)
              .index(2)
              .build();
      PropertyDefinition dockerImage = PropertyDefinition.builder(SCANOSS_DOCKER_IMAGE_KEY)
              .multiValues(false)
              .defaultValue(SCANOSS_DOCKER_IMAGE_DEFAULT_VALUE)
              .category("SCANOSS")
              .name("Docker container image")
              .description("Specify a container image if you want to run the SCANOSS Python CLI with Docker. Leave empty otherwise.")
              .onQualifiers(Qualifiers.PROJECT)
              .index(3)
              .build();
      return asList(
              enableScan,
              apiUrl,
              apiToken,
              dockerImage
      );
    }

  }
