package org.erpmicroservices.e_commerce.endpoint.rest.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@ToString
@EqualsAndHashCode
public class Subscription extends AbstractPersistable<UUID> {

	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@JsonFormat(pattern = "yyyy-MM-dd")
	@NotNull
	private LocalDate startDate;

	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@JsonFormat(pattern = "yyyy-MM-dd")
	@NotNull
	private LocalDate endDate;

	@OneToMany
	@JoinColumn(name = "subscription_id")
	private List<OrderItem> orderItems = new ArrayList<>();

	@NotNull
	@ManyToOne
	private SubscriptionType type;

	private UUID productId;
	private UUID productCategoryId;

	@ManyToOne
	private NeedType needType;

	private UUID partyRoleId;
	private UUID contactMechanismId;
	private UUID communicationEventId;

	@ManyToOne
	private PartyNeed partyNeed;

	@ManyToMany(mappedBy = "subscriptions")
	private List<SubscriptionActivity> subscriptionActivities = new ArrayList<>();


}
