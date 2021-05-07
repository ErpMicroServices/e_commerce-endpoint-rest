package org.erpmicroservices.e_commerce.endpoint.rest.models;

import com.vividsolutions.jts.geom.Point;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Entity
@Data
@ToString
@EqualsAndHashCode
public class WebContentAssociation extends AbstractPersistable<UUID> {
	@Column(name = "upper_left_coordinate", columnDefinition = "POINT")
	private Point upperLeftCoordinate;
	@ManyToOne
	@NotNull
	private FunctionType functionType;

}
