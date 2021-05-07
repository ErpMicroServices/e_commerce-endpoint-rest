package org.erpmicroservices.e_commerce.endpoint.rest.repositories;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.erpmicroservices.e_commerce.endpoint.rest.models.*;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@ToString
@EqualsAndHashCode
public class WebObject extends AbstractPersistable<UUID> {
	@NotBlank
	@NotNull
	private String name;

	private String description;

	@NotBlank
	@NotNull
	private String fileLocation;

	@ManyToOne
	private WebObjectType type;

	@OneToMany
	@JoinColumn(name = "web_object_id")
	private List<FeatureObject> featureObjects = new ArrayList<>();

	@OneToMany
	@JoinColumn(name = "web_object_id")
	private List<ObjectUsage> objectUsages = new ArrayList<>();

	@OneToMany
	@JoinTable(name = "object_purpose")
	private List<PurposeType> types;

	@OneToMany
	@JoinColumn(name = "web_object_id")
	private List<ProductObject> products;

}
