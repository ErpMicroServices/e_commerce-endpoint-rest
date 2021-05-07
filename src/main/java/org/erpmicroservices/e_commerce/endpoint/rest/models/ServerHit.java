package org.erpmicroservices.e_commerce.endpoint.rest.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.time.ZonedDateTime;
import java.util.UUID;

@Entity
@Data
@ToString
@EqualsAndHashCode
public class ServerHit extends AbstractPersistable<UUID> {

	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssZ")
	@NotNull
	private ZonedDateTime dateTime;

	@ManyToOne
	@NotNull
	private WebContent webContent;
}
