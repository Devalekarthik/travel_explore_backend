package com.travel.backend.controller;

import com.travel.backend.api.ApiResponse;
import com.travel.backend.service.ContentService;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
@RequestMapping("/api/content")
public class ContentController {

	private final ContentService contentService;

	public ContentController(ContentService contentService) {
		this.contentService = contentService;
	}

	@GetMapping
	public ApiResponse<Map<String, Object>> getAll() {
		return ApiResponse.ok("Content loaded", contentService.getAllContent());
	}

	@GetMapping("/sections")
	public ApiResponse<Map<String, String>> sections() {
		return ApiResponse.ok("Sections loaded", contentService.getAvailableSections());
	}

	@GetMapping("/{sectionKey}")
	public ApiResponse<Map<String, Object>> getSection(@PathVariable String sectionKey) {
		Map<String, Object> section = contentService.getSection(sectionKey);
		if (section == null) {
			throw new ResponseStatusException(NOT_FOUND, "Content section not found: " + sectionKey);
		}
		return ApiResponse.ok("Section loaded", section);
	}
}
