package com.cheng.cc.lemonman.bean;

public class classify_new_data {
	private int image;
	private String name;
	private String author;
	private int follow;

	public classify_new_data(int image, String name, String author, int follow) {
		super();
		this.image = image;
		this.name = name;
		this.author = author;
		this.follow = follow;
	}
	

	public classify_new_data(int image, String name, String author) {
		super();
		this.image = image;
		this.name = name;
		this.author = author;
	}


	public classify_new_data() {
		super();
	}

	public int getImage() {
		return image;
	}

	public void setImage(int image) {
		this.image = image;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getFollow() {
		return follow;
	}

	public void setFollow(int follow) {
		this.follow = follow;
	}

}
