package dacn.demo.DTO.Request;

import lombok.Data;
import lombok.Getter;

import java.io.Serializable;

@Data
@Getter
public class ConvertToken implements Serializable {
    private String data;

    public String getData() {
        return data;
    }
}
