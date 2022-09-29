package repository;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.InsertOneResult;
import config.MongoConnection;
import org.bson.Document;

public interface CreateRepository {

  void append(Object key, Object value);

  class CreateRepositoryImpl implements CreateRepository {

    private final MongoConnection mongoConnection;

    public CreateRepositoryImpl(MongoConnection mongoConnection) {
      this.mongoConnection = mongoConnection;
    }

    public void create() {
      MongoDatabase mongoDatabase = mongoConnection.mongoDatabase();

      MongoCollection<Document> test = mongoDatabase.getCollection("TEST");

      Document document = new Document();
      document.append("test", "123");
      document.append("test2", "1234");

      InsertOneResult insertOneResult = test.insertOne(document);
      System.out.println("insertOneResult = " + insertOneResult);
//      return insertOneResult.getInsertedId();
    }

    @Override
    public void append(Object key, Object value) {
      //여기서 응답값으로 뭔가 ID같은거 안뱉나?
    }
  }

}
