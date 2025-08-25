package org.example.largefruitcompanyapi;

import com.google.cloud.firestore.annotation.DocumentId;
import com.google.cloud.spring.data.firestore.Document;
import org.springframework.data.annotation.Id;

@Document(collectionName = "fruit")
public class Fruit {
    @DocumentId
    private String documentId;
    private String name;
    private String price;

    Fruit(String documentId, String name, String price) {
        this.documentId = documentId;
        this.name = name;
        this.price = price;
    }

    Fruit(){

    }

    public String getDocumentId() { return documentId; }
    public void setDocumentId(String documentId) { this.documentId = documentId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getPrice() { return price; }
    public void setPrice(String price) { this.price = price; }
}
