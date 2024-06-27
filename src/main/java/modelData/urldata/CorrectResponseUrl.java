package modelData.urldata;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CorrectResponseUrl {
    @JsonProperty("result_url")
    private String resultUrl;
}
