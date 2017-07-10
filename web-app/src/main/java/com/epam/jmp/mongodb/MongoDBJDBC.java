package com.epam.jmp.mongodb;

import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import static com.mongodb.client.model.Filters.*;

/**
 * Created by Aleksei_Okhrimenko on 10.07.2017.
 */
public class MongoDBJDBC {
    public static void main(String[] args) {

        MongoClient client = new MongoClient( "localhost" , 27017 );
        MongoDatabase database = client.getDatabase("test");
        MongoCollection<Document> collection = database.getCollection("test");

        /** Create document **/
        Document doc = new Document("firstname", "Jim")
                .append("lastname", "Brown")
                .append("age", 26);
        collection.insertOne(doc);

//        collection.drop();

        System.out.println(collection.count() + " documents in the collection");

        Document myDoc = collection.find().first();
//        System.out.println(myDoc.toJson());

        /** Find All Documents in a Collection **/
        MongoCursor<Document> cursor = collection.find().iterator();
        try {
            while (cursor.hasNext()) {
                System.out.println(cursor.next().toJson());
            }
        } finally {
            cursor.close();
        }

        System.out.println();
        System.out.println("Get All Documents That Match a Filter:");
        Block<Document> printBlock = new Block<Document>() {
            @Override
            public void apply(final Document document) {
                System.out.println(document.toJson());
            }
        };

        collection.find(eq("age", 26)).forEach(printBlock);

        System.out.println();
        Document document = collection.find().first();
        System.out.println("first document: " + document.toJson());
    }
}
