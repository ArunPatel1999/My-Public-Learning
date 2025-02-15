package com.mtraders.demo.service;

import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.stereotype.Service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import com.mtraders.demo.entity.User;

@Service
public class Firebase {

	public String saveUserDetails(User user) throws InterruptedException, ExecutionException {
		Firestore dbFirstore = FirestoreClient.getFirestore();
		ApiFuture<WriteResult> collection = dbFirstore.collection("users").document(""+user.getUserId()).set(user);
		
		return collection.get().getUpdateTime().toString();
	}
	

	public User getById(int id) throws InterruptedException, ExecutionException {
		Firestore dbFirstore = FirestoreClient.getFirestore();
		ApiFuture<DocumentSnapshot> collection = dbFirstore.collection("users").document(""+id).get();
		return collection.get().toObject(User.class);
	}
	
	public List<User> getAll() throws InterruptedException, ExecutionException {
		Firestore dbFirstore = FirestoreClient.getFirestore();
		ApiFuture<QuerySnapshot> collection = dbFirstore.collection("users").get();
		return collection.get().toObjects(User.class);
	}
	
	
	public String delete(int id) throws InterruptedException, ExecutionException {
		Firestore dbFirstore = FirestoreClient.getFirestore();
		ApiFuture<WriteResult> collection = dbFirstore.collection("users").document(""+id).delete();
		return collection.get().getUpdateTime().toString();
	}
	
}
