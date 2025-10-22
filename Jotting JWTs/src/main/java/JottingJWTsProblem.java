import com.fasterxml.jackson.annotation.JsonProperty;

public class JottingJWTsProblem {

    @JsonProperty("jwt_secret")
    private String jwtSecret;

    public String getJwtSecret() {
        return jwtSecret;
    }

    @Override
    public String toString() {
        return "JottingJWTsProblem{" +
                "jwtSecret='" + jwtSecret + '\'' +
                '}';
    }

    public void setJwtSecret(String jwtSecret) {
        this.jwtSecret = jwtSecret;
    }
}
