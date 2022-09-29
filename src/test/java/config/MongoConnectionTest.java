package config;


import com.mongodb.client.MongoDatabase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

@Disabled
class MongoConnectionTest {

  @Test
  void mongoConnection(){
    ConfigProperties configProperties = ConfigProperties.properties();
    MongoConnection mongoConnection = new MongoConnection();
    MongoDatabase mongoDatabase = mongoConnection.mongoDatabase();

    Assertions.assertEquals(mongoDatabase.getName(),configProperties.Db());
  }
}