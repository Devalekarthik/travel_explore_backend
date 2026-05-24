package com.travel.backend.content;

import java.util.Map;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "content_sections")
public class ContentDocument {

	@Id
	private String id;

	private Map<String, Object> data;

	public ContentDocument() {}

	public ContentDocument(String id, Map<String, Object> data) {
		this.id = id;
		this.data = data;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Map<String, Object> getData() {
		return data;
	}

	public void setData(Map<String, Object> data) {
		this.data = data;
	}
}

