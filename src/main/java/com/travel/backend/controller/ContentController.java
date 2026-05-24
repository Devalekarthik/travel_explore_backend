package com.travel.backend.controller;

import com.travel.backend.service.ContentService;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/content")
public class ContentController {

	private final ContentService contentService;

	public ContentController(ContentService contentService) {
		this.contentService = contentService;
	}

	@GetMapping
	public Map<String, Object> getAll() {
		return contentService.getAllContent();
	}

	@GetMapping("/sections")
	public Map<String, String> sections() {
		return contentService.getAvailableSections();
	}

	@GetMapping("/{sectionKey}")
	public ResponseEntity<Map<String, Object>> getSection(@PathVariable String sectionKey) {
		Map<String, Object> section = contentService.getSection(sectionKey);
		if (section == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.ok(section);
	}
}
