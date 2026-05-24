package com.travel.backend.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

@Service
public class ContentService {

	private final ObjectMapper objectMapper;

	private static final Map<String, String> SECTION_TO_RESOURCE = Map.ofEntries(
		Map.entry("header", "content/Header.json"),
		Map.entry("rating", "content/Rating.json"),
		Map.entry("popularDestination", "content/PopularDestination.json"),
		Map.entry("destination", "content/Destination.json"),
		Map.entry("chooseUs", "content/ChooseUs.json"),
		Map.entry("clientReview", "content/ClientReview.json"),
		Map.entry("contactUs", "content/ContactUs.json"),
		Map.entry("portfolio", "content/Portfolio.json"),
		Map.entry("phoneNoValidation", "content/PhoneNoValidation.json"),
		Map.entry("footer", "content/Footer.json"),
		Map.entry("labelData", "content/LabelData.json"),
		Map.entry("placeHolderLabel", "content/PlaceHolderLabel.json"),
		Map.entry("errorLabel", "content/ErrorLabel.json")
	);

	public ContentService(ObjectMapper objectMapper) {
		this.objectMapper = objectMapper;
	}

	public Map<String, Object> getSection(String sectionKey) {
		String resourcePath = SECTION_TO_RESOURCE.get(sectionKey);
		if (resourcePath == null) {
			return null;
		}
		return readJsonResource(resourcePath);
	}

	public Map<String, Object> getAllContent() {
		Map<String, Object> merged = new LinkedHashMap<>();
		for (String resourcePath : SECTION_TO_RESOURCE.values()) {
			Map<String, Object> section = readJsonResource(resourcePath);
			if (section != null) {
				merged.putAll(section);
			}
		}
		return merged;
	}

	public Map<String, String> getAvailableSections() {
		return new LinkedHashMap<>(SECTION_TO_RESOURCE);
	}

	private Map<String, Object> readJsonResource(String resourcePath) {
		try (InputStream is = new ClassPathResource(resourcePath).getInputStream()) {
			return objectMapper.readValue(is, new TypeReference<Map<String, Object>>() {});
		} catch (IOException e) {
			throw new IllegalStateException("Failed to read resource: " + resourcePath, e);
		}
	}
}
