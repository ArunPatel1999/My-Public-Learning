package com.arun.service.impl;


import java.util.Map;
import java.util.concurrent.ExecutionException;

import org.springframework.stereotype.Service;

import com.arun.service.CRUDFirestore;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;

@Service
public class CRUDFIrestoreSerive implements CRUDFirestore {

	private static final String TABLE_NAME = "users";


	public String saveUserDetails(Map<String, Object> map) throws InterruptedException, ExecutionException {
		Firestore dbFirstore = FirestoreClient.getFirestore();
		ApiFuture<WriteResult> collection = dbFirstore.collection(TABLE_NAME).document(map.get("id").toString()).set(map);
		return collection.get().getUpdateTime().toString();
	}
	

	public Object getById(int id) throws InterruptedException, ExecutionException {
		Firestore dbFirstore = FirestoreClient.getFirestore();
		ApiFuture<DocumentSnapshot> collection = dbFirstore.collection(TABLE_NAME).document(""+id).get();
		return collection.get().toObject(Object.class);
	}
	
	public Object getAll() throws InterruptedException, ExecutionException {
		Firestore dbFirstore = FirestoreClient.getFirestore();
		ApiFuture<QuerySnapshot> collection = dbFirstore.collection(TABLE_NAME).get();
		return collection.get().toObjects(Object.class);
	}
	
	
	public String delete(int id) throws InterruptedException, ExecutionException {
		Firestore dbFirstore = FirestoreClient.getFirestore();
		ApiFuture<WriteResult> collection = dbFirstore.collection(TABLE_NAME).document(""+id).delete();
		return collection.get().getUpdateTime().toString();
	}
	
}
