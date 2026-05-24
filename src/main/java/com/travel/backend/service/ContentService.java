package com.travel.backend.service;

import com.travel.backend.content.ContentDocument;
import com.travel.backend.content.ContentRepository;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class ContentService {

	private final ContentRepository contentRepository;

	public ContentService(ContentRepository contentRepository) {
		this.contentRepository = contentRepository;
	}

	public Map<String, Object> getSection(String sectionKey) {
		Optional<ContentDocument> doc = contentRepository.findById(sectionKey);
		return doc.map(ContentDocument::getData).orElse(null);
	}

	public Map<String, Object> getAllContent() {
		Map<String, Object> merged = new LinkedHashMap<>();
		for (ContentDocument doc : contentRepository.findAll()) {
			if (doc.getData() != null) {
				merged.putAll(doc.getData());
			}
		}
		return merged;
	}

	public Map<String, String> getAvailableSections() {
		Map<String, String> sections = new LinkedHashMap<>();
		for (ContentDocument doc : contentRepository.findAll()) {
			sections.put(doc.getId(), "");
		}
		return sections;
	}
}
