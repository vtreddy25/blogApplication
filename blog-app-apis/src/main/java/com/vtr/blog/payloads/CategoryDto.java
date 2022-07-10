package com.vtr.blog.payloads;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CategoryDto {

	private Integer categoryId;
	@NotEmpty
	@Size(min=4)
	private String categoryTitle;
	@NotEmpty
	@Size(min=10)
	private String categoryDescription;
}
