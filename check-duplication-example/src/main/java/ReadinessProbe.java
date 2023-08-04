import java.time.LocalDateTime;
import java.time.ZoneId;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Readiness;

@Readiness
public class ReadinessProbe implements HealthCheck {

    @Override
    public HealthCheckResponse call() {
        return HealthCheckResponse.up(String.format("Readiness probe hello (%s)", LocalDateTime.now(ZoneId.systemDefault())));
    }
}
