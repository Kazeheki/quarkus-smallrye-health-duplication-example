import java.time.LocalDateTime;
import java.time.ZoneId;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Liveness;

@Liveness
public class LivenessProbe implements HealthCheck {
    @Override
    public HealthCheckResponse call() {
        return HealthCheckResponse.up(String.format("Liveness probe hello (%s)", LocalDateTime.now(ZoneId.systemDefault())));
    }
}
