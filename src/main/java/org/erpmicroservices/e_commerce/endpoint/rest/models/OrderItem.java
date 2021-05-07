package org.erpmicroservices.e_commerce.endpoint.rest.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Entity
@Data
@ToString
@EqualsAndHashCode
public class OrderItem extends AbstractPersistable<UUID> {

	@NotNull
	private UUID orderItemId;

}
