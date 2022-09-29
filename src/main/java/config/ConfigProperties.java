package config;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
public class ConfigProperties{
  private final String url;
  private final String db;
  private final String user;
  private final String port;
  private final String password;
  private final String token;

  private ConfigProperties() {
    File yaml = new File("src/main/resources/properties.yaml");

    final Properties properties = new Properties();

    try (FileInputStream stream = new FileInputStream(yaml)) {
      properties.load(stream);
    } catch (IOException e) {
      throw new IllegalArgumentException("PROPERTIES MUST HAVE");
    }

    this.url= properties.getProperty("url");
    this.db= properties.getProperty("db");
    this.port= properties.getProperty("port");
    this.user= properties.getProperty("user");
    this.password= properties.getProperty("password");
    this.token= properties.getProperty("token");

    if (url == null || url.isBlank()){
      throw new IllegalArgumentException("URL IS NOT NULL");
    }
  }

  public String Url() {
    return url;
  }
  public String Port() {
    return port;
  }

  public String Db() {
    return db;
  }
  public String Token(){
    return token;
  }

  public String User() {
    return user;
  }

  public String Password() {
    return password;
  }

  private static class holder {
    private static final ConfigProperties INSTANCE = new ConfigProperties();
  }

  public static ConfigProperties properties() {
    return holder.INSTANCE;
  }
}
