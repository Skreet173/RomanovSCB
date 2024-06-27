package modelData.usersData;

import lombok.Data;

@Data
public class Location{
	private String country;
	private String city;
	private Street street;
	private Timezone timezone;
	private int postcode;
	private Coordinates coordinates;
	private String state;
}
