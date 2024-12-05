package dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;   //cherez @ ishem ToString ot Lombok

@ToString              // tak stroim getteri setteri i ats..
@Getter
@Setter
@Builder

public class UserDtoLombok {
 private String name;
 private String lastName;
 private String email;
 private String password;
}
