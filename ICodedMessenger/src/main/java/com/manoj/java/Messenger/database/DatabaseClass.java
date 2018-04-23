package com.manoj.java.Messenger.database;
import java.util.*;

import com.manoj.java.Messenger.model.*;
public class DatabaseClass {
	
	
	public static Map<Long,Message> messages = new HashMap<>();
	public static Map<String,Profile> profiles = new HashMap<>();
	

	
	
	public static Map<Long, Message> getMessages() {
		return messages;
	}
	public static Map<String, Profile> getProfiles() {
		return profiles;
	}

}
