package org.erpmicroservices.e_commerce.endpoint.rest.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@ToString
@EqualsAndHashCode
public class WebContent extends AbstractPersistable<UUID> {
	@NotBlank
	@NotNull
	private String description;
	private String fileLocation;
	@ManyToOne
	@NotNull
	private WebContentStatusType status;
	@ManyToOne
	@NotNull
	private WebAddress webAddress;
	@OneToMany
	@JoinColumn(name = "associate_for_web_content_id")
	private List<WebContentAssociation> associateFor = new ArrayList<>();
	@OneToMany
	@JoinColumn(name = "associate_of_web_content_id")
	private List<WebContentAssociation> associateOf = new ArrayList<>();
}