package org.erpmicroservices.e_commerce.endpoint.rest.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Data
@ToString
@EqualsAndHashCode
public class PartyNeed extends AbstractPersistable<UUID> {
	@NotBlank
	@NotNull
	private String description;

	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@JsonFormat(pattern = "yyyy-MM-dd")
	@NotNull
	private LocalDate dateIdentified;

	@NotNull
	private UUID partyRoleId;

	@NotNull
	private UUID productCategoryId;

	@NotNull
	private UUID product;

	@NotNull
	@ManyToOne
	private NeedType type;

	@ManyToOne
	private ServerHit serverHit;

	private UUID communicationEventId;
}
