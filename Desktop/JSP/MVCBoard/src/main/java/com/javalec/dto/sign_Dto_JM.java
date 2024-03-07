package com.javalec.dto;

import java.sql.Timestamp;
import javax.servlet.http.Part;

public class sign_Dto_JM {
	public String id;
    public String pw;
    public String name;
    public Timestamp date;
    public Part profileImage;
	    public sign_Dto_JM() {
	    }
		public sign_Dto_JM(String id, String pw, String name, Timestamp date, Part profileImage) {
			super();
			this.id = id;
			this.pw = pw;
			this.name = name;
			this.date = date;
			this.profileImage = profileImage;
		}
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getPw() {
			return pw;
		}
		public void setPw(String pw) {
			this.pw = pw;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Timestamp getDate() {
			return date;
		}
		public void setDate(Timestamp date) {
			this.date = date;
		}
		public Part getProfileImage() {
			return profileImage;
		}
		public void setProfileImage(Part profileImage) {
			this.profileImage = profileImage;
		}


   
}
