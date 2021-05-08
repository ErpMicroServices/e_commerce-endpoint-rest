package org.erpmicroservices.e_commerce.endpoint.rest.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Entity
@Data
@ToString
@EqualsAndHashCode
public class UserAgent extends AbstractPersistable<UUID> {
	@NotNull
	@ManyToOne
	@JoinColumn(name = "platform_type_id")
	private PlatformType platformType;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "browser_type_id")
	private BrowserType browserType;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "protocol_type_id")
	private ProtocolType protocolType;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "user_agent_method_type_id")
	private UserAgentMethodType userAgentMethodType;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "type_id")
	private UserAgentType type;

}
