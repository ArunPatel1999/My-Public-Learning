package com.arun.service.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.arun.service.CRUDRealTime;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

@Service
public class CRUDRealTimeService implements CRUDRealTime {

	@Override
	public Object getAll() {
		FirebaseDatabase database = FirebaseDatabase.getInstance();
		List<Object> resuList = new LinkedList<>();
		
		database.getReference().addListenerForSingleValueEvent(new ValueEventListener() {
	        @Override
	        public void onDataChange(DataSnapshot dataSnapshot) {
	            dataSnapshot.getChildren().forEach(x -> resuList.add(x.getValue()));
	        }

	        @Override
	        public void onCancelled(DatabaseError databaseError) { }
	    });
		try {
			Thread.sleep(5000);
		}catch (Exception e) {}
		return resuList;
	}

	@Override
	public Object getById(String node) {
		FirebaseDatabase database = FirebaseDatabase.getInstance();
		List<Object> resuList = new LinkedList<>();
		database.getReference(node).addListenerForSingleValueEvent(new ValueEventListener() {
	        @Override
	        public void onDataChange(DataSnapshot dataSnapshot) {
	        	//x.getKey() x.getValue();
	            dataSnapshot.getChildren().forEach(x -> resuList.add(x.getValue()));
	        }

	        @Override
	        public void onCancelled(DatabaseError databaseError) {}
	    });
		try {
			Thread.sleep(5000);
		}catch (Exception e) {}
		return resuList.get(0);
	}

	@Override
	public Map<String, Object> saveAndUpdate(String nodename, Map<String, Object> save) {
		FirebaseDatabase database = FirebaseDatabase.getInstance();
		DatabaseReference ref = database.getReference(nodename);		
		DatabaseReference usersRef = ref.child(save.get("id").toString());
		usersRef.setValueAsync(save);
		return save;
	}

	@Override
	public String deleteById(String nodename) {
		 FirebaseDatabase database = FirebaseDatabase.getInstance();
		 DatabaseReference ref = database.getReference(nodename);
		 ref.removeValueAsync();
		 return "real time database object deleted";
	}  
	
}
