package org.erpmicroservices.e_commerce.endpoint.rest.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
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
public class UserLogin extends AbstractPersistable<UUID> {
	@NotBlank
	@NotNull
	private String userId;

	@NotBlank
	@NotNull
	private String password;

	@NotNull
	private UUID partyId;

	@OneToMany
	@JoinColumn(name = "user_login_id")
	@OrderBy(value = "activeFrom")
	private List<LoginAccountHistory> loginAccountHistory = new ArrayList<>();

	@ManyToOne
	@NotNull
	private WebAddress webAddress;

	@OneToMany
	@JoinColumn(name = "user_login_id")
	@OrderBy(value = "type")
	private List<WebUserPreference> preferences = new ArrayList<>();

	@OneToMany(mappedBy = "userLogin")
	private List<ServerHit> serverHits = new ArrayList<>();
}
