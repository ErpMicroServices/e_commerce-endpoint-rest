package org.erpmicroservices.e_commerce.endpoint.rest.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@ToString
@EqualsAndHashCode
public class SubscriptionActivity extends AbstractPersistable<UUID> {

	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@JsonFormat(pattern = "yyyy-MM-dd")
	@NotNull
	private LocalDate dateSent;

	@NotBlank
	@NotNull
	private String comment;

	@ManyToMany
	@JoinTable(
			name = "subscription_fulfillment_piece",
			joinColumns = @JoinColumn(name = "subscription_activities_id"),
			inverseJoinColumns = @JoinColumn(name = "subscription_id"))
	private List<Subscription> subscriptions = new ArrayList<>();

}
