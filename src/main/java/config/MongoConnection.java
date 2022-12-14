package config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class MongoConnection {

  ConfigProperties configProperties = ConfigProperties.properties();

  public MongoDatabase mongoDatabase() {
    String url = """
        mongodb://%s:%s@%s:%s/%s&authMechanism=SCRAM-SHA-256
        """.formatted(configProperties.User(),
            configProperties.Password(),
            configProperties.Url(),
            configProperties.Port(),
            configProperties.Db());
    MongoClient mongoClient = MongoClients.create(url);
    return mongoClient.getDatabase("mydb");
  }
}
