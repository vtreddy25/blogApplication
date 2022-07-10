package com.vtr.blog.payloads;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class PostPageResponse {

	private List<PostDto> content;
	private int pageNumbe;
	private int pageSize;
	private long totalElements;
	private int totalPages;
	private boolean lastPage;
}
