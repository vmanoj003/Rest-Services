package com.manoj.java.Messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.manoj.java.Messenger.database.DatabaseClass;
import com.manoj.java.Messenger.model.Profile;

public class ProfileService {
	
Map<String,Profile> profiles = DatabaseClass.getProfiles();
	
	public ProfileService(){
		
		profiles.put("Manoj",new Profile(1L,"Manojkumar Velama","Manojkumar","Velama"));
		profiles.put("Manu's",new Profile(2L,"Manu's Velama","Manu","Velama"));
		profiles.put("Kumar",new Profile(3L,"Sukumar","Sukku","Velama"));

	}
	
	
	public List<Profile> getAllProfiles(){
			
		return new ArrayList<Profile>(profiles.values());
		
	}
	
	
		public Profile getProfile(String name){
			
			return profiles.get(name);
		}
		
		
		public Profile addProfile(Profile profile){
			
			profile.setId((long) (profiles.size()+1));
			profiles.put(profile.getProfileName(),profile);
			
			return profile;
		}
		
		
		public Profile  updateProfile(Profile profile){
			
			
			if(profile.getProfileName().isEmpty()) return null;
			else profiles.put(profile.getProfileName(),profile);
			return profile;
		}
		
		
		public Profile removeProfile(String name){
			
			return profiles.remove(name);
			
		}

}
